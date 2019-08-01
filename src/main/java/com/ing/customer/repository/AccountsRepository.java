package com.ing.customer.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.ing.customer.bo.model.Accounts;

public interface AccountsRepository extends CrudRepository<Accounts, UUID>{

}
