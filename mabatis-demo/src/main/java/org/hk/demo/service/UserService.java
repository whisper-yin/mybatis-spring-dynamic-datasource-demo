package org.hk.demo.service;

import org.hk.demo.entity.UserEntity;
import org.hk.demo.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserMapper um;

    public UserEntity findUserById(int id) {
        LOGGER.debug("query user condition id - [{}]", id);
        return um.findById(id);
    }
}
