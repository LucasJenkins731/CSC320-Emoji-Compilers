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
      case FLOAT: return "double";
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

  // Write the generated Java to file.
  void writeFile() {
    try (PrintWriter pw = new PrintWriter("EmoticonProgramTests.java", "UTF-8")) {
      pw.print(sb.toString());
    } catch (Exception e) {
      System.err.println("error: failed to write EmoticonProgramTests.java: " + e.getMessage());
    }
  }
}

// Keywords
KW_READ : '-0-0-';
KW_PRINT : ':P';
KW_IF : ':)';
KW_ELSE : ':(';
KW_ELSE_IF : ':|';
KW_FOR : '>:(';
KW_WHILE : 'D:<';
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
DIVIDE : ':/)';
GREATERTHAN : ':>)'; // A is greater than B
LESSTHAN : ':<)'; // A is less than B
GREATERTHANOREQUALTO : ':>=)';
LESSTHANOREQUALTO : ':<=)';
LBRACKET : '[';
RBRACKET : ']';
INT : ('+'|'-')? ('0'|[1-9][0-9]*);
// FLOAT : ('+'|'-')?[0-9]*'.'[0-9]+;
CHAR : '\'' ( '\\' . | ~('\\'|'\'')) '\'';
STRING : ('\''|'"') .*? ('\''|'"');
WS : [ \t\r\n]+ -> skip;
LPAREN : '(';
RPAREN : ')';
COMMA : ',';
COMMENT : '<3'~[\n\r]* -> skip;
COMMENT_BLOCK : 'OWO' .*? 'UWU' -> skip;
COMPARISON : ':==)';
ASSIGNMENT : ':=)';

// GRAMMAR

program
  : { openProgram(); }         // preamble
    s* EOF
    {
      int numErrors = printDiagnostics();
      if (numErrors == 0) {
        // Successful, so write out the generated code
        closeProgram();
        writeFile();
        System.err.println("Success!");
      } else {
        System.err.println(numErrors + " errors detected. Code not generated.");
        System.exit(1);  // Error code
      }
    }
  ;

s : functioncall | as | ps | expr | arraystmt | blockStatement | ifstmt | forstmt | whilestmt | functionstmt ;

blockStatement : LBRACE
  {  
    if (!definingFunction) {
      SymbolTable currentSymbolTable = new SymbolTable();
      symbolStack.push(currentSymbolTable);
    } else {
      functionDefDepth++;
    }
  } 
  (s)* RBRACE 
  { 
    if (!definingFunction) {
      symbolStack.pop();
    } else {
      functionDefDepth--;
    }
  } 
  ;

