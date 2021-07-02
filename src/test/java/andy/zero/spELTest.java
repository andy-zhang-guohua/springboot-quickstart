package andy.zero;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.*;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 参考资料 : https://cloud.tencent.com/developer/article/1676200
 * 1. 变量 (根变量， 普通变量) #
 * 2. bean @
 * 3. 函数 
 */
@Slf4j
public class spELTest {
    /**
     * 测试只使用 ExpressionParser, 表达式中不引用变量
     */
    @Test
    public void test01ExpressionParser() {
        //创建ExpressionParser解析表达式
        ExpressionParser parser = new SpelExpressionParser();
        //即list.get(0)
        int result1 = parser.parseExpression("{1,2,3}[0]").getValue(int.class);

        log.info("result1 = {}", result1);
    }

    @Test
    public void test02ExpressionParserAndEvaluationContext() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("('Hello' + ' World').concat(#end)");
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("end", "!!!");
        Object value = expression.getValue(context);
        log.info("result1 = {}", value);
    }

    @Test
    public void test03BeanSystemProperties() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        ctx.refresh();

        ExpressionParser parser = new SpelExpressionParser();

        StandardEvaluationContext context = new StandardEvaluationContext();

        context.setBeanResolver(new BeanFactoryResolver(ctx));

        Properties result1 = parser.parseExpression("@systemProperties").getValue(context, Properties.class);
        String value = parser.parseExpression("@systemProperties['user.country']").getValue(context, String.class);
        log.info("@systemProperties['user.country']:{}", value);

        Assert.assertEquals(System.getProperties(), result1);
    }

    @Test
    public void test04FunctionExpression() throws SecurityException, NoSuchMethodException {
        //定义2个函数,registerFunction和setVariable都可以，不过从语义上面来看用registerFunction更恰当
        StandardEvaluationContext context = new StandardEvaluationContext();
        Method parseInt = Integer.class.getDeclaredMethod("parseInt", String.class);
        context.registerFunction("parseInt1", parseInt);
        context.setVariable("parseInt2", parseInt);

        ExpressionParser parser = new SpelExpressionParser();
        System.out.println(parser.parseExpression("#parseInt1('3')").getValue(context, int.class));
        System.out.println(parser.parseExpression("#parseInt2('3')").getValue(context, int.class));

        String expression1 = "#parseInt1('3') == #parseInt2('3')";
        boolean result1 = parser.parseExpression(expression1).getValue(context, boolean.class);
        System.out.println(result1);
    }

    public static class Car {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static class User {
        private Car car;

        public Car getCar() {
            return car;
        }

        public void setCar(Car car) {
            this.car = car;
        }

        @Override
        public String toString() {
            return "User{" +
                    "car=" + car +
                    '}';
        }
    }

    @Test
    public void test5AccessObjectAttribute() {
        User user = new User();
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("user", user);

        ExpressionParser parser = new SpelExpressionParser();
        //使用.符号，访问user.car.name会报错，原因：user.car为空
        try {
            System.out.println(parser.parseExpression("#user.car.name").getValue(context, String.class));
        } catch (EvaluationException | ParseException e) {
            System.out.println("出错了：" + e.getMessage());
        }
        //使用安全访问符号?.，可以规避null错误
        System.out.println(parser.parseExpression("#user?.car?.name").getValue(context, String.class));

        Car car = new Car();
        car.setName("保时捷");
        user.setCar(car);

        System.out.println(parser.parseExpression("#user?.car?.toString()").getValue(context, String.class));
    }
}
