package com.r2.hunter.repository;


import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import com.r2.hunter.domain.Job;
import com.r2.hunter.domain.User;

public interface JobRepository extends PagingAndSortingRepository<Job, Long> {

    List<User> findBySalary(@Param("salary") int salary);

}
