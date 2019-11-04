package com.RamKarlapudi.customerService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RamKarlapudi.customerService.entity.CustomerEntity;
import com.RamKarlapudi.customerService.repository.CustomerRepository;

@Service
public class CustomerService  implements CustomerServiceImpl{
	
	@Autowired
	CustomerRepository CustomerRepository;

	@Override
	public List<CustomerEntity> getCustomerDetails() {
		List<CustomerEntity>  CustomerEntity = new ArrayList<CustomerEntity>();
		CustomerEntity =CustomerRepository.findAll();
		System.out.println(" customer name " + CustomerEntity.get(0).getFirst_name());
		return CustomerEntity;
	}

	@Override
	public List<CustomerEntity> getCustomerByOrderId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerEntity getCustomerById(Long id ) 
	{
		
		Optional<CustomerEntity>  customer =CustomerRepository.findById(id);
		System.out.println(customer.get().getLast_name());
		if (customer.isPresent()) {
			return customer.get();
		} else {
			System.out.println("Record not found");
	 

		}
		return customer.get();
	
		
		
	}

}
