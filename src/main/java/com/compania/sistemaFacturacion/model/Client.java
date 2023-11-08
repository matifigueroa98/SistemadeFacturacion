package com.compania.sistemaFacturacion.model;


public class Client {

    private Integer id;
    private String address;
    private String taxCondition;
    private String dniType; // dni, cuit, etc
    private int dni;
    
    public Client(){
        
    }

    public Client(Integer id, String address, String taxCondition, String dniType, int dni) {
        this.id = id;
        this.address = address;
        this.taxCondition = taxCondition;
        this.dniType = dniType;
        this.dni = dni;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTaxCondition() {
        return taxCondition;
    }

    public void setTaxCondition(String taxCondition) {
        this.taxCondition = taxCondition;
    }

    public String getDniType() {
        return dniType;
    }

    public void setDniType(String dniType) {
        this.dniType = dniType;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
}
