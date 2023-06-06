/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectopractica.Proyecto.service;

import com.proyectopractica.Proyecto.model.Rol;
import com.proyectopractica.Proyecto.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Raul
 */
public class RolServiceImpl extends GenericServiceImpl<Rol, Integer> implements GenericService<Rol, Integer>{

    @Autowired
    RolRepository rolRepository;

    @Override
    public CrudRepository<Rol, Integer> getDao() {
        return rolRepository;
    }
    
}
