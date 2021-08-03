package andy.calc;

import java.util.concurrent.ConcurrentHashMap;

/**
 * CALC 脚本的 Visitor 模式实现类
 */
public class CALCVisitorImpl extends CALCBaseVisitor<Integer> {
    // 计算器内容， 用于记录变量的值
    ConcurrentHashMap<String, Integer> memory = new ConcurrentHashMap<String, Integer>();

    /**
     * 访问规则分支 'print' expr NEWLINE
     *
     * @param ctx
     * @return
     */
    @Override
    public Integer visitPrint(CALCParser.PrintContext ctx) {
        Integer value = visit(ctx.expr());

        // 该节点有三个孩子
        // 1. print 字符串
        // 2. expr 表达式
        // 4. NEWLINE 换行符
        String expressionLiteral = ctx.getChild(1).getText();

        System.out.println(expressionLiteral + " = " + value);

        // 注意 : 该 print 语句返回了值 0, 语言开发者可以根据需要决定在这里返回什么值
        return 0;
    }

    /**
     * 访问规则分支 : ID '=' expr NEWLINE
     *
     * @param ctx
     * @return
     */
    @Override
    public Integer visitAssign(CALCParser.AssignContext ctx) {
        String id = ctx.ID().getText(); // 获取变量名称
        Integer value = visit(ctx.expr()); // 访问表达式，得到表达式的值
        memory.put(id, value); // 将变量的值记录到计算器内存中

        return value;
    }

    /**
     * 访问规则分支 : expr (MULTIPLY|DIVIDE) expr
     *
     * @param ctx
     * @return
     */
    @Override
    public Integer visitMulDiv(CALCParser.MulDivContext ctx) {
        Integer left = visit(ctx.expr(0)); // 乘除表达值 左操作数
        Integer right = visit(ctx.expr(1)); // 乘除表达式 右操作数
        if (ctx.MUL() != null) {
            return left * right; // 乘法的情况
        } else {
            return left / right; // 如果不是乘法，则认为是除法
        }
    }

    /**
     * 访问规则分支 : expr (PLUS|MINUS) expr
     *
     * @param ctx
     * @return
     */
    @Override
    public Integer visitAddSub(CALCParser.AddSubContext ctx) {
        Integer left = visit(ctx.expr(0));  // 加减表达值 左操作数
        Integer right = visit(ctx.expr(1)); // 加减表达值 右操作数
        if (ctx.ADD() != null) {
            return left + right; // 加法的情况
        } else {
            return left - right; // 如果不是加法，则认为是减法
        }
    }



    /**
     * 访问分支 : '('expr')'
     *
     * @param ctx
     * @return
     */
    @Override
    public Integer visitParenthesis(CALCParser.ParenthesisContext ctx) {
        return visit(ctx.expr());
    }
}
