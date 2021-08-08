package andy.zymbol;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class ZYMBOLInterpreter {
    public void run(String script) {
        //  对每一个输入的字符串，构造一个 CodePointCharStream
        CodePointCharStream stream = CharStreams.fromString(script);

        //  用 stream 构造词法分析器 lexer，词法分析的作用是产生记号
        ZYMBOLLexer lexer = new ZYMBOLLexer(stream);

        //  用词法分析器 lexer 构造一个记号流 tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        //  再使用 tokens 构造语法分析器 parser,至此已经完成词法分析和语法分析的准备工作
        ZYMBOLParser parser = new ZYMBOLParser(tokens);

        //  最终调用语法分析器的规则 program，完成对表达式的验证
        ZYMBOLParser.ProgramContext programContext = parser.program();

        //  通过访问者模式，执行我们的程序
        ZYMBOLBaseVisitor evalVisitor = new ZYMBOLVisitorImpl();
        evalVisitor.visit(programContext);
    }
}
