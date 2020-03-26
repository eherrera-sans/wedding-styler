package com.sanservices.websitesapi.modules.wedding.repository;

import com.sanservices.websitesapi.commons.entity.Brand;
import com.sanservices.websitesapi.config.jdbc.source.Wds;
import com.sanservices.websitesapi.modules.wedding.entity.WishList;
import lombok.val;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.JDBCType;
import java.sql.Types;
import java.util.List;

@Repository
public class WishListRepositoryImpl implements WishListRepository {

    private final SimpleJdbcCall spGetWishLists;

    public WishListRepositoryImpl(@Wds JdbcTemplate template, RowMapper<WishList> wishListRowMapper) {
        spGetWishLists = new SimpleJdbcCall(template)
                .withoutProcedureColumnMetaDataAccess()
                .withCatalogName("WS_PAGE_PKG")
                .withProcedureName("GET_WISHLISTS")
                .declareParameters(
                        new SqlParameter("pi_userId", Types.INTEGER, JDBCType.INTEGER.getName()),
                        new SqlParameter("pi_brand", Types.VARCHAR, JDBCType.VARCHAR.getName()),
                        new SqlOutParameter("po_wishLists", Types.REF_CURSOR, wishListRowMapper)
                );
        spGetWishLists.compile();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<WishList> findByUserIdAndBrand(int userId, Brand brand) {
        val params = new MapSqlParameterSource();
        params.addValue("pi_userId", userId);
        params.addValue("pi_brand", brand.name());

        val result = spGetWishLists.execute(params);
        return (List<WishList>) result.get("po_wishLists");
    }
}
