package com.compania.sistemaFacturacion.model;

public class Order {

    private Integer id;
    private Client client;
    private Product product;
    private Boolean confirm; // boolean to confirm the order
    private int quantity;

    public Order() {

    }

    public Order(Integer id, Client client, Product product,Boolean confirm, int quantity) {
        this.id = id;
        this.client = client;
        this.product = product;
        this.confirm = confirm;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Pedido: " + id + ", DNI Cliente: " + client.getDni() + ", Producto: " + product.getName()
                + ", Confirmado: " + confirm + ", Cantidad: " + quantity;
    }
}
