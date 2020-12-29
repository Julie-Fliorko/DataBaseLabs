package com.example.domain;

import javax.persistence.*;

@Entity
@Table(name="production_company")
public class ProductionCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "website")
    private String website;
    @Column(name = "owner")
    private String owner;

    @Override
    public String toString() {
        return "ProductionCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", website='" + website + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }

    public ProductionCompany(int id, String name, String website, String owner) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.owner = owner;
    }

    public ProductionCompany(String name, String website, String owner) {
        this.name = name;
        this.website = website;
        this.owner = owner;
    }

    public ProductionCompany() {
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
