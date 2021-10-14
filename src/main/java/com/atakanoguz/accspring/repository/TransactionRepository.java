package com.atakanoguz.accspring.repository;

import com.atakanoguz.accspring.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
