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
		T__0=1, T__1=2, T__2=3, T__3=4, MUL=5, DIV=6, ADD=7, SUB=8, CONCAT=9, 
		ID=10, INT=11, FLOAT=12, STRING=13, LINE_COMMENT=14, COMMENT=15, SEMICOLON=16, 
		WS=17;
	public static final int
		RULE_program = 0, RULE_stmt = 1, RULE_expr = 2, RULE_exprNumerical = 3, 
		RULE_exprString = 4, RULE_valueNumerical = 5, RULE_valueString = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "stmt", "expr", "exprNumerical", "exprString", "valueNumerical", 
			"valueString"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'print'", "'='", "'('", "')'", "'*'", "'/'", "'+'", "'-'", "'..'", 
			null, null, null, null, null, null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "MUL", "DIV", "ADD", "SUB", "CONCAT", "ID", 
			"INT", "FLOAT", "STRING", "LINE_COMMENT", "COMMENT", "SEMICOLON", "WS"
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
			setState(15); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(14);
				stmt();
				}
				}
				setState(17); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << ID) | (1L << SEMICOLON))) != 0) );
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
			setState(29);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(19);
				match(T__0);
				setState(20);
				expr();
				setState(21);
				match(SEMICOLON);
				}
				break;
			case ID:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(23);
				match(ID);
				setState(24);
				match(T__1);
				setState(25);
				expr();
				setState(26);
				match(SEMICOLON);
				}
				break;
			case SEMICOLON:
				_localctx = new BlankContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(28);
				match(SEMICOLON);
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
	public static class ExpressionNumericalContext extends ExprContext {
		public ExprNumericalContext exprNumerical() {
			return getRuleContext(ExprNumericalContext.class,0);
		}
		public ExpressionNumericalContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).enterExpressionNumerical(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).exitExpressionNumerical(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZYMBOLVisitor ) return ((ZYMBOLVisitor<? extends T>)visitor).visitExpressionNumerical(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionStringContext extends ExprContext {
		public ExprStringContext exprString() {
			return getRuleContext(ExprStringContext.class,0);
		}
		public ExpressionStringContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).enterExpressionString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).exitExpressionString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZYMBOLVisitor ) return ((ZYMBOLVisitor<? extends T>)visitor).visitExpressionString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expr);
		try {
			setState(33);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new ExpressionNumericalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				exprNumerical(0);
				}
				break;
			case 2:
				_localctx = new ExpressionStringContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(32);
				exprString(0);
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

	public static class ExprNumericalContext extends ParserRuleContext {
		public ExprNumericalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprNumerical; }
	 
		public ExprNumericalContext() { }
		public void copyFrom(ExprNumericalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParenthesisContext extends ExprNumericalContext {
		public ExprNumericalContext exprNumerical() {
			return getRuleContext(ExprNumericalContext.class,0);
		}
		public ParenthesisContext(ExprNumericalContext ctx) { copyFrom(ctx); }
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
	public static class NumericalVariableContext extends ExprNumericalContext {
		public TerminalNode ID() { return getToken(ZYMBOLParser.ID, 0); }
		public NumericalVariableContext(ExprNumericalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).enterNumericalVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).exitNumericalVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZYMBOLVisitor ) return ((ZYMBOLVisitor<? extends T>)visitor).visitNumericalVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulDivContext extends ExprNumericalContext {
		public List<ExprNumericalContext> exprNumerical() {
			return getRuleContexts(ExprNumericalContext.class);
		}
		public ExprNumericalContext exprNumerical(int i) {
			return getRuleContext(ExprNumericalContext.class,i);
		}
		public TerminalNode MUL() { return getToken(ZYMBOLParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(ZYMBOLParser.DIV, 0); }
		public MulDivContext(ExprNumericalContext ctx) { copyFrom(ctx); }
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
	public static class AddSubContext extends ExprNumericalContext {
		public List<ExprNumericalContext> exprNumerical() {
			return getRuleContexts(ExprNumericalContext.class);
		}
		public ExprNumericalContext exprNumerical(int i) {
			return getRuleContext(ExprNumericalContext.class,i);
		}
		public TerminalNode ADD() { return getToken(ZYMBOLParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(ZYMBOLParser.SUB, 0); }
		public AddSubContext(ExprNumericalContext ctx) { copyFrom(ctx); }
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
	public static class NumericalLiteralContext extends ExprNumericalContext {
		public ValueNumericalContext valueNumerical() {
			return getRuleContext(ValueNumericalContext.class,0);
		}
		public NumericalLiteralContext(ExprNumericalContext ctx) { copyFrom(ctx); }
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

	public final ExprNumericalContext exprNumerical() throws RecognitionException {
		return exprNumerical(0);
	}

	private ExprNumericalContext exprNumerical(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprNumericalContext _localctx = new ExprNumericalContext(_ctx, _parentState);
		ExprNumericalContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_exprNumerical, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				{
				_localctx = new ParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(36);
				match(T__2);
				setState(37);
				exprNumerical(0);
				setState(38);
				match(T__3);
				}
				break;
			case ID:
				{
				_localctx = new NumericalVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(40);
				match(ID);
				}
				break;
			case INT:
			case FLOAT:
				{
				_localctx = new NumericalLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(41);
				valueNumerical();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(52);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(50);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExprNumericalContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exprNumerical);
						setState(44);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(45);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(46);
						exprNumerical(6);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprNumericalContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exprNumerical);
						setState(47);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(48);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(49);
						exprNumerical(5);
						}
						break;
					}
					} 
				}
				setState(54);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class ExprStringContext extends ParserRuleContext {
		public ExprStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprString; }
	 
		public ExprStringContext() { }
		public void copyFrom(ExprStringContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringLiteralContext extends ExprStringContext {
		public ValueStringContext valueString() {
			return getRuleContext(ValueStringContext.class,0);
		}
		public StringLiteralContext(ExprStringContext ctx) { copyFrom(ctx); }
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
	public static class StringConcatenationContext extends ExprStringContext {
		public List<ExprStringContext> exprString() {
			return getRuleContexts(ExprStringContext.class);
		}
		public ExprStringContext exprString(int i) {
			return getRuleContext(ExprStringContext.class,i);
		}
		public TerminalNode CONCAT() { return getToken(ZYMBOLParser.CONCAT, 0); }
		public StringConcatenationContext(ExprStringContext ctx) { copyFrom(ctx); }
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
	public static class StringVariableContext extends ExprStringContext {
		public TerminalNode ID() { return getToken(ZYMBOLParser.ID, 0); }
		public StringVariableContext(ExprStringContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).enterStringVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZYMBOLListener ) ((ZYMBOLListener)listener).exitStringVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZYMBOLVisitor ) return ((ZYMBOLVisitor<? extends T>)visitor).visitStringVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprStringContext exprString() throws RecognitionException {
		return exprString(0);
	}

	private ExprStringContext exprString(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprStringContext _localctx = new ExprStringContext(_ctx, _parentState);
		ExprStringContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_exprString, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				_localctx = new StringVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(56);
				match(ID);
				}
				break;
			case STRING:
				{
				_localctx = new StringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(57);
				valueString();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(65);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StringConcatenationContext(new ExprStringContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_exprString);
					setState(60);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					{
					setState(61);
					match(CONCAT);
					}
					setState(62);
					exprString(4);
					}
					} 
				}
				setState(67);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		enterRule(_localctx, 10, RULE_valueNumerical);
		try {
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FLOAT:
				_localctx = new FloatLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				match(FLOAT);
				}
				break;
			case INT:
				_localctx = new IntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
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
		enterRule(_localctx, 12, RULE_valueString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return exprNumerical_sempred((ExprNumericalContext)_localctx, predIndex);
		case 4:
			return exprString_sempred((ExprStringContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exprNumerical_sempred(ExprNumericalContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean exprString_sempred(ExprStringContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\23M\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\6\2\22\n\2\r\2\16\2\23"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3 \n\3\3\4\3\4\5\4$\n\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\5\5-\n\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\65\n\5\f"+
		"\5\16\58\13\5\3\6\3\6\3\6\5\6=\n\6\3\6\3\6\3\6\7\6B\n\6\f\6\16\6E\13\6"+
		"\3\7\3\7\5\7I\n\7\3\b\3\b\3\b\2\4\b\n\t\2\4\6\b\n\f\16\2\4\3\2\7\b\3\2"+
		"\t\n\2P\2\21\3\2\2\2\4\37\3\2\2\2\6#\3\2\2\2\b,\3\2\2\2\n<\3\2\2\2\fH"+
		"\3\2\2\2\16J\3\2\2\2\20\22\5\4\3\2\21\20\3\2\2\2\22\23\3\2\2\2\23\21\3"+
		"\2\2\2\23\24\3\2\2\2\24\3\3\2\2\2\25\26\7\3\2\2\26\27\5\6\4\2\27\30\7"+
		"\22\2\2\30 \3\2\2\2\31\32\7\f\2\2\32\33\7\4\2\2\33\34\5\6\4\2\34\35\7"+
		"\22\2\2\35 \3\2\2\2\36 \7\22\2\2\37\25\3\2\2\2\37\31\3\2\2\2\37\36\3\2"+
		"\2\2 \5\3\2\2\2!$\5\b\5\2\"$\5\n\6\2#!\3\2\2\2#\"\3\2\2\2$\7\3\2\2\2%"+
		"&\b\5\1\2&\'\7\5\2\2\'(\5\b\5\2()\7\6\2\2)-\3\2\2\2*-\7\f\2\2+-\5\f\7"+
		"\2,%\3\2\2\2,*\3\2\2\2,+\3\2\2\2-\66\3\2\2\2./\f\7\2\2/\60\t\2\2\2\60"+
		"\65\5\b\5\b\61\62\f\6\2\2\62\63\t\3\2\2\63\65\5\b\5\7\64.\3\2\2\2\64\61"+
		"\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67\t\3\2\2\28\66\3\2"+
		"\2\29:\b\6\1\2:=\7\f\2\2;=\5\16\b\2<9\3\2\2\2<;\3\2\2\2=C\3\2\2\2>?\f"+
		"\5\2\2?@\7\13\2\2@B\5\n\6\6A>\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\13"+
		"\3\2\2\2EC\3\2\2\2FI\7\16\2\2GI\7\r\2\2HF\3\2\2\2HG\3\2\2\2I\r\3\2\2\2"+
		"JK\7\17\2\2K\17\3\2\2\2\13\23\37#,\64\66<CH";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}