package andy.docx4j.test;


import andy.docx4j.utils.Docx4jUtils;
import org.docx4j.jaxb.Context;
import org.docx4j.model.structure.SectionWrapper;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.FooterPart;
import org.docx4j.openpackaging.parts.WordprocessingML.HeaderPart;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.relationships.Relationship;
import org.docx4j.wml.*;

import java.io.File;
import java.util.List;

public class CreateNewDocxFileTest {
    private static WordprocessingMLPackage wordMLPackage;
    private static ObjectFactory objectFactory;


    public static void main(String[] args) throws Docx4JException {
        wordMLPackage = WordprocessingMLPackage.createPackage();
        objectFactory = Context.getWmlObjectFactory();

        SectPr bodySectPr = getBodySectPr();

        { // 创建一个页眉
            // 1. 创建 Hdr
            Hdr hdr = createHeader("页眉");
            // 2. 创建 HeaderPart <== Hdr
            HeaderPart headerPart = new HeaderPart();
            headerPart.setPackage(wordMLPackage);
            headerPart.setJaxbElement(hdr);
            // 3. 创建 Relationship <== HeaderPart
            Relationship relationshipHeader = wordMLPackage.getMainDocumentPart().addTargetPart(headerPart);
            // 4. 创建 HeaderReference <== Relationship
            HeaderReference headerReference = createHeaderReference(relationshipHeader);
            // 5. 绑定 HeaderReference ==> SectPr BODY
            bodySectPr.getEGHdrFtrReferences().add(headerReference);
        }

        { // 创建页脚
            // 1. 创建 Ftr
            Ftr ftr = createFooter("页脚");
            // 2. 创建 FooterPart <== Ftr
            FooterPart footerPart = new FooterPart();
            footerPart.setPackage(wordMLPackage);
            footerPart.setJaxbElement(ftr);
            // 3. 创建 Relationship <== FooterPart
            Relationship relationshipFooter = wordMLPackage.getMainDocumentPart().addTargetPart(footerPart);
            // 4. 创建 FooterReference <== Relationship
            FooterReference footerReference = createFooterReference(relationshipFooter);
            // 5. 绑定 FooterReference ==> SectPr BODY
            bodySectPr.getEGHdrFtrReferences().add(footerReference);
        }


        wordMLPackage.getMainDocumentPart().addParagraphOfText("Hello Word!");
        wordMLPackage.getMainDocumentPart().addParagraphOfText("中文字符！");

        mockANewSection("S1", 10);
        mockANewSection("S2", 11);
        mockANewSection("S3", 12);

        wordMLPackage.save(new File("/程序创建WORD文档.docx"));
    }


    private static void mockANewSection(String text, int startPosition) {
        Text t = objectFactory.createText(); // create text
        t.setValue("程序化插入的 Section P段落(该Section内的最后一个P段落), 参数文本 : " + text);

        R r = objectFactory.createR(); // create new run
        r.getContent().add(t); // add text ton the run

        // proceed to create another paragraph with a run containing text.
        P p = objectFactory.createP(); // create new paragraph
        p.getContent().add(r); // add run to paragraph

        MainDocumentPart mainDocumentPart = wordMLPackage.getMainDocumentPart();
        List list = mainDocumentPart.getContent();
        startPosition = startPosition >= list.size() ? list.size() : startPosition;

        list.add(startPosition, p); // add to main document part

        insertNewSectionP("nextPage", startPosition + 1);
    }

    /**
     * 在指定位置插入一个 段落 P，该段落无内容，只包含一个 SectPr,
     * <p>
     * 1. 该目的是用来添加一个Section，具体添加方式 : 将插入点之前上个一Section P 之后的所有段落 P 形成一个新的 Section 并结束当前 Section;
     * <p>
     * Section 类型 :
     * * continuous - Begins the section on the next paragraph. Certain page-level section properties cannot be specified, as they are inherited from the previous section. If a footnote occurs of the same page as a section of this kind, the new section begins on the following page.
     * * evenPage - The section begins on the next even-numbered page, leaving the next odd page blank if necessary.
     * * nextColumn - The section begins on the following column on the page.
     * * nextPage - The section begins on the following page.
     * * oddPage - The section begins on the next odd-numbered page, leaving the next even page blank if necessary.
     *
     * @param sectionType
     */
    private static void insertNewSectionP(String sectionType, int position) {
        P p = Docx4jUtils.newP_PPr_SectPr(objectFactory, sectionType);

        MainDocumentPart mainDocumentPart = wordMLPackage.getMainDocumentPart();
        Docx4jUtils.insert_P(mainDocumentPart, position, p);
        wordMLPackage.getDocumentModel().refresh();
    }

    private static Ftr createFooter(String content) {
        // Text
        Text text = new Text();
        text.setValue(content);

        // R
        R run = objectFactory.createR();
        run.getContent().add(text);

        // P
        P paragraph = objectFactory.createP();
        paragraph.getContent().add(run);

        // Ftr
        Ftr footer = objectFactory.createFtr();
        footer.getContent().add(paragraph);
        return footer;
    }

    private static Hdr createHeader(String content) {
        // Text
        Text text = new Text();
        text.setValue(content);

        // R
        R run = objectFactory.createR();
        run.getContent().add(text);

        // P
        P paragraph = objectFactory.createP();
        paragraph.getContent().add(run);

        // Hdr
        Hdr hdr = objectFactory.createHdr();
        hdr.getContent().add(paragraph);
        return hdr;
    }

    private static FooterReference createFooterReference(Relationship relationship) {
        FooterReference footerReference = objectFactory.createFooterReference();
        footerReference.setId(relationship.getId());
        footerReference.setType(HdrFtrRef.DEFAULT);

        return footerReference;
    }

    private static HeaderReference createHeaderReference(Relationship relationship) {
        HeaderReference headerReference = objectFactory.createHeaderReference();
        headerReference.setId(relationship.getId());
        headerReference.setType(HdrFtrRef.DEFAULT);

        return headerReference;
    }

    private static SectPr getBodySectPr() {
        List<SectionWrapper> sections = wordMLPackage.getDocumentModel().getSections();

        final int INDEX_OF_BODY_SECTION = sections.size() - 1;
        SectPr sectionProperties = sections.get(INDEX_OF_BODY_SECTION).getSectPr();
        // There is always a section wrapper, but it might not contain a sectPr
        if (sectionProperties == null) {
            sectionProperties = objectFactory.createSectPr();
            wordMLPackage.getMainDocumentPart().addObject(sectionProperties);
            sections.get(INDEX_OF_BODY_SECTION).setSectPr(sectionProperties);
        }

        return sectionProperties;
    }
}