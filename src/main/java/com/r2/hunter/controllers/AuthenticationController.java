package com.r2.hunter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.r2.hunter.domain.Customer;
import com.r2.hunter.domain.Performer;
import com.r2.hunter.service.CustomerService;
import com.r2.hunter.service.PerformerService;

@RestController
@RequestMapping(value = "/api")
public class AuthenticationController {

    @Autowired
    private PerformerService performerService;

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/findCurrentUser")
    public ResponseEntity<?> getAuthenticatedUser() {
        Performer performer = performerService.findAuthenticatedPerformer();
        Customer customer;

        if(performer == null) {
            customer = customerService.findAuthenticatedCustomer();
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }

        return new ResponseEntity<>(performer, HttpStatus.OK);
    }

}
