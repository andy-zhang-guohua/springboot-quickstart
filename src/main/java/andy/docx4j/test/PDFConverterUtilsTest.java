package andy.docx4j.test;

import andy.docx4j.utils.POI_PDFConverterUtils;

public class PDFConverterUtilsTest {
    public static void main(String args[]) {
        String folder = "E:\\L2C\\10.开发实施\\渠道商协议\\20211130-来自李静\\渠道协议模板 - 程序化\\";
        String docxFile = "【黄金】2021年XC经销商协议模板2021.11.30-D.docx";
        String pdfFile = "【黄金】2021年XC经销商协议模板2021.11.30-D.pdf";
        POI_PDFConverterUtils.convert(folder + docxFile, folder + pdfFile);
    }
}
