grammar Emoticon;

@header { import java.util.*; }

@members {

  enum Type {
    INT, STRING, CHAR, UNKNOWN
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
    String paramName; // null if no parameter
  }
  
  SymbolTable mainTable = new SymbolTable();
  Stack<SymbolTable> symbolStack = new Stack<>();
  Map<String, FunctionDef> functions = new HashMap<>();
  
  // Diagnostics
  List<String> diagnostics = new ArrayList<>();
  
  // LHS tracking
  String pendingLHS = null;
  boolean lhsExistedBefore = false;
  
  // Error tracking
  boolean hasErrors = false;
    
  void error(Token t, String msg) {
    diagnostics.add("line " + t.getLine() + ":" + t.getCharPositionInLine() + " " + msg);
    hasErrors = true;
  }

  void printDiagnostics() {    
    if (!diagnostics.isEmpty()) {
      for (String d : diagnostics) {
        System.err.println("Error: " + d);
      }
    }    
    checkUnusedVariables();
  }
  
  void checkUnusedVariables() {
    boolean foundUnused = false;
    
    // Check main table
    for (Map.Entry<String, Identifier> entry : mainTable.table.entrySet()) {
      if (!entry.getValue().hasBeenUsed) {
        if (!foundUnused) {
          System.err.println("\nUnused variables:");
          foundUnused = true;
        }
        System.err.println("Variable '" + entry.getKey() + "' declared but never used");
      }
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

  // Lookup a variable by searching through the scope stack (innermost first)
  Identifier lookupVariable(String name) {
    // Search from top of stack (innermost scope) down
    for (int i = symbolStack.size() - 1; i >= 0; i--) {
      SymbolTable table = symbolStack.get(i);
      if (table.table.containsKey(name)) {
        return table.table.get(name);
      }
    }
    
    // Finally check the main/global table
    if (mainTable.table.containsKey(name)) {
      return mainTable.table.get(name);
    }
    
    return null; // Variable not found in any scope
  }

  // Add a variable to the current scope (top of stack, or main if stack is empty)
  void addVariable(Identifier id) {
    if (symbolStack.isEmpty()) {
      mainTable.table.put(id.id, id);
    } else {
      SymbolTable currentScope = symbolStack.peek();
      currentScope.table.put(id.id, id);
    }
  }

  // Check if variable exists in current scope only
  boolean existsInCurrentScope(String name) {
    if (symbolStack.isEmpty()) {
      return mainTable.table.containsKey(name);
    } else {
      return symbolStack.peek().table.containsKey(name);
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
INT : ('+'|'-')? ('0'|[1-9][0-9]*);
CHAR : '\'' ( '\\' . | ~('\\'|'\'')) '\'';
STRING : ('\''|'"') .*? ('\''|'"');
WS : [ \t\r\n]+ -> skip;
LPAREN : '(';
RPAREN : ')';
COMMENT : '<3'~[\n\r]* -> skip;
COMMENT_BLOCK : 'OWO' .*? 'UWU' -> skip;
COMPARISON : ':==)';
ASSIGNMENT : ':=)';

// GRAMMAR

program : 
  {
    SymbolTable globalSymbolTable = new SymbolTable();
  }
  s+ EOF
  {
    printDiagnostics();
  };

s : as | ps | expr | arraystmt | stringstmt | blockStatement | ifstmt | forstmt | whilestmt | functionstmt | functioncall ;

blockStatement : LBRACE
  {  
    SymbolTable currentSymbolTable = new SymbolTable();
    System.out.println("Debug: Pushing new symbol table for block");
    symbolStack.push(currentSymbolTable); 
  } 
  (s)* RBRACE 
  { 
    symbolStack.pop();
    System.out.println("Debug: Popping symbol table for block");
  } 
  ;

as
  : IDENT 
    {
      pendingLHS = $IDENT.getText();
      // Check if it exists in ANY scope
      Identifier existing = lookupVariable(pendingLHS);
      lhsExistedBefore = (existing != null);
    }
    ':=)' ( expr 
          {
            Identifier newId = new Identifier();
            newId.id = pendingLHS;
            newId.value = $expr.value;
            //TYPE CHECK HERE
            newId.type = typeCheck(String.valueOf(newId.value));
            System.out.println("DEBUG: Assign = " + String.valueOf(newId.value));
            System.out.println("DEBUG: Type = " + newId.type);
            newId.hasKnown = $expr.hasKnownValue;
            newId.hasBeenUsed = false;
            
            // Add to CURRENT scope
            addVariable(newId);
            
            pendingLHS = null;
          }
        | KW_READ
          {
            Identifier newId = new Identifier();
            newId.id = pendingLHS;
            newId.value = 0;
            newId.type = Type.INT;
            newId.hasKnown = false;
            newId.hasBeenUsed = false;
            
            addVariable(newId);
            
            pendingLHS = null;
          }
        ) 
  ;
    
ps : KW_PRINT '(' expr ')' 
    {
      if ($expr.hasKnownValue) {
        System.out.println("Debug: Print value = " + $expr.value);
      } else {
        System.out.println("Debug: Print unknown value");
      }
    }
;


// expr : INT 
//     | IDENT {}
//     | '(' expr ')' {}
//     | expr op expr{}
//     | expr comp expr{}
//     ;

//SHOULD TYPE CHECK SOMEWHERE IN HERE 
//SCRATCH THIS TYPE HECKING ONLY REALLY NEEDS TO BE DONE AT THE LOWEST LEVEL OF FACTOR 
expr returns [boolean hasKnownValue, Integer value]
  : a=term
    {
      if ($a.hasKnownValue) {
        $hasKnownValue = true;
        $value = $a.value;
      } else {
        $hasKnownValue = false;
      } 
    }
    (op=(ADD | SUBTRACT) b=term
    {
      if ($hasKnownValue && $b.hasKnownValue) {
        if ($op.getText().equals(":+)")) {
          $value = $value + $b.value;
        } else {
          $value = $value - $b.value;
        }
      } else {
        $hasKnownValue = false;
      }
    }
    )*
  ;

    term returns [boolean hasKnownValue, Integer value]
  : a=factor 
    {
      if ($a.hasKnownValue) {
        $hasKnownValue = true;
        $value = $a.value;
      } else {
        $hasKnownValue = false;
      }
    }
  ( op=(MULTIPLY|DIVIDE) b=factor
    {
      if ($b.hasKnownValue && $op.getText().equals(":/)") && $b.value == 0) {
        error($op, "division by zero");
        $hasKnownValue = false;
      } else if ($hasKnownValue && $b.hasKnownValue) {
        if ($op.getText().equals(":*)")) {
          $value = $value * $b.value;
        } else {
          $value = $value / $b.value;
        }
      } else {
        $hasKnownValue = false;
      }
    }
    )*
  ;


// TO DO TOMORROW CHANGE INTEGER TO OBJECT AND ALLOW FOR OTHER DATA TYPES TO BE DETECTED.
//type checking goes here 
  factor returns [boolean hasKnownValue, Integer value]
  : INT 
      { 
        $hasKnownValue = true; 
        $value = Integer.parseInt($INT.getText());
      }
  | IDENT 
      {
        String id = $IDENT.getText();
        
        // Use lookupVariable instead of mainTable.table.get
        Identifier currentId = lookupVariable(id);
        
        if (currentId == null) {
          if (pendingLHS != null && !lhsExistedBefore && id.equals(pendingLHS)) {
            error($IDENT, "self-reference on first assignment of '" + pendingLHS + "'");
          } else {
            error($IDENT, "use of variable '" + id + "' before assignment");
          }
          $hasKnownValue = false;
        } else if(currentId.type != Type.INT){
          error($IDENT, id + "is not of type int");
        } else {
          currentId.hasBeenUsed = true;
          $hasKnownValue = currentId.hasKnown;
          Object val = currentId.value;
          if (val instanceof Integer) {
              $value = (Integer) val;
          } else if (val instanceof String) {
              $value = Integer.parseInt((String) val);
          } else {
              error($IDENT, "Unsupported type for arithmetic: " + val.getClass().getSimpleName());
              $hasKnownValue = false;
              $value = 0;
          }
        }
      }
  | '(' expr ')' 
      { 
        if ($expr.hasKnownValue) {
          $hasKnownValue = true;
          $value = $expr.value;
        } else {
          $hasKnownValue = false;
          $value = 0;
        }
      }
  ;

ifstmt : KW_IF 
  {
    SymbolTable ifScope = new SymbolTable();
    System.out.println("Debug: Pushing new symbol table for if");
    symbolStack.push(ifScope);
  }
  '(' expr ')' s 
  {
    symbolStack.pop();
    System.out.println("Debug: Popping symbol table for if");
  }
  (elsestmt)?
  ;

elsestmt : KW_ELSE_IF 
  {
    SymbolTable elseIfScope = new SymbolTable();
    System.out.println("Debug: Pushing new symbol table for else-if");
    symbolStack.push(elseIfScope);
  }
  '(' expr ')' s 
  {
    symbolStack.pop();
    System.out.println("Debug: Popping symbol table for else-if");
  }
  (elsestmt)?
  | KW_ELSE 
  {
    SymbolTable elseScope = new SymbolTable();
    System.out.println("Debug: Pushing new symbol table for else");
    symbolStack.push(elseScope);
  }
  s
  {
    symbolStack.pop();
    System.out.println("Debug: Popping symbol table for else");
  }
  ;

forstmt : KW_FOR '(' 
  {
    SymbolTable forScope = new SymbolTable();
    System.out.println("Debug: Pushing new symbol table for for-loop");
    symbolStack.push(forScope);
  }
  as ';' expr ';' as ')' s
  {
    symbolStack.pop();
    System.out.println("Debug: Popping symbol table for for-loop");
  }
  ;

whilestmt : KW_WHILE 
  {
    SymbolTable whileScope = new SymbolTable();
    System.out.println("Debug: Pushing new symbol table for while-loop");
    symbolStack.push(whileScope);
  }
  '(' expr ')' s
  {
    symbolStack.pop();
    System.out.println("Debug: Popping symbol table for while-loop");
  }
  ;

functionstmt : KW_FUNCTION name=IDENT '(' param=IDENT ')' 
  {
    // Store function definition
    FunctionDef func = new FunctionDef();
    func.name = $name.getText();
    func.paramName = $param.getText();
    functions.put(func.name, func);
    System.out.println("Debug: Defined function '" + func.name + "' with parameter '" + func.paramName + "'");
  }
  s
  | KW_FUNCTION name=IDENT '('')' 
  {
    // Store function definition
    FunctionDef func = new FunctionDef();
    func.name = $name.getText();
    func.paramName = null;
    functions.put(func.name, func);
    System.out.println("Debug: Defined function '" + func.name + "' with no parameters");
  }
  s
  ;

functioncall : IDENT '(' arg=expr ')'
  {
    String funcName = $IDENT.getText();
    if (!functions.containsKey(funcName)) {
      error($IDENT, "function '" + funcName + "' not defined");
    } else {
      FunctionDef func = functions.get(funcName);
      System.out.println("Debug: Calling function '" + funcName + "'");
      
      // Create new scope for function call
      SymbolTable funcScope = new SymbolTable();
      symbolStack.push(funcScope);
      
      // Add parameter with argument value if function has parameter
      if (func.paramName != null) {
        Identifier paramId = new Identifier();
        paramId.id = func.paramName;
        paramId.value = $arg.value;
        paramId.type = Type.INT;
        paramId.hasKnown = $arg.hasKnownValue;
        paramId.hasBeenUsed = false;
        addVariable(paramId);
        System.out.println("Debug: Set parameter '" + func.paramName + "' = " + $arg.value);
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
        System.out.println("Debug: Calling function '" + funcName + "'");
        
        // Create new scope for function call
        SymbolTable funcScope = new SymbolTable();
        symbolStack.push(funcScope);
      }
    }
  }
  ;

arraystmt : KW_ARRAY IDENT ':=)' '[' INT ']' s;

stringstmt : IDENT ':=)' STRING;

operators : ADD | SUBTRACT | MULTIPLY | DIVIDE;

comp : COMPARISON;