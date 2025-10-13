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
		KW_INT=15, KW_STRING=16, KW_CHAR=17, IDENT=18, ADD=19, SUBTRACT=20, MULTIPLY=21, 
		DIVIDE=22, INT=23, CHAR=24, STRING=25, WS=26, LPAREN=27, RPAREN=28, COMMENT=29, 
		COMMENT_BLOCK=30, COMPARISON=31, ASSIGNMENT=32;
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
			"KW_INT", "KW_STRING", "KW_CHAR", "IDENT", "ADD", "SUBTRACT", "MULTIPLY", 
			"DIVIDE", "INT", "CHAR", "STRING", "WS", "LPAREN", "RPAREN", "COMMENT", 
			"COMMENT_BLOCK", "COMPARISON", "ASSIGNMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'['", "']'", "'-0-0-'", "':P'", "':)'", "':('", "':|'", 
			"'>:('", "'D:<'", "'=^._.^='", "'(o_o)'", "'><(((,^>'", "'<^,)))><'", 
			"'int'", "'string'", "'char'", null, "':+)'", "':-)'", "':*)'", "':/)'", 
			null, null, null, null, "'('", "')'", null, null, "':==)'", "':=)'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "KW_READ", "KW_PRINT", "KW_IF", "KW_ELSE", "KW_ELSE_IF", 
			"KW_FOR", "KW_WHILE", "KW_FUNCTION", "KW_ARRAY", "LBRACE", "RBRACE", 
			"KW_INT", "KW_STRING", "KW_CHAR", "IDENT", "ADD", "SUBTRACT", "MULTIPLY", 
			"DIVIDE", "INT", "CHAR", "STRING", "WS", "LPAREN", "RPAREN", "COMMENT", 
			"COMMENT_BLOCK", "COMPARISON", "ASSIGNMENT"
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



	  enum Type {
	    INT, STRING, CHAR, UNKNOWN
	  }

	  class Identifier {
	    String id;
	    Object value; //This line should be an object since we dont know its type can vary.
	    Type type; //Type of the value
	    boolean hasKnown; // is the variable known when calling it i think
	    boolean hasBeenUsed; // used for error checks for if the variable has been used.
	  }

	  class SymbolTable {
	    Map<String, Identifier> table = new HashMap<>();
	  }
	  SymbolTable mainTable = new SymbolTable();

	    Stack<SymbolTable> symbolStack = new Stack<>(); // I feel like a linked list might work better here. stack seems weird.
	    //WE SHOULD MAKE THE DATATYPE INSIDE THE 'STACK' A DATATYPE THAT HAS A .CONTAINS OR .HAS METHOD. THIS WAY WE CAN CALL THIS METHOD ON THE ARRAY/DATASTRUCTURE AS A WHOLE
	    //THIS WILL SAVE A LOT OF TIME AND EFFORT WITH NESTED FOR LOOPS.
	    //linked list will probably work best for this.
	    // diagnostics
	    List<String> diagnostics = new ArrayList<>();
	    // lhs stuff
	    String pendingLHS = null;
	    // error stuff
	    boolean lhsExistedBefore = false;
	    
	    void error(Token t, String msg) {
	        diagnostics.add("line " + t.getLine() + ":" + t.getCharPositionInLine() + " " + msg);
	    }

	    void printDiagnostics() {
	      for (String d : diagnostics) {
	        System.err.println("error: " + d);
	      }
	    }
	//SHOULD BE CALLED IN ASSIGNMENT STATEMENT AND WHEN CALLING VARIABLES.
	//NVM WHEN CALLING VARIABLES WE SHOULD BE SAVING THE TYPE OF THE VARIABLE IN THE IDENTIFIER CLASS AND THEREFORE DONT NEED TO DO THAT.
	    Type typeCheck(String text) {
	      Type varType = Type.UNKNOWN;
	      if (text.matches("[+-]?(0|[1-9][0-9]*)")) {
	        varType = Type.INT;
	      } else if (text.matches("'(\\\\.|[^\\\\'])'")){
	        varType = Type.CHAR;
	      } else if (text.matches("(['\"']).*?(['\"])")) {
	        varType = Type.STRING;
	      }
	      return varType;
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
		"\u0004\u0000 \u00fd\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0005\u0011\u0094\b\u0011\n\u0011\f\u0011\u0097"+
		"\t\u0011\u0001\u0011\u0001\u0011\u0004\u0011\u009b\b\u0011\u000b\u0011"+
		"\f\u0011\u009c\u0003\u0011\u009f\b\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0016\u0003\u0016\u00b2\b\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0005\u0016\u00b7\b\u0016\n\u0016\f\u0016\u00ba\t\u0016"+
		"\u0003\u0016\u00bc\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0003\u0017\u00c2\b\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018"+
		"\u0005\u0018\u00c8\b\u0018\n\u0018\f\u0018\u00cb\t\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0019\u0004\u0019\u00d0\b\u0019\u000b\u0019\f\u0019\u00d1"+
		"\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u00de\b\u001c"+
		"\n\u001c\f\u001c\u00e1\t\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u00ea\b\u001d\n"+
		"\u001d\f\u001d\u00ed\t\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0002"+
		"\u00c9\u00eb\u0000 \u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t"+
		"\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f"+
		"\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014"+
		")\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e"+
		"=\u001f? \u0001\u0000\n\u0002\u0000AZaz\u0004\u000009AZ__az\u0001\u0000"+
		"__\u0002\u0000++--\u0001\u000019\u0001\u000009\u0002\u0000\'\'\\\\\u0002"+
		"\u0000\"\"\'\'\u0003\u0000\t\n\r\r  \u0002\u0000\n\n\r\r\u0107\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000"+
		"\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000"+
		"\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000"+
		"\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001"+
		"\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000"+
		"\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u0000"+
		"5\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001"+
		"\u0000\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000"+
		"\u0000\u0000?\u0001\u0000\u0000\u0000\u0001A\u0001\u0000\u0000\u0000\u0003"+
		"C\u0001\u0000\u0000\u0000\u0005E\u0001\u0000\u0000\u0000\u0007G\u0001"+
		"\u0000\u0000\u0000\tM\u0001\u0000\u0000\u0000\u000bP\u0001\u0000\u0000"+
		"\u0000\rS\u0001\u0000\u0000\u0000\u000fV\u0001\u0000\u0000\u0000\u0011"+
		"Y\u0001\u0000\u0000\u0000\u0013]\u0001\u0000\u0000\u0000\u0015a\u0001"+
		"\u0000\u0000\u0000\u0017i\u0001\u0000\u0000\u0000\u0019o\u0001\u0000\u0000"+
		"\u0000\u001bx\u0001\u0000\u0000\u0000\u001d\u0081\u0001\u0000\u0000\u0000"+
		"\u001f\u0085\u0001\u0000\u0000\u0000!\u008c\u0001\u0000\u0000\u0000#\u009e"+
		"\u0001\u0000\u0000\u0000%\u00a0\u0001\u0000\u0000\u0000\'\u00a4\u0001"+
		"\u0000\u0000\u0000)\u00a8\u0001\u0000\u0000\u0000+\u00ac\u0001\u0000\u0000"+
		"\u0000-\u00b1\u0001\u0000\u0000\u0000/\u00bd\u0001\u0000\u0000\u00001"+
		"\u00c5\u0001\u0000\u0000\u00003\u00cf\u0001\u0000\u0000\u00005\u00d5\u0001"+
		"\u0000\u0000\u00007\u00d7\u0001\u0000\u0000\u00009\u00d9\u0001\u0000\u0000"+
		"\u0000;\u00e4\u0001\u0000\u0000\u0000=\u00f4\u0001\u0000\u0000\u0000?"+
		"\u00f9\u0001\u0000\u0000\u0000AB\u0005;\u0000\u0000B\u0002\u0001\u0000"+
		"\u0000\u0000CD\u0005[\u0000\u0000D\u0004\u0001\u0000\u0000\u0000EF\u0005"+
		"]\u0000\u0000F\u0006\u0001\u0000\u0000\u0000GH\u0005-\u0000\u0000HI\u0005"+
		"0\u0000\u0000IJ\u0005-\u0000\u0000JK\u00050\u0000\u0000KL\u0005-\u0000"+
		"\u0000L\b\u0001\u0000\u0000\u0000MN\u0005:\u0000\u0000NO\u0005P\u0000"+
		"\u0000O\n\u0001\u0000\u0000\u0000PQ\u0005:\u0000\u0000QR\u0005)\u0000"+
		"\u0000R\f\u0001\u0000\u0000\u0000ST\u0005:\u0000\u0000TU\u0005(\u0000"+
		"\u0000U\u000e\u0001\u0000\u0000\u0000VW\u0005:\u0000\u0000WX\u0005|\u0000"+
		"\u0000X\u0010\u0001\u0000\u0000\u0000YZ\u0005>\u0000\u0000Z[\u0005:\u0000"+
		"\u0000[\\\u0005(\u0000\u0000\\\u0012\u0001\u0000\u0000\u0000]^\u0005D"+
		"\u0000\u0000^_\u0005:\u0000\u0000_`\u0005<\u0000\u0000`\u0014\u0001\u0000"+
		"\u0000\u0000ab\u0005=\u0000\u0000bc\u0005^\u0000\u0000cd\u0005.\u0000"+
		"\u0000de\u0005_\u0000\u0000ef\u0005.\u0000\u0000fg\u0005^\u0000\u0000"+
		"gh\u0005=\u0000\u0000h\u0016\u0001\u0000\u0000\u0000ij\u0005(\u0000\u0000"+
		"jk\u0005o\u0000\u0000kl\u0005_\u0000\u0000lm\u0005o\u0000\u0000mn\u0005"+
		")\u0000\u0000n\u0018\u0001\u0000\u0000\u0000op\u0005>\u0000\u0000pq\u0005"+
		"<\u0000\u0000qr\u0005(\u0000\u0000rs\u0005(\u0000\u0000st\u0005(\u0000"+
		"\u0000tu\u0005,\u0000\u0000uv\u0005^\u0000\u0000vw\u0005>\u0000\u0000"+
		"w\u001a\u0001\u0000\u0000\u0000xy\u0005<\u0000\u0000yz\u0005^\u0000\u0000"+
		"z{\u0005,\u0000\u0000{|\u0005)\u0000\u0000|}\u0005)\u0000\u0000}~\u0005"+
		")\u0000\u0000~\u007f\u0005>\u0000\u0000\u007f\u0080\u0005<\u0000\u0000"+
		"\u0080\u001c\u0001\u0000\u0000\u0000\u0081\u0082\u0005i\u0000\u0000\u0082"+
		"\u0083\u0005n\u0000\u0000\u0083\u0084\u0005t\u0000\u0000\u0084\u001e\u0001"+
		"\u0000\u0000\u0000\u0085\u0086\u0005s\u0000\u0000\u0086\u0087\u0005t\u0000"+
		"\u0000\u0087\u0088\u0005r\u0000\u0000\u0088\u0089\u0005i\u0000\u0000\u0089"+
		"\u008a\u0005n\u0000\u0000\u008a\u008b\u0005g\u0000\u0000\u008b \u0001"+
		"\u0000\u0000\u0000\u008c\u008d\u0005c\u0000\u0000\u008d\u008e\u0005h\u0000"+
		"\u0000\u008e\u008f\u0005a\u0000\u0000\u008f\u0090\u0005r\u0000\u0000\u0090"+
		"\"\u0001\u0000\u0000\u0000\u0091\u0095\u0007\u0000\u0000\u0000\u0092\u0094"+
		"\u0007\u0001\u0000\u0000\u0093\u0092\u0001\u0000\u0000\u0000\u0094\u0097"+
		"\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0095\u0096"+
		"\u0001\u0000\u0000\u0000\u0096\u009f\u0001\u0000\u0000\u0000\u0097\u0095"+
		"\u0001\u0000\u0000\u0000\u0098\u009a\u0007\u0002\u0000\u0000\u0099\u009b"+
		"\u0007\u0001\u0000\u0000\u009a\u0099\u0001\u0000\u0000\u0000\u009b\u009c"+
		"\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009c\u009d"+
		"\u0001\u0000\u0000\u0000\u009d\u009f\u0001\u0000\u0000\u0000\u009e\u0091"+
		"\u0001\u0000\u0000\u0000\u009e\u0098\u0001\u0000\u0000\u0000\u009f$\u0001"+
		"\u0000\u0000\u0000\u00a0\u00a1\u0005:\u0000\u0000\u00a1\u00a2\u0005+\u0000"+
		"\u0000\u00a2\u00a3\u0005)\u0000\u0000\u00a3&\u0001\u0000\u0000\u0000\u00a4"+
		"\u00a5\u0005:\u0000\u0000\u00a5\u00a6\u0005-\u0000\u0000\u00a6\u00a7\u0005"+
		")\u0000\u0000\u00a7(\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005:\u0000"+
		"\u0000\u00a9\u00aa\u0005*\u0000\u0000\u00aa\u00ab\u0005)\u0000\u0000\u00ab"+
		"*\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005:\u0000\u0000\u00ad\u00ae\u0005"+
		"/\u0000\u0000\u00ae\u00af\u0005)\u0000\u0000\u00af,\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b2\u0007\u0003\u0000\u0000\u00b1\u00b0\u0001\u0000\u0000"+
		"\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00bb\u0001\u0000\u0000"+
		"\u0000\u00b3\u00bc\u00050\u0000\u0000\u00b4\u00b8\u0007\u0004\u0000\u0000"+
		"\u00b5\u00b7\u0007\u0005\u0000\u0000\u00b6\u00b5\u0001\u0000\u0000\u0000"+
		"\u00b7\u00ba\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000"+
		"\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9\u00bc\u0001\u0000\u0000\u0000"+
		"\u00ba\u00b8\u0001\u0000\u0000\u0000\u00bb\u00b3\u0001\u0000\u0000\u0000"+
		"\u00bb\u00b4\u0001\u0000\u0000\u0000\u00bc.\u0001\u0000\u0000\u0000\u00bd"+
		"\u00c1\u0005\'\u0000\u0000\u00be\u00bf\u0005\\\u0000\u0000\u00bf\u00c2"+
		"\t\u0000\u0000\u0000\u00c0\u00c2\b\u0006\u0000\u0000\u00c1\u00be\u0001"+
		"\u0000\u0000\u0000\u00c1\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001"+
		"\u0000\u0000\u0000\u00c3\u00c4\u0005\'\u0000\u0000\u00c40\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c9\u0007\u0007\u0000\u0000\u00c6\u00c8\t\u0000\u0000"+
		"\u0000\u00c7\u00c6\u0001\u0000\u0000\u0000\u00c8\u00cb\u0001\u0000\u0000"+
		"\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000"+
		"\u0000\u00ca\u00cc\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000"+
		"\u0000\u00cc\u00cd\u0007\u0007\u0000\u0000\u00cd2\u0001\u0000\u0000\u0000"+
		"\u00ce\u00d0\u0007\b\u0000\u0000\u00cf\u00ce\u0001\u0000\u0000\u0000\u00d0"+
		"\u00d1\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d1"+
		"\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3"+
		"\u00d4\u0006\u0019\u0000\u0000\u00d44\u0001\u0000\u0000\u0000\u00d5\u00d6"+
		"\u0005(\u0000\u0000\u00d66\u0001\u0000\u0000\u0000\u00d7\u00d8\u0005)"+
		"\u0000\u0000\u00d88\u0001\u0000\u0000\u0000\u00d9\u00da\u0005<\u0000\u0000"+
		"\u00da\u00db\u00053\u0000\u0000\u00db\u00df\u0001\u0000\u0000\u0000\u00dc"+
		"\u00de\b\t\u0000\u0000\u00dd\u00dc\u0001\u0000\u0000\u0000\u00de\u00e1"+
		"\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00df\u00e0"+
		"\u0001\u0000\u0000\u0000\u00e0\u00e2\u0001\u0000\u0000\u0000\u00e1\u00df"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e3\u0006\u001c\u0000\u0000\u00e3:\u0001"+
		"\u0000\u0000\u0000\u00e4\u00e5\u0005O\u0000\u0000\u00e5\u00e6\u0005W\u0000"+
		"\u0000\u00e6\u00e7\u0005O\u0000\u0000\u00e7\u00eb\u0001\u0000\u0000\u0000"+
		"\u00e8\u00ea\t\u0000\u0000\u0000\u00e9\u00e8\u0001\u0000\u0000\u0000\u00ea"+
		"\u00ed\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000\u0000\u0000\u00eb"+
		"\u00e9\u0001\u0000\u0000\u0000\u00ec\u00ee\u0001\u0000\u0000\u0000\u00ed"+
		"\u00eb\u0001\u0000\u0000\u0000\u00ee\u00ef\u0005U\u0000\u0000\u00ef\u00f0"+
		"\u0005W\u0000\u0000\u00f0\u00f1\u0005U\u0000\u0000\u00f1\u00f2\u0001\u0000"+
		"\u0000\u0000\u00f2\u00f3\u0006\u001d\u0000\u0000\u00f3<\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f5\u0005:\u0000\u0000\u00f5\u00f6\u0005=\u0000\u0000\u00f6"+
		"\u00f7\u0005=\u0000\u0000\u00f7\u00f8\u0005)\u0000\u0000\u00f8>\u0001"+
		"\u0000\u0000\u0000\u00f9\u00fa\u0005:\u0000\u0000\u00fa\u00fb\u0005=\u0000"+
		"\u0000\u00fb\u00fc\u0005)\u0000\u0000\u00fc@\u0001\u0000\u0000\u0000\f"+
		"\u0000\u0095\u009c\u009e\u00b1\u00b8\u00bb\u00c1\u00c9\u00d1\u00df\u00eb"+
		"\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}