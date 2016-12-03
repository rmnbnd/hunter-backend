package com.r2.hunter.controllers;

import static com.r2.hunter.Constants.PERFORMER_ROLE;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.r2.hunter.domain.Performer;
import com.r2.hunter.service.PerformerService;
import com.r2.hunter.service.RoleService;

@RepositoryRestController
@RequestMapping("/performers")
public class PerformerController {

    @Autowired
    private PerformerService performerService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @PostMapping
    public ResponseEntity<?> signUp(@RequestBody String json) throws IOException, URISyntaxException {
        ObjectNode node = mapper.readValue(json, ObjectNode.class);
        Performer performer = mapper.treeToValue(node, Performer.class);

        Optional<Performer> existingPerformer = Optional.ofNullable(performerService.findByEmail(performer.getEmail()));
        if(existingPerformer.isPresent()) {
            return ResponseEntity.badRequest().body("This email is already taken!");
        }

        performer.setPassword(passwordEncoder.encode(node.get("password").textValue()));
        performer.setRole(roleService.findByName(PERFORMER_ROLE));

        Performer savedPerformer = performerService.save(performer);

        return ResponseEntity.created(new URI("/performers/" + savedPerformer.getPerformerId())).body(savedPerformer);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Performer> getPerformerById(@PathVariable Long id) {
        Performer performer = performerService.findById(id);
        return Optional.ofNullable(performer)
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
