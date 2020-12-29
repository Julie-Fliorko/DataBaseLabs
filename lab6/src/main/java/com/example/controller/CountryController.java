package com.example.controller;

import com.example.DTO.CountryDTO;
import com.example.domain.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

import com.example.service.CountryService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/country")
@RestController
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }
    @RequestMapping(method = RequestMethod.GET)
    // зверніть увагу: get - віддає щось до користувача, то ми маємо віддати DTO, а не об'єкти
    public ResponseEntity<List<CountryDTO>> getAll() {
        // стягуємо всі ентіті
        List<Country> countries = countryService.getAll();
        // створюємо (поки що) пустий список для DTOшок
        List<CountryDTO> autoDtos = new ArrayList<>();
        // перебираємо кожен ентіті, що ми знайшли, конвертуємо в DTO і додаємо DTO до ліста
        for (Country country : countries) {
            CountryDTO countryDto = new CountryDTO(
                    country.getName(),
                    country.getId()
            );
            autoDtos.add(countryDto);
        }
        return new ResponseEntity<>(autoDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    // віддаємо на клієнтську частину дані - знову ж таки, віддаємо їх як DTO
    public ResponseEntity<CountryDTO> getById(@PathVariable Integer id) {
        Country country = countryService.getById(id);
        try {

            // і знову та сама хуйня дублюється... бачите чому класно мати якийсь Mapper?
            CountryDTO countryDto = new CountryDTO(
                    country.getName(),
                    country.getId()

            );
            return new ResponseEntity<>(countryDto, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    // параметр consumes - кажемо, що POST в нас хаває дані теж в форматі JSON
    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody Country newCountry) {
        // а тут DTOшок вже не буде, бо нам ж треба в базу зберегти нормальний об'єкт,
        // а не DTO, правда?
        countryService.create(newCountry);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CountryDTO> update(@PathVariable Integer id,
                                          @RequestBody Country country) {
        Country oldCountry = countryService.getById(id);

        if (oldCountry != null && oldCountry.getName() != null) {
            countryService.update(id, country);
            CountryDTO oldCountryDto = new CountryDTO(
                    country.getName(),
                    country.getId()
            );
            return new ResponseEntity<>(oldCountryDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {

        try {
            if (countryService.getById(id) != null && countryService.getById(id).getName() != null) {
                countryService.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
