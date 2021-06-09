package com.epam.esm.model.dao.impl;

import com.epam.esm.exception.ConnectionDataBaseException;
import com.epam.esm.model.dao.ConnectionPool;
import com.epam.esm.model.dao.TagDAO;
import com.epam.esm.model.dao.TagMapper;
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

    public List<Tag> allTags(){
        return jdbcTemplate.query(SqlTagQuery.SELECT_ALL_TAG, new BeanPropertyRowMapper<>(Tag.class));
    }

    public void addTag(String name) {
        jdbcTemplate.update(SqlTagQuery.ADD_TAG, name);
    }

    public void deleteTag(int idTag) {
        jdbcTemplate.query(SqlTagQuery.DELETE_TAG, new Object[]{idTag}, new TagMapper());
    }

    public void updateTag(String name, int id){
        jdbcTemplate.update(SqlTagQuery.UPDATE_TAG, name, id);
    }

    public Tag readOneTag(String name){
        return jdbcTemplate.query(SqlTagQuery.SELECT_TAG_BY_NAME, new Object[]{name},
                new BeanPropertyRowMapper<>(Tag.class)).stream().findAny().orElse(null);
    }
}
