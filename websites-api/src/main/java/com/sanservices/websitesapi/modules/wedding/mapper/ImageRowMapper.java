package com.sanservices.websitesapi.modules.wedding.mapper;

import com.sanservices.websitesapi.modules.wedding.entity.Image;
import lombok.val;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public final class ImageRowMapper implements RowMapper<Image> {
    @Override
    public Image mapRow(ResultSet rs, int rowNum) throws SQLException {
        val image = new Image();
        image.setPath(rs.getString("image_path"));
        image.setName(rs.getString("image_name"));

        if (image.getPath() == null && image.getName() == null) {
            return null;
        }

        return image;
    }
}
