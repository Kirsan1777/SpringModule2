package com.epam.esm.controller;


import com.epam.esm.model.entity.GiftCertificate;
import com.epam.esm.model.service.impl.GiftCertificateServiceImpl;
import com.epam.esm.model.service.impl.GiftTagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * Class of gift certificate controller to handle requests and response
 */
@Controller
@RequestMapping("/certificate")
public class GiftCertificateController {
    private static final String ASC = " ORDER BY name ASC";
    private static final String CERTIFICATE_PAGE = "certificate/secondPage";
    private static final String CERTIFICATE_UPDATE_PAGE = "certificate/update";
    private static final String CERTIFICATE_REDIRECT_PAGE = "redirect:/certificate/secondPage";


    @Autowired
    private GiftTagServiceImpl giftTagService;

    private final GiftCertificateServiceImpl giftCertificate;

    @Autowired
    public GiftCertificateController(GiftCertificateServiceImpl giftCertificate){
        this.giftCertificate = giftCertificate;
    }

    @GetMapping("/secondPage")
    public ModelAndView secondPage(ModelAndView model){
        model.addObject("gifts", giftCertificate.allGiftCertificate(ASC));
        model.addObject("gift", new GiftCertificate());
        model.setViewName(CERTIFICATE_PAGE);
        return model;
    }

    @GetMapping("/{id}")
    public ModelAndView show(@PathVariable("id") int id, ModelAndView model) {
        model.addObject("gift", giftCertificate.findGiftById(id));
        model.setViewName(CERTIFICATE_UPDATE_PAGE);
        return model;
    }

    @GetMapping("/change")
    public ModelAndView newTag(ModelAndView model){
        model.addObject("gift", new GiftCertificate());
        model.setViewName(CERTIFICATE_UPDATE_PAGE);
        return model;
    }

    @PostMapping("/add")
    public ModelAndView saveCountry(@ModelAttribute GiftCertificate gift, ModelAndView model) {
        giftCertificate.addGiftCertificate(gift);
        model.setViewName(CERTIFICATE_REDIRECT_PAGE);
        return model;
    }

    @RequestMapping(value = "/addTagToGift", method = RequestMethod.POST)
    public ModelAndView addTagToGift(@RequestParam(required = false) String newTag,
                                        ModelAndView model, GiftCertificate gift, int idTag){
        System.out.println(newTag);
        System.out.println(idTag);
        System.out.println(gift);
        giftTagService.addTagToGiftCertificate(newTag, idTag);
        model.setViewName(CERTIFICATE_REDIRECT_PAGE);
        return model;

    }

    @DeleteMapping("/{id}")
    public ModelAndView delete(@PathVariable("id") int id, ModelAndView model) {
        giftCertificate.deleteGiftCertificate(id);
        model.setViewName(CERTIFICATE_REDIRECT_PAGE);
        return model;
    }

    @PatchMapping("/{id}")
    public ModelAndView update(@ModelAttribute("gift") GiftCertificate gift, ModelAndView model) {
        giftCertificate.updateGiftCertificate(gift);
        model.setViewName(CERTIFICATE_REDIRECT_PAGE);
        return model;
    }
}