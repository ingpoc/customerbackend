package com.env.agile;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.env.agile.model.Customer;
import com.env.agile.repository.CustomerRepository;

@RestController

public class UserController {
	
	
	
	@Autowired
	CustomerRepository customerRepository;
	
	/*
	 * @PostMapping("/signup")
	 * 
	 * @CrossOrigin(origins = "http://localhost:4200") public UserToken
	 * signup(@RequestBody User registerUser) { System.out.println("signup method");
	 * User user = this.userRepository.findUserByEmail(registerUser.getEmail());
	 * UserToken _token = new UserToken(); if(user == null) { user = new User();
	 * user.setEmail(registerUser.getEmail()); user.setActive(true);
	 * user.setPassword(registerUser.getPassword()); this.userRepository.save(user);
	 * _token.setEmail(registerUser.getEmail());
	 * _token.set_token(UUID.randomUUID());
	 * _token.setMessage("User has been signed up"); return _token; }else {
	 * _token.setEmail(registerUser.getEmail()); _token.set_token(null);
	 * _token.setMessage("User already exists!"); return _token; }
	 * 
	 * }
	 * 
	 * @PostMapping("/login")
	 * 
	 * @CrossOrigin(origins = "http://localhost:4200") public UserToken
	 * login(@RequestBody User registerUser) { System.out.println("login method");
	 * User user = this.userRepository.login(registerUser); UserToken _token = new
	 * UserToken(); if(user != null) { _token.setEmail(registerUser.getEmail());
	 * _token.set_token(UUID.randomUUID());
	 * _token.setMessage("User login successful"); return _token; }else {
	 * _token.setEmail(registerUser.getEmail()); _token.set_token(null);
	 * _token.setMessage("No such user exists!"); return _token; }
	 * 
	 * }
	 */
	
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
			return customerRepository.save(customer);	
		}

}
