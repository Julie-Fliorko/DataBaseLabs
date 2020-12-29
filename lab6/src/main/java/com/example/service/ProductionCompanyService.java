package com.example.service;

import com.example.domain.ProductionCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.repository.ProductionCompanyRepository;

@Repository
public class ProductionCompanyService extends AbstractService<ProductionCompany, Integer> {

    private final ProductionCompanyRepository productionCompanyRepository;

    public ProductionCompanyService(ProductionCompanyRepository productionCompanyRepository) {
        this.productionCompanyRepository = productionCompanyRepository;
    }

    @Override
    protected JpaRepository<ProductionCompany, Integer> getRepository() {
        return productionCompanyRepository;
    }

}