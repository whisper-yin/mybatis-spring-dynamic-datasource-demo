package org.hk.demo.controller;

import com.google.gson.Gson;
import org.hk.demo.annotation.DataSource;
import org.hk.demo.context.DataSourceContext;
import org.hk.demo.entity.InformationEntity;
import org.hk.demo.entity.UserEntity;
import org.hk.demo.service.InformationService;
import org.hk.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    UserService us;

    @Autowired
    InformationService is;

    @Autowired
    Gson gson;

    @GetMapping("/getinfo")
    public String getInfo() {
        return "state: succeed";
    }

    @DataSource()
    @GetMapping("/userid")
    public String getUser(@RequestParam(name = "userId", required = false, defaultValue = "1") int userId) {

        LOGGER.debug("receive user id detail: [{}]", userId);

//        DataSourceContext.setDataSource("masterdb");
        UserEntity userEntity = us.findUserById(userId);
//        DataSourceContext.clearDataSource();

        LOGGER.debug("query result detail: {}", gson.toJson(userEntity));

        return gson.toJson(userEntity);
    }

    @GetMapping("/infoid")
    public String getInformation(@RequestParam(name = "informationId", required = false, defaultValue = "1") int informationId) {

        LOGGER.debug("receive information id detail: [{}]", informationId);

        DataSourceContext.setDataSource("slavedb");
        InformationEntity informationEntity = is.findInformationById(informationId);

        LOGGER.debug("query result detail: {}", gson.toJson(informationEntity));

        return gson.toJson(informationEntity);
    }
}
