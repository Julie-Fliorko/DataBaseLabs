package com.example.model.dao.implementation;
import com.example.model.entity.Film;
import com.example.model.dao.GenericDAO;
import com.example.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO implements GenericDAO<Film>{
    private static final String GET_ALL = "SELECT * FROM julie_fliorko_db.film";
    private static final String GET_ONE = "SELECT * FROM julie_fliorko_db.film WHERE id=?";
    private static final String CREATE = "INSERT julie_fliorko_db.film "
            + "(name, runtime_in_min, rating_out_of_ten, origin_city, production_company_id, country_id) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE julie_fliorko_db.film"
            + " SET name=?, runtime_in_min=?, rating_out_of_ten=?, origin_city=?, production_company_id=?, country_id=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM julie_fliorko_db.film WHERE id=?";

    @Override
    public List<Film> findAll() throws SQLException {
        List<Film> films = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Film film = new Film(
                        resultSet.getString("name"),
                        resultSet.getInt("runtime_in_min"),
                        resultSet.getInt("rating_out_of_ten"),
                        resultSet.getString("origin_city"),
                        resultSet.getInt("production_company_id"),
                        resultSet.getInt("country_id"));

                films.add(film);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return films;
    }

    @Override
    public Film findOne(Integer id) throws SQLException {
        Film film = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                film = new Film(
                        resultSet.getString("name"),
                        resultSet.getInt("runtime_in_min"),
                        resultSet.getInt("rating_out_of_ten"),
                        resultSet.getString("origin_city"),
                        resultSet.getInt("production_company_id"),
                        resultSet.getInt("country_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return film;
    }

    @Override
    public void create(Film film) throws SQLException {

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {

            statement.setString(1, film.getName());
            statement.setInt(2, film.getRuntimeInMinutes());
            statement.setInt(3, film.getRatingOutOfTen());
            statement.setString(4, film.getOriginCity());
            statement.setInt(5, film.getProductionCompanyId());
            statement.setInt(6, film.getCountryId());


            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Film film) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {

            statement.setInt(1, film.getId());
            statement.setString(2, film.getName());
            statement.setInt(4, film.getRuntimeInMinutes());
            statement.setInt(5, film.getRatingOutOfTen());
            statement.setString(6, film.getOriginCity());
            statement.setInt(7, film.getProductionCompanyId());
            statement.setInt(8, film.getCountryId());

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
