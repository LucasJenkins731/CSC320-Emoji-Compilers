grammar Emoticon;


@ header { import java.util.*; }


@ members {

  enum Type {
    INT, STRING, CHAR
  }

  class Identifier {
    String id;
    Object value; //This line should be an object since we dont know its type can vary.
    Type type; //Type of the value
    boolean hasKnown; // is the variable known when calling it i think
    boolean hasBeenUsed; // used for error checks for if the variable has been used.
  }

  class SymbolTable {
    Map<String, Identifier> table = new HashMap<>();
  }
  SymbolTable mainTable = new SymbolTable();

    Stack<SymbolTable> symbolStack = new Stack<>(); // I feel like a linked list might work better here. stack seems weird.
    //WE SHOULD MAKE THE DATATYPE INSIDE THE 'STACK' A DATATYPE THAT HAS A .CONTAINS OR .HAS METHOD. THIS WAY WE CAN CALL THIS METHOD ON THE ARRAY/DATASTRUCTURE AS A WHOLE
    //THIS WILL SAVE A LOT OF TIME AND EFFORT WITH NESTED FOR LOOPS.
    //linked list will probably work best for this.
    
    // for the variables that are assigned (self explanatory) SHOULD DEPRECIATE THIS
    Map<String, Object> assigned = new Hashtable<>();

    //used? SHOULD DEPRECIATE THIS
    Set<String> used = new HashSet<>();
    // diagnostics
    List<String> diagnostics = new ArrayList<>();
    // lhs stuff
    String pendingLHS = null;
    // error stuff
    boolean lhsExistedBefore = false;
    
    void error(Token t, String msg) {
        diagnostics.add("line " + t.getLine() + ":" + t.getCharPositionInLine() + " " + msg);
    }

    void printDiagnostics() {
      // After parsing the whole file: report unused variables and print errors.
      for (String v : assigned.keySet()) {
        if (!used.contains(v)) {
          System.err.println("warning: variable '" + v + "' assigned but never used");
        }
      }
      for (String d : diagnostics) {
        System.err.println("error: " + d);
      }
    }

//SHOULD BE CALLED IN ASSIGNMENT STATEMENT AND WHEN CALLING VARIABLES.
//NVM WHEN CALLING VARIABLES WE SHOULD BE SAVING THE TYPE OF THE VARIABLE IN THE IDENTIFIER CLASS AND THEREFORE DONT NEED TO DO THAT.
    void typeCheck(String text) {
      if (text.matches(INT)) {
        Type varType = Type.INT;
      } else if (text.matches(CHAR)){
        Type varType = Type.CHAR;
      }
      
      else if (text.matches(STRING)) {
        Type varType = Type.STRING;
      }
      return varType;
    }
}


// make a symbol stack look through method here CHANNELS
//should recursively move through the linked list until either the value is found or we reach the end of the linked list. (next is null)


//Keywords

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
// <.)))><
KW_INT : 'int';
KW_STRING : 'string';
KW_CHAR : 'char';



//Other tokens
IDENT : [A-Za-z][A-Za-z0-9_]* | [_][A-Za-z0-9_]+;
ADD : ':+)';
SUBTRACT : ':-)';
MULTIPLY : ':*)';
DIVIDE : ':/)';
INT : ('+'|'-')? ('0'|[1-9][0-9]*);
CHAR : ('\''|'"') . ('\''|'"');
STRING : ('\''|'"') .*? ('\''|'"');
WS : [ \t\r\n]+ -> skip;
LPAREN : '(';
RPAREN : ')';
COMMENT : '<3'~[\n\r]* -> skip;
COMMENT_BLOCK : 'OWO' .*? 'UWU' -> skip;
COMPARISON : ':==)';
ASSIGNMENT : ':=)';



//GRAMMAR

program  : 
  {
    SymbolTable globalSymbolTable = new SymbolTable();
  }
  s+ EOF;

s : as | ps | expr | arraystmt | stringstmt | blockStatement | ifstmt | forstmt | whilestmt | functionstmt ;

blockStatement : LBRACE
   {  
     SymbolTable currentSymbolTable = new SymbolTable();
     System.out.println("DEBUG: Pushing new symbol table");
     symbolStack.push(currentSymbolTable); 
   } 
  (s)* RBRACE 
  { 
    symbolStack.pop();
    System.out.println("DEBUG: Popping symbol table");
  } 
  ;


 

