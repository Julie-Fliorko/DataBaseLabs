package com.example.model.entity;

public class ProductionCompany {
    private int id;
    private String name;
    private String website;
    private String owner;

    @Override
    public String toString() {
        return "ProductionCompany_______________________________________________" + "\n"+
                "id=" + id + "\n"+
                ", name='" + name + "\n"+
                ", website='" + website + "\n"+
                ", owner='" + owner + "\n"+
                "_______________________________________________________________"+ "\n";
    }

    public ProductionCompany(int id, String name, String website, String owner) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.owner = owner;
    }

    public ProductionCompany(String name, String website, String owner) {
        this(-1, name, website, owner);
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
