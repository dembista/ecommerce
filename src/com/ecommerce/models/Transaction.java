package models;

public class Transaction {
    private String currency;
    private int amount;
    private String userType;

    public Transaction(String currency, int amount, String userType) {
        this.currency = currency;
        this.amount = amount;
        this.userType = userType;
    }
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
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