as

  : IDENT 
    {
      // We're entering an assignment: record LHS and whether it existed before.
      pendingLHS = $IDENT.getText();
      lhsExistedBefore = mainTable.table.containsKey(pendingLHS);
    }
    ':=)' ( expr 
          {
            // Successful RHS parse: consider variable now assigned.
            
            Identifier newId = new Identifier();
            newId.id = pendingLHS;
            newId.value = $expr.value;
            //TYPE CHECK HERE
            newId.type = typeCheck(newId.value);
            newId.hasKnown = $expr.hasKnownValue;
            newId.hasBeenUsed = false;
            mainTable.table.put(newId.id, newId);
            assigned.put(pendingLHS, newId.value);

            // Clear LHS context.
            pendingLHS = null;
          }
        | KW_READ
          {
            // Successful RHS parse: consider variable now assigned.
            
            Identifier newId = new Identifier();
            newId.id = pendingLHS;
            newId.value = 0; //??????? MAYBE READING HASNT BEEN PROPERLY IMPLEMENTED AT THIS TIME
            newId.hasKnown = false;
            newId.hasBeenUsed = false;
            mainTable.table.put(newId.id, newId);
            assigned.put(pendingLHS, newId.value);

            // Clear LHS context.
            pendingLHS = null;
          }
        ) 
  ;
    

ps : KW_PRINT '(' expr ')' 
    {
      if ($expr.hasKnownValue) {
        // Let us print it out (for debugging purposes really)
        System.out.println("DEBUG: Line " + $KW_PRINT.getLine() + ": Printing known value: " + $expr.value);
      } else {
        System.out.println("DEBUG: Line " + $KW_PRINT.getLine() + ": Can't print this value. Need to evaluate further.");
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
expr returns [boolean hasKnownValue, float value]
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

    term returns [boolean hasKnownValue, float value]
  : a=factor 
    {
      if ($a.hasKnownValue) {
        $hasKnownValue = true;
        $value = $a.value;
      } else $hasKnownValue = false;

    }
  ( op=(MULTIPLY|DIVIDE) b=factor
    {
        // First check for division by zero when b has value 0 (and /).
        if ($b.hasKnownValue && $op.getText().equals(":/)") && $b.value == 0) {
          error($op, "division by zero");
          $hasKnownValue = false;  // Error anyway so stopping there
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

//type checking goes here 
  factor returns [boolean hasKnownValue, float value]
  : INT 
      { 
        $hasKnownValue = true; $value = Integer.parseInt($INT.getText());
        
        
         }
  | IDENT 
      {
        String id = $IDENT.getText();
        used.add(id);

        Identifier currentId = mainTable.table.get(id);
        if (currentId == null) {
          // Variable used before declaration error
          if (pendingLHS != null && !lhsExistedBefore && id.equals(pendingLHS)) {
            error($IDENT, "self-reference on first assignment of '" + pendingLHS + "'");
          } else {
            error($IDENT, "use of variable '" + id + "' before assignment");
          }
          $hasKnownValue = false;
        } else if(id.getClass() == Integer.class){
          error($IDENT, id + "is not of type int");
        } else {
          currentId.hasBeenUsed = true;
          $hasKnownValue = currentId.hasKnown;
          $value = currentId.value;
        }
      }
  | '(' expr ')' 
      { 
        if ($expr.hasKnownValue) {
          $hasKnownValue = true;
          $value = $expr.value;
        } else {
          $hasKnownValue = false;
        }
      }
  ;







ifstmt : KW_IF '(' expr ')' s 
   | KW_IF '(' expr ')' elsestmt ;

elsestmt : KW_ELSE_IF '(' expr ')' s elsestmt
         | KW_ELSE s ;

forstmt : KW_FOR '(' as ';' expr ';' as ')' s;

whilestmt : KW_WHILE '(' expr ')' s;

functionstmt : KW_FUNCTION IDENT '(' IDENT ')' s
             | KW_FUNCTION IDENT '('')' s;

arraystmt : KW_ARRAY IDENT ':=)' '[' INT ']' s;

stringstmt : IDENT ':=)' STRING;


operators : ADD | SUBTRACT | MULTIPLY | DIVIDE;

comp : COMPARISON;






// expr : term ( ('+'|'-') term )? ;
// term : factor ( ('*'|'/') factor )? ;
// factor : INT | IDENT | '(' expr ')' ;