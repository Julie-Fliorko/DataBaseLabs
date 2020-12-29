package com.example.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;
public abstract class AbstractService<T, ID extends Serializable> {
    public AbstractService(){
        super();
    }
    protected abstract JpaRepository<T, ID> getRepository();

    public List<T> getAll() {
        return getRepository().findAll();
    }

    public T getById(ID id) {
        return getRepository().getOne(id);
    }

    public T create(T newObject) {
        return getRepository().save(newObject);
    }

    public T update(ID id, T object) {
        if (getRepository().findById(id).isPresent()) {
            return getRepository().save(object);
        } else {
            return null;
        }
    }

    public void deleteById(ID id) {
        if (getRepository().findById(id).isPresent()) {
            getRepository().deleteById(id);
        }
    }

}