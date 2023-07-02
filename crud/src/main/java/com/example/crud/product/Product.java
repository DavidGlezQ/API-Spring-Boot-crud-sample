package com.example.crud.product;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private float price;
    private LocalDate date;

    @Transient
    private int antique;
    // con esto le decimos a la base de datos que es un campo transitorio, es decir que es un campo calculado y que no lo va a crear en la db
    public Product() {}

    //Constructor para insert
    public Product(Long id, String name, float price, LocalDate date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
    }

    //Constructor para update
    public Product(String name, float price, LocalDate date) {
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getAntique() {
        //Calculamos el dato de esta manera
        return Period.between(this.date, LocalDate.now()).getYears();
    }

    public void setAntique(int antique) {
        this.antique = antique;
    }
}
