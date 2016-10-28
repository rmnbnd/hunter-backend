package com.r2.hunter.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.r2.hunter.domain.PerformersGroup;

@RepositoryRestResource(collectionResourceRel = "groups", path = "groups")
public interface PerformersGroupRepository extends PagingAndSortingRepository<PerformersGroup, Long> {

    List<PerformersGroup> findByGroupName(@Param("groupName") String groupName);

}
