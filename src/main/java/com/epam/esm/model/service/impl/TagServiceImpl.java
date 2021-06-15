package com.epam.esm.model.service.impl;

import com.epam.esm.model.dao.impl.TagDAOImpl;
import com.epam.esm.model.entity.Tag;
import com.epam.esm.model.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TagServiceImpl implements TagService {
    private TagDAOImpl tagDAO;
    @Autowired
    public TagServiceImpl(TagDAOImpl tagDAO) {
        this.tagDAO = tagDAO;
    }
    public TagServiceImpl(){

    }




    public List<Tag> allTags(String sort){
        return tagDAO.allTags(sort);
    }

    public int deleteTag(int idTag){
        return tagDAO.deleteTag(idTag);
    }

    public int addTag(String name){
        return tagDAO.addTag(name);
    }

    public Tag findByName(String name){
        return tagDAO.readOneTagByName(name);
    }

    public Tag findById(int id){
        return tagDAO.readOneTagById(id);
    }

}
