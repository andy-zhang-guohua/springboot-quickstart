package andy.zero;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * 注意该例子是一个基于 Visitor 模式的例子
 * 另外可以实现一个基于 Listener 模式的例子
 */
public class Main {
    public static void run(String expr) throws Exception {
        //对每一个输入的字符串，构造一个 CodePointCharStream
        CodePointCharStream stream = CharStreams.fromString(expr);

        //用 stream 构造词法分析器 lexer，词法分析的作用是产生记号
        AntlrTestLexer lexer = new AntlrTestLexer(stream);

        //用词法分析器 lexer 构造一个记号流 tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        //再使用 tokens 构造语法分析器 parser,至此已经完成词法分析和语法分析的准备工作
        AntlrTestParser parser = new AntlrTestParser(tokens);

        //最终调用语法分析器的规则 prog，完成对表达式的验证
        AntlrTestParser.ProgContext progContext = parser.prog();

        // 通过访问者模式，执行我们的程序
        EvalVisitor evalVisitor = new EvalVisitor();
        evalVisitor.visit(progContext);
    }

    public static void main(String[] args) throws Exception {
        String script1 = "a=5\n" +
                "b=3\n" +
                "c=a*b+3\n" +
                "c*c*c\n";
        run(script1);

        String script2 = "a=5\n" +
                "b=3\n" +
                "c=a*(b+3)\n" +
                "c\n";
        run(script2);
    }
}
