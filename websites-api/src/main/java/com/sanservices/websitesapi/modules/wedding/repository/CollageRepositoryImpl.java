package com.sanservices.websitesapi.modules.wedding.repository;

import com.sanservices.websitesapi.config.jdbc.source.Wds;
import com.sanservices.websitesapi.modules.wedding.entity.Collage;
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
public class CollageRepositoryImpl implements CollageRepository {

    private final SimpleJdbcCall spGetCollageData;

    public CollageRepositoryImpl(
            @Wds JdbcTemplate template,
            RowMapper<Collage> collageRowMapper) {

        spGetCollageData = new SimpleJdbcCall(template)
                .withoutProcedureColumnMetaDataAccess()
                .withCatalogName("WS_PAGE_PKG")
                .withProcedureName("GET_COLLAGE_DATA")
                .declareParameters(
                        new SqlParameter("pi_wishListId", Types.INTEGER, JDBCType.INTEGER.getName()),
                        new SqlOutParameter("po_collage", Types.REF_CURSOR, collageRowMapper)
                );
        spGetCollageData.compile();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Collage> findByWishListId(int wishListId) {
        val params = new MapSqlParameterSource();
        params.addValue("pi_wishListId", wishListId);

        val result = spGetCollageData.execute(params);
        return (List<Collage>) result.get("po_collage");
    }
}
