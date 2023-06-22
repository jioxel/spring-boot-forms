package com.jioxel.app.cspringbootform.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jioxel.app.cspringbootform.services.RoleService;

@Component
public class RolePropertyEditors extends PropertyEditorSupport{
     @Autowired
     private RoleService roleService;

     @Override
     public void setAsText(String idString) throws IllegalArgumentException {
          try{
               Integer id = Integer.parseInt(idString);
               setValue(roleService.obtenerRole(id));
          }catch(NumberFormatException e){
          super.setValue(null);;
          }

     }

     
}
