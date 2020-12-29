package com.example.DTO;

public class CountryDTO {
    private String name;
    private int id;

    public CountryDTO(String name, int id){
        this.id = id;
        this.name = name;
    }

    public CountryDTO() {
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
