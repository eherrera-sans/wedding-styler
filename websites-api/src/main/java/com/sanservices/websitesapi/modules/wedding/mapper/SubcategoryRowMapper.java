package com.sanservices.websitesapi.modules.wedding.mapper;

import com.sanservices.websitesapi.modules.wedding.entity.Subcategory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public final class SubcategoryRowMapper implements RowMapper<Subcategory> {
    @Override
    public Subcategory mapRow(ResultSet rs, int rowNum) throws SQLException {
        Subcategory subcategory = new Subcategory();
        subcategory.setId(rs.getInt("subcategory_id"));
        subcategory.setName(rs.getString("subcategory_name"));
        subcategory.setItemCount(rs.getInt("items_count"));
        subcategory.setCategoryId(rs.getInt("category_id"));
        subcategory.setCategoryName(rs.getString("category_name"));
        return subcategory;
    }
}
