package com.example.demohaneunjung;

import com.example.demohaneunjung.account.Account;
import com.example.demohaneunjung.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

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
    }
}
