/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectopractica.Proyecto.repository;

import com.proyectopractica.Proyecto.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Raul
 */
public interface RolRepository extends JpaRepository<Rol, Integer>{
    @Query(value = "Select * from rol u where u.tipo = :tipo", nativeQuery = true)
    public Rol buscarRol(String nombre);
}
