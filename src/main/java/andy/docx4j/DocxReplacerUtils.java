package andy.docx4j;

import org.apache.commons.lang3.StringUtils;
import org.docx4j.TraversalUtil;
import org.docx4j.XmlUtils;
import org.docx4j.finders.ClassFinder;
import org.docx4j.model.datastorage.migration.VariablePrepare;
import org.docx4j.model.structure.DocumentModel;
import org.docx4j.model.structure.HeaderFooterPolicy;
import org.docx4j.model.structure.SectionWrapper;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.FooterPart;
import org.docx4j.openpackaging.parts.WordprocessingML.HeaderPart;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.ContentAccessor;
import org.docx4j.wml.Tbl;
import org.docx4j.wml.Text;
import org.docx4j.wml.Tr;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocxReplacerUtils {
    /**
     * 基于模板 sourceFile , 构造新的 docx 文件并输出到 targetFile, 替换其中的 占位符 和表格
     * 替换的位置包括 :
     * 1. 文档主体部分中的占位符及其表格
     * 2. 页眉页脚内容中的占位符
     *
     * @param sourceFile
     * @param targetFile
     * @param data
     * @param tables
     */
    public static void replaceData(String sourceFile, String targetFile,
                                   Map<String, String> data,
                                   Map<Integer, List<Map<String, String>>> tables) {
        synchronized (sourceFile) {
            // 加载模板文件到内存对象 wordMLPackage
            WordprocessingMLPackage wordMLPackage = Docx4jUtils.load(sourceFile);

            // 在加载的模板中替换占位符 : 主体文档，页眉，页脚 中的占位符; 表格中的占位符；
            _replaceData(wordMLPackage, data, tables);

            // 保存替换后的 wordMLPackage
            Docx4jUtils.save(wordMLPackage, targetFile);
        }
    }

    /**
     * 在加载的模板中替换占位符 : 主体文档，页眉，页脚 中的占位符; 表格中的占位符；
     *
     * @param wordMLPackage
     * @param data
     * @param tables
     */
    private static void _replaceData(WordprocessingMLPackage wordMLPackage,
                                     Map<String, String> data,
                                     Map<Integer, List<Map<String, String>>> tables) {

        // 1. 在主体内查找表格，尝试替换表格中的占位符
        _replacePlaceholdersInTablesOfMainDocument(wordMLPackage, tables);

        // 2. 在主体内替换一般占位符 (注意一定要放在 主体内表格占位符替换之后，否则会影响表格内的占位符)
        _replaceCommonPlaceholdersInMainDocument(wordMLPackage, data);

        // 3. 替换页眉页脚中的一般占位符
        _replaceCommonPlaceholdersInHeaderFooters(wordMLPackage, data);
    }

    private static void _replaceCommonPlaceholdersInHeaderFooters(WordprocessingMLPackage wordMLPackage, Map<String, String> data) {
        DocumentModel documentModel = wordMLPackage.getDocumentModel();
        List<SectionWrapper> sections = documentModel.getSections();
        if (sections == null || sections.isEmpty()) return;


        for (int i = 0; i < sections.size(); i++) {
            HeaderFooterPolicy headerFooterPolicy = sections.get(i).getHeaderFooterPolicy();

            HeaderPart firstHeader = headerFooterPolicy.getFirstHeader();
            _resolvePlaceholdersInScope(firstHeader, data);


            FooterPart firstFooter = headerFooterPolicy.getFirstFooter();
            _resolvePlaceholdersInScope(firstFooter, data);

            HeaderPart defaultHeader = headerFooterPolicy.getDefaultHeader();
            _resolvePlaceholdersInScope(defaultHeader, data);

            FooterPart defaultFooter = headerFooterPolicy.getDefaultFooter();
            _resolvePlaceholdersInScope(defaultFooter, data);

            HeaderPart evenHeader = headerFooterPolicy.getEvenHeader();
            _resolvePlaceholdersInScope(evenHeader, data);

            FooterPart evenFooter = headerFooterPolicy.getEvenFooter();
            _resolvePlaceholdersInScope(evenFooter, data);
        }
    }

    private static void _replaceCommonPlaceholdersInMainDocument(WordprocessingMLPackage wordMLPackage, Map<String, String> data) {
        if (CollectionUtils.isEmpty(data)) return; // 没有指定任何需要替换的数据

        try {
            MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();
            VariablePrepare.prepare(wordMLPackage);
            documentPart.variableReplace(data);
        } catch (Exception e) {
            throw new RuntimeException("docx文档主体占位符替换异常", e);
        }
    }

    private static void _replacePlaceholdersInTablesOfMainDocument(WordprocessingMLPackage wordMLPackage, Map<Integer, List<Map<String, String>>> tablesData) {
        if (CollectionUtils.isEmpty(tablesData)) return; // 没有指定任何需要替换的表格数据

        MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();

        // 在主文档中查找所有的表格 (对应目标类 Tbl)
        List<Object> tablesInDocument = _locateElements(documentPart, Tbl.class); // 在文档中找到的表格
        if (CollectionUtils.isEmpty(tablesInDocument)) return; // 没有找到任何表格

        // 遍历处理每个表格
        for (int tableIndex = 0; tableIndex < tablesInDocument.size(); tableIndex++) {
            List<Map<String, String>> tableData = tablesData.get(tableIndex);
            if (CollectionUtils.isEmpty(tableData)) continue;// 当前表格不需要替换

            Tbl tableInDocument = (Tbl) tablesInDocument.get(tableIndex);
            _replaceTableData(tableInDocument, tableData);
        }
    }

    /**
     * 将一个模板表格进行数据替换
     * 1. 假设 模板表格包含两行， 第一行(索引0)是头行，第二行是模板行
     * 2. 替换方法 : 每条目标数据根据模板行构造一个新行追加到表尾，数据处理完成后删除表格中的模板行
     *
     * @param tbl
     * @param tableData
     */
    private static void _replaceTableData(Tbl tbl, List<Map<String, String>> tableData) {
        List<Object> children = tbl.getContent();
        if (children == null || children.size() < 2) return; // 空表格或者只有头行(索引:0)，没有头行(索引:0)下面的行号为1的参数模板行

        Tr templateTr = (Tr) (children.get(1));// 头行(索引:0)下面的行号为1的行是参数模板行

        for (Map<String, String> trData : tableData) { // trData <placeholderName, placeholderValue>
            Tr workingTr = XmlUtils.deepCopy(templateTr);
            //_replaceTrData(workingTr, trData);
            _resolvePlaceholdersInScope(workingTr, trData);
            children.add(workingTr); // 增加数据行
        }

        children.remove(templateTr);// 去掉参数模板行
    }


    /**
     * 获取一个 Tr 中各个列中的 Text 元素
     * 1. 假定 : 该 Tr 中的每个列中都存在并且只存在一个 Text 元素
     *
     * @param tr
     * @return
     */
    private static List<Text> _getTrColumnTexts(Tr tr) {
        List<Text> listColumnText = new ArrayList<>();

        List<Object> listTextForColumnNames = _locateElements(tr, Text.class);
        for (int columnIndex = 0; columnIndex < listTextForColumnNames.size(); columnIndex++) {
            Text text = (Text) listTextForColumnNames.get(columnIndex);
            listColumnText.add(text);
        }

        return listColumnText;
    }

    /**
     * 替换指定 tr 的内容
     * tr 的各列都只包含一个 Text, 使用该 Text 的值作为 key 从 targetTrData 中获取相应的 value,
     * 然后更新为 Text 新的值
     *
     * @param tr
     * @param targetTrData
     */
    private static void _replaceTrData(Tr tr, Map<String, String> targetTrData) {
        List<Text> listColumnTextOfWorkingTr = _getTrColumnTexts(tr); // 获取该行内各列的 Text 元素

        for (Text columnTextOfWorkingTr : listColumnTextOfWorkingTr) {
            String placeholderName = columnTextOfWorkingTr.getValue();
            String targetValue = targetTrData.containsKey(placeholderName) ? targetTrData.get(placeholderName) : "";
            columnTextOfWorkingTr.setValue(targetValue);
        }
    }

    /**
     * 假定 placeholderCandidate 是一个格式为 ${ xxx } 的占位符，
     * 尝试从中分析出 xxx 并返回 xxx。
     * 如果格式不匹配，则返回 null
     *
     * @param placeholderCandidate
     * @return null 表示这不是一个占位符
     */
    private static String _parsePlaceholderName(String placeholderCandidate) {
        Pattern pattern = Pattern.compile("\\$\\{(.*?)\\}");
        Matcher matcher = pattern.matcher(placeholderCandidate);
        boolean match = matcher.find();
        if (!match) return null;

        String name = matcher.group(1);
        return StringUtils.isBlank(name) ? null : name.trim();
    }

    /**
     * 将一个 Text 中的占位符替换成目标值
     *
     * @param text
     * @param data
     */
    private static void _resolvePlaceholderInText(Text text, Map<String, String> data) {
        String placeholder = text.getValue();

        String name = _parsePlaceholderName(placeholder);
        if (name == null) return;

        String value = data.get(name);

        text.setValue(value);
    }

    /**
     * 在表头中执行模板替换
     *
     * @param scope
     * @param data
     */
    private static void _resolvePlaceholdersInScope(ContentAccessor scope, Map<String, String> data) {
        if (scope == null) return; // 退化情况

        if (CollectionUtils.isEmpty(data)) return; // 退化情况

        List<Object> listText = _locateElements(scope, Text.class);
        listText.forEach(element -> {
            Text text = (Text) element;
            _resolvePlaceholderInText(text, data);
        });
    }

    /**
     * 模板替换 （dox4j开源）
     *
     * @param sourceFile 源文件
     * @param targetFile 目标文件
     * @param data       替换键值对
     * @throws Exception
     */
    public static void replaceData(String sourceFile, String targetFile, Map<String, String> data) {
        replaceData(sourceFile, targetFile, data, null);
    }

    /**
     * 从指定范围内定位类型为 toSearch的子孙元素
     *
     * @param scope
     * @param toSearch
     * @return
     */
    private static List<Object> _locateElements(ContentAccessor scope, Class<?> toSearch) {
        ClassFinder finder = new ClassFinder(toSearch);
        new TraversalUtil(scope.getContent(), finder);

        return finder.results;
    }


}
