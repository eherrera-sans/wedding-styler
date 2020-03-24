package com.sanservices.websitesapi.modules.wedding.repository;

import com.sanservices.websitesapi.commons.entity.Brand;
import com.sanservices.websitesapi.config.jdbc.Source;
import com.sanservices.websitesapi.modules.wedding.entity.Region;
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

import static com.sanservices.websitesapi.config.jdbc.Sources.Wds;

@Repository
public class RegionRepositoryImpl implements RegionRepository {

    private final SimpleJdbcCall spGetRegions;

    public RegionRepositoryImpl(
            @Source(Wds) JdbcTemplate template,
            RowMapper<Region> regionRowMapper) {

        spGetRegions = new SimpleJdbcCall(template)
                .withoutProcedureColumnMetaDataAccess()
                .withCatalogName("WS_PAGE_PKG")
                .withProcedureName("GET_REGIONS")
                .declareParameters(
                        new SqlParameter("pi_brand", Types.VARCHAR, JDBCType.VARCHAR.getName()),
                        new SqlOutParameter("po_regions", Types.REF_CURSOR, regionRowMapper)
                );
        spGetRegions.compile();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Region> findByBrand(Brand brand) {
        val params = new MapSqlParameterSource("pi_brand", brand.name());
        val result = spGetRegions.execute(params);
        return (List<Region>) result.get("po_regions");
    }
}
