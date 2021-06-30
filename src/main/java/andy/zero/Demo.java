package andy.zero;

import lombok.extern.slf4j.Slf4j;
import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.definition.KiePackage;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * https://zhuanlan.zhihu.com/p/129863264
 */
@Slf4j
@Component
public class Demo implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        test1();
    }

    public static void test1() throws Exception {
        KieSession kieSession = check(getRawRuleText());

        TestVO drools = new TestVO();
        drools.setDays(2);
        kieSession.insert(drools);
        int i = kieSession.fireAllRules();
        System.out.println("命中： " + i + "返回结果：" + drools.getMessage());

    }


    /**
     * 不进行检查
     *
     * @param rule
     * @return
     */
    public static KieSession getSession(String rule) {
        KieSession kieSession = null;
        try {
            KnowledgeBuilder builder = KnowledgeBuilderFactory.newKnowledgeBuilder();
            builder.add(ResourceFactory.newByteArrayResource(rule.getBytes("UTF-8")), ResourceType.DRL);
            InternalKnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
            Collection<KiePackage> packages = builder.getKnowledgePackages();
            knowledgeBase.addPackages(packages);
            kieSession = knowledgeBase.newKieSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kieSession;
    }


    /**
     * 检查
     *
     * @param sq
     * @return
     * @throws Exception
     */
    private static KieSession check(String sq) throws Exception {
        KieSessionRepo kieSession = new KieSessionRepo();
        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kfs = kieServices.newKieFileSystem();

        kfs.write("src/main/resources/test.drl", sq);
        KieBuilder kieBuilder = kieServices.newKieBuilder(kfs).buildAll();
        Results results = kieBuilder.getResults();
        if (results.hasMessages(Message.Level.ERROR)) {
            for (Message msg : results.getMessages()) {
                System.out.println("drools script error info : " + msg.getText());
            }
            throw new Exception("drools script error");
        }

        kieSession.setKieContainer("test", kieServices.newKieContainer(KieServices.Factory.get().getRepository().getDefaultReleaseId()));

        return kieSession.getKieSession("test");
    }

    public static String getRawRuleText() {
        StringBuffer scripts = new StringBuffer();
        scripts.append("package rule_10001;\n");
        scripts.append("import andy.zero.TestVO\n");
        scripts.append("rule rule_10001 \n");
        scripts.append("when \n");
        scripts.append("testVO : TestVO(days>=2 && days<=10); \n");
        scripts.append("then \n");
        scripts.append("testVO.setMessage(\"命中了\"); \n");
        scripts.append("end");

        System.out.println(scripts.toString());
        return scripts.toString();
    }
}
