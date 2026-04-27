package models;

public class Transaction {
    private String currency;
    private int amount;

    public Transaction(String currency, int amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "currency='" + currency + '\'' +
                ", amount=" + amount +
                '}';
    }
}