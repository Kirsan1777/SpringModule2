package com.epam.esm.controller;

import com.epam.esm.model.entity.Tag;
import com.epam.esm.model.service.impl.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Class of tag controller to handle requests and response
 */
@Controller
@RequestMapping("/tag")
public class TagController {
    private static final String ASC = " ORDER BY name ASC";
    private static final String TAG_PAGE = "tag/firstPage";
    private static final String TAG_UPDATE_PAGE = "tag/change";
    private static final String TAG_REDIRECT_PAGE = "redirect:/tag/firstPage";
    private final TagServiceImpl tagService;

    @Autowired
    public TagController(TagServiceImpl tagService){
        this.tagService = tagService;
    }


    @GetMapping("/firstPage")
    public ModelAndView firstPage(ModelAndView model, @RequestParam(value = "sort", required = false) String sort) {
        model.addObject("tags", tagService.allTags(ASC));
        model.addObject("tag", new Tag());
        model.setViewName(TAG_PAGE);
        return model;
    }

    @GetMapping("/sort")
    public ModelAndView sort(ModelAndView model, @RequestParam("sort") String sort){
        model.addObject("tag", new Tag());
        model.setViewName(TAG_PAGE);
        return model;
    }

    @GetMapping("/{id}")
    public ModelAndView show(@PathVariable("id") int id, ModelAndView model) {
        model.addObject("tag", tagService.findById(id));
        model.setViewName(TAG_UPDATE_PAGE);
        return model;
    }

    @GetMapping("/change")
    public ModelAndView seeTag(ModelAndView model){
        model.addObject("tag", new Tag());
        model.setViewName(TAG_UPDATE_PAGE);
        return model;
    }

    @PostMapping
    public ModelAndView createTag(@ModelAttribute("tag") Tag tag, ModelAndView model){
        tagService.addTag(tag.getName());
        model.setViewName(TAG_REDIRECT_PAGE);
        return model;
    }

    @DeleteMapping("/{id}")
    public ModelAndView delete(@PathVariable("id") int id, ModelAndView model) {
        tagService.deleteTag(id);
        model.setViewName(TAG_REDIRECT_PAGE);
        return model;
    }

}