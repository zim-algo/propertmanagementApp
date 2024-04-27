package com.propertymanagement.portal.service;

import com.propertymanagement.portal.domain.Customer;
import com.propertymanagement.portal.repository.CustomerRepository;
import com.propertymanagement.portal.service.impl.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTests {
    @InjectMocks
    CustomerService service = new CustomerServiceImpl();

    @Mock
    CustomerRepository repository;

    @Test
    public void testGetCustomerById() {
        Customer customer = new Customer();
        customer.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(customer));

        assertEquals(service.getCustomerById(1L).getId(), customer.getId());
    }

    @Test
    public void testgetFavouritePropertiesByCustomer() {
        Customer customer = new Customer();
        customer.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(customer));

        assertEquals(customer.getSavedList(), service.getFavouritePropertiesByCustomer(1L));
    }

}
