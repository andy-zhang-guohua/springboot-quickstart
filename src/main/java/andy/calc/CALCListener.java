// Generated from D:/idea_wks/springboot-quickstart/src\CALC.g4 by ANTLR 4.9.1

    package andy.calc;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CALCParser}.
 */
public interface CALCListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CALCParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CALCParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CALCParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CALCParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code print}
	 * labeled alternative in {@link CALCParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterPrint(CALCParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code print}
	 * labeled alternative in {@link CALCParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitPrint(CALCParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link CALCParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign(CALCParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link CALCParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign(CALCParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blank}
	 * labeled alternative in {@link CALCParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterBlank(CALCParser.BlankContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link CALCParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitBlank(CALCParser.BlankContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link CALCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(CALCParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link CALCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(CALCParser.ParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link CALCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariable(CALCParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link CALCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariable(CALCParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link CALCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(CALCParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link CALCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(CALCParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link CALCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(CALCParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link CALCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(CALCParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntLiteral}
	 * labeled alternative in {@link CALCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIntLiteral(CALCParser.IntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntLiteral}
	 * labeled alternative in {@link CALCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIntLiteral(CALCParser.IntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CALCParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(CALCParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CALCParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(CALCParser.ValueContext ctx);
}