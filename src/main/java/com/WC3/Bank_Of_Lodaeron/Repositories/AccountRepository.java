package com.WC3.Bank_Of_Lodaeron.Repositories;

import com.WC3.Bank_Of_Lodaeron.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {}