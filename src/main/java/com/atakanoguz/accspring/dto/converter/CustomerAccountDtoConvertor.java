package com.atakanoguz.accspring.dto.converter;

import com.atakanoguz.accspring.dto.CustomerAccountDto;
import com.atakanoguz.accspring.model.Account;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CustomerAccountDtoConvertor {

    private final TransactionDtoConvertor convertor;

    public CustomerAccountDtoConvertor(TransactionDtoConvertor convertor) {
        this.convertor = convertor;
    }

    public CustomerAccountDto convert(Account from) {
        return new CustomerAccountDto(
                Objects.requireNonNull(from.getId()),
                from.getBalance(),
                from.getTransaction().stream().map(convertor::convert).collect(Collectors.toSet()),
                from.getCreationDate());
    }
}
