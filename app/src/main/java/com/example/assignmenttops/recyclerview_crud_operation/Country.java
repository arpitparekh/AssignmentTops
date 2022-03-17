package com.example.assignmenttops.recyclerview_crud_operation;

public class Country {
    private String name;
    private String capital;
    private String population;
    private boolean isSelected;

    public Country(){

    }

    public Country(String name, String capital, String population) {
        this.name = name;
        this.capital = capital;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
