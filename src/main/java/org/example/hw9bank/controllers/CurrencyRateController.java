package org.example.hw9bank.controllers;

import org.example.hw9bank.services.CurrencyRateService;
import org.example.hw9bank.services.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CurrencyRateController {
    private final CurrencyRateService currencyRateService;

    public CurrencyRateController(final CurrencyRateService currencyRateService) {
        this.currencyRateService = currencyRateService;
    }

//    @GetMapping("/rates")
//    public String accounts(Model model) {
//        model.addAttribute("rates", currencyRateService.getAllCurrencyRates());
//        return "accounts";
//    }
}