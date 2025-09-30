// Generated from Emoticon.g4 by ANTLR 4.13.2
 import java.util.*; 
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
		T__0=1, T__1=2, T__2=3, KW_READ=4, KW_PRINT=5, KW_IF=6, KW_ELSE=7, KW_ELSE_IF=8, 
		KW_FOR=9, KW_WHILE=10, KW_FUNCTION=11, KW_ARRAY=12, LBRACE=13, RBRACE=14, 
		IDENT=15, ADD=16, SUBTRACT=17, MULTIPLY=18, DIVIDE=19, INT=20, STRING=21, 
		WS=22, LPAREN=23, RPAREN=24, COMMENT=25, COMMENT_BLOCK=26, COMPARISON=27, 
		ASSIGNMENT=28;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "KW_READ", "KW_PRINT", "KW_IF", "KW_ELSE", "KW_ELSE_IF", 
			"KW_FOR", "KW_WHILE", "KW_FUNCTION", "KW_ARRAY", "LBRACE", "RBRACE", 
			"IDENT", "ADD", "SUBTRACT", "MULTIPLY", "DIVIDE", "INT", "STRING", "WS", 
			"LPAREN", "RPAREN", "COMMENT", "COMMENT_BLOCK", "COMPARISON", "ASSIGNMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'['", "']'", "'-0-0-'", "':P'", "':)'", "':('", "':|'", 
			"'>:('", "'D:<'", "'=^._.^='", "'(o_o)'", "'BEGIN'", "'END'", null, "':+)'", 
			"':-)'", "':*)'", "':/)'", null, null, null, "'('", "')'", null, null, 
			"':==)'", "':=)'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "KW_READ", "KW_PRINT", "KW_IF", "KW_ELSE", "KW_ELSE_IF", 
			"KW_FOR", "KW_WHILE", "KW_FUNCTION", "KW_ARRAY", "LBRACE", "RBRACE", 
			"IDENT", "ADD", "SUBTRACT", "MULTIPLY", "DIVIDE", "INT", "STRING", "WS", 
			"LPAREN", "RPAREN", "COMMENT", "COMMENT_BLOCK", "COMPARISON", "ASSIGNMENT"
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



	  class Identifier {
	    String id;
	    float value;
	    boolean hasKnown;
	    boolean hasBeenUsed;
	  }

	  Stack<SymbolTable> symbolStack = new Stack<>();

	  class SymbolTable {
	    Map<String, Identifier> table = new HashMap<>();
	  }
	    // for the variables that are assigned (self explanatory)
	    set<string> assigned = new hashTable<>();

	    //used?
	    set<string> used = new hashTable<>();
	    // diagnostics
	    set<string> diagnostics = new hashTable<>();
	    // lhs stuff
	    String pendingLHS = null;
	    // error stuff
	    boolean lhsExistedBefore = false;
	    
	    void error(Token t, String msg) {
	        diagnostics.add("line " + t.getLine() + ":" + t.getCharPositionInLine() + " " + msg);
	    }

	    void printDiagnostics() {
	      // After parsing the whole file: report unused variables and print errors.
	      for (String v : assigned) {
	        if (!used.contains(v)) {
	          System.err.println("warning: variable '" + v + "' assigned but never used");
	        }
	      }
	      for (String d : diagnostics) {
	        System.err.println("error: " + d);
	      }
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
		"\u0004\u0000\u001c\u00d5\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0005\u000et\b\u000e\n\u000e"+
		"\f\u000ew\t\u000e\u0001\u000e\u0001\u000e\u0004\u000e{\b\u000e\u000b\u000e"+
		"\f\u000e|\u0003\u000e\u007f\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0003\u0013\u0092\b\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0005\u0013\u0097\b\u0013\n\u0013\f\u0013\u009a\t\u0013\u0003"+
		"\u0013\u009c\b\u0013\u0001\u0014\u0001\u0014\u0005\u0014\u00a0\b\u0014"+
		"\n\u0014\f\u0014\u00a3\t\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0004"+
		"\u0015\u00a8\b\u0015\u000b\u0015\f\u0015\u00a9\u0001\u0015\u0001\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0005\u0018\u00b6\b\u0018\n\u0018\f\u0018\u00b9"+
		"\t\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0005\u0019\u00c2\b\u0019\n\u0019\f\u0019\u00c5\t\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0002\u00a1\u00c3\u0000\u001c\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d"+
		"\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/"+
		"\u00181\u00193\u001a5\u001b7\u001c\u0001\u0000\b\u0002\u0000AZaz\u0004"+
		"\u000009AZ__az\u0001\u0000__\u0002\u0000++--\u0001\u000019\u0001\u0000"+
		"09\u0003\u0000\t\n\r\r  \u0002\u0000\n\n\r\r\u00de\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000"+
		"#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001"+
		"\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000"+
		"\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u0000"+
		"1\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001"+
		"\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00019\u0001\u0000\u0000"+
		"\u0000\u0003;\u0001\u0000\u0000\u0000\u0005=\u0001\u0000\u0000\u0000\u0007"+
		"?\u0001\u0000\u0000\u0000\tE\u0001\u0000\u0000\u0000\u000bH\u0001\u0000"+
		"\u0000\u0000\rK\u0001\u0000\u0000\u0000\u000fN\u0001\u0000\u0000\u0000"+
		"\u0011Q\u0001\u0000\u0000\u0000\u0013U\u0001\u0000\u0000\u0000\u0015Y"+
		"\u0001\u0000\u0000\u0000\u0017a\u0001\u0000\u0000\u0000\u0019g\u0001\u0000"+
		"\u0000\u0000\u001bm\u0001\u0000\u0000\u0000\u001d~\u0001\u0000\u0000\u0000"+
		"\u001f\u0080\u0001\u0000\u0000\u0000!\u0084\u0001\u0000\u0000\u0000#\u0088"+
		"\u0001\u0000\u0000\u0000%\u008c\u0001\u0000\u0000\u0000\'\u0091\u0001"+
		"\u0000\u0000\u0000)\u009d\u0001\u0000\u0000\u0000+\u00a7\u0001\u0000\u0000"+
		"\u0000-\u00ad\u0001\u0000\u0000\u0000/\u00af\u0001\u0000\u0000\u00001"+
		"\u00b1\u0001\u0000\u0000\u00003\u00bc\u0001\u0000\u0000\u00005\u00cc\u0001"+
		"\u0000\u0000\u00007\u00d1\u0001\u0000\u0000\u00009:\u0005;\u0000\u0000"+
		":\u0002\u0001\u0000\u0000\u0000;<\u0005[\u0000\u0000<\u0004\u0001\u0000"+
		"\u0000\u0000=>\u0005]\u0000\u0000>\u0006\u0001\u0000\u0000\u0000?@\u0005"+
		"-\u0000\u0000@A\u00050\u0000\u0000AB\u0005-\u0000\u0000BC\u00050\u0000"+
		"\u0000CD\u0005-\u0000\u0000D\b\u0001\u0000\u0000\u0000EF\u0005:\u0000"+
		"\u0000FG\u0005P\u0000\u0000G\n\u0001\u0000\u0000\u0000HI\u0005:\u0000"+
		"\u0000IJ\u0005)\u0000\u0000J\f\u0001\u0000\u0000\u0000KL\u0005:\u0000"+
		"\u0000LM\u0005(\u0000\u0000M\u000e\u0001\u0000\u0000\u0000NO\u0005:\u0000"+
		"\u0000OP\u0005|\u0000\u0000P\u0010\u0001\u0000\u0000\u0000QR\u0005>\u0000"+
		"\u0000RS\u0005:\u0000\u0000ST\u0005(\u0000\u0000T\u0012\u0001\u0000\u0000"+
		"\u0000UV\u0005D\u0000\u0000VW\u0005:\u0000\u0000WX\u0005<\u0000\u0000"+
		"X\u0014\u0001\u0000\u0000\u0000YZ\u0005=\u0000\u0000Z[\u0005^\u0000\u0000"+
		"[\\\u0005.\u0000\u0000\\]\u0005_\u0000\u0000]^\u0005.\u0000\u0000^_\u0005"+
		"^\u0000\u0000_`\u0005=\u0000\u0000`\u0016\u0001\u0000\u0000\u0000ab\u0005"+
		"(\u0000\u0000bc\u0005o\u0000\u0000cd\u0005_\u0000\u0000de\u0005o\u0000"+
		"\u0000ef\u0005)\u0000\u0000f\u0018\u0001\u0000\u0000\u0000gh\u0005B\u0000"+
		"\u0000hi\u0005E\u0000\u0000ij\u0005G\u0000\u0000jk\u0005I\u0000\u0000"+
		"kl\u0005N\u0000\u0000l\u001a\u0001\u0000\u0000\u0000mn\u0005E\u0000\u0000"+
		"no\u0005N\u0000\u0000op\u0005D\u0000\u0000p\u001c\u0001\u0000\u0000\u0000"+
		"qu\u0007\u0000\u0000\u0000rt\u0007\u0001\u0000\u0000sr\u0001\u0000\u0000"+
		"\u0000tw\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000"+
		"\u0000\u0000v\u007f\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000"+
		"xz\u0007\u0002\u0000\u0000y{\u0007\u0001\u0000\u0000zy\u0001\u0000\u0000"+
		"\u0000{|\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000|}\u0001\u0000"+
		"\u0000\u0000}\u007f\u0001\u0000\u0000\u0000~q\u0001\u0000\u0000\u0000"+
		"~x\u0001\u0000\u0000\u0000\u007f\u001e\u0001\u0000\u0000\u0000\u0080\u0081"+
		"\u0005:\u0000\u0000\u0081\u0082\u0005+\u0000\u0000\u0082\u0083\u0005)"+
		"\u0000\u0000\u0083 \u0001\u0000\u0000\u0000\u0084\u0085\u0005:\u0000\u0000"+
		"\u0085\u0086\u0005-\u0000\u0000\u0086\u0087\u0005)\u0000\u0000\u0087\""+
		"\u0001\u0000\u0000\u0000\u0088\u0089\u0005:\u0000\u0000\u0089\u008a\u0005"+
		"*\u0000\u0000\u008a\u008b\u0005)\u0000\u0000\u008b$\u0001\u0000\u0000"+
		"\u0000\u008c\u008d\u0005:\u0000\u0000\u008d\u008e\u0005/\u0000\u0000\u008e"+
		"\u008f\u0005)\u0000\u0000\u008f&\u0001\u0000\u0000\u0000\u0090\u0092\u0007"+
		"\u0003\u0000\u0000\u0091\u0090\u0001\u0000\u0000\u0000\u0091\u0092\u0001"+
		"\u0000\u0000\u0000\u0092\u009b\u0001\u0000\u0000\u0000\u0093\u009c\u0005"+
		"0\u0000\u0000\u0094\u0098\u0007\u0004\u0000\u0000\u0095\u0097\u0007\u0005"+
		"\u0000\u0000\u0096\u0095\u0001\u0000\u0000\u0000\u0097\u009a\u0001\u0000"+
		"\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000"+
		"\u0000\u0000\u0099\u009c\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000"+
		"\u0000\u0000\u009b\u0093\u0001\u0000\u0000\u0000\u009b\u0094\u0001\u0000"+
		"\u0000\u0000\u009c(\u0001\u0000\u0000\u0000\u009d\u00a1\u0005\'\u0000"+
		"\u0000\u009e\u00a0\t\u0000\u0000\u0000\u009f\u009e\u0001\u0000\u0000\u0000"+
		"\u00a0\u00a3\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a1\u009f\u0001\u0000\u0000\u0000\u00a2\u00a4\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005\'\u0000\u0000\u00a5"+
		"*\u0001\u0000\u0000\u0000\u00a6\u00a8\u0007\u0006\u0000\u0000\u00a7\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u00a7"+
		"\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u00ab"+
		"\u0001\u0000\u0000\u0000\u00ab\u00ac\u0006\u0015\u0000\u0000\u00ac,\u0001"+
		"\u0000\u0000\u0000\u00ad\u00ae\u0005(\u0000\u0000\u00ae.\u0001\u0000\u0000"+
		"\u0000\u00af\u00b0\u0005)\u0000\u0000\u00b00\u0001\u0000\u0000\u0000\u00b1"+
		"\u00b2\u0005<\u0000\u0000\u00b2\u00b3\u00053\u0000\u0000\u00b3\u00b7\u0001"+
		"\u0000\u0000\u0000\u00b4\u00b6\b\u0007\u0000\u0000\u00b5\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b9\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00ba\u0001\u0000"+
		"\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00ba\u00bb\u0006\u0018"+
		"\u0000\u0000\u00bb2\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005O\u0000\u0000"+
		"\u00bd\u00be\u0005W\u0000\u0000\u00be\u00bf\u0005O\u0000\u0000\u00bf\u00c3"+
		"\u0001\u0000\u0000\u0000\u00c0\u00c2\t\u0000\u0000\u0000\u00c1\u00c0\u0001"+
		"\u0000\u0000\u0000\u00c2\u00c5\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001"+
		"\u0000\u0000\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000\u00c4\u00c6\u0001"+
		"\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c6\u00c7\u0005"+
		"U\u0000\u0000\u00c7\u00c8\u0005W\u0000\u0000\u00c8\u00c9\u0005U\u0000"+
		"\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca\u00cb\u0006\u0019\u0000"+
		"\u0000\u00cb4\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005:\u0000\u0000\u00cd"+
		"\u00ce\u0005=\u0000\u0000\u00ce\u00cf\u0005=\u0000\u0000\u00cf\u00d0\u0005"+
		")\u0000\u0000\u00d06\u0001\u0000\u0000\u0000\u00d1\u00d2\u0005:\u0000"+
		"\u0000\u00d2\u00d3\u0005=\u0000\u0000\u00d3\u00d4\u0005)\u0000\u0000\u00d4"+
		"8\u0001\u0000\u0000\u0000\u000b\u0000u|~\u0091\u0098\u009b\u00a1\u00a9"+
		"\u00b7\u00c3\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}