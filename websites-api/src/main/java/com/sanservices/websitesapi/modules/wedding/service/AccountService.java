package com.sanservices.websitesapi.modules.wedding.service;

import com.sanservices.websitesapi.modules.wedding.entity.Account;
import com.sanservices.websitesapi.modules.wedding.entity.Credentials;
import com.sanservices.websitesapi.modules.wedding.model.AccountRequestModel;

public interface AccountService {
    Account createAccount(AccountRequestModel account);

    Account login(Credentials credentials);
}
