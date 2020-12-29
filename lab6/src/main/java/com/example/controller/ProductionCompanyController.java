package com.example.controller;

import com.example.DTO.ProductionCompanyDTO;
import com.example.domain.ProductionCompany;
import com.example.service.ProductionCompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ProductionCompanyController {

    private final ProductionCompanyService companyService;

    public ProductionCompanyController(ProductionCompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(method = RequestMethod.GET)

    public ResponseEntity<List<ProductionCompanyDTO>> getAll() {

        List<ProductionCompany> companies = companyService.getAll();

        List<ProductionCompanyDTO> companiesDTOs = new ArrayList<>();


        for (ProductionCompany company : companies) {


            try {
                ProductionCompanyDTO companyDTO = new ProductionCompanyDTO(
                        company.getId(),
                        company.getName(),
                        company.getWebsite(),
                        company.getOwner());
                companiesDTOs.add(companyDTO);
            } catch (NullPointerException e) {
                ProductionCompanyDTO companyDTO = new ProductionCompanyDTO(
                        company.getId(),
                        company.getName(),
                        company.getWebsite(),
                        company.getOwner());
                companiesDTOs.add(companyDTO);
            }
        }
        return new ResponseEntity<>(companiesDTOs, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")

    public ResponseEntity<ProductionCompanyDTO> getById(@PathVariable Integer id) {
        ProductionCompany company = companyService.getById(id);
        try {


            ProductionCompanyDTO companyDTO = new ProductionCompanyDTO(
                    company.getId(),
                    company.getName(),
                    company.getWebsite(),
                    company.getOwner()

            );
            return new ResponseEntity<>(companyDTO, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (NullPointerException e) {
            ProductionCompanyDTO companyDTO = new ProductionCompanyDTO(
                    company.getId(),
                    company.getName(),
                    company.getWebsite(),
                    company.getOwner());
            return new ResponseEntity<>(companyDTO, HttpStatus.OK);
        }


    }


    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody ProductionCompany newCompany) {

        companyService.create(newCompany);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProductionCompanyDTO> update(@PathVariable Integer id,
                                             @RequestBody ProductionCompany company) {
        ProductionCompany oldCompany = companyService.getById(id);

        if (oldCompany != null) {

            companyService.update(id, company);
            try {
                ProductionCompanyDTO oldCompanyDTO = new ProductionCompanyDTO(
                        company.getId(),
                        company.getName(),
                        company.getWebsite(),
                        company.getOwner()
                );
                return new ResponseEntity<>(oldCompanyDTO, HttpStatus.OK);
            } catch (NullPointerException e) {
                ProductionCompanyDTO oldCompanyDTO = new ProductionCompanyDTO(
                        company.getId(),
                        company.getName(),
                        company.getWebsite(),
                        company.getOwner()
                );
                return new ResponseEntity<>(oldCompanyDTO, HttpStatus.OK);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {

        try {
            if (companyService.getById(id) != null) {
                companyService.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
