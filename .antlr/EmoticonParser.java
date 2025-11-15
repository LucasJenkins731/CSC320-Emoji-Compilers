// Generated from /Users/connorryan/Desktop/CSC320-Emoji-Compilers/Emoticon.g4 by ANTLR 4.13.1
 import java.util.*; import java.io.*; import org.antlr.v4.runtime.*; import org.antlr.v4.runtime.tree.*; 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class EmoticonParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, KW_READ=2, KW_PRINT=3, KW_IF=4, KW_ELSE=5, KW_ELSE_IF=6, KW_FOR=7, 
<<<<<<< HEAD
		KW_WHILE=8, KW_FUNCTION=9, KW_ARRAY=10, LBRACE=11, RBRACE=12, KW_INT=13, 
		KW_STRING=14, KW_CHAR=15, IDENT=16, ADD=17, SUBTRACT=18, MULTIPLY=19, 
		DIVIDE=20, GREATERTHAN=21, LESSTHAN=22, GREATERTHANOREQUALTO=23, LESSTHANOREQUALTO=24, 
		LBRACKET=25, RBRACKET=26, INT=27, FLOAT=28, CHAR=29, STRING=30, WS=31, 
		LPAREN=32, RPAREN=33, COMMA=34, COMMENT=35, COMMENT_BLOCK=36, COMPARISON=37, 
		ASSIGNMENT=38;
=======
		KW_WHILE=8, KW_RETURN=9, KW_FUNCTION=10, KW_ARRAY=11, LBRACE=12, RBRACE=13, 
		KW_INT=14, KW_STRING=15, KW_CHAR=16, IDENT=17, ADD=18, SUBTRACT=19, MULTIPLY=20, 
		DIVIDE=21, GREATERTHAN=22, LESSTHAN=23, GREATERTHANOREQUALTO=24, LESSTHANOREQUALTO=25, 
		LBRACKET=26, RBRACKET=27, INT=28, CHAR=29, STRING=30, WS=31, LPAREN=32, 
		RPAREN=33, COMMA=34, COMMENT=35, COMMENT_BLOCK=36, COMPARISON=37, ASSIGNMENT=38;
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
	public static final int
		RULE_program = 0, RULE_s = 1, RULE_functioncallstmt = 2, RULE_blockStatement = 3, 
		RULE_as = 4, RULE_ps = 5, RULE_condition = 6, RULE_expr = 7, RULE_term = 8, 
		RULE_factor = 9, RULE_ifstmt = 10, RULE_elsestmt = 11, RULE_forstmt = 12, 
		RULE_whilestmt = 13, RULE_returnstmt = 14, RULE_functionstmt = 15, RULE_functioncall = 16, 
		RULE_arraystmt = 17, RULE_arrayInitializer = 18, RULE_exprList = 19, RULE_arrayAccess = 20, 
		RULE_operators = 21, RULE_conditionals = 22, RULE_comp = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "s", "functioncallstmt", "blockStatement", "as", "ps", "condition", 
			"expr", "term", "factor", "ifstmt", "elsestmt", "forstmt", "whilestmt", 
			"returnstmt", "functionstmt", "functioncall", "arraystmt", "arrayInitializer", 
			"exprList", "arrayAccess", "operators", "conditionals", "comp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'-0-0-'", "':P'", "':)'", "':('", "':|'", "'>:('", "'D:<'", 
<<<<<<< HEAD
			"'=^._.^='", "'(o_o)'", "'><(((,^>'", "'<^,)))><'", "'int'", "'string'", 
			"'char'", null, "':+)'", "':-)'", "':*)'", "':/)'", "':>)'", "':<)'", 
			"':>=)'", "':<=)'", "'['", "']'", null, null, null, null, null, "'('", 
=======
			"'return'", "'=^._.^='", "'(o_o)'", "'><(((,^>'", "'<^,)))><'", "'int'", 
			"'string'", "'char'", null, "':+)'", "':-)'", "':*)'", "':/)'", "':>)'", 
			"':<)'", "':>=)'", "':<=)'", "'['", "']'", null, null, null, null, "'('", 
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			"')'", "','", null, null, "':==)'", "':=)'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "KW_READ", "KW_PRINT", "KW_IF", "KW_ELSE", "KW_ELSE_IF", 
<<<<<<< HEAD
			"KW_FOR", "KW_WHILE", "KW_FUNCTION", "KW_ARRAY", "LBRACE", "RBRACE", 
			"KW_INT", "KW_STRING", "KW_CHAR", "IDENT", "ADD", "SUBTRACT", "MULTIPLY", 
			"DIVIDE", "GREATERTHAN", "LESSTHAN", "GREATERTHANOREQUALTO", "LESSTHANOREQUALTO", 
			"LBRACKET", "RBRACKET", "INT", "FLOAT", "CHAR", "STRING", "WS", "LPAREN", 
			"RPAREN", "COMMA", "COMMENT", "COMMENT_BLOCK", "COMPARISON", "ASSIGNMENT"
