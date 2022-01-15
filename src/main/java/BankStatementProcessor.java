import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsible for the computations of transactions
 *
 * @author Ayrton de Andrade
 * */
public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    /**
     * Calculate de total amount of the transactions.
     *
     * @return  The total of amount.
     * @author  Ayrton de Andrade
     * */
    public double calculateTotalAmount() {
        double total = 0d;

        for (BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }

        return total;
    }

    /**
     * Calculate the total amount for a specified month.
     *
     * @param   month               The specified month for search the total amount.
     * @return                      A list of all transaction for the specified month.
     * @author                      Ayrton de Andrade
     * */
    public double calculateTotalInMonth(final Month month) {
        double totalAmount = 0;

        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                totalAmount += bankTransaction.getAmount();
            }
        }
        return totalAmount;
    }

    /**
     * Calculate the total amount for a specified category.
     *
     * @param   category            The specified category for search the transaction(s).
     * @return                      A list of all transaction for the specified category.
     * @author                      Ayrton de Andrade
     * */
    public double calculateTotalForCategory(final String category) {
        double totalAmount = 0;

        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDescription().equals(category)) {
                totalAmount += bankTransaction.getAmount();
            }
        }
        return totalAmount;
    }
}
