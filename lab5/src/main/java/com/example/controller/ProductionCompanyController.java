package com.example.controller;

import com.example.model.dao.implementation.ProductionCompanyDAO;
import com.example.model.entity.ProductionCompany;

import java.sql.SQLException;
import java.util.List;

public class ProductionCompanyController implements GenericController<ProductionCompany>{
    ProductionCompanyDAO dao = new ProductionCompanyDAO();

    @Override
    public List<ProductionCompany> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public ProductionCompany findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public void create(ProductionCompany entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, ProductionCompany entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }

}