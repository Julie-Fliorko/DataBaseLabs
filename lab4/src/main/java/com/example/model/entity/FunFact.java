package com.example.model.entity;

public class FunFact {
    private int id;
    private String source;
    private String factText;
    private int filmId;

    @Override
    public String toString() {
        return "FunFact_______________________________________________" + "\n"+
                "id=" + id + "\n"+
                "source='" + source + "\n"+
                "factText='" + factText + "\n"+
                "filmId=" + filmId + "\n"+
                "_____________________________________________________"+ "\n";
    }

    public FunFact(int id, String source, String factText, int filmId) {
        this.id = id;
        this.source = source;
        this.factText = factText;
        this.filmId = filmId;
    }

    public FunFact(String source, String factText, int filmId) {
        this(-1, source, factText, filmId);
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

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }
}
