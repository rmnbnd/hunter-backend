package com.r2.hunter.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import com.r2.hunter.domain.Vacancy;

public interface VacancyRepository extends PagingAndSortingRepository<Vacancy, Long> {

    List<Vacancy> findByVacancyName(@Param("vacancyName") String vacancyName);

}
