package com.epam.esm.model.dao;

import com.epam.esm.model.dao.query.SqlGiftCertificateQuery;
import com.epam.esm.model.entity.GiftCertificate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

/**
 * The interface gift certificate DAO.
 */
public interface GiftCertificateDAO {

    /**
     * Method for getting all gift certificate
     *
     * @param sort string with sql sort param
     */
    List<GiftCertificate> allCertificate(String sort);

    /**
     * Method for getting one gift certificate by id
     *
     * @param id the gift certificate id
     */
    GiftCertificate readOneGiftById(int id);

    /**
     * Method for add one gift certificate
     *
     * @param certificate the gift certificate entity
     */
    int addCertificate(GiftCertificate certificate);

    /**
     * Method for delete one gift certificate by id
     *
     * @param idCertificate the gift certificate id
     */
    int deleteCertificate(int idCertificate);

    /**
     * Method for update one gift certificate
     *
     * @param giftCertificate the gift certificate entity
     */
    int updateCertificate(GiftCertificate giftCertificate);

}