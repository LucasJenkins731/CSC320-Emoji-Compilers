import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class TestDriver {

    public static void main(String[] args) throws Exception {

        if (args.length == 0) {
            System.err.println("Usage: java TestDriver <sourcefile>");
            return;
        }

         String inputFile = args[0];

        // Input .calc or your source file
        String fileName = new File(inputFile).getName();
        String outputFile = fileName.replaceAll("\\.[^.]+$", "") + ".asm";

        // Load file into ANTLR
        InputStream input = new FileInputStream(inputFile);
        CharStream chars = CharStreams.fromStream(input);

        // Lex + parse
        EmoticonLexer lexer = new EmoticonLexer(chars);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        EmoticonParser parser = new EmoticonParser(tokens);

        // Run the grammar
        parser.program();

        // Your grammar now has the final output in parser.asm
        String asmCode = parser.asm.toString();

        // Write it to .asm file
        Files.writeString(Path.of(outputFile), asmCode);

        System.out.println("Assembly written to: " + outputFile);
    }
}
