package org.example.hw9bank.services;

import org.example.hw9bank.domains.CurrencyRate;
import org.example.hw9bank.repositories.CurrencyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CurrencyRateService {

    private final CurrencyRepository currencyRepository;

    public CurrencyRateService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Transactional
    public void addCurrencyRate(CurrencyRate currencyRate) {
        currencyRepository.save(currencyRate);
    }

    @Transactional
    public List<CurrencyRate> getAllCurrencyRates() {
        return currencyRepository.findAll();
    }
}
