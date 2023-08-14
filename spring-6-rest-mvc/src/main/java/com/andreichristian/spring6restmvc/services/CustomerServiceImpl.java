package com.andreichristian.spring6restmvc.services;

import com.andreichristian.spring6restmvc.models.Customer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<UUID, Customer> customerMap;

    public CustomerServiceImpl() {
        this.customerMap = new HashMap<>();

        Customer customer1 = Customer
                .builder()
                .id(UUID.randomUUID())
                .customerName("John Doe")
                .version(1)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        Customer customer2 = Customer
                .builder()
                .id(UUID.randomUUID())
                .customerName("Jane Doe")
                .version(2)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        Customer customer3 = Customer
                .builder()
                .id(UUID.randomUUID())
                .customerName("Jane Doe")
                .version(2)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        customerMap.put(customer1.getId(),customer1);
        customerMap.put(customer2.getId(),customer2);
        customerMap.put(customer3.getId(),customer3);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }


    @Override
    public Customer getCustomerById(UUID id) {
        return customerMap.get(id);
    }

    @Override
    public Customer saveNewCustomer(Customer customer) {

        Customer createdCustomer = Customer.builder()
                .updatedAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .id(UUID.randomUUID())
                .customerName(customer.getCustomerName())
                .version(customer.getVersion())
                .build();

        customerMap.put(createdCustomer.getId(),createdCustomer);

        return createdCustomer;
    }
}
