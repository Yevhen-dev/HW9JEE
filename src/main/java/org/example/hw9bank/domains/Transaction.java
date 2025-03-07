package org.example.hw9bank.domains;

import jakarta.persistence.*;

@Entity
@Table( name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue
    @Column(name = "transaction_id")
    private Long id;

    private String amount;

    private String currency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "account_id")
    private Account account;

    public Transaction() {
    }

    public Transaction(String amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
