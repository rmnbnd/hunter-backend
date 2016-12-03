package com.r2.hunter.service;

import com.r2.hunter.domain.Role;

public interface RoleService {

    Role findById(long id);

    Role findByName(String name);

}