as
  : arrayAccess ':=)' expr
    {
      String arrayCode = $arrayAccess.result.code;
      if ($arrayAccess.result.type != Type.UNKNOWN) {
        emit("    " + arrayCode + " = " + $expr.result.code + ";\n");
      }
    }
  | IDENT ':=)' 
    (
      expr
      {
        String id = $IDENT.getText();
        Identifier var = lookupVariable(id);
        Identifier newId = new Identifier();
        newId.id = id;
        if($expr.result.type == Type.INT || $expr.result.type == Type.FLOAT){
          newId.value = $expr.result.numericalValue;
        } else {
          newId.value = $expr.result.stringValue;
        }
        newId.type = $expr.result.type;
        System.out.println(id + " = " + String.valueOf(newId.value) + " (" + "Type = " + newId.type + ")");
        newId.hasKnown = $expr.result.hasKnownValue;
        newId.hasBeenUsed = false;
        addVariable(newId);
        
        // Generate Java code for assignment
        boolean isNewVariable = (var == null);
        generateAssign(isNewVariable, id, $expr.result.code, $expr.result.type, forAssign);
      }
      
    | INT
      {
        Identifier newId = new Identifier();
        newId.id = $IDENT.getText();
        newId.value = $INT.getText();
        newId.type = Type.INT;
        addVariable(newId);
        System.out.println(newId.value + "(" + "Type = " + newId.type + ")");
        
        // Generate Java code for assignment
        generateAssign(true, newId.id, $INT.getText(), Type.INT, forAssign);
      }
    | STRING
      {
        Identifier newId = new Identifier();
        newId.id = $IDENT.getText();
        newId.value = $STRING.getText();
        newId.type = Type.STRING;
        addVariable(newId);
        System.out.println(newId.value + "(" + "Type = " + newId.type + ")");
        
        // Generate Java code for assignment
        generateAssign(true, newId.id, $STRING.getText(), Type.STRING, forAssign);
      }
    | CHAR
      {
        Identifier newId = new Identifier();
        newId.id = $IDENT.getText();
        newId.value = $CHAR.getText();
        newId.type = Type.CHAR;
        addVariable(newId);
        System.out.println(newId.value + "(" + "Type = " + newId.type + ")");
        
        // Generate Java code for assignment
        generateAssign(true, newId.id, $CHAR.getText(), Type.CHAR, forAssign);
      }
    /*| FLOAT
      {
        Identifier newId = new Identifier();
        newId.id = $IDENT.getText();
        newId.value = $FLOAT.getText();
        newId.type = Type.FLOAT;
        addVariable(newId);
        System.out.println(newId.value + "(" + "Type = " + newId.type + ")");
        
        // Generate Java code for assignment
        generateAssign(true, newId.id, $FLOAT.getText(), Type.FLOAT);
      }*/
    | KW_READ
      {
        String input = readInput.nextLine();
        Identifier newId = new Identifier();
        newId.id = $IDENT.getText();
        newId.value = input;
        newId.type = typeCheck(input);
        addVariable(newId);
        System.out.println(newId.value + "(" + "Type = " + newId.type + ")");
        
        // Generate Java code for assignment
        generateAssign(true, newId.id, "in.nextLine()", newId.type, forAssign);
      }
    | //ARRAY 
      {
        // add array functionality
      }
    )
  ;

ps : KW_PRINT '(' expr ')' 
    {
      if($expr.result.hasKnownValue){
        if($expr.result.type == Type.INT || $expr.result.type == Type.FLOAT){
          System.out.println($expr.result.numericalValue);
        } else {
          System.out.println($expr.result.stringValue);
        }
      }
      
      // Generate Java code for print statement
      emit("    System.out.println(" + $expr.result.code + ");\n");
    }
;
condition returns [ExprResult result]
  @init {
    $result = new ExprResult();
  }
  : a=expr
    {
      // start with the lhs expr result
      $result = $a.result;
    }
    ( conditional=(GREATERTHAN|LESSTHAN|GREATERTHANOREQUALTO|LESSTHANOREQUALTO)
      b=expr
      {
        // map emoticon tokens to Java operators
        String tok = $conditional.getText();
        String javaOp;
        if (":>)".equals(tok)) javaOp = ">";
        else if (":<)".equals(tok)) javaOp = "<";
        else if (":>=)".equals(tok)) javaOp = ">=";
        else if (":<=)".equals(tok)) javaOp = "<=";
        else if (":==)".equals(tok)) javaOp = "==";
        else javaOp = tok;

        // ensure operands are comparable (allow numeric, char, string comparisons as needed)
        if ((($a.result.type == Type.INT || $a.result.type == Type.FLOAT)
             && ($b.result.type == Type.INT || $b.result.type == Type.FLOAT))
            || ($a.result.type == Type.CHAR && $b.result.type == Type.CHAR)
            || ($a.result.type == Type.STRING && $b.result.type == Type.STRING)) {
          $result.code = $a.result.code + " " + javaOp + " " + $b.result.code;
          $result.hasKnownValue = false; // conservative
          $result.type = Type.UNKNOWN;
        } else {
          error($conditional, "incomparable types used in condition");
          $result.code = "false";
          $result.hasKnownValue = false;
          $result.type = Type.UNKNOWN;
        }
      }
    )*
  ;


