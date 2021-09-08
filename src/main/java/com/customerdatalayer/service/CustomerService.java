package com.customerdatalayer.service;

import java.util.List;

import com.customerdatalayer.dto.CustomerDTO;
import com.customerdatalayer.dto.CustomerInputDTO;

public interface CustomerService {

	public List<CustomerDTO> getCustomers();

	public CustomerDTO createCustomer(CustomerInputDTO customerInputDTO);

	public List<CustomerDTO> getFirstNCustomers(int limit);
	
	public CustomerDTO getCustomer(int customerId);

}
