package andy.docx4j.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.docx4j.XmlUtils;
import org.docx4j.model.structure.DocumentModel;
import org.docx4j.model.structure.HeaderFooterPolicy;
import org.docx4j.model.structure.PageDimensions;
import org.docx4j.model.structure.SectionWrapper;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.FooterPart;
import org.docx4j.openpackaging.parts.WordprocessingML.HeaderPart;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.*;

import javax.xml.bind.JAXBElement;
import java.util.List;
import java.util.StringJoiner;

@Slf4j
public class DocxDumpUtils {
    /**
     * 浏览 docx 文件的元素
     * 1. 各个 Section 的情况 : 页面尺寸,页眉/页脚 内容
     * 2. 主文档中所有的元素
     */
    public static void dumpElements(WordprocessingMLPackage wordMLPackage) {
        ///////////////////////////////////// 输出各个Section的信息 /////////////////////////////////////////////
        // 将整个 docx 理解成一个 DocumentModel
        DocumentModel documentModel = wordMLPackage.getDocumentModel();
        List<SectionWrapper> sections = documentModel.getSections();
        log.info("DocumentModel 包含 Section 数量 : {}", sections.size());

        final int SECTION_TOTAL = sections.size();
        final int INDEX_OF_BODY_SECTION = SECTION_TOTAL - 1;// 属于 body 的 section 总是最后一个 Section
        for (int i = 0; i < SECTION_TOTAL; i++) {
            SectionWrapper section = sections.get(i);

            final String bodySection = i == INDEX_OF_BODY_SECTION ? "- BODY" : "";
            final String title = "Section [" + (i + 1) + "]" + bodySection;
            dumpSection(1, title, section);
        }

        ///////////////////////////////////// 输出主文档各个元素的信息 /////////////////////////////////////////////
        // 只输出docx文件主文档 word/document.xml 中的各级元素， 不包含页眉页脚，页眉页脚信息需要通过访问 Section 方式访问
        MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();

        List<Object> objects = documentPart.getContent();
        log.info("MainDocument 内容 : {} 个对象 => {}", objects.size(), objects);
        dumpChildren(0, documentPart);
    }

    private static void dumpChildren(int level, ContentAccessor contentContainer) {
        List<Object> objects = contentContainer.getContent();
        for (int i = 0; i < objects.size(); i++) {
            String title = String.format("元素[%02d]", i + 1);
            dumpContentElement(level + 1, title, objects.get(i));
        }
    }

    private static void dumpContentElement(int level, String title, Object element) {
        String padding = prefixPadding(level);
        log.info("{}{}级{}{}", padding, level, title, element.getClass().getSimpleName());


        if (element instanceof P) {
            dumpP(level, title, (P) element);
            return;
        }

        if (element instanceof ContentAccessor) {
            dumpChildren(level, (ContentAccessor) element);
            return;
        }

        if (element instanceof JAXBElement) {
            dumpJAXBElement(level, title, (JAXBElement) element);
            return;
        }
    }

    private static void dumpP(int level, String title, P element) {
        String padding = prefixPadding(level);

        int childrenCount = element.getContent().size();
        if (childrenCount == 0) {
            PPr ppr = element.getPPr();
            SectPr sectPr = ppr.getSectPr();
            if (sectPr != null) {
                log.info("{} == Section 定义节点 {}", padding, sectPr);
            }

            return;
        }

        dumpChildren(level, element);
    }

    private static void dumpJAXBElement(int level, String title, JAXBElement element) {
        Object value = XmlUtils.unwrap(element);

        level = level + 1;
        String padding = prefixPadding(level);
        if (value == null) {
            log.info("{}{}JAXBElement : {}", padding, title, element);
            return;
        }

        if (value instanceof Tbl) {
            dumpTbl(level, title, (Tbl) value);
            return;
        }

        if (value instanceof Text) {
            dumpText(level, (Text) value);
            return;
        }

        String valueClass = value.getClass().getSimpleName();
        log.info("{}{}级{}", padding, level, valueClass);

        if (value instanceof ContentAccessor) {
            dumpChildren(level, (ContentAccessor) value);
            return;
        }
    }

