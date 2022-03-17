package com.example.assignmenttops.recyclerview;

public class Employee {
    private String name;
    private String position;
    private String email;

    public Employee(String name, String position, String email) {
        this.name = name;
        this.position = position;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




}
