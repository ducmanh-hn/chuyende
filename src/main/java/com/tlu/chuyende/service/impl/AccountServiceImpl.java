package com.tlu.chuyende.service.impl;

import com.tlu.chuyende.exception.NotFoundException;
import com.tlu.chuyende.model.Account;
import com.tlu.chuyende.repository.AccountRepo;
import com.tlu.chuyende.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    AccountRepo accountRepo;

    @Override
    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }

    @Override
    public Account getAccountById(int id) {
        return accountRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepo.save(account);
    }

    @Override
    public Account updateAccount(int id, Account newAccount) {
        if(!accountRepo.existsById(id)){
            throw new NotFoundException(id);
        }
        newAccount.setAccountId(id);
        return accountRepo.save(newAccount);
    }

    @Override
    public boolean deleteAccountById(int id) {
        if(!accountRepo.existsById(id)){
            throw new NotFoundException(id);
        }
        accountRepo.deleteById(id);
        return true;
    }
}
