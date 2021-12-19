package com.c4.reto2;

import com.c4.reto2.model.User;
import com.c4.reto2.repository.crud.ProductCrudRepository;
import com.c4.reto2.repository.crud.UserCrudRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Reto2Application implements CommandLineRunner {
    @Autowired
    private ProductCrudRepository productRepo;
    @Autowired
    private UserCrudRepository userRepo;
    
    public static void main(String[] args) {
        SpringApplication.run(Reto2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepo.deleteAll();
        productRepo.deleteAll();
        
        //userRepo.saveAll(List.of(
        //        new User(1, "1018460767", "Alice", "CR 19 # 19-45", "3112112111", "alice@gmail.com", "Demo123.", "ZONA 1", "ADM"),
        //        new User(2, "1045678587", "Juan", "CR 2 # 45-7", "3154545654", "juan@gmail.com", "Demo456.", "ZONA 2", "COORD"),
        //        new User(3, "827527525", "Diego", "CR 85 # 15-42", "3124568216", "diego@gmail.com", "Demo789.", "ZONA 3", "ASE"),
        //        new User(4, "1450157855", "Ayala", "CR 6 # 74-76", "3175123556", "ayala@gmail.com", "Demo315.", "ZONA 4", "ASE")
        //));
    }

}
