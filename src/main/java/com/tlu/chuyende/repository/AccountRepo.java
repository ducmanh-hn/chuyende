package com.tlu.chuyende.repository;

import com.tlu.chuyende.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {
    @Query("SELECT a FROM Account a WHERE a.username = ?1")
    List<Account> findByUsername(String username);
}
