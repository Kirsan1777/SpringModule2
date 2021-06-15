package com.epam.esm.model.service;

import com.epam.esm.model.entity.GiftCertificate;

import java.time.LocalDateTime;
import java.util.List;

public interface GiftCertificateService {
    int addGiftCertificate(GiftCertificate giftCertificate);

    int deleteGiftCertificate(int id);

    List<GiftCertificate> allGiftCertificate(String sort);

    int updateGiftCertificate(GiftCertificate giftCertificate);

    GiftCertificate findGiftById(int id);
}
