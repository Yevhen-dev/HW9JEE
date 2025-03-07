package org.example.hw9bank.controllers;

import org.example.hw9bank.domains.Account;
import org.example.hw9bank.domains.Transaction;
import org.example.hw9bank.domains.TransactionForCreate;
import org.example.hw9bank.repositories.AccountRepository;
import org.example.hw9bank.repositories.TransactionRepository;
import org.example.hw9bank.services.AccountService;
import org.example.hw9bank.services.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TransactionController {
    private final TransactionService transactionService;
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionController(final TransactionService transactionService, TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionService = transactionService;
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @GetMapping("/transactions")
    public String showAllTransactions(Model model) {

        model.addAttribute("transactions", transactionService.getTransactions());

        return "transactions";
    }

    @PostMapping( "/createTransaction" )
    @ResponseBody
    public void createTransaction(@RequestBody TransactionForCreate transactionForCreate) {

        List<Account> accounts = accountRepository.getAccountByIdAndCurrency(transactionForCreate.getUserId(), transactionForCreate.getCurrency());

        Transaction transaction = new Transaction();
        transaction.setAmount(transactionForCreate.getAmount());
        transaction.setCurrency(transactionForCreate.getCurrency());
        transaction.setAccount(accounts.get(0));


        transactionService.addTransaction(transaction);

    }
}
