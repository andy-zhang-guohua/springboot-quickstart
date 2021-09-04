// Generated from D:/idea_wks/springboot-quickstart/src\ZYMBOL.g4 by ANTLR 4.9.1

    package andy.zymbol;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ZYMBOLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, MUL=8, DIV=9, 
		ADD=10, SUB=11, GT=12, GE=13, LT=14, LE=15, EQ=16, NE=17, NE_2=18, AND=19, 
		OR=20, CONCAT=21, ID=22, INT=23, FLOAT=24, STRING=25, LINE_COMMENT=26, 
		COMMENT=27, SEMICOLON=28, WS=29;
	public static final int
		RULE_program = 0, RULE_stmt = 1, RULE_expr = 2, RULE_valueNumerical = 3, 
		RULE_valueString = 4, RULE_valueBoolean = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "stmt", "expr", "valueNumerical", "valueString", "valueBoolean"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'print'", "'='", "'!'", "'('", "')'", "'true'", "'false'", "'*'", 
			"'/'", "'+'", "'-'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'<>'", 
			"'&&'", "'||'", "'..'", null, null, null, null, null, null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "MUL", "DIV", "ADD", 
			"SUB", "GT", "GE", "LT", "LE", "EQ", "NE", "NE_2", "AND", "OR", "CONCAT", 
			"ID", "INT", "FLOAT", "STRING", "LINE_COMMENT", "COMMENT", "SEMICOLON", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ZYMBOL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ZYMBOLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZYMBOLVisitor ) return ((ZYMBOLVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(12);
				stmt();
				}
				}
				setState(15); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__5) | (1L << T__6) | (1L << SUB) | (1L << ID) | (1L << INT) | (1L << FLOAT) | (1L << STRING) | (1L << SEMICOLON))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	 
		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BlankContext extends StmtContext {
		public TerminalNode SEMICOLON() { return getToken(ZYMBOLParser.SEMICOLON, 0); }
		public BlankContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).enterBlank(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).exitBlank(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZYMBOLVisitor ) return ((ZYMBOLVisitor<? extends T>)visitor).visitBlank(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(ZYMBOLParser.SEMICOLON, 0); }
		public PrintContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZYMBOLVisitor ) return ((ZYMBOLVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimplePrintContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(ZYMBOLParser.SEMICOLON, 0); }
		public SimplePrintContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).enterSimplePrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).exitSimplePrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZYMBOLVisitor ) return ((ZYMBOLVisitor<? extends T>)visitor).visitSimplePrint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignContext extends StmtContext {
		public TerminalNode ID() { return getToken(ZYMBOLParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(ZYMBOLParser.SEMICOLON, 0); }
		public AssignContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZYMBOLVisitor ) return ((ZYMBOLVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmt);
		try {
			setState(30);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(17);
				match(T__0);
				setState(18);
				expr(0);
				setState(19);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new SimplePrintContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(21);
				expr(0);
				setState(22);
				match(SEMICOLON);
				}
				break;
			case 3:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(24);
				match(ID);
				setState(25);
				match(T__1);
				setState(26);
				expr(0);
				setState(27);
				match(SEMICOLON);
				}
				break;
			case 4:
				_localctx = new BlankContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(29);
				match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VariableContext extends ExprContext {
		public TerminalNode ID() { return getToken(ZYMBOLParser.ID, 0); }
		public VariableContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZYMBOLVisitor ) return ((ZYMBOLVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumericNegativeContext extends ExprContext {
		public TerminalNode SUB() { return getToken(ZYMBOLParser.SUB, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NumericNegativeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).enterNumericNegative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).exitNumericNegative(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZYMBOLVisitor ) return ((ZYMBOLVisitor<? extends T>)visitor).visitNumericNegative(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulDivContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(ZYMBOLParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(ZYMBOLParser.DIV, 0); }
		public MulDivContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).enterMulDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).exitMulDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZYMBOLVisitor ) return ((ZYMBOLVisitor<? extends T>)visitor).visitMulDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ADD() { return getToken(ZYMBOLParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(ZYMBOLParser.SUB, 0); }
		public AddSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).enterAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).exitAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZYMBOLVisitor ) return ((ZYMBOLVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanLiteralContext extends ExprContext {
		public ValueBooleanContext valueBoolean() {
			return getRuleContext(ValueBooleanContext.class,0);
		}
		public BooleanLiteralContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).exitBooleanLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZYMBOLVisitor ) return ((ZYMBOLVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanOrContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(ZYMBOLParser.OR, 0); }
		public BooleanOrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).enterBooleanOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).exitBooleanOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZYMBOLVisitor ) return ((ZYMBOLVisitor<? extends T>)visitor).visitBooleanOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanNotContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BooleanNotContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).enterBooleanNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).exitBooleanNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZYMBOLVisitor ) return ((ZYMBOLVisitor<? extends T>)visitor).visitBooleanNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanAndContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(ZYMBOLParser.AND, 0); }
		public BooleanAndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).enterBooleanAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).exitBooleanAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZYMBOLVisitor ) return ((ZYMBOLVisitor<? extends T>)visitor).visitBooleanAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesisContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenthesisContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).enterParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).exitParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZYMBOLVisitor ) return ((ZYMBOLVisitor<? extends T>)visitor).visitParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringLiteralContext extends ExprContext {
		public ValueStringContext valueString() {
			return getRuleContext(ValueStringContext.class,0);
		}
		public StringLiteralContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZYMBOLVisitor ) return ((ZYMBOLVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringConcatenationContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CONCAT() { return getToken(ZYMBOLParser.CONCAT, 0); }
		public StringConcatenationContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).enterStringConcatenation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).exitStringConcatenation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZYMBOLVisitor ) return ((ZYMBOLVisitor<? extends T>)visitor).visitStringConcatenation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumericalLiteralContext extends ExprContext {
		public ValueNumericalContext valueNumerical() {
			return getRuleContext(ValueNumericalContext.class,0);
		}
		public NumericalLiteralContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).enterNumericalLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).exitNumericalLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZYMBOLVisitor ) return ((ZYMBOLVisitor<? extends T>)visitor).visitNumericalLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumericalComparatorContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode GT() { return getToken(ZYMBOLParser.GT, 0); }
		public TerminalNode GE() { return getToken(ZYMBOLParser.GE, 0); }
		public TerminalNode LT() { return getToken(ZYMBOLParser.LT, 0); }
		public TerminalNode LE() { return getToken(ZYMBOLParser.LE, 0); }
		public TerminalNode EQ() { return getToken(ZYMBOLParser.EQ, 0); }
		public TerminalNode NE() { return getToken(ZYMBOLParser.NE, 0); }
		public TerminalNode NE_2() { return getToken(ZYMBOLParser.NE_2, 0); }
		public NumericalComparatorContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).enterNumericalComparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).exitNumericalComparator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZYMBOLVisitor ) return ((ZYMBOLVisitor<? extends T>)visitor).visitNumericalComparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				{
				_localctx = new BooleanNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(33);
				match(T__2);
				setState(34);
				expr(8);
				}
				break;
			case SUB:
				{
				_localctx = new NumericNegativeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(35);
				match(SUB);
				setState(36);
				expr(7);
				}
				break;
			case T__3:
				{
				_localctx = new ParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(37);
				match(T__3);
				setState(38);
				expr(0);
				setState(39);
				match(T__4);
				}
				break;
			case ID:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(41);
				match(ID);
				}
				break;
			case INT:
			case FLOAT:
				{
				_localctx = new NumericalLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(42);
				valueNumerical();
				}
				break;
			case T__5:
			case T__6:
				{
				_localctx = new BooleanLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(43);
				valueBoolean();
				}
				break;
			case STRING:
				{
				_localctx = new StringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(44);
				valueString();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(67);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(65);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(47);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(48);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(49);
						expr(14);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(50);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(51);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(52);
						expr(13);
						}
						break;
					case 3:
						{
						_localctx = new NumericalComparatorContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(53);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(54);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << GE) | (1L << LT) | (1L << LE) | (1L << EQ) | (1L << NE) | (1L << NE_2))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(55);
						expr(12);
						}
						break;
					case 4:
						{
						_localctx = new BooleanAndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(56);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						{
						setState(57);
						match(AND);
						}
						setState(58);
						expr(11);
						}
						break;
					case 5:
						{
						_localctx = new BooleanOrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(59);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						{
						setState(60);
						match(OR);
						}
						setState(61);
						expr(10);
						}
						break;
					case 6:
						{
						_localctx = new StringConcatenationContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(62);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						{
						setState(63);
						match(CONCAT);
						}
						setState(64);
						expr(7);
						}
						break;
					}
					} 
				}
				setState(69);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ValueNumericalContext extends ParserRuleContext {
		public ValueNumericalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueNumerical; }
	 
		public ValueNumericalContext() { }
		public void copyFrom(ValueNumericalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FloatLiteralContext extends ValueNumericalContext {
		public TerminalNode FLOAT() { return getToken(ZYMBOLParser.FLOAT, 0); }
		public FloatLiteralContext(ValueNumericalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).enterFloatLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).exitFloatLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZYMBOLVisitor ) return ((ZYMBOLVisitor<? extends T>)visitor).visitFloatLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntLiteralContext extends ValueNumericalContext {
		public TerminalNode INT() { return getToken(ZYMBOLParser.INT, 0); }
		public IntLiteralContext(ValueNumericalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).enterIntLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).exitIntLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZYMBOLVisitor ) return ((ZYMBOLVisitor<? extends T>)visitor).visitIntLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueNumericalContext valueNumerical() throws RecognitionException {
		ValueNumericalContext _localctx = new ValueNumericalContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_valueNumerical);
		try {
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FLOAT:
				_localctx = new FloatLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				match(FLOAT);
				}
				break;
			case INT:
				_localctx = new IntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				match(INT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueStringContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(ZYMBOLParser.STRING, 0); }
		public ValueStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).enterValueString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).exitValueString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZYMBOLVisitor ) return ((ZYMBOLVisitor<? extends T>)visitor).visitValueString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueStringContext valueString() throws RecognitionException {
		ValueStringContext _localctx = new ValueStringContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_valueString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueBooleanContext extends ParserRuleContext {
		public ValueBooleanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueBoolean; }
	 
		public ValueBooleanContext() { }
		public void copyFrom(ValueBooleanContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BooleanTrueLiteralContext extends ValueBooleanContext {
		public BooleanTrueLiteralContext(ValueBooleanContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).enterBooleanTrueLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).exitBooleanTrueLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZYMBOLVisitor ) return ((ZYMBOLVisitor<? extends T>)visitor).visitBooleanTrueLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanFalseLiteralContext extends ValueBooleanContext {
		public BooleanFalseLiteralContext(ValueBooleanContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).enterBooleanFalseLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).exitBooleanFalseLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZYMBOLVisitor ) return ((ZYMBOLVisitor<? extends T>)visitor).visitBooleanFalseLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueBooleanContext valueBoolean() throws RecognitionException {
		ValueBooleanContext _localctx = new ValueBooleanContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_valueBoolean);
		try {
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				_localctx = new BooleanTrueLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				match(T__5);
				}
				break;
			case T__6:
				_localctx = new BooleanFalseLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				match(T__6);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\37S\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\6\2\20\n\2\r\2\16\2\21\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3!\n\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\60\n\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4D\n\4\f\4\16\4G"+
		"\13\4\3\5\3\5\5\5K\n\5\3\6\3\6\3\7\3\7\5\7Q\n\7\3\7\2\3\6\b\2\4\6\b\n"+
		"\f\2\5\3\2\n\13\3\2\f\r\3\2\16\24\2^\2\17\3\2\2\2\4 \3\2\2\2\6/\3\2\2"+
		"\2\bJ\3\2\2\2\nL\3\2\2\2\fP\3\2\2\2\16\20\5\4\3\2\17\16\3\2\2\2\20\21"+
		"\3\2\2\2\21\17\3\2\2\2\21\22\3\2\2\2\22\3\3\2\2\2\23\24\7\3\2\2\24\25"+
		"\5\6\4\2\25\26\7\36\2\2\26!\3\2\2\2\27\30\5\6\4\2\30\31\7\36\2\2\31!\3"+
		"\2\2\2\32\33\7\30\2\2\33\34\7\4\2\2\34\35\5\6\4\2\35\36\7\36\2\2\36!\3"+
		"\2\2\2\37!\7\36\2\2 \23\3\2\2\2 \27\3\2\2\2 \32\3\2\2\2 \37\3\2\2\2!\5"+
		"\3\2\2\2\"#\b\4\1\2#$\7\5\2\2$\60\5\6\4\n%&\7\r\2\2&\60\5\6\4\t\'(\7\6"+
		"\2\2()\5\6\4\2)*\7\7\2\2*\60\3\2\2\2+\60\7\30\2\2,\60\5\b\5\2-\60\5\f"+
		"\7\2.\60\5\n\6\2/\"\3\2\2\2/%\3\2\2\2/\'\3\2\2\2/+\3\2\2\2/,\3\2\2\2/"+
		"-\3\2\2\2/.\3\2\2\2\60E\3\2\2\2\61\62\f\17\2\2\62\63\t\2\2\2\63D\5\6\4"+
		"\20\64\65\f\16\2\2\65\66\t\3\2\2\66D\5\6\4\17\678\f\r\2\289\t\4\2\29D"+
		"\5\6\4\16:;\f\f\2\2;<\7\25\2\2<D\5\6\4\r=>\f\13\2\2>?\7\26\2\2?D\5\6\4"+
		"\f@A\f\b\2\2AB\7\27\2\2BD\5\6\4\tC\61\3\2\2\2C\64\3\2\2\2C\67\3\2\2\2"+
		"C:\3\2\2\2C=\3\2\2\2C@\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2F\7\3\2\2"+
		"\2GE\3\2\2\2HK\7\32\2\2IK\7\31\2\2JH\3\2\2\2JI\3\2\2\2K\t\3\2\2\2LM\7"+
		"\33\2\2M\13\3\2\2\2NQ\7\b\2\2OQ\7\t\2\2PN\3\2\2\2PO\3\2\2\2Q\r\3\2\2\2"+
		"\t\21 /CEJP";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}