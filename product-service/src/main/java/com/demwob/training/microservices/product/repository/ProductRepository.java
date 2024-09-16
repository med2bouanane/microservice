package com.demwob.training.microservices.product.repository;

import com.demwob.training.microservices.product.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
