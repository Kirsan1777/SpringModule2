package com.epam.esm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControllerSpring {

    @GetMapping("/firstPage")
    public String firstPage(HttpServletRequest request, Model model){
        model.addAttribute("name", "Kirsan");
        //String name = request.getParameter("name");
        return "firstPage"; //Представление??? Куда переносит нас после перехода на страницц
    }

    @GetMapping("/secondPage")
    public String secondPage(@RequestParam(value = "name",
            required = false /*Если переменных нет, то будет null*/) String name){
        System.out.println(name);
        return "secondPage";
    }


}