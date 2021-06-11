package com.epam.esm.test.util;

import com.epam.esm.model.service.impl.TagServiceImpl;
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
@ContextConfiguration(classes = ConfigTest.class)
public class TagValidatorTest {
    private static final String NAME = "Nikita";

    @Autowired
    private TagServiceImpl tagServiceImpl;

    public TagValidatorTest(){
    }

    public TagValidatorTest(TagServiceImpl tagServiceImpl) {
        this.tagServiceImpl = tagServiceImpl;
    }

    @Test
    public void checkValidateName(){
        when(tagServiceImpl.findByName(NAME)).thenReturn(null);
        boolean resultName = tagServiceImpl.findByName(NAME).getName() == null;
        Assert.assertTrue(resultName);
    }

}
