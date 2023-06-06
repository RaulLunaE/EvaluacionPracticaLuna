/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectopractica.Proyecto.repository;

import com.proyectopractica.Proyecto.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Raul
 */
public interface VentaRepository extends JpaRepository<Venta, Integer>{
    @Query(value = "Select * from venta u where u.cliente = :cliente", nativeQuery = true)
    public Venta buscarVenta(String nombre);
}
