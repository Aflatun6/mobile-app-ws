package com.avelibeyli.app.mobileappws.service.impl;

import com.avelibeyli.app.mobileappws.model.request.User;
import com.avelibeyli.app.mobileappws.model.response.UserRest;
import com.avelibeyli.app.mobileappws.service.UserService;
import com.avelibeyli.app.mobileappws.service.shared.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private Map<String, UserRest> users;

    private final Utils utils;

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }


    @Override
    public UserRest createUser(User user) {
        UserRest userRest = new UserRest();
        userRest.setMail(user.getMail());
        userRest.setName(user.getName());
        userRest.setLastName(user.getLastName());

        String id = utils.generateUserUid();
        userRest.setUserId(id);

        if (users == null) users = new HashMap<>();
        users.put(id, userRest);
        return userRest;
    }
}
