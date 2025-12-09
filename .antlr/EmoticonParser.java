// Generated from c:/Users/pieco/Desktop/Emoticon language/Emoticon.g4 by ANTLR 4.13.1
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
		KW_WHILE=8, KW_RETURN=9, KW_FUNCTION=10, KW_ARRAY=11, LBRACE=12, RBRACE=13, 
		KW_INT=14, KW_STRING=15, KW_CHAR=16, IDENT=17, ADD=18, SUBTRACT=19, MULTIPLY=20, 
		DIVIDE=21, GREATERTHAN=22, LESSTHAN=23, GREATERTHANOREQUALTO=24, LESSTHANOREQUALTO=25, 
		LBRACKET=26, RBRACKET=27, INT=28, FLOAT=29, CHAR=30, STRING=31, WS=32, 
		LPAREN=33, RPAREN=34, COMMA=35, COMMENT=36, COMMENT_BLOCK=37, COMPARISON=38, 
		ASSIGNMENT=39;
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
			"'return'", "'=^._.^='", "'(o_o)'", "'><(((,^>'", "'<^,)))><'", "'int'", 
			"'string'", "'char'", null, "':+)'", "':-)'", "':*)'", "':/)'", "':>)'", 
			"':<)'", "':>=)'", "':<=)'", "'['", "']'", null, null, null, null, null, 
			"'('", "')'", "','", null, null, "':==)'", "':=)'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "KW_READ", "KW_PRINT", "KW_IF", "KW_ELSE", "KW_ELSE_IF", 
			"KW_FOR", "KW_WHILE", "KW_RETURN", "KW_FUNCTION", "KW_ARRAY", "LBRACE", 
			"RBRACE", "KW_INT", "KW_STRING", "KW_CHAR", "IDENT", "ADD", "SUBTRACT", 
			"MULTIPLY", "DIVIDE", "GREATERTHAN", "LESSTHAN", "GREATERTHANOREQUALTO", 
			"LESSTHANOREQUALTO", "LBRACKET", "RBRACKET", "INT", "FLOAT", "CHAR", 
			"STRING", "WS", "LPAREN", "RPAREN", "COMMA", "COMMENT", "COMMENT_BLOCK", 
			"COMPARISON", "ASSIGNMENT"
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

	  // ASSEMBLY
	    /* Name of the file to store the assembly code */
	  final String ASSEMBLY_FILE = "code.s";

	  final String CONST_PREFIX = "VAL";
	  final String ID_PREFIX = "IDX";

	  
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
	  boolean redec = false;

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

	  // ASSEMBLY
	    /** Code generation material */
	  // Storage of code for the text segment and the data segment
	  StringBuilder text_sb = new StringBuilder();
	  StringBuilder data_sb = new StringBuilder();
	  int data_count = 0;

	  // ASSEMBLY
	  // Duncan had this in his code dont know what it really does tho
	  // unless it just makes a double variable.
	  // Add a double value explicitly to the data segment.
	  // Note this does NOT optimize for duplicates which would be useful
	  // That would require tracking and later placing them!
	  String addDoubleValue(double x) {
	    String label = CONST_PREFIX+data_count;
	    data_count++;
	    data_emit(label + ":    .double " + x);
	    return label;
	  }

	  //ASSEMBLY
	  //Don't know what this does but it might be useful.
	  void addSymbolsToData(SymbolTable table) {
	      table.table.forEach((id, symbol) -> { if (symbol.hasBeenUsed) { 
	        String label = ID_PREFIX + id;
	        data_emit(label + ":    .double 0.0");
	      }});
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
	  //OLD
	  //StringBuilder sb = new StringBuilder(); // Stores the generated program!

	  //OLD
	  //void emit(String s) { sb.append(s); }   // Short-hand for adding to the program


	  //ASSEMBLY
	  // Short-hand for adding to the program (and some helpers)
	  void emit(StringBuilder sb, String s, boolean newLine) { 
	    sb.append(s);
	    if (newLine) { sb.append("\n"); }
	  }
	  void emit(StringBuilder sb, String s) { emit(sb, s, true); }
	  void data_emit(String s) { emit(data_sb, s); }
	  void text_emit(String s) { emit(text_sb, s); }

	  //OLD
	  // Emit the preamble material for our program
	  // void openProgram() {
	  //   emit("import java.util.*;\n");
	  //   emit("public class EmoticonProgramTests {\n");
	  // }

	    // ASSEMBLY
	    // Emit the preamble material for our program
	  void openProgram() {
	    data_emit("# =================================");
	    data_emit("# Auto-generated code. Do not edit.");
	    data_emit("# =================================");
	    data_emit("    .data");

	    text_emit("    .text");
	    text_emit("main: ");
	  }

	  // OLD
	  // Emit the main method start
	  // void openMainMethod() {
	  //   emit("  public static void main(String[] args) throws Exception {\n");
	  //   emit("    Scanner in = new Scanner(System.in);\n");
	  // }

	  // OLD
	  // Emit the postamble material for our program
	  // void closeProgram() {
	  //   emit("  }\n");
	  //   emit("}\n");
	  // }

	  // ASSEMBLY
	  // Emit the postamble material for our program
	  void closeProgram() {
	    // Add a graceful end call
	    text_emit("end:");
	    text_emit("    li    a0, 0");
	    text_emit("    li    a7, 93");
	    text_emit("    ecall");
	  }

	  // ASSEMBLY
	    // Generate the code to load an double explicitly into a register
	  StringBuilder generateDoubleConstant(String register, double value) {
	    StringBuilder code = new StringBuilder();
	    String label = addDoubleValue(value);
	    emit(code, "    la " + "t0," + label); 
	    emit(code, "    fld " + register + ",(t0)");
	    return code;
	  }

	  // ASSEMBLY
	  StringBuilder generateLoadId(String register, String id) {
	    StringBuilder code = new StringBuilder();
	    String label = ID_PREFIX + id;
	    emit(code, "    la " + "t0," + label); 
	    emit(code, "    fld " + register + ",(t0)");
	    return code;
	  }

	  // ASSEMBLY
	  // Assign value in register to given name (in .data segment)
	  //   We only have ONE data type - double.
	  //   If multiple types then want a separate function for each type!
	  void generateAssign(String name, StringBuilder rhsJavaCode, String register) {
	    // tempRegister is either t0 or t1 (if t0 is taken)
	    String tempRegister = register.equals("t0") ? "t1" : "t0";

	    emit(rhsJavaCode, "    la " + tempRegister + "," + ID_PREFIX+name);
	    emit(rhsJavaCode, "    fsd " + register + ",(" + tempRegister + ")");
	  }

	  // ASSEMBLY
	  // Generate code to read double and store result in register specified
	  void generateReadDouble(StringBuilder code, String register) {
	    emit(code, "    li    a7, 7");  // a7=7 is for reading doubles
	    emit(code, "    ecall");        // invoke the system call
	    if (!register.equals("fa0")) {
	      // Transfer the results over to register from fa0.
	      //    e.g. fmv.d fa1, fa0   fa1 = fa0
	      emit(code, "    fmv.d " + register + ",fa0");
	    }
	  }

	  // ASSEMBLY
	  // Generate code to print the int stored in register
	  void generatePrintDouble(StringBuilder code, String register) {
	    if (!register.equals("fa0")) {
	      // Need to transfer the value in register to fa0
	      //    e.g. fmv.d fa0, fa1   fa0 = fa1
	      emit(code, "    fmv.d fa0," + register);
	    }
	    emit(code, "    li    a7, 3");  // a7=3 is for printing doubles
	    emit(code, "    ecall");        // invoke the system call
	    emit(code, "    li    a0, 10"); // ASCII 10 is \n (newline)
	    emit(code, "    li    a7, 11"); // a7=11 is for printing a character
	    emit(code, "    ecall");        // invoke the system call
	  }

	  // ASSEMBLY
	  // Write the generated Java to file.
	  void writeFile() {
	    try (PrintWriter pw = new PrintWriter(ASSEMBLY_FILE, "UTF-8")) {
	      pw.print(data_sb.toString());
	      pw.print(text_sb.toString());
	    } catch (Exception e) {
	      System.err.println("error: failed to write to " + ASSEMBLY_FILE + ": " + e.getMessage());
	    }
	  }

	  // Helper method to convert Type enum to Java type string
	  // String getJavaType(Type type) {
	  //   switch (type) {
	  //     case INT: return "int";
	  //     case FLOAT: return "float";
	  //     case STRING: return "String";
	  //     case CHAR: return "char";
	  //     default: return "double"; // fallback
	  //   }
	  // }

	  // Declare LHS if first-time assignment; otherwise plain assignment.
	  // void generateAssign(boolean declare, String name, String rhsJavaCode, Type type) {
	  //   String javaType = getJavaType(type);
	  //   if(!forAssign){
	  //     emit("    " + (declare ? javaType + " " : "") + name + " = " + rhsJavaCode + ";\n");
	  //   } else {
	  //     emit((declare ? javaType + " " : " ") + name + " = " + rhsJavaCode);
	  //   }
	  // }

	  // Generate Java method definition for a function
	  // void generateFunctionDefinition(FunctionDef func) {
	  //   // Check if the function body contains a return statement
	  //   String bodyCode = func.javaCode != null ? func.javaCode : "";
	  //   boolean hasExplicitReturn = bodyCode.contains("return ");
	    
	  //   String javaReturnType = (func.hasReturn || hasExplicitReturn) ? getJavaType(func.returnType) : "void";
	  //   emit("  public static " + javaReturnType + " " + func.name + "(");
	    
	  //   if (func.paramName != null) {
	  //     String javaParamType = getJavaType(func.paramType);
	  //     emit(javaParamType + " " + func.paramName);
	  //   }
	    
	  //   emit(") {\n");
	  //   emit(func.javaCode);
	  //   emit("  }\n\n");
	  // }

	  // Generate function call code
	  // String generateFunctionCall(String funcName, String argCode, Type argType) {
	  //   FunctionDef func = functions.get(funcName);
	  //   if (func == null) {
	  //     return "/* ERROR: function " + funcName + " not found */";
	  //   }
	    
	  //   if (func.paramName != null) {
	  //     return funcName + "(" + argCode + ")";
	  //   } else {
	  //     return funcName + "()";
	  //   }
	  // }

	  // Write the generated Java to file.
	  void writeFile() {
	    try (PrintWriter pw = new PrintWriter("EmoticonProgramTests.java", "UTF-8")) {
	      pw.print(data_sb.toString());
	      pw.print(text_sb.toString());
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 12079734680L) != 0)) {
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 12079734680L) != 0)) {
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
			setState(108);
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
				setState(106);
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
					        generateAssign(isNewVariable, id, ((AsContext)_localctx).expr.result.code, ((AsContext)_localctx).expr.result.type);
					      
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
					        
					        System.out.println(newId.value + "(" + "Type = " + newId.type + ")");
					        
					        Identifier var = lookupVariable(newId.id);
					        addVariable(newId);
					        boolean isNewVariable = (var == null);
					        // Generate Java code for assignment
					        generateAssign(isNewVariable, newId.id, ((AsContext)_localctx).INT.getText(), Type.INT);
					      
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
					        
					        System.out.println(newId.value + "(" + "Type = " + newId.type + ")");
					        
					        Identifier var = lookupVariable(newId.id);
					        addVariable(newId);
					        boolean isNewVariable = (var == null);
					        // Generate Java code for assignment
					        generateAssign(isNewVariable, newId.id, ((AsContext)_localctx).STRING.getText(), Type.STRING);
					      
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
					        
					        System.out.println(newId.value + "(" + "Type = " + newId.type + ")");
					        
					        Identifier var = lookupVariable(newId.id);
					        addVariable(newId);
					        boolean isNewVariable = (var == null);
					        // Generate Java code for assignment
					        generateAssign(isNewVariable, newId.id, ((AsContext)_localctx).CHAR.getText(), Type.CHAR);
					      
					}
					break;
				case 5:
					{
					setState(101);
					((AsContext)_localctx).FLOAT = match(FLOAT);

					        Identifier newId = new Identifier();
					        newId.id = ((AsContext)_localctx).IDENT.getText();
					        newId.value = ((AsContext)_localctx).FLOAT.getText();
					        newId.type = Type.FLOAT;
					        
					        System.out.println(newId.value + "(" + "Type = " + newId.type + ")");
					        
					        Identifier var = lookupVariable(newId.id);
					        addVariable(newId);
					        boolean isNewVariable = (var == null);
					        // Generate Java code for assignment
					        generateAssign(isNewVariable, newId.id, ((AsContext)_localctx).FLOAT.getText() + "f", Type.FLOAT);
					      
					}
					break;
				case 6:
					{
					setState(103);
					match(KW_READ);

					        //do it so that if var is not equal to null then do the assignment.
					        String id = ((AsContext)_localctx).IDENT.getText();
					        Identifier var = lookupVariable(id);
					        System.out.println(var.value + "(" + "Type = " + var.type + ")");

					        if(var.type == Type.INT){
					          generateAssign(false, var.id, "in.nextInt()", Type.INT);
					        } else if(var.type == Type.FLOAT){
					          generateAssign(false, var.id, "in.nextFloat()", Type.FLOAT);
					        } else if(var.type == Type.CHAR){
					          generateAssign(false, var.id, "in.next().charAt(0)", Type.CHAR);
					        } else if(var.type == Type.STRING){
					          generateAssign(false, var.id, "in.nextLine()", Type.STRING);
					        } else {
					          generateAssign(false, var.id, "in.nextLine()", Type.STRING); // default to string type
					          System.out.println("ran into default type for reading input (incorrect type name used)");
					        }

					        /* 
					        Identifier newId = new Identifier();
					        newId.id = ((AsContext)_localctx).IDENT.getText();
					        System.out.println("Please specify the type of input variable " + newId.id + " EX: integer, float, String, char");
					        String input = readInput.nextLine();    
					        
					        newId.value = input;
					        newId.type = typeCheck(input);
					        addVariable(newId);
					        System.out.println(newId.value + "(" + "Type = " + newId.type + ")");

					        if(input.equals("integer")){
					          generateAssign(true, newId.id, "in.nextInt()", Type.INT, forAssign);
					        } else if(input.equals("float")){
					          generateAssign(true, newId.id, "in.nextFloat()", Type.FLOAT, forAssign);
					        } else if(input.equals("char")){
					          generateAssign(true, newId.id, "in.next().charAt(0)", Type.CHAR, forAssign);
					        } else if(input.equals("String")){
					          generateAssign(true, newId.id, "in.nextLine()", Type.STRING, forAssign);
					        } else {
					          generateAssign(true, newId.id, "in.nextLine()", Type.STRING, forAssign); // default to string type
					          System.out.println("ran into default type for reading input (incorrect type name used)");
					        }
					        */
					      
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
			setState(110);
			match(KW_PRINT);
			setState(111);
			match(LPAREN);
			setState(112);
			((PsContext)_localctx).expr = expr();
			setState(113);
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
			setState(116);
			((ConditionContext)_localctx).a = expr();

			      // start with the lhs expr result
			      ((ConditionContext)_localctx).result =  ((ConditionContext)_localctx).a.result;
			    
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 62914560L) != 0)) {
				{
				{
				setState(118);
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
				setState(119);
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
				setState(126);
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
			setState(127);
			((ExprContext)_localctx).a = term();

			      ((ExprContext)_localctx).result =  ((ExprContext)_localctx).a.result;
			    
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==SUBTRACT) {
				{
				{
				setState(129);
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
				setState(130);
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
				setState(137);
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
			setState(138);
			((TermContext)_localctx).a = factor();

			      ((TermContext)_localctx).result =  ((TermContext)_localctx).a.result;
			    
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULTIPLY || _la==DIVIDE) {
				{
				{
				setState(140);
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
				setState(141);
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
				setState(148);
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
			setState(171);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
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
				setState(151);
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
				setState(153);
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
				setState(155);
				((FactorContext)_localctx).arrayAccess = arrayAccess();

				      ((FactorContext)_localctx).result =  ((FactorContext)_localctx).arrayAccess.result;
				    
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(158);
				((FactorContext)_localctx).functioncall = functioncall();

				      ((FactorContext)_localctx).result =  ((FactorContext)_localctx).functioncall.result;
				    
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(161);
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
				setState(163);
				((FactorContext)_localctx).functioncall = functioncall();

				      ((FactorContext)_localctx).result =  ((FactorContext)_localctx).functioncall.result;
				    
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(166);
				match(LPAREN);
				setState(167);
				((FactorContext)_localctx).expr = expr();
				setState(168);
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
			setState(173);
			match(KW_IF);

			      emit("    if (");
			    
			setState(175);
			match(LPAREN);
			setState(176);
			((IfstmtContext)_localctx).condition = condition();
			setState(177);
			match(RPAREN);

			      // emit condition and space before block
			      emit(((IfstmtContext)_localctx).condition.result.code + ")");
			    
			setState(179);
			match(LBRACE);

			      emit(" {\n");
			      if (!definingFunction) {
			        SymbolTable ifScope = new SymbolTable();
			        symbolStack.push(ifScope);
			      } else {
			        functionDefDepth++;
			      }
			    
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 12079734680L) != 0)) {
				{
				{
				setState(181);
				s();
				}
				}
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(187);
			match(RBRACE);

			      emit("    }\n");
			      if (!definingFunction) {
			        symbolStack.pop();
			      } else {
			        functionDefDepth--;
			      }
			    
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_ELSE || _la==KW_ELSE_IF) {
				{
				setState(189);
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
			setState(223);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_ELSE_IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
				match(KW_ELSE_IF);

				      emit("    else if (");
				    
				setState(194);
				match(LPAREN);
				setState(195);
				((ElsestmtContext)_localctx).condition = condition();
				setState(196);
				match(RPAREN);

				      emit(((ElsestmtContext)_localctx).condition.result.code + ")");
				    
				setState(198);
				match(LBRACE);

				      emit(" {\n");
				      if (!definingFunction) {
				        SymbolTable elseIfScope = new SymbolTable();
				        symbolStack.push(elseIfScope);
				      } else {
				        functionDefDepth++;
				      }
				    
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 12079734680L) != 0)) {
					{
					{
					setState(200);
					s();
					}
					}
					setState(205);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(206);
				match(RBRACE);

				      emit("    }\n");
				      if (!definingFunction) {
				        symbolStack.pop();
				      } else {
				        functionDefDepth--;
				      }
				    
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_ELSE || _la==KW_ELSE_IF) {
					{
					setState(208);
					elsestmt();
					}
				}

				}
				break;
			case KW_ELSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
				match(KW_ELSE);

				      emit("    else ");
				    
				setState(213);
				match(LBRACE);

				      emit("{\n");
				      if (!definingFunction) {
				        SymbolTable elseScope = new SymbolTable();
				        symbolStack.push(elseScope);
				      } else {
				        functionDefDepth++;
				      }
				    
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 12079734680L) != 0)) {
					{
					{
					setState(215);
					s();
					}
					}
					setState(220);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(221);
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
			setState(225);
			match(KW_FOR);
			setState(226);
			match(LPAREN);

			      //create the block statement stuff
			      SymbolTable forScope = new SymbolTable();
			      symbolStack.push(forScope);

			      // now do assign

			      emit("    for (");
			      forAssign = true;
			    
			setState(228);
			((ForstmtContext)_localctx).a = as();
			setState(229);
			match(T__0);
			setState(230);
			((ForstmtContext)_localctx).b = condition();
			emit(";" + ((ForstmtContext)_localctx).b.result.code + ";");
			setState(232);
			match(T__0);
			setState(233);
			((ForstmtContext)_localctx).c = as();
			setState(234);
			match(RPAREN);

			      forAssign = false;
			      emit(")");
			    
			setState(236);
			match(LBRACE);

			      emit(" {\n");
			      if (!definingFunction) {
			        SymbolTable ifScope = new SymbolTable();
			        symbolStack.push(ifScope);
			      } else {
			        functionDefDepth++;
			      }
			    
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 12079734680L) != 0)) {
				{
				{
				setState(238);
				s();
				}
				}
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(244);
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
			setState(247);
			match(KW_WHILE);
			setState(248);
			match(LPAREN);

			    //create the block statement stuff
			      SymbolTable forScope = new SymbolTable();
			      symbolStack.push(forScope);

			      // now do assign

			      emit("    while (");
			  
			setState(250);
			((WhilestmtContext)_localctx).a = condition();
			{emit(((WhilestmtContext)_localctx).a.result.code);} 
			setState(252);
			match(RPAREN);

			      emit(")");
			    
			setState(254);
			match(LBRACE);

			      emit(" {\n");
			      if (!definingFunction) {
			        SymbolTable ifScope = new SymbolTable();
			        symbolStack.push(ifScope);
			      } else {
			        functionDefDepth++;
			      }
			    
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 12079734680L) != 0)) {
				{
				{
				setState(256);
				s();
				}
				}
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(262);
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
			setState(271);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(265);
				((ReturnstmtContext)_localctx).KW_RETURN = match(KW_RETURN);
				setState(266);
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
				setState(269);
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
			setState(290);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(273);
				match(KW_FUNCTION);
				setState(274);
				((FunctionstmtContext)_localctx).name = match(IDENT);
				setState(275);
				match(LPAREN);
				setState(276);
				((FunctionstmtContext)_localctx).param = match(IDENT);
				setState(277);
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
				  
				setState(279);
				((FunctionstmtContext)_localctx).body = blockStatement();

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
				setState(282);
				match(KW_FUNCTION);
				setState(283);
				((FunctionstmtContext)_localctx).name = match(IDENT);
				setState(284);
				match(LPAREN);
				setState(285);
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
				  
				setState(287);
				((FunctionstmtContext)_localctx).body = blockStatement();

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
			setState(302);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(292);
				((FunctioncallContext)_localctx).IDENT = match(IDENT);
				setState(293);
				match(LPAREN);
				setState(294);
				((FunctioncallContext)_localctx).arg = expr();
				setState(295);
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
				setState(298);
				((FunctioncallContext)_localctx).IDENT = match(IDENT);
				setState(299);
				match(LPAREN);
				setState(300);
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
			setState(304);
			match(KW_ARRAY);
			setState(305);
			((ArraystmtContext)_localctx).IDENT = match(IDENT);
			setState(306);
			match(ASSIGNMENT);
			setState(307);
			match(LBRACKET);
			setState(308);
			((ArraystmtContext)_localctx).size = match(INT);
			setState(309);
			match(RBRACKET);
			setState(312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGNMENT) {
				{
				setState(310);
				match(ASSIGNMENT);
				setState(311);
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
			        emit("    float[] " + arrayName + " = new float[" + arraySize + "];\n");

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
			setState(316);
			match(LBRACKET);
			setState(328);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 12079726592L) != 0)) {
				{
				setState(317);
				((ArrayInitializerContext)_localctx).first = expr();
				 _localctx.values.add(((ArrayInitializerContext)_localctx).first.result.code); 
				setState(325);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(319);
					match(COMMA);
					setState(320);
					((ArrayInitializerContext)_localctx).rest = expr();
					 _localctx.values.add(((ArrayInitializerContext)_localctx).rest.result.code); 
					}
					}
					setState(327);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(330);
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
			setState(332);
			expr();
			setState(337);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(333);
				match(COMMA);
				setState(334);
				expr();
				}
				}
				setState(339);
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
			setState(340);
			((ArrayAccessContext)_localctx).IDENT = match(IDENT);
			setState(341);
			match(LBRACKET);
			setState(342);
			((ArrayAccessContext)_localctx).index = expr();
			setState(343);
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
			setState(346);
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
			setState(348);
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
			setState(350);
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
		"\u0004\u0001\'\u0161\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"\u0003\u0001F\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0005\u0003N\b\u0003\n\u0003\f\u0003Q\t\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004k\b\u0004\u0003\u0004m\b\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006{\b\u0006\n\u0006"+
		"\f\u0006~\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0005\u0007\u0086\b\u0007\n\u0007\f\u0007\u0089\t\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u0091\b\b\n\b"+
		"\f\b\u0094\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00ac\b\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005"+
		"\n\u00b7\b\n\n\n\f\n\u00ba\t\n\u0001\n\u0001\n\u0001\n\u0003\n\u00bf\b"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00ca\b\u000b\n\u000b"+
		"\f\u000b\u00cd\t\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u00d2\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0005\u000b\u00d9\b\u000b\n\u000b\f\u000b\u00dc\t\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u00e0\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0005\f\u00f0\b\f\n\f\f\f\u00f3\t\f\u0001\f\u0001\f\u0001\f\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0005\r\u0102\b\r\n\r\f\r\u0105\t\r\u0001\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e"+
		"\u0110\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0003\u000f\u0123\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0003\u0010\u012f\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0139\b\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u0144\b\u0012\n\u0012"+
		"\f\u0012\u0147\t\u0012\u0003\u0012\u0149\b\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u0150\b\u0013\n\u0013"+
		"\f\u0013\u0153\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0000\u0000\u0018\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*,.\u0000\u0004\u0001\u0000\u0016\u0019\u0001\u0000\u0012\u0013\u0001"+
		"\u0000\u0014\u0015\u0001\u0000\u0012\u0015\u0174\u00000\u0001\u0000\u0000"+
		"\u0000\u0002E\u0001\u0000\u0000\u0000\u0004G\u0001\u0000\u0000\u0000\u0006"+
		"J\u0001\u0000\u0000\u0000\bl\u0001\u0000\u0000\u0000\nn\u0001\u0000\u0000"+
		"\u0000\ft\u0001\u0000\u0000\u0000\u000e\u007f\u0001\u0000\u0000\u0000"+
		"\u0010\u008a\u0001\u0000\u0000\u0000\u0012\u00ab\u0001\u0000\u0000\u0000"+
		"\u0014\u00ad\u0001\u0000\u0000\u0000\u0016\u00df\u0001\u0000\u0000\u0000"+
		"\u0018\u00e1\u0001\u0000\u0000\u0000\u001a\u00f7\u0001\u0000\u0000\u0000"+
		"\u001c\u010f\u0001\u0000\u0000\u0000\u001e\u0122\u0001\u0000\u0000\u0000"+
		" \u012e\u0001\u0000\u0000\u0000\"\u0130\u0001\u0000\u0000\u0000$\u013c"+
		"\u0001\u0000\u0000\u0000&\u014c\u0001\u0000\u0000\u0000(\u0154\u0001\u0000"+
		"\u0000\u0000*\u015a\u0001\u0000\u0000\u0000,\u015c\u0001\u0000\u0000\u0000"+
		".\u015e\u0001\u0000\u0000\u000004\u0006\u0000\uffff\uffff\u000013\u0003"+
		"\u0002\u0001\u000021\u0001\u0000\u0000\u000036\u0001\u0000\u0000\u0000"+
		"42\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u000057\u0001\u0000\u0000"+
		"\u000064\u0001\u0000\u0000\u000078\u0005\u0000\u0000\u000189\u0006\u0000"+
		"\uffff\uffff\u00009\u0001\u0001\u0000\u0000\u0000:F\u0003\u0004\u0002"+
		"\u0000;F\u0003\b\u0004\u0000<F\u0003\n\u0005\u0000=F\u0003\u000e\u0007"+
		"\u0000>F\u0003\"\u0011\u0000?F\u0003\u0006\u0003\u0000@F\u0003\u0014\n"+
		"\u0000AF\u0003\u0018\f\u0000BF\u0003\u001a\r\u0000CF\u0003\u001e\u000f"+
		"\u0000DF\u0003\u001c\u000e\u0000E:\u0001\u0000\u0000\u0000E;\u0001\u0000"+
		"\u0000\u0000E<\u0001\u0000\u0000\u0000E=\u0001\u0000\u0000\u0000E>\u0001"+
		"\u0000\u0000\u0000E?\u0001\u0000\u0000\u0000E@\u0001\u0000\u0000\u0000"+
		"EA\u0001\u0000\u0000\u0000EB\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000"+
		"\u0000ED\u0001\u0000\u0000\u0000F\u0003\u0001\u0000\u0000\u0000GH\u0003"+
		" \u0010\u0000HI\u0006\u0002\uffff\uffff\u0000I\u0005\u0001\u0000\u0000"+
		"\u0000JK\u0005\f\u0000\u0000KO\u0006\u0003\uffff\uffff\u0000LN\u0003\u0002"+
		"\u0001\u0000ML\u0001\u0000\u0000\u0000NQ\u0001\u0000\u0000\u0000OM\u0001"+
		"\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PR\u0001\u0000\u0000\u0000"+
		"QO\u0001\u0000\u0000\u0000RS\u0005\r\u0000\u0000ST\u0006\u0003\uffff\uffff"+
		"\u0000T\u0007\u0001\u0000\u0000\u0000UV\u0003(\u0014\u0000VW\u0005\'\u0000"+
		"\u0000WX\u0003\u000e\u0007\u0000XY\u0006\u0004\uffff\uffff\u0000Ym\u0001"+
		"\u0000\u0000\u0000Z[\u0005\u0011\u0000\u0000[j\u0005\'\u0000\u0000\\]"+
		"\u0003\u000e\u0007\u0000]^\u0006\u0004\uffff\uffff\u0000^k\u0001\u0000"+
		"\u0000\u0000_`\u0005\u001c\u0000\u0000`k\u0006\u0004\uffff\uffff\u0000"+
		"ab\u0005\u001f\u0000\u0000bk\u0006\u0004\uffff\uffff\u0000cd\u0005\u001e"+
		"\u0000\u0000dk\u0006\u0004\uffff\uffff\u0000ef\u0005\u001d\u0000\u0000"+
		"fk\u0006\u0004\uffff\uffff\u0000gh\u0005\u0002\u0000\u0000hk\u0006\u0004"+
		"\uffff\uffff\u0000ik\u0006\u0004\uffff\uffff\u0000j\\\u0001\u0000\u0000"+
		"\u0000j_\u0001\u0000\u0000\u0000ja\u0001\u0000\u0000\u0000jc\u0001\u0000"+
		"\u0000\u0000je\u0001\u0000\u0000\u0000jg\u0001\u0000\u0000\u0000ji\u0001"+
		"\u0000\u0000\u0000km\u0001\u0000\u0000\u0000lU\u0001\u0000\u0000\u0000"+
		"lZ\u0001\u0000\u0000\u0000m\t\u0001\u0000\u0000\u0000no\u0005\u0003\u0000"+
		"\u0000op\u0005!\u0000\u0000pq\u0003\u000e\u0007\u0000qr\u0005\"\u0000"+
		"\u0000rs\u0006\u0005\uffff\uffff\u0000s\u000b\u0001\u0000\u0000\u0000"+
		"tu\u0003\u000e\u0007\u0000u|\u0006\u0006\uffff\uffff\u0000vw\u0007\u0000"+
		"\u0000\u0000wx\u0003\u000e\u0007\u0000xy\u0006\u0006\uffff\uffff\u0000"+
		"y{\u0001\u0000\u0000\u0000zv\u0001\u0000\u0000\u0000{~\u0001\u0000\u0000"+
		"\u0000|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}\r\u0001\u0000"+
		"\u0000\u0000~|\u0001\u0000\u0000\u0000\u007f\u0080\u0003\u0010\b\u0000"+
		"\u0080\u0087\u0006\u0007\uffff\uffff\u0000\u0081\u0082\u0007\u0001\u0000"+
		"\u0000\u0082\u0083\u0003\u0010\b\u0000\u0083\u0084\u0006\u0007\uffff\uffff"+
		"\u0000\u0084\u0086\u0001\u0000\u0000\u0000\u0085\u0081\u0001\u0000\u0000"+
		"\u0000\u0086\u0089\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000"+
		"\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u000f\u0001\u0000\u0000"+
		"\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u008a\u008b\u0003\u0012\t\u0000"+
		"\u008b\u0092\u0006\b\uffff\uffff\u0000\u008c\u008d\u0007\u0002\u0000\u0000"+
		"\u008d\u008e\u0003\u0012\t\u0000\u008e\u008f\u0006\b\uffff\uffff\u0000"+
		"\u008f\u0091\u0001\u0000\u0000\u0000\u0090\u008c\u0001\u0000\u0000\u0000"+
		"\u0091\u0094\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000"+
		"\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u0011\u0001\u0000\u0000\u0000"+
		"\u0094\u0092\u0001\u0000\u0000\u0000\u0095\u0096\u0005\u001c\u0000\u0000"+
		"\u0096\u00ac\u0006\t\uffff\uffff\u0000\u0097\u0098\u0005\u001e\u0000\u0000"+
		"\u0098\u00ac\u0006\t\uffff\uffff\u0000\u0099\u009a\u0005\u001f\u0000\u0000"+
		"\u009a\u00ac\u0006\t\uffff\uffff\u0000\u009b\u009c\u0003(\u0014\u0000"+
		"\u009c\u009d\u0006\t\uffff\uffff\u0000\u009d\u00ac\u0001\u0000\u0000\u0000"+
		"\u009e\u009f\u0003 \u0010\u0000\u009f\u00a0\u0006\t\uffff\uffff\u0000"+
		"\u00a0\u00ac\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005\u0011\u0000\u0000"+
		"\u00a2\u00ac\u0006\t\uffff\uffff\u0000\u00a3\u00a4\u0003 \u0010\u0000"+
		"\u00a4\u00a5\u0006\t\uffff\uffff\u0000\u00a5\u00ac\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a7\u0005!\u0000\u0000\u00a7\u00a8\u0003\u000e\u0007\u0000\u00a8"+
		"\u00a9\u0005\"\u0000\u0000\u00a9\u00aa\u0006\t\uffff\uffff\u0000\u00aa"+
		"\u00ac\u0001\u0000\u0000\u0000\u00ab\u0095\u0001\u0000\u0000\u0000\u00ab"+
		"\u0097\u0001\u0000\u0000\u0000\u00ab\u0099\u0001\u0000\u0000\u0000\u00ab"+
		"\u009b\u0001\u0000\u0000\u0000\u00ab\u009e\u0001\u0000\u0000\u0000\u00ab"+
		"\u00a1\u0001\u0000\u0000\u0000\u00ab\u00a3\u0001\u0000\u0000\u0000\u00ab"+
		"\u00a6\u0001\u0000\u0000\u0000\u00ac\u0013\u0001\u0000\u0000\u0000\u00ad"+
		"\u00ae\u0005\u0004\u0000\u0000\u00ae\u00af\u0006\n\uffff\uffff\u0000\u00af"+
		"\u00b0\u0005!\u0000\u0000\u00b0\u00b1\u0003\f\u0006\u0000\u00b1\u00b2"+
		"\u0005\"\u0000\u0000\u00b2\u00b3\u0006\n\uffff\uffff\u0000\u00b3\u00b4"+
		"\u0005\f\u0000\u0000\u00b4\u00b8\u0006\n\uffff\uffff\u0000\u00b5\u00b7"+
		"\u0003\u0002\u0001\u0000\u00b6\u00b5\u0001\u0000\u0000\u0000\u00b7\u00ba"+
		"\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b9"+
		"\u0001\u0000\u0000\u0000\u00b9\u00bb\u0001\u0000\u0000\u0000\u00ba\u00b8"+
		"\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005\r\u0000\u0000\u00bc\u00be\u0006"+
		"\n\uffff\uffff\u0000\u00bd\u00bf\u0003\u0016\u000b\u0000\u00be\u00bd\u0001"+
		"\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf\u0015\u0001"+
		"\u0000\u0000\u0000\u00c0\u00c1\u0005\u0006\u0000\u0000\u00c1\u00c2\u0006"+
		"\u000b\uffff\uffff\u0000\u00c2\u00c3\u0005!\u0000\u0000\u00c3\u00c4\u0003"+
		"\f\u0006\u0000\u00c4\u00c5\u0005\"\u0000\u0000\u00c5\u00c6\u0006\u000b"+
		"\uffff\uffff\u0000\u00c6\u00c7\u0005\f\u0000\u0000\u00c7\u00cb\u0006\u000b"+
		"\uffff\uffff\u0000\u00c8\u00ca\u0003\u0002\u0001\u0000\u00c9\u00c8\u0001"+
		"\u0000\u0000\u0000\u00ca\u00cd\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001"+
		"\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc\u00ce\u0001"+
		"\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00ce\u00cf\u0005"+
		"\r\u0000\u0000\u00cf\u00d1\u0006\u000b\uffff\uffff\u0000\u00d0\u00d2\u0003"+
		"\u0016\u000b\u0000\u00d1\u00d0\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001"+
		"\u0000\u0000\u0000\u00d2\u00e0\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005"+
		"\u0005\u0000\u0000\u00d4\u00d5\u0006\u000b\uffff\uffff\u0000\u00d5\u00d6"+
		"\u0005\f\u0000\u0000\u00d6\u00da\u0006\u000b\uffff\uffff\u0000\u00d7\u00d9"+
		"\u0003\u0002\u0001\u0000\u00d8\u00d7\u0001\u0000\u0000\u0000\u00d9\u00dc"+
		"\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00da\u00db"+
		"\u0001\u0000\u0000\u0000\u00db\u00dd\u0001\u0000\u0000\u0000\u00dc\u00da"+
		"\u0001\u0000\u0000\u0000\u00dd\u00de\u0005\r\u0000\u0000\u00de\u00e0\u0006"+
		"\u000b\uffff\uffff\u0000\u00df\u00c0\u0001\u0000\u0000\u0000\u00df\u00d3"+
		"\u0001\u0000\u0000\u0000\u00e0\u0017\u0001\u0000\u0000\u0000\u00e1\u00e2"+
		"\u0005\u0007\u0000\u0000\u00e2\u00e3\u0005!\u0000\u0000\u00e3\u00e4\u0006"+
		"\f\uffff\uffff\u0000\u00e4\u00e5\u0003\b\u0004\u0000\u00e5\u00e6\u0005"+
		"\u0001\u0000\u0000\u00e6\u00e7\u0003\f\u0006\u0000\u00e7\u00e8\u0006\f"+
		"\uffff\uffff\u0000\u00e8\u00e9\u0005\u0001\u0000\u0000\u00e9\u00ea\u0003"+
		"\b\u0004\u0000\u00ea\u00eb\u0005\"\u0000\u0000\u00eb\u00ec\u0006\f\uffff"+
		"\uffff\u0000\u00ec\u00ed\u0005\f\u0000\u0000\u00ed\u00f1\u0006\f\uffff"+
		"\uffff\u0000\u00ee\u00f0\u0003\u0002\u0001\u0000\u00ef\u00ee\u0001\u0000"+
		"\u0000\u0000\u00f0\u00f3\u0001\u0000\u0000\u0000\u00f1\u00ef\u0001\u0000"+
		"\u0000\u0000\u00f1\u00f2\u0001\u0000\u0000\u0000\u00f2\u00f4\u0001\u0000"+
		"\u0000\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f4\u00f5\u0005\r\u0000"+
		"\u0000\u00f5\u00f6\u0006\f\uffff\uffff\u0000\u00f6\u0019\u0001\u0000\u0000"+
		"\u0000\u00f7\u00f8\u0005\b\u0000\u0000\u00f8\u00f9\u0005!\u0000\u0000"+
		"\u00f9\u00fa\u0006\r\uffff\uffff\u0000\u00fa\u00fb\u0003\f\u0006\u0000"+
		"\u00fb\u00fc\u0006\r\uffff\uffff\u0000\u00fc\u00fd\u0005\"\u0000\u0000"+
		"\u00fd\u00fe\u0006\r\uffff\uffff\u0000\u00fe\u00ff\u0005\f\u0000\u0000"+
		"\u00ff\u0103\u0006\r\uffff\uffff\u0000\u0100\u0102\u0003\u0002\u0001\u0000"+
		"\u0101\u0100\u0001\u0000\u0000\u0000\u0102\u0105\u0001\u0000\u0000\u0000"+
		"\u0103\u0101\u0001\u0000\u0000\u0000\u0103\u0104\u0001\u0000\u0000\u0000"+
		"\u0104\u0106\u0001\u0000\u0000\u0000\u0105\u0103\u0001\u0000\u0000\u0000"+
		"\u0106\u0107\u0005\r\u0000\u0000\u0107\u0108\u0006\r\uffff\uffff\u0000"+
		"\u0108\u001b\u0001\u0000\u0000\u0000\u0109\u010a\u0005\t\u0000\u0000\u010a"+
		"\u010b\u0003\u000e\u0007\u0000\u010b\u010c\u0006\u000e\uffff\uffff\u0000"+
		"\u010c\u0110\u0001\u0000\u0000\u0000\u010d\u010e\u0005\t\u0000\u0000\u010e"+
		"\u0110\u0006\u000e\uffff\uffff\u0000\u010f\u0109\u0001\u0000\u0000\u0000"+
		"\u010f\u010d\u0001\u0000\u0000\u0000\u0110\u001d\u0001\u0000\u0000\u0000"+
		"\u0111\u0112\u0005\n\u0000\u0000\u0112\u0113\u0005\u0011\u0000\u0000\u0113"+
		"\u0114\u0005!\u0000\u0000\u0114\u0115\u0005\u0011\u0000\u0000\u0115\u0116"+
		"\u0005\"\u0000\u0000\u0116\u0117\u0006\u000f\uffff\uffff\u0000\u0117\u0118"+
		"\u0003\u0006\u0003\u0000\u0118\u0119\u0006\u000f\uffff\uffff\u0000\u0119"+
		"\u0123\u0001\u0000\u0000\u0000\u011a\u011b\u0005\n\u0000\u0000\u011b\u011c"+
		"\u0005\u0011\u0000\u0000\u011c\u011d\u0005!\u0000\u0000\u011d\u011e\u0005"+
		"\"\u0000\u0000\u011e\u011f\u0006\u000f\uffff\uffff\u0000\u011f\u0120\u0003"+
		"\u0006\u0003\u0000\u0120\u0121\u0006\u000f\uffff\uffff\u0000\u0121\u0123"+
		"\u0001\u0000\u0000\u0000\u0122\u0111\u0001\u0000\u0000\u0000\u0122\u011a"+
		"\u0001\u0000\u0000\u0000\u0123\u001f\u0001\u0000\u0000\u0000\u0124\u0125"+
		"\u0005\u0011\u0000\u0000\u0125\u0126\u0005!\u0000\u0000\u0126\u0127\u0003"+
		"\u000e\u0007\u0000\u0127\u0128\u0005\"\u0000\u0000\u0128\u0129\u0006\u0010"+
		"\uffff\uffff\u0000\u0129\u012f\u0001\u0000\u0000\u0000\u012a\u012b\u0005"+
		"\u0011\u0000\u0000\u012b\u012c\u0005!\u0000\u0000\u012c\u012d\u0005\""+
		"\u0000\u0000\u012d\u012f\u0006\u0010\uffff\uffff\u0000\u012e\u0124\u0001"+
		"\u0000\u0000\u0000\u012e\u012a\u0001\u0000\u0000\u0000\u012f!\u0001\u0000"+
		"\u0000\u0000\u0130\u0131\u0005\u000b\u0000\u0000\u0131\u0132\u0005\u0011"+
		"\u0000\u0000\u0132\u0133\u0005\'\u0000\u0000\u0133\u0134\u0005\u001a\u0000"+
		"\u0000\u0134\u0135\u0005\u001c\u0000\u0000\u0135\u0138\u0005\u001b\u0000"+
		"\u0000\u0136\u0137\u0005\'\u0000\u0000\u0137\u0139\u0003$\u0012\u0000"+
		"\u0138\u0136\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000"+
		"\u0139\u013a\u0001\u0000\u0000\u0000\u013a\u013b\u0006\u0011\uffff\uffff"+
		"\u0000\u013b#\u0001\u0000\u0000\u0000\u013c\u0148\u0005\u001a\u0000\u0000"+
		"\u013d\u013e\u0003\u000e\u0007\u0000\u013e\u0145\u0006\u0012\uffff\uffff"+
		"\u0000\u013f\u0140\u0005#\u0000\u0000\u0140\u0141\u0003\u000e\u0007\u0000"+
		"\u0141\u0142\u0006\u0012\uffff\uffff\u0000\u0142\u0144\u0001\u0000\u0000"+
		"\u0000\u0143\u013f\u0001\u0000\u0000\u0000\u0144\u0147\u0001\u0000\u0000"+
		"\u0000\u0145\u0143\u0001\u0000\u0000\u0000\u0145\u0146\u0001\u0000\u0000"+
		"\u0000\u0146\u0149\u0001\u0000\u0000\u0000\u0147\u0145\u0001\u0000\u0000"+
		"\u0000\u0148\u013d\u0001\u0000\u0000\u0000\u0148\u0149\u0001\u0000\u0000"+
		"\u0000\u0149\u014a\u0001\u0000\u0000\u0000\u014a\u014b\u0005\u001b\u0000"+
		"\u0000\u014b%\u0001\u0000\u0000\u0000\u014c\u0151\u0003\u000e\u0007\u0000"+
		"\u014d\u014e\u0005#\u0000\u0000\u014e\u0150\u0003\u000e\u0007\u0000\u014f"+
		"\u014d\u0001\u0000\u0000\u0000\u0150\u0153\u0001\u0000\u0000\u0000\u0151"+
		"\u014f\u0001\u0000\u0000\u0000\u0151\u0152\u0001\u0000\u0000\u0000\u0152"+
		"\'\u0001\u0000\u0000\u0000\u0153\u0151\u0001\u0000\u0000\u0000\u0154\u0155"+
		"\u0005\u0011\u0000\u0000\u0155\u0156\u0005\u001a\u0000\u0000\u0156\u0157"+
		"\u0003\u000e\u0007\u0000\u0157\u0158\u0005\u001b\u0000\u0000\u0158\u0159"+
		"\u0006\u0014\uffff\uffff\u0000\u0159)\u0001\u0000\u0000\u0000\u015a\u015b"+
		"\u0007\u0003\u0000\u0000\u015b+\u0001\u0000\u0000\u0000\u015c\u015d\u0007"+
		"\u0000\u0000\u0000\u015d-\u0001\u0000\u0000\u0000\u015e\u015f\u0005&\u0000"+
		"\u0000\u015f/\u0001\u0000\u0000\u0000\u00184EOjl|\u0087\u0092\u00ab\u00b8"+
		"\u00be\u00cb\u00d1\u00da\u00df\u00f1\u0103\u010f\u0122\u012e\u0138\u0145"+
		"\u0148\u0151";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}