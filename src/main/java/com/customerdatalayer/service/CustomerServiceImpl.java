package com.customerdatalayer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerdatalayer.dto.CustomerDTO;
import com.customerdatalayer.dto.CustomerInputDTO;
import com.customerdatalayer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<CustomerDTO> getCustomers() {
		return customerRepository.getCustomers();
	}

	@Override
	public CustomerDTO createCustomer(CustomerInputDTO customerInputDTO) {
		return customerRepository.createCustomer(customerInputDTO);
	}


	@Override
	public List<CustomerDTO> getFirstNCustomers(int limit) {
		return customerRepository.getFirstNCustomers(limit);
	}

	@Override
	public CustomerDTO getCustomer(int id) {
		return customerRepository.getCustomer(id);
	}

}
