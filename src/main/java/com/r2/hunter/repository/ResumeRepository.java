package com.r2.hunter.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.r2.hunter.domain.Resume;
import com.r2.hunter.domain.User;

@RepositoryRestResource(collectionResourceRel = "resume", path = "resume")
public interface ResumeRepository extends PagingAndSortingRepository<Resume, Long> {

    List<User> findByCountry(@Param("country") String country);

}
