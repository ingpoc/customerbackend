package com.env.agile;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.env.agile.model.Accounts;
import com.env.agile.model.Customer;
import com.env.agile.repository.CustomerRepository;

@RestController

public class UserController {
	
	
	
	@Autowired
	CustomerRepository customerRepository;
	
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

}
