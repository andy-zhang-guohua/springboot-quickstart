package andy.calc;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * CALC 计算器DSL解释执行器
 */
public class CALCInterpreter {
    /**
     * 执行 CALC 语言脚本
     * @param script CALC 语言脚本
     */
    public void run(String script) {
        //  对每一个输入的字符串,也就是 CALC 语言脚本,构造一个 CodePointCharStream
        CodePointCharStream stream = CharStreams.fromString(script);

        //  用 stream 构造 CALC 词法分析器 lexer，词法分析的作用是产生记号
        CALCLexer lexer = new CALCLexer(stream);

        //  用 CALC 词法分析器 lexer 构造一个词法符号流 tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        //  使用 法符号流 tokens 构造 CALC 语法分析器 parser,至此已经完成词法分析和语法分析的准备工作
        CALCParser parser = new CALCParser(tokens);

        //  最终 : 调用 CALC 语法分析器的规则 program，完成对 CALC 表达式脚本 script 的分析
        CALCParser.ProgramContext programContext = parser.program();

        //  通过访问者模式，执行我们的程序
        CALCBaseVisitor evalVisitor = new CALCVisitorImpl();
        evalVisitor.visit(programContext);
    }
}
