// Generated from D:/idea_wks/springboot-quickstart/src\ZYMBOL.g4 by ANTLR 4.9.1

    package andy.zymbol;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ZYMBOLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, MUL=5, DIV=6, ADD=7, SUB=8, ID=9, INT=10, 
		FLOAT=11, STRING=12, LINE_COMMENT=13, COMMENT=14, SEMICOLON=15, WS=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "MUL", "DIV", "ADD", "SUB", "ID", "INT", 
			"FLOAT", "STRING", "LINE_COMMENT", "COMMENT", "SEMICOLON", "WS", "ALPHA", 
			"DIGIT", "ESC"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'print'", "'='", "'('", "')'", "'*'", "'/'", "'+'", "'-'", null, 
			null, null, null, null, null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "MUL", "DIV", "ADD", "SUB", "ID", "INT", 
			"FLOAT", "STRING", "LINE_COMMENT", "COMMENT", "SEMICOLON", "WS"
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


	public ZYMBOLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ZYMBOL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\22\u00a7\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\7\nA\n\n\f\n\16\nD\13"+
		"\n\3\13\5\13G\n\13\3\13\3\13\7\13K\n\13\f\13\16\13N\13\13\3\13\5\13Q\n"+
		"\13\3\f\5\fT\n\f\3\f\6\fW\n\f\r\f\16\fX\3\f\3\f\7\f]\n\f\f\f\16\f`\13"+
		"\f\3\f\5\fc\n\f\3\f\3\f\6\fg\n\f\r\f\16\fh\5\fk\n\f\3\r\3\r\3\r\7\rp\n"+
		"\r\f\r\16\rs\13\r\3\r\3\r\3\16\3\16\3\16\3\16\7\16{\n\16\f\16\16\16~\13"+
		"\16\3\16\5\16\u0081\n\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\7\17"+
		"\u008b\n\17\f\17\16\17\u008e\13\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\21\6\21\u0098\n\21\r\21\16\21\u0099\3\21\3\21\3\22\3\22\3\23\3\23\3"+
		"\24\3\24\3\24\3\24\5\24\u00a6\n\24\5q|\u008c\2\25\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\2%\2\'\2\3"+
		"\2\6\3\2\63;\3\2\62;\5\2\13\f\17\17\"\"\5\2C\\aac|\2\u00b5\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3)\3\2\2\2\5/\3\2\2"+
		"\2\7\61\3\2\2\2\t\63\3\2\2\2\13\65\3\2\2\2\r\67\3\2\2\2\179\3\2\2\2\21"+
		";\3\2\2\2\23=\3\2\2\2\25P\3\2\2\2\27j\3\2\2\2\31l\3\2\2\2\33v\3\2\2\2"+
		"\35\u0086\3\2\2\2\37\u0094\3\2\2\2!\u0097\3\2\2\2#\u009d\3\2\2\2%\u009f"+
		"\3\2\2\2\'\u00a5\3\2\2\2)*\7r\2\2*+\7t\2\2+,\7k\2\2,-\7p\2\2-.\7v\2\2"+
		".\4\3\2\2\2/\60\7?\2\2\60\6\3\2\2\2\61\62\7*\2\2\62\b\3\2\2\2\63\64\7"+
		"+\2\2\64\n\3\2\2\2\65\66\7,\2\2\66\f\3\2\2\2\678\7\61\2\28\16\3\2\2\2"+
		"9:\7-\2\2:\20\3\2\2\2;<\7/\2\2<\22\3\2\2\2=B\5#\22\2>A\5#\22\2?A\5%\23"+
		"\2@>\3\2\2\2@?\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2C\24\3\2\2\2DB\3\2"+
		"\2\2EG\7/\2\2FE\3\2\2\2FG\3\2\2\2GH\3\2\2\2HL\t\2\2\2IK\t\3\2\2JI\3\2"+
		"\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MQ\3\2\2\2NL\3\2\2\2OQ\7\62\2\2PF\3"+
		"\2\2\2PO\3\2\2\2Q\26\3\2\2\2RT\7/\2\2SR\3\2\2\2ST\3\2\2\2TV\3\2\2\2UW"+
		"\5%\23\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z^\7\60\2\2"+
		"[]\5%\23\2\\[\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_k\3\2\2\2`^\3\2\2"+
		"\2ac\7/\2\2ba\3\2\2\2bc\3\2\2\2cd\3\2\2\2df\7\60\2\2eg\5%\23\2fe\3\2\2"+
		"\2gh\3\2\2\2hf\3\2\2\2hi\3\2\2\2ik\3\2\2\2jS\3\2\2\2jb\3\2\2\2k\30\3\2"+
		"\2\2lq\7$\2\2mp\5\'\24\2np\13\2\2\2om\3\2\2\2on\3\2\2\2ps\3\2\2\2qr\3"+
		"\2\2\2qo\3\2\2\2rt\3\2\2\2sq\3\2\2\2tu\7$\2\2u\32\3\2\2\2vw\7\61\2\2w"+
		"x\7\61\2\2x|\3\2\2\2y{\13\2\2\2zy\3\2\2\2{~\3\2\2\2|}\3\2\2\2|z\3\2\2"+
		"\2}\u0080\3\2\2\2~|\3\2\2\2\177\u0081\7\17\2\2\u0080\177\3\2\2\2\u0080"+
		"\u0081\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083\7\f\2\2\u0083\u0084\3\2"+
		"\2\2\u0084\u0085\b\16\2\2\u0085\34\3\2\2\2\u0086\u0087\7\61\2\2\u0087"+
		"\u0088\7,\2\2\u0088\u008c\3\2\2\2\u0089\u008b\13\2\2\2\u008a\u0089\3\2"+
		"\2\2\u008b\u008e\3\2\2\2\u008c\u008d\3\2\2\2\u008c\u008a\3\2\2\2\u008d"+
		"\u008f\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\7,\2\2\u0090\u0091\7\61"+
		"\2\2\u0091\u0092\3\2\2\2\u0092\u0093\b\17\2\2\u0093\36\3\2\2\2\u0094\u0095"+
		"\7=\2\2\u0095 \3\2\2\2\u0096\u0098\t\4\2\2\u0097\u0096\3\2\2\2\u0098\u0099"+
		"\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\u009c\b\21\2\2\u009c\"\3\2\2\2\u009d\u009e\t\5\2\2\u009e$\3\2\2\2\u009f"+
		"\u00a0\t\3\2\2\u00a0&\3\2\2\2\u00a1\u00a2\7^\2\2\u00a2\u00a6\7$\2\2\u00a3"+
		"\u00a4\7^\2\2\u00a4\u00a6\7^\2\2\u00a5\u00a1\3\2\2\2\u00a5\u00a3\3\2\2"+
		"\2\u00a6(\3\2\2\2\25\2@BFLPSX^bhjoq|\u0080\u008c\u0099\u00a5\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}