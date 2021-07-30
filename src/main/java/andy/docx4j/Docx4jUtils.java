package andy.docx4j;

import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.*;

public class Docx4jUtils {
    /**
     * 增加分页符
     *
     * @param documentPart
     * @param factory
     */
    public static void addPageBreak(MainDocumentPart documentPart, ObjectFactory factory) {
        Br pageBreak = factory.createBr();
        pageBreak.setType(STBrType.PAGE);

        R run = factory.createR();
        run.getContent().add(pageBreak);

        P paragraph = factory.createP();
        paragraph.getContent().add(run);

        documentPart.getJaxbElement().getBody().getContent().add(paragraph);
    }
}
