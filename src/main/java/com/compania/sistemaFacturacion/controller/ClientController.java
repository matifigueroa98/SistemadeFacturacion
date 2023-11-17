package com.compania.sistemaFacturacion.controller;

import com.compania.sistemaFacturacion.model.Client;
import com.compania.sistemaFacturacion.service.ClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public String showClients(Model model) {
        List<Client> clients = clientService.getClients();
        model.addAttribute("clients", clients);
        return "Client/clientList";
    }

    @GetMapping("/NewClient")
    public String newClient() {
        return "Client/NewClient";
    }

    @PostMapping("/submitClient")
    public String submitClient(@RequestParam("address") String address, @RequestParam("name") String name,
            @RequestParam("dniType") String dniType,
            @RequestParam("dni") String dni, @RequestParam("taxCondition") String taxCondition) {
        clientService.addClient(address, name, dni, dniType, taxCondition);
        return "redirect:/";
    }

}
