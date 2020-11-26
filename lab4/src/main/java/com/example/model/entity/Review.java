package com.example.model.entity;

public class Review {
    private int id;
    private String nickname;
    private String reviewText;
    private int filmId;

    @Override
    public String toString() {
        return "Review_______________________________________________"+ "\n"+
                "id=" + id + "\n"+
                ", nickname='" + nickname + "\n"+
                ", reviewText='" + reviewText + "\n"+
                ", filmId=" + filmId + "\n"+
                "_____________________________________________________"+ "\n";
    }

    public Review(int id, String nickname, String reviewText, int filmId) {
        this.id = id;
        this.nickname = nickname;
        this.reviewText = reviewText;
        this.filmId = filmId;
    }

    public Review(String nickname, String reviewText, int filmId) {
        this(-1, nickname, reviewText, filmId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }


    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }
}
