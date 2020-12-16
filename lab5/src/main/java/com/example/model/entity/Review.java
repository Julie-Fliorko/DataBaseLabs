package com.example.model.entity;

import javax.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;
    @Column(name = "nick_name")
    private String nickname;
    @Column(name = "review_text")
    private String reviewText;
    @ManyToOne
    @JoinColumn(name = "film_id", referencedColumnName = "id", nullable = false)
    private Film film;

    @Override
    public String toString() {
        return "--------------------------------------------------"+"\n"+"Review{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", reviewText='" + reviewText + '\'' +
                ", film=" + film +
                '}'+"\n";
    }

    public Review(int id, String nickname, String reviewText, Film film) {
        this.id = id;
        this.nickname = nickname;
        this.reviewText = reviewText;
        this.film = film;
    }

    public Review(String nickname, String reviewText, Film film) {
        this.nickname = nickname;
        this.reviewText = reviewText;
        this.film = film;
    }

    public Review() {
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

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
