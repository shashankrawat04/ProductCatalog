package com.shashank.Product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shashank.Product.dto.ProductRequest;
import com.shashank.Product.dto.ProductResponse;
import com.shashank.Product.model.Product;
import com.shashank.Product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {


    private final ProductRepository productRepository;

    

    public void createProduct(ProductRequest productrequest) {
        Product product = Product.builder()
                .name(productrequest.getName())
                .description(productrequest.getDescription())
                .price(productrequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
