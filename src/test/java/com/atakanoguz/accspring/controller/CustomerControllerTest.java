package com.atakanoguz.accspring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.atakanoguz.accspring.IntegrationTestSupport;
import com.atakanoguz.accspring.TestSupport;
import com.atakanoguz.accspring.dto.CustomerDto;
import com.atakanoguz.accspring.dto.converter.CustomerDtoConverter;
import com.atakanoguz.accspring.model.Customer;
import com.atakanoguz.accspring.repository.CustomerRepository;
import com.atakanoguz.accspring.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Objects;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@DirtiesContext
public class CustomerControllerTest extends IntegrationTestSupport{
    @Test
    public void testGetCustomerById_whenCustomerIdExists_shouldReturnCustomerDto() throws Exception{

    }
}
