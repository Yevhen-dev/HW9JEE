package org.example.hw9bank.repositories;

import org.example.hw9bank.domains.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT acc FROM Account acc WHERE acc.user.id = :userId AND acc.currency = :currency")
    List<Account> getAccountByIdAndCurrency(Long userId, String currency);

}
