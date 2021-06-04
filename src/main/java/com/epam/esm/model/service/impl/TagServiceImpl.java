package com.epam.esm.model.service.impl;

import com.epam.esm.model.dao.impl.TagDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TagServiceImpl {

    private static TagDAOImpl tagDAO = new TagDAOImpl();

    public void addTag(String name){
        tagDAO.addTag(name);
    }

    public void deleteTag(int idTag){
        tagDAO.deleteTag(idTag);
    }
}
