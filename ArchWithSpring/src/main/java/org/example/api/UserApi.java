package org.example.api;

import org.example.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@RestController
public class UserApi {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String userUrl = "http://localhost:8081/user";
    public Set<User> getAllUsers() {
        String apiUrl = userUrl + "/getall";
        ResponseEntity<User[]> response = restTemplate.getForEntity(apiUrl, User[].class);
        if (response.getStatusCode().is2xxSuccessful()) {
            User[] users = response.getBody();
            return new HashSet<>(Arrays.asList(users));
        }else {
            return Collections.emptySet();
        }
    }
}