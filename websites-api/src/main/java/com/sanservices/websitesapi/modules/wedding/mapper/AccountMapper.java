package com.sanservices.websitesapi.modules.wedding.mapper;

import com.sanservices.websitesapi.modules.wedding.entity.Account;
import com.sanservices.websitesapi.modules.wedding.model.AccountRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AccountMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "optedIn", constant = "false")
    @Mapping(target = "withId", ignore = true)
    @Mapping(target = "withEmail", ignore = true)
    @Mapping(target = "withLastName", ignore = true)
    @Mapping(target = "withCountryCode", ignore = true)
    @Mapping(target = "withOptedIn", ignore = true)
    Account modelToEntity(AccountRequestModel model);
}
