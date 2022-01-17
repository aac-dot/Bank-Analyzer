
/**
 * Responsible for the selection logic.
 *
 * @author      Ayrton de Andrade
 * */
@FunctionalInterface
public interface BankTransactionFilter {

    /**
     *
     * @param   bankTransaction     Filter a transaction based on some criteria.
     * */
    boolean test(BankTransaction bankTransaction);
}