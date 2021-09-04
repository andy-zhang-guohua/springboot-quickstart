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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, MUL=8, DIV=9, 
		ADD=10, SUB=11, GT=12, GE=13, LT=14, LE=15, EQ=16, NE=17, NE_2=18, AND=19, 
		OR=20, CONCAT=21, ID=22, INT=23, FLOAT=24, STRING=25, LINE_COMMENT=26, 
		COMMENT=27, SEMICOLON=28, WS=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "MUL", "DIV", 
			"ADD", "SUB", "GT", "GE", "LT", "LE", "EQ", "NE", "NE_2", "AND", "OR", 
			"CONCAT", "ID", "INT", "FLOAT", "STRING", "LINE_COMMENT", "COMMENT", 
			"SEMICOLON", "WS", "ALPHA", "DIGIT", "ESC"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\37\u00e1\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\7\27\u0084\n\27\f\27\16\27\u0087\13\27\3\30\3\30\7\30"+
		"\u008b\n\30\f\30\16\30\u008e\13\30\3\30\5\30\u0091\n\30\3\31\6\31\u0094"+
		"\n\31\r\31\16\31\u0095\3\31\3\31\7\31\u009a\n\31\f\31\16\31\u009d\13\31"+
		"\3\31\3\31\6\31\u00a1\n\31\r\31\16\31\u00a2\5\31\u00a5\n\31\3\32\3\32"+
		"\3\32\7\32\u00aa\n\32\f\32\16\32\u00ad\13\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\7\33\u00b5\n\33\f\33\16\33\u00b8\13\33\3\33\5\33\u00bb\n\33\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\7\34\u00c5\n\34\f\34\16\34\u00c8\13"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\36\6\36\u00d2\n\36\r\36\16\36"+
		"\u00d3\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3!\3!\5!\u00e0\n!\5\u00ab\u00b6"+
		"\u00c6\2\"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37=\2?\2A\2\3\2\6\3\2\63;\3\2\62;\5\2\13\f\17\17\"\"\5\2C\\a"+
		"ac|\2\u00ec\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\3C\3\2\2\2\5I\3\2\2\2\7K\3\2\2\2\tM\3\2\2\2\13O\3\2\2"+
		"\2\rQ\3\2\2\2\17V\3\2\2\2\21\\\3\2\2\2\23^\3\2\2\2\25`\3\2\2\2\27b\3\2"+
		"\2\2\31d\3\2\2\2\33f\3\2\2\2\35i\3\2\2\2\37k\3\2\2\2!n\3\2\2\2#q\3\2\2"+
		"\2%t\3\2\2\2\'w\3\2\2\2)z\3\2\2\2+}\3\2\2\2-\u0080\3\2\2\2/\u0090\3\2"+
		"\2\2\61\u00a4\3\2\2\2\63\u00a6\3\2\2\2\65\u00b0\3\2\2\2\67\u00c0\3\2\2"+
		"\29\u00ce\3\2\2\2;\u00d1\3\2\2\2=\u00d7\3\2\2\2?\u00d9\3\2\2\2A\u00df"+
		"\3\2\2\2CD\7r\2\2DE\7t\2\2EF\7k\2\2FG\7p\2\2GH\7v\2\2H\4\3\2\2\2IJ\7?"+
		"\2\2J\6\3\2\2\2KL\7#\2\2L\b\3\2\2\2MN\7*\2\2N\n\3\2\2\2OP\7+\2\2P\f\3"+
		"\2\2\2QR\7v\2\2RS\7t\2\2ST\7w\2\2TU\7g\2\2U\16\3\2\2\2VW\7h\2\2WX\7c\2"+
		"\2XY\7n\2\2YZ\7u\2\2Z[\7g\2\2[\20\3\2\2\2\\]\7,\2\2]\22\3\2\2\2^_\7\61"+
		"\2\2_\24\3\2\2\2`a\7-\2\2a\26\3\2\2\2bc\7/\2\2c\30\3\2\2\2de\7@\2\2e\32"+
		"\3\2\2\2fg\7@\2\2gh\7?\2\2h\34\3\2\2\2ij\7>\2\2j\36\3\2\2\2kl\7>\2\2l"+
		"m\7?\2\2m \3\2\2\2no\7?\2\2op\7?\2\2p\"\3\2\2\2qr\7#\2\2rs\7?\2\2s$\3"+
		"\2\2\2tu\7>\2\2uv\7@\2\2v&\3\2\2\2wx\7(\2\2xy\7(\2\2y(\3\2\2\2z{\7~\2"+
		"\2{|\7~\2\2|*\3\2\2\2}~\7\60\2\2~\177\7\60\2\2\177,\3\2\2\2\u0080\u0085"+
		"\5=\37\2\u0081\u0084\5=\37\2\u0082\u0084\5? \2\u0083\u0081\3\2\2\2\u0083"+
		"\u0082\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2"+
		"\2\2\u0086.\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u008c\t\2\2\2\u0089\u008b"+
		"\t\3\2\2\u008a\u0089\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\u0091\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0091\7\62"+
		"\2\2\u0090\u0088\3\2\2\2\u0090\u008f\3\2\2\2\u0091\60\3\2\2\2\u0092\u0094"+
		"\5? \2\u0093\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0093\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u009b\7\60\2\2\u0098\u009a\5"+
		"? \2\u0099\u0098\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\u00a5\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u00a0\7\60"+
		"\2\2\u009f\u00a1\5? \2\u00a0\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a0"+
		"\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a5\3\2\2\2\u00a4\u0093\3\2\2\2\u00a4"+
		"\u009e\3\2\2\2\u00a5\62\3\2\2\2\u00a6\u00ab\7$\2\2\u00a7\u00aa\5A!\2\u00a8"+
		"\u00aa\13\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ad\3"+
		"\2\2\2\u00ab\u00ac\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad"+
		"\u00ab\3\2\2\2\u00ae\u00af\7$\2\2\u00af\64\3\2\2\2\u00b0\u00b1\7\61\2"+
		"\2\u00b1\u00b2\7\61\2\2\u00b2\u00b6\3\2\2\2\u00b3\u00b5\13\2\2\2\u00b4"+
		"\u00b3\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b6\u00b4\3\2"+
		"\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00bb\7\17\2\2\u00ba"+
		"\u00b9\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\7\f"+
		"\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\b\33\2\2\u00bf\66\3\2\2\2\u00c0\u00c1"+
		"\7\61\2\2\u00c1\u00c2\7,\2\2\u00c2\u00c6\3\2\2\2\u00c3\u00c5\13\2\2\2"+
		"\u00c4\u00c3\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c6\u00c4"+
		"\3\2\2\2\u00c7\u00c9\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00ca\7,\2\2\u00ca"+
		"\u00cb\7\61\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\b\34\2\2\u00cd8\3\2\2"+
		"\2\u00ce\u00cf\7=\2\2\u00cf:\3\2\2\2\u00d0\u00d2\t\4\2\2\u00d1\u00d0\3"+
		"\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"\u00d5\3\2\2\2\u00d5\u00d6\b\36\2\2\u00d6<\3\2\2\2\u00d7\u00d8\t\5\2\2"+
		"\u00d8>\3\2\2\2\u00d9\u00da\t\3\2\2\u00da@\3\2\2\2\u00db\u00dc\7^\2\2"+
		"\u00dc\u00e0\7$\2\2\u00dd\u00de\7^\2\2\u00de\u00e0\7^\2\2\u00df\u00db"+
		"\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0B\3\2\2\2\22\2\u0083\u0085\u008c\u0090"+
		"\u0095\u009b\u00a2\u00a4\u00a9\u00ab\u00b6\u00ba\u00c6\u00d3\u00df\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}