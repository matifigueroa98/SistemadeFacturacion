package com.compania.sistemaFacturacion.model;

import java.time.LocalDate;
import java.util.UUID;

public class Bill extends Document {

    private Product product;
    private double unit;
    private double IVAPercentage;
    private int quantity;
    private double salePrice;
    private double netPrice;
    private double IVAAmount; // % IVA according to category
    private double total;
    private double totalIVA;
    private Boolean status; // if the status is false, the order is pending and if its true, its billed

    public Bill() {

    }

    public Bill(Product product, double unit, double IVAPercentage, int quantity, double salePrice,
            double netPrice, double IVAAmount, double total, double totalIVA, Boolean status, LocalDate date,
            Integer id, UUID issueCode, char letter, Client client) {
        super(date, id, issueCode, letter, client);
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
        return "Factura fecha: " + getDate() + ", ID: " + getId() + ", CODIGO: " + getIssueCode() + ", LETRA: "
                + getLetter() + ", Cliente: " + getClient().getDni() + ", Producto: " + product.getName()
                + ", Precio unitario: " + unit + ", Porcentaje IVA: " + IVAPercentage + ", Cantidad: " + quantity
                + ", Precio de venta: " + salePrice + ", " + "Precio neto: " + netPrice + ", Monto de IVA: " + IVAAmount
                + ", Total: " + total + ", " + "Total IVA: " + totalIVA;
    }
}
