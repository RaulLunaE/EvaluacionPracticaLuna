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
import jakarta.persistence.ManyToMany;
import lombok.Data;

/**
 *
 * @author Raul
 */
@Data
@Entity
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducto")
    private int idproducto;
    
    @Column(name = "detalle")
    private String detalle;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "categoria")
    private String categoria;
    
    @Column(name = "precio_emprendedor")
    private String precio_emprendedor;
    
    @Column(name = "imagen")
    private String imagen;
    
    @Column(name = "adicionales")
    private String adicionales;
    
    /*              RELACION CON VENTA              */
    @ManyToMany
    @JoinColumn(name = "id_ventas_producto", referencedColumnName = "idventa")
    private Venta listaventa;
}
