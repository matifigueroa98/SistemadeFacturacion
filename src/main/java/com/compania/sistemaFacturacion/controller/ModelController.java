package com.compania.sistemaFacturacion.controller;

import com.compania.sistemaFacturacion.model.Client;
import com.compania.sistemaFacturacion.model.Product;
import com.compania.sistemaFacturacion.service.ClientService;
import com.compania.sistemaFacturacion.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ModelController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/clients")
    public String showClients(Model model) {
        List<Client> clients = clientService.getClients();
        model.addAttribute("clients", clients);
        return "clientList";
    }
    
    @GetMapping("/products")
    public String showProducts(Model model) {
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "productList";
    }
}
