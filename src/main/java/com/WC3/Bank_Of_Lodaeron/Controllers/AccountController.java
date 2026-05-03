package com.WC3.Bank_Of_Lodaeron.Controllers;

import com.WC3.Bank_Of_Lodaeron.Entities.Account;
import com.WC3.Bank_Of_Lodaeron.Services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accService;

    public AccountController(AccountService accService) {
        this.accService = accService;
    }

    @PostMapping
    public Account createAccount(@RequestBody Account inputAcc) {
        return accService.createAccount(inputAcc.getName());
    }

    @PostMapping("/{id}/gain-gold")
    public Account gainGold(@PathVariable Long id, @RequestParam double amount) {
        return accService.gainGold(id, amount);
    }

    @PostMapping("/{id}/spend-gold")
    public Account spendGold(@PathVariable Long id, @RequestParam double amount) {
        return accService.spendGold(id, amount);
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accService.getAllAccounts();
    }
}