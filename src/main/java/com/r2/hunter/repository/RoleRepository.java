package com.r2.hunter.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.r2.hunter.domain.Role;
import com.r2.hunter.domain.User;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

    List<User> findByRoleName(@Param("roleName") String roleName);

}
