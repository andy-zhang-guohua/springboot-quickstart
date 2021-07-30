package andy.docx4j;

import lombok.extern.slf4j.Slf4j;
import org.docx4j.model.structure.DocumentModel;
import org.docx4j.model.structure.HeaderFooterPolicy;
import org.docx4j.model.structure.PageDimensions;
import org.docx4j.model.structure.SectionWrapper;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.FooterPart;
import org.docx4j.openpackaging.parts.WordprocessingML.HeaderPart;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class Docx4jCommandLineRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        testReadFileDocx();
    }

    private void testReadFileDocx() {
        String template = "D:\\idea_wks\\springboot-quickstart\\src\\main\\resources\\模板-多样性测试.docx";
        WordprocessingMLPackage wordMLPackage;
        try {
            wordMLPackage = WordprocessingMLPackage.load(new java.io.File(template));
            MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();


            List<Object> objects = documentPart.getContent();
            log.info("主文档部分对象 : {}", objects);

            DocumentModel documentModel = wordMLPackage.getDocumentModel();
            List<SectionWrapper> sections = documentModel.getSections();

            for (int i = 0; i < sections.size(); i++) {
                log.info("Section [{}] ====================> ", i + 1);
                SectionWrapper section = sections.get(i);

                HeaderFooterPolicy headerFooterPolicy = section.getHeaderFooterPolicy();
                HeaderPart firstHeader = headerFooterPolicy.getFirstHeader();
                HeaderPart headerPart = headerFooterPolicy.getDefaultHeader();
                if (headerPart != null) {
                    log.info("页眉内容 : {}", headerPart.getContent());
                }

                PageDimensions pageDimensions = section.getPageDimensions();
                log.info("页面尺寸 : {}", pageDimensions.getPgSz());
                log.info("页面边距 : {}", pageDimensions.getPgMar());

                FooterPart firstFooter = headerFooterPolicy.getFirstFooter();
                FooterPart footerPart = headerFooterPolicy.getDefaultFooter();
                if (footerPart != null) {
                    log.info("页脚内容 : {}", footerPart.getContent());
                }

                log.info("页眉页脚策略 : {}", headerFooterPolicy);
            }

        } catch (Docx4JException e) {
            e.printStackTrace();
        }
    }
}
