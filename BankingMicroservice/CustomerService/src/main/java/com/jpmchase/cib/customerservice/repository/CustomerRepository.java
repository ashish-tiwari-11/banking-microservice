package com.jpmchase.cib.customerservice.repository;

import com.jpmchase.cib.customerservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
