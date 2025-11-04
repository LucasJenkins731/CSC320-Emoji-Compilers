// Generated from c:/Users/pieco/Desktop/Emoticon language/Emoticon.g4 by ANTLR 4.13.1
 import java.util.*; import java.io.*; import org.antlr.v4.runtime.*; import org.antlr.v4.runtime.tree.*; 
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
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, KW_READ=4, KW_PRINT=5, KW_IF=6, KW_ELSE=7, KW_ELSE_IF=8, 
		KW_FOR=9, KW_WHILE=10, KW_FUNCTION=11, KW_ARRAY=12, LBRACE=13, RBRACE=14, 
		KW_INT=15, KW_STRING=16, KW_CHAR=17, IDENT=18, ADD=19, SUBTRACT=20, MULTIPLY=21, 
		DIVIDE=22, GREATERTHAN=23, LESSTHAN=24, GREATERTHANOREQUALTO=25, LESSTHANOREQUALTO=26, 
		INT=27, FLOAT=28, CHAR=29, STRING=30, WS=31, LPAREN=32, RPAREN=33, COMMENT=34, 
		COMMENT_BLOCK=35, COMPARISON=36, ASSIGNMENT=37;
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
			"DIVIDE", "GREATERTHAN", "LESSTHAN", "GREATERTHANOREQUALTO", "LESSTHANOREQUALTO", 
			"INT", "FLOAT", "CHAR", "STRING", "WS", "LPAREN", "RPAREN", "COMMENT", 
			"COMMENT_BLOCK", "COMPARISON", "ASSIGNMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'['", "']'", "'-0-0-'", "':P'", "':)'", "':('", "':|'", 
			"'>:('", "'D:<'", "'=^._.^='", "'(o_o)'", "'><(((,^>'", "'<^,)))><'", 
			"'int'", "'string'", "'char'", null, "':+)'", "':-)'", "':*)'", "':/)'", 
			"':>)'", "':<)'", "':>=)'", "':<=)'", null, null, null, null, null, "'('", 
			"')'", null, null, "':==)'", "':=)'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "KW_READ", "KW_PRINT", "KW_IF", "KW_ELSE", "KW_ELSE_IF", 
			"KW_FOR", "KW_WHILE", "KW_FUNCTION", "KW_ARRAY", "LBRACE", "RBRACE", 
			"KW_INT", "KW_STRING", "KW_CHAR", "IDENT", "ADD", "SUBTRACT", "MULTIPLY", 
			"DIVIDE", "GREATERTHAN", "LESSTHAN", "GREATERTHANOREQUALTO", "LESSTHANOREQUALTO", 
			"INT", "FLOAT", "CHAR", "STRING", "WS", "LPAREN", "RPAREN", "COMMENT", 
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
	    INT, FLOAT, STRING, CHAR, ARRAY, UNKNOWN
	  }

	  class ExprResult {
	    Type type;
	    float numericalValue;
	    String stringValue;
	    Boolean booleanValue;
	    boolean hasKnownValue;
	    String code;

	    ExprResult(){
	      hasKnownValue = false;
	    }

	  }

	  class Identifier {
	    String id;
	    Object value;
	    Type type;
	    boolean hasKnown;
	    boolean hasBeenUsed;
	  }

	  class SymbolTable {
	    Map<String, Identifier> table = new HashMap<>();
	  }
	  
	  class FunctionDef {
	    String name;
	    String paramName;
	    ParserRuleContext body;
	  }
	  
	  SymbolTable mainTable = new SymbolTable();
	  Stack<SymbolTable> symbolStack = new Stack<>();
	  Map<String, FunctionDef> functions = new HashMap<>();
	  
	  // Diagnostics
	  List<String> diagnostics = new ArrayList<>();

	  // for KW_READ in assignment
	  Scanner readInput = new Scanner(System.in);
	  
	  // Error tracking
	  boolean hasErrors = false;
	  
	  boolean definingFunction = false;
	  int functionDefDepth = 0;

	  void error(Token t, String msg) {
	    diagnostics.add("line " + t.getLine() + ":" + t.getCharPositionInLine() + " " + msg);
	    hasErrors = true;
	  }

	  int printDiagnostics() {    
	    if (!diagnostics.isEmpty()) {
	      for (String d : diagnostics) {
	        System.err.println(d);
	      }
	    }    
	    checkUnusedVariables();
	    return diagnostics.size();
	  }
	  
	  void checkUnusedVariables() {
	    boolean foundUnused = false;
	    
	    // Check main table
	    for (Map.Entry<String, Identifier> entry : mainTable.table.entrySet()) {
	      if (!entry.getValue().hasBeenUsed) {
	        if (!foundUnused) {
	          foundUnused = true;
	        }
	        System.err.println(entry.getKey() + " declared but never used");
	      }
	    }
	  }

	  Type typeCheck(String text) {
	    Type varType = Type.UNKNOWN;
	    if (text.matches("[+-]?(0|[1-9][0-9]*)")) {
	      varType = Type.INT;
	    } else if (text.matches("[+-]?(\\d*\\.\\d+|\\d+\\.\\d*)([eE][+-]?\\d+)?")){
	      varType = Type.FLOAT;
	    } else if (text.matches("'(\\\\.|[^\\\\'])'")){
	      varType = Type.CHAR;
	    } else if (text.matches("(['\"']).*?(['\"])")) {
	      varType = Type.STRING;
	    }
	    return varType;
	  }

	  Identifier lookupVariable(String name) {
	    for (int i = symbolStack.size() - 1; i >= 0; i--) {
	      SymbolTable table = symbolStack.get(i);
	      if (table.table.containsKey(name)) {
	        return table.table.get(name);
	      }
	    }
	    
	    if (mainTable.table.containsKey(name)) {
	      return mainTable.table.get(name);
	    }
	    
	    return null;
	  }

	  // Add variable to the current scope
	  void addVariable(Identifier id) {
	    if (symbolStack.isEmpty()) {
	      mainTable.table.put(id.id, id);
	    } else {
	      SymbolTable currentScope = symbolStack.peek();
	      currentScope.table.put(id.id, id);
	    }
	  }

	  // Check if variable exists in current scope
	  boolean existsInCurrentScope(String name) {
	    if (symbolStack.isEmpty()) {
	      return mainTable.table.containsKey(name);
	    } else {
	      return symbolStack.peek().table.containsKey(name);
	    }
	  }

	  /** Code generation material */
	  StringBuilder sb = new StringBuilder(); // Stores the generated program!

	  void emit(String s) { sb.append(s); }   // Short-hand for adding to the program

	  // Emit the preamble material for our program
	  void openProgram() {
	    emit("import java.util.*;\n");
	    emit("public class EmoticonProgramTests {\n");
	    emit("  public static void main(String[] args) throws Exception {\n");
	    emit("    Scanner in = new Scanner(System.in);\n");
	  }

	  // Emit the postamble material for our program
	  void closeProgram() {
	    emit("  }\n");
	    emit("}\n");
	  }

	  // Declare LHS if first-time assignment; otherwise plain assignment.
	  void generateAssign(boolean declare, String name, String rhsJavaCode) {
	    emit("    " + (declare ? "double " : " ") + name + " = " + rhsJavaCode + ";\n");
	  }

	  // Write the generated Java to file.
	  void writeFile() {
	    try (PrintWriter pw = new PrintWriter("EmoticonProgramTests.java", "UTF-8")) {
	      pw.print(sb.toString());
	    } catch (Exception e) {
	      System.err.println("error: failed to write EmoticonProgramTests.java: " + e.getMessage());
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
		"\u0004\u0000%\u0128\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0005\u0011\u009e\b\u0011\n\u0011"+
		"\f\u0011\u00a1\t\u0011\u0001\u0011\u0001\u0011\u0004\u0011\u00a5\b\u0011"+
		"\u000b\u0011\f\u0011\u00a6\u0003\u0011\u00a9\b\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0003\u001a\u00ce\b\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u00d3\b\u001a\n\u001a\f\u001a"+
		"\u00d6\t\u001a\u0003\u001a\u00d8\b\u001a\u0001\u001b\u0003\u001b\u00db"+
		"\b\u001b\u0001\u001b\u0005\u001b\u00de\b\u001b\n\u001b\f\u001b\u00e1\t"+
		"\u001b\u0001\u001b\u0001\u001b\u0004\u001b\u00e5\b\u001b\u000b\u001b\f"+
		"\u001b\u00e6\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c"+
		"\u00ed\b\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0005\u001d"+
		"\u00f3\b\u001d\n\u001d\f\u001d\u00f6\t\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001e\u0004\u001e\u00fb\b\u001e\u000b\u001e\f\u001e\u00fc\u0001\u001e"+
		"\u0001\u001e\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001!\u0001!\u0001"+
		"!\u0001!\u0005!\u0109\b!\n!\f!\u010c\t!\u0001!\u0001!\u0001\"\u0001\""+
		"\u0001\"\u0001\"\u0001\"\u0005\"\u0115\b\"\n\"\f\"\u0118\t\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001#\u0001#"+
		"\u0001$\u0001$\u0001$\u0001$\u0002\u00f4\u0116\u0000%\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010"+
		"!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a"+
		"5\u001b7\u001c9\u001d;\u001e=\u001f? A!C\"E#G$I%\u0001\u0000\n\u0002\u0000"+
		"AZaz\u0004\u000009AZ__az\u0001\u0000__\u0002\u0000++--\u0001\u000019\u0001"+
		"\u000009\u0002\u0000\'\'\\\\\u0002\u0000\"\"\'\'\u0003\u0000\t\n\r\r "+
		" \u0002\u0000\n\n\r\r\u0135\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000"+
		"\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000"+
		"\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-"+
		"\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000"+
		"\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000"+
		"\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;"+
		"\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000"+
		"\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000\u0000"+
		"\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000\u0000I"+
		"\u0001\u0000\u0000\u0000\u0001K\u0001\u0000\u0000\u0000\u0003M\u0001\u0000"+
		"\u0000\u0000\u0005O\u0001\u0000\u0000\u0000\u0007Q\u0001\u0000\u0000\u0000"+
		"\tW\u0001\u0000\u0000\u0000\u000bZ\u0001\u0000\u0000\u0000\r]\u0001\u0000"+
		"\u0000\u0000\u000f`\u0001\u0000\u0000\u0000\u0011c\u0001\u0000\u0000\u0000"+
		"\u0013g\u0001\u0000\u0000\u0000\u0015k\u0001\u0000\u0000\u0000\u0017s"+
		"\u0001\u0000\u0000\u0000\u0019y\u0001\u0000\u0000\u0000\u001b\u0082\u0001"+
		"\u0000\u0000\u0000\u001d\u008b\u0001\u0000\u0000\u0000\u001f\u008f\u0001"+
		"\u0000\u0000\u0000!\u0096\u0001\u0000\u0000\u0000#\u00a8\u0001\u0000\u0000"+
		"\u0000%\u00aa\u0001\u0000\u0000\u0000\'\u00ae\u0001\u0000\u0000\u0000"+
		")\u00b2\u0001\u0000\u0000\u0000+\u00b6\u0001\u0000\u0000\u0000-\u00ba"+
		"\u0001\u0000\u0000\u0000/\u00be\u0001\u0000\u0000\u00001\u00c2\u0001\u0000"+
		"\u0000\u00003\u00c7\u0001\u0000\u0000\u00005\u00cd\u0001\u0000\u0000\u0000"+
		"7\u00da\u0001\u0000\u0000\u00009\u00e8\u0001\u0000\u0000\u0000;\u00f0"+
		"\u0001\u0000\u0000\u0000=\u00fa\u0001\u0000\u0000\u0000?\u0100\u0001\u0000"+
		"\u0000\u0000A\u0102\u0001\u0000\u0000\u0000C\u0104\u0001\u0000\u0000\u0000"+
		"E\u010f\u0001\u0000\u0000\u0000G\u011f\u0001\u0000\u0000\u0000I\u0124"+
		"\u0001\u0000\u0000\u0000KL\u0005;\u0000\u0000L\u0002\u0001\u0000\u0000"+
		"\u0000MN\u0005[\u0000\u0000N\u0004\u0001\u0000\u0000\u0000OP\u0005]\u0000"+
		"\u0000P\u0006\u0001\u0000\u0000\u0000QR\u0005-\u0000\u0000RS\u00050\u0000"+
		"\u0000ST\u0005-\u0000\u0000TU\u00050\u0000\u0000UV\u0005-\u0000\u0000"+
		"V\b\u0001\u0000\u0000\u0000WX\u0005:\u0000\u0000XY\u0005P\u0000\u0000"+
		"Y\n\u0001\u0000\u0000\u0000Z[\u0005:\u0000\u0000[\\\u0005)\u0000\u0000"+
		"\\\f\u0001\u0000\u0000\u0000]^\u0005:\u0000\u0000^_\u0005(\u0000\u0000"+
		"_\u000e\u0001\u0000\u0000\u0000`a\u0005:\u0000\u0000ab\u0005|\u0000\u0000"+
		"b\u0010\u0001\u0000\u0000\u0000cd\u0005>\u0000\u0000de\u0005:\u0000\u0000"+
		"ef\u0005(\u0000\u0000f\u0012\u0001\u0000\u0000\u0000gh\u0005D\u0000\u0000"+
		"hi\u0005:\u0000\u0000ij\u0005<\u0000\u0000j\u0014\u0001\u0000\u0000\u0000"+
		"kl\u0005=\u0000\u0000lm\u0005^\u0000\u0000mn\u0005.\u0000\u0000no\u0005"+
		"_\u0000\u0000op\u0005.\u0000\u0000pq\u0005^\u0000\u0000qr\u0005=\u0000"+
		"\u0000r\u0016\u0001\u0000\u0000\u0000st\u0005(\u0000\u0000tu\u0005o\u0000"+
		"\u0000uv\u0005_\u0000\u0000vw\u0005o\u0000\u0000wx\u0005)\u0000\u0000"+
		"x\u0018\u0001\u0000\u0000\u0000yz\u0005>\u0000\u0000z{\u0005<\u0000\u0000"+
		"{|\u0005(\u0000\u0000|}\u0005(\u0000\u0000}~\u0005(\u0000\u0000~\u007f"+
		"\u0005,\u0000\u0000\u007f\u0080\u0005^\u0000\u0000\u0080\u0081\u0005>"+
		"\u0000\u0000\u0081\u001a\u0001\u0000\u0000\u0000\u0082\u0083\u0005<\u0000"+
		"\u0000\u0083\u0084\u0005^\u0000\u0000\u0084\u0085\u0005,\u0000\u0000\u0085"+
		"\u0086\u0005)\u0000\u0000\u0086\u0087\u0005)\u0000\u0000\u0087\u0088\u0005"+
		")\u0000\u0000\u0088\u0089\u0005>\u0000\u0000\u0089\u008a\u0005<\u0000"+
		"\u0000\u008a\u001c\u0001\u0000\u0000\u0000\u008b\u008c\u0005i\u0000\u0000"+
		"\u008c\u008d\u0005n\u0000\u0000\u008d\u008e\u0005t\u0000\u0000\u008e\u001e"+
		"\u0001\u0000\u0000\u0000\u008f\u0090\u0005s\u0000\u0000\u0090\u0091\u0005"+
		"t\u0000\u0000\u0091\u0092\u0005r\u0000\u0000\u0092\u0093\u0005i\u0000"+
		"\u0000\u0093\u0094\u0005n\u0000\u0000\u0094\u0095\u0005g\u0000\u0000\u0095"+
		" \u0001\u0000\u0000\u0000\u0096\u0097\u0005c\u0000\u0000\u0097\u0098\u0005"+
		"h\u0000\u0000\u0098\u0099\u0005a\u0000\u0000\u0099\u009a\u0005r\u0000"+
		"\u0000\u009a\"\u0001\u0000\u0000\u0000\u009b\u009f\u0007\u0000\u0000\u0000"+
		"\u009c\u009e\u0007\u0001\u0000\u0000\u009d\u009c\u0001\u0000\u0000\u0000"+
		"\u009e\u00a1\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000"+
		"\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a9\u0001\u0000\u0000\u0000"+
		"\u00a1\u009f\u0001\u0000\u0000\u0000\u00a2\u00a4\u0007\u0002\u0000\u0000"+
		"\u00a3\u00a5\u0007\u0001\u0000\u0000\u00a4\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a9\u0001\u0000\u0000\u0000"+
		"\u00a8\u009b\u0001\u0000\u0000\u0000\u00a8\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a9$\u0001\u0000\u0000\u0000\u00aa\u00ab\u0005:\u0000\u0000\u00ab\u00ac"+
		"\u0005+\u0000\u0000\u00ac\u00ad\u0005)\u0000\u0000\u00ad&\u0001\u0000"+
		"\u0000\u0000\u00ae\u00af\u0005:\u0000\u0000\u00af\u00b0\u0005-\u0000\u0000"+
		"\u00b0\u00b1\u0005)\u0000\u0000\u00b1(\u0001\u0000\u0000\u0000\u00b2\u00b3"+
		"\u0005:\u0000\u0000\u00b3\u00b4\u0005*\u0000\u0000\u00b4\u00b5\u0005)"+
		"\u0000\u0000\u00b5*\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005:\u0000\u0000"+
		"\u00b7\u00b8\u0005/\u0000\u0000\u00b8\u00b9\u0005)\u0000\u0000\u00b9,"+
		"\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005:\u0000\u0000\u00bb\u00bc\u0005"+
		">\u0000\u0000\u00bc\u00bd\u0005)\u0000\u0000\u00bd.\u0001\u0000\u0000"+
		"\u0000\u00be\u00bf\u0005:\u0000\u0000\u00bf\u00c0\u0005<\u0000\u0000\u00c0"+
		"\u00c1\u0005)\u0000\u0000\u00c10\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005"+
		":\u0000\u0000\u00c3\u00c4\u0005>\u0000\u0000\u00c4\u00c5\u0005=\u0000"+
		"\u0000\u00c5\u00c6\u0005)\u0000\u0000\u00c62\u0001\u0000\u0000\u0000\u00c7"+
		"\u00c8\u0005:\u0000\u0000\u00c8\u00c9\u0005<\u0000\u0000\u00c9\u00ca\u0005"+
		"=\u0000\u0000\u00ca\u00cb\u0005)\u0000\u0000\u00cb4\u0001\u0000\u0000"+
		"\u0000\u00cc\u00ce\u0007\u0003\u0000\u0000\u00cd\u00cc\u0001\u0000\u0000"+
		"\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u00d7\u0001\u0000\u0000"+
		"\u0000\u00cf\u00d8\u00050\u0000\u0000\u00d0\u00d4\u0007\u0004\u0000\u0000"+
		"\u00d1\u00d3\u0007\u0005\u0000\u0000\u00d2\u00d1\u0001\u0000\u0000\u0000"+
		"\u00d3\u00d6\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000"+
		"\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d8\u0001\u0000\u0000\u0000"+
		"\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d7\u00cf\u0001\u0000\u0000\u0000"+
		"\u00d7\u00d0\u0001\u0000\u0000\u0000\u00d86\u0001\u0000\u0000\u0000\u00d9"+
		"\u00db\u0007\u0003\u0000\u0000\u00da\u00d9\u0001\u0000\u0000\u0000\u00da"+
		"\u00db\u0001\u0000\u0000\u0000\u00db\u00df\u0001\u0000\u0000\u0000\u00dc"+
		"\u00de\u0007\u0005\u0000\u0000\u00dd\u00dc\u0001\u0000\u0000\u0000\u00de"+
		"\u00e1\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00df"+
		"\u00e0\u0001\u0000\u0000\u0000\u00e0\u00e2\u0001\u0000\u0000\u0000\u00e1"+
		"\u00df\u0001\u0000\u0000\u0000\u00e2\u00e4\t\u0000\u0000\u0000\u00e3\u00e5"+
		"\u0007\u0005\u0000\u0000\u00e4\u00e3\u0001\u0000\u0000\u0000\u00e5\u00e6"+
		"\u0001\u0000\u0000\u0000\u00e6\u00e4\u0001\u0000\u0000\u0000\u00e6\u00e7"+
		"\u0001\u0000\u0000\u0000\u00e78\u0001\u0000\u0000\u0000\u00e8\u00ec\u0005"+
		"\'\u0000\u0000\u00e9\u00ea\u0005\\\u0000\u0000\u00ea\u00ed\t\u0000\u0000"+
		"\u0000\u00eb\u00ed\b\u0006\u0000\u0000\u00ec\u00e9\u0001\u0000\u0000\u0000"+
		"\u00ec\u00eb\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000"+
		"\u00ee\u00ef\u0005\'\u0000\u0000\u00ef:\u0001\u0000\u0000\u0000\u00f0"+
		"\u00f4\u0007\u0007\u0000\u0000\u00f1\u00f3\t\u0000\u0000\u0000\u00f2\u00f1"+
		"\u0001\u0000\u0000\u0000\u00f3\u00f6\u0001\u0000\u0000\u0000\u00f4\u00f5"+
		"\u0001\u0000\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f5\u00f7"+
		"\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001\u0000\u0000\u0000\u00f7\u00f8"+
		"\u0007\u0007\u0000\u0000\u00f8<\u0001\u0000\u0000\u0000\u00f9\u00fb\u0007"+
		"\b\u0000\u0000\u00fa\u00f9\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000"+
		"\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000"+
		"\u0000\u0000\u00fd\u00fe\u0001\u0000\u0000\u0000\u00fe\u00ff\u0006\u001e"+
		"\u0000\u0000\u00ff>\u0001\u0000\u0000\u0000\u0100\u0101\u0005(\u0000\u0000"+
		"\u0101@\u0001\u0000\u0000\u0000\u0102\u0103\u0005)\u0000\u0000\u0103B"+
		"\u0001\u0000\u0000\u0000\u0104\u0105\u0005<\u0000\u0000\u0105\u0106\u0005"+
		"3\u0000\u0000\u0106\u010a\u0001\u0000\u0000\u0000\u0107\u0109\b\t\u0000"+
		"\u0000\u0108\u0107\u0001\u0000\u0000\u0000\u0109\u010c\u0001\u0000\u0000"+
		"\u0000\u010a\u0108\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000\u0000"+
		"\u0000\u010b\u010d\u0001\u0000\u0000\u0000\u010c\u010a\u0001\u0000\u0000"+
		"\u0000\u010d\u010e\u0006!\u0000\u0000\u010eD\u0001\u0000\u0000\u0000\u010f"+
		"\u0110\u0005O\u0000\u0000\u0110\u0111\u0005W\u0000\u0000\u0111\u0112\u0005"+
		"O\u0000\u0000\u0112\u0116\u0001\u0000\u0000\u0000\u0113\u0115\t\u0000"+
		"\u0000\u0000\u0114\u0113\u0001\u0000\u0000\u0000\u0115\u0118\u0001\u0000"+
		"\u0000\u0000\u0116\u0117\u0001\u0000\u0000\u0000\u0116\u0114\u0001\u0000"+
		"\u0000\u0000\u0117\u0119\u0001\u0000\u0000\u0000\u0118\u0116\u0001\u0000"+
		"\u0000\u0000\u0119\u011a\u0005U\u0000\u0000\u011a\u011b\u0005W\u0000\u0000"+
		"\u011b\u011c\u0005U\u0000\u0000\u011c\u011d\u0001\u0000\u0000\u0000\u011d"+
		"\u011e\u0006\"\u0000\u0000\u011eF\u0001\u0000\u0000\u0000\u011f\u0120"+
		"\u0005:\u0000\u0000\u0120\u0121\u0005=\u0000\u0000\u0121\u0122\u0005="+
		"\u0000\u0000\u0122\u0123\u0005)\u0000\u0000\u0123H\u0001\u0000\u0000\u0000"+
		"\u0124\u0125\u0005:\u0000\u0000\u0125\u0126\u0005=\u0000\u0000\u0126\u0127"+
		"\u0005)\u0000\u0000\u0127J\u0001\u0000\u0000\u0000\u000f\u0000\u009f\u00a6"+
		"\u00a8\u00cd\u00d4\u00d7\u00da\u00df\u00e6\u00ec\u00f4\u00fc\u010a\u0116"+
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