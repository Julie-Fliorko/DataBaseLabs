package com.example.DTO;

public class ReviewDTO {
    private int id;
    private String nick_name;
    private String review_text;
    private String film_name;

    public ReviewDTO(int id, String nick_name, String review_text, String film_name) {
        this.id = id;
        this.nick_name = nick_name;
        this.review_text = review_text;
        this.film_name = film_name;
    }

    public ReviewDTO(int id, String nick_name, String review_text) {
        this.id = id;
        this.nick_name = nick_name;
        this.review_text = review_text;
    }

    public ReviewDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getReview_text() {
        return review_text;
    }

    public void setReview_text(String review_text) {
        this.review_text = review_text;
    }

    public String getFilm_name() {
        return film_name;
    }

    public void setFilm_name(String film_name) {
        this.film_name = film_name;
    }
}