    private static void dumpText(int level, Text text) {
        String padding = prefixPadding(level);
        log.info("{}{}级元素Text : {}", padding, level, text.getValue());
    }

    private static void dumpTbl(int level, String title, Tbl tbl) {
        String padding = prefixPadding(level);
        log.info("{}Tbl{} : {}", padding, title, tbl);

        TblGrid tblGrid = tbl.getTblGrid();

        String titleTblGrid = "表列信息";
        dumpTblGrid(level + 1, titleTblGrid, tblGrid);

        List<Object> list = tbl.getContent();
        String titleTblContent = "表格内容";
        dumpTblContent(level + 1, titleTblContent, list);
    }

    private static void dumpTblGrid(int level, String title, TblGrid tblGrid) {
        String padding = prefixPadding(level);

        String textTblGrid = toString(tblGrid);
        log.info("{}{} : {}", padding, title, textTblGrid);
    }

    private static void dumpTblContent(int level, String title, List<Object> tblContent) {
        String padding = prefixPadding(level);

        if (tblContent.isEmpty()) {
            log.info("{}{} : {}", padding, title, tblContent);
            return;
        }

        log.info("{}{}", padding, title);
        for (int i = 0; i < tblContent.size(); i++) {
            Object child = tblContent.get(i);
            String childTitle = child.getClass().getSimpleName() + "[" + (i + 1) + "]";
            dumpTblContentElement(level + 1, childTitle, child);
        }
    }

    private static void dumpTblContentElement(int level, String title, Object object) {
        String padding = prefixPadding(level);

        if (object instanceof Tr) {
            dumpTr(level, title, (Tr) object);
        } else {
            log.info("{}{} : {}", padding, title, object);
        }
    }

    private static void dumpTr(int level, String title, Tr tr) {
        String padding = prefixPadding(level);
        log.info("{}{}", padding, title);

        String subTitle = "行内各列内容";
        dumpTrContent(level + 1, subTitle, tr.getContent());
    }

    private static void dumpTrContent(int level, String title, List<Object> trContent) {
        String padding = prefixPadding(level);
        log.info("{}{}", padding, title);

        for (int i = 0; i < trContent.size(); i++) {
            Object child = trContent.get(i);
            String childTitle = child.getClass().getSimpleName() + "[" + (i + 1) + "]";
            dumpTc(level + 1, i + 1, childTitle, child);
        }
    }

    private static void dumpTc(int level, int order, String title, Object object) {
        String padding = prefixPadding(level);

        if (!(object instanceof JAXBElement)) {
            log.info("{}{} : {}", padding, title, object);
            return;
        }

        Object value = ((JAXBElement) object).getValue();
        if (!(value instanceof Tc)) {
            log.info("{}{} : {}", padding, title, value);
            return;
        }

        Tc tc = (Tc) value;
        String newTitle = "Tc[" + order + "]";
        log.info("{}{} : {}", padding, newTitle, tc.getContent());
    }

    private static String toString(TblGrid tblGrid) {
        StringJoiner sj = new StringJoiner(" , ");
        List<TblGridCol> tblGridCols = tblGrid.getGridCol();
        for (int i = 0; i < tblGridCols.size(); i++) {
            TblGridCol col = tblGridCols.get(i);
            sj.add("列[" + (i + 1) + "]宽 : " + col.getW());
        }

        return sj.toString();
    }


    /**
     * 输出一个 Section 的内容
     *
     * @param level   当前 Section 的层级
     * @param title   当前 Section 的输出标题，由调用者设置
     * @param section 要输出的 Section
     */
    private static void dumpSection(int level, String title, SectionWrapper section) {
        String padding = prefixPadding(level);
        log.info("{}{} ====================> ", padding, title);

        // 页面维度信息
        PageDimensions pageDimensions = section.getPageDimensions();

        dumpPageDimensions(level + 1, "页面维度", pageDimensions);

        /// 页眉页脚策略
        HeaderFooterPolicy headerFooterPolicy = section.getHeaderFooterPolicy();
        dumpHeaderFooterPolicy(level + 1, "页眉页脚策略", headerFooterPolicy);
    }


