package by.nikita.springcore.model.service;

import by.nikita.springcore.model.entity.GiftCertificate;

public interface GiftCertificateService {
    //CRUD  create read update delete

    void createCertificate(GiftCertificate giftCertificate);
    void deleteCertificate(int id);
    void updateCertificate(int id, GiftCertificate giftCertificate);
    GiftCertificate readCertificate(int id);

}
