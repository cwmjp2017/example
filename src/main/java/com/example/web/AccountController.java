package com.example.web;

import com.example.domain.Account;
import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

/**
 * Created by chu on 2017/11/06.
 */

@Controller
@RequestMapping("/accounts") // ①
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping
    public String index(Model model) { // ②
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts", accounts); // ③
        return "accounts/index"; // ④
    }

    @GetMapping("new")
    public String newAccount(Model model) {
        return "accounts/new";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Integer id, Model model) { // ⑤
        Account account = accountService.findOne(id);
        model.addAttribute("account", account);
        return "accounts/edit";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Integer id, Model model) {
        Account account = accountService.findOne(id);
        model.addAttribute("account", account);
        return "accounts/show";
    }

    @PostMapping
    public String create(@ModelAttribute Account account) { // ⑥
        account.setId(accountService.getMaxId()+1);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        accountService.save(account);
        return "redirect:/accounts"; // ⑦
    }

    @PutMapping("{id}")
    public String update(@PathVariable Integer id, @ModelAttribute Account account) {
        account.setId(id);
        accountService.save(account);
        return "redirect:/accounts";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        accountService.delete(id);
        return "redirect:/accounts";
    }
}
