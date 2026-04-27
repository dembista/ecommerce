import java.math.BigDecimal;

public class Transaction {
   // private final String id;
    private final Money amount;
    private final String currency;

    public Transaction(String currency, Money amount) {
      //  this.id = id;

        this.currency = currency;
        this.amount = amount;
    }

    public Money setMoney(Money amount) {
        return amount;
    }

    public String setCurrency() {
        return currency;
    }

    public Money getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}
