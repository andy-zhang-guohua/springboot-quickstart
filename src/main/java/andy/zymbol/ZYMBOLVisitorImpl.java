package andy.zymbol;

import andy.zymbol.model.BooleanData;
import andy.zymbol.model.NumericData;
import andy.zymbol.model.StringData;
import andy.zymbol.model.TypedData;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ZYMBOL 脚本的 Visitor 模式实现类
 */
public class ZYMBOLVisitorImpl extends ZYMBOLBaseVisitor<TypedData> {
    // 计算器内容， 用于记录变量的值
    ConcurrentHashMap<String, TypedData> variables = new ConcurrentHashMap<String, TypedData>();

    /**
     * 访问规则分支 : 'print' expr SEMICOLON       # Print // 输出表达式的值
     *
     * @param ctx
     * @return
     */
    @Override
    public TypedData visitPrint(ZYMBOLParser.PrintContext ctx) {
        // 该节点有三个孩子
        // 1. print 字符串
        // 2. expr 表达式
        // 3. SEMICOLON 换行符


        // 访问表达式，得到该表达式的值
        ZYMBOLParser.ExprContext exprContext = ctx.expr();
        TypedData value = visit(exprContext);

        // 获取表达式的字符串文字表示
        String expressionLiteral = ctx.expr().getText();

        // 输出该表达式及其值
        System.out.println(expressionLiteral + " = " + value);

        // 注意 : 该 print 语句返回了值 0, 语言开发者可以根据需要决定在这里返回什么值
        return NumericData.ZERO;
    }

    /**
     * 访问规则分支 : expr SEMICOLON             # SimplePrint // 同样输出表达式的值
     *
     * @param ctx
     * @return
     */
    @Override
    public TypedData visitSimplePrint(ZYMBOLParser.SimplePrintContext ctx) {
        // 该节点有两个孩子
        // 1. expr 表达式
        // 2. SEMICOLON 换行符


        // 访问表达式，得到该表达式的值
        ZYMBOLParser.ExprContext exprContext = ctx.expr();
        TypedData value = visit(exprContext);

        // 获取表达式的字符串文字表示
        String expressionLiteral = ctx.expr().getText();

        // 输出该表达式及其值
        System.out.println(expressionLiteral + " = " + value);

        // 注意 : 该 print 语句返回了值 0, 语言开发者可以根据需要决定在这里返回什么值
        return NumericData.ZERO;
    }


    /**
     * 访问规则分支 : ID '=' expr SEMICOLON             # Assign // 赋值语句 : 变量
     *
     * @param ctx
     * @return
     */
    @Override
    public TypedData visitAssign(ZYMBOLParser.AssignContext ctx) {
        String variableName = ctx.ID().getText(); // 获取变量名称
        ZYMBOLParser.ExprContext exprContext = ctx.expr();


        TypedData value = visit(exprContext); // 访问表达式，得到表达式的值

        if (value == null) throw new RuntimeException("变量不允许设置为空值 : " + variableName);

        variables.put(variableName, value); // 将变量的值记录到内存中

        return value;
    }


    /**
     * 访问规则分支 : expr (MUL|DIV) expr             # MulDiv // 乘除表达式
     *
     * @param ctx
     * @return
     */
    @Override
    public TypedData visitMulDiv(ZYMBOLParser.MulDivContext ctx) {
        NumericData left = (NumericData) visit(ctx.expr(0)); // 乘除表达式 左操作数
        NumericData right = (NumericData) visit(ctx.expr(1)); // 乘除表达式 右操作数
        if (ctx.MUL() != null) {
            return left.multiply(right); // 乘法的情况
        } else {
            return left.divide(right); // 如果不是乘法，则认为是除法
        }
    }

    /**
     * 访问规则分支 : expr (ADD|SUB) expr                 # AddSub // 加减表达式
     *
     * @param ctx
     * @return
     */
    @Override
    public TypedData visitAddSub(ZYMBOLParser.AddSubContext ctx) {
        NumericData left = (NumericData) visit(ctx.expr(0));  // 加减表达值 左操作数
        NumericData right = (NumericData) visit(ctx.expr(1)); // 加减表达值 右操作数
        if (ctx.ADD() != null) {
            return left.add(right); // 加法的情况
        } else if (ctx.SUB() != null) {
            return left.subtract(right); // 减法的情况
        } else {
            return left.add(right);
        }
    }

