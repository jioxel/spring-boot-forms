package com.jioxel.app.cspringbootform.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jioxel.app.cspringbootform.services.PaisService;

@Component //para poder inyectar un valor aqui
public class PaisPropertyEditors extends PropertyEditorSupport{
     @Autowired
     private PaisService service;

     @Override
     public void setAsText(String idString) throws IllegalArgumentException {
          if(idString != null && idString.length() >0){
               try{
                    Integer id = Integer.parseInt(idString);
                    this.setValue(service.obtenerPais(id));

               } catch (NumberFormatException e){
                    this.setValue(null);
               }
               
          }else {
               setValue(null);
          }
     }
}
