package com.compania.sistemaFacturacion.service;

import com.compania.sistemaFacturacion.exceptions.NotFoundException;
import com.compania.sistemaFacturacion.model.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private static ProductService instance; // Singleton pattern
    private ArrayList<Product> products = new ArrayList<>();

    private ProductService() {
        productsCreator();
    }

    public static ProductService getInstance() { // unique instance
        if (instance == null) {
            instance = new ProductService();
        }
        return instance;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
    
    public Product getProductById(Integer productId){
        Product toFind = null;
        for (Product product : products) {
            if (product.getId().equals(productId)) {
                toFind = product;
            }
        }
        if (toFind == null) {
            throw new NotFoundException("Producto no encontrado con ID: " + productId);
        }
        return toFind;
    }

    private void productsCreator() {
        int i = 0;
        HashMap<String, Double> names = new HashMap<>() {
            {
                put("Teléfono", 523.00);
                put("Tablet", 297.50);
                put("Televisor", 760.00);
                put("Laptop", 1234.70);
                put("Computadora", 1400.20);
                put("Parlantes", 150.00);
                put("Auriculares", 115.00);
                put("Monitor", 180.00);
                put("Teclado", 90.90);
                put("Mouse", 100.00);
            }
        };

        for (Map.Entry<String, Double> entry : names.entrySet()) {
            String productName = entry.getKey();
            Double productPrice = entry.getValue();

            Product product = new Product(i + 1, productName, productPrice);
            products.add(product);
            i++;
        }
    }
}
