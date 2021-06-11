package com.epam.esm.model.dao;

import com.epam.esm.model.dao.impl.GiftCertificateDAOImpl;
import com.epam.esm.model.dao.impl.LinkTableDAOImpl;
import com.epam.esm.model.dao.impl.TagDAOImpl;
import com.epam.esm.util.TagValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component
public class Transaction {
    @Autowired
    private TagDAOImpl tagDAO;

    @Autowired
    private GiftCertificateDAOImpl giftCertificateDAO;

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
