package com.epam.esm.model.dao.impl;

import com.epam.esm.model.dao.GiftCertificateDAO;
import com.epam.esm.model.dao.TagMapper;
import com.epam.esm.model.dao.query.SqlGiftCertificateQuery;
import com.epam.esm.model.dao.query.SqlTagQuery;
import com.epam.esm.model.entity.GiftCertificate;
import com.epam.esm.model.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GiftCertificateDAOImpl implements GiftCertificateDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GiftCertificateDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<GiftCertificate> allCertificate(){
        return jdbcTemplate.query(SqlGiftCertificateQuery.SELECT_ALL_CERTIFICATE, new BeanPropertyRowMapper<>(GiftCertificate.class));
    }

    public void addCertificate(GiftCertificate certificate) {
        jdbcTemplate.update(SqlGiftCertificateQuery.ADD_CERTIFICATE, certificate.getDescription(), certificate.getPrice(),
                certificate.getDuration(), certificate.getCreateDate(), certificate.getLastUpdateDate(), certificate.getName());
    }

    public void deleteCertificate(int idCertificate) {
        jdbcTemplate.query(SqlGiftCertificateQuery.DELETE_CERTIFICATE, new Object[]{idCertificate}, new BeanPropertyRowMapper<>(GiftCertificate.class));
    }

    public void updateCertificate(GiftCertificate giftCertificate){
        jdbcTemplate.update(SqlGiftCertificateQuery.UPDATE_CERTIFICATE,
                giftCertificate.getDescription(), giftCertificate.getPrice(),
                giftCertificate.getDuration(), giftCertificate.getCreateDate(),
                giftCertificate.getLastUpdateDate(), giftCertificate.getName(), giftCertificate.getId());
    }

}
