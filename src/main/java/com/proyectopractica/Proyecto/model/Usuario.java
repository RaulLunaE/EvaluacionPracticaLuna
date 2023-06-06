/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectopractica.Proyecto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author Raul
 */
@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private int idusuario;
    
    @Column(name = "nombre")
    private String nombre; 
    
    @Column(name = "apellido")
    private String apellido; 
    
    @Column(name = "cedula")
    private String cedula; 
    
    @Column(name = "direccion")
    private String direccion; 
    
    @Column(name = "numero")
    private String numero; 
    
    @Column(name = "correo")
    private String correo; 
    
    @Column(name = "contra")
    private String contra; 
    
    //////INICIO DE LAS FRELACIONES
    /*              RELACION CON ROL              */
    @ManyToOne
    @JoinColumn(name = "id_roles", referencedColumnName = "idrol")
    private Rol rol;
    
    /*              RELACION CON VENTA              */
    @ManyToOne
    @JoinColumn(name = "id_ventas", referencedColumnName = "idventa")
    private Venta venta;
}
