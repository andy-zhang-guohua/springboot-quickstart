package andy.docx4j;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.docx4j.model.structure.DocumentModel;
import org.docx4j.model.structure.HeaderFooterPolicy;
import org.docx4j.model.structure.PageDimensions;
import org.docx4j.model.structure.SectionWrapper;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.FooterPart;
import org.docx4j.openpackaging.parts.WordprocessingML.HeaderPart;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.SectPr;

import java.util.List;
import java.util.StringJoiner;

@Slf4j
public class Docx4jDumpUtils {
    /**
     * 浏览 docx 文件主文档的元素
     * 1. 能够浏览所有元素
     * -- 1.1 包括隐藏元素
     * 2. 能够替换某些元素
     * 3. 能够隐藏某些元素
     */
    public static void dumpElements(WordprocessingMLPackage wordMLPackage) {
        try {
            MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();

            List<Object> objects = documentPart.getContent();
            log.info("主文档内容 : {} 个对象 => {}", objects.size(), objects);

            DocumentModel documentModel = wordMLPackage.getDocumentModel();
            List<SectionWrapper> sections = documentModel.getSections();
            log.info("主文档包含 Section 数量 : {}", sections.size());


            for (int i = 0; i < sections.size(); i++) {
                SectionWrapper section = sections.get(i);

                String title = "Section [" + (i + 1) + "] ====================> ";
                dumpSection(1, title, section);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void dumpSection(int level, String title, SectionWrapper section) {
        String padding = prefixPadding(level);
        log.info("{}{}", padding, title);

        PageDimensions pageDimensions = section.getPageDimensions();
        dumpPageSize(level + 1, "页面尺寸", pageDimensions.getPgSz());
        dumpPageMargin(level + 1, "页面边距", pageDimensions.getPgMar());

        HeaderFooterPolicy headerFooterPolicy = section.getHeaderFooterPolicy();
        dumpHeaderFooterPolicy(level + 1, "", headerFooterPolicy);
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
        HeaderPart firstHeader = headerFooterPolicy.getFirstHeader(); // 首页页眉
        dumpHeaderPart(level, "首页-页眉内容", firstHeader);

        FooterPart firstFooter = headerFooterPolicy.getFirstFooter(); // 首页页脚
        dumpFooterPart(level, "首页-页脚内容", firstFooter);

        HeaderPart defaultHeader = headerFooterPolicy.getDefaultHeader(); // 默认页面页眉
        dumpHeaderPart(level, "默认-页眉内容", defaultHeader);

        FooterPart defaultFooter = headerFooterPolicy.getDefaultFooter(); // 默认页面页脚
        dumpFooterPart(level, "默认-页脚内容", defaultFooter);

        HeaderPart evenHeader = headerFooterPolicy.getEvenHeader(); // 偶数页面页眉
        dumpHeaderPart(level, "偶数-页眉内容", evenHeader);

        FooterPart evenFooter = headerFooterPolicy.getEvenFooter(); // 偶数页面页脚
        dumpFooterPart(level, "偶数-页脚内容", evenFooter);
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
