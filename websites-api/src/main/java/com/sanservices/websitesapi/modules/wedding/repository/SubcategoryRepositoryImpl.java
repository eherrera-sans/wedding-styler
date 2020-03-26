package com.sanservices.websitesapi.modules.wedding.repository;

import com.sanservices.websitesapi.commons.entity.Brand;
import com.sanservices.websitesapi.config.jdbc.source.Wds;
import com.sanservices.websitesapi.modules.wedding.entity.Subcategory;
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
import java.util.Map;

@Repository
public class SubcategoryRepositoryImpl implements SubcategoryRepository {

    private final SimpleJdbcCall spGetSubcategories;

    public SubcategoryRepositoryImpl(
            @Wds JdbcTemplate template,
            RowMapper<Subcategory> subcategoryRowMapper) {

        spGetSubcategories = new SimpleJdbcCall(template)
                .withoutProcedureColumnMetaDataAccess()
                .withCatalogName("WS_PAGE_PKG")
                .withProcedureName("GET_CATALOG_SUBCAT")
                .declareParameters(
                        new SqlParameter("pi_eventId", Types.INTEGER, JDBCType.INTEGER.getName()),
                        new SqlParameter("pi_brand", Types.VARCHAR, JDBCType.VARCHAR.getName()),
                        new SqlOutParameter("po_subcat", Types.REF_CURSOR, subcategoryRowMapper)
                );
        spGetSubcategories.compile();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Subcategory> findByEventIdAndBrand(int eventId, Brand brand) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("pi_eventId", eventId);
        params.addValue("pi_brand", brand.name());

        Map<String, Object> result = spGetSubcategories.execute(params);
        return (List<Subcategory>) result.get("po_subcat");
    }
}
