package com.tlu.chuyende.controller;

import com.tlu.chuyende.model.Account;
import com.tlu.chuyende.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/account")
@AllArgsConstructor
public class AccountController {

    AccountService service;

    @GetMapping("")
    public ResponseEntity<Object> getAllAccounts(){
        return new ResponseEntity<>(service.getAllAccounts(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getAccountById(@PathVariable int id){
        return new ResponseEntity<>(service.getAccountById(id), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Object> createAccount(@RequestBody Account account){
        return new ResponseEntity<>(service.createAccount(account), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAccount(@PathVariable int id, @RequestBody Account account){
        return new ResponseEntity<>(service.updateAccount(id, account), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAccountById(@PathVariable int id){
        return new ResponseEntity<>(service.deleteAccountById(id), HttpStatus.OK);
    }

}
