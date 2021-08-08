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
		FLOAT=11, SEMICOLON=12, WS=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "MUL", "DIV", "ADD", "SUB", "ID", "INT", 
			"FLOAT", "SEMICOLON", "WS", "ALPHA", "DIGIT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'print'", "'='", "'('", "')'", "'*'", "'/'", "'+'", "'-'", null, 
			null, null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "MUL", "DIV", "ADD", "SUB", "ID", "INT", 
			"FLOAT", "SEMICOLON", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\17q\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3"+
		"\n\7\n9\n\n\f\n\16\n<\13\n\3\13\5\13?\n\13\3\13\3\13\7\13C\n\13\f\13\16"+
		"\13F\13\13\3\13\5\13I\n\13\3\f\5\fL\n\f\3\f\6\fO\n\f\r\f\16\fP\3\f\3\f"+
		"\7\fU\n\f\f\f\16\fX\13\f\3\f\5\f[\n\f\3\f\3\f\6\f_\n\f\r\f\16\f`\5\fc"+
		"\n\f\3\r\3\r\3\16\6\16h\n\16\r\16\16\16i\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\2\2\21\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\2\37\2\3\2\6\3\2\63;\3\2\62;\5\2\13\f\17\17\"\"\5\2C\\aac|\2z\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\3!\3\2\2\2\5\'\3\2\2\2\7)\3\2\2\2\t+\3\2\2\2\13"+
		"-\3\2\2\2\r/\3\2\2\2\17\61\3\2\2\2\21\63\3\2\2\2\23\65\3\2\2\2\25H\3\2"+
		"\2\2\27b\3\2\2\2\31d\3\2\2\2\33g\3\2\2\2\35m\3\2\2\2\37o\3\2\2\2!\"\7"+
		"r\2\2\"#\7t\2\2#$\7k\2\2$%\7p\2\2%&\7v\2\2&\4\3\2\2\2\'(\7?\2\2(\6\3\2"+
		"\2\2)*\7*\2\2*\b\3\2\2\2+,\7+\2\2,\n\3\2\2\2-.\7,\2\2.\f\3\2\2\2/\60\7"+
		"\61\2\2\60\16\3\2\2\2\61\62\7-\2\2\62\20\3\2\2\2\63\64\7/\2\2\64\22\3"+
		"\2\2\2\65:\5\35\17\2\669\5\35\17\2\679\5\37\20\28\66\3\2\2\28\67\3\2\2"+
		"\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;\24\3\2\2\2<:\3\2\2\2=?\7/\2\2>=\3\2"+
		"\2\2>?\3\2\2\2?@\3\2\2\2@D\t\2\2\2AC\t\3\2\2BA\3\2\2\2CF\3\2\2\2DB\3\2"+
		"\2\2DE\3\2\2\2EI\3\2\2\2FD\3\2\2\2GI\7\62\2\2H>\3\2\2\2HG\3\2\2\2I\26"+
		"\3\2\2\2JL\7/\2\2KJ\3\2\2\2KL\3\2\2\2LN\3\2\2\2MO\5\37\20\2NM\3\2\2\2"+
		"OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QR\3\2\2\2RV\7\60\2\2SU\5\37\20\2TS\3\2"+
		"\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2Wc\3\2\2\2XV\3\2\2\2Y[\7/\2\2ZY\3\2"+
		"\2\2Z[\3\2\2\2[\\\3\2\2\2\\^\7\60\2\2]_\5\37\20\2^]\3\2\2\2_`\3\2\2\2"+
		"`^\3\2\2\2`a\3\2\2\2ac\3\2\2\2bK\3\2\2\2bZ\3\2\2\2c\30\3\2\2\2de\7=\2"+
		"\2e\32\3\2\2\2fh\t\4\2\2gf\3\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3\2\2\2jk\3\2"+
		"\2\2kl\b\16\2\2l\34\3\2\2\2mn\t\5\2\2n\36\3\2\2\2op\t\3\2\2p \3\2\2\2"+
		"\17\28:>DHKPVZ`bi\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}