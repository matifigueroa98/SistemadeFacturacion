package com.compania.sistemaFacturacion.model;

import java.time.LocalDate;
import java.util.UUID;

public class CreditNote extends Document {

    private Double total;

    public CreditNote() {

    }

    public CreditNote(LocalDate date, Integer id, UUID issueCode, char letter, Client client, Double total) {
        super(date, id, issueCode, letter, client);
        this.total = total;
    }

    @Override
    public LocalDate getDate() {
        return super.getDate();
    }

    @Override
    public void setDate(LocalDate date) {
        super.setDate(date);
    }

    @Override
    public Integer getId() {
        return super.getId();
    }

    @Override
    public void setId(Integer id) {
        super.setId(id);
    }

    @Override
    public UUID getIssueCode() {
        return super.getIssueCode();
    }

    @Override
    public void setIssueCode(UUID issueCode) {
        super.setIssueCode(issueCode);
    }

    @Override
    public char getLetter() {
        return super.getLetter();
    }

    @Override
    public void setLetter(char letter) {
        super.setLetter(letter);
    }

    @Override
    public Client getClient() {
        return super.getClient();
    }

    @Override
    public void setClient(Client client) {
        super.setClient(client);
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Nota de credito fecha: " + getDate() + ", ID: " + getId() + ", CODIGO: " + getIssueCode()
                + ", LETRA: " + getLetter() + ", Cliente: " + getClient().getDni() + ", TOTAL: " + total;
    }

}
