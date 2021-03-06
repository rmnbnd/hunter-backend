package com.r2.hunter.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import com.r2.hunter.domain.Role;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

    Role findByRoleName(@Param("roleName") String roleName);

}
