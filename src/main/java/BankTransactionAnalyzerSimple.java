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

        System.out.println("The total for all transactions is " + calculateTotalAmount(bankTransactions));
        System.out.println("Transactions in January " + selectionInMonth(bankTransactions, Month.JANUARY));
    }

    /**
     * Search for a transaction from a specific month.
     *
     * @param bankTransactions      A list of all existence transactions.
     * @param month                 The month of the transaction(s).
     * @return                      A list of all transaction for the month.
     * @author                      Ayrton de Andrade
     * */
    private static List<BankTransaction> selectionInMonth(final List<BankTransaction> bankTransactions, final Month month) {
        List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();

        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                bankTransactionsInMonth.add(bankTransaction);
            }
        }
        return bankTransactionsInMonth;
    }

    /**
     * Calculate de total amount of the transactions.
     *
     * @param bankTransactions  A list of all transactions.
     * @return                  The total of amount.
     * @author                  Ayrton de Andrade
     * */
    private static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
        double total = 0d;

        for (BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }

        return total;
    }
    
    
}
