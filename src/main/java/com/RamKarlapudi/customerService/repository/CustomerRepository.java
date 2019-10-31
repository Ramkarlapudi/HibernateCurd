package com.RamKarlapudi.customerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RamKarlapudi.customerService.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {

}
