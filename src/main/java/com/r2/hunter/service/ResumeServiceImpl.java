package com.r2.hunter.service;

import com.r2.hunter.domain.Resume;
import com.r2.hunter.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ResumeServiceImpl implements ResumeService {

    private final ResumeRepository resumeRepository;

    @Autowired
    public ResumeServiceImpl(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    @Override
    public Resume findById(long id) {
        return resumeRepository.findOne(id);
    }

}
