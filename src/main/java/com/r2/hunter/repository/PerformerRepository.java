package com.r2.hunter.repository;

import com.r2.hunter.domain.Performer;
import com.r2.hunter.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PerformerRepository extends PagingAndSortingRepository<Performer, Long> {

    List<User> findByFirstNameAndLastName(@Param("firstName") String firstName,
                                          @Param("lastName") String lastName);

}
