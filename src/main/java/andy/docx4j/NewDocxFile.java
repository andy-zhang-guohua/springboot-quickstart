package andy.docx4j;

import org.docx4j.jaxb.Context;
import org.docx4j.model.structure.DocumentModel;
import org.docx4j.model.structure.PageSizePaper;
import org.docx4j.model.structure.SectionWrapper;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.HeaderPart;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.relationships.Relationship;
import org.docx4j.wml.*;

import javax.xml.bind.JAXBElement;
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
public class NewDocxFile {
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
            addVARToP(factory, p, "PAGE");

            // /
            R r = factory.createR();
            p.getContent().add(r);
            Text t = factory.createText();
            t.setSpace("preserve"); // preserve space
            t.setValue(" / ");
            r.getContent().add(t);

            // NUMPAGES
            addVARToP(factory, p, "NUMPAGES");
        }

        {
            P p = factory.createP();
            header.getContent().add(p);
            R r = factory.createR();
            p.getContent().add(r);
            Text t = factory.createText();
            t.setValue("页眉文字");
            r.getContent().add(t);
        }

        {// new page : page 1
            P p = factory.createP();
            R r = factory.createR();

            Text t = factory.createText();
            t.setValue("第一页");
            r.getContent().add(t);
            p.getContent().add(r);

            body.getContent().add(p);
        }

        addPageBreak(mainDocumentPart, factory);

        {// new page : page 2
            P p = factory.createP();
            R r = factory.createR();

            Text t = factory.createText();
            t.setValue("第二页");
            r.getContent().add(t);
            p.getContent().add(r);

            body.getContent().add(p);
        }

        FileOutputStream fos=new FileOutputStream(new File("/my_test.docx"));
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

    public static void addVARToP(ObjectFactory factory, P paragraph, String var) {
        R r = factory.createR();
        paragraph.getContent().add(r);
        FldChar fldChar = factory.createFldChar();
        r.getContent().add(fldChar);
        fldChar.setFldCharType(STFldCharType.BEGIN); // begin

        r = factory.createR();
        paragraph.getContent().add(r);
        Text t = factory.createText();
        t.setValue(var); // PAGE \* Arabic \* MERGEFORMAT
        JAXBElement<Text> jaxbElement = factory.createRInstrText(t);
        r.getContent().add(jaxbElement);

        r = factory.createR();
        paragraph.getContent().add(r);
        fldChar = factory.createFldChar();
        r.getContent().add(fldChar);
        fldChar.setFldCharType(STFldCharType.SEPARATE);

        r = factory.createR();
        paragraph.getContent().add(r);
        t = factory.createText();
        t.setValue("1"); // start value set to 1
        r.getContent().add(t);

        r = factory.createR();
        paragraph.getContent().add(r);
        fldChar = factory.createFldChar();
        r.getContent().add(fldChar);
        fldChar.setFldCharType(STFldCharType.END); // end
    }
}