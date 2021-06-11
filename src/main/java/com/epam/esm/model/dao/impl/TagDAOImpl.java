package com.epam.esm.model.dao.impl;

import com.epam.esm.model.dao.TagDAO;
import com.epam.esm.model.dao.query.SqlTagQuery;
import com.epam.esm.model.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TagDAOImpl implements TagDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TagDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Tag> allTags(String sort){
        return jdbcTemplate.query(SqlTagQuery.SELECT_ALL_TAG + sort, new BeanPropertyRowMapper<>(Tag.class));
    }

    public void addTag(String name) {
        jdbcTemplate.update(SqlTagQuery.ADD_TAG, name);
    }

    public void deleteTag(int idTag) {
        jdbcTemplate.update(SqlTagQuery.DELETE_TAG, idTag);
    }

    public Tag readOneTagByName(String name){
        return jdbcTemplate.query(SqlTagQuery.SELECT_TAG_BY_NAME, new Object[]{name},
                new BeanPropertyRowMapper<>(Tag.class)).stream().findAny().orElse(null);
    }

    public Tag readOneTagById(int id){
        return jdbcTemplate.query(SqlTagQuery.SELECT_TAG_BY_ID, new Object[]{id},
                new BeanPropertyRowMapper<>(Tag.class)).stream().findAny().orElse(null);
    }
}
