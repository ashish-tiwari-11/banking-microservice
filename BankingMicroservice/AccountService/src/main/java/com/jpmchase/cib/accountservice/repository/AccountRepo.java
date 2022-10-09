package com.jpmchase.cib.accountservice.repository;

import com.jpmchase.cib.accountservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

    Optional<Account> findByAccountNo(String acctNo);

}
