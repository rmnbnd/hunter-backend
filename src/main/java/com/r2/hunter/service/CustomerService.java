package com.r2.hunter.service;

import com.r2.hunter.domain.Customer;

public interface CustomerService {

    Customer findById(long id);

    Customer findByEmail(String email);

    Customer save(Customer customer);

    Customer findAuthenticatedCustomer();

}
