package com.example.buffet.product.web;

import com.example.buffet.product.domain.HttpResponseDto;
import com.example.buffet.product.domain.Product;
import com.example.buffet.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

// Allow a frontend dev server on another port (e.g. localhost:3000) to call the API.
@CrossOrigin
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @PostMapping("")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/{productId}")
    public Product update(@PathVariable Integer productId, @RequestBody Product product) {
        return productService.updateProduct(productId, product);
    }

    @DeleteMapping("/{productId}")
    public HttpResponseDto delete(@PathVariable Integer productId) {
        productService.deleteById(productId);
        HttpResponseDto responseDto = new HttpResponseDto();
        responseDto.setMessage("Product was deleted permanently from DB.");
        return responseDto;
    }
}
