package com.compania.sistemaFacturacion.model;

import java.time.LocalDate;
import java.util.UUID;

public class CreditNote {

    private LocalDate date;
    private Integer id;
    private UUID issueCode;
    private char letter;
    private Client client;
    private double total;
    
    public CreditNote (){
        
    }

    public CreditNote(LocalDate date, Integer id, UUID issueCode, char letter, Client client, double total) {
        this.date = date;
        this.id = id;
        this.issueCode = issueCode;
        this.letter = letter;
        this.client = client;
        this.total = total;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getIssueCode() {
        return issueCode;
    }

    public void setIssueCode(UUID issueCode) {
        this.issueCode = issueCode;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
