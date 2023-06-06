/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectopractica.Proyecto.repository;

import com.proyectopractica.Proyecto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Raul
 */
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    @Query(value = "Select * from producto u where u.nombre = :nombre", nativeQuery = true)
    public Producto buscarProducto(String nombre);
}
