package com.compania.sistemaFacturacion.model;


public class Client {

    private Integer id;
    private String name;
    private String address;
    private String taxCondition;
    private String dniType; // dni, cuit, etc
    private String dni;
    
    public Client(){
        
    }

    public Client(Integer id,String name,String address, String taxCondition, String dniType, String dni) {
        this.id = id;
        this.name = name;
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
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
