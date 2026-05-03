package com.WC3.Bank_Of_Lodaeron.Controllers;

import com.WC3.Bank_Of_Lodaeron.Entities.Transaction;
import com.WC3.Bank_Of_Lodaeron.Repositories.TransactionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {
    private final TransactionRepository transRepo;

    public HistoryController(TransactionRepository transRepo) {
        this.transRepo = transRepo;
    }

    @GetMapping("/{id}")
    public List<Transaction> getLedger(@PathVariable Long id) {
        return transRepo.findByAccount_Id(id);
    }
}
