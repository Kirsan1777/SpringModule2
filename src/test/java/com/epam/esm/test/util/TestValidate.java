package com.epam.esm.test.util;

import com.epam.esm.model.dao.impl.TagDAOImpl;
import com.epam.esm.model.entity.Tag;
import com.epam.esm.model.service.impl.TagServiceImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.jdbc.core.JdbcTemplate;


import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
public class TestValidate {

    private Tag tag = new Tag();

    @Before
    public void init(){

    }

    @Test
    public void testAssert(){
        tag.setName("Name");
        tag.setId(4);
        TagServiceImpl tagService = mock(TagServiceImpl.class);
        when(tagService.findById(1)).thenReturn(tag);
        Tag tagActual = tagService.findById(1);
        Assert.assertEquals(tag, tagActual);
    }

    @Test//lombok
    public void testAssertDAO(){
        tag.setName("Name");
        tag.setId(1);
        TagServiceImpl tagService = new TagServiceImpl();
        //TagServiceImpl tagService = mock(TagServiceImpl.class);
        TagDAOImpl tagDAO = new TagDAOImpl(mock(JdbcTemplate.class));
        when(tagDAO.readOneTagById(1)).thenReturn(tag);
        Tag tagActual = tagService.findById(1);
        Assert.assertEquals(tag, tagActual);
    }


}
