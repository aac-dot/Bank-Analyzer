import java.util.List;

/**
 * Create a model to extract the columns from the line.
 *
 * @author      Ayrton de Andrade
 * */
public interface BankStatementParser {
    /**
     * Parse a line to extract the columns
     *
     * @param line  The line to extract.
     * @return      A BankTransaction object.
     * @author      Ayrton de Andrade
     * */
    BankTransaction parseFrom(String line);

    /**
     * Create a list of BankTransaction objects.
     *
     * @param lines     A list of lines read from a file.
     * @return          A list of BankTransaction objects.
     * @author          Ayrton de Andrade
     * */
    List<BankTransaction> parseLinesFrom(List<String> lines);
}
