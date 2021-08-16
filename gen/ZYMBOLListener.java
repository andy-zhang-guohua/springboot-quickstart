// Generated from D:/idea_wks/springboot-quickstart/src\ZYMBOL.g4 by ANTLR 4.9.1

    package andy.zymbol;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ZYMBOLParser}.
 */
public interface ZYMBOLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ZYMBOLParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ZYMBOLParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZYMBOLParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ZYMBOLParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Print}
	 * labeled alternative in {@link ZYMBOLParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterPrint(ZYMBOLParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Print}
	 * labeled alternative in {@link ZYMBOLParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitPrint(ZYMBOLParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link ZYMBOLParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign(ZYMBOLParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link ZYMBOLParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign(ZYMBOLParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Blank}
	 * labeled alternative in {@link ZYMBOLParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterBlank(ZYMBOLParser.BlankContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Blank}
	 * labeled alternative in {@link ZYMBOLParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitBlank(ZYMBOLParser.BlankContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionNumerical}
	 * labeled alternative in {@link ZYMBOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpressionNumerical(ZYMBOLParser.ExpressionNumericalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionNumerical}
	 * labeled alternative in {@link ZYMBOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpressionNumerical(ZYMBOLParser.ExpressionNumericalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionString}
	 * labeled alternative in {@link ZYMBOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpressionString(ZYMBOLParser.ExpressionStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionString}
	 * labeled alternative in {@link ZYMBOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpressionString(ZYMBOLParser.ExpressionStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ZYMBOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariable(ZYMBOLParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ZYMBOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariable(ZYMBOLParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link ZYMBOLParser#exprNumerical}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(ZYMBOLParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link ZYMBOLParser#exprNumerical}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(ZYMBOLParser.ParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link ZYMBOLParser#exprNumerical}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(ZYMBOLParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link ZYMBOLParser#exprNumerical}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(ZYMBOLParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link ZYMBOLParser#exprNumerical}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(ZYMBOLParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link ZYMBOLParser#exprNumerical}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(ZYMBOLParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumericalLiteral}
	 * labeled alternative in {@link ZYMBOLParser#exprNumerical}.
	 * @param ctx the parse tree
	 */
	void enterNumericalLiteral(ZYMBOLParser.NumericalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumericalLiteral}
	 * labeled alternative in {@link ZYMBOLParser#exprNumerical}.
	 * @param ctx the parse tree
	 */
	void exitNumericalLiteral(ZYMBOLParser.NumericalLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link ZYMBOLParser#exprString}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(ZYMBOLParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link ZYMBOLParser#exprString}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(ZYMBOLParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringConcatenation}
	 * labeled alternative in {@link ZYMBOLParser#exprString}.
	 * @param ctx the parse tree
	 */
	void enterStringConcatenation(ZYMBOLParser.StringConcatenationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringConcatenation}
	 * labeled alternative in {@link ZYMBOLParser#exprString}.
	 * @param ctx the parse tree
	 */
	void exitStringConcatenation(ZYMBOLParser.StringConcatenationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZYMBOLParser#valueNumerical}.
	 * @param ctx the parse tree
	 */
	void enterValueNumerical(ZYMBOLParser.ValueNumericalContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZYMBOLParser#valueNumerical}.
	 * @param ctx the parse tree
	 */
	void exitValueNumerical(ZYMBOLParser.ValueNumericalContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZYMBOLParser#valueString}.
	 * @param ctx the parse tree
	 */
	void enterValueString(ZYMBOLParser.ValueStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZYMBOLParser#valueString}.
	 * @param ctx the parse tree
	 */
	void exitValueString(ZYMBOLParser.ValueStringContext ctx);
}