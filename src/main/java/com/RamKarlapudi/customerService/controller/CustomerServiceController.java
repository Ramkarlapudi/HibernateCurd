package com.RamKarlapudi.customerService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RamKarlapudi.customerService.entity.CustomerEntity;
import com.RamKarlapudi.customerService.service.CustomerService;
import com.RamKarlapudi.customerService.service.CustomerServiceImpl;

@RestController
@RequestMapping("/Customer")
public class CustomerServiceController {

	@Autowired(required = true)
	CustomerServiceImpl  customerServiceImpl ;
	
	@Autowired(required = true)
	CustomerService customerService;

	@GetMapping
	public String getCustomerName() {
		List<CustomerEntity> ce = new ArrayList<CustomerEntity>();
		ce = customerService.getCustomerDetails();
		return ce.get(0).getFirst_name();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable("id") Long id ) {
		CustomerEntity ce =   customerService.getCustomerById(id);
		return new ResponseEntity<CustomerEntity>(ce, new HttpHeaders(), HttpStatus.OK);	
		
		
		
	}

}
