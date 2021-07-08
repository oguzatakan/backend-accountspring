package com.atakanoguz.accspring.service;

import com.atakanoguz.accspring.TestSupport;
import com.atakanoguz.accspring.dto.CustomerDto;
import com.atakanoguz.accspring.dto.converter.CustomerDtoConverter;
import com.atakanoguz.accspring.exception.CustomerNotFoundException;
import com.atakanoguz.accspring.model.Customer;
import com.atakanoguz.accspring.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class CustomerServiceTest extends TestSupport {

    private CustomerService service;
    private  CustomerRepository customerRepository;
    private  CustomerDtoConverter converter;

    @BeforeEach
    public void setUp() {
        customerRepository = mock(CustomerRepository.class);
        converter = mock(CustomerDtoConverter.class);
        service = new CustomerService(customerRepository,converter);
    }

    @Test
    public void testFindByCustomerId_whenCustomerIdExists_shouldReturnCustomer(){
        Customer customer = generateCustomer();

        Mockito.when(customerRepository.findById("customer-id")).thenReturn(Optional.of(customer));

        Customer result = service.findCustomerById("customer-id");

        assertEquals(result,customer);

    }

    @Test
    public void testFindByCustomerId_whenCustomerIdDoesNotExists_shouldThrowCustomerNotFoundException(){


        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class, () -> service.findCustomerById("id"));

    }

    @Test
    public void testGetCustomerById_whenCustomerIdExists_shouldReturnCustomer(){
        Customer customer = generateCustomer();
        CustomerDto customerDto = new CustomerDto("customer-id", "name", "surname",Set.of());

        Mockito.when(customerRepository.findById("customer-id")).thenReturn(Optional.of(customer));
        Mockito.when(converter.convertToCustomerDto(customer)).thenReturn(customerDto);

        CustomerDto result = service.getCustomerById("customer-id");

        assertEquals(result,customerDto);

    }

    @Test
    public void testGetCustomerById_whenCustomerIdDoesNotExist_shouldThrowCustomerNotFoundException(){

        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class,() -> service.getCustomerById("id"));

        Mockito.verifyNoInteractions(converter);

    }

}