package com.example.service;

import com.example.repository.FunFactRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.domain.FunFact;

@Service
public class FunFactService extends AbstractService<FunFact, Integer> {

    private final FunFactRepository funFactRepository;

    public FunFactService(FunFactRepository funFactRepository) {
        this.funFactRepository = funFactRepository;
    }

    @Override
    protected JpaRepository<FunFact, Integer> getRepository() {
        return funFactRepository;
    }

}