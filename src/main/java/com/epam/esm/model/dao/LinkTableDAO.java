package com.epam.esm.model.dao;

import com.epam.esm.model.entity.GiftTag;

import java.util.List;

/**
 * The interface concatenated tables DAO.
 */
public interface LinkTableDAO {
    /**
     * Method for add tag to gift certificate
     *
     * @param idTag  the tag id
     * @param idGift the gift certificate id
     */
    void addTagToGiftCertificate(int idTag, int idGift);

    /**
     * Method for concatenated tables gift certificate and tag
     *
     * @param sortBy the param for sort table
     */
    List<GiftTag> getConcatenatedTables(String sortBy);
}
