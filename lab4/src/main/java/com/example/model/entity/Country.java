package com.example.model.entity;

public class Country {
    private String name;
    private int id;

    @Override
    public String toString() {
        return "Country_______________________________________________"+ "\n"+
                "name='" + name + "\n"+
                "id=" + id + "\n"+
                "_____________________________________________________"+ "\n";
    }

    public Country(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public Country(String name) {
        this(name, -1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
