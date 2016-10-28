package com.r2.hunter.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import com.r2.hunter.domain.Performer;

public interface PerformerRepository extends PagingAndSortingRepository<Performer, Long> {

    List<Performer> findByFirstNameAndLastName(@Param("firstName") String firstName,
                                          @Param("lastName") String lastName);

}
