package com.sanservices.websitesapi.modules.wedding.mapper;

import com.sanservices.websitesapi.modules.wedding.entity.WishList;
import lombok.val;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public final class WishListRowMapper implements RowMapper<WishList> {
    @Override
    public WishList mapRow(ResultSet rs, int rowNum) throws SQLException {
        val wishList = new WishList();
        wishList.setId(rs.getInt("wishList_id"));
        wishList.setCode(rs.getString("wishList_no"));
        wishList.setName(rs.getString("wishList_name"));
        wishList.setRegionId(rs.getInt("region_id"));
        wishList.setTotal(rs.getBigDecimal("total"));
        wishList.setCredit(rs.getBigDecimal("credit"));
        wishList.setBalance(rs.getBigDecimal("balance"));
        wishList.setLastUpdate(rs.getDate("last_update"));
        wishList.setItemCount(rs.getInt("items_count"));
        return wishList;
    }
}
