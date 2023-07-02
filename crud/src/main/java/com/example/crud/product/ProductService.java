package com.example.crud.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//Capa al servicio del controlador
@Service
public class ProductService {
    private final ProductRepository productRepository;

    //DI
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getProducts() {
        return this.productRepository.findAll();
    }

    public ResponseEntity<Object> newProduct(Product product) {
        //Variable opcional
        Optional<Product> res = productRepository.findProductByName(product.getName());
        HashMap<String, Object> data = new HashMap<>();

        if (res.isPresent() && product.getId() == null) {
            data.put("error", true);
            data.put("message", "Ya existe un producto con ese nombre");
            //Respuesta personalizada
            return new ResponseEntity<>(data, HttpStatus.CONFLICT);
        }
        data.put("message", "se guardo con exito");
        if (product.getId() != null) {
            data.put("message", "se actualizo con exito");
        }

        productRepository.save(product);
        data.put("datos", product);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }
}
