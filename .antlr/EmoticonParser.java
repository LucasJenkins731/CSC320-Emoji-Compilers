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
		KW_READ=1, KW_PRINT=2, KW_IF=3, KW_ELSE=4, KW_ELSE_IF=5, KW_FOR=6, KW_WHILE=7, 
		KW_RETURN=8, KW_FUNCTION=9, KW_ARRAY=10, LBRACE=11, RBRACE=12, KW_INT=13, 
		KW_STRING=14, KW_CHAR=15, IDENT=16, ADD=17, SUBTRACT=18, MULTIPLY=19, 
		DIVIDE=20, MODULO=21, GREATERTHAN=22, LESSTHAN=23, GREATERTHANOREQUALTO=24, 
		LESSTHANOREQUALTO=25, LBRACKET=26, RBRACKET=27, INT=28, FLOAT=29, CHAR=30, 
		STRING=31, WS=32, LPAREN=33, RPAREN=34, COMMA=35, COMMENT=36, COMMENT_BLOCK=37, 
		COMPARISON=38, NOTEQUAL=39, ASSIGNMENT=40;
	public static final int
		RULE_program = 0, RULE_s = 1, RULE_blockStatement = 2, RULE_as = 3, RULE_rhs = 4, 
		RULE_ps = 5, RULE_expr = 6, RULE_term = 7, RULE_factor = 8, RULE_ifstmt = 9, 
		RULE_whilestmt = 10, RULE_condition = 11, RULE_operators = 12, RULE_conditionals = 13, 
		RULE_comp = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "s", "blockStatement", "as", "rhs", "ps", "expr", "term", 
			"factor", "ifstmt", "whilestmt", "condition", "operators", "conditionals", 
			"comp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'-0-0-'", "':P'", "':)'", "':('", "':|'", "'>:('", "'D:<'", "'return'", 
			"'=^._.^='", "'(o_o)'", "'><(((,^>'", "'<^,)))><'", "'int'", "'string'", 
			"'char'", null, "':+)'", "':-)'", "':*)'", "':/)'", "':%)'", "':>)'", 
			"':<)'", "':>=)'", "':<=)'", "'['", "']'", null, null, null, null, null, 
			"'('", "')'", "','", null, null, "':==)'", "':!=)'", "':=)'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "KW_READ", "KW_PRINT", "KW_IF", "KW_ELSE", "KW_ELSE_IF", "KW_FOR", 
			"KW_WHILE", "KW_RETURN", "KW_FUNCTION", "KW_ARRAY", "LBRACE", "RBRACE", 
			"KW_INT", "KW_STRING", "KW_CHAR", "IDENT", "ADD", "SUBTRACT", "MULTIPLY", 
			"DIVIDE", "MODULO", "GREATERTHAN", "LESSTHAN", "GREATERTHANOREQUALTO", 
			"LESSTHANOREQUALTO", "LBRACKET", "RBRACKET", "INT", "FLOAT", "CHAR", 
			"STRING", "WS", "LPAREN", "RPAREN", "COMMA", "COMMENT", "COMMENT_BLOCK", 
			"COMPARISON", "NOTEQUAL", "ASSIGNMENT"
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
	  final String ASSEMBLY_FILE = "EmoticonAssembly.s";

	  //used for variable names. done as VALx in code
	  //where x is a number incremented  based on data count (see further).
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
	  StringBuilder asm = new StringBuilder();


	  // ASSEMBLY
	  // this can be helpful for other variables
	  // Duncan had this in his code dont know what it really does tho
	  // unless it just makes a double variable.
	  // Add a double value explicitly to the data segment.
	  // Note this does NOT optimize for duplicates which would be useful
	  // That would require tracking and later placing them!
	  //PROBABLY DONT WANT THIS IT COMPLICATES THINGS.
	  String addDoubleValue(double x) {
	    String label = CONST_PREFIX+data_count;
	    data_count++;
	    data_emit(label + ":    .double " + x);
	    return label;
	  }

	  //ASSEMBLY
	  // Add all variables to data segment (they need storage space if assigned)
	  private int numsym = 0;
	  void addSymbolsToData(SymbolTable table) {
	    numsym = 0;
	      table.table.forEach((id, identifier) -> { 
	        numsym++;
	        System.out.println(numsym + " symbols :D");
	        String label = ID_PREFIX + id;
	        data_emit(label + ":    .double 0.0");
	      });
	      if(numsym == 0) System.out.println("no symbols :(");
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
	    data_emit("input_buffer: .space 100");  // Buffer for string input
	    
	    text_emit("    .text");
	    text_emit("main: ");
	  }  // OLD
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
	    addSymbolsToData(mainTable);
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
	  // Add string constant to data segment
	  String addStringConstant(String str) {
	    String label = "STR" + data_count;
	    data_count++;
	    // Remove quotes and handle escape sequences
	    String cleanStr = str.substring(1, str.length()-1);
	    cleanStr = cleanStr.replace("\\n", "\n").replace("\\\\", "\\").replace("\\'", "'").replace("\\\"", "\"");
	    data_emit(label + ":    .asciz \"" + cleanStr + "\"");
	    return label;
	  }

	  // ASSEMBLY
	  // Generate code to read a string (up to 100 chars) and store address in register
	  void generateReadString(StringBuilder code, String register) {
	    emit(code, "    la    a0, input_buffer");  // Load buffer address
	    emit(code, "    li    a1, 100");          // Max chars to read
	    emit(code, "    li    a7, 8");            // a7=8 is for reading strings
	    emit(code, "    ecall");                  // invoke the system call
	    if (!register.equals("a0")) {
	      emit(code, "    mv    " + register + ", a0");  // Move result to target register
	    }
	  }

	  // ASSEMBLY
	  // Generate code to print a string whose address is in register
	  void generatePrintString(StringBuilder code, String register) {
	    if (!register.equals("a0")) {
	      emit(code, "    mv    a0, " + register);  // Move string address to a0
	    }
	    emit(code, "    li    a7, 4");            // a7=4 is for printing strings
	    emit(code, "    ecall");                  // invoke the system call
	  }

	  // ASSEMBLY
	  // Generate code to print a string constant
	  void generatePrintStringConstant(StringBuilder code, String stringLiteral) {
	    String label = addStringConstant(stringLiteral);
	    emit(code, "    la    a0, " + label);     // Load string address
	    emit(code, "    li    a7, 4");            // a7=4 is for printing strings
	    emit(code, "    ecall");                  // invoke the system call
	  }

	  // ASSEMBLY
	  // Label counter for conditional branches
	  private int labelCount = 0;
	  
	  // Generate unique label
	  String generateLabel(String prefix) {
	    return prefix + labelCount++;
	  }
	  
	  // Generate comparison and conditional jump (jump if condition is FALSE)
	  void generateComparison(StringBuilder code, String leftReg, String rightReg, String operator, String jumpLabel) {
	    emit(code, "    # Compare " + leftReg + " " + operator + " " + rightReg + " (jump if false)");
	    
	    if (operator.equals(":<)")) {
	      // Jump if NOT (left < right) 
	      emit(code, "    flt.d t0, " + leftReg + ", " + rightReg);
	      emit(code, "    beqz t0, " + jumpLabel);  // Jump if left >= right
	    } else if (operator.equals(":>)")) {
	      // Jump if NOT (left > right)
	      emit(code, "    flt.d t0, " + rightReg + ", " + leftReg);
	      emit(code, "    beqz t0, " + jumpLabel);  // Jump if left <= right  
	    } else if (operator.equals(":<=)")) {
	      // Jump if NOT (left <= right)
	      emit(code, "    fle.d t0, " + leftReg + ", " + rightReg);
	      emit(code, "    beqz t0, " + jumpLabel);  // Jump if left > right
	    } else if (operator.equals(":>=)")) {
	      // Jump if NOT (left >= right)
	      emit(code, "    fle.d t0, " + rightReg + ", " + leftReg);
	      emit(code, "    beqz t0, " + jumpLabel);  // Jump if left < right
	    } else if (operator.equals(":==)")) {
	      // Jump if NOT (left == right)
	      emit(code, "    feq.d t0, " + leftReg + ", " + rightReg);
	      emit(code, "    beqz t0, " + jumpLabel);  // Jump if left != right
	    } else if (operator.equals(":!=)")) {
	      // Jump if NOT (left != right)  
	      emit(code, "    feq.d t0, " + leftReg + ", " + rightReg);
	      emit(code, "    bnez t0, " + jumpLabel);  // Jump if left == right
	    }
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
	  // void writeFile() {
	  //   try (PrintWriter pw = new PrintWriter("EmoticonProgramTests.java", "UTF-8")) {
	  //     pw.print(data_sb.toString());
	  //     pw.print(text_sb.toString());
	  //   } catch (Exception e) {
	  //     System.err.println("error: failed to write EmoticonProgramTests.java: " + e.getMessage());
	  //   }
	  // }

	public EmoticonParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public SContext s;
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
			    
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 65676L) != 0)) {
				{
				{
				setState(31);
				((ProgramContext)_localctx).s = s();

				      text_sb.append(((ProgramContext)_localctx).s.code);
				    
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(39);
			match(EOF);

			      int numErrors = printDiagnostics();
			      if (numErrors == 0) {
			        // Successful, so write out the generated code
			        closeProgram();
			        writeFile();     
			        System.err.println("Success");
			        
			        // // Generate function definitions
			        // for (FunctionDef func : functions.values()) {
			        //   if (func.javaCode != null) {
			        //     generateFunctionDefinition(func);
			        //   }
			        asm.append(data_sb.toString());
			        asm.append(text_sb.toString());

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
		public StringBuilder code;
		public AsContext as;
		public PsContext ps;
		public IfstmtContext ifstmt;
		public WhilestmtContext whilestmt;
		public AsContext as() {
			return getRuleContext(AsContext.class,0);
		}
		public PsContext ps() {
			return getRuleContext(PsContext.class,0);
		}
		public IfstmtContext ifstmt() {
			return getRuleContext(IfstmtContext.class,0);
		}
		public WhilestmtContext whilestmt() {
			return getRuleContext(WhilestmtContext.class,0);
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
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				((SContext)_localctx).as = as();
				((SContext)_localctx).code =  ((SContext)_localctx).as.code;
				}
				break;
			case KW_PRINT:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				((SContext)_localctx).ps = ps();
				((SContext)_localctx).code =  ((SContext)_localctx).ps.code;
				}
				break;
			case KW_IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				((SContext)_localctx).ifstmt = ifstmt();
				((SContext)_localctx).code =  ((SContext)_localctx).ifstmt.code;
				}
				break;
			case KW_WHILE:
				enterOuterAlt(_localctx, 4);
				{
				setState(51);
				((SContext)_localctx).whilestmt = whilestmt();
				((SContext)_localctx).code =  ((SContext)_localctx).whilestmt.code;
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
	public static class BlockStatementContext extends ParserRuleContext {
		public StringBuilder code;
		public SContext stmt;
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
		enterRule(_localctx, 4, RULE_blockStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(LBRACE);

			      ((BlockStatementContext)_localctx).code =  new StringBuilder();
			    
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 65676L) != 0)) {
				{
				{
				setState(58);
				((BlockStatementContext)_localctx).stmt = s();

				      _localctx.code.append(((BlockStatementContext)_localctx).stmt.code);
				    
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66);
			match(RBRACE);
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
		public StringBuilder code;
		public Token IDENT;
		public RhsContext rhs;
		public TerminalNode IDENT() { return getToken(EmoticonParser.IDENT, 0); }
		public TerminalNode ASSIGNMENT() { return getToken(EmoticonParser.ASSIGNMENT, 0); }
		public RhsContext rhs() {
			return getRuleContext(RhsContext.class,0);
		}
		public AsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_as; }
	}

	public final AsContext as() throws RecognitionException {
		AsContext _localctx = new AsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_as);
		try {
			enterOuterAlt(_localctx, 1);
			{
			String register = "fa0";
			setState(69);
			((AsContext)_localctx).IDENT = match(IDENT);

			      String id = ((AsContext)_localctx).IDENT.getText();
			      Identifier var = lookupVariable(id);
			      //System.out.println(var);
			    
			setState(71);
			match(ASSIGNMENT);
			setState(72);
			((AsContext)_localctx).rhs = rhs(register);

			      if(var == null){
			        Identifier newId = new Identifier();
			        newId.id = id;
			        newId.type = Type.FLOAT; // Default to float for assembly
			        newId.hasBeenUsed = false;
			        addVariable(newId);
			      }
			      generateAssign(id, ((AsContext)_localctx).rhs.code, register);
			      ((AsContext)_localctx).code =  ((AsContext)_localctx).rhs.code;
			    
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
	public static class RhsContext extends ParserRuleContext {
		public String register;
		public StringBuilder code;
		public ExprContext expr;
		public Token STRING;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode KW_READ() { return getToken(EmoticonParser.KW_READ, 0); }
		public TerminalNode STRING() { return getToken(EmoticonParser.STRING, 0); }
		public RhsContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public RhsContext(ParserRuleContext parent, int invokingState, String register) {
			super(parent, invokingState);
			this.register = register;
		}
		@Override public int getRuleIndex() { return RULE_rhs; }
	}

	public final RhsContext rhs(String register) throws RecognitionException {
		RhsContext _localctx = new RhsContext(_ctx, getState(), register);
		enterRule(_localctx, 8, RULE_rhs);
		try {
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
			case INT:
			case FLOAT:
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				((RhsContext)_localctx).expr = expr(_localctx.register);
				((RhsContext)_localctx).code =  ((RhsContext)_localctx).expr.code;
				}
				break;
			case KW_READ:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				match(KW_READ);

				    ((RhsContext)_localctx).code =  new StringBuilder();
				    generateReadDouble(_localctx.code, _localctx.register);
				  
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				((RhsContext)_localctx).STRING = match(STRING);

				    ((RhsContext)_localctx).code =  new StringBuilder();
				    String label = addStringConstant(((RhsContext)_localctx).STRING.getText());
				    emit(_localctx.code, "    la    " + _localctx.register + ", " + label);
				  
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
	public static class PsContext extends ParserRuleContext {
		public StringBuilder code;
		public ExprContext expr;
		public Token STRING;
		public TerminalNode KW_PRINT() { return getToken(EmoticonParser.KW_PRINT, 0); }
		public TerminalNode LPAREN() { return getToken(EmoticonParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(EmoticonParser.RPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode STRING() { return getToken(EmoticonParser.STRING, 0); }
		public TerminalNode COMMA() { return getToken(EmoticonParser.COMMA, 0); }
		public PsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ps; }
	}

	public final PsContext ps() throws RecognitionException {
		PsContext _localctx = new PsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ps);
		try {
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				String register = "fa0";
				setState(85);
				match(KW_PRINT);
				setState(86);
				match(LPAREN);
				setState(92);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IDENT:
				case INT:
				case FLOAT:
				case LPAREN:
					{
					setState(87);
					((PsContext)_localctx).expr = expr(register);

					        ((PsContext)_localctx).code =  ((PsContext)_localctx).expr.code;
					        generatePrintDouble(_localctx.code, register);
					      
					}
					break;
				case STRING:
					{
					setState(90);
					((PsContext)_localctx).STRING = match(STRING);

					        ((PsContext)_localctx).code =  new StringBuilder();
					        generatePrintStringConstant(_localctx.code, ((PsContext)_localctx).STRING.getText());
					      
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(94);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				String register = "fa0";
				setState(96);
				match(KW_PRINT);
				setState(97);
				match(LPAREN);
				setState(98);
				((PsContext)_localctx).STRING = match(STRING);
				setState(99);
				match(COMMA);
				setState(100);
				((PsContext)_localctx).expr = expr(register);
				setState(101);
				match(RPAREN);

				      ((PsContext)_localctx).code =  new StringBuilder();
				      generatePrintStringConstant(_localctx.code, ((PsContext)_localctx).STRING.getText());
				      _localctx.code.append(((PsContext)_localctx).expr.code);
				      generatePrintDouble(_localctx.code, register);
				    
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
	public static class ExprContext extends ParserRuleContext {
		public String register;
		public StringBuilder code;
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
		public ExprContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExprContext(ParserRuleContext parent, int invokingState, String register) {
			super(parent, invokingState);
			this.register = register;
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr(String register) throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState(), register);
		enterRule(_localctx, 12, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			((ExprContext)_localctx).a = term(_localctx.register);

			    ((ExprContext)_localctx).code =  ((ExprContext)_localctx).a.code;
			    String nextRegister = (_localctx.register.equals("ft0")) ? "ft1" : "ft0";
			  
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==SUBTRACT) {
				{
				{
				setState(108);
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
				setState(109);
				((ExprContext)_localctx).b = term(nextRegister);

				    if(((ExprContext)_localctx).op.getText().equals(":+)")){
				      _localctx.code.append(((ExprContext)_localctx).b.code);
				      emit(_localctx.code, "    fadd.d " + _localctx.register + "," + _localctx.register + "," + nextRegister);
				    } else {
				        // Add the two values
				        _localctx.code.append(((ExprContext)_localctx).b.code);
				        emit(_localctx.code, "    fsub.d " + _localctx.register + "," + _localctx.register + "," + nextRegister);
				      }
				  
				}
				}
				setState(116);
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
		public String register;
		public StringBuilder code;
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
		public List<TerminalNode> MODULO() { return getTokens(EmoticonParser.MODULO); }
		public TerminalNode MODULO(int i) {
			return getToken(EmoticonParser.MODULO, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public TermContext(ParserRuleContext parent, int invokingState, String register) {
			super(parent, invokingState);
			this.register = register;
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term(String register) throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState(), register);
		enterRule(_localctx, 14, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			((TermContext)_localctx).a = factor(_localctx.register);

			      ((TermContext)_localctx).code =  ((TermContext)_localctx).a.code;
			      String nextRegister = (_localctx.register.equals("ft0")) ? "ft1" : "ft0";
			    
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3670016L) != 0)) {
				{
				{
				setState(119);
				((TermContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3670016L) != 0)) ) {
					((TermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(120);
				((TermContext)_localctx).b = factor(nextRegister);

				      if(((TermContext)_localctx).op.getText().equals(":*)")){
				        _localctx.code.append(((TermContext)_localctx).b.code);
				        emit(_localctx.code, "    fmul.d " + _localctx.register + "," + _localctx.register + "," + nextRegister);
				      } else if(((TermContext)_localctx).op.getText().equals(":/)")){
				        _localctx.code.append(((TermContext)_localctx).b.code);
				        emit(_localctx.code, "    fdiv.d " + _localctx.register + "," + _localctx.register + "," + nextRegister);
				      } else {
				        // Modulo operation: convert to int, do mod, convert back to float
				        _localctx.code.append(((TermContext)_localctx).b.code);
				        emit(_localctx.code, "    # Modulo operation: " + _localctx.register + " % " + nextRegister);
				        emit(_localctx.code, "    fcvt.w.d t0, " + _localctx.register + "  # Convert left operand to int");
				        emit(_localctx.code, "    fcvt.w.d t1, " + nextRegister + "  # Convert right operand to int");
				        emit(_localctx.code, "    rem t0, t0, t1             # Integer modulo");
				        emit(_localctx.code, "    fcvt.d.w " + _localctx.register + ", t0  # Convert result back to double");
				      }
				    
				}
				}
				setState(127);
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
		public String register;
		public StringBuilder code;
		public Token INT;
		public Token FLOAT;
		public Token IDENT;
		public ExprContext expr;
		public TerminalNode INT() { return getToken(EmoticonParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(EmoticonParser.FLOAT, 0); }
		public TerminalNode IDENT() { return getToken(EmoticonParser.IDENT, 0); }
		public TerminalNode LPAREN() { return getToken(EmoticonParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(EmoticonParser.RPAREN, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public FactorContext(ParserRuleContext parent, int invokingState, String register) {
			super(parent, invokingState);
			this.register = register;
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor(String register) throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState(), register);
		enterRule(_localctx, 16, RULE_factor);
		try {
			setState(139);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				((FactorContext)_localctx).INT = match(INT);

				      int value = Integer.parseInt(((FactorContext)_localctx).INT.getText());
				      ((FactorContext)_localctx).code =  generateDoubleConstant(_localctx.register, (double) value);
				    
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				((FactorContext)_localctx).FLOAT = match(FLOAT);

				      double value = Double.parseDouble(((FactorContext)_localctx).FLOAT.getText());
				      ((FactorContext)_localctx).code =  generateDoubleConstant(_localctx.register, value);
				    
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(132);
				((FactorContext)_localctx).IDENT = match(IDENT);

				      //find if id has been used before
				      String id = ((FactorContext)_localctx).IDENT.getText();
				      Identifier var = lookupVariable(id);
				      // var used before assignment
				      if(var == null) {
				        error(((FactorContext)_localctx).IDENT, "use of variable '" + id + "' before assignment");
				      } else {
				        var.hasBeenUsed = true;
				      }
				      //gen code
				      ((FactorContext)_localctx).code =  generateLoadId(_localctx.register, id);
				    
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 4);
				{
				setState(134);
				match(LPAREN);
				setState(135);
				((FactorContext)_localctx).expr = expr(_localctx.register);
				setState(136);
				match(RPAREN);

				      ((FactorContext)_localctx).code =  ((FactorContext)_localctx).expr.code;
				    
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
	public static class IfstmtContext extends ParserRuleContext {
		public StringBuilder code;
		public ConditionContext condition;
		public SContext ifbody;
		public SContext elsebody;
		public TerminalNode KW_IF() { return getToken(EmoticonParser.KW_IF, 0); }
		public TerminalNode LPAREN() { return getToken(EmoticonParser.LPAREN, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(EmoticonParser.RPAREN, 0); }
		public List<SContext> s() {
			return getRuleContexts(SContext.class);
		}
		public SContext s(int i) {
			return getRuleContext(SContext.class,i);
		}
		public TerminalNode KW_ELSE() { return getToken(EmoticonParser.KW_ELSE, 0); }
		public IfstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstmt; }
	}

	public final IfstmtContext ifstmt() throws RecognitionException {
		IfstmtContext _localctx = new IfstmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ifstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(KW_IF);
			setState(142);
			match(LPAREN);
			setState(143);
			((IfstmtContext)_localctx).condition = condition();
			setState(144);
			match(RPAREN);
			setState(145);
			((IfstmtContext)_localctx).ifbody = s();
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(146);
				match(KW_ELSE);
				setState(147);
				((IfstmtContext)_localctx).elsebody = s();
				}
				break;
			}

			      ((IfstmtContext)_localctx).code =  new StringBuilder();
			      
			      // Generate condition evaluation
			      _localctx.code.append(((IfstmtContext)_localctx).condition.code);
			      
			      // Generate labels
			      String elseLabel = generateLabel("ELSE_");
			      String endLabel = generateLabel("END_IF_");
			      
			      // Jump to else/end if condition is false
			      generateComparison(_localctx.code, ((IfstmtContext)_localctx).condition.leftReg, ((IfstmtContext)_localctx).condition.rightReg, ((IfstmtContext)_localctx).condition.operator, elseLabel);
			      
			      // If body
			      _localctx.code.append(((IfstmtContext)_localctx).ifbody.code);
			      
			      if (((IfstmtContext)_localctx).elsebody != null) {
			        // Jump over else body
			        emit(_localctx.code, "    j " + endLabel);
			        
			        // Else label and body
			        emit(_localctx.code, elseLabel + ":");
			        _localctx.code.append(((IfstmtContext)_localctx).elsebody.code);
			        
			        // End label
			        emit(_localctx.code, endLabel + ":");
			      } else {
			        // Just end label (no else)
			        emit(_localctx.code, elseLabel + ":");
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
		public StringBuilder code;
		public ConditionContext condition;
		public BlockStatementContext body;
		public TerminalNode KW_WHILE() { return getToken(EmoticonParser.KW_WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(EmoticonParser.LPAREN, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(EmoticonParser.RPAREN, 0); }
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public WhilestmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whilestmt; }
	}

	public final WhilestmtContext whilestmt() throws RecognitionException {
		WhilestmtContext _localctx = new WhilestmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_whilestmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(KW_WHILE);
			setState(153);
			match(LPAREN);
			setState(154);
			((WhilestmtContext)_localctx).condition = condition();
			setState(155);
			match(RPAREN);
			setState(156);
			((WhilestmtContext)_localctx).body = blockStatement();

			      ((WhilestmtContext)_localctx).code =  new StringBuilder();
			      
			      // Generate labels
			      String loopLabel = generateLabel("LOOP_");
			      String endLabel = generateLabel("END_LOOP_");
			      
			      // Loop start label
			      emit(_localctx.code, loopLabel + ":");
			      
			      // Generate condition evaluation
			      _localctx.code.append(((WhilestmtContext)_localctx).condition.code);
			      
			      // Jump to end if condition is false
			      generateComparison(_localctx.code, ((WhilestmtContext)_localctx).condition.leftReg, ((WhilestmtContext)_localctx).condition.rightReg, ((WhilestmtContext)_localctx).condition.operator, endLabel);
			      
			      // Loop body
			      _localctx.code.append(((WhilestmtContext)_localctx).body.code);
			      
			      // Jump back to loop start
			      emit(_localctx.code, "    j " + loopLabel);
			      
			      // End label
			      emit(_localctx.code, endLabel + ":");
			    
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
		public StringBuilder code;
		public String leftReg;
		public String rightReg;
		public String operator;
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LESSTHAN() { return getToken(EmoticonParser.LESSTHAN, 0); }
		public TerminalNode GREATERTHAN() { return getToken(EmoticonParser.GREATERTHAN, 0); }
		public TerminalNode LESSTHANOREQUALTO() { return getToken(EmoticonParser.LESSTHANOREQUALTO, 0); }
		public TerminalNode GREATERTHANOREQUALTO() { return getToken(EmoticonParser.GREATERTHANOREQUALTO, 0); }
		public TerminalNode COMPARISON() { return getToken(EmoticonParser.COMPARISON, 0); }
		public TerminalNode NOTEQUAL() { return getToken(EmoticonParser.NOTEQUAL, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			String leftReg = "ft0"; String rightReg = "ft1";
			setState(160);
			((ConditionContext)_localctx).left = expr(leftReg);
			setState(161);
			((ConditionContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 824696635392L) != 0)) ) {
				((ConditionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(162);
			((ConditionContext)_localctx).right = expr(rightReg);

			      ((ConditionContext)_localctx).code =  new StringBuilder();
			      _localctx.code.append(((ConditionContext)_localctx).left.code);
			      _localctx.code.append(((ConditionContext)_localctx).right.code);
			      ((ConditionContext)_localctx).leftReg =  leftReg;
			      ((ConditionContext)_localctx).rightReg =  rightReg;
			      ((ConditionContext)_localctx).operator =  ((ConditionContext)_localctx).op.getText();
			    
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
		enterRule(_localctx, 24, RULE_operators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1966080L) != 0)) ) {
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
		enterRule(_localctx, 26, RULE_conditionals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
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
		enterRule(_localctx, 28, RULE_comp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
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
		"\u0004\u0001(\u00ac\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0005\u0000#\b\u0000\n\u0000\f\u0000&\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00017\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002>\b\u0002"+
		"\n\u0002\f\u0002A\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004S\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005]\b\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005i\b\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0005\u0006q\b\u0006\n\u0006\f\u0006t\t\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007|\b\u0007"+
		"\n\u0007\f\u0007\u007f\t\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u008c\b\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0095\b\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0000\u0000"+
		"\u000f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u0000\u0005\u0001\u0000\u0011\u0012\u0001\u0000\u0013\u0015"+
		"\u0002\u0000\u0016\u0019&\'\u0001\u0000\u0011\u0014\u0001\u0000\u0016"+
		"\u0019\u00ab\u0000\u001e\u0001\u0000\u0000\u0000\u00026\u0001\u0000\u0000"+
		"\u0000\u00048\u0001\u0000\u0000\u0000\u0006D\u0001\u0000\u0000\u0000\b"+
		"R\u0001\u0000\u0000\u0000\nh\u0001\u0000\u0000\u0000\fj\u0001\u0000\u0000"+
		"\u0000\u000eu\u0001\u0000\u0000\u0000\u0010\u008b\u0001\u0000\u0000\u0000"+
		"\u0012\u008d\u0001\u0000\u0000\u0000\u0014\u0098\u0001\u0000\u0000\u0000"+
		"\u0016\u009f\u0001\u0000\u0000\u0000\u0018\u00a5\u0001\u0000\u0000\u0000"+
		"\u001a\u00a7\u0001\u0000\u0000\u0000\u001c\u00a9\u0001\u0000\u0000\u0000"+
		"\u001e$\u0006\u0000\uffff\uffff\u0000\u001f \u0003\u0002\u0001\u0000 "+
		"!\u0006\u0000\uffff\uffff\u0000!#\u0001\u0000\u0000\u0000\"\u001f\u0001"+
		"\u0000\u0000\u0000#&\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000"+
		"$%\u0001\u0000\u0000\u0000%\'\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000"+
		"\u0000\'(\u0005\u0000\u0000\u0001()\u0006\u0000\uffff\uffff\u0000)\u0001"+
		"\u0001\u0000\u0000\u0000*+\u0003\u0006\u0003\u0000+,\u0006\u0001\uffff"+
		"\uffff\u0000,7\u0001\u0000\u0000\u0000-.\u0003\n\u0005\u0000./\u0006\u0001"+
		"\uffff\uffff\u0000/7\u0001\u0000\u0000\u000001\u0003\u0012\t\u000012\u0006"+
		"\u0001\uffff\uffff\u000027\u0001\u0000\u0000\u000034\u0003\u0014\n\u0000"+
		"45\u0006\u0001\uffff\uffff\u000057\u0001\u0000\u0000\u00006*\u0001\u0000"+
		"\u0000\u00006-\u0001\u0000\u0000\u000060\u0001\u0000\u0000\u000063\u0001"+
		"\u0000\u0000\u00007\u0003\u0001\u0000\u0000\u000089\u0005\u000b\u0000"+
		"\u00009?\u0006\u0002\uffff\uffff\u0000:;\u0003\u0002\u0001\u0000;<\u0006"+
		"\u0002\uffff\uffff\u0000<>\u0001\u0000\u0000\u0000=:\u0001\u0000\u0000"+
		"\u0000>A\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000"+
		"\u0000\u0000@B\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000BC\u0005"+
		"\f\u0000\u0000C\u0005\u0001\u0000\u0000\u0000DE\u0006\u0003\uffff\uffff"+
		"\u0000EF\u0005\u0010\u0000\u0000FG\u0006\u0003\uffff\uffff\u0000GH\u0005"+
		"(\u0000\u0000HI\u0003\b\u0004\u0000IJ\u0006\u0003\uffff\uffff\u0000J\u0007"+
		"\u0001\u0000\u0000\u0000KL\u0003\f\u0006\u0000LM\u0006\u0004\uffff\uffff"+
		"\u0000MS\u0001\u0000\u0000\u0000NO\u0005\u0001\u0000\u0000OS\u0006\u0004"+
		"\uffff\uffff\u0000PQ\u0005\u001f\u0000\u0000QS\u0006\u0004\uffff\uffff"+
		"\u0000RK\u0001\u0000\u0000\u0000RN\u0001\u0000\u0000\u0000RP\u0001\u0000"+
		"\u0000\u0000S\t\u0001\u0000\u0000\u0000TU\u0006\u0005\uffff\uffff\u0000"+
		"UV\u0005\u0002\u0000\u0000V\\\u0005!\u0000\u0000WX\u0003\f\u0006\u0000"+
		"XY\u0006\u0005\uffff\uffff\u0000Y]\u0001\u0000\u0000\u0000Z[\u0005\u001f"+
		"\u0000\u0000[]\u0006\u0005\uffff\uffff\u0000\\W\u0001\u0000\u0000\u0000"+
		"\\Z\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^i\u0005\"\u0000"+
		"\u0000_`\u0006\u0005\uffff\uffff\u0000`a\u0005\u0002\u0000\u0000ab\u0005"+
		"!\u0000\u0000bc\u0005\u001f\u0000\u0000cd\u0005#\u0000\u0000de\u0003\f"+
		"\u0006\u0000ef\u0005\"\u0000\u0000fg\u0006\u0005\uffff\uffff\u0000gi\u0001"+
		"\u0000\u0000\u0000hT\u0001\u0000\u0000\u0000h_\u0001\u0000\u0000\u0000"+
		"i\u000b\u0001\u0000\u0000\u0000jk\u0003\u000e\u0007\u0000kr\u0006\u0006"+
		"\uffff\uffff\u0000lm\u0007\u0000\u0000\u0000mn\u0003\u000e\u0007\u0000"+
		"no\u0006\u0006\uffff\uffff\u0000oq\u0001\u0000\u0000\u0000pl\u0001\u0000"+
		"\u0000\u0000qt\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000rs\u0001"+
		"\u0000\u0000\u0000s\r\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000"+
		"uv\u0003\u0010\b\u0000v}\u0006\u0007\uffff\uffff\u0000wx\u0007\u0001\u0000"+
		"\u0000xy\u0003\u0010\b\u0000yz\u0006\u0007\uffff\uffff\u0000z|\u0001\u0000"+
		"\u0000\u0000{w\u0001\u0000\u0000\u0000|\u007f\u0001\u0000\u0000\u0000"+
		"}{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u000f\u0001\u0000"+
		"\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u0080\u0081\u0005\u001c\u0000"+
		"\u0000\u0081\u008c\u0006\b\uffff\uffff\u0000\u0082\u0083\u0005\u001d\u0000"+
		"\u0000\u0083\u008c\u0006\b\uffff\uffff\u0000\u0084\u0085\u0005\u0010\u0000"+
		"\u0000\u0085\u008c\u0006\b\uffff\uffff\u0000\u0086\u0087\u0005!\u0000"+
		"\u0000\u0087\u0088\u0003\f\u0006\u0000\u0088\u0089\u0005\"\u0000\u0000"+
		"\u0089\u008a\u0006\b\uffff\uffff\u0000\u008a\u008c\u0001\u0000\u0000\u0000"+
		"\u008b\u0080\u0001\u0000\u0000\u0000\u008b\u0082\u0001\u0000\u0000\u0000"+
		"\u008b\u0084\u0001\u0000\u0000\u0000\u008b\u0086\u0001\u0000\u0000\u0000"+
		"\u008c\u0011\u0001\u0000\u0000\u0000\u008d\u008e\u0005\u0003\u0000\u0000"+
		"\u008e\u008f\u0005!\u0000\u0000\u008f\u0090\u0003\u0016\u000b\u0000\u0090"+
		"\u0091\u0005\"\u0000\u0000\u0091\u0094\u0003\u0002\u0001\u0000\u0092\u0093"+
		"\u0005\u0004\u0000\u0000\u0093\u0095\u0003\u0002\u0001\u0000\u0094\u0092"+
		"\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0096"+
		"\u0001\u0000\u0000\u0000\u0096\u0097\u0006\t\uffff\uffff\u0000\u0097\u0013"+
		"\u0001\u0000\u0000\u0000\u0098\u0099\u0005\u0007\u0000\u0000\u0099\u009a"+
		"\u0005!\u0000\u0000\u009a\u009b\u0003\u0016\u000b\u0000\u009b\u009c\u0005"+
		"\"\u0000\u0000\u009c\u009d\u0003\u0004\u0002\u0000\u009d\u009e\u0006\n"+
		"\uffff\uffff\u0000\u009e\u0015\u0001\u0000\u0000\u0000\u009f\u00a0\u0006"+
		"\u000b\uffff\uffff\u0000\u00a0\u00a1\u0003\f\u0006\u0000\u00a1\u00a2\u0007"+
		"\u0002\u0000\u0000\u00a2\u00a3\u0003\f\u0006\u0000\u00a3\u00a4\u0006\u000b"+
		"\uffff\uffff\u0000\u00a4\u0017\u0001\u0000\u0000\u0000\u00a5\u00a6\u0007"+
		"\u0003\u0000\u0000\u00a6\u0019\u0001\u0000\u0000\u0000\u00a7\u00a8\u0007"+
		"\u0004\u0000\u0000\u00a8\u001b\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005"+
		"&\u0000\u0000\u00aa\u001d\u0001\u0000\u0000\u0000\n$6?R\\hr}\u008b\u0094";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}