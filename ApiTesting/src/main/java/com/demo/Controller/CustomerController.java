package com.demo.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Customer;
@RestController
public class CustomerController {
	
	


    @PostMapping("/api/add_customer")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
        // Add customer to database logic goes here
        return ResponseEntity.ok("Customer added successfully");


}
 @GetMapping("/api/customers")
    public String getCustomer(@RequestParam(required = false) String id) {
        if (id != null) {
            return "Customer details for ID: " + id;
        } else {
            return "List of all customers";
        }
    }
}
