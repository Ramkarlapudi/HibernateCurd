package com.RamKarlapudi.customerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.RamKarlapudi.customerService.entity.CustomerEntity;

@EnableJpaRepositories
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {

}
