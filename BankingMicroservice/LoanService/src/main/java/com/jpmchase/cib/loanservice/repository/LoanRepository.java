package com.jpmchase.cib.loanservice.repository;

import com.jpmchase.cib.loanservice.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    Optional<Loan> findByLoanAcctNo(String loanAcctNo);

}
