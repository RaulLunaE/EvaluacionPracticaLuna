/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectopractica.Proyecto.controller;

import com.proyectopractica.Proyecto.model.Rol;
import com.proyectopractica.Proyecto.service.RolServiceImpl;
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
@RequestMapping("/rol")
public class RolController {
    @Autowired
    RolServiceImpl rolService;
    
    @Operation(summary = "Se consulta la informacion para obtener la lista de los usuarios")
    @GetMapping("/listar")
    public ResponseEntity<List<Rol>> listaUsuarios() {
        return new ResponseEntity<>(rolService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Se rellenaran los atributos para crear un usuario")
    @PostMapping("/crear")
    public ResponseEntity<Rol> crearUsuario(@RequestBody Rol u) {
        return new ResponseEntity<>(rolService.save(u), HttpStatus.CREATED);
    }

    @Operation(summary = "Se editaran los atributos de un usuario ya creado")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Rol> actualizarUsuario(@PathVariable Integer id, @RequestBody Rol u) {
        Rol usuario = rolService.findById(id);
        if (usuario != null) {
            try {
                usuario.setTipo(u.getTipo());
                usuario.setEstado(u.getEstado());
                usuario.setListaUsuario(u.getListaUsuario());
                return new ResponseEntity<>(rolService.save(usuario), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Se seleccionara un id para eliminar un usuario")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Rol> elimiarUsuario(@PathVariable Integer id) {
        rolService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
