package com.epam.esm.test.model.service;

import com.epam.esm.model.dao.impl.TagDAOImpl;
import com.epam.esm.model.entity.Tag;
import com.epam.esm.model.service.impl.TagServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TagServiceTest {
    private static TagServiceImpl tagService;
    private static Tag tag = new Tag("Test");
    private static Tag tagFalse = new Tag("TestFalse");

    @BeforeAll
    public static void setup(){
        TagDAOImpl tagDAO = mock(TagDAOImpl.class);
        Tag newTag = new Tag("newTag");
        when(tagDAO.addTag(newTag.getName())).thenReturn(1);
        when(tagDAO.allTags("")).thenReturn(new ArrayList<Tag>(Arrays.asList(newTag)));
        when(tagDAO.deleteTag(1)).thenReturn(1);
        when(tagDAO.readOneTagById(1)).thenReturn(tag);
        when(tagDAO.readOneTagByName("Test")).thenReturn(tag);
        tagService = new TagServiceImpl(tagDAO);
    }

    @Test
    public void addTagTestTrue() {
        assertEquals(tagService.addTag("newTag"),1);
    }

    @Test
    public void getAllGiftCertTestFalse() {
        int listSize = tagService.allTags("").size();
        assertNotEquals(listSize,0);
    }

    @Test
    public void deleteTagTestTrue(){
        assertEquals(tagService.deleteTag(1),1);
    }

    @Test
    public void addTagTestFalse() {
        assertNotEquals(tagService.addTag("newTag"),0);
    }

    @Test
    public void getAllGiftCertTestTrue() {
        int listSize = tagService.allTags("").size();
        assertEquals(listSize,1);
    }

    @Test
    public void deleteTagTestFalse(){
        assertNotEquals(tagService.deleteTag(1),0);
    }

    @Test
    public void getOneByIdTagTestTrue(){
        assertEquals(tagService.findById(1), tag);
    }

    @Test
    public void getOneByIdTestFalse(){
        assertNotEquals(tagService.findById(1), tagFalse);
    }

    @Test
    public void getOneByNameTagTestTrue(){
        assertEquals(tagService.findByName("Test"), tag);
    }

    @Test
    public void getOneByNameTestFalse(){
        assertNotEquals(tagService.findByName("Test"), tagFalse);
    }
}
