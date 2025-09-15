grammar Emoticon;

//Keywords
KW_READ : '-0-0-';
KW_PRINT : ':P';
KW_IF : ':)';
KW_ELSE : ':(';
KW_ELSE_IF : ':|';


//Other tokens

IDENT : [A-Za-z_][A-Za-z0-9_]*;
ADD : ':+)';
SUBTRACT : ':-)';
MULTIPLY : ':*)';
DIVIDE : ':/)';
INT : ('+'|'-')? ('0'|[1-9][0-9]*);
WS : [ \t\r\n]+ -> skip;
LPAREN : '(';
RPAREN : ')';
COMMENT : '<3'~[\n\r]* -> skip;
COMMENT_BLOCK : 'OWO'[.*]'UWU' -> skip;
COMPARISON : ':==)';
ASSIGNMENT : ':=)';


//GRAMMAR
//program : s+ EOF;

 program  : s+ EOF;
s : as | ps | expr ;

as : IDENT ':=)' ( expr | KW_READ) ;
ps : KW_PRINT '(' expr ')' ;
if : KW_IF '(' expr ')' s;

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