package com.ecommerce.models;

import java.math.BigDecimal;
import java.util.UUID;

import com.ecommerce.Money;
import com.ecommerce.SKU;

public class Produit {
     private final UUID id;
    private final SKU sku;
    private final String nom;
    private Money price;

    public Produit(SKU sku, String nom, Money price) {

        if (sku == null) {
            throw new IllegalArgumentException("SKU ne doit pas etre null");
        }

        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Nom ne doit pas être null ou vide");
        }

        if (price == null) {
            throw new IllegalArgumentException("Price ne doit pas être null");
        }

        this.id = UUID.randomUUID();
        this.sku = sku;
        this.nom = nom;
        this.price = price;
    }

    public void applyDiscount(BigDecimal percentage) {

        if (percentage.compareTo(BigDecimal.valueOf(0.1)) < 0 ||
            percentage.compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new IllegalArgumentException("Invalid discount percentage");
        }

        BigDecimal discount = price.amount()
                .multiply(percentage)
                .divide(BigDecimal.valueOf(100));

        BigDecimal newPrice = price.amount().subtract(discount);

        this.price = new Money(newPrice, price.currency());
    }


    public UUID getId() { return id; }
    public SKU getSku() { return sku; }
    public String getNom() { return nom; }
    public Money getPrice() { return price; }
}
