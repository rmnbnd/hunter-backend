package com.r2.hunter.repository;

import com.r2.hunter.domain.PerformersGroup;
import com.r2.hunter.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PerformersGroupRepository extends PagingAndSortingRepository<PerformersGroup, Long> {

    List<User> findByGroupName(@Param("groupName") String groupName);

}
