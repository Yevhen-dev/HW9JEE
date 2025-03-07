package org.example.hw9bank.domains;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.util.Set;

@Entity
@Table(name = "rates")
public class CurrencyRate {

    @Id
    @GeneratedValue
    @Column( name = "currency_id")
    private Long id;

    private String currency;

    private Double buy;

    private Double sell;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cr")
//    private Set<Account> accounts;

    public CurrencyRate() {
    }

    public CurrencyRate(String currency, Double buy, Double sell) {
        this.currency = currency;
        this.buy = buy;
        this.sell = sell;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getBuy() {
        return buy;
    }

    public void setBuy(Double buy) {
        this.buy = buy;
    }

    public Double getSell() {
        return sell;
    }

    public void setSell(Double sell) {
        this.sell = sell;
    }

//    public Set<Account> getAccounts() {
//        return accounts;
//    }
//
//    public void setAccounts(Set<Account> accounts) {
//        this.accounts = accounts;
//    }
}