expr returns [ExprResult result]
  @init {
    $result = new ExprResult();
  }
  : a=term
    {
      $result = $a.result;
    }
    ( op=(ADD|SUBTRACT) b=term
      {
        ExprResult resultB = $b.result;
        if(($result.type == Type.INT || $result.type == Type.FLOAT)){
          if(resultB.type == Type.INT || resultB.type == Type.FLOAT){
            if($op.getText().equals(":+)")){
              $result.numericalValue += resultB.numericalValue;
            } else {
              $result.numericalValue -= resultB.numericalValue;
            }
            $result.code = ""+$result.numericalValue;
            if($result.type == Type.FLOAT || resultB.type == Type.FLOAT){
              $result.type = Type.FLOAT;
            }
          } else {
            error($op, "cannot do arithmetic on non-numerical types");
            $result.hasKnownValue = false;
            $result.code = "(" + $result.code + $op.getText() + resultB.code + ")";
          }
        } else if($result.type == Type.STRING || $result.type == Type.CHAR){
          if($op.getText().equals(":+)")){
            $result.stringValue = $result.stringValue + resultB.stringValue;
          } else {
            error($op, "cannot subtract strings");
            $result.hasKnownValue = false;
            $result.code = "(" + $result.code + $op.getText() + resultB.code + ")";
          }
        } else {
          error($op, "unknown type");
          $result.hasKnownValue = false;
        }
      }
    )*
  ;

term returns [ExprResult result]
  @init {
    $result = new ExprResult();
  }
  : a=factor
    {
      $result = $a.result;
    }
    ( op=(MULTIPLY|DIVIDE) b=factor
      {
        ExprResult resultB = $b.result;
        if($result.type == Type.INT || $result.type == Type.FLOAT){
          if(resultB.type == Type.INT || resultB.type == Type.FLOAT){
            if(resultB.numericalValue == 0 && $op.getText().equals(":/)")){
              error($op, "division by zero");
              $result.hasKnownValue = false;
              $result.code = "Error";
            } else if($op.getText().equals(":*)")){
              $result.numericalValue *= resultB.numericalValue;
            } else {
              $result.numericalValue /= resultB.numericalValue;
            }
            $result.code = ""+$result.numericalValue;
            if($result.type == Type.FLOAT || resultB.type == Type.FLOAT){
              $result.type = Type.FLOAT;
            } else {
              $result.type = Type.INT;
            }
          } else {
            error($op, "cannot do arithmetic on non-numeric types");
            $result.hasKnownValue = false;
            $result.code = "(" + $result.code + $op.getText() + resultB.code + ")";
          }
        } else {
          error($op, "cannot do arithmetic on non-numeric types");
          $result.hasKnownValue = false;
          $result.code = "(" + $result.code + $op.getText() + resultB.code + ")";
        }
      }
    )*
  ;
    

factor returns [ExprResult result] 
  : INT
    {
      $result = new ExprResult();
      $result.type = Type.INT;
      $result.numericalValue = Integer.parseInt($INT.getText());
      $result.hasKnownValue = true;
      $result.code = Integer.toString((int)$result.numericalValue);
    }
  /*| FLOAT
    {
      $result = new ExprResult();
      $result.type = Type.FLOAT;
      $result.numericalValue = Float.parseFloat($FLOAT.getText());
      $result.hasKnownValue = true;
      $result.code = ""+$result.numericalValue;
    }*/
  | CHAR
    {
      $result = new ExprResult();
      $result.type = Type.CHAR;
      $result.stringValue = String.valueOf($CHAR.getText().charAt(1));
      $result.hasKnownValue = true;
      $result.code = $CHAR.getText();
    }
  | STRING
    {
      $result = new ExprResult();
      $result.type = Type.STRING;
      $result.stringValue = $STRING.getText();
      $result.hasKnownValue = true;
      $result.code = ""+$result.stringValue;
    }
  | arrayAccess
    {
      $result = $arrayAccess.result;
    }
  | IDENT
    {
      String id = $IDENT.getText();
      Identifier var = lookupVariable(id);
      $result = new ExprResult();

      if(var == null){
        error($IDENT, "variable is not yet defined");
      } else {
        var.hasBeenUsed = true;
        $result.type = var.type;
        $result.hasKnownValue = var.hasKnown;
        if(var.type == Type.INT || var.type == Type.FLOAT){
          if(var.value instanceof Integer){
            $result.numericalValue = (Integer)var.value;
          } else if(var.value instanceof Float){
            $result.numericalValue = (Float)var.value;
          } else if(var.value instanceof String){
            try {
              $result.numericalValue = Float.parseFloat((String)var.value);
            } catch(NumberFormatException e) {
              $result.numericalValue = 0;
            }
          }
        } else {
          $result.stringValue = (String)var.value;
        }
      }
      $result.code = id;
    }
  | '(' expr ')' 
    {
      $result = $expr.result;
    }
  ;

