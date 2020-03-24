package com.sanservices.websitesapi.modules.wedding.service;

import com.sanservices.websitesapi.modules.wedding.entity.Account;
import com.sanservices.websitesapi.modules.wedding.entity.Credentials;
import com.sanservices.websitesapi.modules.wedding.mapper.AccountMapper;
import com.sanservices.websitesapi.modules.wedding.model.AccountRequestModel;
import com.sanservices.websitesapi.modules.wedding.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public Account createAccount(AccountRequestModel account) {
        val entity = accountMapper.modelToEntity(account);

        val result = accountRepository.save(entity);
        if (result.isSuccess()) {
            return result.getValue();
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, result.getReason());
        }
    }

    @Override
    public Account login(Credentials credentials) {
        val result = accountRepository.login(credentials);
        if (result.isSuccess()) {
            return result.getValue();
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, result.getReason());
        }
    }
}
