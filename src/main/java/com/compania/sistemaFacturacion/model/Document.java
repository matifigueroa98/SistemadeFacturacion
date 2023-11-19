package com.compania.sistemaFacturacion.model;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Document {

    private LocalDate date;
    private Integer id;
    private UUID issueCode;
    private char letter;
    private Client client;

    public Document() {

    }

    public Document(Integer id, Client client) {
        this.id = id;
        this.client = client;
    }

    public Document(LocalDate date, Integer id, UUID issueCode, char letter, Client client) {
        this.date = date;
        this.id = id;
        this.issueCode = issueCode;
        this.letter = letter;
        this.client = client;
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
}
