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
	 * Enter a parse tree produced by the {@code print}
	 * labeled alternative in {@link ZYMBOLParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterPrint(ZYMBOLParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code print}
	 * labeled alternative in {@link ZYMBOLParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitPrint(ZYMBOLParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link ZYMBOLParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign(ZYMBOLParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link ZYMBOLParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign(ZYMBOLParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blank}
	 * labeled alternative in {@link ZYMBOLParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterBlank(ZYMBOLParser.BlankContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link ZYMBOLParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitBlank(ZYMBOLParser.BlankContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link ZYMBOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(ZYMBOLParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link ZYMBOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(ZYMBOLParser.ParenthesisContext ctx);
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
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link ZYMBOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(ZYMBOLParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link ZYMBOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(ZYMBOLParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link ZYMBOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(ZYMBOLParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link ZYMBOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(ZYMBOLParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Literal}
	 * labeled alternative in {@link ZYMBOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(ZYMBOLParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Literal}
	 * labeled alternative in {@link ZYMBOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(ZYMBOLParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZYMBOLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(ZYMBOLParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZYMBOLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(ZYMBOLParser.ValueContext ctx);
}