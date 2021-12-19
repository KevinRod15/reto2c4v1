
package com.c4.reto2.service;

import com.c4.reto2.model.User;
import com.c4.reto2.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repositorio;
    
    public Optional<User> getUser(int id) {
        return repositorio.getUser(id);
    }
    
    public List<User> listar(){
        return repositorio.listar();
    }
    
    public boolean existeEmail(String email){
        return repositorio.existeEmail(email);
    }
    
    public User autenticateUser(String email, String password){
        Optional<User> usuario = repositorio.autenticateUser(email, password);
        
        if (usuario.isEmpty()){
            return new User();
        }else{
            return usuario.get();
        }
    }
    
    public User create(User user){
        if (user.getId() == null){
            return user;
        } else {
            Optional<User> e = repositorio.getUser(user.getId());
            if (e.isEmpty()){
                if (existeEmail(user.getEmail()) == false){
                    return repositorio.create(user);
                }else{
                    return user;
                }
            }else {
                return user;
            }
        }
    }
    
    public User update(User user){
        if (user.getId() != null){
            Optional<User> userData = repositorio.getUser(user.getId());
            if (!userData.isEmpty()){
                if(user.getIdentification() != null){
                    userData.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null){
                    userData.get().setName(user.getName());
                }
                if (user.getAddress() != null){
                    userData.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null){
                    userData.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null){
                    userData.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null){
                    userData.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null){
                    userData.get().setZone(user.getZone());
                }
                
                repositorio.update(userData.get());
                return userData.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    
    public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            repositorio.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
