package com.r2.hunter.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.r2.hunter.domain.Vacancy;
import com.r2.hunter.service.VacancyService;

@RepositoryRestController
@RequestMapping(value = "/vacancies")
public class VacancyController {

    @Autowired
    private VacancyService vacancyService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Vacancy> getVacancyById(@PathVariable Long id) {
        Vacancy vacancy = vacancyService.findById(id);
        return Optional.ofNullable(vacancy)
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
