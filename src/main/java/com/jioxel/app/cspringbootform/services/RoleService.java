package com.jioxel.app.cspringbootform.services;

import java.util.List;

import com.jioxel.app.cspringbootform.models.domain.Role;

public interface RoleService {
     public List<Role> listar();
     public Role obtenerRole(Integer id);
}
