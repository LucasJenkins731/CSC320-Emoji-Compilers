grammar Emoticon;


@ header { import java.util.*; }

@ members {
    // for the variables that are assigned (self explanatory)
    set<string> assigned = new hashTable<>();

    //used?
    set<string> used = new hashTable<>();
    // diagnostics
    set<string> diagnostics = new hashTable<>();
    // lhs stuff
    String pendingLHS = null;
    // error stuff
    boolean lhsExistedBefore = false;
    
    void error(Token t, String msg) {
        diagnostics.add("line " + t.getLine() + ":" + t.getCharPositionInLine() + " " + msg);
    }

    void printDiagnostics() {
      // After parsing the whole file: report unused variables and print errors.
      for (String v : assigned) {
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
LBRACE : '{';
RBRACE : '}';


//GRAMMAR
//program : s+ EOF;

 program  : s+ EOF;
s : as | ps | expr | ifstmt | elsestmt | forstmt | whilestmt | functionstmt | arraystmt | stringstmt;

as : IDENT ':=)' ( expr | KW_READ) ;
ps : KW_PRINT '(' expr ')' ;
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


op : ADD | SUBTRACT | MULTIPLY | DIVIDE;

comp : COMPARISON;

expr : INT 
    | IDENT 
    | '(' expr ')' 
    | expr op expr
    | expr comp expr
    ;

    



// expr : term ( ('+'|'-') term )? ;
// term : factor ( ('*'|'/') factor )? ;
// factor : INT | IDENT | '(' expr ')' ;