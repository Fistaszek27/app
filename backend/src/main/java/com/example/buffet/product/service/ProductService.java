package com.example.buffet.product.service;

import com.example.buffet.product.domain.Product;
import com.example.buffet.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Integer id, Product product) {
        if (!productRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product does not exist");
        }
        product.setId(id);
        return productRepository.save(product);
    }

    private Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

}
