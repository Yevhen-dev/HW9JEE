package org.example.hw9bank.repositories;

import org.example.hw9bank.domains.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
