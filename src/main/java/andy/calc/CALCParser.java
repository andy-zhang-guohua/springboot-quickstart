package andy.calc;
// Generated from D:/idea_wks/springboot-quickstart/src\CALC.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CALCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, MULTIPLY=5, DIVIDE=6, PLUS=7, MINUS=8, 
		ID=9, INT=10, NEWLINE=11, WS=12;
	public static final int
		RULE_program = 0, RULE_stat = 1, RULE_expr = 2, RULE_value = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "stat", "expr", "value"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'print'", "'='", "'('", "')'", "'*'", "'/'", "'+'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "MULTIPLY", "DIVIDE", "PLUS", "MINUS", 
			"ID", "INT", "NEWLINE", "WS"
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
	public String getGrammarFileName() { return "CALC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CALCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CALCListener ) ((CALCListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CALCListener ) ((CALCListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CALCVisitor ) return ((CALCVisitor<? extends T>)visitor).visitProgram(this);
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
			setState(9); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(8);
				stat();
				}
				}
				setState(11); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << ID) | (1L << NEWLINE))) != 0) );
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

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(CALCParser.NEWLINE, 0); }
		public PrintContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CALCListener ) ((CALCListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CALCListener ) ((CALCListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CALCVisitor ) return ((CALCVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlankContext extends StatContext {
		public TerminalNode NEWLINE() { return getToken(CALCParser.NEWLINE, 0); }
		public BlankContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CALCListener ) ((CALCListener)listener).enterBlank(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CALCListener ) ((CALCListener)listener).exitBlank(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CALCVisitor ) return ((CALCVisitor<? extends T>)visitor).visitBlank(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignContext extends StatContext {
		public TerminalNode ID() { return getToken(CALCParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(CALCParser.NEWLINE, 0); }
		public AssignContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CALCListener ) ((CALCListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CALCListener ) ((CALCListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CALCVisitor ) return ((CALCVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(23);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(13);
				match(T__0);
				setState(14);
				expr(0);
				setState(15);
				match(NEWLINE);
				}
				break;
			case ID:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(17);
				match(ID);
				setState(18);
				match(T__1);
				setState(19);
				expr(0);
				setState(20);
				match(NEWLINE);
				}
				break;
			case NEWLINE:
				_localctx = new BlankContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(22);
				match(NEWLINE);
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
	public static class ParenthesisContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenthesisContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CALCListener ) ((CALCListener)listener).enterParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CALCListener ) ((CALCListener)listener).exitParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CALCVisitor ) return ((CALCVisitor<? extends T>)visitor).visitParenthesis(this);
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
		public TerminalNode MULTIPLY() { return getToken(CALCParser.MULTIPLY, 0); }
		public TerminalNode DIVIDE() { return getToken(CALCParser.DIVIDE, 0); }
		public MulDivContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CALCListener ) ((CALCListener)listener).enterMulDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CALCListener ) ((CALCListener)listener).exitMulDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CALCVisitor ) return ((CALCVisitor<? extends T>)visitor).visitMulDiv(this);
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
		public TerminalNode PLUS() { return getToken(CALCParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(CALCParser.MINUS, 0); }
		public AddSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CALCListener ) ((CALCListener)listener).enterAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CALCListener ) ((CALCListener)listener).exitAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CALCVisitor ) return ((CALCVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdIntContext extends ExprContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public IdIntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CALCListener ) ((CALCListener)listener).enterIdInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CALCListener ) ((CALCListener)listener).exitIdInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CALCVisitor ) return ((CALCVisitor<? extends T>)visitor).visitIdInt(this);
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
			setState(31);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				{
				_localctx = new ParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(26);
				match(T__2);
				setState(27);
				expr(0);
				setState(28);
				match(T__3);
				}
				break;
			case ID:
			case INT:
				{
				_localctx = new IdIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(30);
				value();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(41);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(39);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(33);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(34);
						_la = _input.LA(1);
						if ( !(_la==MULTIPLY || _la==DIVIDE) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(35);
						expr(5);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(36);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(37);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(38);
						expr(4);
						}
						break;
					}
					} 
				}
				setState(43);
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(CALCParser.INT, 0); }
		public TerminalNode ID() { return getToken(CALCParser.ID, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CALCListener ) ((CALCListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CALCListener ) ((CALCListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CALCVisitor ) return ((CALCVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==INT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\16\61\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\3\2\6\2\f\n\2\r\2\16\2\r\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\5\3\32\n\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4\"\n\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\7\4*\n\4\f\4\16\4-\13\4\3\5\3\5\3\5\2\3\6\6\2\4\6\b\2"+
		"\5\3\2\7\b\3\2\t\n\3\2\13\f\2\62\2\13\3\2\2\2\4\31\3\2\2\2\6!\3\2\2\2"+
		"\b.\3\2\2\2\n\f\5\4\3\2\13\n\3\2\2\2\f\r\3\2\2\2\r\13\3\2\2\2\r\16\3\2"+
		"\2\2\16\3\3\2\2\2\17\20\7\3\2\2\20\21\5\6\4\2\21\22\7\r\2\2\22\32\3\2"+
		"\2\2\23\24\7\13\2\2\24\25\7\4\2\2\25\26\5\6\4\2\26\27\7\r\2\2\27\32\3"+
		"\2\2\2\30\32\7\r\2\2\31\17\3\2\2\2\31\23\3\2\2\2\31\30\3\2\2\2\32\5\3"+
		"\2\2\2\33\34\b\4\1\2\34\35\7\5\2\2\35\36\5\6\4\2\36\37\7\6\2\2\37\"\3"+
		"\2\2\2 \"\5\b\5\2!\33\3\2\2\2! \3\2\2\2\"+\3\2\2\2#$\f\6\2\2$%\t\2\2\2"+
		"%*\5\6\4\7&\'\f\5\2\2\'(\t\3\2\2(*\5\6\4\6)#\3\2\2\2)&\3\2\2\2*-\3\2\2"+
		"\2+)\3\2\2\2+,\3\2\2\2,\7\3\2\2\2-+\3\2\2\2./\t\4\2\2/\t\3\2\2\2\7\r\31"+
		"!)+";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}