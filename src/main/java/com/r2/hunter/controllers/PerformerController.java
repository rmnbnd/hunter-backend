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
import com.r2.hunter.domain.Performer;
import com.r2.hunter.service.PerformerService;

@RepositoryRestController
public class PerformerController {

    @Autowired
    private PerformerService performerService;

    @RequestMapping(value = "/performers/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Performer> getPerformerById(@PathVariable Long id) {
        Performer performer = performerService.findById(id);
        return Optional.ofNullable(performer)
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
