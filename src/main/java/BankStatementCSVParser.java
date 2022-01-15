import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsible for the CSV file extraction operation.
 * @author      Ayrton de Andrade
 */
public class BankStatementCSVParser {

    // Define o padrão da data.
    private static final DateTimeFormatter DATE_PATTERN =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");

    /**
     * Extrai os dados das colunas.
     *
     * @param line  current line to extract the columns.
     * @return      A BankTransaction object.
     * @author      Ayrton de Andrade
     */
    private BankTransaction parseFromCSV(final String line) {
        // O arquivo CSV trabalhado aqui é separado por virgula.
        final String[] colums = line.split(",");

        // Verifica se a data no arquivo está de acordo com o formato definido.
        final LocalDate date = LocalDate.parse(colums[0], DATE_PATTERN);

        // Extrai a parte decimal da linha que corresponde ao valor da transação.
        final double amount = Double.parseDouble(colums[1]);

        // Extrai a descrição de cada transação
        final String description = colums[2];

        return new BankTransaction(date, amount, description);
    }

    /**
     * Extrai as linhas do arquivo.
     *
     * @param   lines   set of lines.
     * @return          A list of all transaction ready for analyze.
     * @author          Ayrton de Andrade
     * */
    public List<BankTransaction> parseLineFromCSV(final List<String> lines) {
        final List<BankTransaction> bankTransactions = new ArrayList<BankTransaction>();

        for (final String line : lines) {
            bankTransactions.add(parseFromCSV(line));
        }

        return bankTransactions;
    }
}
