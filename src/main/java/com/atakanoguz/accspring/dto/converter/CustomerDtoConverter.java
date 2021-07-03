package com.atakanoguz.accspring.dto.converter;


import com.atakanoguz.accspring.dto.AccountCustomerDto;
import com.atakanoguz.accspring.dto.CustomerAccountDto;
import com.atakanoguz.accspring.dto.CustomerDto;
import com.atakanoguz.accspring.model.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {

    private final CustomerAccountDtoConvertor converter;

    public CustomerDtoConverter(CustomerAccountDtoConvertor converter) {
        this.converter = converter;
    }

    public AccountCustomerDto convertToAccountCustomer(Customer from) {
        if (from == null) {
            return new AccountCustomerDto("","","");
        }
        return new AccountCustomerDto(from.getId(),from.getName(),from.getSurname());
    }

    public CustomerDto convertToCustomerDto(Customer from) {
        return new CustomerDto(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getAccounts().stream().map(converter::convert).collect(Collectors.toSet()));

    }

}
