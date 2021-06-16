package com.epam.esm.model.service.impl;

import com.epam.esm.model.dao.impl.LinkTableDAOImpl;
import com.epam.esm.model.dao.impl.TagDAOImpl;
import com.epam.esm.model.service.GiftTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The class for realise interface GiftTagService
 */
@Service
public class GiftTagServiceImpl implements GiftTagService {
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
