package com.example.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.domain.Review;
import com.example.repository.ReviewRepository;

@Service
public class ReviewService extends AbstractService<Review, Integer> {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    protected JpaRepository<Review, Integer> getRepository() {
        return reviewRepository;
    }

}