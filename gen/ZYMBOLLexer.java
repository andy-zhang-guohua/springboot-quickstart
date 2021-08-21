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
		ID=10, INT=11, FLOAT=12, STRING=13, SEMICOLON=14, WS=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "MUL", "DIV", "ADD", "SUB", "CONCAT", 
			"ID", "INT", "FLOAT", "STRING", "SEMICOLON", "WS", "ALPHA", "DIGIT", 
			"ESC"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'print'", "'='", "'('", "')'", "'*'", "'/'", "'+'", "'-'", "'..'", 
			null, null, null, null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "MUL", "DIV", "ADD", "SUB", "CONCAT", "ID", 
			"INT", "FLOAT", "STRING", "SEMICOLON", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\21\u008a\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3"+
		"\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\7\13B\n\13\f\13"+
		"\16\13E\13\13\3\f\5\fH\n\f\3\f\3\f\7\fL\n\f\f\f\16\fO\13\f\3\f\5\fR\n"+
		"\f\3\r\5\rU\n\r\3\r\6\rX\n\r\r\r\16\rY\3\r\3\r\7\r^\n\r\f\r\16\ra\13\r"+
		"\3\r\5\rd\n\r\3\r\3\r\6\rh\n\r\r\r\16\ri\5\rl\n\r\3\16\3\16\3\16\7\16"+
		"q\n\16\f\16\16\16t\13\16\3\16\3\16\3\17\3\17\3\20\6\20{\n\20\r\20\16\20"+
		"|\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\5\23\u0089\n\23\3"+
		"r\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\2#\2%\2\3\2\6\3\2\63;\3\2\62;\5\2\13\f\17\17\"\"\5\2C\\"+
		"aac|\2\u0095\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\3\'\3"+
		"\2\2\2\5-\3\2\2\2\7/\3\2\2\2\t\61\3\2\2\2\13\63\3\2\2\2\r\65\3\2\2\2\17"+
		"\67\3\2\2\2\219\3\2\2\2\23;\3\2\2\2\25>\3\2\2\2\27Q\3\2\2\2\31k\3\2\2"+
		"\2\33m\3\2\2\2\35w\3\2\2\2\37z\3\2\2\2!\u0080\3\2\2\2#\u0082\3\2\2\2%"+
		"\u0088\3\2\2\2\'(\7r\2\2()\7t\2\2)*\7k\2\2*+\7p\2\2+,\7v\2\2,\4\3\2\2"+
		"\2-.\7?\2\2.\6\3\2\2\2/\60\7*\2\2\60\b\3\2\2\2\61\62\7+\2\2\62\n\3\2\2"+
		"\2\63\64\7,\2\2\64\f\3\2\2\2\65\66\7\61\2\2\66\16\3\2\2\2\678\7-\2\28"+
		"\20\3\2\2\29:\7/\2\2:\22\3\2\2\2;<\7\60\2\2<=\7\60\2\2=\24\3\2\2\2>C\5"+
		"!\21\2?B\5!\21\2@B\5#\22\2A?\3\2\2\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3"+
		"\2\2\2D\26\3\2\2\2EC\3\2\2\2FH\7/\2\2GF\3\2\2\2GH\3\2\2\2HI\3\2\2\2IM"+
		"\t\2\2\2JL\t\3\2\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NR\3\2\2\2O"+
		"M\3\2\2\2PR\7\62\2\2QG\3\2\2\2QP\3\2\2\2R\30\3\2\2\2SU\7/\2\2TS\3\2\2"+
		"\2TU\3\2\2\2UW\3\2\2\2VX\5#\22\2WV\3\2\2\2XY\3\2\2\2YW\3\2\2\2YZ\3\2\2"+
		"\2Z[\3\2\2\2[_\7\60\2\2\\^\5#\22\2]\\\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3"+
		"\2\2\2`l\3\2\2\2a_\3\2\2\2bd\7/\2\2cb\3\2\2\2cd\3\2\2\2de\3\2\2\2eg\7"+
		"\60\2\2fh\5#\22\2gf\3\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3\2\2\2jl\3\2\2\2kT"+
		"\3\2\2\2kc\3\2\2\2l\32\3\2\2\2mr\7$\2\2nq\5%\23\2oq\13\2\2\2pn\3\2\2\2"+
		"po\3\2\2\2qt\3\2\2\2rs\3\2\2\2rp\3\2\2\2su\3\2\2\2tr\3\2\2\2uv\7$\2\2"+
		"v\34\3\2\2\2wx\7=\2\2x\36\3\2\2\2y{\t\4\2\2zy\3\2\2\2{|\3\2\2\2|z\3\2"+
		"\2\2|}\3\2\2\2}~\3\2\2\2~\177\b\20\2\2\177 \3\2\2\2\u0080\u0081\t\5\2"+
		"\2\u0081\"\3\2\2\2\u0082\u0083\t\3\2\2\u0083$\3\2\2\2\u0084\u0085\7^\2"+
		"\2\u0085\u0089\7$\2\2\u0086\u0087\7^\2\2\u0087\u0089\7^\2\2\u0088\u0084"+
		"\3\2\2\2\u0088\u0086\3\2\2\2\u0089&\3\2\2\2\22\2ACGMQTY_cikpr|\u0088\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}