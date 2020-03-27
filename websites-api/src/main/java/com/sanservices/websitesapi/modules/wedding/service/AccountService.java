package com.sanservices.websitesapi.modules.wedding.service;

import com.sanservices.websitesapi.modules.wedding.entity.Account;
import com.sanservices.websitesapi.modules.wedding.model.AccountRequestModel;
import com.sanservices.websitesapi.modules.wedding.model.CredentialsRequestModel;

public interface AccountService {
    Account createAccount(AccountRequestModel account);

    Account login(CredentialsRequestModel credentials);
}
