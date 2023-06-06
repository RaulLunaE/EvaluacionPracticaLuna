/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectopractica.Proyecto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Raul
 */
@Data
@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrol")
    private int idrol;
    
    @Column(name = "tipo")
    private String tipo;  
    
    @Column(name = "estado")
    private String estado;  
    
    //////////////////////ESTA ES LA FINALIZACION A LA CONEXION CON PERSONA
    @JsonIgnore
    @OneToMany(mappedBy = "rol")
    private List<Usuario> listaUsuario;
}
