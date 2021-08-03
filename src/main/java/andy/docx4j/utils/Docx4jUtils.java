package andy.docx4j.utils;

import lombok.extern.slf4j.Slf4j;
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
