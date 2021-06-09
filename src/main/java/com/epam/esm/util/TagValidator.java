package com.epam.esm.util;

import com.epam.esm.model.service.impl.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TagValidator {
    private final TagServiceImpl tagService;

    public TagValidator(TagServiceImpl tagService) {
        this.tagService = tagService;
    }

    public boolean checkDuplicateTag(String name){
        if(tagService.findByName(name) != null){
            System.out.println("This tag already yet");
        }
        return false;
    }
}
