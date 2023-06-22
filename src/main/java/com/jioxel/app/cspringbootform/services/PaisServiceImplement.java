package com.jioxel.app.cspringbootform.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jioxel.app.cspringbootform.models.domain.Pais;

@Service
public class PaisServiceImplement implements PaisService{
     private List<Pais> paises;

     public PaisServiceImplement(){
          this.paises=Arrays.asList( new Pais(1, "JP", "Japon"),new Pais(2, "CL", "Colombia"),new Pais(3, "MX", "Mexico"));
     }
     @Override
     public List<Pais> listar() {
          return paises;
     }

     @Override
     public Pais obtenerPais(Integer id) {
          Pais resultado = null;
          for(Pais pais: this.paises){
               if(id == pais.getId()){
                    resultado = pais;
                    break;
               }
          }
          return resultado;
     }
     
}
