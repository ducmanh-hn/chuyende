package com.tlu.chuyende.service;

import com.tlu.chuyende.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    List<Account> getAllAccounts();
    Account getAccountById(int id);
    Account createAccount(Account account);
    Account updateAccount(int id, Account newAccount);
    boolean deleteAccountById(int id);
}
