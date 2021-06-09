package com.epam.esm.model.service.impl;

import com.epam.esm.model.dao.impl.TagDAOImpl;
import com.epam.esm.model.entity.Tag;
import com.epam.esm.model.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TagServiceImpl implements TagService {
    private final TagDAOImpl tagDAO;
    @Autowired
    public TagServiceImpl(TagDAOImpl tagDAO) {
        this.tagDAO = tagDAO;
    }


    public List<Tag> allTags(){
        return tagDAO.allTags();
    }

    public void deleteTag(int idTag){
        tagDAO.deleteTag(idTag);
    }

    public void updateTag(Tag tag){
        tagDAO.updateTag(tag.getName(), tag.getId());
    }

    public void addTag(String name){
        tagDAO.addTag(name);
    }

    public Tag findByName(String name){
        return tagDAO.readOneTag(name);
    }

}
