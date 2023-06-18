package com.jioxel.app.cspringbootform.models.domain;

import java.util.Date;

// import org.springframework.format.annotation.DateTimeFormat;

import com.jioxel.app.cspringbootform.validations.IdentificadorRegex;
import com.jioxel.app.cspringbootform.validations.Requerido;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
// import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Usuario {
     // @Pattern(regexp = "[0-9]{3}[-][A-Z]{1}")
     @IdentificadorRegex
     private String id;
     

     // @NotEmpty
     private String nombre;

     @Requerido
     private String apellido;
     
     @NotBlank
     @Size(min = 3, max = 10)
     private String username;
     
     @NotEmpty
     private String password;
     
     @NotEmpty
     @Email
     private String email;
     
     @NotNull
     @Min(5)
     @Max(5000)
     private Integer cuenta;

     @NotNull
     @Past //Solo fecha pasada a la actual
     // @Future // feecha en futuro
     //@DateTimeFormat(pattern = "yyyy-MM-dd")
     private Date fechaNacimiento;

     @Valid
     private Pais pais;

     public String getUsername() {
          return username;
     }
     public void setUsername(String username) {
          this.username = username;
     }
     public String getPassword() {
          return password;
     }
     public void setPassword(String password) {
          this.password = password;
     }
     public String getEmail() {
          return email;
     }
     public void setEmail(String email) {
          this.email = email;
     }      
     public String getNombre() {
          return nombre;
     }
     public void setNombre(String nombre) {
          this.nombre = nombre;
     }
     public String getApellido() {
          return apellido;
     }
     public void setApellido(String apellido) {
          this.apellido = apellido;
     }
     public String getId() {
          return id;
     }
     public void setId(String id) {
          this.id = id;
     }
     public Integer getCuenta() {
          return cuenta;
     }
     public void setCuenta(Integer cuenta) {
          this.cuenta = cuenta;
     }
     public Date getFechaNacimiento() {
          return fechaNacimiento;
     }
     public void setFechaNacimiento(Date fechaNacimiento) {
          this.fechaNacimiento = fechaNacimiento;
     }
     public Pais getPais() {
          return pais;
     }
     public void setPais(Pais pais) {
          this.pais = pais;
     }
}
