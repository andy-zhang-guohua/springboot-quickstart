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
		T__0=1, T__1=2, T__2=3, T__3=4, MUL=5, DIV=6, ADD=7, SUB=8, CONCAT=9, 
		ID=10, INT=11, FLOAT=12, STRING=13, LINE_COMMENT=14, COMMENT=15, SEMICOLON=16, 
		WS=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "MUL", "DIV", "ADD", "SUB", "CONCAT", 
			"ID", "INT", "FLOAT", "STRING", "LINE_COMMENT", "COMMENT", "SEMICOLON", 
			"WS", "ALPHA", "DIGIT", "ESC"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23\u00ac\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3"+
		"\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\7\13F\n\13\f\13\16\13I\13\13\3\f\5\fL\n\f\3\f\3\f\7\fP\n\f\f\f\16"+
		"\fS\13\f\3\f\5\fV\n\f\3\r\5\rY\n\r\3\r\6\r\\\n\r\r\r\16\r]\3\r\3\r\7\r"+
		"b\n\r\f\r\16\re\13\r\3\r\5\rh\n\r\3\r\3\r\6\rl\n\r\r\r\16\rm\5\rp\n\r"+
		"\3\16\3\16\3\16\7\16u\n\16\f\16\16\16x\13\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\7\17\u0080\n\17\f\17\16\17\u0083\13\17\3\17\5\17\u0086\n\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\7\20\u0090\n\20\f\20\16\20\u0093\13"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\6\22\u009d\n\22\r\22\16\22"+
		"\u009e\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\5\25\u00ab\n"+
		"\25\5v\u0081\u0091\2\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\2\'\2)\2\3\2\6\3\2\63;\3\2\62;"+
		"\5\2\13\f\17\17\"\"\5\2C\\aac|\2\u00ba\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\3+\3\2\2\2\5\61\3\2\2\2\7\63"+
		"\3\2\2\2\t\65\3\2\2\2\13\67\3\2\2\2\r9\3\2\2\2\17;\3\2\2\2\21=\3\2\2\2"+
		"\23?\3\2\2\2\25B\3\2\2\2\27U\3\2\2\2\31o\3\2\2\2\33q\3\2\2\2\35{\3\2\2"+
		"\2\37\u008b\3\2\2\2!\u0099\3\2\2\2#\u009c\3\2\2\2%\u00a2\3\2\2\2\'\u00a4"+
		"\3\2\2\2)\u00aa\3\2\2\2+,\7r\2\2,-\7t\2\2-.\7k\2\2./\7p\2\2/\60\7v\2\2"+
		"\60\4\3\2\2\2\61\62\7?\2\2\62\6\3\2\2\2\63\64\7*\2\2\64\b\3\2\2\2\65\66"+
		"\7+\2\2\66\n\3\2\2\2\678\7,\2\28\f\3\2\2\29:\7\61\2\2:\16\3\2\2\2;<\7"+
		"-\2\2<\20\3\2\2\2=>\7/\2\2>\22\3\2\2\2?@\7\60\2\2@A\7\60\2\2A\24\3\2\2"+
		"\2BG\5%\23\2CF\5%\23\2DF\5\'\24\2EC\3\2\2\2ED\3\2\2\2FI\3\2\2\2GE\3\2"+
		"\2\2GH\3\2\2\2H\26\3\2\2\2IG\3\2\2\2JL\7/\2\2KJ\3\2\2\2KL\3\2\2\2LM\3"+
		"\2\2\2MQ\t\2\2\2NP\t\3\2\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RV\3"+
		"\2\2\2SQ\3\2\2\2TV\7\62\2\2UK\3\2\2\2UT\3\2\2\2V\30\3\2\2\2WY\7/\2\2X"+
		"W\3\2\2\2XY\3\2\2\2Y[\3\2\2\2Z\\\5\'\24\2[Z\3\2\2\2\\]\3\2\2\2][\3\2\2"+
		"\2]^\3\2\2\2^_\3\2\2\2_c\7\60\2\2`b\5\'\24\2a`\3\2\2\2be\3\2\2\2ca\3\2"+
		"\2\2cd\3\2\2\2dp\3\2\2\2ec\3\2\2\2fh\7/\2\2gf\3\2\2\2gh\3\2\2\2hi\3\2"+
		"\2\2ik\7\60\2\2jl\5\'\24\2kj\3\2\2\2lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2np\3"+
		"\2\2\2oX\3\2\2\2og\3\2\2\2p\32\3\2\2\2qv\7$\2\2ru\5)\25\2su\13\2\2\2t"+
		"r\3\2\2\2ts\3\2\2\2ux\3\2\2\2vw\3\2\2\2vt\3\2\2\2wy\3\2\2\2xv\3\2\2\2"+
		"yz\7$\2\2z\34\3\2\2\2{|\7\61\2\2|}\7\61\2\2}\u0081\3\2\2\2~\u0080\13\2"+
		"\2\2\177~\3\2\2\2\u0080\u0083\3\2\2\2\u0081\u0082\3\2\2\2\u0081\177\3"+
		"\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0086\7\17\2\2\u0085"+
		"\u0084\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\7\f"+
		"\2\2\u0088\u0089\3\2\2\2\u0089\u008a\b\17\2\2\u008a\36\3\2\2\2\u008b\u008c"+
		"\7\61\2\2\u008c\u008d\7,\2\2\u008d\u0091\3\2\2\2\u008e\u0090\13\2\2\2"+
		"\u008f\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u0092\3\2\2\2\u0091\u008f"+
		"\3\2\2\2\u0092\u0094\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0095\7,\2\2\u0095"+
		"\u0096\7\61\2\2\u0096\u0097\3\2\2\2\u0097\u0098\b\20\2\2\u0098 \3\2\2"+
		"\2\u0099\u009a\7=\2\2\u009a\"\3\2\2\2\u009b\u009d\t\4\2\2\u009c\u009b"+
		"\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\u00a1\b\22\2\2\u00a1$\3\2\2\2\u00a2\u00a3\t\5\2\2"+
		"\u00a3&\3\2\2\2\u00a4\u00a5\t\3\2\2\u00a5(\3\2\2\2\u00a6\u00a7\7^\2\2"+
		"\u00a7\u00ab\7$\2\2\u00a8\u00a9\7^\2\2\u00a9\u00ab\7^\2\2\u00aa\u00a6"+
		"\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab*\3\2\2\2\25\2EGKQUX]cgmotv\u0081\u0085"+
		"\u0091\u009e\u00aa\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}