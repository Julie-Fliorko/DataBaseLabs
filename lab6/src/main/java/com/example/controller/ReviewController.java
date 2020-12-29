package com.example.controller;

import com.example.DTO.ReviewDTO;
import com.example.domain.Review;
import com.example.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @RequestMapping(method = RequestMethod.GET)

    public ResponseEntity<List<ReviewDTO>> getAll() {

        List<Review> reviews = reviewService.getAll();

        List<ReviewDTO> reviewsDTOs = new ArrayList<>();


        for (Review review : reviews) {


            try {
                ReviewDTO reviewDTO = new ReviewDTO(
                        review.getId(),
                        review.getNickname(),
                        review.getReviewText(),
                        review.getFilm().getName());
                reviewsDTOs.add(reviewDTO);
            } catch (NullPointerException e) {
                ReviewDTO reviewDTO = new ReviewDTO(
                        review.getId(),
                        review.getNickname(),
                        review.getReviewText(),
                        review.getFilm().getName());
                reviewsDTOs.add(reviewDTO);
            }
        }
        return new ResponseEntity<>(reviewsDTOs, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")

    public ResponseEntity<ReviewDTO> getById(@PathVariable Integer id) {
        Review review = reviewService.getById(id);
        try {
            ReviewDTO reviewDTO = new ReviewDTO(
                    review.getId(),
                    review.getNickname(),
                    review.getReviewText(),
                    review.getFilm().getName()

            );
            return new ResponseEntity<>(reviewDTO, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (NullPointerException e) {
            ReviewDTO reviewDTO = new ReviewDTO(
                    review.getId(),
                    review.getNickname(),
                    review.getReviewText(),
                    review.getFilm().getName());
            return new ResponseEntity<>(reviewDTO, HttpStatus.OK);
        }


    }


    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody Review newReview) {

        reviewService.create(newReview);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ReviewDTO> update(@PathVariable Integer id,
                                             @RequestBody Review review) {
        Review oldReview = reviewService.getById(id);

        if (oldReview != null && oldReview.getFilm() != null) {

            reviewService.update(id, review);
            try {
                ReviewDTO oldReviewDTO = new ReviewDTO(
                        review.getId(),
                        review.getNickname(),
                        review.getReviewText(),
                        review.getFilm().getName()
                );
                return new ResponseEntity<>(oldReviewDTO, HttpStatus.OK);
            } catch (NullPointerException e) {
                ReviewDTO oldReviewDTO= new ReviewDTO(
                        review.getId(),
                        review.getNickname(),
                        review.getReviewText(),
                        oldReview.getFilm().getName()
                );
                return new ResponseEntity<>(oldReviewDTO, HttpStatus.OK);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {

        try {
            if (reviewService.getById(id) != null && reviewService.getById(id).getFilm().getName() != null && reviewService.getById(id).getFilm().getName() !=null) {
                reviewService.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