    /**
     * 访问规则分支 : expr (GT|GE|LT|LE|EQ|NE|NE_2) expr   # NumericalComparator // 数字比较表达式(结果是布尔值)
     *
     * @param ctx
     * @return
     */
    @Override
    public TypedData visitNumericalComparator(ZYMBOLParser.NumericalComparatorContext ctx) {
        NumericData left = (NumericData) visit(ctx.expr(0));
        NumericData right = (NumericData) visit(ctx.expr(1));


        boolean value = false;

        if (ctx.GT() != null) {
            // >操作符
            value = left.isGreaterThan(right);
        } else if (ctx.GT() != null) {
            // >=操作符
            value = left.isGreaterThanOrEqualTo(right);
        } else if (ctx.EQ() != null) {
            // ==操作符
            value = left.isEqualTo(right);
        } else if (ctx.LE() != null) {
            // <=操作符
            value = left.isLessThanOrEqualTo(right);
        } else if (ctx.LT() != null) {
            // <操作符
            value = left.isLessThan(right);
        } else {
            // != 操作符 , <> 操作符
            value = left.isNotEqualTo(right);
        }

        BooleanData data = BooleanData.of(value);
        return data;
    }

    /**
     * 访问规则分支 : expr (AND) expr                      # BooleanAnd // 布尔变量的二元操作表达式AND(结果是布尔值)
     *
     * @param ctx
     * @return
     */
    @Override
    public TypedData visitBooleanAnd(ZYMBOLParser.BooleanAndContext ctx) {
        BooleanData left = (BooleanData) visit(ctx.expr(0));
        BooleanData right = (BooleanData) visit(ctx.expr(1));


        return left.and(right);
    }

    /**
     * 访问规则分支 : expr (OR) expr                      # BooleanOr // 布尔变量的二元操作表达式OR(结果是布尔值)
     *
     * @param ctx
     * @return
     */
    @Override
    public TypedData visitBooleanOr(ZYMBOLParser.BooleanOrContext ctx) {
        BooleanData left = (BooleanData) visit(ctx.expr(0));
        BooleanData right = (BooleanData) visit(ctx.expr(1));


        return left.or(right);
    }

    /**
     * 访问规则分支 : '!'expr                              # BooleanNot // 布尔值取反(结果是布尔值)
     *
     * @param ctx
     * @return
     */
    @Override
    public TypedData visitBooleanNot(ZYMBOLParser.BooleanNotContext ctx) {
        BooleanData booleanData = (BooleanData) visit(ctx.expr());

        return booleanData.not();
    }

    /**
     * 访问规则分支 : '-'expr                              # NumericNegative // 数值取负数(结果是数值)
     *
     * @param ctx
     * @return
     */
    @Override
    public TypedData visitNumericNegative(ZYMBOLParser.NumericNegativeContext ctx) {
        NumericData numericData = (NumericData) visit(ctx.expr());

        return numericData.negate();
    }

    /**
     * 访问规则分支 : expr (CONCAT) expr                   # StringConcatenation // 拼接字符串(结果是字符串)
     *
     * @param ctx
     * @return
     */

    @Override
    public TypedData visitStringConcatenation(ZYMBOLParser.StringConcatenationContext ctx) {
        StringData left = (StringData) visit(ctx.expr(0)); // 字符串拼接 左操作数
        StringData right = (StringData) visit(ctx.expr(1)); // 字符串拼接 右操作数

        StringData result = StringData.of(left).concatenate(right);
        return result;
    }

    /**
     * 访问规则分支 : ID                                   # Variable // 引用其他变量
     *
     * @param ctx
     * @return
     */
    @Override
    public TypedData visitVariable(ZYMBOLParser.VariableContext ctx) {
        String variableName = ctx.getText();

        if (variables.containsKey(variableName))
            // 这是一个已经定义的变量
            return variables.get(variableName);

        throw new RuntimeException("未定义的变量 : " + variableName);
    }

    /**
     * 访问规则分支 : FLOAT     # FloatLiteral // 直接是一个浮点数字面值
     *
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
     * 访问规则分支 : INT # IntLiteral // 直接是一个整数字面值
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
     * 访问规则分支 :  '('expr')'                           # Parenthesis // ()表达式,提升优先级
     *
     * @param ctx
     * @return
     */
    @Override
    public TypedData visitParenthesis(ZYMBOLParser.ParenthesisContext ctx) {
        ZYMBOLParser.ExprContext exprContext = ctx.expr();
        return visit(exprContext);
    }

    /**
     * 访问规则分支 : STRING     // 直接是一个字符串字面值
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

        // 简易处理转义字符 : \\ ==> \
        value = value.replace("\\\\", "\\");

        // 简易处理转义字符 : \" ==> "
        value = value.replace("\\\"", "\"");

        return StringData.of(value);
    }

    /**
     * 访问规则分支 : 'true'      # BooleanTrueLiteral     // 布尔变量真值字面值
     *
     * @param ctx
     * @return
     */
    @Override
    public TypedData visitBooleanTrueLiteral(ZYMBOLParser.BooleanTrueLiteralContext ctx) {
        return BooleanData.TRUE;
    }

    /**
     * 访问规则分支 : 'false'                   # BooleanFalseLiteral    // 布尔变量假值字面值
     *
     * @param ctx
     * @return
     */
    @Override
    public TypedData visitBooleanFalseLiteral(ZYMBOLParser.BooleanFalseLiteralContext ctx) {
        return BooleanData.FALSE;
    }
}
