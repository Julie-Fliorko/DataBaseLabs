package com.example.domain;

import javax.persistence.*;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "origin_city")
    private String originCity;
    @OneToOne
    @JoinColumn(name = "production_company_id", referencedColumnName = "id", nullable = false)
    private ProductionCompany productionCompany;
    @OneToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    private Country country;

    @Override
    public String toString() {
        return "---------------------------------------------"+"\n"+"Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", originCity='" + originCity + '\'' +
                ", productionCompany=" + productionCompany +
                ", country=" + country +
                '}';
    }

    public Film() {
    }

    public Film(String name, String originCity, ProductionCompany productionCompany, Country country) {
        this.name = name;
        this.originCity = originCity;
        this.productionCompany = productionCompany;
        this.country = country;
    }

    public Film(int id, String name,  String originCity, ProductionCompany productionCompany, Country country) {
        this.id = id;
        this.name = name;
        this.originCity = originCity;
        this.productionCompany = productionCompany;
        this.country = country;
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


    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public ProductionCompany getProductionCompany() {
        return productionCompany;
    }

    public void setProductionCompany(ProductionCompany productionCompany) {
        this.productionCompany = productionCompany;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}


