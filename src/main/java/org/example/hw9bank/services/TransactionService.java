package org.example.hw9bank.services;

import org.example.hw9bank.domains.Transaction;
import org.example.hw9bank.repositories.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository tr;


    public TransactionService(TransactionRepository tr) {
        this.tr = tr;
    }

    @Transactional
    public void addTransaction(Transaction t) {
        tr.save(t);
    }

    @Transactional
    public List<Transaction> getTransactions() {
        return tr.findAll();
    }


}
