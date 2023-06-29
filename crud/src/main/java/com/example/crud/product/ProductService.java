package com.example.crud.product;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//Capa al servicio del controlador
@Service
public class ProductService {
    public List<Product> getProducts() {
        return List.of(
                new Product(123L, "Samsumg s22 Ultra", 30000, LocalDate.of(2022, Month.APRIL, 5), 2));
    }
}
