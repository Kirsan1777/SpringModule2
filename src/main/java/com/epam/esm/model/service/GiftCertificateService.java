package com.epam.esm.model.service;

import com.epam.esm.model.entity.GiftCertificate;

import java.util.List;
/**
 * The interface gift certificate service.
 */
public interface GiftCertificateService {
    /**
     * Method for add gift certificate in DB
     *
     * @param giftCertificate the gift certificate entity
     */
    int addGiftCertificate(GiftCertificate giftCertificate);
    /**
     * Method for delete one gift certificate by id
     *
     * @param id the gift certificate id
     */
    int deleteGiftCertificate(int id);
    /**
     * Method for getting all gift certificate
     *
     * @param sort string with sql sort param
     */
    List<GiftCertificate> allGiftCertificate(String sort);
    /**
     * Method for update gift certificate
     *
     * @param giftCertificate the gift certificate entity
     */
    int updateGiftCertificate(GiftCertificate giftCertificate);

    /**
     * Method for getting one gift certificate by id
     *
     * @param id the gift certificate id
     */
    GiftCertificate findGiftById(int id);
}
