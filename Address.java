package com.oracle;

public class Address {
    private int emp_id;
    private String city;
    private String state;
    private int pin;

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getPin() {
        return pin;
    }

    public Address(int emp_id, String city, String state, int pin) {
        this.emp_id = emp_id;
        this.city = city;
        this.state = state;
        this.pin = pin;
    }
}
