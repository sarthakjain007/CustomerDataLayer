package com.customerdatalayer.resolver;

import org.springframework.beans.factory.annotation.Autowired;

import com.customerdatalayer.dto.CustomerDTO;
import com.customerdatalayer.dto.CustomerInputDTO;
import com.customerdatalayer.service.CustomerService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;

@DgsComponent
public class CustomerMutationResolver {

	@Autowired
	CustomerService customerService;

	@DgsMutation
	public CustomerDTO createCustomer(
			@InputArgument CustomerInputDTO customerInputDTO) {
		return customerService.createCustomer(customerInputDTO);
	}

}