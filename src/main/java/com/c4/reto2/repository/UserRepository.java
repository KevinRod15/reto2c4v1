
package com.c4.reto2.repository;

import com.c4.reto2.model.User;
import com.c4.reto2.repository.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository crudInterface;
    
    public Optional<User> getUser(int id){
        return crudInterface.findById(id);
    }
    
    public User create(User user){
        return crudInterface.save(user);
    }
    
    
    public void update(User user) {
        crudInterface.save(user);
    }
    
    public void delete(User user) {
        crudInterface.delete(user);
    }
    
    public List<User> listar(){
        return crudInterface.findAll();
    }
    
    public boolean existeEmail(String email){
        Optional<User> usuario = crudInterface.findByEmail(email);
        
        return !usuario.isEmpty();
    }
    
    public Optional<User> autenticateUser(String email, String password){
        return crudInterface.findByEmailAndPassword(email, password);
    }
}
