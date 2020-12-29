package com.example.controller;

import com.example.DTO.FunFactDTO;
import com.example.domain.FunFact;
import com.example.service.FunFactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/fun_fact")
@RestController
public class FunFactController {
private final FunFactService factService;

    public FunFactController(FunFactService factService) {
        this.factService = factService;
    }


    @RequestMapping(method = RequestMethod.GET)

    public ResponseEntity<List<FunFactDTO>> getAll() {

        List<FunFact> facts = factService.getAll();

        List<FunFactDTO> factsDTOs = new ArrayList<>();


        for (FunFact fact : facts) {


            try {
                FunFactDTO factDto = new FunFactDTO(
                        fact.getId(),
                        fact.getSource(),
                        fact.getFactText(),
                        fact.getFilm().getName());
                factsDTOs.add(factDto);
            } catch (NullPointerException e) {
                FunFactDTO factDTO = new FunFactDTO(
                        fact.getId(),
                        fact.getSource(),
                        fact.getFactText(),
                        fact.getFilm().getName());
                factsDTOs.add(factDTO);
            }
        }
        return new ResponseEntity<>(factsDTOs, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")

    public ResponseEntity<FunFactDTO> getById(@PathVariable Integer id) {
        FunFact fact = factService.getById(id);
        try {


            FunFactDTO factDTO = new FunFactDTO(
                    fact.getId(),
                    fact.getSource(),
                    fact.getFactText(),
                    fact.getFilm().getName()

            );
            return new ResponseEntity<>(factDTO, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (NullPointerException e) {
            FunFactDTO factDTO = new FunFactDTO(
                    fact.getId(),
                    fact.getSource(),
                    fact.getFactText(),
                    fact.getFilm().getName());
            return new ResponseEntity<>(factDTO, HttpStatus.OK);
        }


    }


    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody FunFact newPersonalData) {

        factService.create(newPersonalData);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<FunFactDTO> update(@PathVariable Integer id,
                                                  @RequestBody FunFact fact) {
        FunFact oldFact = factService.getById(id);

        if (oldFact != null && oldFact.getFilm() != null) {

            factService.update(id, fact);
            try {
                FunFactDTO oldPersonalDataDto = new FunFactDTO(
                        fact.getId(),
                        fact.getSource(),
                        fact.getFactText(),
                        fact.getFilm().getName()
                );
                return new ResponseEntity<>(oldPersonalDataDto, HttpStatus.OK);
            } catch (NullPointerException e) {
                FunFactDTO oldPersonalDataDto = new FunFactDTO(
                        fact.getId(),
                        fact.getSource(),
                        fact.getFactText(),
                        fact.getFilm().getName()
                );
                return new ResponseEntity<>(oldPersonalDataDto, HttpStatus.OK);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {

        try {
            if (factService.getById(id) != null && factService.getById(id).getFilm() != null) {
                factService.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}