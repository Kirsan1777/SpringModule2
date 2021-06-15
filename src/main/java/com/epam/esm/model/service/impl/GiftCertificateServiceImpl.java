package com.epam.esm.model.service.impl;

import com.epam.esm.model.dao.impl.GiftCertificateDAOImpl;
import com.epam.esm.model.entity.GiftCertificate;
import com.epam.esm.model.service.GiftCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.List;

@Component
public class GiftCertificateServiceImpl implements GiftCertificateService {

    private final GiftCertificateDAOImpl giftCertificateDAO;

    @Autowired
    public GiftCertificateServiceImpl(GiftCertificateDAOImpl giftCertificateDAO) {
        this.giftCertificateDAO = giftCertificateDAO;
    }

    public int addGiftCertificate(GiftCertificate giftCertificate){
        giftCertificate.setCreateDate(LocalDateTime.now());
        giftCertificate.setLastUpdateDate(LocalDateTime.now());
        return giftCertificateDAO.addCertificate(giftCertificate);
    }

    public int deleteGiftCertificate(int id){
        return giftCertificateDAO.deleteCertificate(id);
    }

    public List<GiftCertificate> allGiftCertificate(String sort){
        return giftCertificateDAO.allCertificate(sort);
    }

    public int updateGiftCertificate(GiftCertificate giftCertificate){
        giftCertificate.setLastUpdateDate(LocalDateTime.now());
        return giftCertificateDAO.updateCertificate(giftCertificate);
    }

    public GiftCertificate findGiftById(int id){
        return giftCertificateDAO.readOneGiftById(id);
    }
}
