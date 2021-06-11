package com.epam.esm.controller;


import com.epam.esm.model.dao.Transaction;
import com.epam.esm.model.dao.impl.LinkTableDAOImpl;
import com.epam.esm.model.entity.GiftCertificate;
import com.epam.esm.model.service.impl.GiftCertificateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/certificate")
public class GiftCertificateController {
    private static final String DESK = " ORDER BY name DESC";
    private static final String ASC = " ORDER BY name ASC";
    @Autowired
    private Transaction transaction;

    private final GiftCertificateServiceImpl giftCertificate;
    @Autowired
    private LinkTableDAOImpl linkTableDAO;

    @Autowired
    public GiftCertificateController(GiftCertificateServiceImpl giftCertificate){
        this.giftCertificate = giftCertificate;
    }

    @GetMapping("/secondPage")
    public String secondPage(Model model){
        model.addAttribute("tables", linkTableDAO.getConcatenatedTables());
        model.addAttribute("gifts", giftCertificate.allGiftCertificate(ASC));
        model.addAttribute("gift", new GiftCertificate());
        transaction.addTagToGiftCertificate("qwer", 1);
        return "certificate/secondPage";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("gift", giftCertificate.findGiftById(id));
        return "certificate/update";
    }

    @GetMapping("/change")
    public String newTag(Model model){
        model.addAttribute("gift", new GiftCertificate());
        return "certificate/update";
    }

    @PostMapping
    public String createGift(@ModelAttribute("gift") GiftCertificate gift){
        giftCertificate.addGiftCertificate(gift);
        return "redirect:/certificate/secondPage";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        giftCertificate.deleteGiftCertificate(id);
        return "redirect:/certificate/secondPage";
    }

    //Put use for update
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("gift") GiftCertificate gift) {
        giftCertificate.updateGiftCertificate(gift);
        return "redirect:/certificate/secondPage";
    }
}
