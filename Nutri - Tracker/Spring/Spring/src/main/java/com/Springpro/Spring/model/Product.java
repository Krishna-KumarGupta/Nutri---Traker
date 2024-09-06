package com.Springpro.Spring.model;

import java.util.List;

public class Product {
    private String barcode;
    private String name;
    private List<String> ingredients; // Use List<String> to handle multiple ingredients

    // Constructor
    public Product(String barcode, String name, List<String> ingredients) {
        this.barcode = barcode;
        this.name = name;
        this.ingredients = ingredients;
    }

    // Getters and Setters
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
