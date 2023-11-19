package com.compania.sistemaFacturacion.model;

public class Order extends Document {
    
    private Product product;
    private Boolean confirm; // boolean to confirm the order
    private int quantity;
    
    public Order() {
        
    }
    
    public Order(Integer id, Client client, Product product, Boolean confirm, int quantity) {
        super(id, client);
        this.product = product;
        this.confirm = confirm;
        this.quantity = quantity;
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
        return "Pedido: " + getId() + ", DNI Cliente: " + getClient().getDni() + ", Producto: " + product.getName()
                + ", Confirmado: " + confirm + ", Cantidad: " + quantity;
    }
}
