package com.epam.esm.controller;

import com.epam.esm.model.entity.Tag;
import com.epam.esm.model.service.impl.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tag")
public class ControllerSpring {

    private final TagServiceImpl tagService;

    @Autowired
    public ControllerSpring(TagServiceImpl tagService){
        this.tagService = tagService;
    }

    @GetMapping("/firstPage")
    public String firstPage(Model model){
        model.addAttribute("tags", tagService.allTags());
        model.addAttribute("tag", new Tag());
        //String name = request.getParameter("name");
        return "tag/firstPage"; //Представление??? Куда переносит нас после перехода на страницц
    }

    @GetMapping("/new")
    public String newTag(Model model){
        model.addAttribute("tag", new Tag());
        return "tag/new";
    }

    @PostMapping
    public String createTag(@ModelAttribute("tag") Tag tag){
        tagService.addTag(tag.getName());
        return "redirect:/tag/firstPage";
    }

}