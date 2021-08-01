package andy.docx4j;

import lombok.extern.slf4j.Slf4j;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Docx4jCommandLineRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        testReadFileDocx();
    }

    private void testReadFileDocx() {
        String docxFilePath = "D:\\idea_wks\\springboot-quickstart\\src\\main\\resources\\模板-多样性测试.docx";
        WordprocessingMLPackage wordMLPackage = Docx4jUtils.load(docxFilePath);
        Docx4jDumpUtils.dumpElements(wordMLPackage);
    }
}
