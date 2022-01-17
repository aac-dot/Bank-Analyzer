import java.io.IOException;

/**
 * Main class for BankAnalyzer
 *
 * @author  Ayrton de Andrade
* */
public class BankTransactionAnalyzerSimple {


    public static void main(String... args) throws IOException {
        BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        BankStatementParser bankStatementParser = new BankStatementCSVParser();

        bankStatementAnalyzer.analyze(args[0], bankStatementParser);

    }
}
