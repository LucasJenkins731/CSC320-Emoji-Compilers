import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;

public class TestDriver {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if (args.length > 0) inputFile = args[0];
        
        InputStream is = System.in;
        if (inputFile != null) {
            is = new FileInputStream(inputFile);
        }
        
        //ANTLRInputStream input = new ANTLRInputStream(is);
        CharStream input = CharStreams.fromStream(is);
        EmoticonLexer lexer = new EmoticonLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        EmoticonParser parser = new EmoticonParser(tokens);
        
        // This will execute your code generation
        ParseTree tree = parser.program();
        
        System.out.println("Parsing completed!");
    }
}