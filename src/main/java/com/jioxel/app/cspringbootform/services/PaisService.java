package com.jioxel.app.cspringbootform.services;

import java.util.List;

import com.jioxel.app.cspringbootform.models.domain.Pais;

public interface PaisService {
     public List<Pais> listar();
     public Pais obtenerPais(Integer id);
}
