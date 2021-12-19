
package com.c4.reto2.controller;

import com.c4.reto2.model.User;
import com.c4.reto2.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
/**
 * Clase controlador de usuario
 */
public class UserController {
    @Autowired
    /**
     * Instanciar el servicio
     */
    private UserService servicio;
    
    @GetMapping("/all")
    /**
     * lista de los servicios
     */
    public List<User> listar(){
        return servicio.listar();
    }
    
    @GetMapping("/emailexist/{email}")
    /**
     * Comprobar si existe el email
     */
    public boolean existeEmail(@PathVariable("email") String email){
        return servicio.existeEmail(email);
    }
         
    @GetMapping("/{email}/{password}")
    /**
     * Autenticar el usuario con email y password como path variables
     */
    public User autenticateUser(@PathVariable("email")String email, @PathVariable("password") String password){
        return servicio.autenticateUser(email,password);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    /**
     * crear el usuario
     */
    public User create(@RequestBody User user){
        return servicio.create(user);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    /**
     * Actualizar el usuario
     */
    public User update(@RequestBody User user){
        return servicio.update(user);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    /**
     * Eliminar un usuario por id
     */
    public boolean delete(@PathVariable("id") int id){
        return servicio.delete(id);
    }
}
