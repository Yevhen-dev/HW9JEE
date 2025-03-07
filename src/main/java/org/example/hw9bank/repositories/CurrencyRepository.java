package org.example.hw9bank.repositories;

import org.example.hw9bank.domains.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CurrencyRepository extends JpaRepository<CurrencyRate, Long> {
}
