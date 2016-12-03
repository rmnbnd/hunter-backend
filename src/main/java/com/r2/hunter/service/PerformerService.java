package com.r2.hunter.service;

import com.r2.hunter.domain.Performer;

public interface PerformerService {

    Performer findById(long id);

    Performer findByEmail(String email);

    Performer save(Performer performer);

    Performer findAuthenticatedPerformer();

}
