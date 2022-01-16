import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * Main class for BankAnalyzer
 * @author  Ayrton de Andrade
* */
public class BankTransactionAnalyzerSimple {


    public static void main(String... args) throws IOException {
        BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        BankStatementParser bankStatementParser = new BankStatementCSVParser();

        bankStatementAnalyzer.analyze(args[0], bankStatementParser);
    }
}
