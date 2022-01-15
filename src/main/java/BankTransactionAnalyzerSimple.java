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
    private static final String RESOURCE = "src/main/resources/";

    public static void main(String... args) throws IOException {
        // Cria o caminho do arquivo do diretório RESOURCE.
        final Path path = Paths.get(RESOURCE + args[0]);
        final List<String> lines = Files.readAllLines(path);

        BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

        // Extrai as transações do arquivo CSV.
        List<BankTransaction> bankTransactions = bankStatementParser.parseLineFromCSV(lines);

        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    /**
     * Display a report of the transactions.
     *
     * @param   bankStatementProcessor      The calculated transactions
     * @author  Ayrton de Andrade
    * */
    private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transactions: " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for all transactions in January: " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total salary received: " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}
