package sk.stu.fiit.login.controller;

import sk.stu.fiit.login.model.LoginCredentials;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.security.Key;
import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
@RestController
@RequestMapping("/login")
public class LoginController {

    @Value("${jwt.secret}")
    private String secret;

    @GetMapping
    public String getToken() {
        System.out.println("inside auth login");
        return Jwts.builder()
                .claim("id","miso")
                .claim("role","developer")
                .setSubject("Test Token")
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plus(10, ChronoUnit.MINUTES)))
                .signWith(SignatureAlgorithm.HS256,secret.getBytes()).compact();
    }

    @PostMapping
    public String getTokenProvidingUsernameAndPassword(@RequestBody LoginCredentials loginCredentials) {
        System.out.println("inside getTokenProvidingUsernameAndPassword");
        return Jwts.builder()
                .claim("id",loginCredentials.getUserName())
                .claim("role",loginCredentials.getRole())
                .setSubject("Test Token")
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plus(10, ChronoUnit.MINUTES)))
                .signWith(SignatureAlgorithm.HS256,secret.getBytes()).compact();
    }

}
