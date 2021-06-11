package com.epam.esm.controller;

import com.epam.esm.model.entity.Tag;
import com.epam.esm.model.service.impl.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("film")
public class TagController {
    private final TagServiceImpl tagService;

    public TagController(TagServiceImpl tagService) {
        this.tagService = tagService;
    }

    /*@GetMapping
    public Set<Tag> list(){
        return tagService.allTags();
    }*/
}
