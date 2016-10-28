package com.r2.hunter.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.r2.hunter.domain.PerformersGroup;
import com.r2.hunter.service.PerformersGroupService;

@RepositoryRestController
public class PerformersGroupController {

    @Autowired
    private PerformersGroupService performersGroupService;

    @RequestMapping(value = "/groups/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PerformersGroup> getPerformersGroupById(@PathVariable Long id) {
        PerformersGroup performersGroup = performersGroupService.findById(id);
        return Optional.ofNullable(performersGroup)
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
