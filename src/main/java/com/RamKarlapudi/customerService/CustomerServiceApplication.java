package com.RamKarlapudi.customerService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.RamKarlapudi.customerService.entity.CustomerEntity;
import com.RamKarlapudi.customerService.model.Customer;
import com.RamKarlapudi.customerService.repository.CustomerRepository;

@SpringBootApplication
public class CustomerServiceApplication implements CommandLineRunner {

	@Autowired
	CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		 Optional<CustomerEntity> cm =  customerRepository.findById((long) 1);
		System.out.println(cm.get().getEmail()); 

	}

}
