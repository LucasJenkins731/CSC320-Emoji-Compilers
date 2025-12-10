grammar Emoticon;

@header { import java.util.*; import java.io.*; import org.antlr.v4.runtime.*; import org.antlr.v4.runtime.tree.*; }

@members {

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
}

// Keywords
KW_READ : '-0-0-';
KW_PRINT : ':P';
KW_IF : ':)';
KW_ELSE : ':(';
KW_ELSE_IF : ':|';
KW_FOR : '>:(';
KW_WHILE : 'D:<';
KW_RETURN : 'return';
KW_FUNCTION : '=^._.^=';
KW_ARRAY : '(o_o)';
LBRACE : '><(((,^>';
RBRACE : '<^,)))><';
KW_INT : 'int';
KW_STRING : 'string';
KW_CHAR : 'char';

// Other tokens
IDENT : [A-Za-z][A-Za-z0-9_]* | [_][A-Za-z0-9_]+;
ADD : ':+)';
SUBTRACT : ':-)';
MULTIPLY : ':*)';
DIVIDE : ':/)' ;
MODULO : ':%)' ;
GREATERTHAN : ':>)'; // A is greater than B
LESSTHAN : ':<)'; // A is less than B
GREATERTHANOREQUALTO : ':>=)';
LESSTHANOREQUALTO : ':<=)';
LBRACKET : '[';
RBRACKET : ']';
INT : ('+'|'-')? ('0'|[1-9][0-9]*);
 FLOAT : ('+'|'-')?[0-9]*'.'[0-9]+;
CHAR : '\'' ( '\\' . | ~('\\'|'\'')) '\'';
STRING : ('\''|'"') .*? ('\''|'"');
WS : [ \t\r\n]+ -> skip;
LPAREN : '(';
RPAREN : ')';
COMMA : ',';
COMMENT : '<3'~[\n\r]* -> skip;
COMMENT_BLOCK : 'OWO' .*? 'UWU' -> skip;
COMPARISON : ':==)';
NOTEQUAL : ':!=)';
ASSIGNMENT : ':=)';

// GRAMMAR

