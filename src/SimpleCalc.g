grammar SimpleCalc;

tokens {
	PLUS 	= '+' ;
	MINUS	= '-' ;
	MULT	= '*' ;
	DIV	= '/' ;
}

@members {
    public static void main(String[] args) throws Exception {
        SimpleCalcLexer lex = new SimpleCalcLexer(new ANTLRStringStream("7-3*5+2"));
       	CommonTokenStream tokens = new CommonTokenStream(lex);

        SimpleCalcParser parser = new SimpleCalcParser(tokens);

        try {
            System.out.println(parser.expr());
        } catch (RecognitionException e)  {
            e.printStackTrace();
        }
    }
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

all returns [int value]
    : expr  {$value=$expr.value;};

expr  returns [int value]
    : a=expr (o=( PLUS | MINUS ) b=term)?  {$value = $o==null ? $a.value:$o.getType() == PLUS?
                                                                         $a.value + $b.value:
                                                                         $a.value - $b.value;};
    
term  returns [int value]
    : a=factor (o=( DIV | MULT ) b=term)?  {$value = $o==null ? $a.value:$o.getType() == MULT?
                                                                         $a.value * $b.value:
                                                                         $a.value / $b.value;};
        
factor returns [int value]	
    : NUMBER { $value=Integer.valueOf($NUMBER.getText());};


/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/

NUMBER	: (DIGIT)+ ;

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ 	{ $channel = HIDDEN; } ;

fragment DIGIT	: '0'..'9' ;