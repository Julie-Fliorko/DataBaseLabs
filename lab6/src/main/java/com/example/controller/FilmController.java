package com.example.controller;

import com.example.domain.Film;
import com.example.service.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import com.example.DTO.FilmDTO;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/film")
@RestController
public class FilmController {
    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }


    @RequestMapping(method = RequestMethod.GET)

    public ResponseEntity<List<FilmDTO>> getAll() {

        List<Film> films = filmService.getAll();

        List<FilmDTO> filmsDTOs = new ArrayList<>();


        for (Film film : films) {
            try {
                FilmDTO filmDTO = new FilmDTO(
                        film.getId(),
                        film.getName(),
                        film.getOriginCity(),
                        film.getCountry().getName(),
                        film.getProductionCompany().getName());
                filmsDTOs.add(filmDTO);
            } catch (NullPointerException e) {
                FilmDTO filmDTO = new FilmDTO(
                        film.getId(),
                        film.getName(),
                        film.getOriginCity(),
                        film.getCountry().getName(),
                        film.getProductionCompany().getName());
                filmsDTOs.add(filmDTO);
            }
        }
        return new ResponseEntity<>(filmsDTOs, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")

    public ResponseEntity<FilmDTO> getById(@PathVariable Integer id) {
        Film film = filmService.getById(id);
        try {


            FilmDTO filmDTO = new FilmDTO(
                    film.getId(),
                    film.getName(),
                    film.getOriginCity(),
                    film.getCountry().getName(),
                    film.getProductionCompany().getName()

            );
            return new ResponseEntity<>(filmDTO, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (NullPointerException e) {
            FilmDTO filmDTO = new FilmDTO(
                    film.getId(),
                    film.getName(),
                    film.getOriginCity(),
                    film.getCountry().getName(),
                    film.getProductionCompany().getName());
            return new ResponseEntity<>(filmDTO, HttpStatus.OK);
        }


    }


    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody Film newPersonalData) {

        filmService.create(newPersonalData);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<FilmDTO> update(@PathVariable Integer id,
                                                  @RequestBody Film film) {
        Film oldFilm = filmService.getById(id);

        if (oldFilm != null && oldFilm.getCountry().getName() != null && oldFilm.getProductionCompany().getName() != null) {

            filmService.update(id, film);
            try {
                FilmDTO oldFilmDTO = new FilmDTO(
                        film.getId(),
                        film.getName(),
                        film.getOriginCity(),
                        film.getCountry().getName(),
                        film.getProductionCompany().getName()
                );
                return new ResponseEntity<>(oldFilmDTO, HttpStatus.OK);
            } catch (NullPointerException e) {
                FilmDTO oldFilmDTO = new FilmDTO(
                        film.getId(),
                        film.getName(),
                        film.getOriginCity(),
                        film.getCountry().getName(),
                        film.getProductionCompany().getName()
                );
                return new ResponseEntity<>(oldFilmDTO, HttpStatus.OK);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {

        try {
            if (filmService.getById(id) != null && filmService.getById(id).getCountry().getName() != null && filmService.getById(id).getProductionCompany().getName() !=null) {
                filmService.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}