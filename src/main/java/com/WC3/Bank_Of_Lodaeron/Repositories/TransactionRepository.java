package com.WC3.Bank_Of_Lodaeron.Repositories;

import com.WC3.Bank_Of_Lodaeron.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccount_Id(Long accountId);
}