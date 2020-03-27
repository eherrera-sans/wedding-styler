package com.sanservices.websitesapi.modules.wedding.controller;

import com.sanservices.websitesapi.modules.wedding.entity.Account;
import com.sanservices.websitesapi.modules.wedding.model.AccountRequestModel;
import com.sanservices.websitesapi.modules.wedding.model.CredentialsRequestModel;
import com.sanservices.websitesapi.modules.wedding.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weddings")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/register")
    public Account createAccount(@RequestBody @Valid AccountRequestModel account) {
        return accountService.createAccount(account);
    }

    @PutMapping("/login")
    public Account login(@RequestBody @Valid CredentialsRequestModel credentials) {
        return accountService.login(credentials);
    }
}
