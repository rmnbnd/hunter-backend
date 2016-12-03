package com.r2.hunter.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.r2.hunter.domain.Role;
import com.r2.hunter.service.RoleService;

@RepositoryRestController
@RequestMapping(value = "/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
        Role role = roleService.findById(id);
        return Optional.ofNullable(role)
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
