package com.compania.sistemaFacturacion.model;

public class Order {

    private Integer id;
    private Client client;
    private Product product;
    private Boolean confirm; // boolean to confirm the order
    private Boolean status; // ff the status is false, the order is pending and if its true, its billed
    private int quantity;

    public Order() {

    }

    public Order(Integer id, Client client, Product product,Boolean confirm,Boolean status, int quantity) {
        this.id = id;
        this.client = client;
        this.product = product;
        this.confirm = confirm;
        this.status = status;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    
    public Boolean isConfirm() {
        return confirm;
    }

    public void setConfirm (Boolean confirm) {
        this.confirm = confirm;
    }

    public Boolean isStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Pedido: " + id + ", DNI Cliente: " + client.getDni() + ", Producto: " + product.getName()
                + ", Activo: " + status+ ", Confirmado: " + confirm + ", Cantidad: " + quantity;
    }
}
