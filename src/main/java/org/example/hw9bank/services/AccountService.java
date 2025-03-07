package org.example.hw9bank.services;

import org.example.hw9bank.domains.Account;
import org.example.hw9bank.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void addAccount(Account account) {
        accountRepository.save(account);
    }

    @Transactional
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Transactional
    public List<Account> getAccountByIdAndCurrency( Long userId, String currency ) {
        return accountRepository.getAccountByIdAndCurrency( userId, currency );
    }

    @Transactional
    public void updateAccount(Account account) {
        accountRepository.save(account);

    }
}