ifstmt
  : KW_IF
    {
      emit("    if (");
    }
    '(' condition ')'
    {
      // emit condition and space before block
      emit($condition.result.code + ")");
    }
    LBRACE
    {
      emit(" {\n");
      if (!definingFunction) {
        SymbolTable ifScope = new SymbolTable();
        symbolStack.push(ifScope);
      } else {
        functionDefDepth++;
      }
    }
    (s)*
    RBRACE
    {
      emit("    }\n");
      if (!definingFunction) {
        symbolStack.pop();
      } else {
        functionDefDepth--;
      }
    }
    (elsestmt)?
  ;

elsestmt
  : KW_ELSE_IF
    {
      emit("    else if (");
    }
    '(' condition ')'
    {
      emit($condition.result.code + ")");
    }
    LBRACE
    {
      emit(" {\n");
      if (!definingFunction) {
        SymbolTable elseIfScope = new SymbolTable();
        symbolStack.push(elseIfScope);
      } else {
        functionDefDepth++;
      }
    }
    (s)*
    RBRACE
    {
      emit("    }\n");
      if (!definingFunction) {
        symbolStack.pop();
      } else {
        functionDefDepth--;
      }
    }
    (elsestmt)?
  | KW_ELSE
    {
      emit("    else ");
    }
    LBRACE
    {
      emit("{\n");
      if (!definingFunction) {
        SymbolTable elseScope = new SymbolTable();
        symbolStack.push(elseScope);
      } else {
        functionDefDepth++;
      }
    }
    (s)*
    RBRACE
    {
      emit("    }\n");
      if (!definingFunction) {
        symbolStack.pop();
      } else {
        functionDefDepth--;
      }
    }
  ;

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

  forstmt : KW_FOR '('
    {
      //create the block statement stuff
      SymbolTable forScope = new SymbolTable();
      symbolStack.push(forScope);

      // now do assign

      emit("    for (");
      forAssign = true;
    }
    a=as
    ';'
    b=condition
    {emit(";" + $b.result.code + ";");} 
    ';'
    c=as
    ')'

    {
      forAssign = false;
      emit(")");
    }
    LBRACE
    {
      emit(" {\n");
      if (!definingFunction) {
        SymbolTable ifScope = new SymbolTable();
        symbolStack.push(ifScope);
      } else {
        functionDefDepth++;
      }
    }
    (s)*
    RBRACE
    {
      emit("    }\n");
      if (!definingFunction) {
        symbolStack.pop();
      } else {
        functionDefDepth--;
      }
    }

    ;

whilestmt : KW_WHILE 
  {
    if (!definingFunction) {
      SymbolTable whileScope = new SymbolTable();
      symbolStack.push(whileScope);
    }
  }
  '(' expr ')' s
  {
    if (!definingFunction) {
      symbolStack.pop();
    }
  }
  ;

functionstmt : KW_FUNCTION name=IDENT '(' param=IDENT ')' 
  {
    definingFunction = true;
    functionDefDepth = 0;
    FunctionDef func = new FunctionDef();
    func.name = $name.getText();
    func.paramName = $param.getText();
    functions.put(func.name, func);
    System.out.println("Defining function '" + func.name + "' with parameter '" + func.paramName + "'");
  }
  body=s
  {
    definingFunction = false;
    functionDefDepth = 0;
    FunctionDef funcDef = functions.get($name.getText());
    funcDef.body = $body.ctx;
    System.out.println("Function '" + funcDef.name + "' defined");
  }
  | KW_FUNCTION name=IDENT '('')' 
  {
    definingFunction = true;
    functionDefDepth = 0;
    FunctionDef func2 = new FunctionDef();
    func2.name = $name.getText();
    func2.paramName = null;
    functions.put(func2.name, func2);
    System.out.println("Defining function '" + func2.name + "'");
  }
  body=s
  {
    definingFunction = false;
    functionDefDepth = 0;
    FunctionDef funcDef2 = functions.get($name.getText());
    funcDef2.body = $body.ctx;
    System.out.println("Function '" + funcDef2.name + "' defined");
  }
  ;

