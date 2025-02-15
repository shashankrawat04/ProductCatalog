package com.shashank.Product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shashank.Product.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
