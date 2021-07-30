package andy.docx4j;

import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.*;

import javax.xml.bind.JAXBElement;

public class Docx4jUtils {
    /**
     * 增加分页符
     *
     * @param documentPart
     * @param factory
     */
    public static void addPageBreak(MainDocumentPart documentPart, ObjectFactory factory) {
        P paragraph = newPageBreak(factory);

        try {
            documentPart.getContents().getBody().getContent().add(paragraph);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static P newPageBreak(ObjectFactory factory) {
        Br pageBreak = factory.createBr();
        pageBreak.setType(STBrType.PAGE);

        R run = factory.createR();
        run.getContent().add(pageBreak);

        P paragraph = factory.createP();
        paragraph.getContent().add(run);
        return paragraph;
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
            addFldChar(factory, paragraph, fldChar);
        }

        { // 变量名称
            Text t = factory.createText();
            t.setValue(varName); // PAGE \* Arabic \* MERGEFORMAT
            addInstrText(factory, paragraph, t);
        }

        {
            FldChar fldChar = factory.createFldChar();
            fldChar.setFldCharType(STFldCharType.SEPARATE);
            addFldChar(factory, paragraph, fldChar);
        }

        { // 初始值
            Text t = factory.createText();
            t.setValue(initialValue); //设置初始值
            addText(factory, paragraph, t);
        }

        {// end
            FldChar fldChar = factory.createFldChar();
            fldChar.setFldCharType(STFldCharType.END);
            addFldChar(factory, paragraph, fldChar);
        }


    }

    public static void addInstrText(ObjectFactory factory, ContentAccessor paragraph, Text t) {
        R r = factory.createR();
        paragraph.getContent().add(r);
        JAXBElement<Text> jaxbElement = factory.createRInstrText(t);
        r.getContent().add(jaxbElement);
    }

    public static void addText(ObjectFactory factory, ContentAccessor paragraph, Text t) {
        R r = factory.createR();
        paragraph.getContent().add(r);
        r.getContent().add(t);
    }

    public static void addFldChar(ObjectFactory factory, ContentAccessor paragraph, FldChar fldChar) {
        R r = factory.createR();
        paragraph.getContent().add(r);
        r.getContent().add(fldChar);
    }
}
