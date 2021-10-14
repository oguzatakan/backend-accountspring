package com.atakanoguz.accspring.dto.converter;


import com.atakanoguz.accspring.dto.AccountCustomerDto;
import com.atakanoguz.accspring.dto.CustomerDto;
import com.atakanoguz.accspring.model.Customer;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {

    private final CustomerAccountDtoConvertor customerAccountDtoConvertor;

    public CustomerDtoConverter(CustomerAccountDtoConvertor converter) {
        this.customerAccountDtoConvertor = converter;
    }

    public AccountCustomerDto convertToAccountCustomer(Optional<Customer> from) {
        return from.map(f -> new AccountCustomerDto(f.getId(), f.getName(), f.getSurname())).orElse(null);
    }

    public CustomerDto convertToCustomerDto(Customer from) {
        return new CustomerDto(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getAccounts().stream().map(customerAccountDtoConvertor::convert).collect(Collectors.toSet()));

    }

}
