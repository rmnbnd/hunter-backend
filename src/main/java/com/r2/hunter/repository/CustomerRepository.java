package com.r2.hunter.repository;

import com.r2.hunter.domain.Customer;
import com.r2.hunter.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    List<User> findByCompanyName(@Param("companyName") String companyName);

}
