package com.RamKarlapudi.customerService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RamKarlapudi.customerService.entity.CustomerEntity;
import com.RamKarlapudi.customerService.service.CustomerService;
import com.RamKarlapudi.customerService.service.CustomerServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Customer")
@Api(value = "Customer Resource API")
public class CustomerServiceController {

	@Autowired(required = true)
	CustomerService  customerService ;
	
	@Autowired(required = true)
	CustomerServiceImpl customerServiceImpl;
	

	@ApiOperation(value = "Return All Customer Details")
	@GetMapping("/getAllCustomers")
	public List<CustomerEntity> getCustomerName() {
		List<CustomerEntity> ce = new ArrayList<CustomerEntity>();
		ce = customerServiceImpl.getCustomerDetails();
		return  ce;
	}
	
	
	@ApiOperation(value = "Return particular Customer Details Based on ID  ")
	@GetMapping("/{id}")
	public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable("id") Long id ) {
		CustomerEntity ce =   customerServiceImpl.getCustomerById(id);
		customerServiceImpl.updateCustomerById(ce);
		return new ResponseEntity<CustomerEntity>(ce, new HttpHeaders(), HttpStatus.OK);	
		
		
		
	}
	@ApiOperation(value = "Update the  Customer Details  Based on ID")
	@PostMapping("/update")
	public ResponseEntity<CustomerEntity> updateCustomerById(@RequestBody  CustomerEntity Customerentity ) {
		CustomerEntity updatedentity = customerServiceImpl.updateCustomerById(Customerentity);
		return new ResponseEntity<CustomerEntity>(updatedentity, new HttpHeaders(), HttpStatus.OK);
		
	}
	
	/*
	 * @PutMapping() public ResponseEntity<CustomerEntity>
	 * UpdateCustomerById(@RequestBody CustomerEntity Customerentity ) {
	 * CustomerEntity ce = customerServiceImpl.updateCustomerById(Customerentity);
	 * return new ResponseEntity<CustomerEntity>(ce, new HttpHeaders(),
	 * HttpStatus.OK);
	 * 
	 * }
	 */

	

}
