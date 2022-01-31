package fr.codeonce.testTech.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import fr.codeonce.testTech.model.Product;

@Repository("productRepo")
public interface ProductRepo extends MongoRepository<Product, String> {

}
