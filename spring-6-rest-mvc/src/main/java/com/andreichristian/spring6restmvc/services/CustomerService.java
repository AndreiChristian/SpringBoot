package com.andreichristian.spring6restmvc.services;

import com.andreichristian.spring6restmvc.models.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomerById(UUID id);

    Customer saveNewCustomer(Customer customer);
}
