package com.example.controller;

import com.example.model.dao.implementation.FunFactDAO;
import com.example.model.entity.FunFact;

import java.sql.SQLException;
import java.util.List;

public class FunFactController implements GenericController<FunFact>{
    FunFactDAO dao = new FunFactDAO();

    @Override
    public List<FunFact> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public FunFact findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public void create(FunFact entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, FunFact entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }

}