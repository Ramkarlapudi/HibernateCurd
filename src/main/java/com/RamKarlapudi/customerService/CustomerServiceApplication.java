package com.RamKarlapudi.customerService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.RamKarlapudi.customerService.entity.CustomerEntity;
import com.RamKarlapudi.customerService.repository.CustomerRepository;

@SpringBootApplication
@ComponentScan({"com.RamKarlapudi.customerService"})
@EntityScan("com.RamKarlapudi.customerService.entity")
@EnableJpaRepositories("com.RamKarlapudi.customerService.repository")
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
