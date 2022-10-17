package com.jpmchase.cib.customerservice.controller;

import com.jpmchase.cib.customerservice.dto.BranchResponseDTO;
import com.jpmchase.cib.customerservice.dto.CustomerRequestDTO;
import com.jpmchase.cib.customerservice.dto.CustomerResponseDTO;
import com.jpmchase.cib.customerservice.model.Branch;
import com.jpmchase.cib.customerservice.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer/{custId}")
    public ResponseEntity<CustomerResponseDTO> getCustomerById(@PathVariable(value = "custId") String custId) {
        return new ResponseEntity<>(customerService.getCustomerById(Long.valueOf(custId)), HttpStatus.OK);
    }

    @GetMapping("/customer/{custId}/branch")
    public ResponseEntity<Branch> getBranchByBranchId(@PathVariable(value = "custId") Long custId) {
        return new ResponseEntity<>(customerService.getBranchByCustId(custId), HttpStatus.OK);
    }

    @GetMapping("/customer/all")
    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @PostMapping("/customer")
    public ResponseEntity<CustomerResponseDTO> saveCustomer(@RequestBody CustomerRequestDTO requestDTO) {
        return new ResponseEntity<>(customerService.saveCustomer(requestDTO), HttpStatus.OK);
    }

}
