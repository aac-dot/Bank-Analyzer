import java.time.LocalDate;
import java.util.Objects;

/**
 * Domain class of bank transaction.
 * @author  Ayrton de Andrade
 * */
public class BankTransaction {
    private final LocalDate date;
    private final double amount;
    private final String description;

    public BankTransaction(final LocalDate date, final double amount, final String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, description);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        BankTransaction that = (BankTransaction) obj;

        // Se todos os valores dos atributos do objeto passado for igual aos objetos da classe,
        // então o obj é um BankTransaction.
        return Double.compare(that.amount, amount) == 0 &&
                date.equals(that.date) &&
                description.equals(that.description);
    }

    @Override
    public String toString() {

        return "BankTransaction {" +
                "date = " + date +
                ", amount = " + amount +
                ", description = '" + description + "'" + "}";
    }
}
