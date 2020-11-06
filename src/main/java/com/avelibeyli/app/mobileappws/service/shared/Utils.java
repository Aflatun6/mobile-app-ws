package com.avelibeyli.app.mobileappws.service.shared;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Utils {
    public String generateUserUid() {
        return UUID.randomUUID().toString();
    }
}
