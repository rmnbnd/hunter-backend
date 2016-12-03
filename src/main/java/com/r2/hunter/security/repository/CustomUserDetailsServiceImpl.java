package com.r2.hunter.security.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.r2.hunter.domain.Customer;
import com.r2.hunter.domain.Performer;
import com.r2.hunter.service.CustomerService;
import com.r2.hunter.service.PerformerService;

public class CustomUserDetailsServiceImpl implements UserDetailsService {

    private CustomerService customerService;
    private PerformerService performerService;

    public CustomUserDetailsServiceImpl(CustomerService customerService, PerformerService performerService) {
        this.customerService = customerService;
        this.performerService = performerService;
    }

    /**
     * @param username - in range of our application it's email indeed, because we
     *                   determine uniqueness of user by email instead of username.
     *                   So, we have representation of our username as an email
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerService.findByEmail(username);
        Performer performer = performerService.findByEmail(username);

        if (customer != null) {
            return new User(username, customer.getPassword(),
                    getAuthorities(customer.getRole().getRoleName()));
        } else if (performer != null) {
            return new User(username, performer.getPassword(),
                    getAuthorities(performer.getRole().getRoleName()));
        }

        throw new UsernameNotFoundException("User with '" + username + "' email not found");
    }

    private List<GrantedAuthority> getAuthorities(String role) {
        List<GrantedAuthority> authList = new ArrayList<>();
        authList.add(new SimpleGrantedAuthority(role));

        return authList;
    }

}
