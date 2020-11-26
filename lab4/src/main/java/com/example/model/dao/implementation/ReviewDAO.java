package com.example.model.dao.implementation;

import com.example.model.dao.GenericDAO;
import com.example.model.entity.Review;
import com.example.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO implements GenericDAO<Review> {
    private static final String GET_ALL = "SELECT * FROM julie_fliorko_db.review";
    private static final String GET_ONE = "SELECT * FROM julie_fliorko_db.review WHERE id=?";
    private static final String CREATE = "INSERT julie_fliorko_db.review "
            + "(nick_name, review_text, film_id) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE julie_fliorko_db.review"
            + " SET nick_name=?, review_text=?, film_id=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM julie_fliorko_db.review WHERE id=?";

    @Override
    public List<Review> findAll() throws SQLException {
        List<Review> reviews = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Review review = new Review(
                        resultSet.getInt("id"),
                        resultSet.getString("nick_name"),
                        resultSet.getString("review_text"),
                        resultSet.getInt("film_id"));

                reviews.add(review);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reviews;
    }

    @Override
    public Review findOne(Integer id) throws SQLException {
        Review review = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                review = new Review(
                        resultSet.getInt("id"),
                        resultSet.getString("nick_name"),
                        resultSet.getString("review_text"),
                        resultSet.getInt("film_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return review;
    }

    @Override
    public void create(Review review) throws SQLException {

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {

            statement.setString(1, review.getNickname());
            statement.setString(2, review.getReviewText());
            statement.setInt(3, review.getFilmId());

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Review review) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, review.getId());
            statement.setString(2, review.getNickname());
            statement.setString(3, review.getReviewText());
            statement.setInt(4, review.getFilmId());

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

