package com.RamKarlapudi.customerService.service;

import java.util.List;

import com.RamKarlapudi.customerService.model.Customer;

public interface CustomerServiceImpl {
	
	public List<Customer> getCustomerDetails();
	public List<Customer> getCustomerByOrderId();

}
