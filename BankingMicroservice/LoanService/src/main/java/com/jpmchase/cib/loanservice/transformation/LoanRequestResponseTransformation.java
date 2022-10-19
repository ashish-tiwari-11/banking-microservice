package com.jpmchase.cib.loanservice.transformation;

import com.jpmchase.cib.loanservice.dto.LoanRequestResponseDTO;
import com.jpmchase.cib.loanservice.model.Loan;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class LoanRequestResponseTransformation {

    public Loan transfromLoanReqRespDTOToModel(LoanRequestResponseDTO requestDTO) {
        Loan loanAcct = new Loan();
        if(Objects.nonNull(requestDTO)){

        }
        return loanAcct;
    }


}
