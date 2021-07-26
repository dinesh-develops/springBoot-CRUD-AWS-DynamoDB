package com.aws.springBootCRUD.Controller;

import com.aws.springBootCRUD.Entity.Customer;
import com.aws.springBootCRUD.Repository.customerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class customerController {
    @Autowired
    private customerRepository repository;
    @GetMapping("/")
    public String home(){
        return "Hello from AWS Cloud!";
    }
    @PostMapping("/saveCustomer")
    public Customer saveCustomer(@RequestBody Customer customer){
        return repository.addCustomer(customer);
    }
    @GetMapping("/getCustomer/{customerId}")
    public Customer findCustomer(@PathVariable String customerId){
        return repository.findCustomerById(customerId);
    }
    @DeleteMapping("/deleteCustomer")
    public String deleteCustomer(@RequestBody Customer customer){
        return repository.deleteCustomer(customer);
    }
    @PutMapping("/updateCustomer")
    public String updateCustomer(@RequestBody Customer customer){
        return repository.updateCustomer(customer);
    }
}
