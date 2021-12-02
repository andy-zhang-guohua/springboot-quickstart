package andy.docx4j.utils;


import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class POI_PDFConverterUtils {
    /**
     * 参考 : https://www.cnblogs.com/M87-A/p/15315306.html?ivk_sa=1024320u
     * <p>
     * 问题 :
     * 1. 页眉中的图片转换不出来
     * 2. 行间距变小了
     *
     * @param docxPath
     * @param pdfPath
     */
    public static void convert(String docxPath, String pdfPath) {
        try {
            //读取word文档
            InputStream inputStream = Files.newInputStream(Paths.get(docxPath));
            XWPFDocument xwpfDocument = new XWPFDocument(inputStream);

            //将word转成pdf
            PdfOptions options = PdfOptions.create();
            OutputStream outputStream = Files.newOutputStream(Paths.get(pdfPath));
            PdfConverter.getInstance().convert(xwpfDocument, outputStream, options);

            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
