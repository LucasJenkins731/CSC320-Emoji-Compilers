// Generated from Emoticon.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class EmoticonLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KW_READ=1, KW_PRINT=2, KW_IF=3, KW_ELSE=4, KW_ELSE_IF=5, IDENT=6, ADD=7, 
		SUBTRACT=8, MULTIPLY=9, DIVIDE=10, INT=11, WS=12, LPAREN=13, RPAREN=14, 
		COMMENT=15, COMMENT_BLOCK=16, COMPARISON=17, ASSIGNMENT=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"KW_READ", "KW_PRINT", "KW_IF", "KW_ELSE", "KW_ELSE_IF", "IDENT", "ADD", 
			"SUBTRACT", "MULTIPLY", "DIVIDE", "INT", "WS", "LPAREN", "RPAREN", "COMMENT", 
			"COMMENT_BLOCK", "COMPARISON", "ASSIGNMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'-0-0-'", "':P'", "':)'", "':('", "':|'", null, "':+)'", "':-)'", 
			"':*)'", "':/)'", null, null, "'('", "')'", null, null, "':==)'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "KW_READ", "KW_PRINT", "KW_IF", "KW_ELSE", "KW_ELSE_IF", "IDENT", 
			"ADD", "SUBTRACT", "MULTIPLY", "DIVIDE", "INT", "WS", "LPAREN", "RPAREN", 
			"COMMENT", "COMMENT_BLOCK", "COMPARISON", "ASSIGNMENT"
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


	public EmoticonLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Emoticon.g4"; }

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
		"\u0004\u0000\u0012\u0083\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0005\u0005:\b\u0005\n\u0005\f\u0005=\t\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0003\nP\b\n\u0001\n\u0001\n\u0001\n\u0005"+
		"\nU\b\n\n\n\f\nX\t\n\u0003\nZ\b\n\u0001\u000b\u0004\u000b]\b\u000b\u000b"+
		"\u000b\f\u000b^\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000ek\b\u000e"+
		"\n\u000e\f\u000en\t\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0000\u0000\u0012\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d"+
		"\u000f\u001f\u0010!\u0011#\u0012\u0001\u0000\b\u0003\u0000AZ__az\u0004"+
		"\u000009AZ__az\u0002\u0000++--\u0001\u000019\u0001\u000009\u0003\u0000"+
		"\t\n\r\r  \u0002\u0000\n\n\r\r\u0002\u0000**..\u0088\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000"+
		"\u0000#\u0001\u0000\u0000\u0000\u0001%\u0001\u0000\u0000\u0000\u0003+"+
		"\u0001\u0000\u0000\u0000\u0005.\u0001\u0000\u0000\u0000\u00071\u0001\u0000"+
		"\u0000\u0000\t4\u0001\u0000\u0000\u0000\u000b7\u0001\u0000\u0000\u0000"+
		"\r>\u0001\u0000\u0000\u0000\u000fB\u0001\u0000\u0000\u0000\u0011F\u0001"+
		"\u0000\u0000\u0000\u0013J\u0001\u0000\u0000\u0000\u0015O\u0001\u0000\u0000"+
		"\u0000\u0017\\\u0001\u0000\u0000\u0000\u0019b\u0001\u0000\u0000\u0000"+
		"\u001bd\u0001\u0000\u0000\u0000\u001df\u0001\u0000\u0000\u0000\u001fq"+
		"\u0001\u0000\u0000\u0000!|\u0001\u0000\u0000\u0000#\u0081\u0001\u0000"+
		"\u0000\u0000%&\u0005-\u0000\u0000&\'\u00050\u0000\u0000\'(\u0005-\u0000"+
		"\u0000()\u00050\u0000\u0000)*\u0005-\u0000\u0000*\u0002\u0001\u0000\u0000"+
		"\u0000+,\u0005:\u0000\u0000,-\u0005P\u0000\u0000-\u0004\u0001\u0000\u0000"+
		"\u0000./\u0005:\u0000\u0000/0\u0005)\u0000\u00000\u0006\u0001\u0000\u0000"+
		"\u000012\u0005:\u0000\u000023\u0005(\u0000\u00003\b\u0001\u0000\u0000"+
		"\u000045\u0005:\u0000\u000056\u0005|\u0000\u00006\n\u0001\u0000\u0000"+
		"\u00007;\u0007\u0000\u0000\u00008:\u0007\u0001\u0000\u000098\u0001\u0000"+
		"\u0000\u0000:=\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000;<\u0001"+
		"\u0000\u0000\u0000<\f\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000"+
		">?\u0005:\u0000\u0000?@\u0005+\u0000\u0000@A\u0005)\u0000\u0000A\u000e"+
		"\u0001\u0000\u0000\u0000BC\u0005:\u0000\u0000CD\u0005-\u0000\u0000DE\u0005"+
		")\u0000\u0000E\u0010\u0001\u0000\u0000\u0000FG\u0005:\u0000\u0000GH\u0005"+
		"*\u0000\u0000HI\u0005)\u0000\u0000I\u0012\u0001\u0000\u0000\u0000JK\u0005"+
		":\u0000\u0000KL\u0005/\u0000\u0000LM\u0005)\u0000\u0000M\u0014\u0001\u0000"+
		"\u0000\u0000NP\u0007\u0002\u0000\u0000ON\u0001\u0000\u0000\u0000OP\u0001"+
		"\u0000\u0000\u0000PY\u0001\u0000\u0000\u0000QZ\u00050\u0000\u0000RV\u0007"+
		"\u0003\u0000\u0000SU\u0007\u0004\u0000\u0000TS\u0001\u0000\u0000\u0000"+
		"UX\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000"+
		"\u0000WZ\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000YQ\u0001\u0000"+
		"\u0000\u0000YR\u0001\u0000\u0000\u0000Z\u0016\u0001\u0000\u0000\u0000"+
		"[]\u0007\u0005\u0000\u0000\\[\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000"+
		"\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_`\u0001\u0000"+
		"\u0000\u0000`a\u0006\u000b\u0000\u0000a\u0018\u0001\u0000\u0000\u0000"+
		"bc\u0005(\u0000\u0000c\u001a\u0001\u0000\u0000\u0000de\u0005)\u0000\u0000"+
		"e\u001c\u0001\u0000\u0000\u0000fg\u0005<\u0000\u0000gh\u00053\u0000\u0000"+
		"hl\u0001\u0000\u0000\u0000ik\b\u0006\u0000\u0000ji\u0001\u0000\u0000\u0000"+
		"kn\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000"+
		"\u0000mo\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000op\u0006\u000e"+
		"\u0000\u0000p\u001e\u0001\u0000\u0000\u0000qr\u0005O\u0000\u0000rs\u0005"+
		"W\u0000\u0000st\u0005O\u0000\u0000tu\u0001\u0000\u0000\u0000uv\u0007\u0007"+
		"\u0000\u0000vw\u0005U\u0000\u0000wx\u0005W\u0000\u0000xy\u0005U\u0000"+
		"\u0000yz\u0001\u0000\u0000\u0000z{\u0006\u000f\u0000\u0000{ \u0001\u0000"+
		"\u0000\u0000|}\u0005:\u0000\u0000}~\u0005=\u0000\u0000~\u007f\u0005=\u0000"+
		"\u0000\u007f\u0080\u0005)\u0000\u0000\u0080\"\u0001\u0000\u0000\u0000"+
		"\u0081\u0082\u0005=\u0000\u0000\u0082$\u0001\u0000\u0000\u0000\u0007\u0000"+
		";OVY^l\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}