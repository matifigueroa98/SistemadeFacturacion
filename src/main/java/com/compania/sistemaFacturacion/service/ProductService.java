package com.compania.sistemaFacturacion.service;

import com.compania.sistemaFacturacion.exceptions.NotFoundException;
import com.compania.sistemaFacturacion.model.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getProducts() {
        if (products.isEmpty()) {
            productsCreator();
        }
        return products;
    }
    
    public Product getProductById(Integer productId){
        productsCreator();
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

    public void productsCreator() {
        int i = 0;
        HashMap<String, Double> names = new HashMap<>() {
            {
                put("Teléfono", 523.0);
                put("Tablet", 297.0);
                put("Televisor", 760.0);
                put("Laptop", 1234.0);
                put("Computadora", 1400.0);
                put("Parlantes", 150.0);
                put("Auriculares", 115.0);
                put("Monitor", 180.0);
                put("Teclado", 90.0);
                put("Mouse", 100.0);
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
