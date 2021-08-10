package andy.docx4j;

import andy.docx4j.utils.Docx4jUtils;
import andy.docx4j.utils.RandomChineseUtils;
import org.docx4j.jaxb.Context;
import org.docx4j.model.structure.DocumentModel;
import org.docx4j.model.structure.PageSizePaper;
import org.docx4j.model.structure.SectionWrapper;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.HeaderPart;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.relationships.Relationship;
import org.docx4j.wml.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * 参考资料 : https://www.docx4java.org/forums/docx-java-f6/page-number-t2492.html
 * MainDocumentPart
 * - 可以包含 Tbl, P
 * Tbl table 表格
 * -  Tr table row
 * - Tc table cell (可以包含 P)
 * P paragraph 段落
 * -  R run
 * - RPr run properties
 * - Text 文本
 */
public class CreateDocxFile {
    public static void main(String[] args) throws Exception {
        boolean landscape = false;//横版 : false
        WordprocessingMLPackage wordprocessingMLPackage = WordprocessingMLPackage.createPackage(PageSizePaper.valueOf("A4"), landscape);
        MainDocumentPart mainDocumentPart = wordprocessingMLPackage.getMainDocumentPart();
        Body body = mainDocumentPart.getContents().getBody();
        DocumentModel documentModel = wordprocessingMLPackage.getDocumentModel();

        ObjectFactory factory = Context.getWmlObjectFactory();

        // Header
        HeaderPart headerPart = new HeaderPart();
        Relationship relationship = mainDocumentPart.addTargetPart(headerPart);
        Hdr header = factory.createHdr();
        headerPart.setJaxbElement(header);

        // <w:sectPr>
        // <w:headerReference w:type="default" r:id="rId2"/>
        // <w:footerReference w:type="default" r:id="rId3"/>
        // </w:sectPr>
        List<SectionWrapper> sections = documentModel.getSections();
        final int indexDefaultSection = sections.size() - 1;
        SectPr sectPr = sections.get(indexDefaultSection).getSectPr();
        // There is always a section wrapper, but it might not contain a sectPr
        if (sectPr == null) {
            sectPr = factory.createSectPr();
            mainDocumentPart.addObject(sectPr);
            sections.get(indexDefaultSection).setSectPr(sectPr);
        }
        HeaderReference headerReference = factory.createHeaderReference();
        headerReference.setId(relationship.getId());
        headerReference.setType(HdrFtrRef.DEFAULT);
        sectPr.getEGHdrFtrReferences().add(headerReference);// add header or footer


        {
            // Add table, image, p ... to Header
            P p = factory.createP();
            header.getContent().add(p);

            PPr pPr = factory.createPPr();
            p.setPPr(pPr);
            // style
            PPrBase.PStyle pStyle = factory.createPPrBasePStyle();
            pStyle.setVal("a4"); // style21
            pPr.setPStyle(pStyle);
            Jc jc = factory.createJc();
            jc.setVal(JcEnumeration.CENTER);
            pPr.setJc(jc);

            // PAGE
            addVarToParagraph(factory, p, "PAGE");

            // /
            R r = factory.createR();
            p.getContent().add(r);
            Text t = factory.createText();
            t.setSpace("preserve"); // preserve space
            t.setValue(" / ");
            r.getContent().add(t);

            // NUMPAGES
            addVarToParagraph(factory, p, "NUMPAGES");
        }

        {
            P p = factory.createP();
            header.getContent().add(p);

            Text t = factory.createText();
            t.setValue("页眉文字");

            Docx4jUtils.newR_Text(factory, p, t);
        }

        {// // 新增段落
            P p = factory.createP();
            body.getContent().add(p);

            Text t = factory.createText();
            t.setValue("第一个段落");

            Docx4jUtils.newR_Text(factory, p, t);
        }

        // 添加分页符
        addPageBreak(mainDocumentPart, factory);

        {// 新增段落
            P p = factory.createP();
            body.getContent().add(p);

            Text t = factory.createText();

            String value = RandomChineseUtils.randomChineseString(2000);

            t.setValue(value);

            Docx4jUtils.newR_Text(factory, p, t);
        }


        FileOutputStream fos = new FileOutputStream(new File("/my-test.docx"));
        wordprocessingMLPackage.save(fos);
    }

    /**
     * 增加分页符
     *
     * @param documentPart
     * @param factory
     */
    public static void addPageBreak(MainDocumentPart documentPart, ObjectFactory factory) {
        Docx4jUtils.addPageBreak(documentPart, factory);
    }

    public static void addVarToParagraph(ObjectFactory factory, P paragraph, String var) {
        Docx4jUtils.addVarToParagraph(factory, paragraph, var, "1");
    }
}