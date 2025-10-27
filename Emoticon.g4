grammar Emoticon;

@header { import java.util.*; import org.antlr.v4.runtime.*; import org.antlr.v4.runtime.tree.*; }

@members {

  enum Type {
    INT, FLOAT, STRING, CHAR, UNKNOWN
  }

  class ExprResult {
    Type type;
    float numericalValue;
    String stringValue;
    boolean hasKnownValue;

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
  
  // LHS tracking
  String pendingLHS = null;
  boolean lhsExistedBefore = false;
  
  // Error tracking
  boolean hasErrors = false;
  
  boolean definingFunction = false;
  int functionDefDepth = 0;

  void error(Token t, String msg) {
    diagnostics.add("line " + t.getLine() + ":" + t.getCharPositionInLine() + " " + msg);
    hasErrors = true;
  }

  void printDiagnostics() {    
    if (!diagnostics.isEmpty()) {
      for (String d : diagnostics) {
        System.err.println(d);
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
          foundUnused = true;
        }
        System.err.println(entry.getKey() + " declared but never used");
      }
    }
  }
//[+-]?[0-9]*.[0-9]+
//"('+'|'-')? ('0'|[1-9][0-9]*) '.' ('0'|[1-9][0-9]*)"
  Type typeCheck(String text) {
    Type varType = Type.UNKNOWN;
    if (text.matches("[+-]?(0|[1-9][0-9]*)")) {
      varType = Type.INT;
    } else if (text.matches("[+-]?[0-9]*.[0-9]+")){
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
  
  // Execute declared function
  void executeStatement(ParserRuleContext ctx) {
    if (ctx == null) {
      return;
    }
    
    // Check statmenet type and execute
    if (ctx instanceof EmoticonParser.AsContext) {
      executeAssignment((EmoticonParser.AsContext) ctx);
    } else if (ctx instanceof EmoticonParser.PsContext) {
      executePrint((EmoticonParser.PsContext) ctx);
    } else if (ctx instanceof EmoticonParser.BlockStatementContext) {
      executeBlock((EmoticonParser.BlockStatementContext) ctx);
    } else if (ctx instanceof EmoticonParser.IfstmtContext) {
      executeIf((EmoticonParser.IfstmtContext) ctx);
    } else if (ctx instanceof EmoticonParser.SContext) {
      EmoticonParser.SContext sCtx = (EmoticonParser.SContext) ctx;
      if (sCtx.as() != null) {
        executeAssignment(sCtx.as());
      } else if (sCtx.ps() != null) {
        executePrint(sCtx.ps());
      } else if (sCtx.blockStatement() != null) {
        executeBlock(sCtx.blockStatement());
      } else if (sCtx.ifstmt() != null) {
        executeIf(sCtx.ifstmt());
      }
    }
  }
  
  void executeAssignment(EmoticonParser.AsContext ctx) {
    String varName = ctx.IDENT().getText();

    if (ctx.expr() != null) {
      Integer value = evaluateExpr(ctx.expr());
      
      Identifier newId = new Identifier();
      newId.id = varName;
      newId.value = value;
      newId.type = typeCheck(String.valueOf(value));
      newId.hasKnown = (value != null);
      newId.hasBeenUsed = false;
      
      addVariable(newId);
      System.out.println(varName + " = " + value);
    } else if (ctx.KW_READ() != null) {
      Identifier newId = new Identifier();
      newId.id = varName;
      newId.value = 0;
      newId.type = Type.INT;
      newId.hasKnown = false;
      newId.hasBeenUsed = false;
      addVariable(newId);
    }
  }
  
  void executePrint(EmoticonParser.PsContext ctx) {
    Integer value = evaluateExpr(ctx.expr());
    if (value != null) {
      System.out.println(value);
    }
  }
  
  void executeBlock(EmoticonParser.BlockStatementContext ctx) {
    SymbolTable blockScope = new SymbolTable();
    symbolStack.push(blockScope);
    
    for (EmoticonParser.SContext stmt : ctx.s()) {
      executeStatement(stmt);
    }
    
    symbolStack.pop();
  }
  
  void executeIf(EmoticonParser.IfstmtContext ctx) {
    SymbolTable ifScope = new SymbolTable();
    symbolStack.push(ifScope);
    
    executeStatement(ctx.s());
    
    symbolStack.pop();
  }
  
  Integer evaluateExpr(EmoticonParser.ExprContext ctx) {
    if (ctx == null) return null;
    Integer value = evaluateTerm(ctx.term(0));
    if (value == null) return null;
    for (int i = 1; i < ctx.term().size(); i++) {
      Integer nextValue = evaluateTerm(ctx.term(i));
      if (nextValue == null) return null;
      String op = ctx.getChild(i * 2 - 1).getText();
      if (op.equals(":+)")) {
        value = value + nextValue;
      } else if (op.equals(":-)")) {
        value = value - nextValue;
      }
    }
    
    return value;
  }
  
  Integer evaluateTerm(EmoticonParser.TermContext ctx) {
    if (ctx == null) return null;
    
    // Get first factor
    Integer value = evaluateFactor(ctx.factor(0));
    if (value == null) return null;
    
    // Process other factors with operators
    for (int i = 1; i < ctx.factor().size(); i++) {
      Integer nextValue = evaluateFactor(ctx.factor(i));
      if (nextValue == null) return null;
      
      String op = ctx.getChild(i * 2 - 1).getText(); // Get operator
      if (op.equals(":*)")) {
        value = value * nextValue;
      } else if (op.equals(":/)")) {
        if (nextValue == 0) {
          return null;
        }
        value = value / nextValue;
      }
    }
    
    return value;
  }
  
  Integer evaluateFactor(EmoticonParser.FactorContext ctx) {
    if (ctx == null) return null;
    
    // Check if it's an INT literal
    if (ctx.INT() != null) {
      return Integer.parseInt(ctx.INT().getText());
    }
    
    // Check if it's an IDENT (variable)
    if (ctx.IDENT() != null) {
      String varName = ctx.IDENT().getText();
      Identifier id = lookupVariable(varName);
      if (id != null && id.value instanceof Integer) {
        id.hasBeenUsed = true;
        return (Integer) id.value;
      }
      return null;
    }
    
    // Check if it's a parenthesized expression
    if (ctx.expr() != null) {
      return evaluateExpr(ctx.expr());
    }
    
    return null;
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
FLOAT : [+-]?[0-9]*.[0-9]+;
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
  : IDENT ':=)' 
    (
      expr
      {
        if (!definingFunction) {
        pendingLHS = $IDENT.getText();
        // Check if it exists in ANY scope
        Identifier existing = lookupVariable(pendingLHS);
        lhsExistedBefore = (existing != null);
      }
      if (!definingFunction) {
              Identifier newId = new Identifier();
              newId.id = pendingLHS;
              if($expr.result.type == Type.INT || $expr.result.type == Type.FLOAT){
              newId.value = $expr.result.numericalValue;
              } else {
                newId.value = $expr.result.stringlValue;
              }
              //TYPE CHECK HERE
              newId.type = typeCheck(String.valueOf(newId.value));
              System.out.println(pendingLHS + " = " + String.valueOf(newId.value) + " (" + "Type = " + newId.type + ")");
              newId.hasKnown = $expr.result.hasKnownValue;
              newId.hasBeenUsed = false;
              
              // Add to CURRENT scope
              addVariable(newId);
              
              pendingLHS = null;
            }
      }
    |
      KW_READ
      {
        Identifier newId = new Identifier();
        newId.id = $IDENT.getText();
        newId.value = 0;
        newId.type = Type.INT;
        addVariable(newId);
        System.out.println(newId.value + "(" + "Type = " + newId.type + ")");
      }
    |
      STRING
      {
        Identifier newId = new Identifier();
        newId.id = $IDENT.getText();
        newId.value = $STRING.getText();
        newId.type = Type.STRING;
        addVariable(newId);
        System.out.println(newId.value + "(" + "Type = " + newId.type + ")");
      }
    |
      CHAR
      {
        Identifier newId = new Identifier();
        newId.id = $IDENT.getText();
        newId.value = $CHAR.getText();
        newId.type = Type.CHAR;
        addVariable(newId);
        System.out.println(newId.value + "(" + "Type = " + newId.type + ")");
      }
    |
      FLOAT
      {
        Identifier newId = new Identifier();
        newId.id = $IDENT.getText();
        newId.value = $FLOAT.getText();
        newId.type = Type.FLOAT;
        addVariable(newId);
        System.out.println(newId.value + "(" + "Type = " + newId.type + ")");
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
    }
;

expr returns [ExprResult result]
  : a=term
    {
      ExprResult resultA = a.result;
      $result = a.result;
    }
    ( op=(ADD|SUBTRACT) b=factor
      {
        ExprResult resultB = b.result;
          if((resultA.type == Type.INT || resultA.type == Type.FLOAT)){
            if(resultB.type == Type.INT || resultB.type == Type.FLOAT){
              if($op.getText().equals(":+)")){
                resultA.numericalValue += resultB.numericalValue;
              } else {
                resultA.numericalValue -= resultB.numericalValue;
              }
              $result.numericalValue = resultA.numericalValue;
            } else {
              error($op, "cannot do arithmetic on non-numerical types");
              $result.hasKnownValue = false;
            }
          } else if(resultB.type == Type.STRING || resultB.type == Type.CHAR){
            if($op.getText().equals(":+)")){
              $result.stringValue = resultA.stringValue + resultB.stringValue;
            } else {
            error($op, "cannot subtract strings");
            $result.HasKnownValue = false;
          }
        } else {
          error($op, "unknown type");
          $result.hasKnownValue = false;
        }
      }
    )*
  ;

term returns [ExprResult result]
  : a=factor
    {
      ExprResult resultA = a.result;
      $result = a.result;
    }
    ( op=(MULTIPLY|DIVIDE) b=factor
      {
        ExprResult resultB = b.result;
        if(resultA.type == Type.INT || resultA.type == Type.FLOAT){
          if(resultB.type == Type.INT || resultB.type == Type.FLOAT){
            //now do math
            if(resultB.numericalValue == 0 && $op.getText().equals(":/)")){
              error($op, "division by zero");
            } else if($op.getText().equals(":*)")){
              resultA.numericalValue *= resultB.numericalValue;
            } else {
              resultA.numericalValue /= resultB.numericalValue;
            }
            $result.numericalValue = resultA.numericalValue;
            if(resultA.type == Type.FLOAT || resultB.type || Type.FLOAT){
              $result.type == Type.FLOAT;
            } else {
              $result.type == Type.INT;
            }
          } else {
            error($op, "cannot do arithmetic on non-numeric types");
            $result.hasKnownValue = false;
          }
        } else {
          error($op, "cannot do arithmetic on non-numeric types");
            $result.hasKnownValue = false;
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
    }
  | FLOAT
    {
      $result = new ExprResult();
      $result.type = Type.FLOAT;
      $result.numericalValue = Float.parseFloat($FLOAT.getText());
      $result.hasKnownValue = true;
    }
  | CHAR
    {
      $result = new ExprResult();
      $result.type = Type.CHAR;
      $result.stringValue = $CHAR.getText().charAt(0);
      $result.hasKnownValue = true;
    }
  | STRING
    {
      $result = new ExprResult();
      $result.type = Type.STRING;
      $result.stringValue = $STRING.getText();
      $result.hasKnownValue = true;
    }
  | IDENT
    {
      String id = $IDENT.getText();
      Identifier var = lookupVariable(id);
      $result = new ExprResult();

      if(var == null){
        error(id, "variable is not yet defined");
      } else {
        $result.type = var.type;
        $result.hasKnownValue = var.hasKnown;
        if(var.type == Type.INT || var.type == Type.FLOAT){
          if(var.value instanceof Integer){
            $result.numericalValue = (Integer)var.value;
          } else {
            $result.numericalValue = (Float)var.value;
          }
        } else{
            $result.stringValue = (String)var.value;
        }
      }
    }
  | '(' expr ')' 
    {
      $result = $expr.result;
    }
  ;

ifstmt : KW_IF 
  {
    if (!definingFunction) {
      SymbolTable ifScope = new SymbolTable();
      symbolStack.push(ifScope);
    }
  }
  '(' expr ')' s 
  {
    if (!definingFunction) {
      symbolStack.pop();
    }
  }
  (elsestmt)?
  ;

elsestmt : KW_ELSE_IF 
  {
    if (!definingFunction) {
      SymbolTable elseIfScope = new SymbolTable();
      symbolStack.push(elseIfScope);
    }
  }
  '(' expr ')' s 
  {
    if (!definingFunction) {
      symbolStack.pop();
    }
  }
  (elsestmt)?
  | KW_ELSE 
  {
    if (!definingFunction) {
      SymbolTable elseScope = new SymbolTable();
      symbolStack.push(elseScope);
    }
  }
  s
  {
    if (!definingFunction) {
      symbolStack.pop();
    }
  }
  ;

forstmt : KW_FOR '(' 
  {
    if (!definingFunction) {
      SymbolTable forScope = new SymbolTable();
      symbolStack.push(forScope);
    }
  }
  as ';' expr ';' as ')' s
  {
    if (!definingFunction) {
      symbolStack.pop();
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
      System.out.println("Calling function '" + funcName + "' with argument " + $arg.result.value);
      
      // Create new scope for function call
      SymbolTable funcScope = new SymbolTable();
      symbolStack.push(funcScope);
      
      // Add parameter with argument value if function has parameter
      if (func.paramName != null) {
        Identifier paramId = new Identifier();
        paramId.id = func.paramName;
        paramId.value = $arg.result.value;
        paramId.type = Type.INT;
        paramId.hasKnown = $arg.result.hasKnownValue;
        paramId.hasBeenUsed = false;
        addVariable(paramId);
      }
      if (func.body != null) {
        executeStatement(func.body);
      }
      symbolStack.pop();
      System.out.println("Function '" + funcName + "' executed");
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
        SymbolTable funcScope = new SymbolTable();
        symbolStack.push(funcScope);
        if (func.body != null) {
          executeStatement(func.body);
        }
        symbolStack.pop();
        System.out.println("Function '" + funcName + "' executed");
      }
    }
  }
  ;

arraystmt : KW_ARRAY IDENT ':=)' '[' INT ']' s;

//stringstmt : IDENT ':=)' STRING;

operators : ADD | SUBTRACT | MULTIPLY | DIVIDE;

comp : COMPARISON;