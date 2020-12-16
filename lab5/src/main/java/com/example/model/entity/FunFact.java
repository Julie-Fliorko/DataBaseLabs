package com.example.model.entity;

import javax.persistence.*;

@Entity
@Table(name="fun_fact")
public class FunFact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;
    @Column(name = "sourse")
    private String source;
    @Column(name = "fact_text")
    private String factText;
    @ManyToOne
    @JoinColumn(name = "film_id", referencedColumnName = "id", nullable = false)
    private Film film;

    @Override
    public String toString() {
        return "FunFact{" +
                "id=" + id +
                ", source='" + source + '\'' +
                ", factText='" + factText + '\'' +
                ", film=" + film +
                '}';
    }

    public FunFact(int id, String source, String factText, Film film) {
        this.id = id;
        this.source = source;
        this.factText = factText;
        this.film = film;
    }

    public FunFact(String source, String factText, Film film) {
        this.source = source;
        this.factText = factText;
        this.film = film;
    }

    public FunFact() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getFactText() {
        return factText;
    }

    public void setFactText(String factText) {
        this.factText = factText;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
