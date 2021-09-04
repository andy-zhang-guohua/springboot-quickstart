// Generated from D:/idea_wks/springboot-quickstart/src\ZYMBOL.g4 by ANTLR 4.9.1

    package andy.zymbol;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ZYMBOLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ZYMBOLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ZYMBOLParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ZYMBOLParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Print}
	 * labeled alternative in {@link ZYMBOLParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(ZYMBOLParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimplePrint}
	 * labeled alternative in {@link ZYMBOLParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimplePrint(ZYMBOLParser.SimplePrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link ZYMBOLParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(ZYMBOLParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Blank}
	 * labeled alternative in {@link ZYMBOLParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlank(ZYMBOLParser.BlankContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link ZYMBOLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(ZYMBOLParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumericNegative}
	 * labeled alternative in {@link ZYMBOLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericNegative(ZYMBOLParser.NumericNegativeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link ZYMBOLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(ZYMBOLParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link ZYMBOLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(ZYMBOLParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanLiteral}
	 * labeled alternative in {@link ZYMBOLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(ZYMBOLParser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanOr}
	 * labeled alternative in {@link ZYMBOLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanOr(ZYMBOLParser.BooleanOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanNot}
	 * labeled alternative in {@link ZYMBOLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanNot(ZYMBOLParser.BooleanNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanAnd}
	 * labeled alternative in {@link ZYMBOLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanAnd(ZYMBOLParser.BooleanAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link ZYMBOLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesis(ZYMBOLParser.ParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link ZYMBOLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(ZYMBOLParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringConcatenation}
	 * labeled alternative in {@link ZYMBOLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringConcatenation(ZYMBOLParser.StringConcatenationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumericalLiteral}
	 * labeled alternative in {@link ZYMBOLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericalLiteral(ZYMBOLParser.NumericalLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumericalComparator}
	 * labeled alternative in {@link ZYMBOLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericalComparator(ZYMBOLParser.NumericalComparatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FloatLiteral}
	 * labeled alternative in {@link ZYMBOLParser#valueNumerical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatLiteral(ZYMBOLParser.FloatLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntLiteral}
	 * labeled alternative in {@link ZYMBOLParser#valueNumerical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLiteral(ZYMBOLParser.IntLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZYMBOLParser#valueString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueString(ZYMBOLParser.ValueStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanTrueLiteral}
	 * labeled alternative in {@link ZYMBOLParser#valueBoolean}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanTrueLiteral(ZYMBOLParser.BooleanTrueLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanFalseLiteral}
	 * labeled alternative in {@link ZYMBOLParser#valueBoolean}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanFalseLiteral(ZYMBOLParser.BooleanFalseLiteralContext ctx);
}