package com.jioxel.app.cspringbootform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FormController {

     @GetMapping("/form")
     public String form(Model model) {

          return "form";
     }
     @PostMapping("/form")
     public String recibirFormulario(Model model){
          
          return "resultado";
     }
}
