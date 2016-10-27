package com.r2.hunter.service;

import com.r2.hunter.domain.Performer;
import com.r2.hunter.repository.PerformerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PerformerServiceImpl implements PerformerService {

    private final PerformerRepository performerRepository;

    @Autowired
    public PerformerServiceImpl(PerformerRepository performerRepository) {
        this.performerRepository = performerRepository;
    }

    @Override
    public Performer findById(long id) {
        return performerRepository.findOne(id);
    }

}
