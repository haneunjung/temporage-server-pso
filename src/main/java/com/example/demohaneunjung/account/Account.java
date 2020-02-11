package com.example.demohaneunjung.account;

import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Builder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity @Table(name = "account")
public class Account {

    @GeneratedValue @Id
    @Column(name = "account_id")
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
    }
}
