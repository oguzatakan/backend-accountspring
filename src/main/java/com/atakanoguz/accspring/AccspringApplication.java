package com.atakanoguz.accspring;

import com.atakanoguz.accspring.model.Customer;
import com.atakanoguz.accspring.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.util.HashSet;
import java.util.UUID;
import java.util.function.Supplier;

@SpringBootApplication
public class AccspringApplication implements CommandLineRunner {

	private final CustomerRepository customerRepository;

	public AccspringApplication(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AccspringApplication.class, args);
	}


	@Override
	public void run(String... args)throws Exception{
		Customer customer = customerRepository.save(new Customer("","Atakan", "Oğuz",new HashSet<>()));
		System.out.println(customer);
	}

}
