package com.epam.esm.test.configuration;

import com.epam.esm.model.dao.impl.TagDAOImpl;
import com.epam.esm.model.service.impl.TagServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.Mockito.mock;

@Configuration
public class ConfigTest {

    @Bean
    public TagServiceImpl tagServiceImpl(){
        return mock(TagServiceImpl.class);
    }

   @Bean
    public TagDAOImpl tagDAO(){
        return new TagDAOImpl(template());
    }

    @Bean
    public JdbcTemplate template(){
        return mock(JdbcTemplate.class);
    }
}
