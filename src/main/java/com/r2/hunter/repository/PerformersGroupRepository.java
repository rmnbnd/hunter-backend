package com.r2.hunter.repository;

import com.r2.hunter.domain.PerformersGroup;
import com.r2.hunter.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "groups", path = "groups")
public interface PerformersGroupRepository extends PagingAndSortingRepository<PerformersGroup, Long> {

    List<User> findByGroupName(@Param("groupName") String groupName);

}
