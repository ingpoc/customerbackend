package com.env.agile.repository;
import org.springframework.data.repository.CrudRepository;

import com.env.agile.model.Customer;

import java.util.List;
import java.util.UUID;


public interface CustomerRepository extends CrudRepository<Customer, UUID> {

} 