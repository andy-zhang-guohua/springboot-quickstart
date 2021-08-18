package andy.zymbol;

import andy.zymbol.model.NumericData;
import andy.zymbol.model.StringData;
import andy.zymbol.model.TypedData;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ZYMBOL 脚本的 Visitor 模式实现类
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
        return NumericData.ZERO;
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
        ZYMBOLParser.ExprContext exprContext = ctx.expr();
        TypedData value = visit(exprContext); // 访问表达式，得到表达式的值

        if (value == null) throw new RuntimeException("变量不允许设置为空值 : " + id);

        memory.put(id, value); // 将变量的值记录到计算器内存中

        return value;
    }

    /**
     * 访问规则分支 : exprNumerical (MUL|DIV) exprNumerical
     *
     * @param ctx
     * @return
     */
    @Override
    public TypedData visitMulDiv(ZYMBOLParser.MulDivContext ctx) {
        NumericData left = (NumericData) visit(ctx.exprNumerical(0)); // 乘除表达式 左操作数
        NumericData right = (NumericData) visit(ctx.exprNumerical(1)); // 乘除表达式 右操作数
        if (ctx.MUL() != null) {
            return left.multiply(right); // 乘法的情况
        } else {
            return left.divide(right); // 如果不是乘法，则认为是除法
        }
    }

    /**
     * 访问规则分支 : exprNumerical (ADD|SUB) exprNumerical
     *
     * @param ctx
     * @return
     */
    @Override
    public TypedData visitAddSub(ZYMBOLParser.AddSubContext ctx) {
        NumericData left = (NumericData) visit(ctx.exprNumerical(0));  // 加减表达值 左操作数
        NumericData right = (NumericData) visit(ctx.exprNumerical(1)); // 加减表达值 右操作数
        if (ctx.ADD() != null) {
            return left.add(right); // 加法的情况
        } else {
            return left.subtract(right); // 如果不是加法，则认为是减法
        }
    }

    /**
     * 访问规则分支 : NumericalVariable
     *
     * @param ctx
     * @return
     */
    @Override
    public TypedData visitNumericalVariable(ZYMBOLParser.NumericalVariableContext ctx) {
        String id = ctx.getText();

        if (memory.containsKey(id))
            // 这是一个已经定义的变量
            return memory.get(id);

        throw new RuntimeException("未定义的变量 : " + id);
    }

    /**
     * 访问规则分支 : FloatLiteral
     * @param ctx
     * @return
     */
    @Override
    public TypedData visitFloatLiteral(ZYMBOLParser.FloatLiteralContext ctx) {
        String text = ctx.getText();
        // 是整数数字字面值的情况
        return NumericData.parseFloatLiteral(text);
    }

    /**
     * 访问规则分支 : IntLiteral
     *
     * @param ctx
     * @return
     */
    @Override
    public TypedData visitIntLiteral(ZYMBOLParser.IntLiteralContext ctx) {
        String text = ctx.getText();
        // 是整数数字字面值的情况
        return NumericData.parseIntLiteral(text);
    }

    /**
     * 访问分支 : '('exprNumerical')'
     *
     * @param ctx
     * @return
     */
    @Override
    public TypedData visitParenthesis(ZYMBOLParser.ParenthesisContext ctx) {
        ZYMBOLParser.ExprNumericalContext exprNumericalContext = ctx.exprNumerical();
        return visit(exprNumericalContext);
    }


    @Override
    public TypedData visitStringConcatenation(ZYMBOLParser.StringConcatenationContext ctx) {
        StringData left = (StringData) visit(ctx.exprString(0)); // 字符串拼接 左操作数
        StringData right = (StringData) visit(ctx.exprString(1)); // 字符串拼接 右操作数

        StringData result = StringData.of(left).concatenate(right);
        return result;
    }

    /**
     * 访问规则
     * <p>
     * valueString : STRING     // 直接是一个字符串字面值
     *
     * @param ctx
     * @return
     */
    @Override
    public TypedData visitValueString(ZYMBOLParser.ValueStringContext ctx) {
        // 这里获得的 text 包括首尾的双引号字符
        String text = ctx.getText();

        // 去除首尾的双引号字符
        int length = text.length();
        String value = text.substring(1, length - 1);

        return StringData.of(value);
    }

    /**
     * 访问规则分支 : StringVariable
     *
     * @param ctx
     * @return
     */
    @Override
    public TypedData visitStringVariable(ZYMBOLParser.StringVariableContext ctx) {
        String id = ctx.getText();

        if (memory.containsKey(id))
            // 这是一个已经定义的变量
            return memory.get(id);

        throw new RuntimeException("未定义的变量 : " + id);
    }
}
