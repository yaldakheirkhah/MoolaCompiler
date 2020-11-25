package compiler;
import gen.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
/**
 * Created by yaldakheirkhah on 11/25/20.
 */
public class Compiler {
    public static void main(String[] args) throws IOException {
        CharStream stream = CharStreams.fromFileName("./sample/test.mla");
        MoolaLexer lexer = new MoolaLexer(stream);
        TokenStream token = new CommonTokenStream(lexer);
        MoolaParser parser = new MoolaParser(token);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.program();
        ParseTreeWalker walker = new ParseTreeWalker();
        MoolaListener listener = new ProgramPrinter();
        walker.walk(listener,tree);

    }
}
