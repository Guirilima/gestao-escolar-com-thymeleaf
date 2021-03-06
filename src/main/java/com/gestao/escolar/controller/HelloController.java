package com.gestao.escolar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("mensagem","Olá Spring Boot com Thymeleaf.");
        return "index";//Por padrão thymeleaf procura na pasta src/resources/templates
    }
}
