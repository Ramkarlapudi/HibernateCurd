package com.RamKarlapudi.customerService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RamKarlapudi.customerService.entity.CustomerEntity;
import com.RamKarlapudi.customerService.model.Customer;
import com.RamKarlapudi.customerService.repository.CustomerRepository;

@Service
public class CustomerServiceImpl  implements CustomerService{
	
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

	@Override
	public CustomerEntity  updateCustomerById(CustomerEntity customerEnt) {
		// TODO Auto-generated method stub
		Optional<CustomerEntity> customerEntity = CustomerRepository.findById(customerEnt.getCustomer_id());
		System.out.println(customerEntity.isPresent());
		System.out.println(customerEntity.get().getAddress());
		if(customerEntity.isPresent()) {
			
			CustomerEntity ce =  customerEntity.get();
			ce.setCustomer_id(customerEnt.getCustomer_id());
			ce.setFirst_name(customerEnt.getFirst_name());
			ce.setLast_name(customerEnt.getLast_name());
			ce.setEmail(customerEnt.getEmail());
			ce.setAddress(customerEnt.getAddress());
			ce.setState(customerEnt.getState());
			ce.setZip(customerEnt.getZip());
			ce.setCity(customerEnt.getCity());
			ce =  CustomerRepository.save(ce);
			
			 return ce ;
		}else {
			customerEnt = CustomerRepository.save(customerEnt);
			return customerEnt;
			
			
			
			
			
		}
		
	}

}
