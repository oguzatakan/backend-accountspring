package com.atakanoguz.accspring.controller;

import com.atakanoguz.accspring.dto.converter.AccountDtoConverter;
import com.atakanoguz.accspring.repository.AccountRepository;
import com.atakanoguz.accspring.service.AccountService;
import com.atakanoguz.accspring.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Clock;
import java.util.UUID;
import java.util.function.Supplier;

@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,properties = {

        "server-port=0",
        "command.line.runner.enabled=false"
})
@RunWith(SpringRunner.class)
@DirtiesContext
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Clock clock;

    @MockBean
    private Supplier<UUID> uuidSupplier;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountDtoConverter converter;

    private AccountService service = new AccountService(accountRepository, customerService, converter);
    private ObjectMapper mapper = new ObjectMapper();
    private static final UUID uuid = UUID.randomUUID();
}
