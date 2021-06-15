package com.epam.esm.model.dao;

import com.epam.esm.model.dao.query.SqlTagQuery;
import com.epam.esm.model.entity.Tag;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

    public interface TagDAO {
        List<Tag> allTags(String sort);

        int addTag(String name);

        int deleteTag(int idTag);

        Tag readOneTagByName(String name);

        Tag readOneTagById(int id);
    }
