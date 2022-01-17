
/**
 * Reporting the information about the transactions
 *
 * @author Ayrton de Andrade
 * */
@FunctionalInterface
public interface BankTransactionSummarizer {

    /**
     * Display a report about a transaction amount.
     *
     * @param accumulator       Hold the sum of the amount
     * @param bankTransaction   A transaction to report
     * @return                  The total amount.
     * */
    double summarize(double accumulator, BankTransaction bankTransaction);
}
