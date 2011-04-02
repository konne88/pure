grammar Pure;

tokens {
	PLUS 	= '+' ;
	MINUS	= '-' ;
	MULT	= '*' ;
	DIV	= '/' ;
}

@members {

}

object
/*

    : explicit_object
    | expression
    ;
/*
expression
    : explicit_object expression
    | explicit_object explicit_object
    ;

explicit_object
*/

  //  : '{' map_items '}'
  //  | '[' list_items ']'
  //  | '(' object ')'
  //  | '{' '}'
  //  | '[' ']'
    : identifier
    | number
  //  | string
  //  | chars
    | token
    ;

/*
map_items
    : map_item ',' map_items
    | map_item
    ;

map_item
    : object ':' object
    ;

list_items
    : object ',' list_items
    | object
    ;

*/
token
    : '+'
    | '-'
    | '*'
    | '/'
    | '|'
    | '&'
    | '$'
    | '@'
    | '%'
    | '\\'
    | '^'
    | '<'
    | '>'
    | '!'
    | '?'
    | '.'
    | '='
    | ';'
    | '~'
    | '`'
    ;

identifier : ALPHANUM(ALPHANUM|digit)* ;
number     : ('1'..'9'digit*|'0')('.'digit+) ;
//string     : '"'('\\"'|.)*'"' ;
//chars      : '\''('\\\''|.)*'\'' ;
  
whitespace : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ 	{ $channel = HIDDEN; } ;

fragment ALPHANUM : ('a'..'z'|'A'..'Z'|'_') ;
fragment digit	  : ('0'..'9');