package com.ing.customer.repository;
import org.springframework.data.repository.CrudRepository;

import com.ing.customer.bo.model.Customer;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;


public interface CustomerRepository extends CrudRepository<Customer, UUID> {

} 