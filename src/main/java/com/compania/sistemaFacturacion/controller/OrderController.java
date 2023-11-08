package com.compania.sistemaFacturacion.controller;

import com.compania.sistemaFacturacion.model.Order;
import com.compania.sistemaFacturacion.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orderForm")
    public String showForm() {
        return "Order/OrderForm";
    }

    @PostMapping("/submitOrder")
    public String submitOrder(@RequestParam("clientId") Integer clientId, @RequestParam("productId") 
            Integer productId, @RequestParam("quantity") int quantity, Model model) {
        Order order = orderService.addOrder(clientId, productId, quantity);

        return "redirect:/confirmationPage?id=" + order.getId();
    }

    @GetMapping("/confirmationPage")
    public String confirmOrder(@RequestParam("id") Integer orderId, Model model) {
        Order order = orderService.getOrderById(orderId);
        model.addAttribute("order", order);
        Double grossTotalOrder = order.getProduct().getPrice() * order.getQuantity();
        model.addAttribute("gross", grossTotalOrder);
        return "Order/ConfirmationPage";
    }

    @PostMapping("/confirmTrue")
    public String confirmOrderTrue(@RequestParam("orderId") Integer orderId) {
        Order order = orderService.updateOrderConfirm(orderId, Boolean.TRUE);
        return "redirect:/";
    }

}
