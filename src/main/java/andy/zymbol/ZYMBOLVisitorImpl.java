package andy.zymbol;

import andy.zymbol.model.TypedData;

import java.util.concurrent.ConcurrentHashMap;

/**
 * CALC 脚本的 Visitor 模式实现类
 */
public class ZYMBOLVisitorImpl extends ZYMBOLBaseVisitor<TypedData> {
    // 计算器内容， 用于记录变量的值
    ConcurrentHashMap<String, TypedData> memory = new ConcurrentHashMap<String, TypedData>();

    /**
     * 访问规则分支 'print' expr SEMICOLON
     *
     * @param ctx
     * @return
     */
    @Override
    public TypedData visitPrint(ZYMBOLParser.PrintContext ctx) {
        TypedData value = visit(ctx.expr());

        // 该节点有三个孩子
        // 1. print 字符串
        // 2. expr 表达式
        // 4. SEMICOLON 换行符
        String expressionLiteral = ctx.getChild(1).getText();

        System.out.println(expressionLiteral + " = " + value);

        // 注意 : 该 print 语句返回了值 0, 语言开发者可以根据需要决定在这里返回什么值
        return TypedData.ZERO;
    }

    /**
     * 访问规则分支 : ID '=' expr SEMICOLON
     *
     * @param ctx
     * @return
     */
    @Override
    public TypedData visitAssign(ZYMBOLParser.AssignContext ctx) {
        String id = ctx.ID().getText(); // 获取变量名称
        TypedData value = visit(ctx.expr()); // 访问表达式，得到表达式的值
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
    public TypedData visitMulDiv(ZYMBOLParser.MulDivContext ctx) {
        TypedData left = visit(ctx.expr(0)); // 乘除表达值 左操作数
        TypedData right = visit(ctx.expr(1)); // 乘除表达式 右操作数
        if (ctx.MUL() != null) {
            return left.multiply(right); // 乘法的情况
        } else {
            return left.divide(right); // 如果不是乘法，则认为是除法
        }
    }

    /**
     * 访问规则分支 : expr (PLUS|MINUS) expr
     *
     * @param ctx
     * @return
     */
    @Override
    public TypedData visitAddSub(ZYMBOLParser.AddSubContext ctx) {
        TypedData left = visit(ctx.expr(0));  // 加减表达值 左操作数
        TypedData right = visit(ctx.expr(1)); // 加减表达值 右操作数
        if (ctx.ADD() != null) {
            return left.add(right); // 加法的情况
        } else {
            return left.subtract(right); // 如果不是加法，则认为是减法
        }
    }

    /**
     * 访问规则分支 : variable
     *
     * @param ctx
     * @return
     */
    @Override
    public TypedData visitVariable(ZYMBOLParser.VariableContext ctx) {
        String id = ctx.getText();

        return memory.containsKey(id) ?
                memory.get(id) : // 这是一个已经定义的变量
                TypedData.ZERO; // 引用了一个未被定义的变量，则返回 0
    }

    /**
     * 访问规则分支 : value
     *
     * @param ctx
     * @return
     */
    @Override
    public TypedData visitValue(ZYMBOLParser.ValueContext ctx) {
        String text = ctx.getText();
        // 是整数数字字面值的情况
        return TypedData.parseNumberLiteral(text);
    }

    /**
     * 访问分支 : '('expr')'
     *
     * @param ctx
     * @return
     */
    @Override
    public TypedData visitParenthesis(ZYMBOLParser.ParenthesisContext ctx) {
        return visit(ctx.expr());
    }
}
