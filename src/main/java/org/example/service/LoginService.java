package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginService {
    @Value("${admin.client.id}")
    private String clientId;

    @Value("${admin.client.granttype}")
    private String grantType;

    @Value("${admin.client.secret}")
    private String clientSecret;

    @Value("${keycloak.token.url}")
    private String tokenUrl;

    private final RestTemplate restTemplate;

    @Autowired
    public LoginService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getToken(String username, String password) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("username", username);
        map.add("password", password);
        map.add("client_id", clientId);
        map.add("grant_type", grantType);
        map.add("client_secret", clientSecret);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, new HttpHeaders());

        return restTemplate.postForObject(tokenUrl, request, String.class);
    }
}
