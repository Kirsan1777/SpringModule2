package com.epam.esm.test.model.dao;

import com.epam.esm.model.dao.impl.TagDAOImpl;
import com.epam.esm.model.entity.Tag;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

//@ExtendWith(SpringExtension.class)
public class TagDAOTest {
    private TagDAOImpl tagDAO;


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
        tagDAO = new TagDAOImpl(new JdbcTemplate(dataSource));
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
        tagDAO = null;
    }

    @Test
    public void addGiftCertificateValidTest() {
        Tag checkResult = new Tag();
        checkResult.setId(1);
        checkResult.setName("tag1");
        Tag created = tagDAO.readOneTagById(1);;
        Assert.assertEquals(checkResult, created);
    }
}
