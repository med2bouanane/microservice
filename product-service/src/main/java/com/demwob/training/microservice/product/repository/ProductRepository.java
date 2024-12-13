package com.demwob.training.microservice.product.repository;

import com.demwob.training.microservice.product.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
