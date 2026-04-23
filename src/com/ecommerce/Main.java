package com.ecommerce;

import java.math.BigDecimal;

import com.ecommerce.models.Produit;

public class Main {

    public static void main(String[] args) {

        SKU sku = new SKU("TEC1234");

        Money price = new Money(new BigDecimal("10000"), "FCFA");

        Produit produit = new Produit(sku, "Laptop", price);

        System.out.println("Prix initial: " + produit.getPrice());

        produit.applyDiscount(new BigDecimal("10"));

        System.out.println("Prix après remise: " + produit.getPrice());

        try {
            new SKU("AA");
        } catch (Exception e) {
            System.out.println("Erreur SKU: " + e.getMessage());
        }

        try {
            new Money(new BigDecimal("1000"), "USD");
        } catch (Exception e) {
            System.out.println("Erreur currency: " + e.getMessage());
        }

        try {
            Money m1 = new Money(new BigDecimal("1000"), "FCFA");
            Money m2 = new Money(new BigDecimal("10"), "EUR");
            m1.add(m2);
        } catch (Exception e) {
            System.out.println("Erreur addition: " + e.getMessage());
        }
    }
}
