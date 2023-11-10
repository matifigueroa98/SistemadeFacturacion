package com.compania.sistemaFacturacion.service;

import com.compania.sistemaFacturacion.exceptions.NotFoundException;
import com.compania.sistemaFacturacion.model.Bill;
import com.compania.sistemaFacturacion.model.Client;
import com.compania.sistemaFacturacion.model.Order;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {

    private static Integer billIdCounter = 1;
    private ArrayList<Bill> bills = new ArrayList<>();
    @Autowired
    private CreditNoteService creditNoteService;

    public void addBillFromOrder(Order order) {
        Bill bill = null;
        if (order.isConfirm()) {
            bill = new Bill();
            bill.setDate(LocalDate.now());
            bill.setId(billIdCounter++);
            bill.setIssueCode(UUID.randomUUID());
            bill.setLetter(generateLetter(order.getClient()));
            bill.setClient(order.getClient());
            bill.setProduct(order.getProduct());
            bill.setUnit(order.getProduct().getPrice());
            bill.setNetPrice(order.getQuantity() * order.getProduct().getPrice());
            bill.setQuantity(order.getQuantity());
            bill.setIVAPercentage(generatePercentage(order.getClient()));
            bill.setIVAAmount(generateIVAAmount(bill.getNetPrice(), generatePercentage(order.getClient())));
            bill.setSalePrice(bill.getNetPrice() + bill.getIVAAmount());
            bill.setStatus(Boolean.FALSE);
            bill.setTotal(bill.getNetPrice() + bill.getIVAAmount());
            bill.setTotalIVA(bill.getIVAAmount());
            bills.add(bill);
        } else {
            throw new NotFoundException("Pedido no encontrado con ID: " + order.getId());
        }
    }

    public char generateLetter(Client client) {
        char letter = ' ';
        if (client != null) {
            if (client.getTaxCondition().equals("Responsable inscripto")) {
                letter = 'A';
            } else if (client.getTaxCondition().equals("Monotributo")) {
                letter = 'B';
            } else {
                letter = 'X';
            }
        }
        return letter;
    }

    public double generatePercentage(Client client) {
        double percentage = 0;
        if (client != null) {
            if (client.getTaxCondition().equals("Responsable inscripto")) {
                percentage = 10.05;
            } else if (client.getTaxCondition().equals("Monotributo")) {
                percentage = 21;
            } else {
                percentage = 70;
            }
        }
        return percentage;
    }

    public double generateIVAAmount(double netPrice, double IVAPercentage) {
        double value = (netPrice * IVAPercentage) / 100;
        return value;
    }

    public ArrayList<Bill> getBills() {
        return bills;
    }

    public Bill getBillById(Integer billId) {
        Bill toFind = null;
        for (Bill bill : bills) {
            if (bill.getId().equals(billId)) {
                toFind = bill;
            }
        }
        if (toFind == null) {
            throw new NotFoundException("Factura no encontrada con ID: " + billId);
        }
        return toFind;
    }

    public void cancelBillToCreditNote(Bill bill) {
        if (bill.getStatus()) {
            creditNoteService.addCreditNote(bill);
            System.out.println("Cancelacion de pedido");
            bills.remove(bill);
        } else {
            bills.remove(bill); // delete bill before executing it
        }
    }

    public String generateBillContent(Bill bill) {
        return "Client Number: " + bill.getClient().getId() + " | " + bill.getClient().getDniType() + " | "
                + bill.getLetter() + " | Bill number: " + bill.getId() + " | " + bill.getDate() + " | TOTAL = $"
                + bill.getTotal();
    }
}
