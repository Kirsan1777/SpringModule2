package com.epam.esm.model.service.impl;

import com.epam.esm.model.dao.impl.GiftCertificateDAOImpl;
import com.epam.esm.model.entity.GiftCertificate;
import com.epam.esm.model.service.GiftCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GiftCertificateServiceImpl implements GiftCertificateService {

    private final GiftCertificateDAOImpl giftCertificateDAO;

    @Autowired
    public GiftCertificateServiceImpl(GiftCertificateDAOImpl giftCertificateDAO) {
        this.giftCertificateDAO = giftCertificateDAO;
    }

    public void addGiftCertificate(GiftCertificate giftCertificate){
        giftCertificateDAO.addCertificate(giftCertificate);
    }

    public void deleteGiftCertificate(int id){
        giftCertificateDAO.deleteCertificate(id);
    }

    public List<GiftCertificate> allGiftCertificate(String sort){
        return giftCertificateDAO.allCertificate(sort);
    }

    public void updateGiftCertificate(GiftCertificate giftCertificate){
        giftCertificateDAO.updateCertificate(giftCertificate);
    }

    public GiftCertificate findGiftById(int id){
        return giftCertificateDAO.readOneGiftById(id);
    }
}
