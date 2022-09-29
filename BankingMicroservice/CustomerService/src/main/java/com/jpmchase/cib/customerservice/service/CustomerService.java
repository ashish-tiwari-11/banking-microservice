package com.jpmchase.cib.customerservice.service;

import com.jpmchase.cib.customerservice.dto.CustomerRequestDTO;
import com.jpmchase.cib.customerservice.dto.CustomerResponseDTO;
import com.jpmchase.cib.customerservice.model.Branch;
import com.jpmchase.cib.customerservice.model.Customer;
import com.jpmchase.cib.customerservice.repository.CustomerRepository;
import com.jpmchase.cib.customerservice.tranform.CustomerRequestResponseTransformation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final BranchService branchService;
    private final CustomerRequestResponseTransformation transformation;

    public CustomerService(CustomerRepository customerRepository, BranchService branchService, CustomerRequestResponseTransformation transformation) {
        this.customerRepository = customerRepository;
        this.branchService = branchService;
        this.transformation = transformation;
    }

    @Transactional
    public CustomerResponseDTO getCustomerById(Long custId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(custId);
        return optionalCustomer.isPresent()
                ? transformation.fromEntityToResponseDTO(optionalCustomer.get())
                : null;
    }

    @Transactional
    public List<CustomerResponseDTO> getAllCustomers() {
        return customerRepository
                .findAll()
                .stream()
                .map(cust -> transformation.fromEntityToResponseDTO(cust))
                .collect(Collectors.toList());
    }

    @Transactional
    public CustomerResponseDTO saveCustomer(CustomerRequestDTO requestDTO) {
        Branch branch = branchService.getBranchById(requestDTO.getBranchId());
        requestDTO.setBranch(branch);
        Customer customer = customerRepository.saveAndFlush(transformation.fromRequestDTOtoEntity(requestDTO));
        return transformation.fromEntityToResponseDTO(customer);
    }
}
