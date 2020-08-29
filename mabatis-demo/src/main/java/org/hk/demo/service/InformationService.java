package org.hk.demo.service;

import org.hk.demo.entity.InformationEntity;
import org.hk.demo.mapper.InformationMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InformationService.class);

    @Autowired
    InformationMapper im;

    public InformationEntity findInformationById(int id) {
        LOGGER.debug("query information condition id - [{}]", id);
        return im.findById(id);
    }
}
