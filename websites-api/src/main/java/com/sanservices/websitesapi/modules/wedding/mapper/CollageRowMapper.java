package com.sanservices.websitesapi.modules.wedding.mapper;

import com.sanservices.websitesapi.modules.wedding.entity.Collage;
import com.sanservices.websitesapi.modules.wedding.entity.Image;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.core.convert.ConversionService;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@RequiredArgsConstructor
public final class CollageRowMapper implements RowMapper<Collage> {

    private final RowMapper<Image> imageRowMapper;
    private final ConversionService conversionService;

    @Override
    public Collage mapRow(ResultSet rs, int rowNum) throws SQLException {
        val collage = new Collage();
        collage.setEvent(rs.getString("event"));
        collage.setPosition(rs.getInt("collage_position_id"));
        collage.setSubcategoryId(rs.getInt("subcategory_id"));
        collage.setSubcategoryName(rs.getString("subcategory_name"));

        val attributeId = conversionService.convert(rs.getBigDecimal("item_attribute_id"), Integer.class);
        collage.setAttributeId(attributeId);

        val image = imageRowMapper.mapRow(rs, rowNum);
        collage.setImage(image);

        return collage;
    }
}