=======
			"KW_FOR", "KW_WHILE", "KW_RETURN", "KW_FUNCTION", "KW_ARRAY", "LBRACE", 
			"RBRACE", "KW_INT", "KW_STRING", "KW_CHAR", "IDENT", "ADD", "SUBTRACT", 
			"MULTIPLY", "DIVIDE", "GREATERTHAN", "LESSTHAN", "GREATERTHANOREQUALTO", 
			"LESSTHANOREQUALTO", "LBRACKET", "RBRACKET", "INT", "CHAR", "STRING", 
			"WS", "LPAREN", "RPAREN", "COMMA", "COMMENT", "COMMENT_BLOCK", "COMPARISON", 
			"ASSIGNMENT"
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
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
	public String getGrammarFileName() { return "Emoticon.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	  enum Type {
	    INT, FLOAT, STRING, CHAR, ARRAY, UNKNOWN
	  }

	  class ExprResult {
	    Type type;
	    float numericalValue;
	    String stringValue;
	    boolean hasKnownValue;
	    boolean forAssign;
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

	    //Array Specific
	    int arraySize;
	    Object[] arrayValues;
	    boolean isArray;
	  }

	  class SymbolTable {
	    Map<String, Identifier> table = new HashMap<>();
	  }
	  
	  class FunctionDef {
	    String name;
	    String paramName;
	    Type paramType;
	    Type returnType;
	    ParserRuleContext body;
	    String javaCode;
	    boolean hasReturn;
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
	  FunctionDef currentFunction = null;

	  boolean forAssign = false;// global check to semicolons in for stmt

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
	  }

	  // Emit the main method start
	  void openMainMethod() {
	    emit("  public static void main(String[] args) throws Exception {\n");
	    emit("    Scanner in = new Scanner(System.in);\n");
	  }

	  // Emit the postamble material for our program
	  void closeProgram() {
	    emit("  }\n");
	    emit("}\n");
	  }

	  // Helper method to convert Type enum to Java type string
	  String getJavaType(Type type) {
	    switch (type) {
	      case INT: return "int";
	      case FLOAT: return "float";
	      case STRING: return "String";
	      case CHAR: return "char";
	      default: return "double"; // fallback
	    }
	  }

	  // Declare LHS if first-time assignment; otherwise plain assignment.
	  void generateAssign(boolean declare, String name, String rhsJavaCode, Type type, boolean forAssign) {
	    String javaType = getJavaType(type);
	    if(!forAssign){
	      emit("    " + (declare ? javaType + " " : " ") + name + " = " + rhsJavaCode + ";\n");
	    } else {
	      emit((declare ? javaType + " " : " ") + name + " = " + rhsJavaCode);
	    }
	  }

	  // Generate Java method definition for a function
	  void generateFunctionDefinition(FunctionDef func) {
	    // Check if the function body contains a return statement
	    String bodyCode = func.javaCode != null ? func.javaCode : "";
	    boolean hasExplicitReturn = bodyCode.contains("return ");
	    
	    String javaReturnType = (func.hasReturn || hasExplicitReturn) ? getJavaType(func.returnType) : "void";
	    emit("  public static " + javaReturnType + " " + func.name + "(");
	    
	    if (func.paramName != null) {
	      String javaParamType = getJavaType(func.paramType);
	      emit(javaParamType + " " + func.paramName);
	    }
	    
	    emit(") {\n");
	    emit(func.javaCode);
	    emit("  }\n\n");
	  }

	  // Generate function call code
	  String generateFunctionCall(String funcName, String argCode, Type argType) {
	    FunctionDef func = functions.get(funcName);
	    if (func == null) {
	      return "/* ERROR: function " + funcName + " not found */";
	    }
	    
	    if (func.paramName != null) {
	      return funcName + "(" + argCode + ")";
	    } else {
	      return funcName + "()";
	    }
	  }

	  // Write the generated Java to file.
	  void writeFile() {
	    try (PrintWriter pw = new PrintWriter("EmoticonProgramTests.java", "UTF-8")) {
	      pw.print(sb.toString());
	    } catch (Exception e) {
	      System.err.println("error: failed to write EmoticonProgramTests.java: " + e.getMessage());
	    }
	  }

	public EmoticonParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(EmoticonParser.EOF, 0); }
		public List<SContext> s() {
			return getRuleContexts(SContext.class);
		}
		public SContext s(int i) {
			return getRuleContext(SContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 
			      openProgram();
			      openMainMethod();
			    
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
<<<<<<< HEAD
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6039867288L) != 0)) {
=======
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6174154648L) != 0)) {
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				{
				{
				setState(49);
				s();
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
			match(EOF);

			      int numErrors = printDiagnostics();
			      if (numErrors == 0) {
			        // Close main method first
			        emit("  }\n");
			        
			        // Generate function definitions
			        for (FunctionDef func : functions.values()) {
			          if (func.javaCode != null) {
			            generateFunctionDefinition(func);
			          }
			        }
			        
			        // Close class
			        emit("}\n");
			        
			        // Successful, so write out the generated code
			        writeFile();
			        System.err.println("Success!");
			      } else {
			        System.err.println(numErrors + " errors detected. Code not generated.");
			        System.exit(1);  // Error code
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

	@SuppressWarnings("CheckReturnValue")
	public static class SContext extends ParserRuleContext {
		public FunctioncallstmtContext functioncallstmt() {
			return getRuleContext(FunctioncallstmtContext.class,0);
		}
		public AsContext as() {
			return getRuleContext(AsContext.class,0);
		}
		public PsContext ps() {
			return getRuleContext(PsContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArraystmtContext arraystmt() {
			return getRuleContext(ArraystmtContext.class,0);
		}
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public IfstmtContext ifstmt() {
			return getRuleContext(IfstmtContext.class,0);
		}
		public ForstmtContext forstmt() {
			return getRuleContext(ForstmtContext.class,0);
		}
		public WhilestmtContext whilestmt() {
			return getRuleContext(WhilestmtContext.class,0);
		}
		public FunctionstmtContext functionstmt() {
			return getRuleContext(FunctionstmtContext.class,0);
		}
		public ReturnstmtContext returnstmt() {
			return getRuleContext(ReturnstmtContext.class,0);
		}
		public SContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_s; }
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_s);
		try {
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				functioncallstmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				as();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(60);
				ps();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(61);
				expr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(62);
				arraystmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(63);
				blockStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(64);
				ifstmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(65);
				forstmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(66);
				whilestmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(67);
				functionstmt();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(68);
				returnstmt();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctioncallstmtContext extends ParserRuleContext {
		public FunctioncallContext functioncall;
		public FunctioncallContext functioncall() {
			return getRuleContext(FunctioncallContext.class,0);
		}
		public FunctioncallstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functioncallstmt; }
	}

	public final FunctioncallstmtContext functioncallstmt() throws RecognitionException {
		FunctioncallstmtContext _localctx = new FunctioncallstmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functioncallstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			((FunctioncallstmtContext)_localctx).functioncall = functioncall();

			    if (!definingFunction) {
			      emit("    " + ((FunctioncallstmtContext)_localctx).functioncall.result.code + ";\n");
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockStatementContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(EmoticonParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(EmoticonParser.RBRACE, 0); }
		public List<SContext> s() {
			return getRuleContexts(SContext.class);
		}
		public SContext s(int i) {
			return getRuleContext(SContext.class,i);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_blockStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(LBRACE);
			  
			    if (!definingFunction) {
			      SymbolTable currentSymbolTable = new SymbolTable();
			      symbolStack.push(currentSymbolTable);
			    } else {
			      functionDefDepth++;
			    }
			  
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
<<<<<<< HEAD
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6039867288L) != 0)) {
=======
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6174154648L) != 0)) {
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				{
				{
				setState(76);
				s();
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82);
			match(RBRACE);
			 
			    if (!definingFunction) {
			      symbolStack.pop();
			    } else {
			      functionDefDepth--;
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

	@SuppressWarnings("CheckReturnValue")
	public static class AsContext extends ParserRuleContext {
		public ArrayAccessContext arrayAccess;
		public ExprContext expr;
		public Token IDENT;
		public Token INT;
		public Token STRING;
		public Token CHAR;
		public Token FLOAT;
		public ArrayAccessContext arrayAccess() {
			return getRuleContext(ArrayAccessContext.class,0);
		}
		public TerminalNode ASSIGNMENT() { return getToken(EmoticonParser.ASSIGNMENT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(EmoticonParser.IDENT, 0); }
		public TerminalNode INT() { return getToken(EmoticonParser.INT, 0); }
		public TerminalNode STRING() { return getToken(EmoticonParser.STRING, 0); }
		public TerminalNode CHAR() { return getToken(EmoticonParser.CHAR, 0); }
		public TerminalNode FLOAT() { return getToken(EmoticonParser.FLOAT, 0); }
		public TerminalNode KW_READ() { return getToken(EmoticonParser.KW_READ, 0); }
		public AsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_as; }
	}

	public final AsContext as() throws RecognitionException {
		AsContext _localctx = new AsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_as);
		try {
<<<<<<< HEAD
			setState(100);
=======
			setState(106);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				((AsContext)_localctx).arrayAccess = arrayAccess();
				setState(86);
				match(ASSIGNMENT);
				setState(87);
				((AsContext)_localctx).expr = expr();

				      String arrayCode = ((AsContext)_localctx).arrayAccess.result.code;
				      if (((AsContext)_localctx).arrayAccess.result.type != Type.UNKNOWN) {
				        emit("    " + arrayCode + " = " + ((AsContext)_localctx).expr.result.code + ";\n");
				      }
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				((AsContext)_localctx).IDENT = match(IDENT);
				setState(91);
				match(ASSIGNMENT);
<<<<<<< HEAD
				setState(98);
=======
				setState(104);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(92);
					((AsContext)_localctx).expr = expr();

					        String id = ((AsContext)_localctx).IDENT.getText();
					        Identifier var = lookupVariable(id);
					        Identifier newId = new Identifier();
					        newId.id = id;
					        if(((AsContext)_localctx).expr.result.type == Type.INT || ((AsContext)_localctx).expr.result.type == Type.FLOAT){
					          newId.value = ((AsContext)_localctx).expr.result.numericalValue;
					        } else {
					          newId.value = ((AsContext)_localctx).expr.result.stringValue;
					        }
					        newId.type = ((AsContext)_localctx).expr.result.type;
					        System.out.println(id + " = " + String.valueOf(newId.value) + " (" + "Type = " + newId.type + ")");
					        newId.hasKnown = ((AsContext)_localctx).expr.result.hasKnownValue;
					        newId.hasBeenUsed = false;
					        addVariable(newId);
					        
					        // Generate Java code for assignment
					        boolean isNewVariable = (var == null);
					        generateAssign(isNewVariable, id, ((AsContext)_localctx).expr.result.code, ((AsContext)_localctx).expr.result.type, forAssign);
					      
					}
					break;
				case 2:
					{
					setState(95);
					((AsContext)_localctx).INT = match(INT);

					        Identifier newId = new Identifier();
					        newId.id = ((AsContext)_localctx).IDENT.getText();
					        newId.value = ((AsContext)_localctx).INT.getText();
					        newId.type = Type.INT;
					        addVariable(newId);
					        System.out.println(newId.value + "(" + "Type = " + newId.type + ")");
					        
					        // Generate Java code for assignment
					        generateAssign(true, newId.id, ((AsContext)_localctx).INT.getText(), Type.INT, forAssign);
					      
					}
					break;
				case 3:
					{
					setState(97);
					((AsContext)_localctx).STRING = match(STRING);

					        Identifier newId = new Identifier();
					        newId.id = ((AsContext)_localctx).IDENT.getText();
					        newId.value = ((AsContext)_localctx).STRING.getText();
					        newId.type = Type.STRING;
					        addVariable(newId);
					        System.out.println(newId.value + "(" + "Type = " + newId.type + ")");
					        
					        // Generate Java code for assignment
					        generateAssign(true, newId.id, ((AsContext)_localctx).STRING.getText(), Type.STRING, forAssign);
					      
					}
					break;
				case 4:
					{
					setState(99);
					((AsContext)_localctx).CHAR = match(CHAR);

					        Identifier newId = new Identifier();
					        newId.id = ((AsContext)_localctx).IDENT.getText();
					        newId.value = ((AsContext)_localctx).CHAR.getText();
					        newId.type = Type.CHAR;
					        addVariable(newId);
					        System.out.println(newId.value + "(" + "Type = " + newId.type + ")");
					        
					        // Generate Java code for assignment
					        generateAssign(true, newId.id, ((AsContext)_localctx).CHAR.getText(), Type.CHAR, forAssign);
					      
					}
					break;
				case 5:
					{
<<<<<<< HEAD
					setState(93);
					((AsContext)_localctx).FLOAT = match(FLOAT);

					        Identifier newId = new Identifier();
					        newId.id = ((AsContext)_localctx).IDENT.getText();
					        newId.value = ((AsContext)_localctx).FLOAT.getText();
					        newId.type = Type.FLOAT;
					        addVariable(newId);
					        System.out.println(newId.value + "(" + "Type = " + newId.type + ")");
					        
					        // Generate Java code for assignment
					        generateAssign(true, newId.id, ((AsContext)_localctx).FLOAT.getText() + "f", Type.FLOAT, forAssign);
					      
					}
					break;
				case 6:
					{
					setState(95);
=======
					setState(101);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
					match(KW_READ);

					        String input = readInput.nextLine();
					        Identifier newId = new Identifier();
					        newId.id = ((AsContext)_localctx).IDENT.getText();
					        newId.value = input;
					        newId.type = typeCheck(input);
					        addVariable(newId);
					        System.out.println(newId.value + "(" + "Type = " + newId.type + ")");
					        
					        // Generate Java code for assignment
					        generateAssign(true, newId.id, "in.nextLine()", Type.STRING, forAssign);
					      
					}
					break;
				case 7:
					{

					        // add array functionality
					      
					}
					break;
				}
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class PsContext extends ParserRuleContext {
		public ExprContext expr;
		public TerminalNode KW_PRINT() { return getToken(EmoticonParser.KW_PRINT, 0); }
		public TerminalNode LPAREN() { return getToken(EmoticonParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(EmoticonParser.RPAREN, 0); }
		public PsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ps; }
	}

	public final PsContext ps() throws RecognitionException {
		PsContext _localctx = new PsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ps);
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< HEAD
			setState(102);
			match(KW_PRINT);
			setState(103);
			match(LPAREN);
			setState(104);
			((PsContext)_localctx).expr = expr();
			setState(105);
=======
			setState(108);
			match(KW_PRINT);
			setState(109);
			match(LPAREN);
			setState(110);
			((PsContext)_localctx).expr = expr();
			setState(111);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			match(RPAREN);

			      if(((PsContext)_localctx).expr.result.hasKnownValue){
			        if(((PsContext)_localctx).expr.result.type == Type.INT || ((PsContext)_localctx).expr.result.type == Type.FLOAT){
			          System.out.println(((PsContext)_localctx).expr.result.numericalValue);
			        } else {
			          System.out.println(((PsContext)_localctx).expr.result.stringValue);
			        }
			      }
			      
			      // Generate Java code for print statement
			      emit("    System.out.println(" + ((PsContext)_localctx).expr.result.code + ");\n");
			    
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionContext extends ParserRuleContext {
		public ExprResult result;
		public ExprContext a;
		public Token conditional;
		public ExprContext b;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> GREATERTHAN() { return getTokens(EmoticonParser.GREATERTHAN); }
		public TerminalNode GREATERTHAN(int i) {
			return getToken(EmoticonParser.GREATERTHAN, i);
		}
		public List<TerminalNode> LESSTHAN() { return getTokens(EmoticonParser.LESSTHAN); }
		public TerminalNode LESSTHAN(int i) {
			return getToken(EmoticonParser.LESSTHAN, i);
		}
		public List<TerminalNode> GREATERTHANOREQUALTO() { return getTokens(EmoticonParser.GREATERTHANOREQUALTO); }
		public TerminalNode GREATERTHANOREQUALTO(int i) {
			return getToken(EmoticonParser.GREATERTHANOREQUALTO, i);
		}
		public List<TerminalNode> LESSTHANOREQUALTO() { return getTokens(EmoticonParser.LESSTHANOREQUALTO); }
		public TerminalNode LESSTHANOREQUALTO(int i) {
			return getToken(EmoticonParser.LESSTHANOREQUALTO, i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_condition);

		    ((ConditionContext)_localctx).result =  new ExprResult();
		  
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< HEAD
			setState(108);
=======
			setState(114);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			((ConditionContext)_localctx).a = expr();

			      // start with the lhs expr result
			      ((ConditionContext)_localctx).result =  ((ConditionContext)_localctx).a.result;
			    
<<<<<<< HEAD
			setState(116);
=======
			setState(122);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 62914560L) != 0)) {
				{
				{
<<<<<<< HEAD
				setState(110);
=======
				setState(116);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				((ConditionContext)_localctx).conditional = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 62914560L) != 0)) ) {
					((ConditionContext)_localctx).conditional = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
<<<<<<< HEAD
				setState(111);
=======
				setState(117);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				((ConditionContext)_localctx).b = expr();

				        // map emoticon tokens to Java operators
				        String tok = ((ConditionContext)_localctx).conditional.getText();
				        String javaOp;
				        if (":>)".equals(tok)) javaOp = ">";
				        else if (":<)".equals(tok)) javaOp = "<";
				        else if (":>=)".equals(tok)) javaOp = ">=";
				        else if (":<=)".equals(tok)) javaOp = "<=";
				        else if (":==)".equals(tok)) javaOp = "==";
				        else javaOp = tok;

				        // ensure operands are comparable (allow numeric, char, string comparisons as needed)
				        if (((((ConditionContext)_localctx).a.result.type == Type.INT || ((ConditionContext)_localctx).a.result.type == Type.FLOAT)
				             && (((ConditionContext)_localctx).b.result.type == Type.INT || ((ConditionContext)_localctx).b.result.type == Type.FLOAT))
				            || (((ConditionContext)_localctx).a.result.type == Type.CHAR && ((ConditionContext)_localctx).b.result.type == Type.CHAR)
				            || (((ConditionContext)_localctx).a.result.type == Type.STRING && ((ConditionContext)_localctx).b.result.type == Type.STRING)) {
				          _localctx.result.code = ((ConditionContext)_localctx).a.result.code + " " + javaOp + " " + ((ConditionContext)_localctx).b.result.code;
				          _localctx.result.hasKnownValue = false; // conservative
				          _localctx.result.type = Type.UNKNOWN;
				        } else {
				          error(((ConditionContext)_localctx).conditional, "incomparable types used in condition");
				          _localctx.result.code = "false";
				          _localctx.result.hasKnownValue = false;
				          _localctx.result.type = Type.UNKNOWN;
				        }
				      
				}
				}
<<<<<<< HEAD
				setState(118);
=======
				setState(124);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprResult result;
		public TermContext a;
		public Token op;
		public TermContext b;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> ADD() { return getTokens(EmoticonParser.ADD); }
		public TerminalNode ADD(int i) {
			return getToken(EmoticonParser.ADD, i);
		}
		public List<TerminalNode> SUBTRACT() { return getTokens(EmoticonParser.SUBTRACT); }
		public TerminalNode SUBTRACT(int i) {
			return getToken(EmoticonParser.SUBTRACT, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expr);

		    ((ExprContext)_localctx).result =  new ExprResult();
		  
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< HEAD
			setState(119);
=======
			setState(125);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			((ExprContext)_localctx).a = term();

			      ((ExprContext)_localctx).result =  ((ExprContext)_localctx).a.result;
			    
<<<<<<< HEAD
			setState(127);
=======
			setState(133);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==SUBTRACT) {
				{
				{
<<<<<<< HEAD
				setState(121);
=======
				setState(127);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				((ExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUBTRACT) ) {
					((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
<<<<<<< HEAD
				setState(122);
=======
				setState(128);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				((ExprContext)_localctx).b = term();

				        ExprResult resultB = ((ExprContext)_localctx).b.result;
				        if((_localctx.result.type == Type.INT || _localctx.result.type == Type.FLOAT)){
				          if(resultB.type == Type.INT || resultB.type == Type.FLOAT){
				            if(((ExprContext)_localctx).op.getText().equals(":+)")){
				              _localctx.result.code = ((ExprContext)_localctx).a.result.code + " " + "+" + " " + ((ExprContext)_localctx).b.result.code;
				            } else {
				              _localctx.result.code = ((ExprContext)_localctx).a.result.code + " " + "-" + " " + ((ExprContext)_localctx).b.result.code;
				            }
				            //_localctx.result.code = ""+_localctx.result.numericalValue;
				            if(_localctx.result.type == Type.FLOAT || resultB.type == Type.FLOAT){
				              _localctx.result.type = Type.FLOAT;
				            }
				          } else {
				            error(((ExprContext)_localctx).op, "cannot do arithmetic on non-numerical types");
				            _localctx.result.hasKnownValue = false;
				            _localctx.result.code = "(" + _localctx.result.code + ((ExprContext)_localctx).op.getText() + resultB.code + ")";
				          }
				        } else if(_localctx.result.type == Type.STRING || _localctx.result.type == Type.CHAR){
				          if(((ExprContext)_localctx).op.getText().equals(":+)")){
				            _localctx.result.stringValue = _localctx.result.stringValue + resultB.stringValue;
				          } else {
				            error(((ExprContext)_localctx).op, "cannot subtract strings");
				            _localctx.result.hasKnownValue = false;
				            _localctx.result.code = "(" + _localctx.result.code + ((ExprContext)_localctx).op.getText() + resultB.code + ")";
				          }
				        } else {
				          error(((ExprContext)_localctx).op, "unknown type");
				          _localctx.result.hasKnownValue = false;
				        }
				      
				}
				}
<<<<<<< HEAD
				setState(129);
=======
				setState(135);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public ExprResult result;
		public FactorContext a;
		public Token op;
		public FactorContext b;
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> MULTIPLY() { return getTokens(EmoticonParser.MULTIPLY); }
		public TerminalNode MULTIPLY(int i) {
			return getToken(EmoticonParser.MULTIPLY, i);
		}
		public List<TerminalNode> DIVIDE() { return getTokens(EmoticonParser.DIVIDE); }
		public TerminalNode DIVIDE(int i) {
			return getToken(EmoticonParser.DIVIDE, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_term);

		    ((TermContext)_localctx).result =  new ExprResult();
		  
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< HEAD
			setState(130);
=======
			setState(136);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			((TermContext)_localctx).a = factor();

			      ((TermContext)_localctx).result =  ((TermContext)_localctx).a.result;
			    
<<<<<<< HEAD
			setState(138);
=======
			setState(144);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULTIPLY || _la==DIVIDE) {
				{
				{
<<<<<<< HEAD
				setState(132);
=======
				setState(138);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				((TermContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==MULTIPLY || _la==DIVIDE) ) {
					((TermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
<<<<<<< HEAD
				setState(133);
=======
				setState(139);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				((TermContext)_localctx).b = factor();

				        ExprResult resultB = ((TermContext)_localctx).b.result;
				        if(_localctx.result.type == Type.INT || _localctx.result.type == Type.FLOAT){
				          if(resultB.type == Type.INT || resultB.type == Type.FLOAT){
				            if(resultB.numericalValue == 0 && ((TermContext)_localctx).op.getText().equals(":/)")){
				              error(((TermContext)_localctx).op, "division by zero");
				              _localctx.result.hasKnownValue = false;
				              _localctx.result.code = "Error";
				            } else if(((TermContext)_localctx).op.getText().equals(":*)")){
				              _localctx.result.code = ((TermContext)_localctx).a.result.code + " " + "*" + " " + ((TermContext)_localctx).b.result.code;
				            } else {
				              _localctx.result.code = ((TermContext)_localctx).a.result.code + " " + "/" + " " + ((TermContext)_localctx).b.result.code;
				            }
				            //_localctx.result.code = ""+_localctx.result.numericalValue;
				            if(_localctx.result.type == Type.FLOAT || resultB.type == Type.FLOAT){
				              _localctx.result.type = Type.FLOAT;
				            } else {
				              _localctx.result.type = Type.INT;
				            }
				          } else {
				            error(((TermContext)_localctx).op, "cannot do arithmetic on non-numeric types");
				            _localctx.result.hasKnownValue = false;
				            _localctx.result.code = "(" + _localctx.result.code + ((TermContext)_localctx).op.getText() + resultB.code + ")";
				          }
				        } else {
				          error(((TermContext)_localctx).op, "cannot do arithmetic on non-numeric types");
				          _localctx.result.hasKnownValue = false;
				          _localctx.result.code = "(" + _localctx.result.code + ((TermContext)_localctx).op.getText() + resultB.code + ")";
				        }
				      
				}
				}
<<<<<<< HEAD
				setState(140);
=======
				setState(146);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public ExprResult result;
		public Token INT;
		public Token CHAR;
		public Token STRING;
		public ArrayAccessContext arrayAccess;
		public FunctioncallContext functioncall;
		public Token IDENT;
		public ExprContext expr;
		public TerminalNode INT() { return getToken(EmoticonParser.INT, 0); }
		public TerminalNode CHAR() { return getToken(EmoticonParser.CHAR, 0); }
		public TerminalNode STRING() { return getToken(EmoticonParser.STRING, 0); }
		public ArrayAccessContext arrayAccess() {
			return getRuleContext(ArrayAccessContext.class,0);
		}
		public FunctioncallContext functioncall() {
			return getRuleContext(FunctioncallContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(EmoticonParser.IDENT, 0); }
		public TerminalNode LPAREN() { return getToken(EmoticonParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(EmoticonParser.RPAREN, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_factor);
		try {
<<<<<<< HEAD
			setState(157);
=======
			setState(169);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
<<<<<<< HEAD
				setState(141);
=======
				setState(147);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				((FactorContext)_localctx).INT = match(INT);

				      ((FactorContext)_localctx).result =  new ExprResult();
				      _localctx.result.type = Type.INT;
				      _localctx.result.numericalValue = Integer.parseInt(((FactorContext)_localctx).INT.getText());
				      _localctx.result.hasKnownValue = true;
				      _localctx.result.code = Integer.toString((int)_localctx.result.numericalValue);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
<<<<<<< HEAD
				setState(143);
=======
				setState(149);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				((FactorContext)_localctx).CHAR = match(CHAR);

				      ((FactorContext)_localctx).result =  new ExprResult();
				      _localctx.result.type = Type.CHAR;
				      _localctx.result.stringValue = String.valueOf(((FactorContext)_localctx).CHAR.getText().charAt(1));
				      _localctx.result.hasKnownValue = true;
				      _localctx.result.code = ((FactorContext)_localctx).CHAR.getText();
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
<<<<<<< HEAD
				setState(145);
=======
				setState(151);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				((FactorContext)_localctx).STRING = match(STRING);

				      ((FactorContext)_localctx).result =  new ExprResult();
				      _localctx.result.type = Type.STRING;
				      _localctx.result.stringValue = ((FactorContext)_localctx).STRING.getText();
				      _localctx.result.hasKnownValue = true;
				      _localctx.result.code = ""+_localctx.result.stringValue;
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
<<<<<<< HEAD
				setState(147);
=======
				setState(153);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				((FactorContext)_localctx).arrayAccess = arrayAccess();

				      ((FactorContext)_localctx).result =  ((FactorContext)_localctx).arrayAccess.result;
				    
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
<<<<<<< HEAD
				setState(150);
=======
				setState(156);
				((FactorContext)_localctx).functioncall = functioncall();

				      ((FactorContext)_localctx).result =  ((FactorContext)_localctx).functioncall.result;
				    
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(159);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				((FactorContext)_localctx).IDENT = match(IDENT);

				      String id = ((FactorContext)_localctx).IDENT.getText();
				      Identifier var = lookupVariable(id);
				      ((FactorContext)_localctx).result =  new ExprResult();

				      if(var == null){
				        error(((FactorContext)_localctx).IDENT, "variable is not yet defined");
				      } else {
				        var.hasBeenUsed = true;
				        _localctx.result.type = var.type;
				        _localctx.result.hasKnownValue = var.hasKnown;
				        if(var.type == Type.INT || var.type == Type.FLOAT){
				          if(var.value instanceof Integer){
				            _localctx.result.numericalValue = (Integer)var.value;
				          } else if(var.value instanceof Float){
				            _localctx.result.numericalValue = (Float)var.value;
				          } else if(var.value instanceof String){
				            try {
				              _localctx.result.numericalValue = Float.parseFloat((String)var.value);
				            } catch(NumberFormatException e) {
				              _localctx.result.numericalValue = 0;
				            }
				          }
				        } else {
				          _localctx.result.stringValue = (String)var.value;
				        }
				      }
				      _localctx.result.code = id;
				    
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
<<<<<<< HEAD
				setState(152);
				match(LPAREN);
				setState(153);
				((FactorContext)_localctx).expr = expr();
				setState(154);
=======
				setState(161);
				((FactorContext)_localctx).functioncall = functioncall();

				      ((FactorContext)_localctx).result =  ((FactorContext)_localctx).functioncall.result;
				    
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(164);
				match(LPAREN);
				setState(165);
				((FactorContext)_localctx).expr = expr();
				setState(166);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				match(RPAREN);

				      ((FactorContext)_localctx).result =  ((FactorContext)_localctx).expr.result;
				    
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfstmtContext extends ParserRuleContext {
		public ConditionContext condition;
		public TerminalNode KW_IF() { return getToken(EmoticonParser.KW_IF, 0); }
		public TerminalNode LPAREN() { return getToken(EmoticonParser.LPAREN, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(EmoticonParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(EmoticonParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(EmoticonParser.RBRACE, 0); }
		public List<SContext> s() {
			return getRuleContexts(SContext.class);
		}
		public SContext s(int i) {
			return getRuleContext(SContext.class,i);
		}
		public ElsestmtContext elsestmt() {
			return getRuleContext(ElsestmtContext.class,0);
		}
		public IfstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstmt; }
	}

	public final IfstmtContext ifstmt() throws RecognitionException {
		IfstmtContext _localctx = new IfstmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ifstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< HEAD
			setState(159);
=======
			setState(171);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			match(KW_IF);

			      emit("    if (");
			    
<<<<<<< HEAD
			setState(161);
			match(LPAREN);
			setState(162);
			((IfstmtContext)_localctx).condition = condition();
			setState(163);
=======
			setState(173);
			match(LPAREN);
			setState(174);
			((IfstmtContext)_localctx).condition = condition();
			setState(175);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			match(RPAREN);

			      // emit condition and space before block
			      emit(((IfstmtContext)_localctx).condition.result.code + ")");
			    
<<<<<<< HEAD
			setState(165);
=======
			setState(177);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			match(LBRACE);

			      emit(" {\n");
			      if (!definingFunction) {
			        SymbolTable ifScope = new SymbolTable();
			        symbolStack.push(ifScope);
			      } else {
			        functionDefDepth++;
			      }
			    
<<<<<<< HEAD
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6039867288L) != 0)) {
				{
				{
				setState(167);
				s();
				}
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(173);
=======
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6174154648L) != 0)) {
				{
				{
				setState(179);
				s();
				}
				}
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(185);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			match(RBRACE);

			      emit("    }\n");
			      if (!definingFunction) {
			        symbolStack.pop();
			      } else {
			        functionDefDepth--;
			      }
			    
<<<<<<< HEAD
			setState(176);
=======
			setState(188);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_ELSE || _la==KW_ELSE_IF) {
				{
<<<<<<< HEAD
				setState(175);
=======
				setState(187);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				elsestmt();
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElsestmtContext extends ParserRuleContext {
		public ConditionContext condition;
		public TerminalNode KW_ELSE_IF() { return getToken(EmoticonParser.KW_ELSE_IF, 0); }
		public TerminalNode LPAREN() { return getToken(EmoticonParser.LPAREN, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(EmoticonParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(EmoticonParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(EmoticonParser.RBRACE, 0); }
		public List<SContext> s() {
			return getRuleContexts(SContext.class);
		}
		public SContext s(int i) {
			return getRuleContext(SContext.class,i);
		}
		public ElsestmtContext elsestmt() {
			return getRuleContext(ElsestmtContext.class,0);
		}
		public TerminalNode KW_ELSE() { return getToken(EmoticonParser.KW_ELSE, 0); }
		public ElsestmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elsestmt; }
	}

	public final ElsestmtContext elsestmt() throws RecognitionException {
		ElsestmtContext _localctx = new ElsestmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_elsestmt);
		int _la;
		try {
<<<<<<< HEAD
			setState(209);
=======
			setState(221);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_ELSE_IF:
				enterOuterAlt(_localctx, 1);
				{
<<<<<<< HEAD
				setState(178);
=======
				setState(190);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				match(KW_ELSE_IF);

				      emit("    else if (");
				    
<<<<<<< HEAD
				setState(180);
				match(LPAREN);
				setState(181);
				((ElsestmtContext)_localctx).condition = condition();
				setState(182);
=======
				setState(192);
				match(LPAREN);
				setState(193);
				((ElsestmtContext)_localctx).condition = condition();
				setState(194);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				match(RPAREN);

				      emit(((ElsestmtContext)_localctx).condition.result.code + ")");
				    
<<<<<<< HEAD
				setState(184);
=======
				setState(196);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				match(LBRACE);

				      emit(" {\n");
				      if (!definingFunction) {
				        SymbolTable elseIfScope = new SymbolTable();
				        symbolStack.push(elseIfScope);
				      } else {
				        functionDefDepth++;
				      }
				    
<<<<<<< HEAD
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6039867288L) != 0)) {
					{
					{
					setState(186);
					s();
					}
					}
					setState(191);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(192);
=======
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6174154648L) != 0)) {
					{
					{
					setState(198);
					s();
					}
					}
					setState(203);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(204);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				match(RBRACE);

				      emit("    }\n");
				      if (!definingFunction) {
				        symbolStack.pop();
				      } else {
				        functionDefDepth--;
				      }
				    
<<<<<<< HEAD
				setState(195);
=======
				setState(207);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_ELSE || _la==KW_ELSE_IF) {
					{
<<<<<<< HEAD
					setState(194);
=======
					setState(206);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
					elsestmt();
					}
				}

				}
				break;
			case KW_ELSE:
				enterOuterAlt(_localctx, 2);
				{
<<<<<<< HEAD
				setState(197);
=======
				setState(209);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				match(KW_ELSE);

				      emit("    else ");
				    
<<<<<<< HEAD
				setState(199);
=======
				setState(211);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				match(LBRACE);

				      emit("{\n");
				      if (!definingFunction) {
				        SymbolTable elseScope = new SymbolTable();
				        symbolStack.push(elseScope);
				      } else {
				        functionDefDepth++;
				      }
				    
<<<<<<< HEAD
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6039867288L) != 0)) {
					{
					{
					setState(201);
					s();
					}
					}
					setState(206);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(207);
=======
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6174154648L) != 0)) {
					{
					{
					setState(213);
					s();
					}
					}
					setState(218);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(219);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				match(RBRACE);

				      emit("    }\n");
				      if (!definingFunction) {
				        symbolStack.pop();
				      } else {
				        functionDefDepth--;
				      }
				    
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForstmtContext extends ParserRuleContext {
		public AsContext a;
		public ConditionContext b;
		public AsContext c;
		public TerminalNode KW_FOR() { return getToken(EmoticonParser.KW_FOR, 0); }
		public TerminalNode LPAREN() { return getToken(EmoticonParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(EmoticonParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(EmoticonParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(EmoticonParser.RBRACE, 0); }
		public List<AsContext> as() {
			return getRuleContexts(AsContext.class);
		}
		public AsContext as(int i) {
			return getRuleContext(AsContext.class,i);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<SContext> s() {
			return getRuleContexts(SContext.class);
		}
		public SContext s(int i) {
			return getRuleContext(SContext.class,i);
		}
		public ForstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forstmt; }
	}

	public final ForstmtContext forstmt() throws RecognitionException {
		ForstmtContext _localctx = new ForstmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_forstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< HEAD
			setState(211);
			match(KW_FOR);
			setState(212);
=======
			setState(223);
			match(KW_FOR);
			setState(224);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			match(LPAREN);

			      //create the block statement stuff
			      SymbolTable forScope = new SymbolTable();
			      symbolStack.push(forScope);

			      // now do assign

			      emit("    for (");
			      forAssign = true;
			    
<<<<<<< HEAD
			setState(214);
			((ForstmtContext)_localctx).a = as();
			setState(215);
			match(T__0);
			setState(216);
			((ForstmtContext)_localctx).b = condition();
			emit(";" + ((ForstmtContext)_localctx).b.result.code + ";");
			setState(218);
			match(T__0);
			setState(219);
			((ForstmtContext)_localctx).c = as();
			setState(220);
=======
			setState(226);
			((ForstmtContext)_localctx).a = as();
			setState(227);
			match(T__0);
			setState(228);
			((ForstmtContext)_localctx).b = condition();
			emit(";" + ((ForstmtContext)_localctx).b.result.code + ";");
			setState(230);
			match(T__0);
			setState(231);
			((ForstmtContext)_localctx).c = as();
			setState(232);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			match(RPAREN);

			      forAssign = false;
			      emit(")");
			    
<<<<<<< HEAD
			setState(222);
=======
			setState(234);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			match(LBRACE);

			      emit(" {\n");
			      if (!definingFunction) {
			        SymbolTable ifScope = new SymbolTable();
			        symbolStack.push(ifScope);
			      } else {
			        functionDefDepth++;
			      }
			    
<<<<<<< HEAD
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6039867288L) != 0)) {
				{
				{
				setState(224);
				s();
				}
				}
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(230);
=======
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6174154648L) != 0)) {
				{
				{
				setState(236);
				s();
				}
				}
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(242);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			match(RBRACE);

			      emit("    }\n");
			      if (!definingFunction) {
			        symbolStack.pop();
			      } else {
			        functionDefDepth--;
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhilestmtContext extends ParserRuleContext {
		public ConditionContext a;
		public TerminalNode KW_WHILE() { return getToken(EmoticonParser.KW_WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(EmoticonParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(EmoticonParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(EmoticonParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(EmoticonParser.RBRACE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<SContext> s() {
			return getRuleContexts(SContext.class);
		}
		public SContext s(int i) {
			return getRuleContext(SContext.class,i);
		}
		public WhilestmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whilestmt; }
	}

	public final WhilestmtContext whilestmt() throws RecognitionException {
		WhilestmtContext _localctx = new WhilestmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_whilestmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< HEAD
			setState(233);
			match(KW_WHILE);
			setState(234);
=======
			setState(245);
			match(KW_WHILE);
			setState(246);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			match(LPAREN);

			    //create the block statement stuff
			      SymbolTable forScope = new SymbolTable();
			      symbolStack.push(forScope);

			      // now do assign

			      emit("    while (");
			  
<<<<<<< HEAD
			setState(236);
			((WhilestmtContext)_localctx).a = condition();
			{emit(((WhilestmtContext)_localctx).a.result.code);} 
			setState(238);
=======
			setState(248);
			((WhilestmtContext)_localctx).a = condition();
			{emit(((WhilestmtContext)_localctx).a.result.code);} 
			setState(250);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			match(RPAREN);

			      emit(")");
			    
<<<<<<< HEAD
			setState(240);
=======
			setState(252);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			match(LBRACE);

			      emit(" {\n");
			      if (!definingFunction) {
			        SymbolTable ifScope = new SymbolTable();
			        symbolStack.push(ifScope);
			      } else {
			        functionDefDepth++;
			      }
			    
<<<<<<< HEAD
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6039867288L) != 0)) {
				{
				{
				setState(242);
				s();
				}
				}
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(248);
=======
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6174154648L) != 0)) {
				{
				{
				setState(254);
				s();
				}
				}
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(260);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			match(RBRACE);

			      emit("    }\n");
			      if (!definingFunction) {
			        symbolStack.pop();
			      } else {
			        functionDefDepth--;
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnstmtContext extends ParserRuleContext {
		public Token KW_RETURN;
		public ExprContext expr;
		public TerminalNode KW_RETURN() { return getToken(EmoticonParser.KW_RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnstmt; }
	}

	public final ReturnstmtContext returnstmt() throws RecognitionException {
		ReturnstmtContext _localctx = new ReturnstmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_returnstmt);
		try {
			setState(269);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(263);
				((ReturnstmtContext)_localctx).KW_RETURN = match(KW_RETURN);
				setState(264);
				((ReturnstmtContext)_localctx).expr = expr();

				    if (!definingFunction || currentFunction == null) {
				      error(((ReturnstmtContext)_localctx).KW_RETURN, "return statement outside function");
				    } else {
				      currentFunction.hasReturn = true;
				      currentFunction.returnType = ((ReturnstmtContext)_localctx).expr.result.type;
				      emit("    return " + ((ReturnstmtContext)_localctx).expr.result.code + ";\n");
				    }
				  
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(267);
				((ReturnstmtContext)_localctx).KW_RETURN = match(KW_RETURN);

				    if (!definingFunction || currentFunction == null) {
				      error(((ReturnstmtContext)_localctx).KW_RETURN, "return statement outside function");
				    } else {
				      emit("    return;\n");
				    }
				  
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionstmtContext extends ParserRuleContext {
		public Token name;
		public Token param;
		public BlockStatementContext body;
		public TerminalNode KW_FUNCTION() { return getToken(EmoticonParser.KW_FUNCTION, 0); }
		public TerminalNode LPAREN() { return getToken(EmoticonParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(EmoticonParser.RPAREN, 0); }
		public List<TerminalNode> IDENT() { return getTokens(EmoticonParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(EmoticonParser.IDENT, i);
		}
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public FunctionstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionstmt; }
	}

	public final FunctionstmtContext functionstmt() throws RecognitionException {
		FunctionstmtContext _localctx = new FunctionstmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_functionstmt);
		try {
<<<<<<< HEAD
			setState(268);
=======
			setState(288);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
<<<<<<< HEAD
				setState(251);
				match(KW_FUNCTION);
				setState(252);
				((FunctionstmtContext)_localctx).name = match(IDENT);
				setState(253);
				match(LPAREN);
				setState(254);
				((FunctionstmtContext)_localctx).param = match(IDENT);
				setState(255);
=======
				setState(271);
				match(KW_FUNCTION);
				setState(272);
				((FunctionstmtContext)_localctx).name = match(IDENT);
				setState(273);
				match(LPAREN);
				setState(274);
				((FunctionstmtContext)_localctx).param = match(IDENT);
				setState(275);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				match(RPAREN);

				    definingFunction = true;
				    functionDefDepth = 0;
				    FunctionDef func = new FunctionDef();
				    func.name = ((FunctionstmtContext)_localctx).name.getText();
				    func.paramName = ((FunctionstmtContext)_localctx).param.getText();
				    func.paramType = Type.FLOAT; // Default parameter type
				    func.returnType = Type.FLOAT; // Default return type
				    func.hasReturn = false;
				    currentFunction = func;
				    functions.put(func.name, func);
				    System.out.println("Defining function '" + func.name + "' with parameter '" + func.paramName + "'");
				    
				    // Create new scope for function
				    SymbolTable functionScope = new SymbolTable();
				    symbolStack.push(functionScope);
				    
				    // Add parameter to function scope
				    Identifier paramId = new Identifier();
				    paramId.id = func.paramName;
				    paramId.type = func.paramType;
				    paramId.hasBeenUsed = false;
				    functionScope.table.put(paramId.id, paramId);
				    
				    // Start capturing function body code
				    StringBuilder oldSb = sb;
				    sb = new StringBuilder();
				  
<<<<<<< HEAD
				setState(257);
				((FunctionstmtContext)_localctx).body = s();
=======
				setState(277);
				((FunctionstmtContext)_localctx).body = blockStatement();
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5

				    // Capture the generated code for this function
				    FunctionDef funcDef = functions.get(((FunctionstmtContext)_localctx).name.getText());
				    funcDef.javaCode = sb.toString();
				    
				    // Restore original string builder
				    sb = oldSb;
				    
				    definingFunction = false;
				    functionDefDepth = 0;
				    currentFunction = null;
				    symbolStack.pop(); // Remove function scope
				    System.out.println("Function '" + funcDef.name + "' defined");
				  
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
<<<<<<< HEAD
				setState(260);
				match(KW_FUNCTION);
				setState(261);
				((FunctionstmtContext)_localctx).name = match(IDENT);
				setState(262);
				match(LPAREN);
				setState(263);
=======
				setState(280);
				match(KW_FUNCTION);
				setState(281);
				((FunctionstmtContext)_localctx).name = match(IDENT);
				setState(282);
				match(LPAREN);
				setState(283);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				match(RPAREN);

				    definingFunction = true;
				    functionDefDepth = 0;
				    FunctionDef func2 = new FunctionDef();
				    func2.name = ((FunctionstmtContext)_localctx).name.getText();
				    func2.paramName = null;
				    func2.returnType = Type.FLOAT; // Default return type
				    func2.hasReturn = false;
				    currentFunction = func2;
				    functions.put(func2.name, func2);
				    System.out.println("Defining function '" + func2.name + "'");
				    
				    // Create new scope for function
				    SymbolTable functionScope = new SymbolTable();
				    symbolStack.push(functionScope);
				    
				    // Start capturing function body code
				    StringBuilder oldSb = sb;
				    sb = new StringBuilder();
				  
<<<<<<< HEAD
				setState(265);
				((FunctionstmtContext)_localctx).body = s();
=======
				setState(285);
				((FunctionstmtContext)_localctx).body = blockStatement();
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5

				    // Capture the generated code for this function
				    FunctionDef funcDef2 = functions.get(((FunctionstmtContext)_localctx).name.getText());
				    funcDef2.javaCode = sb.toString();
				    
				    // Restore original string builder
				    sb = oldSb;
				    
				    definingFunction = false;
				    functionDefDepth = 0;
				    currentFunction = null;
				    symbolStack.pop(); // Remove function scope
				    System.out.println("Function '" + funcDef2.name + "' defined");
				  
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctioncallContext extends ParserRuleContext {
		public ExprResult result;
		public Token IDENT;
		public ExprContext arg;
		public TerminalNode IDENT() { return getToken(EmoticonParser.IDENT, 0); }
		public TerminalNode LPAREN() { return getToken(EmoticonParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(EmoticonParser.RPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FunctioncallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functioncall; }
	}

	public final FunctioncallContext functioncall() throws RecognitionException {
		FunctioncallContext _localctx = new FunctioncallContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_functioncall);

		    ((FunctioncallContext)_localctx).result =  new ExprResult();
		  
		try {
<<<<<<< HEAD
			setState(280);
=======
			setState(300);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
<<<<<<< HEAD
				setState(270);
				((FunctioncallContext)_localctx).IDENT = match(IDENT);
				setState(271);
				match(LPAREN);
				setState(272);
				((FunctioncallContext)_localctx).arg = expr();
				setState(273);
=======
				setState(290);
				((FunctioncallContext)_localctx).IDENT = match(IDENT);
				setState(291);
				match(LPAREN);
				setState(292);
				((FunctioncallContext)_localctx).arg = expr();
				setState(293);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				match(RPAREN);

				    String funcName = ((FunctioncallContext)_localctx).IDENT.getText();
				    if (!functions.containsKey(funcName)) {
				      error(((FunctioncallContext)_localctx).IDENT, "function '" + funcName + "' not defined");
				      _localctx.result.type = Type.UNKNOWN;
				    } else {
				      FunctionDef func = functions.get(funcName);
				      if (func.paramName == null) {
				        error(((FunctioncallContext)_localctx).IDENT, "function '" + funcName + "' does not expect parameters");
				        _localctx.result.type = Type.UNKNOWN;
				      } else {
				        if(((FunctioncallContext)_localctx).arg.result.type == Type.INT || ((FunctioncallContext)_localctx).arg.result.type == Type.FLOAT){
				          System.out.println("Calling function '" + funcName + "' with argument " + ((FunctioncallContext)_localctx).arg.result.numericalValue);
				        } else {
				          System.out.println("Calling function '" + funcName + "' with argument " + ((FunctioncallContext)_localctx).arg.result.stringValue);
				        }
				        
				        // Generate function call code
				        _localctx.result.type = func.returnType;
				        _localctx.result.code = generateFunctionCall(funcName, ((FunctioncallContext)_localctx).arg.result.code, ((FunctioncallContext)_localctx).arg.result.type);
				        _localctx.result.hasKnownValue = false; // Function calls don't have compile-time known values
				      }
				    }
				  
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
<<<<<<< HEAD
				setState(276);
				((FunctioncallContext)_localctx).IDENT = match(IDENT);
				setState(277);
				match(LPAREN);
				setState(278);
=======
				setState(296);
				((FunctioncallContext)_localctx).IDENT = match(IDENT);
				setState(297);
				match(LPAREN);
				setState(298);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				match(RPAREN);

				    String funcName = ((FunctioncallContext)_localctx).IDENT.getText();
				    if (!functions.containsKey(funcName)) {
				      error(((FunctioncallContext)_localctx).IDENT, "function '" + funcName + "' not defined");
				      _localctx.result.type = Type.UNKNOWN;
				    } else {
				      FunctionDef func = functions.get(funcName);
				      if (func.paramName != null) {
				        error(((FunctioncallContext)_localctx).IDENT, "function '" + funcName + "' expects a parameter");
				        _localctx.result.type = Type.UNKNOWN;
				      } else {
				        System.out.println("Calling function '" + funcName + "'");
				        
				        // Generate function call code
				        _localctx.result.type = func.returnType;
				        _localctx.result.code = generateFunctionCall(funcName, null, Type.UNKNOWN);
				        _localctx.result.hasKnownValue = false; // Function calls don't have compile-time known values
				      }
				    }
				  
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArraystmtContext extends ParserRuleContext {
		public Token IDENT;
		public Token size;
		public ArrayInitializerContext arrayInitializer;
		public TerminalNode KW_ARRAY() { return getToken(EmoticonParser.KW_ARRAY, 0); }
		public TerminalNode IDENT() { return getToken(EmoticonParser.IDENT, 0); }
		public List<TerminalNode> ASSIGNMENT() { return getTokens(EmoticonParser.ASSIGNMENT); }
		public TerminalNode ASSIGNMENT(int i) {
			return getToken(EmoticonParser.ASSIGNMENT, i);
		}
		public TerminalNode LBRACKET() { return getToken(EmoticonParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(EmoticonParser.RBRACKET, 0); }
		public TerminalNode INT() { return getToken(EmoticonParser.INT, 0); }
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public ArraystmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arraystmt; }
	}

	public final ArraystmtContext arraystmt() throws RecognitionException {
		ArraystmtContext _localctx = new ArraystmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_arraystmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< HEAD
			setState(282);
			match(KW_ARRAY);
			setState(283);
			((ArraystmtContext)_localctx).IDENT = match(IDENT);
			setState(284);
			match(ASSIGNMENT);
			setState(285);
			match(LBRACKET);
			setState(286);
			((ArraystmtContext)_localctx).size = match(INT);
			setState(287);
			match(RBRACKET);
			setState(290);
=======
			setState(302);
			match(KW_ARRAY);
			setState(303);
			((ArraystmtContext)_localctx).IDENT = match(IDENT);
			setState(304);
			match(ASSIGNMENT);
			setState(305);
			match(LBRACKET);
			setState(306);
			((ArraystmtContext)_localctx).size = match(INT);
			setState(307);
			match(RBRACKET);
			setState(310);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGNMENT) {
				{
<<<<<<< HEAD
				setState(288);
				match(ASSIGNMENT);
				setState(289);
=======
				setState(308);
				match(ASSIGNMENT);
				setState(309);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				((ArraystmtContext)_localctx).arrayInitializer = arrayInitializer();
				}
			}


			    String arrayName = ((ArraystmtContext)_localctx).IDENT.getText();
			    int arraySize = Integer.parseInt(((ArraystmtContext)_localctx).size.getText());
			    
			    // Check if already declared
			    if (existsInCurrentScope(arrayName)) {
			        error(((ArraystmtContext)_localctx).IDENT, "Array '" + arrayName + "' already declared");
			    } else {
			        // Create array identifier
			        Identifier arrayId = new Identifier();
			        arrayId.id = arrayName;
			        arrayId.type = Type.ARRAY;
			        arrayId.isArray = true;
			        arrayId.arraySize = arraySize;
			        arrayId.arrayValues = new Object[arraySize];
			        arrayId.hasKnown = true;
			        
			        addVariable(arrayId);
			        
			        // Generate Java code for array declaration
			        emit("    double[] " + arrayName + " = new double[" + arraySize + "];\n");

			        // If initializer is present:
			        if (((ArraystmtContext)_localctx).arrayInitializer != null) {
			            // Generate initialization code
			            for (int i = 0; i < ((ArraystmtContext)_localctx).arrayInitializer.values.size(); i++) {
			                emit("    " + arrayName + "[" + i + "] = " + 
			                     ((ArraystmtContext)_localctx).arrayInitializer.values.get(i) + ";\n");
			            }
			        }
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayInitializerContext extends ParserRuleContext {
		public List<String> values;
		public ExprContext first;
		public ExprContext rest;
		public TerminalNode LBRACKET() { return getToken(EmoticonParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(EmoticonParser.RBRACKET, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(EmoticonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EmoticonParser.COMMA, i);
		}
		public ArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInitializer; }
	}

	public final ArrayInitializerContext arrayInitializer() throws RecognitionException {
		ArrayInitializerContext _localctx = new ArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_arrayInitializer);
		 ((ArrayInitializerContext)_localctx).values =  new ArrayList<>(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< HEAD
			setState(294);
			match(LBRACKET);
			setState(306);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6039863296L) != 0)) {
				{
				setState(295);
				((ArrayInitializerContext)_localctx).first = expr();
				 _localctx.values.add(((ArrayInitializerContext)_localctx).first.result.code); 
				setState(303);
=======
			setState(314);
			match(LBRACKET);
			setState(326);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6174146560L) != 0)) {
				{
				setState(315);
				((ArrayInitializerContext)_localctx).first = expr();
				 _localctx.values.add(((ArrayInitializerContext)_localctx).first.result.code); 
				setState(323);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
<<<<<<< HEAD
					setState(297);
					match(COMMA);
					setState(298);
=======
					setState(317);
					match(COMMA);
					setState(318);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
					((ArrayInitializerContext)_localctx).rest = expr();
					 _localctx.values.add(((ArrayInitializerContext)_localctx).rest.result.code); 
					}
					}
<<<<<<< HEAD
					setState(305);
=======
					setState(325);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

<<<<<<< HEAD
			setState(308);
=======
			setState(328);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			match(RBRACKET);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(EmoticonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EmoticonParser.COMMA, i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< HEAD
			setState(310);
			expr();
			setState(315);
=======
			setState(330);
			expr();
			setState(335);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
<<<<<<< HEAD
				setState(311);
				match(COMMA);
				setState(312);
				expr();
				}
				}
				setState(317);
=======
				setState(331);
				match(COMMA);
				setState(332);
				expr();
				}
				}
				setState(337);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayAccessContext extends ParserRuleContext {
		public ExprResult result;
		public Token IDENT;
		public ExprContext index;
		public TerminalNode IDENT() { return getToken(EmoticonParser.IDENT, 0); }
		public TerminalNode LBRACKET() { return getToken(EmoticonParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(EmoticonParser.RBRACKET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArrayAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAccess; }
	}

	public final ArrayAccessContext arrayAccess() throws RecognitionException {
		ArrayAccessContext _localctx = new ArrayAccessContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_arrayAccess);
		 ((ArrayAccessContext)_localctx).result =  new ExprResult(); 
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< HEAD
			setState(318);
			((ArrayAccessContext)_localctx).IDENT = match(IDENT);
			setState(319);
			match(LBRACKET);
			setState(320);
			((ArrayAccessContext)_localctx).index = expr();
			setState(321);
=======
			setState(338);
			((ArrayAccessContext)_localctx).IDENT = match(IDENT);
			setState(339);
			match(LBRACKET);
			setState(340);
			((ArrayAccessContext)_localctx).index = expr();
			setState(341);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			match(RBRACKET);

			    String arrayName = ((ArrayAccessContext)_localctx).IDENT.getText();
			    Identifier arrayVar = lookupVariable(arrayName);
			    
			    if (arrayVar == null) {
			        error(((ArrayAccessContext)_localctx).IDENT, "Undefined array '" + arrayName + "'");
			        _localctx.result.type = Type.UNKNOWN;
			    } else if (!arrayVar.isArray) {
			        error(((ArrayAccessContext)_localctx).IDENT, "'" + arrayName + "' is not an array");
			        _localctx.result.type = Type.UNKNOWN;
			    } else {
			        arrayVar.hasBeenUsed = true;
			        _localctx.result.type = Type.FLOAT; // Assuming numeric arrays for now
			        _localctx.result.code = arrayName + "[" + ((ArrayAccessContext)_localctx).index.result.code + "]";
			        
			        // Optional: bounds checking at compile time if index is constant
			        if (((ArrayAccessContext)_localctx).index.result.hasKnownValue && ((ArrayAccessContext)_localctx).index.result.type == Type.INT) {
			            int indexValue = (int)((ArrayAccessContext)_localctx).index.result.numericalValue;
			            if (indexValue < 0 || indexValue >= arrayVar.arraySize) {
			                error(_localctx.start, "Array index " + indexValue + " out of bounds [0, " + (arrayVar.arraySize-1) + "]");
			            }
			        }
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

	@SuppressWarnings("CheckReturnValue")
	public static class OperatorsContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(EmoticonParser.ADD, 0); }
		public TerminalNode SUBTRACT() { return getToken(EmoticonParser.SUBTRACT, 0); }
		public TerminalNode MULTIPLY() { return getToken(EmoticonParser.MULTIPLY, 0); }
		public TerminalNode DIVIDE() { return getToken(EmoticonParser.DIVIDE, 0); }
		public OperatorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operators; }
	}

	public final OperatorsContext operators() throws RecognitionException {
		OperatorsContext _localctx = new OperatorsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_operators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< HEAD
			setState(324);
=======
			setState(344);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3932160L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalsContext extends ParserRuleContext {
		public TerminalNode GREATERTHAN() { return getToken(EmoticonParser.GREATERTHAN, 0); }
		public TerminalNode LESSTHAN() { return getToken(EmoticonParser.LESSTHAN, 0); }
		public TerminalNode GREATERTHANOREQUALTO() { return getToken(EmoticonParser.GREATERTHANOREQUALTO, 0); }
		public TerminalNode LESSTHANOREQUALTO() { return getToken(EmoticonParser.LESSTHANOREQUALTO, 0); }
		public ConditionalsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionals; }
	}

	public final ConditionalsContext conditionals() throws RecognitionException {
		ConditionalsContext _localctx = new ConditionalsContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_conditionals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< HEAD
			setState(326);
=======
			setState(346);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 62914560L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class CompContext extends ParserRuleContext {
		public TerminalNode COMPARISON() { return getToken(EmoticonParser.COMPARISON, 0); }
		public CompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp; }
	}

	public final CompContext comp() throws RecognitionException {
		CompContext _localctx = new CompContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_comp);
		try {
			enterOuterAlt(_localctx, 1);
			{
<<<<<<< HEAD
			setState(328);
=======
			setState(348);
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
			match(COMPARISON);
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

	public static final String _serializedATN =
<<<<<<< HEAD
		"\u0004\u0001&\u014b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
=======
		"\u0004\u0001&\u015f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0001\u0000\u0001\u0000"+
		"\u0005\u00003\b\u0000\n\u0000\f\u00006\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
<<<<<<< HEAD
		"\u0001\u0001\u0003\u0001A\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002F\b\u0002\n\u0002\f\u0002I\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003c\b\u0003"+
		"\u0003\u0003e\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0005\u0005s\b\u0005\n\u0005\f\u0005v\t\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0005\u0006~\b\u0006\n\u0006\f\u0006\u0081\t\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0089"+
		"\b\u0007\n\u0007\f\u0007\u008c\t\u0007\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0003\b\u009e\b\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00a9\b\t\n\t\f\t\u00ac"+
		"\t\t\u0001\t\u0001\t\u0001\t\u0003\t\u00b1\b\t\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00bc\b\n\n\n"+
		"\f\n\u00bf\t\n\u0001\n\u0001\n\u0001\n\u0003\n\u00c4\b\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0005\n\u00cb\b\n\n\n\f\n\u00ce\t\n\u0001\n"+
		"\u0001\n\u0003\n\u00d2\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00e2\b\u000b"+
		"\n\u000b\f\u000b\u00e5\t\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0005\f\u00f4\b\f\n\f\f\f\u00f7\t\f\u0001\f\u0001\f\u0001\f\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u010d"+
		"\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0119"+
		"\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0123\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0005\u0010\u012e\b\u0010\n\u0010\f\u0010\u0131\t\u0010"+
		"\u0003\u0010\u0133\b\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0005\u0011\u013a\b\u0011\n\u0011\f\u0011\u013d\t\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0000\u0000\u0016\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*\u0000\u0004\u0001\u0000\u0015"+
		"\u0018\u0001\u0000\u0011\u0012\u0001\u0000\u0013\u0014\u0001\u0000\u0011"+
		"\u0014\u015c\u0000,\u0001\u0000\u0000\u0000\u0002@\u0001\u0000\u0000\u0000"+
		"\u0004B\u0001\u0000\u0000\u0000\u0006d\u0001\u0000\u0000\u0000\bf\u0001"+
		"\u0000\u0000\u0000\nl\u0001\u0000\u0000\u0000\fw\u0001\u0000\u0000\u0000"+
		"\u000e\u0082\u0001\u0000\u0000\u0000\u0010\u009d\u0001\u0000\u0000\u0000"+
		"\u0012\u009f\u0001\u0000\u0000\u0000\u0014\u00d1\u0001\u0000\u0000\u0000"+
		"\u0016\u00d3\u0001\u0000\u0000\u0000\u0018\u00e9\u0001\u0000\u0000\u0000"+
		"\u001a\u010c\u0001\u0000\u0000\u0000\u001c\u0118\u0001\u0000\u0000\u0000"+
		"\u001e\u011a\u0001\u0000\u0000\u0000 \u0126\u0001\u0000\u0000\u0000\""+
		"\u0136\u0001\u0000\u0000\u0000$\u013e\u0001\u0000\u0000\u0000&\u0144\u0001"+
		"\u0000\u0000\u0000(\u0146\u0001\u0000\u0000\u0000*\u0148\u0001\u0000\u0000"+
		"\u0000,0\u0006\u0000\uffff\uffff\u0000-/\u0003\u0002\u0001\u0000.-\u0001"+
		"\u0000\u0000\u0000/2\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u0000"+
		"01\u0001\u0000\u0000\u000013\u0001\u0000\u0000\u000020\u0001\u0000\u0000"+
		"\u000034\u0005\u0000\u0000\u000145\u0006\u0000\uffff\uffff\u00005\u0001"+
		"\u0001\u0000\u0000\u00006A\u0003\u001c\u000e\u00007A\u0003\u0006\u0003"+
		"\u00008A\u0003\b\u0004\u00009A\u0003\f\u0006\u0000:A\u0003\u001e\u000f"+
		"\u0000;A\u0003\u0004\u0002\u0000<A\u0003\u0012\t\u0000=A\u0003\u0016\u000b"+
		"\u0000>A\u0003\u0018\f\u0000?A\u0003\u001a\r\u0000@6\u0001\u0000\u0000"+
		"\u0000@7\u0001\u0000\u0000\u0000@8\u0001\u0000\u0000\u0000@9\u0001\u0000"+
		"\u0000\u0000@:\u0001\u0000\u0000\u0000@;\u0001\u0000\u0000\u0000@<\u0001"+
		"\u0000\u0000\u0000@=\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000"+
		"@?\u0001\u0000\u0000\u0000A\u0003\u0001\u0000\u0000\u0000BC\u0005\u000b"+
		"\u0000\u0000CG\u0006\u0002\uffff\uffff\u0000DF\u0003\u0002\u0001\u0000"+
		"ED\u0001\u0000\u0000\u0000FI\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000"+
		"\u0000GH\u0001\u0000\u0000\u0000HJ\u0001\u0000\u0000\u0000IG\u0001\u0000"+
		"\u0000\u0000JK\u0005\f\u0000\u0000KL\u0006\u0002\uffff\uffff\u0000L\u0005"+
		"\u0001\u0000\u0000\u0000MN\u0003$\u0012\u0000NO\u0005&\u0000\u0000OP\u0003"+
		"\f\u0006\u0000PQ\u0006\u0003\uffff\uffff\u0000Qe\u0001\u0000\u0000\u0000"+
		"RS\u0005\u0010\u0000\u0000Sb\u0005&\u0000\u0000TU\u0003\f\u0006\u0000"+
		"UV\u0006\u0003\uffff\uffff\u0000Vc\u0001\u0000\u0000\u0000WX\u0005\u001b"+
		"\u0000\u0000Xc\u0006\u0003\uffff\uffff\u0000YZ\u0005\u001e\u0000\u0000"+
		"Zc\u0006\u0003\uffff\uffff\u0000[\\\u0005\u001d\u0000\u0000\\c\u0006\u0003"+
		"\uffff\uffff\u0000]^\u0005\u001c\u0000\u0000^c\u0006\u0003\uffff\uffff"+
		"\u0000_`\u0005\u0002\u0000\u0000`c\u0006\u0003\uffff\uffff\u0000ac\u0006"+
		"\u0003\uffff\uffff\u0000bT\u0001\u0000\u0000\u0000bW\u0001\u0000\u0000"+
		"\u0000bY\u0001\u0000\u0000\u0000b[\u0001\u0000\u0000\u0000b]\u0001\u0000"+
		"\u0000\u0000b_\u0001\u0000\u0000\u0000ba\u0001\u0000\u0000\u0000ce\u0001"+
		"\u0000\u0000\u0000dM\u0001\u0000\u0000\u0000dR\u0001\u0000\u0000\u0000"+
		"e\u0007\u0001\u0000\u0000\u0000fg\u0005\u0003\u0000\u0000gh\u0005 \u0000"+
		"\u0000hi\u0003\f\u0006\u0000ij\u0005!\u0000\u0000jk\u0006\u0004\uffff"+
		"\uffff\u0000k\t\u0001\u0000\u0000\u0000lm\u0003\f\u0006\u0000mt\u0006"+
		"\u0005\uffff\uffff\u0000no\u0007\u0000\u0000\u0000op\u0003\f\u0006\u0000"+
		"pq\u0006\u0005\uffff\uffff\u0000qs\u0001\u0000\u0000\u0000rn\u0001\u0000"+
		"\u0000\u0000sv\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000tu\u0001"+
		"\u0000\u0000\u0000u\u000b\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000"+
		"\u0000wx\u0003\u000e\u0007\u0000x\u007f\u0006\u0006\uffff\uffff\u0000"+
		"yz\u0007\u0001\u0000\u0000z{\u0003\u000e\u0007\u0000{|\u0006\u0006\uffff"+
		"\uffff\u0000|~\u0001\u0000\u0000\u0000}y\u0001\u0000\u0000\u0000~\u0081"+
		"\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f\u0080\u0001"+
		"\u0000\u0000\u0000\u0080\r\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000"+
		"\u0000\u0000\u0082\u0083\u0003\u0010\b\u0000\u0083\u008a\u0006\u0007\uffff"+
		"\uffff\u0000\u0084\u0085\u0007\u0002\u0000\u0000\u0085\u0086\u0003\u0010"+
		"\b\u0000\u0086\u0087\u0006\u0007\uffff\uffff\u0000\u0087\u0089\u0001\u0000"+
		"\u0000\u0000\u0088\u0084\u0001\u0000\u0000\u0000\u0089\u008c\u0001\u0000"+
		"\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000"+
		"\u0000\u0000\u008b\u000f\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0005\u001b\u0000\u0000\u008e\u009e\u0006\b\uffff"+
		"\uffff\u0000\u008f\u0090\u0005\u001d\u0000\u0000\u0090\u009e\u0006\b\uffff"+
		"\uffff\u0000\u0091\u0092\u0005\u001e\u0000\u0000\u0092\u009e\u0006\b\uffff"+
		"\uffff\u0000\u0093\u0094\u0003$\u0012\u0000\u0094\u0095\u0006\b\uffff"+
		"\uffff\u0000\u0095\u009e\u0001\u0000\u0000\u0000\u0096\u0097\u0005\u0010"+
		"\u0000\u0000\u0097\u009e\u0006\b\uffff\uffff\u0000\u0098\u0099\u0005 "+
		"\u0000\u0000\u0099\u009a\u0003\f\u0006\u0000\u009a\u009b\u0005!\u0000"+
		"\u0000\u009b\u009c\u0006\b\uffff\uffff\u0000\u009c\u009e\u0001\u0000\u0000"+
		"\u0000\u009d\u008d\u0001\u0000\u0000\u0000\u009d\u008f\u0001\u0000\u0000"+
		"\u0000\u009d\u0091\u0001\u0000\u0000\u0000\u009d\u0093\u0001\u0000\u0000"+
		"\u0000\u009d\u0096\u0001\u0000\u0000\u0000\u009d\u0098\u0001\u0000\u0000"+
		"\u0000\u009e\u0011\u0001\u0000\u0000\u0000\u009f\u00a0\u0005\u0004\u0000"+
		"\u0000\u00a0\u00a1\u0006\t\uffff\uffff\u0000\u00a1\u00a2\u0005 \u0000"+
		"\u0000\u00a2\u00a3\u0003\n\u0005\u0000\u00a3\u00a4\u0005!\u0000\u0000"+
		"\u00a4\u00a5\u0006\t\uffff\uffff\u0000\u00a5\u00a6\u0005\u000b\u0000\u0000"+
		"\u00a6\u00aa\u0006\t\uffff\uffff\u0000\u00a7\u00a9\u0003\u0002\u0001\u0000"+
		"\u00a8\u00a7\u0001\u0000\u0000\u0000\u00a9\u00ac\u0001\u0000\u0000\u0000"+
		"\u00aa\u00a8\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000"+
		"\u00ab\u00ad\u0001\u0000\u0000\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000"+
		"\u00ad\u00ae\u0005\f\u0000\u0000\u00ae\u00b0\u0006\t\uffff\uffff\u0000"+
		"\u00af\u00b1\u0003\u0014\n\u0000\u00b0\u00af\u0001\u0000\u0000\u0000\u00b0"+
		"\u00b1\u0001\u0000\u0000\u0000\u00b1\u0013\u0001\u0000\u0000\u0000\u00b2"+
		"\u00b3\u0005\u0006\u0000\u0000\u00b3\u00b4\u0006\n\uffff\uffff\u0000\u00b4"+
		"\u00b5\u0005 \u0000\u0000\u00b5\u00b6\u0003\n\u0005\u0000\u00b6\u00b7"+
		"\u0005!\u0000\u0000\u00b7\u00b8\u0006\n\uffff\uffff\u0000\u00b8\u00b9"+
		"\u0005\u000b\u0000\u0000\u00b9\u00bd\u0006\n\uffff\uffff\u0000\u00ba\u00bc"+
		"\u0003\u0002\u0001\u0000\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bf"+
		"\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00bd\u00be"+
		"\u0001\u0000\u0000\u0000\u00be\u00c0\u0001\u0000\u0000\u0000\u00bf\u00bd"+
		"\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005\f\u0000\u0000\u00c1\u00c3\u0006"+
		"\n\uffff\uffff\u0000\u00c2\u00c4\u0003\u0014\n\u0000\u00c3\u00c2\u0001"+
		"\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4\u00d2\u0001"+
		"\u0000\u0000\u0000\u00c5\u00c6\u0005\u0005\u0000\u0000\u00c6\u00c7\u0006"+
		"\n\uffff\uffff\u0000\u00c7\u00c8\u0005\u000b\u0000\u0000\u00c8\u00cc\u0006"+
		"\n\uffff\uffff\u0000\u00c9\u00cb\u0003\u0002\u0001\u0000\u00ca\u00c9\u0001"+
		"\u0000\u0000\u0000\u00cb\u00ce\u0001\u0000\u0000\u0000\u00cc\u00ca\u0001"+
		"\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u00cf\u0001"+
		"\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005"+
		"\f\u0000\u0000\u00d0\u00d2\u0006\n\uffff\uffff\u0000\u00d1\u00b2\u0001"+
		"\u0000\u0000\u0000\u00d1\u00c5\u0001\u0000\u0000\u0000\u00d2\u0015\u0001"+
		"\u0000\u0000\u0000\u00d3\u00d4\u0005\u0007\u0000\u0000\u00d4\u00d5\u0005"+
		" \u0000\u0000\u00d5\u00d6\u0006\u000b\uffff\uffff\u0000\u00d6\u00d7\u0003"+
		"\u0006\u0003\u0000\u00d7\u00d8\u0005\u0001\u0000\u0000\u00d8\u00d9\u0003"+
		"\n\u0005\u0000\u00d9\u00da\u0006\u000b\uffff\uffff\u0000\u00da\u00db\u0005"+
		"\u0001\u0000\u0000\u00db\u00dc\u0003\u0006\u0003\u0000\u00dc\u00dd\u0005"+
		"!\u0000\u0000\u00dd\u00de\u0006\u000b\uffff\uffff\u0000\u00de\u00df\u0005"+
		"\u000b\u0000\u0000\u00df\u00e3\u0006\u000b\uffff\uffff\u0000\u00e0\u00e2"+
		"\u0003\u0002\u0001\u0000\u00e1\u00e0\u0001\u0000\u0000\u0000\u00e2\u00e5"+
		"\u0001\u0000\u0000\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e3\u00e4"+
		"\u0001\u0000\u0000\u0000\u00e4\u00e6\u0001\u0000\u0000\u0000\u00e5\u00e3"+
		"\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005\f\u0000\u0000\u00e7\u00e8\u0006"+
		"\u000b\uffff\uffff\u0000\u00e8\u0017\u0001\u0000\u0000\u0000\u00e9\u00ea"+
		"\u0005\b\u0000\u0000\u00ea\u00eb\u0005 \u0000\u0000\u00eb\u00ec\u0006"+
		"\f\uffff\uffff\u0000\u00ec\u00ed\u0003\n\u0005\u0000\u00ed\u00ee\u0006"+
		"\f\uffff\uffff\u0000\u00ee\u00ef\u0005!\u0000\u0000\u00ef\u00f0\u0006"+
		"\f\uffff\uffff\u0000\u00f0\u00f1\u0005\u000b\u0000\u0000\u00f1\u00f5\u0006"+
		"\f\uffff\uffff\u0000\u00f2\u00f4\u0003\u0002\u0001\u0000\u00f3\u00f2\u0001"+
		"\u0000\u0000\u0000\u00f4\u00f7\u0001\u0000\u0000\u0000\u00f5\u00f3\u0001"+
		"\u0000\u0000\u0000\u00f5\u00f6\u0001\u0000\u0000\u0000\u00f6\u00f8\u0001"+
		"\u0000\u0000\u0000\u00f7\u00f5\u0001\u0000\u0000\u0000\u00f8\u00f9\u0005"+
		"\f\u0000\u0000\u00f9\u00fa\u0006\f\uffff\uffff\u0000\u00fa\u0019\u0001"+
		"\u0000\u0000\u0000\u00fb\u00fc\u0005\t\u0000\u0000\u00fc\u00fd\u0005\u0010"+
		"\u0000\u0000\u00fd\u00fe\u0005 \u0000\u0000\u00fe\u00ff\u0005\u0010\u0000"+
		"\u0000\u00ff\u0100\u0005!\u0000\u0000\u0100\u0101\u0006\r\uffff\uffff"+
		"\u0000\u0101\u0102\u0003\u0002\u0001\u0000\u0102\u0103\u0006\r\uffff\uffff"+
		"\u0000\u0103\u010d\u0001\u0000\u0000\u0000\u0104\u0105\u0005\t\u0000\u0000"+
		"\u0105\u0106\u0005\u0010\u0000\u0000\u0106\u0107\u0005 \u0000\u0000\u0107"+
		"\u0108\u0005!\u0000\u0000\u0108\u0109\u0006\r\uffff\uffff\u0000\u0109"+
		"\u010a\u0003\u0002\u0001\u0000\u010a\u010b\u0006\r\uffff\uffff\u0000\u010b"+
		"\u010d\u0001\u0000\u0000\u0000\u010c\u00fb\u0001\u0000\u0000\u0000\u010c"+
		"\u0104\u0001\u0000\u0000\u0000\u010d\u001b\u0001\u0000\u0000\u0000\u010e"+
		"\u010f\u0005\u0010\u0000\u0000\u010f\u0110\u0005 \u0000\u0000\u0110\u0111"+
		"\u0003\f\u0006\u0000\u0111\u0112\u0005!\u0000\u0000\u0112\u0113\u0006"+
		"\u000e\uffff\uffff\u0000\u0113\u0119\u0001\u0000\u0000\u0000\u0114\u0115"+
		"\u0005\u0010\u0000\u0000\u0115\u0116\u0005 \u0000\u0000\u0116\u0117\u0005"+
		"!\u0000\u0000\u0117\u0119\u0006\u000e\uffff\uffff\u0000\u0118\u010e\u0001"+
		"\u0000\u0000\u0000\u0118\u0114\u0001\u0000\u0000\u0000\u0119\u001d\u0001"+
		"\u0000\u0000\u0000\u011a\u011b\u0005\n\u0000\u0000\u011b\u011c\u0005\u0010"+
		"\u0000\u0000\u011c\u011d\u0005&\u0000\u0000\u011d\u011e\u0005\u0019\u0000"+
		"\u0000\u011e\u011f\u0005\u001b\u0000\u0000\u011f\u0122\u0005\u001a\u0000"+
		"\u0000\u0120\u0121\u0005&\u0000\u0000\u0121\u0123\u0003 \u0010\u0000\u0122"+
		"\u0120\u0001\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000\u0123"+
		"\u0124\u0001\u0000\u0000\u0000\u0124\u0125\u0006\u000f\uffff\uffff\u0000"+
		"\u0125\u001f\u0001\u0000\u0000\u0000\u0126\u0132\u0005\u0019\u0000\u0000"+
		"\u0127\u0128\u0003\f\u0006\u0000\u0128\u012f\u0006\u0010\uffff\uffff\u0000"+
		"\u0129\u012a\u0005\"\u0000\u0000\u012a\u012b\u0003\f\u0006\u0000\u012b"+
		"\u012c\u0006\u0010\uffff\uffff\u0000\u012c\u012e\u0001\u0000\u0000\u0000"+
		"\u012d\u0129\u0001\u0000\u0000\u0000\u012e\u0131\u0001\u0000\u0000\u0000"+
		"\u012f\u012d\u0001\u0000\u0000\u0000\u012f\u0130\u0001\u0000\u0000\u0000"+
		"\u0130\u0133\u0001\u0000\u0000\u0000\u0131\u012f\u0001\u0000\u0000\u0000"+
		"\u0132\u0127\u0001\u0000\u0000\u0000\u0132\u0133\u0001\u0000\u0000\u0000"+
		"\u0133\u0134\u0001\u0000\u0000\u0000\u0134\u0135\u0005\u001a\u0000\u0000"+
		"\u0135!\u0001\u0000\u0000\u0000\u0136\u013b\u0003\f\u0006\u0000\u0137"+
		"\u0138\u0005\"\u0000\u0000\u0138\u013a\u0003\f\u0006\u0000\u0139\u0137"+
		"\u0001\u0000\u0000\u0000\u013a\u013d\u0001\u0000\u0000\u0000\u013b\u0139"+
		"\u0001\u0000\u0000\u0000\u013b\u013c\u0001\u0000\u0000\u0000\u013c#\u0001"+
		"\u0000\u0000\u0000\u013d\u013b\u0001\u0000\u0000\u0000\u013e\u013f\u0005"+
		"\u0010\u0000\u0000\u013f\u0140\u0005\u0019\u0000\u0000\u0140\u0141\u0003"+
		"\f\u0006\u0000\u0141\u0142\u0005\u001a\u0000\u0000\u0142\u0143\u0006\u0012"+
		"\uffff\uffff\u0000\u0143%\u0001\u0000\u0000\u0000\u0144\u0145\u0007\u0003"+
		"\u0000\u0000\u0145\'\u0001\u0000\u0000\u0000\u0146\u0147\u0007\u0000\u0000"+
		"\u0000\u0147)\u0001\u0000\u0000\u0000\u0148\u0149\u0005%\u0000\u0000\u0149"+
		"+\u0001\u0000\u0000\u0000\u00170@Gbdt\u007f\u008a\u009d\u00aa\u00b0\u00bd"+
		"\u00c3\u00cc\u00d1\u00e3\u00f5\u010c\u0118\u0122\u012f\u0132\u013b";
=======
		"\u0003\u0001F\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0005\u0003N\b\u0003\n\u0003\f\u0003Q\t\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004i\b\u0004"+
		"\u0003\u0004k\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0005\u0006y\b\u0006\n\u0006\f\u0006|\t\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0005\u0007\u0084\b\u0007\n\u0007\f\u0007\u0087\t\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u008f\b\b\n\b\f\b\u0092\t\b"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00aa\b\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00b5\b\n\n"+
		"\n\f\n\u00b8\t\n\u0001\n\u0001\n\u0001\n\u0003\n\u00bd\b\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0005\u000b\u00c8\b\u000b\n\u000b\f\u000b\u00cb"+
		"\t\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00d0\b\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b"+
		"\u00d7\b\u000b\n\u000b\f\u000b\u00da\t\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u00de\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00ee"+
		"\b\f\n\f\f\f\u00f1\t\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u0100"+
		"\b\r\n\r\f\r\u0103\t\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u010e\b\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u0121\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010"+
		"\u012d\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0137\b\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0005\u0012\u0142\b\u0012\n\u0012\f\u0012\u0145"+
		"\t\u0012\u0003\u0012\u0147\b\u0012\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0005\u0013\u014e\b\u0013\n\u0013\f\u0013\u0151"+
		"\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0000\u0000\u0018\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.\u0000\u0004"+
		"\u0001\u0000\u0016\u0019\u0001\u0000\u0012\u0013\u0001\u0000\u0014\u0015"+
		"\u0001\u0000\u0012\u0015\u0171\u00000\u0001\u0000\u0000\u0000\u0002E\u0001"+
		"\u0000\u0000\u0000\u0004G\u0001\u0000\u0000\u0000\u0006J\u0001\u0000\u0000"+
		"\u0000\bj\u0001\u0000\u0000\u0000\nl\u0001\u0000\u0000\u0000\fr\u0001"+
		"\u0000\u0000\u0000\u000e}\u0001\u0000\u0000\u0000\u0010\u0088\u0001\u0000"+
		"\u0000\u0000\u0012\u00a9\u0001\u0000\u0000\u0000\u0014\u00ab\u0001\u0000"+
		"\u0000\u0000\u0016\u00dd\u0001\u0000\u0000\u0000\u0018\u00df\u0001\u0000"+
		"\u0000\u0000\u001a\u00f5\u0001\u0000\u0000\u0000\u001c\u010d\u0001\u0000"+
		"\u0000\u0000\u001e\u0120\u0001\u0000\u0000\u0000 \u012c\u0001\u0000\u0000"+
		"\u0000\"\u012e\u0001\u0000\u0000\u0000$\u013a\u0001\u0000\u0000\u0000"+
		"&\u014a\u0001\u0000\u0000\u0000(\u0152\u0001\u0000\u0000\u0000*\u0158"+
		"\u0001\u0000\u0000\u0000,\u015a\u0001\u0000\u0000\u0000.\u015c\u0001\u0000"+
		"\u0000\u000004\u0006\u0000\uffff\uffff\u000013\u0003\u0002\u0001\u0000"+
		"21\u0001\u0000\u0000\u000036\u0001\u0000\u0000\u000042\u0001\u0000\u0000"+
		"\u000045\u0001\u0000\u0000\u000057\u0001\u0000\u0000\u000064\u0001\u0000"+
		"\u0000\u000078\u0005\u0000\u0000\u000189\u0006\u0000\uffff\uffff\u0000"+
		"9\u0001\u0001\u0000\u0000\u0000:F\u0003\u0004\u0002\u0000;F\u0003\b\u0004"+
		"\u0000<F\u0003\n\u0005\u0000=F\u0003\u000e\u0007\u0000>F\u0003\"\u0011"+
		"\u0000?F\u0003\u0006\u0003\u0000@F\u0003\u0014\n\u0000AF\u0003\u0018\f"+
		"\u0000BF\u0003\u001a\r\u0000CF\u0003\u001e\u000f\u0000DF\u0003\u001c\u000e"+
		"\u0000E:\u0001\u0000\u0000\u0000E;\u0001\u0000\u0000\u0000E<\u0001\u0000"+
		"\u0000\u0000E=\u0001\u0000\u0000\u0000E>\u0001\u0000\u0000\u0000E?\u0001"+
		"\u0000\u0000\u0000E@\u0001\u0000\u0000\u0000EA\u0001\u0000\u0000\u0000"+
		"EB\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000ED\u0001\u0000\u0000"+
		"\u0000F\u0003\u0001\u0000\u0000\u0000GH\u0003 \u0010\u0000HI\u0006\u0002"+
		"\uffff\uffff\u0000I\u0005\u0001\u0000\u0000\u0000JK\u0005\f\u0000\u0000"+
		"KO\u0006\u0003\uffff\uffff\u0000LN\u0003\u0002\u0001\u0000ML\u0001\u0000"+
		"\u0000\u0000NQ\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000OP\u0001"+
		"\u0000\u0000\u0000PR\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000"+
		"RS\u0005\r\u0000\u0000ST\u0006\u0003\uffff\uffff\u0000T\u0007\u0001\u0000"+
		"\u0000\u0000UV\u0003(\u0014\u0000VW\u0005&\u0000\u0000WX\u0003\u000e\u0007"+
		"\u0000XY\u0006\u0004\uffff\uffff\u0000Yk\u0001\u0000\u0000\u0000Z[\u0005"+
		"\u0011\u0000\u0000[h\u0005&\u0000\u0000\\]\u0003\u000e\u0007\u0000]^\u0006"+
		"\u0004\uffff\uffff\u0000^i\u0001\u0000\u0000\u0000_`\u0005\u001c\u0000"+
		"\u0000`i\u0006\u0004\uffff\uffff\u0000ab\u0005\u001e\u0000\u0000bi\u0006"+
		"\u0004\uffff\uffff\u0000cd\u0005\u001d\u0000\u0000di\u0006\u0004\uffff"+
		"\uffff\u0000ef\u0005\u0002\u0000\u0000fi\u0006\u0004\uffff\uffff\u0000"+
		"gi\u0006\u0004\uffff\uffff\u0000h\\\u0001\u0000\u0000\u0000h_\u0001\u0000"+
		"\u0000\u0000ha\u0001\u0000\u0000\u0000hc\u0001\u0000\u0000\u0000he\u0001"+
		"\u0000\u0000\u0000hg\u0001\u0000\u0000\u0000ik\u0001\u0000\u0000\u0000"+
		"jU\u0001\u0000\u0000\u0000jZ\u0001\u0000\u0000\u0000k\t\u0001\u0000\u0000"+
		"\u0000lm\u0005\u0003\u0000\u0000mn\u0005 \u0000\u0000no\u0003\u000e\u0007"+
		"\u0000op\u0005!\u0000\u0000pq\u0006\u0005\uffff\uffff\u0000q\u000b\u0001"+
		"\u0000\u0000\u0000rs\u0003\u000e\u0007\u0000sz\u0006\u0006\uffff\uffff"+
		"\u0000tu\u0007\u0000\u0000\u0000uv\u0003\u000e\u0007\u0000vw\u0006\u0006"+
		"\uffff\uffff\u0000wy\u0001\u0000\u0000\u0000xt\u0001\u0000\u0000\u0000"+
		"y|\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000"+
		"\u0000{\r\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000}~\u0003\u0010"+
		"\b\u0000~\u0085\u0006\u0007\uffff\uffff\u0000\u007f\u0080\u0007\u0001"+
		"\u0000\u0000\u0080\u0081\u0003\u0010\b\u0000\u0081\u0082\u0006\u0007\uffff"+
		"\uffff\u0000\u0082\u0084\u0001\u0000\u0000\u0000\u0083\u007f\u0001\u0000"+
		"\u0000\u0000\u0084\u0087\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000"+
		"\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u000f\u0001\u0000"+
		"\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0088\u0089\u0003\u0012"+
		"\t\u0000\u0089\u0090\u0006\b\uffff\uffff\u0000\u008a\u008b\u0007\u0002"+
		"\u0000\u0000\u008b\u008c\u0003\u0012\t\u0000\u008c\u008d\u0006\b\uffff"+
		"\uffff\u0000\u008d\u008f\u0001\u0000\u0000\u0000\u008e\u008a\u0001\u0000"+
		"\u0000\u0000\u008f\u0092\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000"+
		"\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0011\u0001\u0000"+
		"\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0093\u0094\u0005\u001c"+
		"\u0000\u0000\u0094\u00aa\u0006\t\uffff\uffff\u0000\u0095\u0096\u0005\u001d"+
		"\u0000\u0000\u0096\u00aa\u0006\t\uffff\uffff\u0000\u0097\u0098\u0005\u001e"+
		"\u0000\u0000\u0098\u00aa\u0006\t\uffff\uffff\u0000\u0099\u009a\u0003("+
		"\u0014\u0000\u009a\u009b\u0006\t\uffff\uffff\u0000\u009b\u00aa\u0001\u0000"+
		"\u0000\u0000\u009c\u009d\u0003 \u0010\u0000\u009d\u009e\u0006\t\uffff"+
		"\uffff\u0000\u009e\u00aa\u0001\u0000\u0000\u0000\u009f\u00a0\u0005\u0011"+
		"\u0000\u0000\u00a0\u00aa\u0006\t\uffff\uffff\u0000\u00a1\u00a2\u0003 "+
		"\u0010\u0000\u00a2\u00a3\u0006\t\uffff\uffff\u0000\u00a3\u00aa\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a5\u0005 \u0000\u0000\u00a5\u00a6\u0003\u000e\u0007"+
		"\u0000\u00a6\u00a7\u0005!\u0000\u0000\u00a7\u00a8\u0006\t\uffff\uffff"+
		"\u0000\u00a8\u00aa\u0001\u0000\u0000\u0000\u00a9\u0093\u0001\u0000\u0000"+
		"\u0000\u00a9\u0095\u0001\u0000\u0000\u0000\u00a9\u0097\u0001\u0000\u0000"+
		"\u0000\u00a9\u0099\u0001\u0000\u0000\u0000\u00a9\u009c\u0001\u0000\u0000"+
		"\u0000\u00a9\u009f\u0001\u0000\u0000\u0000\u00a9\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a9\u00a4\u0001\u0000\u0000\u0000\u00aa\u0013\u0001\u0000\u0000"+
		"\u0000\u00ab\u00ac\u0005\u0004\u0000\u0000\u00ac\u00ad\u0006\n\uffff\uffff"+
		"\u0000\u00ad\u00ae\u0005 \u0000\u0000\u00ae\u00af\u0003\f\u0006\u0000"+
		"\u00af\u00b0\u0005!\u0000\u0000\u00b0\u00b1\u0006\n\uffff\uffff\u0000"+
		"\u00b1\u00b2\u0005\f\u0000\u0000\u00b2\u00b6\u0006\n\uffff\uffff\u0000"+
		"\u00b3\u00b5\u0003\u0002\u0001\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b8\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u00b9\u0001\u0000\u0000\u0000"+
		"\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005\r\u0000\u0000\u00ba"+
		"\u00bc\u0006\n\uffff\uffff\u0000\u00bb\u00bd\u0003\u0016\u000b\u0000\u00bc"+
		"\u00bb\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd"+
		"\u0015\u0001\u0000\u0000\u0000\u00be\u00bf\u0005\u0006\u0000\u0000\u00bf"+
		"\u00c0\u0006\u000b\uffff\uffff\u0000\u00c0\u00c1\u0005 \u0000\u0000\u00c1"+
		"\u00c2\u0003\f\u0006\u0000\u00c2\u00c3\u0005!\u0000\u0000\u00c3\u00c4"+
		"\u0006\u000b\uffff\uffff\u0000\u00c4\u00c5\u0005\f\u0000\u0000\u00c5\u00c9"+
		"\u0006\u000b\uffff\uffff\u0000\u00c6\u00c8\u0003\u0002\u0001\u0000\u00c7"+
		"\u00c6\u0001\u0000\u0000\u0000\u00c8\u00cb\u0001\u0000\u0000\u0000\u00c9"+
		"\u00c7\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca"+
		"\u00cc\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cc"+
		"\u00cd\u0005\r\u0000\u0000\u00cd\u00cf\u0006\u000b\uffff\uffff\u0000\u00ce"+
		"\u00d0\u0003\u0016\u000b\u0000\u00cf\u00ce\u0001\u0000\u0000\u0000\u00cf"+
		"\u00d0\u0001\u0000\u0000\u0000\u00d0\u00de\u0001\u0000\u0000\u0000\u00d1"+
		"\u00d2\u0005\u0005\u0000\u0000\u00d2\u00d3\u0006\u000b\uffff\uffff\u0000"+
		"\u00d3\u00d4\u0005\f\u0000\u0000\u00d4\u00d8\u0006\u000b\uffff\uffff\u0000"+
		"\u00d5\u00d7\u0003\u0002\u0001\u0000\u00d6\u00d5\u0001\u0000\u0000\u0000"+
		"\u00d7\u00da\u0001\u0000\u0000\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000"+
		"\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u00db\u0001\u0000\u0000\u0000"+
		"\u00da\u00d8\u0001\u0000\u0000\u0000\u00db\u00dc\u0005\r\u0000\u0000\u00dc"+
		"\u00de\u0006\u000b\uffff\uffff\u0000\u00dd\u00be\u0001\u0000\u0000\u0000"+
		"\u00dd\u00d1\u0001\u0000\u0000\u0000\u00de\u0017\u0001\u0000\u0000\u0000"+
		"\u00df\u00e0\u0005\u0007\u0000\u0000\u00e0\u00e1\u0005 \u0000\u0000\u00e1"+
		"\u00e2\u0006\f\uffff\uffff\u0000\u00e2\u00e3\u0003\b\u0004\u0000\u00e3"+
		"\u00e4\u0005\u0001\u0000\u0000\u00e4\u00e5\u0003\f\u0006\u0000\u00e5\u00e6"+
		"\u0006\f\uffff\uffff\u0000\u00e6\u00e7\u0005\u0001\u0000\u0000\u00e7\u00e8"+
		"\u0003\b\u0004\u0000\u00e8\u00e9\u0005!\u0000\u0000\u00e9\u00ea\u0006"+
		"\f\uffff\uffff\u0000\u00ea\u00eb\u0005\f\u0000\u0000\u00eb\u00ef\u0006"+
		"\f\uffff\uffff\u0000\u00ec\u00ee\u0003\u0002\u0001\u0000\u00ed\u00ec\u0001"+
		"\u0000\u0000\u0000\u00ee\u00f1\u0001\u0000\u0000\u0000\u00ef\u00ed\u0001"+
		"\u0000\u0000\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0\u00f2\u0001"+
		"\u0000\u0000\u0000\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005"+
		"\r\u0000\u0000\u00f3\u00f4\u0006\f\uffff\uffff\u0000\u00f4\u0019\u0001"+
		"\u0000\u0000\u0000\u00f5\u00f6\u0005\b\u0000\u0000\u00f6\u00f7\u0005 "+
		"\u0000\u0000\u00f7\u00f8\u0006\r\uffff\uffff\u0000\u00f8\u00f9\u0003\f"+
		"\u0006\u0000\u00f9\u00fa\u0006\r\uffff\uffff\u0000\u00fa\u00fb\u0005!"+
		"\u0000\u0000\u00fb\u00fc\u0006\r\uffff\uffff\u0000\u00fc\u00fd\u0005\f"+
		"\u0000\u0000\u00fd\u0101\u0006\r\uffff\uffff\u0000\u00fe\u0100\u0003\u0002"+
		"\u0001\u0000\u00ff\u00fe\u0001\u0000\u0000\u0000\u0100\u0103\u0001\u0000"+
		"\u0000\u0000\u0101\u00ff\u0001\u0000\u0000\u0000\u0101\u0102\u0001\u0000"+
		"\u0000\u0000\u0102\u0104\u0001\u0000\u0000\u0000\u0103\u0101\u0001\u0000"+
		"\u0000\u0000\u0104\u0105\u0005\r\u0000\u0000\u0105\u0106\u0006\r\uffff"+
		"\uffff\u0000\u0106\u001b\u0001\u0000\u0000\u0000\u0107\u0108\u0005\t\u0000"+
		"\u0000\u0108\u0109\u0003\u000e\u0007\u0000\u0109\u010a\u0006\u000e\uffff"+
		"\uffff\u0000\u010a\u010e\u0001\u0000\u0000\u0000\u010b\u010c\u0005\t\u0000"+
		"\u0000\u010c\u010e\u0006\u000e\uffff\uffff\u0000\u010d\u0107\u0001\u0000"+
		"\u0000\u0000\u010d\u010b\u0001\u0000\u0000\u0000\u010e\u001d\u0001\u0000"+
		"\u0000\u0000\u010f\u0110\u0005\n\u0000\u0000\u0110\u0111\u0005\u0011\u0000"+
		"\u0000\u0111\u0112\u0005 \u0000\u0000\u0112\u0113\u0005\u0011\u0000\u0000"+
		"\u0113\u0114\u0005!\u0000\u0000\u0114\u0115\u0006\u000f\uffff\uffff\u0000"+
		"\u0115\u0116\u0003\u0006\u0003\u0000\u0116\u0117\u0006\u000f\uffff\uffff"+
		"\u0000\u0117\u0121\u0001\u0000\u0000\u0000\u0118\u0119\u0005\n\u0000\u0000"+
		"\u0119\u011a\u0005\u0011\u0000\u0000\u011a\u011b\u0005 \u0000\u0000\u011b"+
		"\u011c\u0005!\u0000\u0000\u011c\u011d\u0006\u000f\uffff\uffff\u0000\u011d"+
		"\u011e\u0003\u0006\u0003\u0000\u011e\u011f\u0006\u000f\uffff\uffff\u0000"+
		"\u011f\u0121\u0001\u0000\u0000\u0000\u0120\u010f\u0001\u0000\u0000\u0000"+
		"\u0120\u0118\u0001\u0000\u0000\u0000\u0121\u001f\u0001\u0000\u0000\u0000"+
		"\u0122\u0123\u0005\u0011\u0000\u0000\u0123\u0124\u0005 \u0000\u0000\u0124"+
		"\u0125\u0003\u000e\u0007\u0000\u0125\u0126\u0005!\u0000\u0000\u0126\u0127"+
		"\u0006\u0010\uffff\uffff\u0000\u0127\u012d\u0001\u0000\u0000\u0000\u0128"+
		"\u0129\u0005\u0011\u0000\u0000\u0129\u012a\u0005 \u0000\u0000\u012a\u012b"+
		"\u0005!\u0000\u0000\u012b\u012d\u0006\u0010\uffff\uffff\u0000\u012c\u0122"+
		"\u0001\u0000\u0000\u0000\u012c\u0128\u0001\u0000\u0000\u0000\u012d!\u0001"+
		"\u0000\u0000\u0000\u012e\u012f\u0005\u000b\u0000\u0000\u012f\u0130\u0005"+
		"\u0011\u0000\u0000\u0130\u0131\u0005&\u0000\u0000\u0131\u0132\u0005\u001a"+
		"\u0000\u0000\u0132\u0133\u0005\u001c\u0000\u0000\u0133\u0136\u0005\u001b"+
		"\u0000\u0000\u0134\u0135\u0005&\u0000\u0000\u0135\u0137\u0003$\u0012\u0000"+
		"\u0136\u0134\u0001\u0000\u0000\u0000\u0136\u0137\u0001\u0000\u0000\u0000"+
		"\u0137\u0138\u0001\u0000\u0000\u0000\u0138\u0139\u0006\u0011\uffff\uffff"+
		"\u0000\u0139#\u0001\u0000\u0000\u0000\u013a\u0146\u0005\u001a\u0000\u0000"+
		"\u013b\u013c\u0003\u000e\u0007\u0000\u013c\u0143\u0006\u0012\uffff\uffff"+
		"\u0000\u013d\u013e\u0005\"\u0000\u0000\u013e\u013f\u0003\u000e\u0007\u0000"+
		"\u013f\u0140\u0006\u0012\uffff\uffff\u0000\u0140\u0142\u0001\u0000\u0000"+
		"\u0000\u0141\u013d\u0001\u0000\u0000\u0000\u0142\u0145\u0001\u0000\u0000"+
		"\u0000\u0143\u0141\u0001\u0000\u0000\u0000\u0143\u0144\u0001\u0000\u0000"+
		"\u0000\u0144\u0147\u0001\u0000\u0000\u0000\u0145\u0143\u0001\u0000\u0000"+
		"\u0000\u0146\u013b\u0001\u0000\u0000\u0000\u0146\u0147\u0001\u0000\u0000"+
		"\u0000\u0147\u0148\u0001\u0000\u0000\u0000\u0148\u0149\u0005\u001b\u0000"+
		"\u0000\u0149%\u0001\u0000\u0000\u0000\u014a\u014f\u0003\u000e\u0007\u0000"+
		"\u014b\u014c\u0005\"\u0000\u0000\u014c\u014e\u0003\u000e\u0007\u0000\u014d"+
		"\u014b\u0001\u0000\u0000\u0000\u014e\u0151\u0001\u0000\u0000\u0000\u014f"+
		"\u014d\u0001\u0000\u0000\u0000\u014f\u0150\u0001\u0000\u0000\u0000\u0150"+
		"\'\u0001\u0000\u0000\u0000\u0151\u014f\u0001\u0000\u0000\u0000\u0152\u0153"+
		"\u0005\u0011\u0000\u0000\u0153\u0154\u0005\u001a\u0000\u0000\u0154\u0155"+
		"\u0003\u000e\u0007\u0000\u0155\u0156\u0005\u001b\u0000\u0000\u0156\u0157"+
		"\u0006\u0014\uffff\uffff\u0000\u0157)\u0001\u0000\u0000\u0000\u0158\u0159"+
		"\u0007\u0003\u0000\u0000\u0159+\u0001\u0000\u0000\u0000\u015a\u015b\u0007"+
		"\u0000\u0000\u0000\u015b-\u0001\u0000\u0000\u0000\u015c\u015d\u0005%\u0000"+
		"\u0000\u015d/\u0001\u0000\u0000\u0000\u00184EOhjz\u0085\u0090\u00a9\u00b6"+
		"\u00bc\u00c9\u00cf\u00d8\u00dd\u00ef\u0101\u010d\u0120\u012c\u0136\u0143"+
		"\u0146\u014f";
>>>>>>> b8277acd28cb0adf9f942b162e1ce411182ae3c5
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}