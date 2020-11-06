package com.avelibeyli.app.mobileappws.service;

import com.avelibeyli.app.mobileappws.model.request.User;
import com.avelibeyli.app.mobileappws.model.response.UserRest;

public interface UserService {
    UserRest createUser(User user);
}
