package com.andy.jacob.test;


import com.andy.jacob.utils.JacobPdfUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JacobWord2PdfTest {


    public static void testWord2PDF() {
        String folder = "D:\\idea_wks\\springboot-quickstart\\src\\main\\resources\\";
        String word = "TEST-WORD.docx";
        String pdfByWPS = "TEST-jacob-wps.pdf";
        String pdfByWORD = "TEST-jacob-word.pdf";

        String wordFile = folder + word;
        String pdfFileFromWPS = folder + pdfByWPS;
        String pdfFileFromWORD = folder + pdfByWORD;

        JacobPdfUtils.convertWordToPdfUsingWPS(wordFile, pdfFileFromWPS);
        JacobPdfUtils.convertWordToPdfUsingMSWord(wordFile, pdfFileFromWORD);
    }


    public static void main(String[] args) {
        testWord2PDF();

    }
}
