package com.example.controller;

import com.example.model.dao.implementation.ReviewDAO;
import com.example.model.entity.Review;

import java.sql.SQLException;
import java.util.List;

public class ReviewController implements GenericController<Review>{
    ReviewDAO dao = new ReviewDAO();

@Override
public List<Review> findAll() throws SQLException {
    return dao.findAll();
}

@Override
public Review findOne(Integer id) throws SQLException {
    return dao.findOne(id);
}

@Override
public void create(Review entity) throws SQLException {
    dao.create(entity);
}

@Override
public void update(Integer id, Review entity) throws SQLException {
    dao.update(id, entity);
}

@Override
public void delete(Integer id) throws SQLException {
    dao.delete(id);

}

}
