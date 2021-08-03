package andy.docx4j.test;

import andy.docx4j.utils.Docx4jUtils;
import andy.docx4j.utils.DocxDumpUtils;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

/**
 * 浏览 docx 文件的元素，并做必要的操作
 * 1. 能够浏览所有元素
 * -- 1.1 包括隐藏元素
 * 2. 能够替换某些元素
 * 3. 能够隐藏某些元素
 */
public class DocxDumpTest {
    public static void main(String[] args) throws Exception {
        String docxFilePath = "D:\\idea_wks\\springboot-quickstart\\src\\main\\resources\\模板-多样性测试.docx";
        WordprocessingMLPackage wordprocessingMLPackage = Docx4jUtils.load(docxFilePath);
        DocxDumpUtils.dumpElements(wordprocessingMLPackage);
    }
}
