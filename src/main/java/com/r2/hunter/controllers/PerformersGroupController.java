package com.r2.hunter.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.r2.hunter.domain.PerformersGroup;
import com.r2.hunter.service.PerformersGroupService;

@RepositoryRestController
@RequestMapping(value = "/groups")
public class PerformersGroupController {

    @Autowired
    private PerformersGroupService performersGroupService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PerformersGroup> getPerformersGroupById(@PathVariable Long id) {
        PerformersGroup performersGroup = performersGroupService.findById(id);
        return Optional.ofNullable(performersGroup)
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
