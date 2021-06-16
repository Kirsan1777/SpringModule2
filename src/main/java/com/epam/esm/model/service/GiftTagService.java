package com.epam.esm.model.service;

/**
 * The interface concatenated tables service.
 */
public interface GiftTagService {
    /**
     * Method for linking tag and gift certificate
     *
     * @param nameTag the tag name
     * @param idGiftCertificate the gift certificate id
     */
    void addTagToGiftCertificate(String nameTag, int idGiftCertificate);
}
