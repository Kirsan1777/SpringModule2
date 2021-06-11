package com.epam.esm.model.dao;

import com.epam.esm.model.entity.GiftTag;
import com.epam.esm.model.entity.Tag;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GiftTagMapper implements RowMapper<GiftTag> {
    @Override
    public GiftTag mapRow(ResultSet resultSet, int i) throws SQLException {
        GiftTag giftTag = new GiftTag();
        giftTag.setGiftName(resultSet.getString("c.name"));
        giftTag.setTagName(resultSet.getString("t.name"));
        giftTag.setCreateDate(resultSet.getString("c.create_date"));
        giftTag.setDuration(resultSet.getInt("c.duration"));
        giftTag.setLastUpdateDate(resultSet.getString("c.last_update_date"));
        giftTag.setPrice(resultSet.getDouble("c.price"));
        giftTag.setDescription(resultSet.getString("c.description"));
        return giftTag;
    }
}
