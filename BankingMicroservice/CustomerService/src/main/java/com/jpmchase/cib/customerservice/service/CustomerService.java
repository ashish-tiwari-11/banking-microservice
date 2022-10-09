package com.jpmchase.cib.customerservice.service;

import com.jpmchase.cib.customerservice.dto.BranchResponseDTO;
import com.jpmchase.cib.customerservice.dto.CustomerRequestDTO;
import com.jpmchase.cib.customerservice.dto.CustomerResponseDTO;
import com.jpmchase.cib.customerservice.model.Branch;
import com.jpmchase.cib.customerservice.model.Customer;
import com.jpmchase.cib.customerservice.repository.CustomerRepository;
import com.jpmchase.cib.customerservice.tranform.BranchReqRespTransformation;
import com.jpmchase.cib.customerservice.tranform.CustomerRequestResponseTransformation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final BranchService branchService;
    private final CustomerRequestResponseTransformation transformation;
    private final BranchReqRespTransformation branchReqRespTransformationm;

    public CustomerService(CustomerRepository customerRepository, BranchService branchService, CustomerRequestResponseTransformation transformation, BranchReqRespTransformation branchReqRespTransformationm) {
        this.customerRepository = customerRepository;
        this.branchService = branchService;
        this.transformation = transformation;
        this.branchReqRespTransformationm = branchReqRespTransformationm;
    }

    @Transactional
    public Customer getCustomer(Long custId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(custId);
        return optionalCustomer.isPresent() ? optionalCustomer.get() : null;
    }


    public CustomerResponseDTO getCustomerById(Long custId) {
        Customer customer = getCustomer(custId);
        return Objects.nonNull(customer) ? transformation.fromEntityToResponseDTO(customer) : null;
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

    @Transactional
    public Branch getBranchByCustId(Long custId) {
        return getCustomer(custId).getBranch();
    }
}
