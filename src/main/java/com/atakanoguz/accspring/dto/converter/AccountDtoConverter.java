package com.atakanoguz.accspring.dto.converter;

import com.atakanoguz.accspring.dto.AccountDto;
import com.atakanoguz.accspring.dto.TransactionDto;
import com.atakanoguz.accspring.model.Account;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AccountDtoConverter {

    private final CustomerDtoConverter customerDtoConverter;
    private final TransactionDtoConvertor transactionDtoConverter;

    public AccountDtoConverter(CustomerDtoConverter customerDtoConverter,
                               TransactionDtoConvertor transactionDtoConverter){
        this.customerDtoConverter = customerDtoConverter;
        this.transactionDtoConverter = transactionDtoConverter;
    }

    public AccountDto convert(Account from) {

        return new AccountDto(
                from.getId(),
                from.getBalance(),
                from.getCreationDate(),
                customerDtoConverter.convertToAccountCustomer(from.getCustomer()),
                from.getTransaction().stream().map(t -> transactionDtoConverter.convert(t)).collect(Collectors.toSet()));
    }
}