functioncall : IDENT '(' arg=expr ')'
  {
    String funcName = $IDENT.getText();
    if (!functions.containsKey(funcName)) {
      error($IDENT, "function '" + funcName + "' not defined");
    } else {
      FunctionDef func = functions.get(funcName);
      if($arg.result.type == Type.INT || $arg.result.type == Type.FLOAT){
        System.out.println("Calling function '" + funcName + "' with argument " + $arg.result.numericalValue);
      } else {
        System.out.println("Calling function '" + funcName + "' with argument " + $arg.result.stringValue);
      }
    }
  }
  | IDENT '('')'
  {
    String funcName = $IDENT.getText();
    if (!functions.containsKey(funcName)) {
      error($IDENT, "function '" + funcName + "' not defined");
    } else {
      FunctionDef func = functions.get(funcName);
      if (func.paramName != null) {
        error($IDENT, "function '" + funcName + "' expects a parameter");
      } else {
        System.out.println("Calling function '" + funcName + "'");
      }
    }
  }
  ;

arraystmt : KW_ARRAY IDENT ':=)' LBRACKET size=INT RBRACKET (':=)' arrayInitializer)?
{
    String arrayName = $IDENT.getText();
    int arraySize = Integer.parseInt($size.getText());
    
    // Check if already declared
    if (existsInCurrentScope(arrayName)) {
        error($IDENT, "Array '" + arrayName + "' already declared");
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
        if ($arrayInitializer.ctx != null) {
            // Generate initialization code
            for (int i = 0; i < $arrayInitializer.values.size(); i++) {
                emit("    " + arrayName + "[" + i + "] = " + 
                     $arrayInitializer.values.get(i) + ";\n");
            }
        }
    }
}
;

//arrayInitializer : '[' exprList? ']' ;

arrayInitializer returns [List<String> values]
@init { $values = new ArrayList<>(); }
: LBRACKET (first=expr { $values.add($first.result.code); } 
      (COMMA rest=expr { $values.add($rest.result.code); })*)? RBRACKET
;

exprList : expr (COMMA expr)* ;

arrayAccess returns [ExprResult result]
@init { $result = new ExprResult(); }
: IDENT LBRACKET index=expr RBRACKET
{
    String arrayName = $IDENT.getText();
    Identifier arrayVar = lookupVariable(arrayName);
    
    if (arrayVar == null) {
        error($IDENT, "Undefined array '" + arrayName + "'");
        $result.type = Type.UNKNOWN;
    } else if (!arrayVar.isArray) {
        error($IDENT, "'" + arrayName + "' is not an array");
        $result.type = Type.UNKNOWN;
    } else {
        arrayVar.hasBeenUsed = true;
        $result.type = Type.FLOAT; // Assuming numeric arrays for now
        $result.code = arrayName + "[" + $index.result.code + "]";
        
        // Optional: bounds checking at compile time if index is constant
        if ($index.result.hasKnownValue && $index.result.type == Type.INT) {
            int indexValue = (int)$index.result.numericalValue;
            if (indexValue < 0 || indexValue >= arrayVar.arraySize) {
                error($start, "Array index " + indexValue + " out of bounds [0, " + (arrayVar.arraySize-1) + "]");
            }
        }
    }
}
;

operators : ADD | SUBTRACT | MULTIPLY | DIVIDE;

conditionals : GREATERTHAN | LESSTHAN | GREATERTHANOREQUALTO | LESSTHANOREQUALTO;

comp : COMPARISON;