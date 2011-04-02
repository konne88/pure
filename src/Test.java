import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

public class Test {
    public static void main(String[] args) throws Exception {
    	String[] tests = {
    		"1.12",
    		
    		"1+2+3.0",
    		
    		"hallo",
    		
    		"'hallo'",
    		
    		"\"hal\\\"lo\"",
    		
    		"'hallo' 'test'",
    		
    		"\"hallo\"\"test\"",
    		
    		"[1,2,3]",
    		
    		"{a:b}",
    		
    		"{a:[1,2],b:[1],c:[]}",
    		
			"hello {" +
			"	list : [1,2,3,4]" +
		  	"   ,12+3 : ++-.% &/peter  " +
		  	"   ,[1,2,33,4] : 4" +
		  	"   ,\"identi\" : \n value " +
		    "   ,12:[12,221,11], key: [" +
			"   	[], {}, [12], {key: value}" +
			"	]" +
			"   ,key:{a:2, b:3," +
			"     king:{'what':a, world:-31211.232e+1}," +
			"     endoffile:12+132" +
			"   }"+
			"}"
    	};
    	
    	for(String input : tests) {
	        PureLexer lex = new PureLexer(new ANTLRStringStream(
	        	input
	        ));
	       	CommonTokenStream tokens = new CommonTokenStream(lex);
	
	       	PureParser parser = new PureParser(tokens);
	
	        try {
	            System.out.println(parser.wrapper());
	        } catch (RecognitionException e)  {
	            e.printStackTrace();
	        }
    	}
    }
}
