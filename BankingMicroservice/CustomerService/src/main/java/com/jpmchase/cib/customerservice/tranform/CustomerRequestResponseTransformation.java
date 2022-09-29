package com.jpmchase.cib.customerservice.tranform;

import com.jpmchase.cib.customerservice.dto.CustomerRequestDTO;
import com.jpmchase.cib.customerservice.dto.CustomerResponseDTO;
import com.jpmchase.cib.customerservice.model.Customer;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CustomerRequestResponseTransformation {

    private final BranchReqRespTransformation transformation;

    public CustomerRequestResponseTransformation(BranchReqRespTransformation transformation) {
        this.transformation = transformation;
    }

    public CustomerResponseDTO fromEntityToResponseDTO(Customer customer) {
        CustomerResponseDTO responseDTO = new CustomerResponseDTO();
        responseDTO.setCustId(customer.getCustId());
        responseDTO.setCustFname(customer.getCustFname());
        responseDTO.setCustLname(customer.getCustLname());
        responseDTO.setCustEmail(customer.getCustEmail());
        responseDTO.setCustMobile(customer.getCustMobile());
        responseDTO.setCustCreationDT(customer.getCustCreationDT());
        responseDTO.setBranchResponseDTO(transformation.fromEntityToResponseDTO(customer.getBranch()));
        return responseDTO;
    }

    public Customer fromRequestDTOtoEntity(CustomerRequestDTO requestDTO) {
        Customer customer = new Customer();
        customer.setCustFname(requestDTO.getCustFname());
        customer.setCustLname(requestDTO.getCustLname());
        customer.setCustEmail(requestDTO.getCustEmail());
        customer.setCustMobile(requestDTO.getCustMobile());
        customer.setCustCreationDT(LocalDateTime.now());
        customer.setBranch(requestDTO.getBranch());
        return customer;
    }
}
