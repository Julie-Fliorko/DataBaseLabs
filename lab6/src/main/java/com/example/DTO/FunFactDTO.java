package com.example.DTO;

public class FunFactDTO {
    private int id;
    private String sourse;
    private String fact_text;
    private String film_name;

    public FunFactDTO(int id, String sourse, String fact_text, String film_name) {
        this.id = id;
        this.sourse = sourse;
        this.fact_text = fact_text;
        this.film_name = film_name;
    }

    public FunFactDTO(int id, String sourse, String fact_text) {
        this.id = id;
        this.sourse = sourse;
        this.fact_text = fact_text;
    }

    public FunFactDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSourse() {
        return sourse;
    }

    public void setSourse(String sourse) {
        this.sourse = sourse;
    }

    public String getFact_text() {
        return fact_text;
    }

    public void setFact_text(String fact_text) {
        this.fact_text = fact_text;
    }

    public String getFilm_name() {
        return film_name;
    }

    public void setFilm_name(String film_name) {
        this.film_name = film_name;
    }
}
