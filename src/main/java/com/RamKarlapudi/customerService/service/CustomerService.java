package com.RamKarlapudi.customerService.service;

import java.util.List;

import com.RamKarlapudi.customerService.entity.CustomerEntity;

public interface CustomerService {
	
	
	
	public List<CustomerEntity> getCustomerDetails();
	public List<CustomerEntity> getCustomerByOrderId();
	
	public CustomerEntity getCustomerById(Long id);
	public CustomerEntity updateCustomerById(CustomerEntity custEnt);
	

}
