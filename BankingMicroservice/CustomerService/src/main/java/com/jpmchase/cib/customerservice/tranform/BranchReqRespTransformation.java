package com.jpmchase.cib.customerservice.tranform;

import com.jpmchase.cib.customerservice.dto.BranchResponseDTO;
import com.jpmchase.cib.customerservice.model.Branch;
import org.springframework.stereotype.Component;

@Component
public class BranchReqRespTransformation {

    public BranchResponseDTO fromEntityToResponseDTO(Branch branch) {
        BranchResponseDTO branchResponseDTO = new BranchResponseDTO();
        branchResponseDTO.setBranchCode(branch.getBranchCode());
        branchResponseDTO.setBranchAddress(branch.getBranchAddress());
        return branchResponseDTO;
    }
}
