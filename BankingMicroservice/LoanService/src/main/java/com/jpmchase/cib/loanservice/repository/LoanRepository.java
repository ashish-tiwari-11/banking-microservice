package com.jpmchase.cib.loanservice.repository;

import com.jpmchase.cib.loanservice.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    Optional<Loan> findByLoanAcctNo(String loanAcctNo);

    Optional<List<Loan>> findByAcctNo(String acctNo);
}
