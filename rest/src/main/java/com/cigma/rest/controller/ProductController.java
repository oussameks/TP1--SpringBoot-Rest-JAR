package com.cigma.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cigma.rest.service.IProductService;
import com.cigma.rest.service.model.Product;

@RestController
public class ProductController {
    @Autowired
    private IProductService service;

    @GetMapping(value = "/products")
    public List<Product> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/products/{id}")
    public Product getProductById(@PathVariable(value = "id") Long productId) {
        return service.getById(productId);
    }

    @PostMapping(value = "/products")
    public ResponseEntity<Object> createProdut(@Validated @RequestBody Product product) {
        service.create(product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    @PutMapping(value = "/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(name = "id") Long productId, @RequestBody Product product) {
        Product productFound = service.getById(productId);
        if (productFound == null)
            return ResponseEntity.notFound().build();
        service.update(productId, product);
        return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(name = "id") Long productId) {
        Product productFound = service.getById(productId);
        if (productFound == null)
            return ResponseEntity.notFound().build();
        service.delete(productId);
        return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
    }

    public IProductService getService() {
        return service;
    }
    public void setService(IProductService service) {
        this.service = service;
    }


}
