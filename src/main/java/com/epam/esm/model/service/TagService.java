package com.epam.esm.model.service;

import com.epam.esm.model.entity.Tag;

import java.util.List;

/**
 * The interface tag service.
 */
public interface TagService {
    /**
     * Method for get all tags
     *
     * @param sort the param for sort table
     */
    List<Tag> allTags(String sort);

    /**
     * Method for delete tag
     *
     * @param idTag the tag id
     */
    int deleteTag(int idTag);

    /**
     * Method for add tag
     *
     * @param name the tag name
     */
    int addTag(String name);

    /**
     * Method for get one tag by name
     *
     * @param name the tag name
     */
    Tag findByName(String name);

    /**
     * Method for get one tag by id
     *
     * @param id the tag id
     */
    Tag findById(int id);

}
