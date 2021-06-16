package com.epam.esm.model.dao;

import com.epam.esm.model.dao.query.SqlTagQuery;
import com.epam.esm.model.entity.Tag;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

/**
 * The interface tag DAO.
 */
public interface TagDAO {
    /**
     * Method for get all tags
     *
     * @param sort the param for sort table
     */
    List<Tag> allTags(String sort);

    /**
     * Method for add tag
     *
     * @param name the tag name
     */
    int addTag(String name);

    /**
     * Method for delete tag
     *
     * @param idTag the tag id
     */
    int deleteTag(int idTag);

    /**
     * Method for get one tag by name
     *
     * @param name the tag name
     */
    Tag readOneTagByName(String name);

    /**
     * Method for get one tag by id
     *
     * @param id the tag id
     */
    Tag readOneTagById(int id);
}
