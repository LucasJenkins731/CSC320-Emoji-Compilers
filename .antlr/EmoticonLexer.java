// Generated from /Users/connorryan/Desktop/CSC320-Emoji-Compilers/Emoticon.g4 by ANTLR 4.13.1
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
		KW_READ=1, KW_PRINT=2, KW_IF=3, KW_ELSE=4, KW_ELSE_IF=5, KW_FOR=6, KW_WHILE=7, 
		KW_RETURN=8, KW_FUNCTION=9, KW_ARRAY=10, LBRACE=11, RBRACE=12, KW_INT=13, 
		KW_STRING=14, KW_CHAR=15, IDENT=16, ADD=17, SUBTRACT=18, MULTIPLY=19, 
		DIVIDE=20, MODULO=21, GREATERTHAN=22, LESSTHAN=23, GREATERTHANOREQUALTO=24, 
		LESSTHANOREQUALTO=25, LBRACKET=26, RBRACKET=27, INT=28, FLOAT=29, CHAR=30, 
		STRING=31, WS=32, LPAREN=33, RPAREN=34, COMMA=35, COMMENT=36, COMMENT_BLOCK=37, 
		COMPARISON=38, NOTEQUAL=39, ASSIGNMENT=40;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"KW_READ", "KW_PRINT", "KW_IF", "KW_ELSE", "KW_ELSE_IF", "KW_FOR", "KW_WHILE", 
			"KW_RETURN", "KW_FUNCTION", "KW_ARRAY", "LBRACE", "RBRACE", "KW_INT", 
			"KW_STRING", "KW_CHAR", "IDENT", "ADD", "SUBTRACT", "MULTIPLY", "DIVIDE", 
			"MODULO", "GREATERTHAN", "LESSTHAN", "GREATERTHANOREQUALTO", "LESSTHANOREQUALTO", 
			"LBRACKET", "RBRACKET", "INT", "FLOAT", "CHAR", "STRING", "WS", "LPAREN", 
			"RPAREN", "COMMA", "COMMENT", "COMMENT_BLOCK", "COMPARISON", "NOTEQUAL", 
			"ASSIGNMENT"
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
		"\u0004\u0000(\u013e\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
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
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0005\u000f\u00a5\b\u000f\n\u000f\f\u000f\u00a8\t\u000f\u0001"+
		"\u000f\u0001\u000f\u0004\u000f\u00ac\b\u000f\u000b\u000f\f\u000f\u00ad"+
		"\u0003\u000f\u00b0\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001b\u0003\u001b\u00dd\b\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0005\u001b\u00e2\b\u001b\n\u001b\f\u001b\u00e5"+
		"\t\u001b\u0003\u001b\u00e7\b\u001b\u0001\u001c\u0003\u001c\u00ea\b\u001c"+
		"\u0001\u001c\u0005\u001c\u00ed\b\u001c\n\u001c\f\u001c\u00f0\t\u001c\u0001"+
		"\u001c\u0001\u001c\u0004\u001c\u00f4\b\u001c\u000b\u001c\f\u001c\u00f5"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u00fc\b\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0005\u001e\u0102\b\u001e"+
		"\n\u001e\f\u001e\u0105\t\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0004"+
		"\u001f\u010a\b\u001f\u000b\u001f\f\u001f\u010b\u0001\u001f\u0001\u001f"+
		"\u0001 \u0001 \u0001!\u0001!\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001"+
		"#\u0005#\u011a\b#\n#\f#\u011d\t#\u0001#\u0001#\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0005$\u0126\b$\n$\f$\u0129\t$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001%\u0001%\u0001%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001\'\u0001\'\u0001\'\u0001\'\u0002\u0103\u0127\u0000(\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d"+
		"\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/"+
		"\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f? A!C\"E#G$I%K"+
		"&M\'O(\u0001\u0000\n\u0002\u0000AZaz\u0004\u000009AZ__az\u0001\u0000_"+
		"_\u0002\u0000++--\u0001\u000019\u0001\u000009\u0002\u0000\'\'\\\\\u0002"+
		"\u0000\"\"\'\'\u0003\u0000\t\n\r\r  \u0002\u0000\n\n\r\r\u014b\u0000\u0001"+
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
		"\u0000\u0000?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000"+
		"C\u0001\u0000\u0000\u0000\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001"+
		"\u0000\u0000\u0000\u0000I\u0001\u0000\u0000\u0000\u0000K\u0001\u0000\u0000"+
		"\u0000\u0000M\u0001\u0000\u0000\u0000\u0000O\u0001\u0000\u0000\u0000\u0001"+
		"Q\u0001\u0000\u0000\u0000\u0003W\u0001\u0000\u0000\u0000\u0005Z\u0001"+
		"\u0000\u0000\u0000\u0007]\u0001\u0000\u0000\u0000\t`\u0001\u0000\u0000"+
		"\u0000\u000bc\u0001\u0000\u0000\u0000\rg\u0001\u0000\u0000\u0000\u000f"+
		"k\u0001\u0000\u0000\u0000\u0011r\u0001\u0000\u0000\u0000\u0013z\u0001"+
		"\u0000\u0000\u0000\u0015\u0080\u0001\u0000\u0000\u0000\u0017\u0089\u0001"+
		"\u0000\u0000\u0000\u0019\u0092\u0001\u0000\u0000\u0000\u001b\u0096\u0001"+
		"\u0000\u0000\u0000\u001d\u009d\u0001\u0000\u0000\u0000\u001f\u00af\u0001"+
		"\u0000\u0000\u0000!\u00b1\u0001\u0000\u0000\u0000#\u00b5\u0001\u0000\u0000"+
		"\u0000%\u00b9\u0001\u0000\u0000\u0000\'\u00bd\u0001\u0000\u0000\u0000"+
		")\u00c1\u0001\u0000\u0000\u0000+\u00c5\u0001\u0000\u0000\u0000-\u00c9"+
		"\u0001\u0000\u0000\u0000/\u00cd\u0001\u0000\u0000\u00001\u00d2\u0001\u0000"+
		"\u0000\u00003\u00d7\u0001\u0000\u0000\u00005\u00d9\u0001\u0000\u0000\u0000"+
		"7\u00dc\u0001\u0000\u0000\u00009\u00e9\u0001\u0000\u0000\u0000;\u00f7"+
		"\u0001\u0000\u0000\u0000=\u00ff\u0001\u0000\u0000\u0000?\u0109\u0001\u0000"+
		"\u0000\u0000A\u010f\u0001\u0000\u0000\u0000C\u0111\u0001\u0000\u0000\u0000"+
		"E\u0113\u0001\u0000\u0000\u0000G\u0115\u0001\u0000\u0000\u0000I\u0120"+
		"\u0001\u0000\u0000\u0000K\u0130\u0001\u0000\u0000\u0000M\u0135\u0001\u0000"+
		"\u0000\u0000O\u013a\u0001\u0000\u0000\u0000QR\u0005-\u0000\u0000RS\u0005"+
		"0\u0000\u0000ST\u0005-\u0000\u0000TU\u00050\u0000\u0000UV\u0005-\u0000"+
		"\u0000V\u0002\u0001\u0000\u0000\u0000WX\u0005:\u0000\u0000XY\u0005P\u0000"+
		"\u0000Y\u0004\u0001\u0000\u0000\u0000Z[\u0005:\u0000\u0000[\\\u0005)\u0000"+
		"\u0000\\\u0006\u0001\u0000\u0000\u0000]^\u0005:\u0000\u0000^_\u0005(\u0000"+
		"\u0000_\b\u0001\u0000\u0000\u0000`a\u0005:\u0000\u0000ab\u0005|\u0000"+
		"\u0000b\n\u0001\u0000\u0000\u0000cd\u0005>\u0000\u0000de\u0005:\u0000"+
		"\u0000ef\u0005(\u0000\u0000f\f\u0001\u0000\u0000\u0000gh\u0005D\u0000"+
		"\u0000hi\u0005:\u0000\u0000ij\u0005<\u0000\u0000j\u000e\u0001\u0000\u0000"+
		"\u0000kl\u0005r\u0000\u0000lm\u0005e\u0000\u0000mn\u0005t\u0000\u0000"+
		"no\u0005u\u0000\u0000op\u0005r\u0000\u0000pq\u0005n\u0000\u0000q\u0010"+
		"\u0001\u0000\u0000\u0000rs\u0005=\u0000\u0000st\u0005^\u0000\u0000tu\u0005"+
		".\u0000\u0000uv\u0005_\u0000\u0000vw\u0005.\u0000\u0000wx\u0005^\u0000"+
		"\u0000xy\u0005=\u0000\u0000y\u0012\u0001\u0000\u0000\u0000z{\u0005(\u0000"+
		"\u0000{|\u0005o\u0000\u0000|}\u0005_\u0000\u0000}~\u0005o\u0000\u0000"+
		"~\u007f\u0005)\u0000\u0000\u007f\u0014\u0001\u0000\u0000\u0000\u0080\u0081"+
		"\u0005>\u0000\u0000\u0081\u0082\u0005<\u0000\u0000\u0082\u0083\u0005("+
		"\u0000\u0000\u0083\u0084\u0005(\u0000\u0000\u0084\u0085\u0005(\u0000\u0000"+
		"\u0085\u0086\u0005,\u0000\u0000\u0086\u0087\u0005^\u0000\u0000\u0087\u0088"+
		"\u0005>\u0000\u0000\u0088\u0016\u0001\u0000\u0000\u0000\u0089\u008a\u0005"+
		"<\u0000\u0000\u008a\u008b\u0005^\u0000\u0000\u008b\u008c\u0005,\u0000"+
		"\u0000\u008c\u008d\u0005)\u0000\u0000\u008d\u008e\u0005)\u0000\u0000\u008e"+
		"\u008f\u0005)\u0000\u0000\u008f\u0090\u0005>\u0000\u0000\u0090\u0091\u0005"+
		"<\u0000\u0000\u0091\u0018\u0001\u0000\u0000\u0000\u0092\u0093\u0005i\u0000"+
		"\u0000\u0093\u0094\u0005n\u0000\u0000\u0094\u0095\u0005t\u0000\u0000\u0095"+
		"\u001a\u0001\u0000\u0000\u0000\u0096\u0097\u0005s\u0000\u0000\u0097\u0098"+
		"\u0005t\u0000\u0000\u0098\u0099\u0005r\u0000\u0000\u0099\u009a\u0005i"+
		"\u0000\u0000\u009a\u009b\u0005n\u0000\u0000\u009b\u009c\u0005g\u0000\u0000"+
		"\u009c\u001c\u0001\u0000\u0000\u0000\u009d\u009e\u0005c\u0000\u0000\u009e"+
		"\u009f\u0005h\u0000\u0000\u009f\u00a0\u0005a\u0000\u0000\u00a0\u00a1\u0005"+
		"r\u0000\u0000\u00a1\u001e\u0001\u0000\u0000\u0000\u00a2\u00a6\u0007\u0000"+
		"\u0000\u0000\u00a3\u00a5\u0007\u0001\u0000\u0000\u00a4\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a5\u00a8\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00b0\u0001\u0000"+
		"\u0000\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a9\u00ab\u0007\u0002"+
		"\u0000\u0000\u00aa\u00ac\u0007\u0001\u0000\u0000\u00ab\u00aa\u0001\u0000"+
		"\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001\u0000"+
		"\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae\u00b0\u0001\u0000"+
		"\u0000\u0000\u00af\u00a2\u0001\u0000\u0000\u0000\u00af\u00a9\u0001\u0000"+
		"\u0000\u0000\u00b0 \u0001\u0000\u0000\u0000\u00b1\u00b2\u0005:\u0000\u0000"+
		"\u00b2\u00b3\u0005+\u0000\u0000\u00b3\u00b4\u0005)\u0000\u0000\u00b4\""+
		"\u0001\u0000\u0000\u0000\u00b5\u00b6\u0005:\u0000\u0000\u00b6\u00b7\u0005"+
		"-\u0000\u0000\u00b7\u00b8\u0005)\u0000\u0000\u00b8$\u0001\u0000\u0000"+
		"\u0000\u00b9\u00ba\u0005:\u0000\u0000\u00ba\u00bb\u0005*\u0000\u0000\u00bb"+
		"\u00bc\u0005)\u0000\u0000\u00bc&\u0001\u0000\u0000\u0000\u00bd\u00be\u0005"+
		":\u0000\u0000\u00be\u00bf\u0005/\u0000\u0000\u00bf\u00c0\u0005)\u0000"+
		"\u0000\u00c0(\u0001\u0000\u0000\u0000\u00c1\u00c2\u0005:\u0000\u0000\u00c2"+
		"\u00c3\u0005%\u0000\u0000\u00c3\u00c4\u0005)\u0000\u0000\u00c4*\u0001"+
		"\u0000\u0000\u0000\u00c5\u00c6\u0005:\u0000\u0000\u00c6\u00c7\u0005>\u0000"+
		"\u0000\u00c7\u00c8\u0005)\u0000\u0000\u00c8,\u0001\u0000\u0000\u0000\u00c9"+
		"\u00ca\u0005:\u0000\u0000\u00ca\u00cb\u0005<\u0000\u0000\u00cb\u00cc\u0005"+
		")\u0000\u0000\u00cc.\u0001\u0000\u0000\u0000\u00cd\u00ce\u0005:\u0000"+
		"\u0000\u00ce\u00cf\u0005>\u0000\u0000\u00cf\u00d0\u0005=\u0000\u0000\u00d0"+
		"\u00d1\u0005)\u0000\u0000\u00d10\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005"+
		":\u0000\u0000\u00d3\u00d4\u0005<\u0000\u0000\u00d4\u00d5\u0005=\u0000"+
		"\u0000\u00d5\u00d6\u0005)\u0000\u0000\u00d62\u0001\u0000\u0000\u0000\u00d7"+
		"\u00d8\u0005[\u0000\u0000\u00d84\u0001\u0000\u0000\u0000\u00d9\u00da\u0005"+
		"]\u0000\u0000\u00da6\u0001\u0000\u0000\u0000\u00db\u00dd\u0007\u0003\u0000"+
		"\u0000\u00dc\u00db\u0001\u0000\u0000\u0000\u00dc\u00dd\u0001\u0000\u0000"+
		"\u0000\u00dd\u00e6\u0001\u0000\u0000\u0000\u00de\u00e7\u00050\u0000\u0000"+
		"\u00df\u00e3\u0007\u0004\u0000\u0000\u00e0\u00e2\u0007\u0005\u0000\u0000"+
		"\u00e1\u00e0\u0001\u0000\u0000\u0000\u00e2\u00e5\u0001\u0000\u0000\u0000"+
		"\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000"+
		"\u00e4\u00e7\u0001\u0000\u0000\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000"+
		"\u00e6\u00de\u0001\u0000\u0000\u0000\u00e6\u00df\u0001\u0000\u0000\u0000"+
		"\u00e78\u0001\u0000\u0000\u0000\u00e8\u00ea\u0007\u0003\u0000\u0000\u00e9"+
		"\u00e8\u0001\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea"+
		"\u00ee\u0001\u0000\u0000\u0000\u00eb\u00ed\u0007\u0005\u0000\u0000\u00ec"+
		"\u00eb\u0001\u0000\u0000\u0000\u00ed\u00f0\u0001\u0000\u0000\u0000\u00ee"+
		"\u00ec\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001\u0000\u0000\u0000\u00ef"+
		"\u00f1\u0001\u0000\u0000\u0000\u00f0\u00ee\u0001\u0000\u0000\u0000\u00f1"+
		"\u00f3\u0005.\u0000\u0000\u00f2\u00f4\u0007\u0005\u0000\u0000\u00f3\u00f2"+
		"\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000\u0000\u00f5\u00f3"+
		"\u0001\u0000\u0000\u0000\u00f5\u00f6\u0001\u0000\u0000\u0000\u00f6:\u0001"+
		"\u0000\u0000\u0000\u00f7\u00fb\u0005\'\u0000\u0000\u00f8\u00f9\u0005\\"+
		"\u0000\u0000\u00f9\u00fc\t\u0000\u0000\u0000\u00fa\u00fc\b\u0006\u0000"+
		"\u0000\u00fb\u00f8\u0001\u0000\u0000\u0000\u00fb\u00fa\u0001\u0000\u0000"+
		"\u0000\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fd\u00fe\u0005\'\u0000\u0000"+
		"\u00fe<\u0001\u0000\u0000\u0000\u00ff\u0103\u0007\u0007\u0000\u0000\u0100"+
		"\u0102\t\u0000\u0000\u0000\u0101\u0100\u0001\u0000\u0000\u0000\u0102\u0105"+
		"\u0001\u0000\u0000\u0000\u0103\u0104\u0001\u0000\u0000\u0000\u0103\u0101"+
		"\u0001\u0000\u0000\u0000\u0104\u0106\u0001\u0000\u0000\u0000\u0105\u0103"+
		"\u0001\u0000\u0000\u0000\u0106\u0107\u0007\u0007\u0000\u0000\u0107>\u0001"+
		"\u0000\u0000\u0000\u0108\u010a\u0007\b\u0000\u0000\u0109\u0108\u0001\u0000"+
		"\u0000\u0000\u010a\u010b\u0001\u0000\u0000\u0000\u010b\u0109\u0001\u0000"+
		"\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c\u010d\u0001\u0000"+
		"\u0000\u0000\u010d\u010e\u0006\u001f\u0000\u0000\u010e@\u0001\u0000\u0000"+
		"\u0000\u010f\u0110\u0005(\u0000\u0000\u0110B\u0001\u0000\u0000\u0000\u0111"+
		"\u0112\u0005)\u0000\u0000\u0112D\u0001\u0000\u0000\u0000\u0113\u0114\u0005"+
		",\u0000\u0000\u0114F\u0001\u0000\u0000\u0000\u0115\u0116\u0005<\u0000"+
		"\u0000\u0116\u0117\u00053\u0000\u0000\u0117\u011b\u0001\u0000\u0000\u0000"+
		"\u0118\u011a\b\t\u0000\u0000\u0119\u0118\u0001\u0000\u0000\u0000\u011a"+
		"\u011d\u0001\u0000\u0000\u0000\u011b\u0119\u0001\u0000\u0000\u0000\u011b"+
		"\u011c\u0001\u0000\u0000\u0000\u011c\u011e\u0001\u0000\u0000\u0000\u011d"+
		"\u011b\u0001\u0000\u0000\u0000\u011e\u011f\u0006#\u0000\u0000\u011fH\u0001"+
		"\u0000\u0000\u0000\u0120\u0121\u0005O\u0000\u0000\u0121\u0122\u0005W\u0000"+
		"\u0000\u0122\u0123\u0005O\u0000\u0000\u0123\u0127\u0001\u0000\u0000\u0000"+
		"\u0124\u0126\t\u0000\u0000\u0000\u0125\u0124\u0001\u0000\u0000\u0000\u0126"+
		"\u0129\u0001\u0000\u0000\u0000\u0127\u0128\u0001\u0000\u0000\u0000\u0127"+
		"\u0125\u0001\u0000\u0000\u0000\u0128\u012a\u0001\u0000\u0000\u0000\u0129"+
		"\u0127\u0001\u0000\u0000\u0000\u012a\u012b\u0005U\u0000\u0000\u012b\u012c"+
		"\u0005W\u0000\u0000\u012c\u012d\u0005U\u0000\u0000\u012d\u012e\u0001\u0000"+
		"\u0000\u0000\u012e\u012f\u0006$\u0000\u0000\u012fJ\u0001\u0000\u0000\u0000"+
		"\u0130\u0131\u0005:\u0000\u0000\u0131\u0132\u0005=\u0000\u0000\u0132\u0133"+
		"\u0005=\u0000\u0000\u0133\u0134\u0005)\u0000\u0000\u0134L\u0001\u0000"+
		"\u0000\u0000\u0135\u0136\u0005:\u0000\u0000\u0136\u0137\u0005!\u0000\u0000"+
		"\u0137\u0138\u0005=\u0000\u0000\u0138\u0139\u0005)\u0000\u0000\u0139N"+
		"\u0001\u0000\u0000\u0000\u013a\u013b\u0005:\u0000\u0000\u013b\u013c\u0005"+
		"=\u0000\u0000\u013c\u013d\u0005)\u0000\u0000\u013dP\u0001\u0000\u0000"+
		"\u0000\u000f\u0000\u00a6\u00ad\u00af\u00dc\u00e3\u00e6\u00e9\u00ee\u00f5"+
		"\u00fb\u0103\u010b\u011b\u0127\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}