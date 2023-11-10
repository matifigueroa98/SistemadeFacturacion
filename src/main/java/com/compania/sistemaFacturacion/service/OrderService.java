package com.compania.sistemaFacturacion.service;

import com.compania.sistemaFacturacion.exceptions.NotFoundException;
import com.compania.sistemaFacturacion.model.Client;
import com.compania.sistemaFacturacion.model.Order;
import com.compania.sistemaFacturacion.model.Product;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ClientService clientService;
    @Autowired
    private ProductService productService;
    private static Integer orderIdCounter = 1;
    private ArrayList<Order> orders = new ArrayList<>();

    public Order addOrder(Integer clientId, Integer productId, int quantity) {
        Client client = clientService.getClientById(clientId);
        Product product = productService.getProductById(productId);
        Order order = new Order();
        order.setId(orderIdCounter++);
        order.setClient(client);
        order.setProduct(product);
        order.setConfirm(Boolean.FALSE);
        order.setQuantity(quantity);
        orders.add(order);

        return order;
    }

    public Order getOrderById(Integer orderId) {
        Order toFind = null;
        for (Order order : orders) {
            if (order.getId().equals(orderId)) {
                toFind = order;
            }
        }
        if (toFind == null) {
            throw new NotFoundException("Pedido no encontrado con ID: " + orderId);
        }
        return toFind;
    }

    public Order updateOrderConfirm(Integer orderId, Boolean confirm) {
        Order order = getOrderById(orderId);
        if (order != null) {
            order.setConfirm(confirm);
        } else {
            throw new NotFoundException("Pedido no encontrado con ID: " + orderId);
        }
        return order;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void clearOrders() {
        orders.clear();
    }

}
