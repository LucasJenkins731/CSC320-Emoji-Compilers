grammar Emoticon;

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

IDENT : [A-Za-z_][A-Za-z0-9_]*;
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
s : as | ps | expr | if | else | for | while | function | array | string;

as : IDENT ':=)' ( expr | KW_READ) ;
ps : KW_PRINT '(' expr ')' ;
if : KW_IF '(' expr ')' s 
   | KW_IF '(' expr ')' else ;

else : KW_ELSE_IF '(' expr ')' s else
    | KW_ELSE s ;

for : KW_FOR '(' as ';' expr ';' expr ')' s;

while : KW_WHILE '(' expr ')' s;

function : KW_FUNCTION IDENT '(' IDENT ')' s;

array : KW_ARRAY IDENT ':=)' '[' INT ']' s;

string : IDENT ':=)' STRING;


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