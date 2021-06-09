package com.epam.esm.test.model.service;

import com.epam.esm.model.dao.impl.TagDAOImpl;
import com.epam.esm.test.configuration.ConfigTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ConfigTest.class, loader = AnnotationConfigContextLoader.class)
public class TagServiceImplTest {


    @Test
    public void validateNameAccept(){
        /*when(tagDAO.readOneTag(NAME)).thenReturn(null);
        Assert.assertEquals(tagDAO.readOneTag(NAME), null);*/
    }
}

