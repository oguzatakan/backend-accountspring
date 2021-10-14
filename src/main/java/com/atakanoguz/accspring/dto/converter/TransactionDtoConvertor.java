package com.atakanoguz.accspring.dto.converter;

import com.atakanoguz.accspring.dto.TransactionDto;
import com.atakanoguz.accspring.model.Transaction;
import org.springframework.stereotype.Component;


@Component
public class TransactionDtoConvertor {

    public TransactionDto convert(Transaction from) {
        return new TransactionDto(
                from.getId(),
                from.getTransactionType(),
                from.getAmount(),
                from.getTransactionDate());
    }
}
