package com.atakanoguz.accspring.repository;

import com.atakanoguz.accspring.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
