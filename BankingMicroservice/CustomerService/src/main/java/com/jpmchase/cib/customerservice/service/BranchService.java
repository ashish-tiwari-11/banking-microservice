package com.jpmchase.cib.customerservice.service;

import com.jpmchase.cib.customerservice.dto.BranchResponseDTO;
import com.jpmchase.cib.customerservice.model.Branch;
import com.jpmchase.cib.customerservice.repository.BranchRepository;
import com.jpmchase.cib.customerservice.tranform.BranchReqRespTransformation;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BranchService {

    private final BranchRepository branchRepository;
    private final BranchReqRespTransformation transformation;

    public BranchService(BranchRepository branchRepository, BranchReqRespTransformation transformation) {
        this.branchRepository = branchRepository;
        this.transformation = transformation;
    }

    public Branch getBranchById(Long branchId) {
        Optional<Branch> branchOptional = branchRepository.findById(branchId);
        return branchOptional.isPresent() ? branchOptional.get() : null;
    }

    public BranchResponseDTO getBranchResponseDTO(Long branchId){
        return transformation.fromEntityToResponseDTO(getBranchById(branchId));
    }
}
