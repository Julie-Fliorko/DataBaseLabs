package com.example.model.dao.implementation;

import com.example.model.dao.GenericDAO;
import com.example.model.entity.ProductionCompany;
import com.example.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductionCompanyDAO implements GenericDAO<ProductionCompany>{
        private static final String GET_ALL = "SELECT * FROM julie_fliorko_db.production_company";
        private static final String GET_ONE = "SELECT * FROM julie_fliorko_db.production_company WHERE id=?";
        private static final String CREATE = "INSERT julie_fliorko_db.production_company "
                + "(name, website, owner) VALUES (?, ?, ?, ?)";
        private static final String UPDATE = "UPDATE julie_fliorko_db.production_company"
                + " SET name=?, website=?, owner=?  WHERE id=?";
        private static final String DELETE = "DELETE FROM julie_fliorko_db.production_company WHERE id=?";

        @Override
        public List<ProductionCompany> findAll() throws SQLException {
        List<ProductionCompany> companies = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ProductionCompany company = new ProductionCompany(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("website"),
                        resultSet.getString("owner"));

                companies.add(company);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companies;
    }

        @Override
        public ProductionCompany findOne(Integer id) throws SQLException {
            ProductionCompany company = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                company = new ProductionCompany(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("website"),
                        resultSet.getString("owner"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return company;
    }

        @Override
        public void create(ProductionCompany company) throws SQLException {

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {

            statement.setString(1, company.getName());
            statement.setString(2, company.getWebsite());
            statement.setString(3, company.getOwner());

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        @Override
        public void update(Integer id, ProductionCompany company) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {

            statement.setString(1, company.getName());
            statement.setString(2, company.getWebsite());
            statement.setString(3, company.getOwner());
            statement.setInt(4, company.getId());

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
