/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectopractica.Proyecto.controller;

import com.proyectopractica.Proyecto.model.Venta;
import com.proyectopractica.Proyecto.service.VentaServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Raul
 */
@RestController
@RequestMapping("/venta")
public class VentaController {
    @Autowired
    VentaServiceImpl ventaService;
    
    @Operation(summary = "Se consulta la informacion para obtener la lista de los usuarios")
    @GetMapping("/listar")
    public ResponseEntity<List<Venta>> listaUsuarios() {
        return new ResponseEntity<>(ventaService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Se rellenaran los atributos para crear un usuario")
    @PostMapping("/crear")
    public ResponseEntity<Venta> crearUsuario(@RequestBody Venta u) {
        return new ResponseEntity<>(ventaService.save(u), HttpStatus.CREATED);
    }

    @Operation(summary = "Se editaran los atributos de un usuario ya creado")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Venta> actualizarUsuario(@PathVariable Integer id, @RequestBody Venta u) {
        Venta usuario = ventaService.findById(id);
        if (usuario != null) {
            try {
                usuario.setCliente(u.getCliente());
                usuario.setProducto(u.getProducto());
                usuario.setCantidad(u.getCantidad());
                usuario.setPrecio(u.getPrecio());
                usuario.setFecha(u.getFecha());
                usuario.setListaUsuario(u.getListaUsuario());
                usuario.setListaproductos(u.getListaproductos());
                return new ResponseEntity<>(ventaService.save(usuario), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Se seleccionara un id para eliminar un usuario")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Venta> elimiarUsuario(@PathVariable Integer id) {
        ventaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
