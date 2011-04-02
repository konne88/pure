grammar Pure;

@header {
  import java.util.Map;
  import java.util.List;
  import java.util.HashMap;
  import java.util.ArrayList;
  import org.pure.model.*;
  import org.pure.model.impl.*;
}

@members {

}

// Lexer

wrapper returns [PureObject value]
    : o=object {$value = $o.value;}
    ;

object returns [PureObject value]
    : o=explicit_object {$value = $o.object;}
      (e=explicit_object {
        if($value instanceof PureExpression){
          ((PureExpression)$value).add($e.object);
        }
        else {
          $value = new PureExpressionImpl($value,$e.object);
        }
      })*
    ;

explicit_object returns [PureObject object]
    : '(' o=object ')'      {$object = $o.value;}
    | '{' m=map_items '}'   {$object = new PureMapImpl($m.map);}
    | '[' l=list_items ']'  {$object = new PureListImpl($l.list);}
    | '{' '}'               {$object = new PureMapImpl();}
    | '[' ']'               {$object = new PureListImpl();}
    | v=IDENTIFIER          {$object = new PureIdentifierImpl($v.text);}
    | v=NUMBER              {$object = new PureNumberImpl($v.text);}
    | v=STRING              {$object = new PureStringImpl($v.text);}
    | v=CHARS               {$object = new PureCharsImpl($v.text);}
    | v=TOKEN               {$object = new PureTokenImpl($v.text);}
    ;

map_items returns [Map map] @init{ map = new HashMap(); }
    : a=object ':' b=object { $map.put($a.value,$b.value); }
      (',' k=object ':' v=object {
        if($map.put($k.value,$v.value)!= null){
          // multiple entries with same key
          throw new RecognitionException();
        }
      } )*
    ;

list_items returns [List list] @init{ list = new ArrayList(); }
	  : f=object { $list.add($f.value); } 
	    (',' v=object { $list.add($v.value); } )*
	  ;

// Parser

TOKEN
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

IDENTIFIER : ALPHANUM(ALPHANUM|DIGIT)* ;

NUMBER     : ('1'..'9'DIGIT*|'0')('.'DIGIT+)? ;
STRING     : '"'('\\"'|~('"'|'\n'|'\r'))*'"' ;
CHARS      : '\''('\\\''|~('\''|'\n'|'\r'))*'\'' ;
  
WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ 	{ $channel = HIDDEN; } ;

fragment ALPHANUM : ('a'..'z'|'A'..'Z'|'_') ;
fragment DIGIT	  : ('0'..'9');