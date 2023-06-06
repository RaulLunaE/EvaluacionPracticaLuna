/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectopractica.Proyecto.service;

import com.proyectopractica.Proyecto.model.Producto;
import com.proyectopractica.Proyecto.model.Usuario;
import com.proyectopractica.Proyecto.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Raul
 */
public class ProductoServiceImpl extends GenericServiceImpl<Producto, Integer> implements GenericService<Producto, Integer>{

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public CrudRepository<Producto, Integer> getDao() {
        return productoRepository;
    }
}
