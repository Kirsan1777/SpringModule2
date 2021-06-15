package com.epam.esm.model.dao;

import com.epam.esm.model.dao.query.SqlGiftCertificateQuery;
import com.epam.esm.model.entity.GiftCertificate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

public interface GiftCertificateDAO {
    List<GiftCertificate> allCertificate(String sort);

    GiftCertificate readOneGiftById(int id);

    int addCertificate(GiftCertificate certificate);

    int deleteCertificate(int idCertificate);

    int updateCertificate(GiftCertificate giftCertificate);

}