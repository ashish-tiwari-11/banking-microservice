package com.jpmchase.cib.loanservice.service;

import com.jpmchase.cib.loanservice.dto.LoanRequestResponseDTO;
import com.jpmchase.cib.loanservice.repository.LoanRepository;
import com.jpmchase.cib.loanservice.transformation.LoanRequestResponseTransformation;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    private final LoanRepository repository;

    private final LoanRequestResponseTransformation transform;

    public LoanService(LoanRepository repository, LoanRequestResponseTransformation transform) {
        this.repository = repository;
        this.transform = transform;
    }


    public String createAloanRequest(LoanRequestResponseDTO requestDTO) {
        return null;
    }

    public LoanRequestResponseDTO getLoanAcctNo(String loanAcctNo) {
        return null;
    }

    public LoanRequestResponseDTO getLoanByAccountNo(String acctNo) {
        return null;
    }
}
