package com.jioxel.app.cspringbootform.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;


import com.jioxel.app.cspringbootform.models.domain.Role;

@Service
public class RoleServiceImplement implements RoleService{
     private List<Role> roles;
     
     public RoleServiceImplement(){
          this.roles = Arrays.asList(
               new Role(1, "Administrador", "ROLE_ADMIN"),
               new Role(2, "Usuario", "ROLE_USER"),
               new Role(3, "Moderador", "ROLE_MODER")
          );
     }

     @Override
     public List<Role> listar() {
          return roles;
     }

     @Override
     public Role obtenerRole(Integer id) {
          Role newRole=null;
          for(Role role: this.roles){
               if(id == role.getId()){
                    newRole = role;
                    break;
               }
          }
          return newRole; 
     }
     
}
