package com.customerdatalayer.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.customerdatalayer.dto.AddressDTO;
import com.customerdatalayer.dto.CustomerDTO;
import com.customerdatalayer.dto.CustomerInputDTO;

@Component
public class CustomerRepository{
	
	public static List<CustomerDTO> customersData = new ArrayList<CustomerDTO>();
	public static Long customerId = 1l;
	static {
		AddressDTO address1  = new AddressDTO(1l, "Rohini", "New Delhi", "New Delhi", "New Delhi", 110007, new Date().toString());
		AddressDTO address2 = new AddressDTO(2l, "Malad", "Malad", "Mumbai", "Maharashtra", 414141, new Date().toString());
		AddressDTO address3 = new AddressDTO(2l, "Andheri", "Andheri", "Mumbai", "Maharashtra", 414141, new Date().toString());
		CustomerDTO customer1 = new CustomerDTO(customerId++,"Raj","Kumar","raj.kuamr","11",new Date().toString(),Arrays.asList(address1,address2));
		CustomerDTO customer2 = new CustomerDTO(customerId++,"Dilip","Kumar","dilip.kuamr","12",new Date().toString(),Arrays.asList(address2,address3));
		CustomerDTO customer3 = new CustomerDTO(customerId++,"Vivek","Kumar","vivek.kuamr","13",new Date().toString(),Arrays.asList(address1,address3));
		customersData.add(customer1);
		customersData.add(customer2);
		customersData.add(customer3);
	}

	public List<CustomerDTO> getCustomers() {
		return customersData;
	}

	public CustomerDTO createCustomer(CustomerInputDTO customerInputDTO) {
		CustomerDTO customer = new CustomerDTO(customerId++,customerInputDTO.getFirstName(),customerInputDTO.getLastName(),
				customerInputDTO.getEmail(),customerInputDTO.getPhoneNumber(),new Date().toString(),null);
		customersData.add(customer);
		return customer;
		
	}

	public List<CustomerDTO> getFirstNCustomers(int limit) {
		return customersData.stream().limit(limit).collect(Collectors.toList());		
	}

	public CustomerDTO getCustomer(int id) {
		return customersData.stream().filter(t->t.getCustomerId()==id).findFirst().orElse(null);
	}
}
