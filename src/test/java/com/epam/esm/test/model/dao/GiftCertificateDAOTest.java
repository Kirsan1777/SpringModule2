package com.epam.esm.test.model.dao;

import com.epam.esm.model.dao.impl.GiftCertificateDAOImpl;
import com.epam.esm.model.entity.GiftCertificate;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.time.Month;

public class GiftCertificateDAOTest {

    private GiftCertificateDAOImpl giftCertificateDAO;

    GiftCertificate giftCertificateUpdated = new GiftCertificate(10,"newTagUpdate",200,1,
            LocalDateTime.of(2017, Month.NOVEMBER, 30, 0,0),
            LocalDateTime.of(2017, Month.NOVEMBER, 30, 0,0),
            "newGift");
    
    GiftCertificate giftCertificate = new GiftCertificate(1,"desc1",1,1,
            LocalDateTime.of(2021, Month.JUNE, 2, 0,0),
            LocalDateTime.of(2021, Month.JUNE, 2, 0,0),
            "cer1");

    @BeforeEach
    public void setUp() {
        DataSource dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setScriptEncoding("UTF-8")
                .addScript("classpath:query/create_gift_certificate_table.sql")
                .addScript("classpath:query/fill_gift_certificate_table.sql")
                .addScript("classpath:query/create_many_to_many_table.sql")
                .addScript("classpath:query/fill_many_to_many_table.sql")
                .addScript("classpath:query/create_tag_table.sql")
                .addScript("classpath:query/fill_tag_table.sql")
                .build();
        giftCertificateDAO = new GiftCertificateDAOImpl(new JdbcTemplate(dataSource));
    }

    @AfterEach
    public void deactivate() {
        new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setScriptEncoding("UTF-8")
                .addScript("classpath:query/delete_gift_certificate_table.sql")
                .addScript("classpath:query/delete_tag_table.sql")
                .addScript("classpath:query/delete_many_to_many_table.sql")
                .build();
        giftCertificateDAO = null;
    }

    @Test
    public void addGiftCertificateValidTest() {
        int result = giftCertificateDAO.addCertificate(giftCertificateUpdated);
        Assert.assertEquals(1, result);
    }

    @Test
    public void getAllGiftCertificateValidTest() {
        int resultSize = giftCertificateDAO.allCertificate("").size();
        Assert.assertEquals(5, resultSize);
    }

    @Test
    public void deleteGiftCertificateValidTest(){
        int result = giftCertificateDAO.deleteCertificate(1);;
        Assert.assertEquals(result, 1);
    }

    @Test
    public void updateGiftCertificateValidTest(){
        int result = giftCertificateDAO.updateCertificate(giftCertificate);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void readOneGiftCertificateValidTest(){
        GiftCertificate result = giftCertificateDAO.readOneGiftById(1);
        Assert.assertEquals(result, giftCertificate);
    }


}
