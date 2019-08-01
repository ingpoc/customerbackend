package com.ing.customer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ing.customer.bo.model.Customer;
import com.ing.customer.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgileApplicationTests {
	  @Autowired
	    private TestEntityManager entityManager;
	 
	    @Autowired
	    private CustomerRepository customerRepository;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void addCustomerTest() {
	    // given
	    Customer alex = new Customer();
	    UUID uuid = UUID.randomUUID();
	    alex.setUUID(uuid);
	    alex.setName("alex");
	    alex.setSurName("Trumph");
	    alex.setEmail("alex_trumph@gmail.com");
	    entityManager.persist(alex);
	    entityManager.flush();

	    Optional<Customer> found = customerRepository.findById(uuid);
	    Boolean isCustomerPresent = found.isPresent();

	   System.out.println( assertThat(isCustomerPresent)
	      .isEqualTo(true));
	}
	@Test
	public void finfAllCustomerTest() {

	   List<Customer> found = (List<Customer>)customerRepository.findAll();

	   System.out.println( assertThat(found.size()>0)
	      .isEqualTo(true));
	}
}
