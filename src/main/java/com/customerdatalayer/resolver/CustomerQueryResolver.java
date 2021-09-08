package com.customerdatalayer.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.customerdatalayer.dto.CustomerDTO;
import com.customerdatalayer.service.CustomerService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

@DgsComponent
public class CustomerQueryResolver {

	@Autowired
	CustomerService customerService;

	@DgsQuery
	public CustomerDTO customerById(@InputArgument int customerId) {

		return customerService.getCustomer(customerId);
	}

	@DgsQuery
	public List<CustomerDTO> firstNCustomers(@InputArgument Integer limit) {

		return customerService.getFirstNCustomers(limit);
	}

	@DgsQuery
	public List<CustomerDTO> customerDetails() {

		return customerService.getCustomers();
	}

}
