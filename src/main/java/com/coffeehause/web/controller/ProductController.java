package com.coffeehause.web.controller;

import com.coffeehause.web.entity.Product;
import com.coffeehause.web.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.List;

@RestController
public class ProductController {
    private final ProductRepository productRepository;

    ProductController (ProductRepository productRepository){this.productRepository = productRepository;}

    @GetMapping("/product")
    List<Product> all(){return productRepository.findAll();}
    @PostMapping("/product/create")
    Product newProduct(){
        Product product = new Product();
        product.setCook_time(new Time(0,5,0));
        product.setName("govno");
        product.setPrice(10);
        return productRepository.save(product);
    }
}
