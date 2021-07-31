package andy.calc;

import java.util.concurrent.ConcurrentHashMap;

/**
 * CALC 脚本的 Visitor 模式实现类
 */
public class CALCVisitorImpl extends CALCBaseVisitor<Integer> {
    ConcurrentHashMap<String, Integer> memory = new ConcurrentHashMap<String, Integer>();

    @Override
    public Integer visitPrint(CALCParser.PrintContext ctx) {
        Integer value = visit(ctx.expr());

        // 该节点有三个孩子
        // 1. print 字符串
        // 2. expr 表达式
        // 4. NEWLINE 换行符
        String expressionLiteral = ctx.children.get(1).getText();

        System.out.println(expressionLiteral + " = " + value);

        return 0;
    }

    @Override
    public Integer visitAssign(CALCParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        Integer value = visit(ctx.expr());
        memory.put(id, value);
        return value;
    }

    @Override
    public Integer visitMulDiv(CALCParser.MulDivContext ctx) {
        Integer left = visit(ctx.expr(0));
        Integer right = visit(ctx.expr(1));
        if (ctx.MULTIPLY() != null) {
            return left * right;
        } else {
            return left / right;
        }
    }

    @Override
    public Integer visitAddSub(CALCParser.AddSubContext ctx) {
        Integer left = visit(ctx.expr(0));
        Integer right = visit(ctx.expr(1));
        if (ctx.PLUS() != null) {
            return left + right;
        } else {
            return left - right;
        }
    }

    @Override
    public Integer visitIdInt(CALCParser.IdIntContext ctx) {
        String text = ctx.getText();
        if (text.matches("[a-z]+")) {
            String id = text;
            return memory.containsKey(id) ? memory.get(id) : 0;
        }
        return Integer.valueOf(text);
    }

    @Override
    public Integer visitParenthesis(CALCParser.ParenthesisContext ctx) {
        return visit(ctx.expr());
    }
}