program
  : { 
      openProgram();
    }         // preamble
    (s {
      text_sb.append($s.code);
    })* EOF
    {
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
  ;

//s : functioncallstmt | as | ps | expr | arraystmt | blockStatement | ifstmt | forstmt | whilestmt | functionstmt | returnstmt;

s returns [StringBuilder code]
 : as {$code = $as.code;}
 | ps {$code = $ps.code;}
 | ifstmt {$code = $ifstmt.code;}
 | whilestmt {$code = $whilestmt.code;}
 ;

// functioncallstmt : functioncall
//   {
//     if (!definingFunction) {
//       emit("    " + $functioncall.result.code + ";\n");
//     }
//   }
//   ;

// blockStatement : LBRACE
//   {  
//     if (!definingFunction) {
//       SymbolTable currentSymbolTable = new SymbolTable();
//       symbolStack.push(currentSymbolTable);
//     } else {
//       functionDefDepth++;
//     }
//   } 
//   (s)* RBRACE 
//   { 
//     if (!definingFunction) {
//       symbolStack.pop();
//     } else {
//       functionDefDepth--;
//     }
//   } 
//   ;

blockStatement returns [StringBuilder code]
  : LBRACE 
    {
      $code = new StringBuilder();
    }
    (stmt=s
    {
      $code.append($stmt.code);
    }
    )* RBRACE
  ;

as returns [StringBuilder code]
  : {String register = "fa0";}
    IDENT
    {
      String id = $IDENT.getText();
      Identifier var = lookupVariable(id);
      //System.out.println(var);
    }
    ':=)' rhs[register]
    {
      if(var == null){
        Identifier newId = new Identifier();
        newId.id = id;
        newId.type = Type.FLOAT; // Default to float for assembly
        newId.hasBeenUsed = false;
        addVariable(newId);
      }
      generateAssign(id, $rhs.code, register);
      $code = $rhs.code;
    }
;



rhs[String register] returns [StringBuilder code]
  : expr[$register] {$code = $expr.code;}
  | KW_READ {
    $code = new StringBuilder();
    generateReadDouble($code, $register);
  }
  | STRING {
    $code = new StringBuilder();
    String label = addStringConstant($STRING.getText());
    emit($code, "    la    " + $register + ", " + label);
  }
;

// as
//   : arrayAccess ':=)' expr
//     {
//       String arrayCode = $arrayAccess.result.code;
//       if ($arrayAccess.result.type != Type.UNKNOWN) {
//         emit("    " + arrayCode + " = " + $expr.result.code + ";\n");
//       }
//     }
//   | IDENT ':=)' 
//     (
//       expr
//       {
//         String id = $IDENT.getText();
//         Identifier var = lookupVariable(id);
//         Identifier newId = new Identifier();
//         newId.id = id;
//         if($expr.result.type == Type.INT || $expr.result.type == Type.FLOAT){
//           newId.value = $expr.result.numericalValue;
//         } else {
//           newId.value = $expr.result.stringValue;
//         }
//         newId.type = $expr.result.type;
//         System.out.println(id + " = " + String.valueOf(newId.value) + " (" + "Type = " + newId.type + ")");
//         newId.hasKnown = $expr.result.hasKnownValue;
//         newId.hasBeenUsed = false;
//         addVariable(newId);
        
//         // Generate Java code for assignment
//         boolean isNewVariable = (var == null);
//         generateAssign(isNewVariable, id, $expr.result.code, $expr.result.type);
//       }
      
//     | INT
//       {
//         Identifier newId = new Identifier();
//         newId.id = $IDENT.getText();
//         newId.value = $INT.getText();
//         newId.type = Type.INT;
        
//         System.out.println(newId.value + "(" + "Type = " + newId.type + ")");
        
//         Identifier var = lookupVariable(newId.id);
//         addVariable(newId);
//         boolean isNewVariable = (var == null);
//         // Generate Java code for assignment
//         generateAssign(isNewVariable, newId.id, $INT.getText(), Type.INT);
//       }
//     | STRING
//       {
//         Identifier newId = new Identifier();
//         newId.id = $IDENT.getText();
//         newId.value = $STRING.getText();
//         newId.type = Type.STRING;
        
//         System.out.println(newId.value + "(" + "Type = " + newId.type + ")");
        
//         Identifier var = lookupVariable(newId.id);
//         addVariable(newId);
//         boolean isNewVariable = (var == null);
//         // Generate Java code for assignment
//         generateAssign(isNewVariable, newId.id, $STRING.getText(), Type.STRING);
//       }
//     | CHAR
//       {
//         Identifier newId = new Identifier();
//         newId.id = $IDENT.getText();
//         newId.value = $CHAR.getText();
//         newId.type = Type.CHAR;
        
//         System.out.println(newId.value + "(" + "Type = " + newId.type + ")");
        
//         Identifier var = lookupVariable(newId.id);
//         addVariable(newId);
//         boolean isNewVariable = (var == null);
//         // Generate Java code for assignment
//         generateAssign(isNewVariable, newId.id, $CHAR.getText(), Type.CHAR);
//       }
//     | FLOAT
//       {
//         Identifier newId = new Identifier();
//         newId.id = $IDENT.getText();
//         newId.value = $FLOAT.getText();
//         newId.type = Type.FLOAT;
        
//         System.out.println(newId.value + "(" + "Type = " + newId.type + ")");
        
//         Identifier var = lookupVariable(newId.id);
//         addVariable(newId);
//         boolean isNewVariable = (var == null);
//         // Generate Java code for assignment
//         generateAssign(isNewVariable, newId.id, $FLOAT.getText() + "f", Type.FLOAT);
//       }
//     | KW_READ
//       {
//         //do it so that if var is not equal to null then do the assignment.
//         String id = $IDENT.getText();
//         Identifier var = lookupVariable(id);
//         System.out.println(var.value + "(" + "Type = " + var.type + ")");

//         if(var.type == Type.INT){
//           generateAssign(false, var.id, "in.nextInt()", Type.INT);
//         } else if(var.type == Type.FLOAT){
//           generateAssign(false, var.id, "in.nextFloat()", Type.FLOAT);
//         } else if(var.type == Type.CHAR){
//           generateAssign(false, var.id, "in.next().charAt(0)", Type.CHAR);
//         } else if(var.type == Type.STRING){
//           generateAssign(false, var.id, "in.nextLine()", Type.STRING);
//         } else {
//           generateAssign(false, var.id, "in.nextLine()", Type.STRING); // default to string type
//           System.out.println("ran into default type for reading input (incorrect type name used)");
//         }

//         /* 
//         Identifier newId = new Identifier();
//         newId.id = $IDENT.getText();
//         System.out.println("Please specify the type of input variable " + newId.id + " EX: integer, float, String, char");
//         String input = readInput.nextLine();    
        
//         newId.value = input;
//         newId.type = typeCheck(input);
//         addVariable(newId);
//         System.out.println(newId.value + "(" + "Type = " + newId.type + ")");

//         if(input.equals("integer")){
//           generateAssign(true, newId.id, "in.nextInt()", Type.INT, forAssign);
//         } else if(input.equals("float")){
//           generateAssign(true, newId.id, "in.nextFloat()", Type.FLOAT, forAssign);
//         } else if(input.equals("char")){
//           generateAssign(true, newId.id, "in.next().charAt(0)", Type.CHAR, forAssign);
//         } else if(input.equals("String")){
//           generateAssign(true, newId.id, "in.nextLine()", Type.STRING, forAssign);
//         } else {
//           generateAssign(true, newId.id, "in.nextLine()", Type.STRING, forAssign); // default to string type
//           System.out.println("ran into default type for reading input (incorrect type name used)");
//         }
//         */
//       }
//     | //ARRAY 
//       {
//         // add array functionality
//       }
//     )
//   ;

// ps : KW_PRINT '(' expr ')' 
//     {
//       if($expr.result.hasKnownValue){
//         if($expr.result.type == Type.INT || $expr.result.type == Type.FLOAT){
//           System.out.println($expr.result.numericalValue);
//         } else {
//           System.out.println($expr.result.stringValue);
//         }
//       }
      
//       // Generate Java code for print statement
//       emit("    System.out.println(" + $expr.result.code + ");\n");
//     }
// ;

ps returns [StringBuilder code]
  : {String register = "fa0";}
    KW_PRINT '(' 
    (
      expr[register]
      {
        $code = $expr.code;
        generatePrintDouble($code, register);
      }
    | STRING
      {
        $code = new StringBuilder();
        generatePrintStringConstant($code, $STRING.getText());
      }
    )
    ')'
  | {String register = "fa0";}
    KW_PRINT '(' STRING ',' expr[register] ')'
    {
      $code = new StringBuilder();
      generatePrintStringConstant($code, $STRING.getText());
      $code.append($expr.code);
      generatePrintDouble($code, register);
    }
;

// condition returns [ExprResult result]
//   @init {
//     $result = new ExprResult();
//   }
//   : a=expr
//     {
//       // start with the lhs expr result
//       $result = $a.result;
//     }
//     ( conditional=(GREATERTHAN|LESSTHAN|GREATERTHANOREQUALTO|LESSTHANOREQUALTO)
//       b=expr
//       {
//         // map emoticon tokens to Java operators
//         String tok = $conditional.getText();
//         String javaOp;
//         if (":>)".equals(tok)) javaOp = ">";
//         else if (":<)".equals(tok)) javaOp = "<";
//         else if (":>=)".equals(tok)) javaOp = ">=";
//         else if (":<=)".equals(tok)) javaOp = "<=";
//         else if (":==)".equals(tok)) javaOp = "==";
//         else javaOp = tok;

//         // ensure operands are comparable (allow numeric, char, string comparisons as needed)
//         if ((($a.result.type == Type.INT || $a.result.type == Type.FLOAT)
//              && ($b.result.type == Type.INT || $b.result.type == Type.FLOAT))
//             || ($a.result.type == Type.CHAR && $b.result.type == Type.CHAR)
//             || ($a.result.type == Type.STRING && $b.result.type == Type.STRING)) {
//           $result.code = $a.result.code + " " + javaOp + " " + $b.result.code;
//           $result.hasKnownValue = false; // conservative
//           $result.type = Type.UNKNOWN;
//         } else {
//           error($conditional, "incomparable types used in condition");
//           $result.code = "false";
//           $result.hasKnownValue = false;
//           $result.type = Type.UNKNOWN;
//         }
//       }
//     )*
//   ;


// expr returns [ExprResult result]
//   @init {
//     $result = new ExprResult();
//   }
//   : a=term
//     {
//       $result = $a.result;
//     }
//     ( op=(ADD|SUBTRACT) b=term
//       {
//         ExprResult resultB = $b.result;
//         if(($result.type == Type.INT || $result.type == Type.FLOAT)){
//           if(resultB.type == Type.INT || resultB.type == Type.FLOAT){
//             if(op.getText().equals(":+)")){
//               $result.code = $a.result.code + " " + "+" + " " + $b.result.code;
//             } else {
//               $result.code = $a.result.code + " " + "-" + " " + $b.result.code;
//             }
//             //$result.code = ""+$result.numericalValue;
//             if($result.type == Type.FLOAT || resultB.type == Type.FLOAT){
//               $result.type = Type.FLOAT;
//             }
//           } else {
//             error($op, "cannot do arithmetic on non-numerical types");
//             $result.hasKnownValue = false;
//             $result.code = "(" + $result.code + $op.getText() + resultB.code + ")";
//           }
//         } else if($result.type == Type.STRING || $result.type == Type.CHAR){
//           if($op.getText().equals(":+)")){
//             $result.stringValue = $result.stringValue + resultB.stringValue;
//           } else {
//             error($op, "cannot subtract strings");
//             $result.hasKnownValue = false;
//             $result.code = "(" + $result.code + $op.getText() + resultB.code + ")";
//           }
//         } else {
//           error($op, "unknown type");
//           $result.hasKnownValue = false;
//         }
//       }
//     )*
//   ;

expr[String register] returns [StringBuilder code]
: a=term[$register]
  {
    $code = $a.code;
    String nextRegister = ($register.equals("ft0")) ? "ft1" : "ft0";
  }
  (op=(ADD | SUBTRACT) b=term[nextRegister]
  {
    if($op.getText().equals(":+)")){
      $code.append($b.code);
      emit($code, "    fadd.d " + $register + "," + $register + "," + nextRegister);
    } else {
        // Add the two values
        $code.append($b.code);
        emit($code, "    fsub.d " + $register + "," + $register + "," + nextRegister);
      }
  }
  )*
;

// term returns [ExprResult result]
//   @init {
//     $result = new ExprResult();
//   }
//   : a=factor
//     {
//       $result = $a.result;
//     }
//     ( op=(MULTIPLY|DIVIDE) b=factor
//       {
//         ExprResult resultB = $b.result;
//         if($result.type == Type.INT || $result.type == Type.FLOAT){
//           if(resultB.type == Type.INT || resultB.type == Type.FLOAT){
//             if(resultB.numericalValue == 0 && $op.getText().equals(":/)")){
//               error($op, "division by zero");
//               $result.hasKnownValue = false;
//               $result.code = "Error";
//             } else if($op.getText().equals(":*)")){
//               $result.code = $a.result.code + " " + "*" + " " + $b.result.code;
//             } else {
//               $result.code = $a.result.code + " " + "/" + " " + $b.result.code;
//             }
//             //$result.code = ""+$result.numericalValue;
//             if($result.type == Type.FLOAT || resultB.type == Type.FLOAT){
//               $result.type = Type.FLOAT;
//             } else {
//               $result.type = Type.INT;
//             }
//           } else {
//             error($op, "cannot do arithmetic on non-numeric types");
//             $result.hasKnownValue = false;
//             $result.code = "(" + $result.code + $op.getText() + resultB.code + ")";
//           }
//         } else {
//           error($op, "cannot do arithmetic on non-numeric types");
//           $result.hasKnownValue = false;
//           $result.code = "(" + $result.code + $op.getText() + resultB.code + ")";
//         }
//       }
//     )*
//   ;

term [String register] returns [StringBuilder code]
  : a = factor [$register]
    {
      $code = $a.code;
      String nextRegister = ($register.equals("ft0")) ? "ft1" : "ft0";
    }
    (op = (MULTIPLY | DIVIDE | MODULO) b = factor [nextRegister]
    {
      if($op.getText().equals(":*)")){
        $code.append($b.code);
        emit($code, "    fmul.d " + $register + "," + $register + "," + nextRegister);
      } else if($op.getText().equals(":/)")){
        $code.append($b.code);
        emit($code, "    fdiv.d " + $register + "," + $register + "," + nextRegister);
      } else {
        // Modulo operation: convert to int, do mod, convert back to float
        $code.append($b.code);
        emit($code, "    # Modulo operation: " + $register + " % " + nextRegister);
        emit($code, "    fcvt.w.d t0, " + $register + "  # Convert left operand to int");
        emit($code, "    fcvt.w.d t1, " + nextRegister + "  # Convert right operand to int");
        emit($code, "    rem t0, t0, t1             # Integer modulo");
        emit($code, "    fcvt.d.w " + $register + ", t0  # Convert result back to double");
      }
    }
    )*
;

// factor returns [ExprResult result] 
//   : INT
//     {
//       $result = new ExprResult();
//       $result.type = Type.INT;
//       $result.numericalValue = Integer.parseInt($INT.getText());
//       $result.hasKnownValue = true;
//       $result.code = Integer.toString((int)$result.numericalValue);
//     }
//   /*| FLOAT
//     {
//       $result = new ExprResult();
//       $result.type = Type.FLOAT;
//       $result.numericalValue = Float.parseFloat($FLOAT.getText());
//       $result.hasKnownValue = true;
//       $result.code = ""+$result.numericalValue;
//     }*/
//   | CHAR
//     {
//       $result = new ExprResult();
//       $result.type = Type.CHAR;
//       $result.stringValue = String.valueOf($CHAR.getText().charAt(1));
//       $result.hasKnownValue = true;
//       $result.code = $CHAR.getText();
//     }
//   | STRING
//     {
//       $result = new ExprResult();
//       $result.type = Type.STRING;
//       $result.stringValue = $STRING.getText();
//       $result.hasKnownValue = true;
//       $result.code = ""+$result.stringValue;
//     }
//   | arrayAccess
//     {
//       $result = $arrayAccess.result;
//     }
//   | functioncall
//     {
//       $result = $functioncall.result;
//     }
//   | IDENT
//     {
//       String id = $IDENT.getText();
//       Identifier var = lookupVariable(id);
//       $result = new ExprResult();

//       if(var == null){
//         error($IDENT, "variable is not yet defined");
//       } else {
//         var.hasBeenUsed = true;
//         $result.type = var.type;
//         $result.hasKnownValue = var.hasKnown;
//         if(var.type == Type.INT || var.type == Type.FLOAT){
//           if(var.value instanceof Integer){
//             $result.numericalValue = (Integer)var.value;
//           } else if(var.value instanceof Float){
//             $result.numericalValue = (Float)var.value;
//           } else if(var.value instanceof String){
//             try {
//               $result.numericalValue = Float.parseFloat((String)var.value);
//             } catch(NumberFormatException e) {
//               $result.numericalValue = 0;
//             }
//           }
//         } else {
//           $result.stringValue = (String)var.value;
//         }
//       }
//       $result.code = id;
//     }
//   | functioncall
//     {
//       $result = $functioncall.result;
//     }
//   | '(' expr ')' 
//     {
//       $result = $expr.result;
//     }
//   ;


factor[String register] returns [StringBuilder code]
  : INT
    {
      int value = Integer.parseInt($INT.getText());
      $code = generateDoubleConstant($register, (double) value);
    }
  | FLOAT
    {
      double value = Double.parseDouble($FLOAT.getText());
      $code = generateDoubleConstant($register, value);
    }
  | IDENT
    {
      //find if id has been used before
      String id = $IDENT.getText();
      Identifier var = lookupVariable(id);
      // var used before assignment
      if(var == null) {
        error($IDENT, "use of variable '" + id + "' before assignment");
      } else {
        var.hasBeenUsed = true;
      }
      //gen code
      $code = generateLoadId($register, id);
    }
  | '(' expr[$register] ')'
    {
      $code = $expr.code;
    }
  ;

// If statement with assembly generation
ifstmt returns [StringBuilder code]
  : KW_IF '(' condition ')' ifbody=s (KW_ELSE elsebody=s)?
    {
      $code = new StringBuilder();
      
      // Generate condition evaluation
      $code.append($condition.code);
      
      // Generate labels
      String elseLabel = generateLabel("ELSE_");
      String endLabel = generateLabel("END_IF_");
      
      // Jump to else/end if condition is false
      generateComparison($code, $condition.leftReg, $condition.rightReg, $condition.operator, elseLabel);
      
      // If body
      $code.append($ifbody.code);
      
      if ($elsebody.ctx != null) {
        // Jump over else body
        emit($code, "    j " + endLabel);
        
        // Else label and body
        emit($code, elseLabel + ":");
        $code.append($elsebody.code);
        
        // End label
        emit($code, endLabel + ":");
      } else {
        // Just end label (no else)
        emit($code, elseLabel + ":");
      }
    }
  ;

// While statement with assembly generation
whilestmt returns [StringBuilder code]
  : KW_WHILE '(' condition ')' body=blockStatement
    {
      $code = new StringBuilder();
      
      // Generate labels
      String loopLabel = generateLabel("LOOP_");
      String endLabel = generateLabel("END_LOOP_");
      
      // Loop start label
      emit($code, loopLabel + ":");
      
      // Generate condition evaluation
      $code.append($condition.code);
      
      // Jump to end if condition is false
      generateComparison($code, $condition.leftReg, $condition.rightReg, $condition.operator, endLabel);
      
      // Loop body
      $code.append($body.code);
      
      // Jump back to loop start
      emit($code, "    j " + loopLabel);
      
      // End label
      emit($code, endLabel + ":");
    }
  ;

// Condition for if statements and while loops
condition returns [StringBuilder code, String leftReg, String rightReg, String operator]
  : {String leftReg = "ft0"; String rightReg = "ft1";}
    left=expr[leftReg] op=(LESSTHAN|GREATERTHAN|LESSTHANOREQUALTO|GREATERTHANOREQUALTO|COMPARISON|NOTEQUAL) right=expr[rightReg]
    {
      $code = new StringBuilder();
      $code.append($left.code);
      $code.append($right.code);
      $leftReg = leftReg;
      $rightReg = rightReg;
      $operator = $op.getText();
    }
  ;

// ifstmt
//   : KW_IF
//     {
//       emit("    if (");
//     }
//     '(' condition ')'
//     {
//       // emit condition and space before block
//       emit($condition.result.code + ")");
//     }
//     LBRACE
//     {
//       emit(" {\n");
//       if (!definingFunction) {
//         SymbolTable ifScope = new SymbolTable();
//         symbolStack.push(ifScope);
//       } else {
//         functionDefDepth++;
//       }
//     }
//     (s)*
//     RBRACE
//     {
//       emit("    }\n");
//       if (!definingFunction) {
//         symbolStack.pop();
//       } else {
//         functionDefDepth--;
//       }
//     }
//     (elsestmt)?
//   ;


// elsestmt
//   : KW_ELSE_IF
//     {
//       emit("    else if (");
//     }
//     '(' condition ')'
//     {
//       emit($condition.result.code + ")");
//     }
//     LBRACE
//     {
//       emit(" {\n");
//       if (!definingFunction) {
//         SymbolTable elseIfScope = new SymbolTable();
//         symbolStack.push(elseIfScope);
//       } else {
//         functionDefDepth++;
//       }
//     }
//     (s)*
//     RBRACE
//     {
//       emit("    }\n");
//       if (!definingFunction) {
//         symbolStack.pop();
//       } else {
//         functionDefDepth--;
//       }
//     }
//     (elsestmt)?
//   | KW_ELSE
//     {
//       emit("    else ");
//     }
//     LBRACE
//     {
//       emit("{\n");
//       if (!definingFunction) {
//         SymbolTable elseScope = new SymbolTable();
//         symbolStack.push(elseScope);
//       } else {
//         functionDefDepth++;
//       }
//     }
//     (s)*
//     RBRACE
//     {
//       emit("    }\n");
//       if (!definingFunction) {
//         symbolStack.pop();
//       } else {
//         functionDefDepth--;
//       }
//     }
//   ;

//middle part should be a conditional.
// forstmt : KW_FOR '(' as ';' s ';' as ')' 
//   {

//       SymbolTable forScope = new SymbolTable();
//       symbolStack.push(forScope);
    
//   }
//   as ';' expr ';' as ')' s
//   {

//     emit("for (" )" );


//     if (!definingFunction) {
//       symbolStack.pop();
//     }
//   }
//   ;

//   forstmt : KW_FOR '('
//     {
//       //create the block statement stuff
//       SymbolTable forScope = new SymbolTable();
//       symbolStack.push(forScope);

//       // now do assign

//       emit("    for (");
//       forAssign = true;
//     }
//     a=as
//     ';'
//     b=condition
//     {emit(";" + $b.result.code + ";");} 
//     ';'
//     c=as
//     ')'

//     {
//       forAssign = false;
//       emit(")");
//     }
//     LBRACE
//     {
//       emit(" {\n");
//       if (!definingFunction) {
//         SymbolTable ifScope = new SymbolTable();
//         symbolStack.push(ifScope);
//       } else {
//         functionDefDepth++;
//       }
//     }
//     (s)*
//     RBRACE
//     {
//       emit("    }\n");
//       if (!definingFunction) {
//         symbolStack.pop();
//       } else {
//         functionDefDepth--;
//       }
//     }

//     ;

// whilestmt : KW_WHILE '('
//   {
//     //create the block statement stuff
//       SymbolTable forScope = new SymbolTable();
//       symbolStack.push(forScope);

//       // now do assign

//       emit("    while (");
//   }
//   a=condition
//   {{emit($a.result.code);} }
//   ')'
//   {
//       emit(")");
//     }
//   LBRACE
//     {
//       emit(" {\n");
//       if (!definingFunction) {
//         SymbolTable ifScope = new SymbolTable();
//         symbolStack.push(ifScope);
//       } else {
//         functionDefDepth++;
//       }
//     }
//     (s)*
//     RBRACE
//     {
//       emit("    }\n");
//       if (!definingFunction) {
//         symbolStack.pop();
//       } else {
//         functionDefDepth--;
//       }
//     }
//   ;

// returnstmt : KW_RETURN expr
//   {
//     if (!definingFunction || currentFunction == null) {
//       error($KW_RETURN, "return statement outside function");
//     } else {
//       currentFunction.hasReturn = true;
//       currentFunction.returnType = $expr.result.type;
//       emit("    return " + $expr.result.code + ";\n");
//     }
//   }
//   | KW_RETURN
//   {
//     if (!definingFunction || currentFunction == null) {
//       error($KW_RETURN, "return statement outside function");
//     } else {
//       emit("    return;\n");
//     }
//   }
//   ;

// functionstmt : KW_FUNCTION name=IDENT '(' param=IDENT ')' 
//   {
//     definingFunction = true;
//     functionDefDepth = 0;
//     FunctionDef func = new FunctionDef();
//     func.name = $name.getText();
//     func.paramName = $param.getText();
//     func.paramType = Type.FLOAT; // Default parameter type
//     func.returnType = Type.FLOAT; // Default return type
//     func.hasReturn = false;
//     currentFunction = func;
//     functions.put(func.name, func);
//     System.out.println("Defining function '" + func.name + "' with parameter '" + func.paramName + "'");
    
//     // Create new scope for function
//     SymbolTable functionScope = new SymbolTable();
//     symbolStack.push(functionScope);
    
//     // Add parameter to function scope
//     Identifier paramId = new Identifier();
//     paramId.id = func.paramName;
//     paramId.type = func.paramType;
//     paramId.hasBeenUsed = false;
//     functionScope.table.put(paramId.id, paramId);
    
//     // Start capturing function body code
//     StringBuilder oldSb = sb;
//     sb = new StringBuilder();
//   }
//   body=blockStatement
//   {
//     // Capture the generated code for this function
//     FunctionDef funcDef = functions.get($name.getText());
//     funcDef.javaCode = sb.toString();
    
//     // Restore original string builder
//     sb = oldSb;
    
//     definingFunction = false;
//     functionDefDepth = 0;
//     currentFunction = null;
//     symbolStack.pop(); // Remove function scope
//     System.out.println("Function '" + funcDef.name + "' defined");
//   }
//   | KW_FUNCTION name=IDENT '('')' 
//   {
//     definingFunction = true;
//     functionDefDepth = 0;
//     FunctionDef func2 = new FunctionDef();
//     func2.name = $name.getText();
//     func2.paramName = null;
//     func2.returnType = Type.FLOAT; // Default return type
//     func2.hasReturn = false;
//     currentFunction = func2;
//     functions.put(func2.name, func2);
//     System.out.println("Defining function '" + func2.name + "'");
    
//     // Create new scope for function
//     SymbolTable functionScope = new SymbolTable();
//     symbolStack.push(functionScope);
    
//     // Start capturing function body code
//     StringBuilder oldSb = sb;
//     sb = new StringBuilder();
//   }
//   body=blockStatement
//   {
//     // Capture the generated code for this function
//     FunctionDef funcDef2 = functions.get($name.getText());
//     funcDef2.javaCode = sb.toString();
    
//     // Restore original string builder
//     sb = oldSb;
    
//     definingFunction = false;
//     functionDefDepth = 0;
//     currentFunction = null;
//     symbolStack.pop(); // Remove function scope
//     System.out.println("Function '" + funcDef2.name + "' defined");
//   }
//   ;

// functioncall returns [ExprResult result]
//   @init {
//     $result = new ExprResult();
//   }
//   : IDENT '(' arg=expr ')'
//   {
//     String funcName = $IDENT.getText();
//     if (!functions.containsKey(funcName)) {
//       error($IDENT, "function '" + funcName + "' not defined");
//       $result.type = Type.UNKNOWN;
//     } else {
//       FunctionDef func = functions.get(funcName);
//       if (func.paramName == null) {
//         error($IDENT, "function '" + funcName + "' does not expect parameters");
//         $result.type = Type.UNKNOWN;
//       } else {
//         if($arg.result.type == Type.INT || $arg.result.type == Type.FLOAT){
//           System.out.println("Calling function '" + funcName + "' with argument " + $arg.result.numericalValue);
//         } else {
//           System.out.println("Calling function '" + funcName + "' with argument " + $arg.result.stringValue);
//         }
        
//         // Generate function call code
//         $result.type = func.returnType;
//         $result.code = generateFunctionCall(funcName, $arg.result.code, $arg.result.type);
//         $result.hasKnownValue = false; // Function calls don't have compile-time known values
//       }
//     }
//   }
//   | IDENT '('')'
//   {
//     String funcName = $IDENT.getText();
//     if (!functions.containsKey(funcName)) {
//       error($IDENT, "function '" + funcName + "' not defined");
//       $result.type = Type.UNKNOWN;
//     } else {
//       FunctionDef func = functions.get(funcName);
//       if (func.paramName != null) {
//         error($IDENT, "function '" + funcName + "' expects a parameter");
//         $result.type = Type.UNKNOWN;
//       } else {
//         System.out.println("Calling function '" + funcName + "'");
        
//         // Generate function call code
//         $result.type = func.returnType;
//         $result.code = generateFunctionCall(funcName, null, Type.UNKNOWN);
//         $result.hasKnownValue = false; // Function calls don't have compile-time known values
//       }
//     }
//   }
//   ;

// arraystmt : KW_ARRAY IDENT ':=)' LBRACKET size=INT RBRACKET (':=)' arrayInitializer)?
// {
//     String arrayName = $IDENT.getText();
//     int arraySize = Integer.parseInt($size.getText());
    
//     // Check if already declared
//     if (existsInCurrentScope(arrayName)) {
//         error($IDENT, "Array '" + arrayName + "' already declared");
//     } else {
//         // Create array identifier
//         Identifier arrayId = new Identifier();
//         arrayId.id = arrayName;
//         arrayId.type = Type.ARRAY;
//         arrayId.isArray = true;
//         arrayId.arraySize = arraySize;
//         arrayId.arrayValues = new Object[arraySize];
//         arrayId.hasKnown = true;
        
//         addVariable(arrayId);
        
//         // Generate Java code for array declaration
//         emit("    float[] " + arrayName + " = new float[" + arraySize + "];\n");

//         // If initializer is present:
//         if ($arrayInitializer.ctx != null) {
//             // Generate initialization code
//             for (int i = 0; i < $arrayInitializer.values.size(); i++) {
//                 emit("    " + arrayName + "[" + i + "] = " + 
//                      $arrayInitializer.values.get(i) + ";\n");
//             }
//         }
//     }
// }
// ;

// //arrayInitializer : '[' exprList? ']' ;

// arrayInitializer returns [List<String> values]
// @init { $values = new ArrayList<>(); }
// : LBRACKET (first=expr { $values.add($first.result.code); } 
//       (COMMA rest=expr { $values.add($rest.result.code); })*)? RBRACKET
// ;

// exprList : expr (COMMA expr)* ;

// arrayAccess returns [ExprResult result]
// @init { $result = new ExprResult(); }
// : IDENT LBRACKET index=expr RBRACKET
// {
//     String arrayName = $IDENT.getText();
//     Identifier arrayVar = lookupVariable(arrayName);
    
//     if (arrayVar == null) {
//         error($IDENT, "Undefined array '" + arrayName + "'");
//         $result.type = Type.UNKNOWN;
//     } else if (!arrayVar.isArray) {
//         error($IDENT, "'" + arrayName + "' is not an array");
//         $result.type = Type.UNKNOWN;
//     } else {
//         arrayVar.hasBeenUsed = true;
//         $result.type = Type.FLOAT; // Assuming numeric arrays for now
//         $result.code = arrayName + "[" + $index.result.code + "]";
        
//         // Optional: bounds checking at compile time if index is constant
//         if ($index.result.hasKnownValue && $index.result.type == Type.INT) {
//             int indexValue = (int)$index.result.numericalValue;
//             if (indexValue < 0 || indexValue >= arrayVar.arraySize) {
//                 error($start, "Array index " + indexValue + " out of bounds [0, " + (arrayVar.arraySize-1) + "]");
//             }
//         }
//     }
// }
// ;

operators : ADD | SUBTRACT | MULTIPLY | DIVIDE;

conditionals : GREATERTHAN | LESSTHAN | GREATERTHANOREQUALTO | LESSTHANOREQUALTO;

comp : COMPARISON;
