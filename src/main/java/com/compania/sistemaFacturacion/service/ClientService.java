package com.compania.sistemaFacturacion.service;

import com.compania.sistemaFacturacion.exceptions.NotFoundException;
import com.compania.sistemaFacturacion.model.Client;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private static ClientService instance; // Singleton pattern
    private ArrayList<Client> clients = new ArrayList<>();
    
    private ClientService() {
        clientsCreator();
    }
    
    public static ClientService getInstance() { // unique instance
        if (instance == null) {
            instance = new ClientService();
        }
        return instance;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void addClient(String address,String name, String dni, String dniType, String taxCondition) {
        Client client = new Client();
        client.setId(clients.size() + 1);
        client.setName(name);
        client.setAddress(address);
        client.setDni(dni);
        client.setDniType(dniType);
        client.setTaxCondition(taxCondition);
        clients.add(client);
    }

    public Client getClientById(Integer clientId) {
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

    private void clientsCreator() {
        int i = 0, dni;
        String dniStr;
        ArrayList<String> name = new ArrayList<>(
                List.of("Pedro", "Carlos", "Agustin", "Franco", "Esteban",
                        "Matias", "Micaela", "Sofia", "Julieta", "Nicolas"));
        ArrayList<String> address = new ArrayList<>(
                List.of("La Rioja 1345", "Cordoba 2300", "Av. Colon 3231", "Irigoyen 4223", "Av. Independencia 5323",
                        "Rivadavia 6231", "Catamarca 27", "Maipu 831", "Dorrego 921", "Strobel 10"));
        ArrayList<String> taxCondition = new ArrayList<>(
                List.of("Responsable inscripto", "Monotributo", "IVA no responsable"));
        ArrayList<String> dniType = new ArrayList<>(
                List.of("DNI", "CUIT", "PASAPORTE"));
        while (i < 10) {
            dni = (int) (Math.random() * 100000000);
            dniStr = String.valueOf(dni);
            String condition = taxCondition.get(i % taxCondition.size());
            String type = dniType.get(i % dniType.size());
            Client client = new Client(i + 1, name.get(i), address.get(i), condition, type, dniStr);
            clients.add(client);
            i++;
        }
    }

}
