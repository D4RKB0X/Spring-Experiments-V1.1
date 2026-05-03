package com.WC3.Bank_Of_Lodaeron.Services;

import com.WC3.Bank_Of_Lodaeron.Entities.Account;
import com.WC3.Bank_Of_Lodaeron.Entities.Transaction;
import com.WC3.Bank_Of_Lodaeron.Entities.TransactionType;
import com.WC3.Bank_Of_Lodaeron.Repositories.AccountRepository;
import com.WC3.Bank_Of_Lodaeron.Repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accRepo;
    private final TransactionRepository transRepo;

    public AccountService(AccountRepository accRepo, TransactionRepository transRepo) {
        this.accRepo = accRepo;
        this.transRepo = transRepo;
    }

    public Account createAccount(String name) {
        Account inputAcc = new Account();

        inputAcc.setName(name);
        inputAcc.setBalance(0.0);

        return accRepo.save(inputAcc);
    }

    public Account gainGold(Long id, double amount) {
        Account inputAcc = accRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found!"));

        inputAcc.setBalance(inputAcc.getBalance() + amount);
        accRepo.save(inputAcc);

        transRepo.save(new Transaction(TransactionType.DEPOSIT, amount, inputAcc));
        return inputAcc;
    }

    public Account spendGold(Long id, double amount) {
        Account inputAcc = accRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found!"));

        if(inputAcc.getBalance() < amount) {
            throw new RuntimeException("Not enough gold!");
        }

        inputAcc.setBalance(inputAcc.getBalance() - amount);
        accRepo.save(inputAcc);

        transRepo.save(new Transaction(TransactionType.WITHDRAWAL, amount, inputAcc));

        return inputAcc;
    }

    public List<Account> getAllAccounts() {
        return accRepo.findAll();
    }
}
