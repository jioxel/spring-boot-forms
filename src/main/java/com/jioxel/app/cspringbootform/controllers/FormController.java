package com.jioxel.app.cspringbootform.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.jioxel.app.cspringbootform.models.domain.Usuario;

import jakarta.validation.Valid;


@Controller
@SessionAttributes("usuario") // persiste el objeto usuario en la sesion
public class FormController {

     @GetMapping("/form")
     public String form(Model model) {
          Usuario usuario = new Usuario();
          usuario.setNombre("jovany");
          usuario.setApellido("Elen");
          usuario.setId("456-k");
          model.addAttribute("title"," Agregar Titulo");
          model.addAttribute("usuario", usuario);
          return "form";
     }
     @PostMapping("/form")
     public String recibirFormulario(@Valid Usuario usuario,BindingResult result,Model model, SessionStatus status //se meten los datos del formulario solos al objeto Usuario
          // @RequestParam("username") String username,
          // @RequestParam("password") String password,
          // @RequestParam("email") String email
     ){
          // Usuario usuario = new Usuario();

          // usuario.setUsername(username);
          // usuario.setEmail(email);
          // usuario.setPassword(password);
          model.addAttribute("title", "Resultado Form");

          if(result.hasErrors()){
               // Map<String,String> errores = new HashMap<>();
               // result.getFieldErrors().forEach(err ->{
               //      errores.put(err.getField(), "El campo: ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
               // });
               // model.addAttribute("error", errores);

               return "form";
          }
          
          model.addAttribute("usuario", usuario);
          status.setComplete(); //acompleta los campos que existen pero el formulario no mando como el id que existe en un registro peroel usuario no manda el valor
          return "resultado";
     }
}
