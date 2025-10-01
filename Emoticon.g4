grammar Emoticon;


@ header { import java.util.*; }


@ members {

  class Identifier {
    String id;
    float value;
    boolean hasKnown;
    boolean hasBeenUsed;
  }



  class SymbolTable {
    Map<String, Identifier> table = new HashMap<>();
  }
    Stack<SymbolTable> symbolStack = new Stack<>();
    SymbolTable mainTable = new SymbolTable();
    // for the variables that are assigned (self explanatory)
    Map<String, Object> assigned = new Hashtable<>();

    //used?
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
}



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
STRING : '\'' .*? '\'';
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
            newId.value = 0;
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