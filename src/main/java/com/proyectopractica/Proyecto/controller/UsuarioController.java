/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectopractica.Proyecto.controller;

import com.proyectopractica.Proyecto.model.Usuario;
import com.proyectopractica.Proyecto.service.UsuarioServiceImpl;
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
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioServiceImpl usuarioService;
    
    @Operation(summary = "Se consulta la informacion para obtener la lista de los usuarios")
    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listaUsuarios() {
        return new ResponseEntity<>(usuarioService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Se rellenaran los atributos para crear un usuario")
    @PostMapping("/crear")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario u) {
        return new ResponseEntity<>(usuarioService.save(u), HttpStatus.CREATED);
    }

    @Operation(summary = "Se editaran los atributos de un usuario ya creado")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Integer id, @RequestBody Usuario u) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario != null) {
            try {
                usuario.setNombre(u.getNombre());
                usuario.setNombre(u.getNombre());
                usuario.setApellido(u.getApellido());
                usuario.setCedula(u.getCedula());
                usuario.setNumero(u.getNumero());
                usuario.setCorreo(u.getCorreo());
                usuario.setContra(u.getContra());
                usuario.setRol(u.getRol());
                usuario.setVenta(u.getVenta());
                return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Se seleccionara un id para eliminar un usuario")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Usuario> elimiarUsuario(@PathVariable Integer id) {
        usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
