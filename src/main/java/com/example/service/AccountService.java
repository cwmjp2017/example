package com.example.service;

import com.example.domain.Account;
import com.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chu on 2017/11/06.
 */
@Service
public class AccountService {
    // ①
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account findOne(Integer id) {
        return accountRepository.findOne(id);
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public void delete(Integer id) {
        accountRepository.delete(id);
    }

    public Integer getMaxId() {
        return accountRepository.getMaxId();
    }
}