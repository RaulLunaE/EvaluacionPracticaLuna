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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Raul
 */
@Data
@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idventa")
    private int idventa;
    
    @Column(name = "cliente")
    private String cliente;
    
    @Column(name = "producto")
    private String producto;
    
    @Column(name = "cantidad")
    private String cantidad;
    
    @Column(name = "precio")
    private String precio;
    
    @Column(name = "fecha")
    private String fecha;
    /*
La asociación podrá visualizar las ventas realizadas de sus productos, incluyendo 
información como el cliente, el producto adquirido, la cantidad, el precio y la fecha de 
venta.
    */
    
    //////////////////////ESTA ES LA FINALIZACION A LA CONEXION CON PERSONA
    @JsonIgnore
    @OneToMany(mappedBy = "rol")
    private List<Usuario> listaUsuario;
    
    //////////////////////ESTA ES LA FINALIZACION A LA CONEXION CON producto
    @ManyToMany(mappedBy = "producto")
    private List<Producto> listaproductos;
}
