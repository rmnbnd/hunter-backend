package com.r2.hunter.service;

import com.r2.hunter.domain.PerformersGroup;
import com.r2.hunter.repository.PerformersGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PerformersGroupServiceImpl implements PerformersGroupService {

    private final PerformersGroupRepository performersGroupRepository;

    @Autowired
    public PerformersGroupServiceImpl(PerformersGroupRepository performersGroupRepository) {
        this.performersGroupRepository = performersGroupRepository;
    }

    @Override
    public PerformersGroup findById(long id) {
        return performersGroupRepository.findOne(id);
    }
}
