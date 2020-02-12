package com.example.demohaneunjung;

import com.example.demohaneunjung.account.Account;
import com.example.demohaneunjung.account.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    AccountService accountService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = Account.builder()
                .username("admin")
                .password("admins")
                .role("ADMIN")
                .build();

        accountService.createNew(account);

//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        HttpEntity<Account> request = new HttpEntity<>(account, headers);
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost/sign-in", request, String.class);
//
//        log.debug(response.getBody());
    }
}
