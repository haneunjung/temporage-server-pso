package com.example.demohaneunjung.account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;

@ExtendWith(SpringExtension.class)
@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    public void testSignIn() {
        Account account = Account.builder()
                .role("ADMIN")
                .username("admin")
                .password("admin")
                .build();

        WebTestClient.BodyContentSpec bodyContentSpec = webTestClient.post()
                .uri("/sign-in")
                .body(BodyInserters.fromValue(account))
                .exchange() // 얘가 실행하는애
                .expectBody();

        System.out.println(bodyContentSpec.returnResult());

    }

    @Test
    public void testSignInRestTemplate() {
        Account account = Account.builder()
                .username("admin")
                .password("admins")
                .role("ADMIN")
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Account> request = new HttpEntity<>(account, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost/sign-in", request, String.class);
        System.out.println(response.getBody());

    }
}
