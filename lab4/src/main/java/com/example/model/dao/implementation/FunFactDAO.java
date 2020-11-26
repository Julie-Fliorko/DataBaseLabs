package com.example.model.dao.implementation;

import com.example.model.dao.GenericDAO;
import com.example.model.entity.FunFact;
import com.example.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FunFactDAO implements GenericDAO<FunFact> {
    private static final String GET_ALL = "SELECT * FROM julie_fliorko_db.fun_fact";
    private static final String GET_ONE = "SELECT * FROM julie_fliorko_db.fun_fact WHERE id=?";
    private static final String CREATE = "INSERT julie_fliorko_db.fun_fact "
            + "(sourse, fact_text, film_id) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE julie_fliorko_db.fun_fact"
            + " SETsourse=?, fact_text=?,  film_id=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM julie_fliorko_db.fun_fact WHERE id=?";

    @Override
    public List<FunFact> findAll() throws SQLException {
        List<FunFact> facts = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                FunFact fact = new FunFact(
                        resultSet.getInt("id"),
                        resultSet.getString("sourse"),
                        resultSet.getString("fact_text"),
                        resultSet.getInt("film_id"));

                facts.add(fact);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return facts;
    }

    @Override
    public FunFact findOne(Integer id) throws SQLException {
        FunFact fact = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                fact = new FunFact(
                        resultSet.getInt("id"),
                        resultSet.getString("sourse"),
                        resultSet.getString("fact_text"),
                        resultSet.getInt("film_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fact;
    }

    @Override
    public void create(FunFact fact) throws SQLException {

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {

            statement.setString(1, fact.getSource());
            statement.setString(2, fact.getFactText());
            statement.setInt(3, fact.getFilmId());

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, FunFact fact) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {

            statement.setInt(1, fact.getId());
            statement.setString(2, fact.getSource());
            statement.setString(3, fact.getFactText());
            statement.setInt(4, fact.getFilmId());

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

