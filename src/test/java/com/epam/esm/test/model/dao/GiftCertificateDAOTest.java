package com.epam.esm.test.model.dao;

import com.epam.esm.model.dao.impl.GiftCertificateDAOImpl;
import com.epam.esm.model.dao.impl.TagDAOImpl;
import com.epam.esm.model.entity.GiftCertificate;
import com.epam.esm.model.entity.Tag;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.util.List;

public class GiftCertificateDAOTest {

    private GiftCertificateDAOImpl giftCertificateDAO;

    private static final String SELECT = "SELECT * FROM gift_certificate";

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
        GiftCertificate checkResult = new GiftCertificate();
        checkResult.setId(1);
        checkResult.setName("tag1");
        List<GiftCertificate> certificates = giftCertificateDAO.allCertificate("");


        //certificates.stream().forEach(System.out::println);


        /*GiftCertificate created = giftCertificateDAO.readOneGiftById(1);;
        Assert.assertEquals(checkResult, created);*/
    }

    /*@Test
    public void addGiftCertificateInvalidTest(){
        GiftCertificate checkResult = new GiftCertificate();
        checkResult.setId(2);
        checkResult.setName("tag2");
        GiftCertificate created = giftCertificateDAO.readOneGiftById(1);;
        Assert.assertNotEquals(checkResult, created);
    }*/
}
