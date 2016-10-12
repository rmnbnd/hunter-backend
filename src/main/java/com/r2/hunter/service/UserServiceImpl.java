package com.r2.hunter.service;

import com.r2.hunter.domain.User;
import com.r2.hunter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findById(long id) {
        return repository.findOne(id);
    }
}
