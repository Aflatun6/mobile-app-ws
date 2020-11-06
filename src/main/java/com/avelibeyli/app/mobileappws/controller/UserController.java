package com.avelibeyli.app.mobileappws.controller;

import com.avelibeyli.app.mobileappws.exceptions.UserServiceException;
import com.avelibeyli.app.mobileappws.model.request.UpdateUser;
import com.avelibeyli.app.mobileappws.model.request.User;
import com.avelibeyli.app.mobileappws.model.response.UserRest;
import com.avelibeyli.app.mobileappws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController {

    private Map<String, UserRest> users;

    @Autowired
    private UserService userService;

    @GetMapping
    public Map<String, UserRest> getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                                          @RequestParam(value = "limit", defaultValue = "50") int limit,
                                          @RequestParam(value = "sort", defaultValue = "desc") String sort) {
        return users;
    }

    @GetMapping(path = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String id) {
        throw new UserServiceException("a user service exception is thrown");

    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody User user) {
        UserRest userRest = userService.createUser(user);

        return new ResponseEntity<UserRest>(userRest, HttpStatus.OK);
    }

    @PutMapping(path = "{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> updateUser(@PathVariable String id, @Valid @RequestBody UpdateUser user) {
        UserRest userRest = users.get(id);
        userRest.setLastName(user.getLastName());
        userRest.setName(user.getName());

        users.put(id, userRest);

        return new ResponseEntity<>(userRest, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        users.remove(id);

        return ResponseEntity.noContent().build();
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
