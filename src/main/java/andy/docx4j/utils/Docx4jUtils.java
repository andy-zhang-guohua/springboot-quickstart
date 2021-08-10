package andy.docx4j.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.docx4j.XmlUtils;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.*;

import javax.xml.bind.JAXBElement;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Docx4jUtils {
    /**
     * 加载指定路径上的 docx 文件
     *
     * @param docxFilePath
     * @return
     */
    public static WordprocessingMLPackage load(String docxFilePath) {
        try {
            InputStream templateInputStream = new FileInputStream(docxFilePath);
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(templateInputStream);
            templateInputStream.close();
            return wordMLPackage;
        } catch (Exception e) {
            throw new RuntimeException("加载文件异常 : " + docxFilePath, e);
        }
    }

    /**
     * 将 wordprocessingMLPackage 内容保存为 docx 文件 targetFilePath
     *
     * @param wordprocessingMLPackage
     * @param targetFilePath          目标 docx 文件
     */
    public static void save(WordprocessingMLPackage wordprocessingMLPackage, String targetFilePath) {
        try {
            OutputStream outputStream = new FileOutputStream(new File(targetFilePath));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            wordprocessingMLPackage.save(byteArrayOutputStream);
            byteArrayOutputStream.writeTo(outputStream);

            outputStream.close();
            byteArrayOutputStream.close();
        } catch (Exception e) {
            throw new RuntimeException("保存文件到[" + targetFilePath + "]异常", e);
        }
    }


    /**
     * 增加分页符
     *
     * @param documentPart
     * @param factory
     */
    public static void addPageBreak(MainDocumentPart documentPart, ObjectFactory factory) {
        P paragraph = newP_R_PageBreak(factory);

        try {
            documentPart.getContents().getBody().getContent().add(paragraph);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static P newP_R_PageBreak(ObjectFactory factory) {
        Br br = factory.createBr();
        br.setType(STBrType.PAGE);

        R r = factory.createR();
        r.getContent().add(br);

        P p = factory.createP();
        p.getContent().add(r);
        return p;
    }

    /**
     * 创建一个空的 P, 其 PPr 属性包含了一个 SectPr ,
     * <p>
     * 该 SectPr P 用于新建一个新的 Section
     * <p>
     * Section 类型 :
     * * continuous - Begins the section on the next paragraph. Certain page-level section properties cannot be specified, as they are inherited from the previous section. If a footnote occurs of the same page as a section of this kind, the new section begins on the following page.
     * * evenPage - The section begins on the next even-numbered page, leaving the next odd page blank if necessary.
     * * nextColumn - The section begins on the following column on the page.
     * * nextPage - The section begins on the following page.
     * * oddPage - The section begins on the next odd-numbered page, leaving the next even page blank if necessary.
     *
     * @param objectFactory
     * @param sectionType
     * @return
     */
    public static P newP_PPr_SectPr(ObjectFactory objectFactory, String sectionType) {
        SectPr.Type sectPrType = objectFactory.createSectPrType();
        sectPrType.setVal(sectionType);

        // create new section and add it to the document
        SectPr sectPr = objectFactory.createSectPr(); // create new section
        sectPr.setType(sectPrType);

        PPr ppr = objectFactory.createPPr();
        ppr.setSectPr(sectPr);

        P p = objectFactory.createP(); // create new paragraph
        p.setPPr(ppr);

        return p;
    }

    /**
     * 插入一个 P 元素到指定的索引
     *
     * @param mainDocumentPart
     * @param index
     * @param p
     */
    public static void insert_P(MainDocumentPart mainDocumentPart, int index, P p) {
        if (index < 0 || p == null) return;

        List<Object> list = mainDocumentPart.getContent();
        if (index >= list.size()) index = list.size();

        list.add(index, p);
    }

    /**
     * 为段落增加一个变量
     * <p>
     * http://webapp.docx4java.org/OnlineDemo/ecma376/WordML/fldChar.html
     * http://webapp.docx4java.org/OnlineDemo/ecma376/WordML/Fields%20&%20Hyperlinks.html
     *
     * @param factory
     * @param paragraph
     * @param varName   变量名称
     * @pram initialValue 变量初始值
     */
    public static void addVarToParagraph(ObjectFactory factory, ContentAccessor paragraph, String varName, String initialValue) {
        {// begin
            // http://webapp.docx4java.org/OnlineDemo/ecma376/WordML/fldChar.html
            FldChar fldChar = factory.createFldChar();
            // http://webapp.docx4java.org/OnlineDemo/ecma376/WordML/ST_FldCharType.html
            fldChar.setFldCharType(STFldCharType.BEGIN);
            newR_FldChar(factory, paragraph, fldChar);
        }

        { // 变量名称
            Text t = factory.createText();
            t.setValue(varName); // PAGE \* Arabic \* MERGEFORMAT
            newR_InstrText(factory, paragraph, t);
        }

        {
            FldChar fldChar = factory.createFldChar();
            fldChar.setFldCharType(STFldCharType.SEPARATE);
            newR_FldChar(factory, paragraph, fldChar);
        }

        { // 初始值
            Text t = factory.createText();
            t.setValue(initialValue); //设置初始值
            newR_Text(factory, paragraph, t);
        }

        {// end
            FldChar fldChar = factory.createFldChar();
            fldChar.setFldCharType(STFldCharType.END);
            newR_FldChar(factory, paragraph, fldChar);
        }


    }

    public static void newR_InstrText(ObjectFactory factory, ContentAccessor paragraph, Text t) {
        R r = factory.createR();
        paragraph.getContent().add(r);
        JAXBElement<Text> jaxbElement = factory.createRInstrText(t);
        r.getContent().add(jaxbElement);
    }

    public static void newR_Text(ObjectFactory factory, ContentAccessor paragraph, Text t) {
        R r = factory.createR();
        paragraph.getContent().add(r);
        r.getContent().add(t);
    }

    public static void newR_FldChar(ObjectFactory factory, ContentAccessor paragraph, FldChar fldChar) {
        R r = factory.createR();
        paragraph.getContent().add(r);
        r.getContent().add(fldChar);
    }

    /**
     * 使用 xpath 定位特定元素
     *
     * @param documentPart
     * @param xpath
     * @return
     */
    public static List<Object> locateElementsByXPath(MainDocumentPart documentPart, String xpath) {
        try {
            List<Object> list = documentPart.getJAXBNodesViaXPath(xpath, false);
            if (list == null || list.isEmpty()) return list;

            List<Object> elements = new ArrayList<>();
            list.forEach(o -> {
                Object e = XmlUtils.unwrap(o);
                elements.add(e);
            });

            return elements;
        } catch (Exception e) {
            throw new RuntimeException("xpath定位对象失败:" + xpath, e);
        }
    }

    /**
     * 在主文档 documentPart getContent() 孩子元素中查找第一个段落P,该段落P包含一个 Text 元素，并且其内容包含指定文字
     *
     * @param documentPart
     * @param textToSearch
     * @return -1 表示没有找到
     */
    public static int getIndexOfFirstMainDocumentChildP_R_Text(MainDocumentPart documentPart, String textToSearch) {
        if (documentPart == null) return -1;
        if (textToSearch == null) return -1;

        List<Object> children = documentPart.getContent();
        for (int ci = 0; ci < children.size(); ci++) {
            Object child = children.get(ci);

            if (isP_R_Text(child, textToSearch)) return ci;
        }

        return -1;
    }

    /**
     * 检测一个对象是否是一个P元素，该元素包含了一个 R.Text , 其文本包含内容 textToSearch
     *
     * @param object
     * @param textToSearch
     * @return
     */
    public static boolean isP_R_Text(Object object, String textToSearch) {
        if (object == null) return false;
        if (textToSearch == null) return false;

        if (!(object instanceof P)) return false;

        P p = ((P) object);
        List<Object> children = p.getContent();

        for (int ci = 0; ci < children.size(); ci++) {
            Object child = children.get(ci);

            if (isR_Text(child, textToSearch)) return true;
        }

        return false;
    }

    /**
     * 检测一个对象是否是一个R元素，该元素包含了一个 Text , 其文本包含内容 textToSearch
     *
     * @param object
     * @param textToSearch
     * @return
     */
    public static boolean isR_Text(Object object, String textToSearch) {
        if (object == null) return false;
        if (textToSearch == null) return false;

        if (object instanceof JAXBElement) {
            object = XmlUtils.unwrap(object);
        }

        if (!(object instanceof R)) return false;

        R r = ((R) object);
        List<Object> children = r.getContent();

        for (int ci = 0; ci < children.size(); ci++) {
            Object child = children.get(ci);

            if (isText(child, textToSearch)) return true;
        }

        return false;
    }

    /**
     * 检测一个对象是否是一个Text元素，其文本包含内容 textToSearch
     *
     * @param object
     * @param textToSearch
     * @return
     */
    public static boolean isText(Object object, String textToSearch) {
        if (object == null) return false;
        if (textToSearch == null) return false;

        if (!(object instanceof Text)) return false;

        Text t = ((Text) object);
        String value = t.getValue();

        boolean match = StringUtils.contains(value, textToSearch);
        return match;
    }

    /**
     * 清空 xpath 定位到到的 Text 组件的内容
     *
     * @param wordMLPackage
     * @param xpath
     */
    public static void clearTextValue(WordprocessingMLPackage wordMLPackage, String xpath) {
        MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();

        List<Object> targets = Docx4jUtils.locateElementsByXPath(documentPart, xpath);

        for (Object target : targets) {
            if (!(target instanceof Text)) continue;

            Text t = (Text) target;
            t.setValue("");
        }
    }
}
