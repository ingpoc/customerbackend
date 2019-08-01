package com.ing.customer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ing.customer.bo.model.Accounts;
import com.ing.customer.bo.model.Customer;
import com.ing.customer.repository.AccountsRepository;
import com.ing.customer.repository.CustomerRepository;

@RestController

public class CustomerController {
	
	
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AccountsRepository accountsRepository;
	
	@GetMapping("/customer")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Customer> getCustomer() {
		
			return (List<Customer>) customerRepository.findAll();	
		}
	
	
	/*
	 * @RequestMapping( value = "/save", method = RequestMethod.POST, consumes =
	 * "text/plain")
	 */
	@PostMapping("/save")
	@CrossOrigin(origins = "http://localhost:4200")
	public Customer saveCustomer(@RequestBody Customer customer) {
			customer.setUUID(UUID.randomUUID());
			System.out.println("Save Customer");
		
		  for(Accounts account: customer.getAccounts()) {
		  account.setCustomer(customer); }
		 
			return customerRepository.save(customer);	
		}
	
	@PostMapping("/createAccount")
	@CrossOrigin(origins = "http://localhost:4200")
	public Customer createAccount(@RequestBody Customer customer, @RequestBody Accounts account, Double savingBalance ) {
			
			System.out.println("Create Customer Accounts"); 
						
			Double prevBalance = account.getBalance();			
			Double total = prevBalance - savingBalance;
			account.setBalance(total);
			
			List<Accounts> updatedaccounts = new ArrayList<Accounts>();			
			updatedaccounts.add(account);
			
			Accounts savingAccounts = new Accounts();
						
			savingAccounts.setBalance(savingBalance);
			savingAccounts.setProductType("SAVINGS");
			savingAccounts.setCurrency(account.getCurrency());
			updatedaccounts.add(savingAccounts);
			customer.setAccounts(updatedaccounts);
			return 	customerRepository.save(customer);
		}

}
