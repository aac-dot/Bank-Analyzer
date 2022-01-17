import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

/**
 * Responsible for open the file and decide which parser use.
 *
 * @author Ayrton de Andrade
 * */
public class BankStatementAnalyzer {
    private static final String RESOURCE = "src/main/resources/";

    /**
     * Open a file with for a specified parser
     *
     * @param   filename                The name of the file to open.
     * @param   bankStatementParser     The parser to the file.
     * @throws  IOException           If the file operations have any problem.
     * @author  Ayrton de Andrade
     */
    public void analyze(final String filename, BankStatementParser bankStatementParser) throws IOException {
        // Cria o caminho do arquivo do diretório RESOURCE.
        final Path path = Paths.get(RESOURCE + filename);
        final List<String> lines = Files.readAllLines(path);

        List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
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
        System.out.println("All the January's transactions: " + bankStatementProcessor.findTransactionInMonth(Month.JANUARY));
        System.out.println("All the transaction greater than 0: " + bankStatementProcessor.findTransactionGreaterThanEqual(0));

    }
}
