package com.example.DTO;

public class FilmDTO {

    private int id;
    private String name;
    private String origin_city;
    private String production_company;
    private String country;

    public FilmDTO(int id, String name, String origin_city, String production_company, String country) {
        this.id = id;
        this.name = name;
        this.origin_city = origin_city;
        this.production_company = production_company;
        this.country = country;
    }

    public FilmDTO(int id, String name, String origin_city) {
        this.id = id;
        this.name = name;
        this.origin_city = origin_city;
    }

    public FilmDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin_city() {
        return origin_city;
    }

    public void setOrigin_city(String origin_city) {
        this.origin_city = origin_city;
    }

    public String getProduction_company() {
        return production_company;
    }

    public void setProduction_company(String production_company) {
        this.production_company = production_company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
