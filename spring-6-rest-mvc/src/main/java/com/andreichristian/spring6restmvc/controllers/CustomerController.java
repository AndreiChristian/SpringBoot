package com.andreichristian.spring6restmvc.controllers;

import com.andreichristian.spring6restmvc.models.Customer;
import com.andreichristian.spring6restmvc.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity handlePost(@RequestBody Customer customer){

        Customer createdCustomer = customerService.saveNewCustomer(customer);

        HttpHeaders headers = new HttpHeaders();

        headers.add("Location","/api/v1/customers/"+createdCustomer.getId().toString());

        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> listCustomers(){
        return customerService.getAllCustomers();
    }

    @RequestMapping( value = "{customerId}",method = RequestMethod.GET)
   public Customer getCustomerById( @PathVariable("customerId") UUID id){
        return  customerService.getCustomerById(id);
   }


}
