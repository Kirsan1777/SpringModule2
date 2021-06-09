package com.epam.esm.controller;


import com.epam.esm.model.service.impl.GiftCertificateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GiftCertificateController {
    private final GiftCertificateServiceImpl giftCertificate;

    @Autowired
    public GiftCertificateController(GiftCertificateServiceImpl giftCertificate){
        this.giftCertificate = giftCertificate;
    }

    @GetMapping("/secondPage")
    public String firstPage(Model model){
        model.addAttribute("gifts", giftCertificate.allGiftCertificate());
        //String name = request.getParameter("name");
        return "secondPage"; //Представление??? Куда переносит нас после перехода на страницц
    }
}
