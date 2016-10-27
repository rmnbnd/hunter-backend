package com.r2.hunter.repository;

import com.r2.hunter.domain.User;
import com.r2.hunter.domain.Vacancy;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VacancyRepository extends PagingAndSortingRepository<Vacancy, Long> {

    List<User> findByVacancyName(@Param("vacancyName") String vacancyName);


}
