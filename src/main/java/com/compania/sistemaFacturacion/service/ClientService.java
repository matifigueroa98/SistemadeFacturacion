package com.compania.sistemaFacturacion.service;

import com.compania.sistemaFacturacion.exceptions.NotFoundException;
import com.compania.sistemaFacturacion.model.Client;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private ArrayList<Client> clients = new ArrayList<>();

    public ArrayList<Client> getClients() {
        if (clients.isEmpty()) {
            clientsCreator();
        }
        return clients;
    }

    public Client getClientById(Integer clientId){
        clientsCreator();
        Client toFind = null;
        for (Client client : clients) {
            if (client.getId().equals(clientId)) {
                toFind = client;
            }
        }
        if (toFind == null) {
            throw new NotFoundException("Cliente no encontrado con ID: " + clientId);
        }
        return toFind;
    }

    public void clientsCreator() {
        int i = 0, dni;
        ArrayList<String> address = new ArrayList<>(
                List.of("La Rioja 1345", "Cordoba 2300", "Av. Colon 3231", "Irigoyen 4223", "Av. Independencia 5323",
                        "Rivadavia 6231", "Catamarca 27", "Maipu 831", "Dorrego 921", "Strobel 10"));
        ArrayList<String> taxCondition = new ArrayList<>(
                List.of("Responsable inscripto", "Monotributo", "IVA no responsable"));

        while (i < 10) {
            dni = (int) (Math.random() * 100000000);
            String condition = taxCondition.get(i % taxCondition.size());
            Client client = new Client(i+1, address.get(i), condition, "DNI", dni);
            clients.add(client);
            i++;
        }
    }
    
}
