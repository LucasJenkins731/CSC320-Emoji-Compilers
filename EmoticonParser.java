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
		T__0=1, KW_READ=2, KW_PRINT=3, KW_IF=4, KW_ELSE=5, KW_ELSE_IF=6, KW_FOR=7, 
		KW_WHILE=8, KW_RETURN=9, KW_FUNCTION=10, KW_ARRAY=11, LBRACE=12, RBRACE=13, 
		KW_INT=14, KW_STRING=15, KW_CHAR=16, IDENT=17, ADD=18, SUBTRACT=19, MULTIPLY=20, 
		DIVIDE=21, MODULO=22, GREATERTHAN=23, LESSTHAN=24, GREATERTHANOREQUALTO=25, 
		LESSTHANOREQUALTO=26, LBRACKET=27, RBRACKET=28, INT=29, FLOAT=30, CHAR=31, 
		STRING=32, WS=33, LPAREN=34, RPAREN=35, COMMA=36, COMMENT=37, COMMENT_BLOCK=38, 
		COMPARISON=39, NOTEQUAL=40, ASSIGNMENT=41;
	public static final int
		RULE_program = 0, RULE_s = 1, RULE_returnstmt = 2, RULE_functionstmt = 3, 
		RULE_paramList = 4, RULE_argList = 5, RULE_blockStatement = 6, RULE_as = 7, 
		RULE_rhs = 8, RULE_ps = 9, RULE_expr = 10, RULE_term = 11, RULE_factor = 12, 
		RULE_functioncall = 13, RULE_arrayAccess = 14, RULE_ifstmt = 15, RULE_elseifclause = 16, 
		RULE_whilestmt = 17, RULE_arraystmt = 18, RULE_condition = 19, RULE_operators = 20, 
		RULE_conditionals = 21, RULE_comp = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "s", "returnstmt", "functionstmt", "paramList", "argList", 
			"blockStatement", "as", "rhs", "ps", "expr", "term", "factor", "functioncall", 
			"arrayAccess", "ifstmt", "elseifclause", "whilestmt", "arraystmt", "condition", 
			"operators", "conditionals", "comp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'()'", "'-0-0-'", "':P'", "':)'", "':('", "':|'", "'>:('", "'D:<'", 
			"'return'", "'=^._.^='", "'(o_o)'", "'><(((,^>'", "'<^,)))><'", "'int'", 
			"'string'", "'char'", null, "':+)'", "':-)'", "':*)'", "':/)'", "':%)'", 
			"':>)'", "':<)'", "':>=)'", "':<=)'", "'['", "']'", null, null, null, 
			null, null, "'('", "')'", "','", null, null, "':==)'", "':!=)'", "':=)'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "KW_READ", "KW_PRINT", "KW_IF", "KW_ELSE", "KW_ELSE_IF", 
			"KW_FOR", "KW_WHILE", "KW_RETURN", "KW_FUNCTION", "KW_ARRAY", "LBRACE", 
			"RBRACE", "KW_INT", "KW_STRING", "KW_CHAR", "IDENT", "ADD", "SUBTRACT", 
			"MULTIPLY", "DIVIDE", "MODULO", "GREATERTHAN", "LESSTHAN", "GREATERTHANOREQUALTO", 
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
	    
	    //Stack allocation for function variables

	  }

	  class SymbolTable {
	    Map<String, Identifier> table = new HashMap<>();
	  }
	  
	  class FunctionDef {
	    String name;
	    String paramName;  // Keep for backward compatibility
	    Type paramType;    // Keep for backward compatibility
	    List<String> paramNames;  // New: multiple parameter names
	    List<Type> paramTypes;    // New: multiple parameter types
	    Type returnType;
	    ParserRuleContext body;
	    String javaCode;
	    boolean hasReturn;
	    
	    // Constructor to initialize lists
	    public FunctionDef() {
	      paramNames = new ArrayList<>();
	      paramTypes = new ArrayList<>();
	    }
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
	  StringBuilder func_sb = new StringBuilder();  // For function definitions
	  int data_count = 0;
	  StringBuilder asm = new StringBuilder();
	  
	  // Stack management for function local variables

	  boolean inFunction = false;  // Track if we're inside a function


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
	  void func_emit(String s) { emit(func_sb, s); }

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
	    text_emit("    .globl main");
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
	    // Store to global memory (original behavior)
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
	  // Generate function call assembly code
	  StringBuilder generateFunctionCall(String funcName, String resultRegister) {
	    StringBuilder code = new StringBuilder();
	    emit(code, "    # Call function " + funcName);
	    emit(code, "    jal   FUNC_" + funcName);  // Jump and link to function
	    if (!resultRegister.equals("fa0")) {
	      // Move return value from fa0 to desired register
	      emit(code, "    fmv.d " + resultRegister + ", fa0");
	    }
	    return code;
	  }

	  // ASSEMBLY  
	  // Generate function return assembly code
	  StringBuilder generateFunctionReturn(StringBuilder valueCode) {
	    StringBuilder code = new StringBuilder();
	    if (valueCode != null) {
	      code.append(valueCode);  // Generate code to put return value in fa0
	    }
	    emit(code, "    # Return from function");
	    emit(code, "    ret");  // Return to caller
	    return code;
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EmoticonVisitor ) return ((EmoticonVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
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
			    
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 134936L) != 0)) {
				{
				{
				setState(47);
				((ProgramContext)_localctx).s = s();

				      text_sb.append(((ProgramContext)_localctx).s.code);
				    
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
			        // Successful, so write out the generated code
			        closeProgram();
			        writeFile();     
			        //System.err.println("Success");
			        
			        // // Generate function definitions
			        // for (FunctionDef func : functions.values()) {
			        //   if (func.javaCode != null) {
			        //     generateFunctionDefinition(func);
			        //   }
			        asm.append(data_sb.toString());
			        asm.append(text_sb.toString());
			        asm.append(func_sb.toString());

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
		public ReturnstmtContext returnstmt;
		public FunctionstmtContext functionstmt;
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
		public ReturnstmtContext returnstmt() {
			return getRuleContext(ReturnstmtContext.class,0);
		}
		public FunctionstmtContext functionstmt() {
			return getRuleContext(FunctionstmtContext.class,0);
		}
		public SContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_s; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EmoticonVisitor ) return ((EmoticonVisitor<? extends T>)visitor).visitS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_s);
		try {
			setState(79);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				((SContext)_localctx).as = as();
				((SContext)_localctx).code =  ((SContext)_localctx).as.code;
				}
				break;
			case KW_PRINT:
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				((SContext)_localctx).ps = ps();
				((SContext)_localctx).code =  ((SContext)_localctx).ps.code;
				}
				break;
			case KW_IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				((SContext)_localctx).ifstmt = ifstmt();
				((SContext)_localctx).code =  ((SContext)_localctx).ifstmt.code;
				}
				break;
			case KW_WHILE:
				enterOuterAlt(_localctx, 4);
				{
				setState(67);
				((SContext)_localctx).whilestmt = whilestmt();
				((SContext)_localctx).code =  ((SContext)_localctx).whilestmt.code;
				}
				break;
			case KW_ARRAY:
				enterOuterAlt(_localctx, 5);
				{
				setState(70);
				((SContext)_localctx).arraystmt = arraystmt();
				((SContext)_localctx).code =  ((SContext)_localctx).arraystmt.code;
				}
				break;
			case KW_RETURN:
				enterOuterAlt(_localctx, 6);
				{
				setState(73);
				((SContext)_localctx).returnstmt = returnstmt();
				((SContext)_localctx).code =  ((SContext)_localctx).returnstmt.code;
				}
				break;
			case KW_FUNCTION:
				enterOuterAlt(_localctx, 7);
				{
				setState(76);
				((SContext)_localctx).functionstmt = functionstmt();
				((SContext)_localctx).code =  ((SContext)_localctx).functionstmt.code;
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
	public static class ReturnstmtContext extends ParserRuleContext {
		public StringBuilder code;
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EmoticonVisitor ) return ((EmoticonVisitor<? extends T>)visitor).visitReturnstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnstmtContext returnstmt() throws RecognitionException {
		ReturnstmtContext _localctx = new ReturnstmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_returnstmt);
		try {
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				((ReturnstmtContext)_localctx).KW_RETURN = match(KW_RETURN);
				setState(82);
				((ReturnstmtContext)_localctx).expr = expr("fa0");

				      if (!definingFunction) {
				        error(((ReturnstmtContext)_localctx).KW_RETURN, "return statement outside function");
				        ((ReturnstmtContext)_localctx).code =  new StringBuilder();
				      } else {
				        ((ReturnstmtContext)_localctx).code =  new StringBuilder();
				        // Generate code to evaluate return expression (result in fa0)
				        _localctx.code.append(((ReturnstmtContext)_localctx).expr.code);
				        // Generate return instruction
				        _localctx.code.append(generateFunctionReturn(null));
				        System.out.println("Generated return statement with value");
				      }
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				((ReturnstmtContext)_localctx).KW_RETURN = match(KW_RETURN);

				      if (!definingFunction) {
				        error(((ReturnstmtContext)_localctx).KW_RETURN, "return statement outside function");
				        ((ReturnstmtContext)_localctx).code =  new StringBuilder();
				      } else {
				        ((ReturnstmtContext)_localctx).code =  new StringBuilder();
				        // Generate return instruction (no return value)
				        _localctx.code.append(generateFunctionReturn(null));
				        System.out.println("Generated return statement without value");
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
		public StringBuilder code;
		public Token name;
		public Token param;
		public BlockStatementContext body;
		public ParamListContext paramList;
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
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public FunctionstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionstmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EmoticonVisitor ) return ((EmoticonVisitor<? extends T>)visitor).visitFunctionstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionstmtContext functionstmt() throws RecognitionException {
		FunctionstmtContext _localctx = new FunctionstmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionstmt);
		try {
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				match(KW_FUNCTION);
				setState(90);
				((FunctionstmtContext)_localctx).name = match(IDENT);
				setState(91);
				match(LPAREN);
				setState(92);
				((FunctionstmtContext)_localctx).param = match(IDENT);
				setState(93);
				match(RPAREN);

				      definingFunction = true;
				      functionDefDepth = 0;
				      FunctionDef func = new FunctionDef();
				      func.name = ((FunctionstmtContext)_localctx).name.getText();
				      func.paramName = ((FunctionstmtContext)_localctx).param.getText();
				      functions.put(func.name, func);
				      currentFunction = func;
				      
				      // Generate function label and parameter setup
				      func_emit("FUNC_" + func.name + ":");
				      func_emit("    # Function " + func.name + " with parameter " + func.paramName);
				      
				      if (func.paramName != null) {
				        // Add parameter to data section (original working approach)
				        String paramLabel = "PARAM_" + func.name + "_" + func.paramName;
				        data_emit(paramLabel + ":    .double 0.0");
				        // Store parameter value (passed in fa0)
				        func_emit("    la    t0, " + paramLabel);
				        func_emit("    fsd   fa0, (t0)");
				      }
				      
				      System.out.println("Defining function '" + func.name + "' with parameter '" + func.paramName + "'");
				    
				setState(95);
				((FunctionstmtContext)_localctx).body = blockStatement();

				      definingFunction = false;
				      functionDefDepth = 0;
				      currentFunction = null;
				      FunctionDef funcDef = functions.get(((FunctionstmtContext)_localctx).name.getText());
				      funcDef.body = ((FunctionstmtContext)_localctx).body;
				      
				      ((FunctionstmtContext)_localctx).code =  new StringBuilder();
				      // Generate function body assembly
				      func_sb.append(((FunctionstmtContext)_localctx).body.code.toString());
				      
				      // Add default return if no explicit return
				      func_emit("    # Default return (0.0)");
				      func_emit("    li    t0, 0");
				      func_emit("    fcvt.d.w fa0, t0");
				      func_emit("    ret");
				      
				      System.out.println("Function '" + funcDef.name + "' defined");
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				match(KW_FUNCTION);
				setState(99);
				((FunctionstmtContext)_localctx).name = match(IDENT);
				setState(100);
				match(T__0);

				      definingFunction = true;
				      functionDefDepth = 0;
				      FunctionDef func2 = new FunctionDef();
				      func2.name = ((FunctionstmtContext)_localctx).name.getText();
				      func2.paramName = null;
				      functions.put(func2.name, func2);
				      currentFunction = func2;
				      
				      // Generate function label
				      func_emit("FUNC_" + func2.name + ":");
				      func_emit("    # Function " + func2.name + " (no parameters)");
				      
				      System.out.println("Defining function '" + func2.name + "'");
				    
				setState(102);
				((FunctionstmtContext)_localctx).body = blockStatement();

				      definingFunction = false;
				      functionDefDepth = 0;
				      currentFunction = null;
				      FunctionDef funcDef2 = functions.get(((FunctionstmtContext)_localctx).name.getText());
				      funcDef2.body = ((FunctionstmtContext)_localctx).body;
				      
				      ((FunctionstmtContext)_localctx).code =  new StringBuilder();
				      // Generate function body assembly
				      func_sb.append(((FunctionstmtContext)_localctx).body.code.toString());
				      
				      // Add default return if no explicit return
				      func_emit("    # Default return (0.0)");
				      func_emit("    li    t0, 0");
				      func_emit("    fcvt.d.w fa0, t0");
				      func_emit("    ret");
				      
				      System.out.println("Function '" + funcDef2.name + "' defined");
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(105);
				match(KW_FUNCTION);
				setState(106);
				((FunctionstmtContext)_localctx).name = match(IDENT);
				setState(107);
				match(LPAREN);
				setState(108);
				((FunctionstmtContext)_localctx).paramList = paramList();
				setState(109);
				match(RPAREN);

				      definingFunction = true;
				      functionDefDepth = 0;
				      FunctionDef func = new FunctionDef();
				      func.name = ((FunctionstmtContext)_localctx).name.getText();
				      
				      // Copy parameters from paramList
				      for (String param : ((FunctionstmtContext)_localctx).paramList.params) {
				        func.paramNames.add(param);
				        func.paramTypes.add(Type.FLOAT); // Default to FLOAT for now
				      }
				      
				      functions.put(func.name, func);
				      currentFunction = func;
				      
				      // Generate function label and parameter setup
				      func_emit("FUNC_" + func.name + ":");
				      func_emit("    # Function " + func.name + " with " + func.paramNames.size() + " parameters");
				      
				      // Store parameters (first few in fa0, fa1, fa2, fa3, rest on stack)
				      for (int i = 0; i < func.paramNames.size(); i++) {
				        String paramName = func.paramNames.get(i);
				        String paramLabel = "PARAM_" + func.name + "_" + paramName;
				        data_emit(paramLabel + ":    .double 0.0");
				        
				        if (i == 0) {
				          func_emit("    la    t0, " + paramLabel);
				          func_emit("    fsd   fa0, (t0)");
				        } else if (i == 1) {
				          func_emit("    la    t0, " + paramLabel);
				          func_emit("    fsd   fa1, (t0)");
				        } else if (i == 2) {
				          func_emit("    la    t0, " + paramLabel);
				          func_emit("    fsd   fa2, (t0)");
				        } else if (i == 3) {
				          func_emit("    la    t0, " + paramLabel);
				          func_emit("    fsd   fa3, (t0)");
				        } else {
				          // For more than 4 parameters, use stack (advanced feature)
				          func_emit("    # TODO: Handle parameter " + paramName + " from stack");
				        }
				      }
				      
				      System.out.println("Defining function '" + func.name + "' with " + func.paramNames.size() + " parameters");
				    
				setState(111);
				((FunctionstmtContext)_localctx).body = blockStatement();

				      definingFunction = false;
				      functionDefDepth = 0;
				      currentFunction = null;
				      FunctionDef funcDef = functions.get(((FunctionstmtContext)_localctx).name.getText());
				      funcDef.body = ((FunctionstmtContext)_localctx).body;
				      
				      ((FunctionstmtContext)_localctx).code =  new StringBuilder();
				      // Generate function body assembly
				      func_sb.append(((FunctionstmtContext)_localctx).body.code.toString());
				      
				      // Add default return if no explicit return
				      func_emit("    # Default return (0.0)");
				      func_emit("    li    t0, 0");
				      func_emit("    fcvt.d.w fa0, t0");
				      func_emit("    ret");
				      
				      System.out.println("Function '" + funcDef.name + "' defined");
				    
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
	public static class ParamListContext extends ParserRuleContext {
		public List<String> params;
		public Token first;
		public Token rest;
		public List<TerminalNode> IDENT() { return getTokens(EmoticonParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(EmoticonParser.IDENT, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(EmoticonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(EmoticonParser.COMMA, i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EmoticonVisitor ) return ((EmoticonVisitor<? extends T>)visitor).visitParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ParamListContext)_localctx).params =  new ArrayList<>();
			setState(117);
			((ParamListContext)_localctx).first = match(IDENT);
			_localctx.params.add(((ParamListContext)_localctx).first.getText());
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(119);
				match(COMMA);
				setState(120);
				((ParamListContext)_localctx).rest = match(IDENT);
				_localctx.params.add(((ParamListContext)_localctx).rest.getText());
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
	public static class ArgListContext extends ParserRuleContext {
		public List<StringBuilder> args;
		public ExprContext first;
		public ExprContext rest;
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
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EmoticonVisitor ) return ((EmoticonVisitor<? extends T>)visitor).visitArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ArgListContext)_localctx).args =  new ArrayList<>();
			setState(128);
			((ArgListContext)_localctx).first = expr("fa0");
			_localctx.args.add(((ArgListContext)_localctx).first.code);
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(130);
				match(COMMA);
				setState(131);
				((ArgListContext)_localctx).rest = expr("fa0");
				_localctx.args.add(((ArgListContext)_localctx).rest.code);
				}
				}
				setState(138);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EmoticonVisitor ) return ((EmoticonVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_blockStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(LBRACE);

			      ((BlockStatementContext)_localctx).code =  new StringBuilder();
			    
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 134936L) != 0)) {
				{
				{
				setState(141);
				((BlockStatementContext)_localctx).stmt = s();

				      _localctx.code.append(((BlockStatementContext)_localctx).stmt.code);
				    
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(149);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EmoticonVisitor ) return ((EmoticonVisitor<? extends T>)visitor).visitAs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsContext as() throws RecognitionException {
		AsContext _localctx = new AsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_as);
		int _la;
		try {
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				String register = "fa0";
				setState(152);
				((AsContext)_localctx).IDENT = match(IDENT);
				setState(153);
				match(LBRACKET);
				setState(154);
				((AsContext)_localctx).index1 = expr("ft2");
				setState(155);
				match(RBRACKET);
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(156);
					match(LBRACKET);
					setState(157);
					((AsContext)_localctx).index2 = expr("ft3");
					setState(158);
					match(RBRACKET);
					}
				}

				setState(162);
				match(ASSIGNMENT);
				setState(163);
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
				setState(167);
				((AsContext)_localctx).IDENT = match(IDENT);

				      String id = ((AsContext)_localctx).IDENT.getText();
				      Identifier var = lookupVariable(id);
				      //System.out.println(var);
				    
				setState(169);
				match(ASSIGNMENT);
				setState(170);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EmoticonVisitor ) return ((EmoticonVisitor<? extends T>)visitor).visitRhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RhsContext rhs(String register) throws RecognitionException {
		RhsContext _localctx = new RhsContext(_ctx, getState(), register);
		enterRule(_localctx, 16, RULE_rhs);
		try {
			setState(182);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
			case INT:
			case FLOAT:
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				((RhsContext)_localctx).expr = expr(_localctx.register);
				((RhsContext)_localctx).code =  ((RhsContext)_localctx).expr.code;
				}
				break;
			case KW_READ:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				match(KW_READ);

				    ((RhsContext)_localctx).code =  new StringBuilder();
				    generateReadDouble(_localctx.code, _localctx.register);
				  
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(180);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EmoticonVisitor ) return ((EmoticonVisitor<? extends T>)visitor).visitPs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PsContext ps() throws RecognitionException {
		PsContext _localctx = new PsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ps);
		try {
			setState(204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				String register = "fa0";
				setState(185);
				match(KW_PRINT);
				setState(186);
				match(LPAREN);
				setState(192);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IDENT:
				case INT:
				case FLOAT:
				case LPAREN:
					{
					setState(187);
					((PsContext)_localctx).expr = expr(register);

					        ((PsContext)_localctx).code =  ((PsContext)_localctx).expr.code;
					        generatePrintDouble(_localctx.code, register);
					      
					}
					break;
				case STRING:
					{
					setState(190);
					((PsContext)_localctx).STRING = match(STRING);

					        ((PsContext)_localctx).code =  new StringBuilder();
					        generatePrintStringConstant(_localctx.code, ((PsContext)_localctx).STRING.getText());
					      
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(194);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				String register = "fa0";
				setState(196);
				match(KW_PRINT);
				setState(197);
				match(LPAREN);
				setState(198);
				((PsContext)_localctx).STRING = match(STRING);
				setState(199);
				match(COMMA);
				setState(200);
				((PsContext)_localctx).expr = expr(register);
				setState(201);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EmoticonVisitor ) return ((EmoticonVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr(String register) throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState(), register);
		enterRule(_localctx, 20, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			((ExprContext)_localctx).a = term(_localctx.register);

			    ((ExprContext)_localctx).code =  ((ExprContext)_localctx).a.code;
			    String nextRegister = (_localctx.register.equals("ft0")) ? "ft1" : "ft0";
			  
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==SUBTRACT) {
				{
				{
				setState(208);
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
				setState(209);
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
				setState(216);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EmoticonVisitor ) return ((EmoticonVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term(String register) throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState(), register);
		enterRule(_localctx, 22, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			((TermContext)_localctx).a = factor(_localctx.register);

			      ((TermContext)_localctx).code =  ((TermContext)_localctx).a.code;
			      String nextRegister = (_localctx.register.equals("ft0")) ? "ft1" : "ft0";
			    
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 7340032L) != 0)) {
				{
				{
				setState(219);
				((TermContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7340032L) != 0)) ) {
					((TermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(220);
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
				setState(227);
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
		public FunctioncallContext functioncall;
		public Token IDENT;
		public ExprContext expr;
		public TerminalNode INT() { return getToken(EmoticonParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(EmoticonParser.FLOAT, 0); }
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
		public FactorContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public FactorContext(ParserRuleContext parent, int invokingState, String register) {
			super(parent, invokingState);
			this.register = register;
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EmoticonVisitor ) return ((EmoticonVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor(String register) throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState(), register);
		enterRule(_localctx, 24, RULE_factor);
		try {
			setState(245);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(228);
				((FactorContext)_localctx).INT = match(INT);

				      int value = Integer.parseInt(((FactorContext)_localctx).INT.getText());
				      ((FactorContext)_localctx).code =  generateDoubleConstant(_localctx.register, (double) value);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(230);
				((FactorContext)_localctx).FLOAT = match(FLOAT);

				      double value = Double.parseDouble(((FactorContext)_localctx).FLOAT.getText());
				      ((FactorContext)_localctx).code =  generateDoubleConstant(_localctx.register, value);
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(232);
				((FactorContext)_localctx).arrayAccess = arrayAccess(_localctx.register);

				      ((FactorContext)_localctx).code =  ((FactorContext)_localctx).arrayAccess.code;
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(235);
				((FactorContext)_localctx).functioncall = functioncall(_localctx.register);

				      ((FactorContext)_localctx).code =  ((FactorContext)_localctx).functioncall.code;
				    
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(238);
				((FactorContext)_localctx).IDENT = match(IDENT);

				      //find if id has been used before
				      String id = ((FactorContext)_localctx).IDENT.getText();
				      Identifier var = lookupVariable(id);
				      
				      // Check if this is a function parameter inside a function
				      boolean isParameter = false;
				      if (definingFunction && var == null && currentFunction != null) {
				        // Check if this identifier matches the current function's single parameter (backward compatibility)
				        if (currentFunction.paramName != null && currentFunction.paramName.equals(id)) {
				          // Generate code to load parameter from global storage
				          ((FactorContext)_localctx).code =  new StringBuilder();
				          String paramLabel = "PARAM_" + currentFunction.name + "_" + currentFunction.paramName;
				          emit(_localctx.code, "    la    t0, " + paramLabel + "  # Load parameter address");
				          emit(_localctx.code, "    fld   " + _localctx.register + ", (t0)  # Load parameter value");
				          isParameter = true;
				        }
				        // Check if this identifier matches any of the multiparameters
				        else if (!currentFunction.paramNames.isEmpty()) {
				          for (String paramName : currentFunction.paramNames) {
				            if (paramName.equals(id)) {
				              ((FactorContext)_localctx).code =  new StringBuilder();
				              String paramLabel = "PARAM_" + currentFunction.name + "_" + paramName;
				              emit(_localctx.code, "    la    t0, " + paramLabel + "  # Load parameter address");
				              emit(_localctx.code, "    fld   " + _localctx.register + ", (t0)  # Load parameter value");
				              isParameter = true;
				              break;
				            }
				          }
				        }
				      }
				      
				      // Handle regular variables if not a parameter
				      if (!isParameter) {
				        // var used before assignment
				        if(var == null) {
				          error(((FactorContext)_localctx).IDENT, "use of variable '" + id + "' before assignment");
				          ((FactorContext)_localctx).code =  new StringBuilder();
				        } else {
				          var.hasBeenUsed = true;
				          //gen code
				          ((FactorContext)_localctx).code =  generateLoadId(_localctx.register, id);
				        }
				      }
				    
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(240);
				match(LPAREN);
				setState(241);
				((FactorContext)_localctx).expr = expr(_localctx.register);
				setState(242);
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
	public static class FunctioncallContext extends ParserRuleContext {
		public String register;
		public StringBuilder code;
		public Token IDENT;
		public ExprContext arg;
		public ArgListContext argList;
		public TerminalNode IDENT() { return getToken(EmoticonParser.IDENT, 0); }
		public TerminalNode LPAREN() { return getToken(EmoticonParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(EmoticonParser.RPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public FunctioncallContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public FunctioncallContext(ParserRuleContext parent, int invokingState, String register) {
			super(parent, invokingState);
			this.register = register;
		}
		@Override public int getRuleIndex() { return RULE_functioncall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EmoticonVisitor ) return ((EmoticonVisitor<? extends T>)visitor).visitFunctioncall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctioncallContext functioncall(String register) throws RecognitionException {
		FunctioncallContext _localctx = new FunctioncallContext(_ctx, getState(), register);
		enterRule(_localctx, 26, RULE_functioncall);
		try {
			setState(262);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(247);
				((FunctioncallContext)_localctx).IDENT = match(IDENT);
				setState(248);
				match(LPAREN);
				setState(249);
				((FunctioncallContext)_localctx).arg = expr("fa0");
				setState(250);
				match(RPAREN);

				      String funcName = ((FunctioncallContext)_localctx).IDENT.getText();
				      if (!functions.containsKey(funcName)) {
				        error(((FunctioncallContext)_localctx).IDENT, "function '" + funcName + "' not defined");
				        ((FunctioncallContext)_localctx).code =  new StringBuilder();
				      } else {
				        FunctionDef func = functions.get(funcName);
				        if (func.paramName == null && func.paramNames.isEmpty()) {
				          error(((FunctioncallContext)_localctx).IDENT, "function '" + funcName + "' does not expect parameters");
				          ((FunctioncallContext)_localctx).code =  new StringBuilder();
				        } else if (func.paramName == null && func.paramNames.size() != 1) {
				          error(((FunctioncallContext)_localctx).IDENT, "function '" + funcName + "' expects " + func.paramNames.size() + " parameters, not 1");
				          ((FunctioncallContext)_localctx).code =  new StringBuilder();
				        } else {
				          ((FunctioncallContext)_localctx).code =  new StringBuilder();
				          // Generate argument evaluation (puts result in fa0)
				          _localctx.code.append(((FunctioncallContext)_localctx).arg.code);
				          // Call the function
				          _localctx.code.append(generateFunctionCall(funcName, _localctx.register));
				          System.out.println("Generated call to function '" + funcName + "' with parameter");
				        }
				      }
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(253);
				((FunctioncallContext)_localctx).IDENT = match(IDENT);
				setState(254);
				match(T__0);

				      String funcName = ((FunctioncallContext)_localctx).IDENT.getText();
				      if (!functions.containsKey(funcName)) {
				        error(((FunctioncallContext)_localctx).IDENT, "function '" + funcName + "' not defined");
				        ((FunctioncallContext)_localctx).code =  new StringBuilder();
				      } else {
				        FunctionDef func = functions.get(funcName);
				        if (func.paramName != null || !func.paramNames.isEmpty()) {
				          int expectedParams = func.paramName != null ? 1 : func.paramNames.size();
				          error(((FunctioncallContext)_localctx).IDENT, "function '" + funcName + "' expects " + expectedParams + " parameter(s)");
				          ((FunctioncallContext)_localctx).code =  new StringBuilder();
				        } else {
				          ((FunctioncallContext)_localctx).code =  new StringBuilder();
				          // Call the function (no parameters)
				          _localctx.code.append(generateFunctionCall(funcName, _localctx.register));
				          System.out.println("Generated call to function '" + funcName + "' without parameters");
				        }
				      }
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(256);
				((FunctioncallContext)_localctx).IDENT = match(IDENT);
				setState(257);
				match(LPAREN);
				setState(258);
				((FunctioncallContext)_localctx).argList = argList();
				setState(259);
				match(RPAREN);

				      String funcName = ((FunctioncallContext)_localctx).IDENT.getText();
				      if (!functions.containsKey(funcName)) {
				        error(((FunctioncallContext)_localctx).IDENT, "function '" + funcName + "' not defined");
				        ((FunctioncallContext)_localctx).code =  new StringBuilder();
				      } else {
				        FunctionDef func = functions.get(funcName);
				        
				        if (func.paramNames.isEmpty()) {
				          error(((FunctioncallContext)_localctx).IDENT, "function '" + funcName + "' does not expect parameters");
				          ((FunctioncallContext)_localctx).code =  new StringBuilder();
				        } else if (((FunctioncallContext)_localctx).argList.args.size() != func.paramNames.size()) {
				          error(((FunctioncallContext)_localctx).IDENT, "function '" + funcName + "' expects " + func.paramNames.size() + 
				                " parameters but " + ((FunctioncallContext)_localctx).argList.args.size() + " provided");
				          ((FunctioncallContext)_localctx).code =  new StringBuilder();
				        } else {
				          ((FunctioncallContext)_localctx).code =  new StringBuilder();
				          
				          // Generate argument evaluation code
				          for (int i = 0; i < ((FunctioncallContext)_localctx).argList.args.size(); i++) {
				            if (i == 0) {
				              _localctx.code.append(((FunctioncallContext)_localctx).argList.args.get(i)); // Result goes to fa0
				            } else if (i == 1) {
				              // Move fa0 to ft0, evaluate next arg to fa0, then move to fa1
				              _localctx.code.append("    fmv.d ft0, fa0\n");
				              _localctx.code.append(((FunctioncallContext)_localctx).argList.args.get(i));
				              _localctx.code.append("    fmv.d fa1, fa0\n");
				              _localctx.code.append("    fmv.d fa0, ft0\n");
				            } else if (i == 2) {
				              _localctx.code.append("    fmv.d ft1, fa0\n");
				              _localctx.code.append(((FunctioncallContext)_localctx).argList.args.get(i));
				              _localctx.code.append("    fmv.d fa2, fa0\n");
				              _localctx.code.append("    fmv.d fa0, ft1\n");
				            } else if (i == 3) {
				              _localctx.code.append("    fmv.d ft2, fa0\n");
				              _localctx.code.append(((FunctioncallContext)_localctx).argList.args.get(i));
				              _localctx.code.append("    fmv.d fa3, fa0\n");
				              _localctx.code.append("    fmv.d fa0, ft2\n");
				            } else {
				              // For more than 4 parameters, use stack
				              _localctx.code.append("    # TODO: Handle parameter " + i + " via stack\n");
				            }
				          }
				          
				          // Call the function
				          _localctx.code.append(generateFunctionCall(funcName, _localctx.register));
				          System.out.println("Generated call to function '" + funcName + "' with " + 
				                           ((FunctioncallContext)_localctx).argList.args.size() + " parameters");
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EmoticonVisitor ) return ((EmoticonVisitor<? extends T>)visitor).visitArrayAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayAccessContext arrayAccess(String register) throws RecognitionException {
		ArrayAccessContext _localctx = new ArrayAccessContext(_ctx, getState(), register);
		enterRule(_localctx, 28, RULE_arrayAccess);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			((ArrayAccessContext)_localctx).IDENT = match(IDENT);
			setState(265);
			match(LBRACKET);
			setState(266);
			((ArrayAccessContext)_localctx).index1 = expr("ft2");
			setState(267);
			match(RBRACKET);
			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(268);
				match(LBRACKET);
				setState(269);
				((ArrayAccessContext)_localctx).index2 = expr("ft3");
				setState(270);
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
		public List<ElseifclauseContext> elseifclause() {
			return getRuleContexts(ElseifclauseContext.class);
		}
		public ElseifclauseContext elseifclause(int i) {
			return getRuleContext(ElseifclauseContext.class,i);
		}
		public TerminalNode KW_ELSE() { return getToken(EmoticonParser.KW_ELSE, 0); }
		public IfstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EmoticonVisitor ) return ((EmoticonVisitor<? extends T>)visitor).visitIfstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfstmtContext ifstmt() throws RecognitionException {
		IfstmtContext _localctx = new IfstmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ifstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(KW_IF);
			setState(277);
			match(LPAREN);
			setState(278);
			((IfstmtContext)_localctx).condition = condition();
			setState(279);
			match(RPAREN);
			setState(280);
			((IfstmtContext)_localctx).ifbody = blockStatement();
			setState(284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KW_ELSE_IF) {
				{
				{
				setState(281);
				elseifclause();
				}
				}
				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_ELSE) {
				{
				setState(287);
				match(KW_ELSE);
				setState(288);
				((IfstmtContext)_localctx).elsebody = blockStatement();
				}
			}


			      ((IfstmtContext)_localctx).code =  new StringBuilder();
			      
			      // Generate condition evaluation for main if
			      _localctx.code.append(((IfstmtContext)_localctx).condition.code);
			      
			      // Generate labels
			      String nextLabel = generateLabel("ELSEIF_");
			      String endLabel = generateLabel("END_IF_");
			      
			      // Jump to first else-if if main condition is false
			      generateComparison(_localctx.code, ((IfstmtContext)_localctx).condition.leftReg, ((IfstmtContext)_localctx).condition.rightReg, ((IfstmtContext)_localctx).condition.operator, nextLabel);
			      
			      // Main if body
			      _localctx.code.append(((IfstmtContext)_localctx).ifbody.code);
			      emit(_localctx.code, "    j " + endLabel);  // Jump to end after executing if body
			      
			      // For now, skip else-if implementation and just do if-else
			      // This will fix the parsing but else-if logic won't work perfectly yet
			      
			      // Handle final else clause
			      if (((IfstmtContext)_localctx).elsebody != null) {
			        emit(_localctx.code, nextLabel + ":");
			        _localctx.code.append(((IfstmtContext)_localctx).elsebody.code);
			      } else {
			        emit(_localctx.code, nextLabel + ":");
			      }
			      
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
	public static class ElseifclauseContext extends ParserRuleContext {
		public StringBuilder code;
		public BlockStatementContext body;
		public TerminalNode KW_ELSE_IF() { return getToken(EmoticonParser.KW_ELSE_IF, 0); }
		public TerminalNode LPAREN() { return getToken(EmoticonParser.LPAREN, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(EmoticonParser.RPAREN, 0); }
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public ElseifclauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseifclause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EmoticonVisitor ) return ((EmoticonVisitor<? extends T>)visitor).visitElseifclause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseifclauseContext elseifclause() throws RecognitionException {
		ElseifclauseContext _localctx = new ElseifclauseContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_elseifclause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			match(KW_ELSE_IF);
			setState(294);
			match(LPAREN);
			setState(295);
			condition();
			setState(296);
			match(RPAREN);
			setState(297);
			((ElseifclauseContext)_localctx).body = blockStatement();

			      ((ElseifclauseContext)_localctx).code =  new StringBuilder();
			      // For now, just append the body - proper condition handling will be added later
			      _localctx.code.append(((ElseifclauseContext)_localctx).body.code);
			    
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EmoticonVisitor ) return ((EmoticonVisitor<? extends T>)visitor).visitWhilestmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhilestmtContext whilestmt() throws RecognitionException {
		WhilestmtContext _localctx = new WhilestmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_whilestmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			match(KW_WHILE);
			setState(301);
			match(LPAREN);
			setState(302);
			((WhilestmtContext)_localctx).condition = condition();
			setState(303);
			match(RPAREN);
			setState(304);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EmoticonVisitor ) return ((EmoticonVisitor<? extends T>)visitor).visitArraystmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArraystmtContext arraystmt() throws RecognitionException {
		ArraystmtContext _localctx = new ArraystmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_arraystmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			match(KW_ARRAY);
			setState(308);
			((ArraystmtContext)_localctx).IDENT = match(IDENT);
			setState(309);
			match(ASSIGNMENT);
			setState(310);
			match(LBRACKET);
			setState(311);
			((ArraystmtContext)_localctx).size1 = match(INT);
			setState(312);
			match(RBRACKET);
			setState(316);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(313);
				match(LBRACKET);
				setState(314);
				((ArraystmtContext)_localctx).size2 = match(INT);
				setState(315);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EmoticonVisitor ) return ((EmoticonVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			String leftReg = "ft0"; String rightReg = "ft1";
			setState(321);
			((ConditionContext)_localctx).left = expr(leftReg);
			setState(322);
			((ConditionContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1649393270784L) != 0)) ) {
				((ConditionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(323);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EmoticonVisitor ) return ((EmoticonVisitor<? extends T>)visitor).visitOperators(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorsContext operators() throws RecognitionException {
		OperatorsContext _localctx = new OperatorsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_operators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EmoticonVisitor ) return ((EmoticonVisitor<? extends T>)visitor).visitConditionals(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalsContext conditionals() throws RecognitionException {
		ConditionalsContext _localctx = new ConditionalsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_conditionals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 125829120L) != 0)) ) {
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EmoticonVisitor ) return ((EmoticonVisitor<? extends T>)visitor).visitComp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompContext comp() throws RecognitionException {
		CompContext _localctx = new CompContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_comp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
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
		"\u0004\u0001)\u014d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0005\u00003\b\u0000\n\u0000\f\u00006\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001P\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002X\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003s\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"{\b\u0004\n\u0004\f\u0004~\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u0087\b\u0005"+
		"\n\u0005\f\u0005\u008a\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0005\u0006\u0091\b\u0006\n\u0006\f\u0006\u0094\t\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007"+
		"\u00a1\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0003\u0007\u00ae\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\b\u00b7\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\t\u00c1\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00cd\b\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00d5\b\n\n\n\f\n\u00d8\t\n"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0005\u000b\u00e0\b\u000b\n\u000b\f\u000b\u00e3\t\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00f6\b\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0107\b\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0003\u000e\u0111\b\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f"+
		"\u011b\b\u000f\n\u000f\f\u000f\u011e\t\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u0122\b\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u013d\b\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0000\u0000\u0017\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,\u0000\u0005\u0001"+
		"\u0000\u0012\u0013\u0001\u0000\u0014\u0016\u0002\u0000\u0017\u001a\'("+
		"\u0001\u0000\u0012\u0015\u0001\u0000\u0017\u001a\u0155\u0000.\u0001\u0000"+
		"\u0000\u0000\u0002O\u0001\u0000\u0000\u0000\u0004W\u0001\u0000\u0000\u0000"+
		"\u0006r\u0001\u0000\u0000\u0000\bt\u0001\u0000\u0000\u0000\n\u007f\u0001"+
		"\u0000\u0000\u0000\f\u008b\u0001\u0000\u0000\u0000\u000e\u00ad\u0001\u0000"+
		"\u0000\u0000\u0010\u00b6\u0001\u0000\u0000\u0000\u0012\u00cc\u0001\u0000"+
		"\u0000\u0000\u0014\u00ce\u0001\u0000\u0000\u0000\u0016\u00d9\u0001\u0000"+
		"\u0000\u0000\u0018\u00f5\u0001\u0000\u0000\u0000\u001a\u0106\u0001\u0000"+
		"\u0000\u0000\u001c\u0108\u0001\u0000\u0000\u0000\u001e\u0114\u0001\u0000"+
		"\u0000\u0000 \u0125\u0001\u0000\u0000\u0000\"\u012c\u0001\u0000\u0000"+
		"\u0000$\u0133\u0001\u0000\u0000\u0000&\u0140\u0001\u0000\u0000\u0000("+
		"\u0146\u0001\u0000\u0000\u0000*\u0148\u0001\u0000\u0000\u0000,\u014a\u0001"+
		"\u0000\u0000\u0000.4\u0006\u0000\uffff\uffff\u0000/0\u0003\u0002\u0001"+
		"\u000001\u0006\u0000\uffff\uffff\u000013\u0001\u0000\u0000\u00002/\u0001"+
		"\u0000\u0000\u000036\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u0000"+
		"45\u0001\u0000\u0000\u000057\u0001\u0000\u0000\u000064\u0001\u0000\u0000"+
		"\u000078\u0005\u0000\u0000\u000189\u0006\u0000\uffff\uffff\u00009\u0001"+
		"\u0001\u0000\u0000\u0000:;\u0003\u000e\u0007\u0000;<\u0006\u0001\uffff"+
		"\uffff\u0000<P\u0001\u0000\u0000\u0000=>\u0003\u0012\t\u0000>?\u0006\u0001"+
		"\uffff\uffff\u0000?P\u0001\u0000\u0000\u0000@A\u0003\u001e\u000f\u0000"+
		"AB\u0006\u0001\uffff\uffff\u0000BP\u0001\u0000\u0000\u0000CD\u0003\"\u0011"+
		"\u0000DE\u0006\u0001\uffff\uffff\u0000EP\u0001\u0000\u0000\u0000FG\u0003"+
		"$\u0012\u0000GH\u0006\u0001\uffff\uffff\u0000HP\u0001\u0000\u0000\u0000"+
		"IJ\u0003\u0004\u0002\u0000JK\u0006\u0001\uffff\uffff\u0000KP\u0001\u0000"+
		"\u0000\u0000LM\u0003\u0006\u0003\u0000MN\u0006\u0001\uffff\uffff\u0000"+
		"NP\u0001\u0000\u0000\u0000O:\u0001\u0000\u0000\u0000O=\u0001\u0000\u0000"+
		"\u0000O@\u0001\u0000\u0000\u0000OC\u0001\u0000\u0000\u0000OF\u0001\u0000"+
		"\u0000\u0000OI\u0001\u0000\u0000\u0000OL\u0001\u0000\u0000\u0000P\u0003"+
		"\u0001\u0000\u0000\u0000QR\u0005\t\u0000\u0000RS\u0003\u0014\n\u0000S"+
		"T\u0006\u0002\uffff\uffff\u0000TX\u0001\u0000\u0000\u0000UV\u0005\t\u0000"+
		"\u0000VX\u0006\u0002\uffff\uffff\u0000WQ\u0001\u0000\u0000\u0000WU\u0001"+
		"\u0000\u0000\u0000X\u0005\u0001\u0000\u0000\u0000YZ\u0005\n\u0000\u0000"+
		"Z[\u0005\u0011\u0000\u0000[\\\u0005\"\u0000\u0000\\]\u0005\u0011\u0000"+
		"\u0000]^\u0005#\u0000\u0000^_\u0006\u0003\uffff\uffff\u0000_`\u0003\f"+
		"\u0006\u0000`a\u0006\u0003\uffff\uffff\u0000as\u0001\u0000\u0000\u0000"+
		"bc\u0005\n\u0000\u0000cd\u0005\u0011\u0000\u0000de\u0005\u0001\u0000\u0000"+
		"ef\u0006\u0003\uffff\uffff\u0000fg\u0003\f\u0006\u0000gh\u0006\u0003\uffff"+
		"\uffff\u0000hs\u0001\u0000\u0000\u0000ij\u0005\n\u0000\u0000jk\u0005\u0011"+
		"\u0000\u0000kl\u0005\"\u0000\u0000lm\u0003\b\u0004\u0000mn\u0005#\u0000"+
		"\u0000no\u0006\u0003\uffff\uffff\u0000op\u0003\f\u0006\u0000pq\u0006\u0003"+
		"\uffff\uffff\u0000qs\u0001\u0000\u0000\u0000rY\u0001\u0000\u0000\u0000"+
		"rb\u0001\u0000\u0000\u0000ri\u0001\u0000\u0000\u0000s\u0007\u0001\u0000"+
		"\u0000\u0000tu\u0006\u0004\uffff\uffff\u0000uv\u0005\u0011\u0000\u0000"+
		"v|\u0006\u0004\uffff\uffff\u0000wx\u0005$\u0000\u0000xy\u0005\u0011\u0000"+
		"\u0000y{\u0006\u0004\uffff\uffff\u0000zw\u0001\u0000\u0000\u0000{~\u0001"+
		"\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000"+
		"}\t\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000\u007f\u0080\u0006"+
		"\u0005\uffff\uffff\u0000\u0080\u0081\u0003\u0014\n\u0000\u0081\u0088\u0006"+
		"\u0005\uffff\uffff\u0000\u0082\u0083\u0005$\u0000\u0000\u0083\u0084\u0003"+
		"\u0014\n\u0000\u0084\u0085\u0006\u0005\uffff\uffff\u0000\u0085\u0087\u0001"+
		"\u0000\u0000\u0000\u0086\u0082\u0001\u0000\u0000\u0000\u0087\u008a\u0001"+
		"\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0088\u0089\u0001"+
		"\u0000\u0000\u0000\u0089\u000b\u0001\u0000\u0000\u0000\u008a\u0088\u0001"+
		"\u0000\u0000\u0000\u008b\u008c\u0005\f\u0000\u0000\u008c\u0092\u0006\u0006"+
		"\uffff\uffff\u0000\u008d\u008e\u0003\u0002\u0001\u0000\u008e\u008f\u0006"+
		"\u0006\uffff\uffff\u0000\u008f\u0091\u0001\u0000\u0000\u0000\u0090\u008d"+
		"\u0001\u0000\u0000\u0000\u0091\u0094\u0001\u0000\u0000\u0000\u0092\u0090"+
		"\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u0095"+
		"\u0001\u0000\u0000\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0095\u0096"+
		"\u0005\r\u0000\u0000\u0096\r\u0001\u0000\u0000\u0000\u0097\u0098\u0006"+
		"\u0007\uffff\uffff\u0000\u0098\u0099\u0005\u0011\u0000\u0000\u0099\u009a"+
		"\u0005\u001b\u0000\u0000\u009a\u009b\u0003\u0014\n\u0000\u009b\u00a0\u0005"+
		"\u001c\u0000\u0000\u009c\u009d\u0005\u001b\u0000\u0000\u009d\u009e\u0003"+
		"\u0014\n\u0000\u009e\u009f\u0005\u001c\u0000\u0000\u009f\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a0\u009c\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005)\u0000"+
		"\u0000\u00a3\u00a4\u0003\u0010\b\u0000\u00a4\u00a5\u0006\u0007\uffff\uffff"+
		"\u0000\u00a5\u00ae\u0001\u0000\u0000\u0000\u00a6\u00a7\u0006\u0007\uffff"+
		"\uffff\u0000\u00a7\u00a8\u0005\u0011\u0000\u0000\u00a8\u00a9\u0006\u0007"+
		"\uffff\uffff\u0000\u00a9\u00aa\u0005)\u0000\u0000\u00aa\u00ab\u0003\u0010"+
		"\b\u0000\u00ab\u00ac\u0006\u0007\uffff\uffff\u0000\u00ac\u00ae\u0001\u0000"+
		"\u0000\u0000\u00ad\u0097\u0001\u0000\u0000\u0000\u00ad\u00a6\u0001\u0000"+
		"\u0000\u0000\u00ae\u000f\u0001\u0000\u0000\u0000\u00af\u00b0\u0003\u0014"+
		"\n\u0000\u00b0\u00b1\u0006\b\uffff\uffff\u0000\u00b1\u00b7\u0001\u0000"+
		"\u0000\u0000\u00b2\u00b3\u0005\u0002\u0000\u0000\u00b3\u00b7\u0006\b\uffff"+
		"\uffff\u0000\u00b4\u00b5\u0005 \u0000\u0000\u00b5\u00b7\u0006\b\uffff"+
		"\uffff\u0000\u00b6\u00af\u0001\u0000\u0000\u0000\u00b6\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b7\u0011\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b9\u0006\t\uffff\uffff\u0000\u00b9\u00ba\u0005\u0003"+
		"\u0000\u0000\u00ba\u00c0\u0005\"\u0000\u0000\u00bb\u00bc\u0003\u0014\n"+
		"\u0000\u00bc\u00bd\u0006\t\uffff\uffff\u0000\u00bd\u00c1\u0001\u0000\u0000"+
		"\u0000\u00be\u00bf\u0005 \u0000\u0000\u00bf\u00c1\u0006\t\uffff\uffff"+
		"\u0000\u00c0\u00bb\u0001\u0000\u0000\u0000\u00c0\u00be\u0001\u0000\u0000"+
		"\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u00cd\u0005#\u0000\u0000"+
		"\u00c3\u00c4\u0006\t\uffff\uffff\u0000\u00c4\u00c5\u0005\u0003\u0000\u0000"+
		"\u00c5\u00c6\u0005\"\u0000\u0000\u00c6\u00c7\u0005 \u0000\u0000\u00c7"+
		"\u00c8\u0005$\u0000\u0000\u00c8\u00c9\u0003\u0014\n\u0000\u00c9\u00ca"+
		"\u0005#\u0000\u0000\u00ca\u00cb\u0006\t\uffff\uffff\u0000\u00cb\u00cd"+
		"\u0001\u0000\u0000\u0000\u00cc\u00b8\u0001\u0000\u0000\u0000\u00cc\u00c3"+
		"\u0001\u0000\u0000\u0000\u00cd\u0013\u0001\u0000\u0000\u0000\u00ce\u00cf"+
		"\u0003\u0016\u000b\u0000\u00cf\u00d6\u0006\n\uffff\uffff\u0000\u00d0\u00d1"+
		"\u0007\u0000\u0000\u0000\u00d1\u00d2\u0003\u0016\u000b\u0000\u00d2\u00d3"+
		"\u0006\n\uffff\uffff\u0000\u00d3\u00d5\u0001\u0000\u0000\u0000\u00d4\u00d0"+
		"\u0001\u0000\u0000\u0000\u00d5\u00d8\u0001\u0000\u0000\u0000\u00d6\u00d4"+
		"\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7\u0015"+
		"\u0001\u0000\u0000\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d9\u00da"+
		"\u0003\u0018\f\u0000\u00da\u00e1\u0006\u000b\uffff\uffff\u0000\u00db\u00dc"+
		"\u0007\u0001\u0000\u0000\u00dc\u00dd\u0003\u0018\f\u0000\u00dd\u00de\u0006"+
		"\u000b\uffff\uffff\u0000\u00de\u00e0\u0001\u0000\u0000\u0000\u00df\u00db"+
		"\u0001\u0000\u0000\u0000\u00e0\u00e3\u0001\u0000\u0000\u0000\u00e1\u00df"+
		"\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2\u0017"+
		"\u0001\u0000\u0000\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e4\u00e5"+
		"\u0005\u001d\u0000\u0000\u00e5\u00f6\u0006\f\uffff\uffff\u0000\u00e6\u00e7"+
		"\u0005\u001e\u0000\u0000\u00e7\u00f6\u0006\f\uffff\uffff\u0000\u00e8\u00e9"+
		"\u0003\u001c\u000e\u0000\u00e9\u00ea\u0006\f\uffff\uffff\u0000\u00ea\u00f6"+
		"\u0001\u0000\u0000\u0000\u00eb\u00ec\u0003\u001a\r\u0000\u00ec\u00ed\u0006"+
		"\f\uffff\uffff\u0000\u00ed\u00f6\u0001\u0000\u0000\u0000\u00ee\u00ef\u0005"+
		"\u0011\u0000\u0000\u00ef\u00f6\u0006\f\uffff\uffff\u0000\u00f0\u00f1\u0005"+
		"\"\u0000\u0000\u00f1\u00f2\u0003\u0014\n\u0000\u00f2\u00f3\u0005#\u0000"+
		"\u0000\u00f3\u00f4\u0006\f\uffff\uffff\u0000\u00f4\u00f6\u0001\u0000\u0000"+
		"\u0000\u00f5\u00e4\u0001\u0000\u0000\u0000\u00f5\u00e6\u0001\u0000\u0000"+
		"\u0000\u00f5\u00e8\u0001\u0000\u0000\u0000\u00f5\u00eb\u0001\u0000\u0000"+
		"\u0000\u00f5\u00ee\u0001\u0000\u0000\u0000\u00f5\u00f0\u0001\u0000\u0000"+
		"\u0000\u00f6\u0019\u0001\u0000\u0000\u0000\u00f7\u00f8\u0005\u0011\u0000"+
		"\u0000\u00f8\u00f9\u0005\"\u0000\u0000\u00f9\u00fa\u0003\u0014\n\u0000"+
		"\u00fa\u00fb\u0005#\u0000\u0000\u00fb\u00fc\u0006\r\uffff\uffff\u0000"+
		"\u00fc\u0107\u0001\u0000\u0000\u0000\u00fd\u00fe\u0005\u0011\u0000\u0000"+
		"\u00fe\u00ff\u0005\u0001\u0000\u0000\u00ff\u0107\u0006\r\uffff\uffff\u0000"+
		"\u0100\u0101\u0005\u0011\u0000\u0000\u0101\u0102\u0005\"\u0000\u0000\u0102"+
		"\u0103\u0003\n\u0005\u0000\u0103\u0104\u0005#\u0000\u0000\u0104\u0105"+
		"\u0006\r\uffff\uffff\u0000\u0105\u0107\u0001\u0000\u0000\u0000\u0106\u00f7"+
		"\u0001\u0000\u0000\u0000\u0106\u00fd\u0001\u0000\u0000\u0000\u0106\u0100"+
		"\u0001\u0000\u0000\u0000\u0107\u001b\u0001\u0000\u0000\u0000\u0108\u0109"+
		"\u0005\u0011\u0000\u0000\u0109\u010a\u0005\u001b\u0000\u0000\u010a\u010b"+
		"\u0003\u0014\n\u0000\u010b\u0110\u0005\u001c\u0000\u0000\u010c\u010d\u0005"+
		"\u001b\u0000\u0000\u010d\u010e\u0003\u0014\n\u0000\u010e\u010f\u0005\u001c"+
		"\u0000\u0000\u010f\u0111\u0001\u0000\u0000\u0000\u0110\u010c\u0001\u0000"+
		"\u0000\u0000\u0110\u0111\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000"+
		"\u0000\u0000\u0112\u0113\u0006\u000e\uffff\uffff\u0000\u0113\u001d\u0001"+
		"\u0000\u0000\u0000\u0114\u0115\u0005\u0004\u0000\u0000\u0115\u0116\u0005"+
		"\"\u0000\u0000\u0116\u0117\u0003&\u0013\u0000\u0117\u0118\u0005#\u0000"+
		"\u0000\u0118\u011c\u0003\f\u0006\u0000\u0119\u011b\u0003 \u0010\u0000"+
		"\u011a\u0119\u0001\u0000\u0000\u0000\u011b\u011e\u0001\u0000\u0000\u0000"+
		"\u011c\u011a\u0001\u0000\u0000\u0000\u011c\u011d\u0001\u0000\u0000\u0000"+
		"\u011d\u0121\u0001\u0000\u0000\u0000\u011e\u011c\u0001\u0000\u0000\u0000"+
		"\u011f\u0120\u0005\u0005\u0000\u0000\u0120\u0122\u0003\f\u0006\u0000\u0121"+
		"\u011f\u0001\u0000\u0000\u0000\u0121\u0122\u0001\u0000\u0000\u0000\u0122"+
		"\u0123\u0001\u0000\u0000\u0000\u0123\u0124\u0006\u000f\uffff\uffff\u0000"+
		"\u0124\u001f\u0001\u0000\u0000\u0000\u0125\u0126\u0005\u0006\u0000\u0000"+
		"\u0126\u0127\u0005\"\u0000\u0000\u0127\u0128\u0003&\u0013\u0000\u0128"+
		"\u0129\u0005#\u0000\u0000\u0129\u012a\u0003\f\u0006\u0000\u012a\u012b"+
		"\u0006\u0010\uffff\uffff\u0000\u012b!\u0001\u0000\u0000\u0000\u012c\u012d"+
		"\u0005\b\u0000\u0000\u012d\u012e\u0005\"\u0000\u0000\u012e\u012f\u0003"+
		"&\u0013\u0000\u012f\u0130\u0005#\u0000\u0000\u0130\u0131\u0003\f\u0006"+
		"\u0000\u0131\u0132\u0006\u0011\uffff\uffff\u0000\u0132#\u0001\u0000\u0000"+
		"\u0000\u0133\u0134\u0005\u000b\u0000\u0000\u0134\u0135\u0005\u0011\u0000"+
		"\u0000\u0135\u0136\u0005)\u0000\u0000\u0136\u0137\u0005\u001b\u0000\u0000"+
		"\u0137\u0138\u0005\u001d\u0000\u0000\u0138\u013c\u0005\u001c\u0000\u0000"+
		"\u0139\u013a\u0005\u001b\u0000\u0000\u013a\u013b\u0005\u001d\u0000\u0000"+
		"\u013b\u013d\u0005\u001c\u0000\u0000\u013c\u0139\u0001\u0000\u0000\u0000"+
		"\u013c\u013d\u0001\u0000\u0000\u0000\u013d\u013e\u0001\u0000\u0000\u0000"+
		"\u013e\u013f\u0006\u0012\uffff\uffff\u0000\u013f%\u0001\u0000\u0000\u0000"+
		"\u0140\u0141\u0006\u0013\uffff\uffff\u0000\u0141\u0142\u0003\u0014\n\u0000"+
		"\u0142\u0143\u0007\u0002\u0000\u0000\u0143\u0144\u0003\u0014\n\u0000\u0144"+
		"\u0145\u0006\u0013\uffff\uffff\u0000\u0145\'\u0001\u0000\u0000\u0000\u0146"+
		"\u0147\u0007\u0003\u0000\u0000\u0147)\u0001\u0000\u0000\u0000\u0148\u0149"+
		"\u0007\u0004\u0000\u0000\u0149+\u0001\u0000\u0000\u0000\u014a\u014b\u0005"+
		"\'\u0000\u0000\u014b-\u0001\u0000\u0000\u0000\u00144OWr|\u0088\u0092\u00a0"+
		"\u00ad\u00b6\u00c0\u00cc\u00d6\u00e1\u00f5\u0106\u0110\u011c\u0121\u013c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}