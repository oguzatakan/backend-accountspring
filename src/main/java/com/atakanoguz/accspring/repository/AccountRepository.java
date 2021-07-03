package com.atakanoguz.accspring.repository;

import com.atakanoguz.accspring.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
