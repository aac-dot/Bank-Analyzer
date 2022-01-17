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
     * Display the information about a transaction based on lambda passed as argument.
     *
     * @param   bankTransactionSummarizer       The interface to summarize the information.
     * @return                                  The total amount of transaction.
     * @author                                  Ayrton de Andrade
     * */
    public double summarizeTransactions(final BankTransactionSummarizer bankTransactionSummarizer) {
        double result = 0;

        for (final BankTransaction bankTransaction : bankTransactions) {
            result = bankTransactionSummarizer.summarize(result, bankTransaction);
        }

        return result;
    }

    /**
     * Calculate de total amount of the transactions.
     *
     * @return  The total of amount.
     * @author  Ayrton de Andrade
     * */
    public double calculateTotalAmount() {
        return summarizeTransactions((aac, bankTransactions) ->
                bankTransactions.getAmount() + aac);
    }

    /**
     * Calculate the total amount for a specified month.
     *
     * @param   month               The specified month for search the total amount.
     * @return                      The total of the month's transaction.
     * @author                      Ayrton de Andrade
     * */
    public double calculateTotalInMonth(final Month month) {
        return summarizeTransactions((aac, bankTransactions) ->
                bankTransactions.getDate().getMonth() == month ? aac + bankTransactions.getAmount() : aac);
    }

    /**
     * Calculate the total amount for a specified category.
     *
     * @param   category            The specified category for search the transaction(s).
     * @return                      A list of all transaction for the specified category.
     * @author                      Ayrton de Andrade
     * */
    public double calculateTotalForCategory(final String category) {
        return summarizeTransactions((aac, bankTransactions) ->
                bankTransactions.getDescription().equals(category) ? aac + bankTransactions.getAmount() : aac);
    }

     /**
     * Find transactions with specified greater or equal amount.
     *
     * @param   amount  Amount to find.
     * @return          A list of all transactions with amount equal or higher than the amount passed.
     * @author          Ayrton de Andrade
     * */
    public List<BankTransaction> findTransactionGreaterThanEqual(final double amount) {
        return findTransactions(bankTransaction -> bankTransaction.getAmount() >= amount);
    }

    /**
     * Find transactions with specified month.
     *
     * @param   month   Month to find the transactions.
     * @return          A list of all transactions with the month passed.
     * @author          Ayrton de Andrade
     * */
    public List<BankTransaction> findTransactionInMonth(final Month month) {
       return findTransactions(bankTransaction -> bankTransaction.getDate().getMonth() == month);
    }

    /**
     * Find transactions with specified criteria.
     *
     * @param   bankTransactionFilter   The filter.
     * @return                          A list of all transactions with a specific criteria.
     * @author                          Ayrton de Andrade
     * */
    public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter) {
        final List<BankTransaction> result = new ArrayList<>();

        for (BankTransaction bankTransaction : bankTransactions) {
            if (bankTransactionFilter.test(bankTransaction)) {
                result.add(bankTransaction);
            }
        }

        return result;
    }

}