    private static void dumpPageDimensions(int level, String title, PageDimensions pageDimensions) {
        String padding = prefixPadding(level);
        log.info("{}{}", padding, title);

        //// 页面尺寸
        dumpPageSize(level + 1, "页面尺寸", pageDimensions.getPgSz());

        //// 页面边距
        dumpPageMargin(level + 1, "页面边距", pageDimensions.getPgMar());
    }


    private static void dumpPageSize(int level, String title, SectPr.PgSz pageSize) {
        String padding = prefixPadding(level);
        log.info("{}{} : {}", padding, title, toString(pageSize));
    }

    private static void dumpPageMargin(int level, String title, SectPr.PgMar pageMargin) {
        String padding = prefixPadding(level);
        log.info("{}{} : {}", padding, title, toString(pageMargin));
    }

    private static void dumpHeaderFooterPolicy(int level, String title, HeaderFooterPolicy headerFooterPolicy) {
        String padding = prefixPadding(level);
        log.info("{}{}", padding, title);

        HeaderPart firstHeader = headerFooterPolicy.getFirstHeader(); // 首页页眉
        dumpHeaderPart(level + 1, "首页-页眉内容", firstHeader);

        FooterPart firstFooter = headerFooterPolicy.getFirstFooter(); // 首页页脚
        dumpFooterPart(level + 1, "首页-页脚内容", firstFooter);

        HeaderPart defaultHeader = headerFooterPolicy.getDefaultHeader(); // 默认页面页眉
        dumpHeaderPart(level + 1, "默认-页眉内容", defaultHeader);

        FooterPart defaultFooter = headerFooterPolicy.getDefaultFooter(); // 默认页面页脚
        dumpFooterPart(level + 1, "默认-页脚内容", defaultFooter);

        HeaderPart evenHeader = headerFooterPolicy.getEvenHeader(); // 偶数页面页眉
        dumpHeaderPart(level + 1, "偶数-页眉内容", evenHeader);

        FooterPart evenFooter = headerFooterPolicy.getEvenFooter(); // 偶数页面页脚
        dumpFooterPart(level + 1, "偶数-页脚内容", evenFooter);
    }

    private static void dumpHeaderPart(int level, String title, HeaderPart headerPart) {
        String padding = prefixPadding(level);

        if (headerPart == null) {
            log.info("{}{} :  N/A", padding, title);
            return;
        }

        List<Object> list = headerPart.getContent();
        log.info("{}{} : {} 个对象 => {}", padding, title, list.size(), list);
    }

    private static void dumpFooterPart(int level, String title, FooterPart footerPart) {
        String padding = prefixPadding(level);
        if (footerPart == null) {
            log.info("{}{} :  N/A", padding, title);
            return;
        }

        List<Object> list = footerPart.getContent();
        log.info("{}{} : {} 个对象 => {}", padding, title, list.size(), list);
    }


    public static String toString(SectPr.PgSz pageSize) {
        StringJoiner sj = new StringJoiner(" , ");

        sj.add("W = " + pageSize.getW());

        sj.add("H = " + pageSize.getH());

        if (pageSize.getCode() != null) {
            sj.add("CODE = " + pageSize.getCode());
        }

        if (pageSize.getOrient() != null) {
            sj.add("O = " + pageSize.getOrient().value());
        }

        return "[ " + sj.toString() + " ]";
    }

    public static String toString(SectPr.PgMar pageMargin) {
        StringJoiner sj = new StringJoiner(" , ");

        sj.add("T = " + pageMargin.getTop()); // 顶
        sj.add("R = " + pageMargin.getRight()); // 右
        sj.add("B = " + pageMargin.getBottom());// 底
        sj.add("L = " + pageMargin.getLeft()); // 左

        if (pageMargin.getHeader() != null) {
            sj.add("H = " + pageMargin.getHeader()); // 头
        }

        if (pageMargin.getFooter() != null) {
            sj.add("F = " + pageMargin.getFooter()); // 脚
        }

        return "[ " + sj.toString() + " ]";
    }

    private static String prefixPadding(int level) {
        String padding = StringUtils.repeat("..", level);
        return padding;
    }
}
