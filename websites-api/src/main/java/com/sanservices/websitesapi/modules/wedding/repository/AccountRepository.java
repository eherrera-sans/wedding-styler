package com.sanservices.websitesapi.modules.wedding.repository;

import com.sanservices.websitesapi.commons.entity.Result;
import com.sanservices.websitesapi.modules.wedding.entity.Account;
import com.sanservices.websitesapi.modules.wedding.entity.Credentials;

public interface AccountRepository {
    Result<Account, String> save(Account account);

    Result<Account, String> login(Credentials credentials);
}
