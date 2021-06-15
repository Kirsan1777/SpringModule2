package com.epam.esm.model.dao;

import com.epam.esm.model.dao.query.SqlManyToManyQuery;
import com.epam.esm.model.entity.GiftTag;

import java.util.List;

public interface LinkTableDAO {
    void addTagToGiftCertificate(int idTag, int idGift);

    List<GiftTag> getConcatenatedTables(String sortBy);
}
