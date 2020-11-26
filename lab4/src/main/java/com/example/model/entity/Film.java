package com.example.model.entity;

public class Film {
    private int id;
    private String name;
    private int runtimeInMinutes;
    private int ratingOutOfTen;
    private String originCity;
    private int productionCompanyId;
    private int countryId;

    @Override
    public String toString() {
        return "\nFilm_______________________________________________" + "\n"+
                "id=" + id + "\n"+
                "name='" + name +  "\n"+
                "runtimeInMinutes=" + runtimeInMinutes + "\n"+
                "ratingOutOfTen=" + ratingOutOfTen + "\n"+
                "originCity='" + originCity + "\n"+
                "productionCompanyId=" + productionCompanyId + "\n"+
                "countryId=" + countryId + "\n"+
                "__________________________________________________";
    }

    public Film(int id, String name, int runtimeInMinutes, int ratingOutOfTen, String originCity, int productionCompanyId, int countryId) {
        this.id = id;
        this.name = name;
        this.runtimeInMinutes = runtimeInMinutes;
        this.ratingOutOfTen = ratingOutOfTen;
        this.originCity = originCity;
        this.productionCompanyId = productionCompanyId;
        this.countryId = countryId;
    }

    public Film(String name, int runtimeInMinutes, int ratingOutOfTen, String originCity, int productionCompanyId, int countryId) {
        this(-1, name, runtimeInMinutes, ratingOutOfTen, originCity, productionCompanyId, countryId);
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


    public int getRuntimeInMinutes() {
        return runtimeInMinutes;
    }

    public void setRuntimeInMinutes(int runtimeInMinutes) {
        this.runtimeInMinutes = runtimeInMinutes;
    }

    public int getRatingOutOfTen() {
        return ratingOutOfTen;
    }

    public void setRatingOutOfTen(int ratingOutOfTen) {
        this.ratingOutOfTen = ratingOutOfTen;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public int getProductionCompanyId() {
        return productionCompanyId;
    }

    public void setProductionCompanyId(int productionCompanyId) {
        this.productionCompanyId = productionCompanyId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
}
