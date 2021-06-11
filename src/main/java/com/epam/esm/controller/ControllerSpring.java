package com.epam.esm.controller;

import com.epam.esm.model.entity.Tag;
import com.epam.esm.model.service.impl.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.Set;

@Controller
@RequestMapping("/tag")
public class ControllerSpring {
    private static final String DESK = " ORDER BY name DESC";
    private static final String ASC = " ORDER BY name ASC";
    private final TagServiceImpl tagService;

    @Autowired
    public ControllerSpring(TagServiceImpl tagService){
        this.tagService = tagService;
    }

    @GetMapping("/firstPage")
    public String firstPage(Model model, @RequestParam(value = "sort", required = false) String sort){
        model.addAttribute("tags", tagService.allTags(ASC));
        model.addAttribute("tag", new Tag());
        return "tag/firstPage";
    }

    @GetMapping("/sort")
    public String sort(Model model, @RequestParam("sort") String sort){

        model.addAttribute("tag", new Tag());
        return "tag/firstPage";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("tag", tagService.findById(id));
        return "tag/change";
    }

    @GetMapping("/change")
    public String seeTag(Model model){
        model.addAttribute("tag", new Tag());
        return "tag/change";
    }

    @PostMapping
    public String createTag(@ModelAttribute("tag") Tag tag){
        tagService.addTag(tag.getName());
        return "redirect:/tag/firstPage";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        tagService.deleteTag(id);
        return "redirect:/tag/firstPage";
    }

}