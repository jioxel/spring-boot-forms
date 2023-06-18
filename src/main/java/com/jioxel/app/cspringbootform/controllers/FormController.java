package com.jioxel.app.cspringbootform.controllers;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.jioxel.app.cspringbootform.editors.NombreMayusculaEditors;
import com.jioxel.app.cspringbootform.models.domain.Pais;
import com.jioxel.app.cspringbootform.models.domain.Usuario;
import com.jioxel.app.cspringbootform.validations.UsuarioValidador;

import jakarta.validation.Valid;



@Controller
@SessionAttributes("usuario") // persiste el objeto usuario en la sesion
public class FormController {
     @Autowired
     private UsuarioValidador validador;

     @InitBinder //Valida de forma transparente
     public void initBinder(WebDataBinder binder){
          binder.addValidators(validador);
          // addValidators agrega la validacion
          // setValidator Cambia las validaciones por nuestra clase validadora

          SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd");
          dateForm.setLenient(false);
          binder.registerCustomEditor(Date.class,"fechaNacimiento", new CustomDateEditor(dateForm,false));

          //editor para volver los campos mayuscula
          binder.registerCustomEditor(String.class, "nombre" ,new NombreMayusculaEditors());
          binder.registerCustomEditor(String.class, "appellido" ,new NombreMayusculaEditors());
     }

     @ModelAttribute("listaPaises")
     public List<Pais> listaPaises(){
          
          return Arrays.asList( new Pais(3, "JP", "Japon"),new Pais(2, "CL", "Colombia"),new Pais(3, "MX", "Mexico"));
     }

     @ModelAttribute("paises")
     public List<String> paises(){
          
          return Arrays.asList("Mexico","Europa","Asia");
     }

     @ModelAttribute("paisesMap")
     public Map<String,String> paisesMap(){
          
          Map<String,String> paises = new HashMap<String,String>();
          paises.put("MX", "Mexico");
          paises.put("JP","JAPON");
          paises.put("CL", "Colombia");
          return paises;
     }
     @GetMapping("/form")
     public String form(Model model) {
          Usuario usuario = new Usuario();
          usuario.setNombre("jovany");
          usuario.setApellido("Elen");
          usuario.setId("456-K");
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


          // validador.validate(usuario, result); //validador explicito
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
