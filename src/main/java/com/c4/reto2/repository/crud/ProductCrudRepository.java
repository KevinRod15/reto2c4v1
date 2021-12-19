
package com.c4.reto2.repository.crud;


import com.c4.reto2.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductCrudRepository extends MongoRepository<Product, String> {
}
