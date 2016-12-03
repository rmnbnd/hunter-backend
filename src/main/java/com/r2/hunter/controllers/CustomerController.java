package com.r2.hunter.controllers;

import static com.r2.hunter.Constants.CUSTOMER_ROLE;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.r2.hunter.domain.Customer;
import com.r2.hunter.service.CustomerService;
import com.r2.hunter.service.RoleService;

@RepositoryRestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @PostMapping
    public ResponseEntity<?> signUp(@RequestBody String json) throws IOException, URISyntaxException {
        ObjectNode node = mapper.readValue(json, ObjectNode.class);
        Customer customer = mapper.treeToValue(node, Customer.class);

        Optional<Customer> existingCustomer = Optional.ofNullable(customerService.findByEmail(customer.getEmail()));
        if(existingCustomer.isPresent()) {
            return ResponseEntity.badRequest().body("This email is already taken!");
        }

        customer.setPassword(passwordEncoder.encode(node.get("password").textValue()));
        customer.setRole(roleService.findByName(CUSTOMER_ROLE));

        Customer savedCustomer = customerService.save(customer);

        return ResponseEntity.created(new URI("/customers/" + savedCustomer.getCustomerId())).body(savedCustomer);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        return Optional.ofNullable(customer)
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
