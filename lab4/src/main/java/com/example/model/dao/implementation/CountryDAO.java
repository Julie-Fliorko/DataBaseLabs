package com.example.model.dao.implementation;

import com.example.model.dao.GenericDAO;
import com.example.model.entity.Country;
import com.example.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO implements GenericDAO<Country> {
    private static final String GET_ALL = "SELECT * FROM julie_fliorko_db.country";
    private static final String GET_ONE = "SELECT * FROM julie_fliorko_db.country WHERE id=?";
    private static final String CREATE = "INSERT julie_fliorko_db.country "
            + "(name) VALUES (?)";
    private static final String UPDATE = "UPDATE julie_fliorko_db.country"
            + " SET name=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM julie_fliorko_db.country WHERE id=?";

    @Override
    public List<Country> findAll() throws SQLException {
        List<Country> countries = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Country country = new Country(
                        resultSet.getString("name"),
                        resultSet.getInt("id"));

                countries.add(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public Country findOne(Integer id) throws SQLException {
        Country country = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                country = new Country(
                        resultSet.getString("name"),
                        resultSet.getInt("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
    }

    @Override
    public void create(Country country) throws SQLException {

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {

            statement.setString(1, country.getName());

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Country country) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {

            statement.setInt(2, country.getId());
            statement.setString(1, country.getName());

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
