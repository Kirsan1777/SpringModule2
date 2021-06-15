package com.epam.esm.model.service.impl;

import com.epam.esm.model.dao.impl.GiftCertificateDAOImpl;
import com.epam.esm.model.dao.impl.LinkTableDAOImpl;
import com.epam.esm.model.dao.impl.TagDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GiftTagServiceImpl {
    @Autowired
    private TagDAOImpl tagDAO;

    @Autowired
    private LinkTableDAOImpl linkTableDAO;

    public void addTagToGiftCertificate(String nameTag, int idGiftCertificate) {
        if (tagDAO.readOneTagByName(nameTag) == null) {
            tagDAO.addTag(nameTag);
        }
        int id = tagDAO.readOneTagByName(nameTag).getId();
        linkTableDAO.addTagToGiftCertificate(id, idGiftCertificate); //add method for many-to-many
    }
}
