package com.sanservices.websitesapi.modules.wedding.mapper;

import com.sanservices.websitesapi.modules.wedding.entity.Account;
import com.sanservices.websitesapi.modules.wedding.entity.Credentials;
import com.sanservices.websitesapi.modules.wedding.model.AccountRequestModel;
import com.sanservices.websitesapi.modules.wedding.model.CredentialsRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AccountMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "optedIn", constant = "false")
    Account modelToEntity(AccountRequestModel model);

    Credentials modelToEntity(CredentialsRequestModel model);
}
