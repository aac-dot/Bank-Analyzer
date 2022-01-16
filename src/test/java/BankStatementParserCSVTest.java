import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankStatementParserCSVTest {
    private final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();

    @Test
    public void shouldParseOneCorrectLine() {
       final String transaction = "12-08-2022,10000,Bitcoin";

       // Resultado inicial
       BankTransaction result = bankStatementCSVParser.parseFrom(transaction);

       // Objecto com os valores que é esperado.
       BankTransaction expected = new BankTransaction(LocalDate.of(2022, Month.AUGUST, 12), 10000, "Bitcoin");

       // Tolerância mínima para a comparação de amount.
       final double tolerance = 0.0d;

       // Compara os resultados com a expectativas.
       assertEquals(expected.getDate(), result.getDate());
       assertEquals(expected.getAmount(), result.getAmount(), tolerance);
       assertEquals(expected.getDescription(), result.getDescription());
    }
}
