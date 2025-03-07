package org.example.hw9bank.domains;

public class TransactionForCreate {

    private String amount;

    private String currency;

    private Long userId;

    public TransactionForCreate() {
    }

    public TransactionForCreate(String amount, String currency, Long userId) {
        this.amount = amount;
        this.currency = currency;
        this.userId = userId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
