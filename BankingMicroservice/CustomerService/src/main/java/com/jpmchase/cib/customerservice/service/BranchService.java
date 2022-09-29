package com.jpmchase.cib.customerservice.service;

import com.jpmchase.cib.customerservice.model.Branch;
import com.jpmchase.cib.customerservice.repository.BranchRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BranchService {

    private final BranchRepository branchRepository;

    public BranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    public Branch getBranchById(Long branchId) {
        Optional<Branch> branchOptional = branchRepository.findById(branchId);
        return branchOptional.isPresent() ? branchOptional.get() : null;
    }
}
