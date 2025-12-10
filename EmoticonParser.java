// Generated from Emoticon.g4 by ANTLR 4.13.2
 import java.util.*; import java.io.*; import org.antlr.v4.runtime.*; import org.antlr.v4.runtime.tree.*; 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class EmoticonParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

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
		RULE_ps = 5, RULE_expr = 6, RULE_term = 7, RULE_factor = 8, RULE_arrayAccess = 9, 
		RULE_ifstmt = 10, RULE_whilestmt = 11, RULE_arraystmt = 12, RULE_condition = 13, 
		RULE_operators = 14, RULE_conditionals = 15, RULE_comp = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "s", "blockStatement", "as", "rhs", "ps", "expr", "term", 
			"factor", "arrayAccess", "ifstmt", "whilestmt", "arraystmt", "condition", 
			"operators", "conditionals", "comp"
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
	        
	        if (identifier.isArray && identifier.arrayValues != null) {
	          // Array: allocate space for all elements
	          int arraySize = identifier.arrayValues.length;
	          data_emit(label + ":    .space " + (arraySize * 8)); // 8 bytes per double
	          System.out.println("Allocated array " + id + " with " + arraySize + " elements");
	        } else {
	          // Regular variable
	          data_emit(label + ":    .double 0.0");
	        }
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
	  // Generate code to load array element into register
	  StringBuilder generateLoad1DArrayElement(String register, String arrayName, String indexReg) {
	    StringBuilder code = new StringBuilder();
	    emit(code, "    # Load 1D array element " + arrayName + "[" + indexReg + "]");
	    emit(code, "    fcvt.w.d t0, " + indexReg + "  # Convert index to int");
	    emit(code, "    li t1, 8                    # Size of double");
	    emit(code, "    mul t0, t0, t1              # Calculate offset");
	    emit(code, "    la t1, " + ID_PREFIX + arrayName + "  # Load array base address");
	    emit(code, "    add t0, t1, t0              # Add offset to base");
	    emit(code, "    fld " + register + ", (t0)   # Load element");
	    return code;
	  }
	  
	  // Generate code to store register value into array element
	  StringBuilder generateStore1DArrayElement(String register, String arrayName, String indexReg) {
	    StringBuilder code = new StringBuilder();
	    emit(code, "    # Store 1D array element " + arrayName + "[" + indexReg + "]");
	    emit(code, "    fcvt.w.d t0, " + indexReg + "  # Convert index to int");
	    emit(code, "    li t1, 8                    # Size of double");
	    emit(code, "    mul t0, t0, t1              # Calculate offset");
	    emit(code, "    la t1, " + ID_PREFIX + arrayName + "  # Load array base address");
	    emit(code, "    add t0, t1, t0              # Add offset to base");
	    emit(code, "    fsd " + register + ", (t0)   # Store element");
	    return code;
	  }
	  
	  // Generate code to load 2D array element
	  StringBuilder generateLoad2DArrayElement(String register, String arrayName, String indexReg1, String indexReg2, int cols) {
	    StringBuilder code = new StringBuilder();
	    emit(code, "    # Load 2D array element " + arrayName + "[" + indexReg1 + "][" + indexReg2 + "]");
	    emit(code, "    fcvt.w.d t0, " + indexReg1 + "  # Convert row index to int");
	    emit(code, "    fcvt.w.d t1, " + indexReg2 + "  # Convert col index to int");
	    emit(code, "    li t2, " + cols + "           # Number of columns");
	    emit(code, "    mul t0, t0, t2              # row * cols");
	    emit(code, "    add t0, t0, t1              # row * cols + col");
	    emit(code, "    li t1, 8                    # Size of double");
	    emit(code, "    mul t0, t0, t1              # Calculate offset");
	    emit(code, "    la t1, " + ID_PREFIX + arrayName + "  # Load array base address");
	    emit(code, "    add t0, t1, t0              # Add offset to base");
	    emit(code, "    fld " + register + ", (t0)   # Load element");
	    return code;
	  }
	  
	  // Generate code to store register value into 2D array element
	  StringBuilder generateStore2DArrayElement(String register, String arrayName, String indexReg1, String indexReg2, int cols) {
	    StringBuilder code = new StringBuilder();
	    emit(code, "    # Store 2D array element " + arrayName + "[" + indexReg1 + "][" + indexReg2 + "]");
	    emit(code, "    fcvt.w.d t0, " + indexReg1 + "  # Convert row index to int");
	    emit(code, "    fcvt.w.d t1, " + indexReg2 + "  # Convert col index to int");
	    emit(code, "    li t2, " + cols + "           # Number of columns");
	    emit(code, "    mul t0, t0, t2              # row * cols");
	    emit(code, "    add t0, t0, t1              # row * cols + col");
	    emit(code, "    li t1, 8                    # Size of double");
	    emit(code, "    mul t0, t0, t1              # Calculate offset");
	    emit(code, "    la t1, " + ID_PREFIX + arrayName + "  # Load array base address");
	    emit(code, "    add t0, t1, t0              # Add offset to base");
	    emit(code, "    fsd " + register + ", (t0)   # Store element");
	    return code;
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 
			      openProgram();
			    
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 66700L) != 0)) {
				{
				{
				setState(35);
				((ProgramContext)_localctx).s = s();

				      text_sb.append(((ProgramContext)_localctx).s.code);
				    
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43);
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
		public ArraystmtContext arraystmt;
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
		public ArraystmtContext arraystmt() {
			return getRuleContext(ArraystmtContext.class,0);
		}
		public SContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_s; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitS(this);
		}
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_s);
		try {
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				((SContext)_localctx).as = as();
				((SContext)_localctx).code =  ((SContext)_localctx).as.code;
				}
				break;
			case KW_PRINT:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				((SContext)_localctx).ps = ps();
				((SContext)_localctx).code =  ((SContext)_localctx).ps.code;
				}
				break;
			case KW_IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(52);
				((SContext)_localctx).ifstmt = ifstmt();
				((SContext)_localctx).code =  ((SContext)_localctx).ifstmt.code;
				}
				break;
			case KW_WHILE:
				enterOuterAlt(_localctx, 4);
				{
				setState(55);
				((SContext)_localctx).whilestmt = whilestmt();
				((SContext)_localctx).code =  ((SContext)_localctx).whilestmt.code;
				}
				break;
			case KW_ARRAY:
				enterOuterAlt(_localctx, 5);
				{
				setState(58);
				((SContext)_localctx).arraystmt = arraystmt();
				((SContext)_localctx).code =  ((SContext)_localctx).arraystmt.code;
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitBlockStatement(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_blockStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(LBRACE);

			      ((BlockStatementContext)_localctx).code =  new StringBuilder();
			    
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 66700L) != 0)) {
				{
				{
				setState(65);
				((BlockStatementContext)_localctx).stmt = s();

				      _localctx.code.append(((BlockStatementContext)_localctx).stmt.code);
				    
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73);
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
		public ExprContext index1;
		public ExprContext index2;
		public RhsContext rhs;
		public TerminalNode IDENT() { return getToken(EmoticonParser.IDENT, 0); }
		public List<TerminalNode> LBRACKET() { return getTokens(EmoticonParser.LBRACKET); }
		public TerminalNode LBRACKET(int i) {
			return getToken(EmoticonParser.LBRACKET, i);
		}
		public List<TerminalNode> RBRACKET() { return getTokens(EmoticonParser.RBRACKET); }
		public TerminalNode RBRACKET(int i) {
			return getToken(EmoticonParser.RBRACKET, i);
		}
		public TerminalNode ASSIGNMENT() { return getToken(EmoticonParser.ASSIGNMENT, 0); }
		public RhsContext rhs() {
			return getRuleContext(RhsContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_as; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterAs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitAs(this);
		}
	}

	public final AsContext as() throws RecognitionException {
		AsContext _localctx = new AsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_as);
		int _la;
		try {
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				String register = "fa0";
				setState(76);
				((AsContext)_localctx).IDENT = match(IDENT);
				setState(77);
				match(LBRACKET);
				setState(78);
				((AsContext)_localctx).index1 = expr("ft2");
				setState(79);
				match(RBRACKET);
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(80);
					match(LBRACKET);
					setState(81);
					((AsContext)_localctx).index2 = expr("ft3");
					setState(82);
					match(RBRACKET);
					}
				}

				setState(86);
				match(ASSIGNMENT);
				setState(87);
				((AsContext)_localctx).rhs = rhs(register);

				      // Array element assignment
				      ((AsContext)_localctx).code =  new StringBuilder();
				      String arrayName = ((AsContext)_localctx).IDENT.getText();
				      boolean is2D = (((AsContext)_localctx).index2 != null);
				      
				      Identifier arrayVar = lookupVariable(arrayName);
				      
				      if (arrayVar == null) {
				        error(((AsContext)_localctx).IDENT, "Undefined array '" + arrayName + "'");
				      } else if (!arrayVar.isArray) {
				        error(((AsContext)_localctx).IDENT, "'" + arrayName + "' is not an array");
				      } else {
				        arrayVar.hasBeenUsed = true;
				        
				        // Generate index calculation first
				        _localctx.code.append(((AsContext)_localctx).index1.code); // Generate code for first index
				        if (is2D) {
				          _localctx.code.append(((AsContext)_localctx).index2.code); // Generate code for second index
				        }
				        
				        // Generate RHS value
				        _localctx.code.append(((AsContext)_localctx).rhs.code);
				        
				        // Generate store operation
				        if (is2D) {
				          _localctx.code.append(generateStore2DArrayElement(register, arrayName, "ft2", "ft3", arrayVar.arraySize));
				        } else {
				          _localctx.code.append(generateStore1DArrayElement(register, arrayName, "ft2"));
				        }
				      }
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				String register = "fa0";
				setState(91);
				((AsContext)_localctx).IDENT = match(IDENT);

				      String id = ((AsContext)_localctx).IDENT.getText();
				      Identifier var = lookupVariable(id);
				      //System.out.println(var);
				    
				setState(93);
				match(ASSIGNMENT);
				setState(94);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterRhs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitRhs(this);
		}
	}

	public final RhsContext rhs(String register) throws RecognitionException {
		RhsContext _localctx = new RhsContext(_ctx, getState(), register);
		enterRule(_localctx, 8, RULE_rhs);
		try {
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
			case INT:
			case FLOAT:
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				((RhsContext)_localctx).expr = expr(_localctx.register);
				((RhsContext)_localctx).code =  ((RhsContext)_localctx).expr.code;
				}
				break;
			case KW_READ:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				match(KW_READ);

				    ((RhsContext)_localctx).code =  new StringBuilder();
				    generateReadDouble(_localctx.code, _localctx.register);
				  
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(104);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterPs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitPs(this);
		}
	}

	public final PsContext ps() throws RecognitionException {
		PsContext _localctx = new PsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ps);
		try {
			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				String register = "fa0";
				setState(109);
				match(KW_PRINT);
				setState(110);
				match(LPAREN);
				setState(116);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IDENT:
				case INT:
				case FLOAT:
				case LPAREN:
					{
					setState(111);
					((PsContext)_localctx).expr = expr(register);

					        ((PsContext)_localctx).code =  ((PsContext)_localctx).expr.code;
					        generatePrintDouble(_localctx.code, register);
					      
					}
					break;
				case STRING:
					{
					setState(114);
					((PsContext)_localctx).STRING = match(STRING);

					        ((PsContext)_localctx).code =  new StringBuilder();
					        generatePrintStringConstant(_localctx.code, ((PsContext)_localctx).STRING.getText());
					      
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(118);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				String register = "fa0";
				setState(120);
				match(KW_PRINT);
				setState(121);
				match(LPAREN);
				setState(122);
				((PsContext)_localctx).STRING = match(STRING);
				setState(123);
				match(COMMA);
				setState(124);
				((PsContext)_localctx).expr = expr(register);
				setState(125);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr(String register) throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState(), register);
		enterRule(_localctx, 12, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			((ExprContext)_localctx).a = term(_localctx.register);

			    ((ExprContext)_localctx).code =  ((ExprContext)_localctx).a.code;
			    String nextRegister = (_localctx.register.equals("ft0")) ? "ft1" : "ft0";
			  
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==SUBTRACT) {
				{
				{
				setState(132);
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
				setState(133);
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
				setState(140);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitTerm(this);
		}
	}

	public final TermContext term(String register) throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState(), register);
		enterRule(_localctx, 14, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			((TermContext)_localctx).a = factor(_localctx.register);

			      ((TermContext)_localctx).code =  ((TermContext)_localctx).a.code;
			      String nextRegister = (_localctx.register.equals("ft0")) ? "ft1" : "ft0";
			    
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3670016L) != 0)) {
				{
				{
				setState(143);
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
				setState(144);
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
				setState(151);
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
		public ArrayAccessContext arrayAccess;
		public Token IDENT;
		public ExprContext expr;
		public TerminalNode INT() { return getToken(EmoticonParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(EmoticonParser.FLOAT, 0); }
		public ArrayAccessContext arrayAccess() {
			return getRuleContext(ArrayAccessContext.class,0);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor(String register) throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState(), register);
		enterRule(_localctx, 16, RULE_factor);
		try {
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				((FactorContext)_localctx).INT = match(INT);

				      int value = Integer.parseInt(((FactorContext)_localctx).INT.getText());
				      ((FactorContext)_localctx).code =  generateDoubleConstant(_localctx.register, (double) value);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				((FactorContext)_localctx).FLOAT = match(FLOAT);

				      double value = Double.parseDouble(((FactorContext)_localctx).FLOAT.getText());
				      ((FactorContext)_localctx).code =  generateDoubleConstant(_localctx.register, value);
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(156);
				((FactorContext)_localctx).arrayAccess = arrayAccess(_localctx.register);

				      ((FactorContext)_localctx).code =  ((FactorContext)_localctx).arrayAccess.code;
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(159);
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
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(161);
				match(LPAREN);
				setState(162);
				((FactorContext)_localctx).expr = expr(_localctx.register);
				setState(163);
				match(RPAREN);

				      ((FactorContext)_localctx).code =  ((FactorContext)_localctx).expr.code;
				    
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
	public static class ArrayAccessContext extends ParserRuleContext {
		public String register;
		public StringBuilder code;
		public String arrayName;
		public String indexReg;
		public boolean is2D;
		public Token IDENT;
		public ExprContext index1;
		public ExprContext index2;
		public TerminalNode IDENT() { return getToken(EmoticonParser.IDENT, 0); }
		public List<TerminalNode> LBRACKET() { return getTokens(EmoticonParser.LBRACKET); }
		public TerminalNode LBRACKET(int i) {
			return getToken(EmoticonParser.LBRACKET, i);
		}
		public List<TerminalNode> RBRACKET() { return getTokens(EmoticonParser.RBRACKET); }
		public TerminalNode RBRACKET(int i) {
			return getToken(EmoticonParser.RBRACKET, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArrayAccessContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ArrayAccessContext(ParserRuleContext parent, int invokingState, String register) {
			super(parent, invokingState);
			this.register = register;
		}
		@Override public int getRuleIndex() { return RULE_arrayAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterArrayAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitArrayAccess(this);
		}
	}

	public final ArrayAccessContext arrayAccess(String register) throws RecognitionException {
		ArrayAccessContext _localctx = new ArrayAccessContext(_ctx, getState(), register);
		enterRule(_localctx, 18, RULE_arrayAccess);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			((ArrayAccessContext)_localctx).IDENT = match(IDENT);
			setState(169);
			match(LBRACKET);
			setState(170);
			((ArrayAccessContext)_localctx).index1 = expr("ft2");
			setState(171);
			match(RBRACKET);
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(172);
				match(LBRACKET);
				setState(173);
				((ArrayAccessContext)_localctx).index2 = expr("ft3");
				setState(174);
				match(RBRACKET);
				}
			}


			      ((ArrayAccessContext)_localctx).code =  new StringBuilder();
			      ((ArrayAccessContext)_localctx).arrayName =  ((ArrayAccessContext)_localctx).IDENT.getText();
			      ((ArrayAccessContext)_localctx).indexReg =  "ft2";
			      ((ArrayAccessContext)_localctx).is2D =  (((ArrayAccessContext)_localctx).index2 != null);
			      
			      Identifier arrayVar = lookupVariable(_localctx.arrayName);
			      
			      if (arrayVar == null) {
			        error(((ArrayAccessContext)_localctx).IDENT, "Undefined array '" + _localctx.arrayName + "'");
			        ((ArrayAccessContext)_localctx).code =  new StringBuilder();
			      } else if (!arrayVar.isArray) {
			        error(((ArrayAccessContext)_localctx).IDENT, "'" + _localctx.arrayName + "' is not an array");
			        ((ArrayAccessContext)_localctx).code =  new StringBuilder();
			      } else {
			        arrayVar.hasBeenUsed = true;
			        _localctx.code.append(((ArrayAccessContext)_localctx).index1.code); // Generate code for first index
			        
			        if (_localctx.is2D) {
			          // 2D array access: array[i][j] 
			          _localctx.code.append(((ArrayAccessContext)_localctx).index2.code); // Generate code for second index
			          _localctx.code.append(generateLoad2DArrayElement(_localctx.register, _localctx.arrayName, "ft2", "ft3", arrayVar.arraySize));
			        } else {
			          // 1D array access: array[i]
			          _localctx.code.append(generateLoad1DArrayElement(_localctx.register, _localctx.arrayName, "ft2"));
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
	public static class IfstmtContext extends ParserRuleContext {
		public StringBuilder code;
		public ConditionContext condition;
		public BlockStatementContext ifbody;
		public BlockStatementContext elsebody;
		public TerminalNode KW_IF() { return getToken(EmoticonParser.KW_IF, 0); }
		public TerminalNode LPAREN() { return getToken(EmoticonParser.LPAREN, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(EmoticonParser.RPAREN, 0); }
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public TerminalNode KW_ELSE() { return getToken(EmoticonParser.KW_ELSE, 0); }
		public IfstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterIfstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitIfstmt(this);
		}
	}

	public final IfstmtContext ifstmt() throws RecognitionException {
		IfstmtContext _localctx = new IfstmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ifstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(KW_IF);
			setState(181);
			match(LPAREN);
			setState(182);
			((IfstmtContext)_localctx).condition = condition();
			setState(183);
			match(RPAREN);
			setState(184);
			((IfstmtContext)_localctx).ifbody = blockStatement();
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_ELSE) {
				{
				setState(185);
				match(KW_ELSE);
				setState(186);
				((IfstmtContext)_localctx).elsebody = blockStatement();
				}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterWhilestmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitWhilestmt(this);
		}
	}

	public final WhilestmtContext whilestmt() throws RecognitionException {
		WhilestmtContext _localctx = new WhilestmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_whilestmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(KW_WHILE);
			setState(192);
			match(LPAREN);
			setState(193);
			((WhilestmtContext)_localctx).condition = condition();
			setState(194);
			match(RPAREN);
			setState(195);
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
	public static class ArraystmtContext extends ParserRuleContext {
		public StringBuilder code;
		public Token IDENT;
		public Token size1;
		public Token size2;
		public TerminalNode KW_ARRAY() { return getToken(EmoticonParser.KW_ARRAY, 0); }
		public TerminalNode IDENT() { return getToken(EmoticonParser.IDENT, 0); }
		public TerminalNode ASSIGNMENT() { return getToken(EmoticonParser.ASSIGNMENT, 0); }
		public List<TerminalNode> LBRACKET() { return getTokens(EmoticonParser.LBRACKET); }
		public TerminalNode LBRACKET(int i) {
			return getToken(EmoticonParser.LBRACKET, i);
		}
		public List<TerminalNode> RBRACKET() { return getTokens(EmoticonParser.RBRACKET); }
		public TerminalNode RBRACKET(int i) {
			return getToken(EmoticonParser.RBRACKET, i);
		}
		public List<TerminalNode> INT() { return getTokens(EmoticonParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(EmoticonParser.INT, i);
		}
		public ArraystmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arraystmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterArraystmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitArraystmt(this);
		}
	}

	public final ArraystmtContext arraystmt() throws RecognitionException {
		ArraystmtContext _localctx = new ArraystmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_arraystmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(KW_ARRAY);
			setState(199);
			((ArraystmtContext)_localctx).IDENT = match(IDENT);
			setState(200);
			match(ASSIGNMENT);
			setState(201);
			match(LBRACKET);
			setState(202);
			((ArraystmtContext)_localctx).size1 = match(INT);
			setState(203);
			match(RBRACKET);
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(204);
				match(LBRACKET);
				setState(205);
				((ArraystmtContext)_localctx).size2 = match(INT);
				setState(206);
				match(RBRACKET);
				}
			}


			      ((ArraystmtContext)_localctx).code =  new StringBuilder();
			      String arrayName = ((ArraystmtContext)_localctx).IDENT.getText();
			      int arraySize1 = Integer.parseInt(((ArraystmtContext)_localctx).size1.getText());
			      
			      // Create array identifier
			      Identifier arrayId = new Identifier();
			      arrayId.id = arrayName;
			      arrayId.type = Type.ARRAY;
			      arrayId.isArray = true;
			      arrayId.arraySize = arraySize1;
			      arrayId.hasBeenUsed = false;
			      
			      if (((ArraystmtContext)_localctx).size2 != null) {
			        // 2D array
			        int arraySize2 = Integer.parseInt(((ArraystmtContext)_localctx).size2.getText());
			        arrayId.arrayValues = new Object[arraySize1 * arraySize2]; // Flatten 2D to 1D
			        System.out.println("Declared 2D array " + arrayName + "[" + arraySize1 + "][" + arraySize2 + "]");
			      } else {
			        // 1D array  
			        arrayId.arrayValues = new Object[arraySize1];
			        System.out.println("Declared 1D array " + arrayName + "[" + arraySize1 + "]");
			      }
			      
			      addVariable(arrayId);
			      // Note: Assembly generation for arrays will be added to addSymbolsToData method
			    
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			String leftReg = "ft0"; String rightReg = "ft1";
			setState(212);
			((ConditionContext)_localctx).left = expr(leftReg);
			setState(213);
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
			setState(214);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterOperators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitOperators(this);
		}
	}

	public final OperatorsContext operators() throws RecognitionException {
		OperatorsContext _localctx = new OperatorsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_operators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterConditionals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitConditionals(this);
		}
	}

	public final ConditionalsContext conditionals() throws RecognitionException {
		ConditionalsContext _localctx = new ConditionalsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_conditionals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).enterComp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EmoticonListener ) ((EmoticonListener)listener).exitComp(this);
		}
	}

	public final CompContext comp() throws RecognitionException {
		CompContext _localctx = new CompContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_comp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
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
		"\u0004\u0001(\u00e0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0005\u0000\'\b\u0000\n\u0000\f\u0000*\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001>\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"E\b\u0002\n\u0002\f\u0002H\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003U\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003b\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004k\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005u\b\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0081\b\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0005\u0006\u0089\b\u0006\n\u0006\f\u0006\u008c\t\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0094"+
		"\b\u0007\n\u0007\f\u0007\u0097\t\u0007\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\b\u00a7\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\t\u00b1\b\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00bc\b\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0003\f\u00d0\b\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0000\u0000\u0011\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \u0000\u0005"+
		"\u0001\u0000\u0011\u0012\u0001\u0000\u0013\u0015\u0002\u0000\u0016\u0019"+
		"&\'\u0001\u0000\u0011\u0014\u0001\u0000\u0016\u0019\u00e3\u0000\"\u0001"+
		"\u0000\u0000\u0000\u0002=\u0001\u0000\u0000\u0000\u0004?\u0001\u0000\u0000"+
		"\u0000\u0006a\u0001\u0000\u0000\u0000\bj\u0001\u0000\u0000\u0000\n\u0080"+
		"\u0001\u0000\u0000\u0000\f\u0082\u0001\u0000\u0000\u0000\u000e\u008d\u0001"+
		"\u0000\u0000\u0000\u0010\u00a6\u0001\u0000\u0000\u0000\u0012\u00a8\u0001"+
		"\u0000\u0000\u0000\u0014\u00b4\u0001\u0000\u0000\u0000\u0016\u00bf\u0001"+
		"\u0000\u0000\u0000\u0018\u00c6\u0001\u0000\u0000\u0000\u001a\u00d3\u0001"+
		"\u0000\u0000\u0000\u001c\u00d9\u0001\u0000\u0000\u0000\u001e\u00db\u0001"+
		"\u0000\u0000\u0000 \u00dd\u0001\u0000\u0000\u0000\"(\u0006\u0000\uffff"+
		"\uffff\u0000#$\u0003\u0002\u0001\u0000$%\u0006\u0000\uffff\uffff\u0000"+
		"%\'\u0001\u0000\u0000\u0000&#\u0001\u0000\u0000\u0000\'*\u0001\u0000\u0000"+
		"\u0000(&\u0001\u0000\u0000\u0000()\u0001\u0000\u0000\u0000)+\u0001\u0000"+
		"\u0000\u0000*(\u0001\u0000\u0000\u0000+,\u0005\u0000\u0000\u0001,-\u0006"+
		"\u0000\uffff\uffff\u0000-\u0001\u0001\u0000\u0000\u0000./\u0003\u0006"+
		"\u0003\u0000/0\u0006\u0001\uffff\uffff\u00000>\u0001\u0000\u0000\u0000"+
		"12\u0003\n\u0005\u000023\u0006\u0001\uffff\uffff\u00003>\u0001\u0000\u0000"+
		"\u000045\u0003\u0014\n\u000056\u0006\u0001\uffff\uffff\u00006>\u0001\u0000"+
		"\u0000\u000078\u0003\u0016\u000b\u000089\u0006\u0001\uffff\uffff\u0000"+
		"9>\u0001\u0000\u0000\u0000:;\u0003\u0018\f\u0000;<\u0006\u0001\uffff\uffff"+
		"\u0000<>\u0001\u0000\u0000\u0000=.\u0001\u0000\u0000\u0000=1\u0001\u0000"+
		"\u0000\u0000=4\u0001\u0000\u0000\u0000=7\u0001\u0000\u0000\u0000=:\u0001"+
		"\u0000\u0000\u0000>\u0003\u0001\u0000\u0000\u0000?@\u0005\u000b\u0000"+
		"\u0000@F\u0006\u0002\uffff\uffff\u0000AB\u0003\u0002\u0001\u0000BC\u0006"+
		"\u0002\uffff\uffff\u0000CE\u0001\u0000\u0000\u0000DA\u0001\u0000\u0000"+
		"\u0000EH\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000"+
		"\u0000\u0000GI\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000IJ\u0005"+
		"\f\u0000\u0000J\u0005\u0001\u0000\u0000\u0000KL\u0006\u0003\uffff\uffff"+
		"\u0000LM\u0005\u0010\u0000\u0000MN\u0005\u001a\u0000\u0000NO\u0003\f\u0006"+
		"\u0000OT\u0005\u001b\u0000\u0000PQ\u0005\u001a\u0000\u0000QR\u0003\f\u0006"+
		"\u0000RS\u0005\u001b\u0000\u0000SU\u0001\u0000\u0000\u0000TP\u0001\u0000"+
		"\u0000\u0000TU\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VW\u0005"+
		"(\u0000\u0000WX\u0003\b\u0004\u0000XY\u0006\u0003\uffff\uffff\u0000Yb"+
		"\u0001\u0000\u0000\u0000Z[\u0006\u0003\uffff\uffff\u0000[\\\u0005\u0010"+
		"\u0000\u0000\\]\u0006\u0003\uffff\uffff\u0000]^\u0005(\u0000\u0000^_\u0003"+
		"\b\u0004\u0000_`\u0006\u0003\uffff\uffff\u0000`b\u0001\u0000\u0000\u0000"+
		"aK\u0001\u0000\u0000\u0000aZ\u0001\u0000\u0000\u0000b\u0007\u0001\u0000"+
		"\u0000\u0000cd\u0003\f\u0006\u0000de\u0006\u0004\uffff\uffff\u0000ek\u0001"+
		"\u0000\u0000\u0000fg\u0005\u0001\u0000\u0000gk\u0006\u0004\uffff\uffff"+
		"\u0000hi\u0005\u001f\u0000\u0000ik\u0006\u0004\uffff\uffff\u0000jc\u0001"+
		"\u0000\u0000\u0000jf\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000"+
		"k\t\u0001\u0000\u0000\u0000lm\u0006\u0005\uffff\uffff\u0000mn\u0005\u0002"+
		"\u0000\u0000nt\u0005!\u0000\u0000op\u0003\f\u0006\u0000pq\u0006\u0005"+
		"\uffff\uffff\u0000qu\u0001\u0000\u0000\u0000rs\u0005\u001f\u0000\u0000"+
		"su\u0006\u0005\uffff\uffff\u0000to\u0001\u0000\u0000\u0000tr\u0001\u0000"+
		"\u0000\u0000uv\u0001\u0000\u0000\u0000v\u0081\u0005\"\u0000\u0000wx\u0006"+
		"\u0005\uffff\uffff\u0000xy\u0005\u0002\u0000\u0000yz\u0005!\u0000\u0000"+
		"z{\u0005\u001f\u0000\u0000{|\u0005#\u0000\u0000|}\u0003\f\u0006\u0000"+
		"}~\u0005\"\u0000\u0000~\u007f\u0006\u0005\uffff\uffff\u0000\u007f\u0081"+
		"\u0001\u0000\u0000\u0000\u0080l\u0001\u0000\u0000\u0000\u0080w\u0001\u0000"+
		"\u0000\u0000\u0081\u000b\u0001\u0000\u0000\u0000\u0082\u0083\u0003\u000e"+
		"\u0007\u0000\u0083\u008a\u0006\u0006\uffff\uffff\u0000\u0084\u0085\u0007"+
		"\u0000\u0000\u0000\u0085\u0086\u0003\u000e\u0007\u0000\u0086\u0087\u0006"+
		"\u0006\uffff\uffff\u0000\u0087\u0089\u0001\u0000\u0000\u0000\u0088\u0084"+
		"\u0001\u0000\u0000\u0000\u0089\u008c\u0001\u0000\u0000\u0000\u008a\u0088"+
		"\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\r\u0001"+
		"\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008d\u008e\u0003"+
		"\u0010\b\u0000\u008e\u0095\u0006\u0007\uffff\uffff\u0000\u008f\u0090\u0007"+
		"\u0001\u0000\u0000\u0090\u0091\u0003\u0010\b\u0000\u0091\u0092\u0006\u0007"+
		"\uffff\uffff\u0000\u0092\u0094\u0001\u0000\u0000\u0000\u0093\u008f\u0001"+
		"\u0000\u0000\u0000\u0094\u0097\u0001\u0000\u0000\u0000\u0095\u0093\u0001"+
		"\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u000f\u0001"+
		"\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0098\u0099\u0005"+
		"\u001c\u0000\u0000\u0099\u00a7\u0006\b\uffff\uffff\u0000\u009a\u009b\u0005"+
		"\u001d\u0000\u0000\u009b\u00a7\u0006\b\uffff\uffff\u0000\u009c\u009d\u0003"+
		"\u0012\t\u0000\u009d\u009e\u0006\b\uffff\uffff\u0000\u009e\u00a7\u0001"+
		"\u0000\u0000\u0000\u009f\u00a0\u0005\u0010\u0000\u0000\u00a0\u00a7\u0006"+
		"\b\uffff\uffff\u0000\u00a1\u00a2\u0005!\u0000\u0000\u00a2\u00a3\u0003"+
		"\f\u0006\u0000\u00a3\u00a4\u0005\"\u0000\u0000\u00a4\u00a5\u0006\b\uffff"+
		"\uffff\u0000\u00a5\u00a7\u0001\u0000\u0000\u0000\u00a6\u0098\u0001\u0000"+
		"\u0000\u0000\u00a6\u009a\u0001\u0000\u0000\u0000\u00a6\u009c\u0001\u0000"+
		"\u0000\u0000\u00a6\u009f\u0001\u0000\u0000\u0000\u00a6\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a7\u0011\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005\u0010"+
		"\u0000\u0000\u00a9\u00aa\u0005\u001a\u0000\u0000\u00aa\u00ab\u0003\f\u0006"+
		"\u0000\u00ab\u00b0\u0005\u001b\u0000\u0000\u00ac\u00ad\u0005\u001a\u0000"+
		"\u0000\u00ad\u00ae\u0003\f\u0006\u0000\u00ae\u00af\u0005\u001b\u0000\u0000"+
		"\u00af\u00b1\u0001\u0000\u0000\u0000\u00b0\u00ac\u0001\u0000\u0000\u0000"+
		"\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b3\u0006\t\uffff\uffff\u0000\u00b3\u0013\u0001\u0000\u0000\u0000"+
		"\u00b4\u00b5\u0005\u0003\u0000\u0000\u00b5\u00b6\u0005!\u0000\u0000\u00b6"+
		"\u00b7\u0003\u001a\r\u0000\u00b7\u00b8\u0005\"\u0000\u0000\u00b8\u00bb"+
		"\u0003\u0004\u0002\u0000\u00b9\u00ba\u0005\u0004\u0000\u0000\u00ba\u00bc"+
		"\u0003\u0004\u0002\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bb\u00bc"+
		"\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u00be"+
		"\u0006\n\uffff\uffff\u0000\u00be\u0015\u0001\u0000\u0000\u0000\u00bf\u00c0"+
		"\u0005\u0007\u0000\u0000\u00c0\u00c1\u0005!\u0000\u0000\u00c1\u00c2\u0003"+
		"\u001a\r\u0000\u00c2\u00c3\u0005\"\u0000\u0000\u00c3\u00c4\u0003\u0004"+
		"\u0002\u0000\u00c4\u00c5\u0006\u000b\uffff\uffff\u0000\u00c5\u0017\u0001"+
		"\u0000\u0000\u0000\u00c6\u00c7\u0005\n\u0000\u0000\u00c7\u00c8\u0005\u0010"+
		"\u0000\u0000\u00c8\u00c9\u0005(\u0000\u0000\u00c9\u00ca\u0005\u001a\u0000"+
		"\u0000\u00ca\u00cb\u0005\u001c\u0000\u0000\u00cb\u00cf\u0005\u001b\u0000"+
		"\u0000\u00cc\u00cd\u0005\u001a\u0000\u0000\u00cd\u00ce\u0005\u001c\u0000"+
		"\u0000\u00ce\u00d0\u0005\u001b\u0000\u0000\u00cf\u00cc\u0001\u0000\u0000"+
		"\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000"+
		"\u0000\u00d1\u00d2\u0006\f\uffff\uffff\u0000\u00d2\u0019\u0001\u0000\u0000"+
		"\u0000\u00d3\u00d4\u0006\r\uffff\uffff\u0000\u00d4\u00d5\u0003\f\u0006"+
		"\u0000\u00d5\u00d6\u0007\u0002\u0000\u0000\u00d6\u00d7\u0003\f\u0006\u0000"+
		"\u00d7\u00d8\u0006\r\uffff\uffff\u0000\u00d8\u001b\u0001\u0000\u0000\u0000"+
		"\u00d9\u00da\u0007\u0003\u0000\u0000\u00da\u001d\u0001\u0000\u0000\u0000"+
		"\u00db\u00dc\u0007\u0004\u0000\u0000\u00dc\u001f\u0001\u0000\u0000\u0000"+
		"\u00dd\u00de\u0005&\u0000\u0000\u00de!\u0001\u0000\u0000\u0000\u000e("+
		"=FTajt\u0080\u008a\u0095\u00a6\u00b0\u00bb\u00cf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}