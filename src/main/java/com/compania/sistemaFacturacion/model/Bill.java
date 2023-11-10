package com.compania.sistemaFacturacion.model;

import java.time.LocalDate;
import java.util.UUID;

public class Bill {

    private LocalDate date;
    private Integer id;
    private UUID issueCode;
    private char letter;
    private Client client;
    private Product product;
    private double unit;
    private double IVAPercentage;
    private int quantity;
    private double salePrice;
    private double netPrice;
    private double IVAAmount; // % IVA according to category
    private double total;
    private double totalIVA;
    private Boolean status; // ff the status is false, the order is pending and if its true, its billed
    
    public Bill(){
        
    }

    public Bill(LocalDate date, Integer id, UUID issueCode, char letter, Client client, Product product, 
            double unit, double IVAPercentage, int quantity, double salePrice, double netPrice, 
            double IVAAmount, double total, double totalIVA, Boolean status) {
        this.date = date;
        this.id = id;
        this.issueCode = issueCode;
        this.letter = letter;
        this.client = client;
        this.product = product;
        this.unit = unit;
        this.IVAPercentage = IVAPercentage;
        this.quantity = quantity;
        this.salePrice = salePrice;
        this.netPrice = netPrice;
        this.IVAAmount = IVAAmount;
        this.total = total;
        this.totalIVA = totalIVA;
        this.status = status;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getUnit() {
        return unit;
    }

    public void setUnit(double unit) {
        this.unit = unit;
    }

    public double getIVAPercentage() {
        return IVAPercentage;
    }

    public void setIVAPercentage(double IVAPercentage) {
        this.IVAPercentage = IVAPercentage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(double netPrice) {
        this.netPrice = netPrice;
    }

    public double getIVAAmount() {
        return IVAAmount;
    }

    public void setIVAAmount(double IVAAmount) {
        this.IVAAmount = IVAAmount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalIVA() {
        return totalIVA;
    }

    public void setTotalIVA(double totalIVA) {
        this.totalIVA = totalIVA;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "Factura fecha: " + date + ", ID: " + id + ", CODIGO: " + issueCode + ", LETRA: " 
                + letter + ", Cliente: " + client.getDni()+ ", Producto: " + product.getName() + 
                ", Precio unitario: " + unit + ", Porcentaje IVA: " + IVAPercentage + ", Cantidad: " + quantity +
                ", Precio de venta: " + salePrice + ", " + "Precio neto: " + netPrice + ", Monto de IVA: " + IVAAmount + 
                ", Total: " + total + ", " + "Total IVA: " + totalIVA;
    }
}
