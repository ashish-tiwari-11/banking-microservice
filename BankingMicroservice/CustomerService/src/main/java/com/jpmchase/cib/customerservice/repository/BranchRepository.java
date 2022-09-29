package com.jpmchase.cib.customerservice.repository;

import com.jpmchase.cib.customerservice.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}
