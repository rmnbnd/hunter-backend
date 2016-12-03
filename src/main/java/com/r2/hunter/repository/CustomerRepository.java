package com.r2.hunter.repository;

import java.util.List;
import java.util.function.Consumer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import com.r2.hunter.domain.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    @Query("select customer from Customer customer where customer.email = ?#{principal.username}")
    Customer findCurrentCustomer();

    List<Consumer> findByCompanyName(@Param("companyName") String companyName);

    Customer findByEmail(@Param("email") String email);

}
