package org.example.hw9bank.controllers;

import org.example.hw9bank.domains.Account;
import org.example.hw9bank.services.AccountService;
import org.example.hw9bank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AccountsController {
    private final AccountService accountService;
    private final UserService userService;

    public AccountsController(final AccountService accountService, UserService userService) {
        this.accountService = accountService;
        this.userService = userService;
    }

    @GetMapping("/accounts")
    public String accounts(Model model) {
        model.addAttribute("accounts", accountService.getAccounts());
        return "accounts";
    }

    @GetMapping("/topUp")
    public String topUp(Model model) {
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("accounts", accountService.getAccounts());
        return "topUp";
    }

    @GetMapping("/sendMoney")
    public String sendMoney(Model model) {
        return "sendMoney";
    }

    @GetMapping( "/getUserAcc" )
    @ResponseBody
    public List<Account> getAccountByIdAndCurrency(@RequestParam Long userId, @RequestParam String currency) {
        return accountService.getAccountByIdAndCurrency(userId, currency);
    }

    @PostMapping( "/topUp" )
    @ResponseBody
    public void topUpAcc(@RequestBody Account account) {

        accountService.updateAccount( account );

    }





}


