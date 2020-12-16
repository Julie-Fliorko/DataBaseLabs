package com.example.view;

import com.example.controller.*;
import com.example.model.entity.*;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private static final Scanner SCANNER = new Scanner(System.in);
    private final Map<String, Printable> menu = new LinkedHashMap<>();

    private final FilmController filmController = new FilmController();
    private final CountryController countryController = new CountryController();
    private final FunFactController factController = new FunFactController();
    private final ProductionCompanyController companyController = new ProductionCompanyController();
    private final ReviewController reviewController = new ReviewController();
//company create
    public View() {
        /////////______Film______/////////
        menu.put("11", this::getAllFilms);
        menu.put("12", this::getFilmById);
        menu.put("13", this::createFilm);
        menu.put("14", this::updateFilm);
        menu.put("15", this::deleteFilm);

        /////////___User-Role___/////////
        menu.put("21", this::getAllCountries);
        menu.put("22", this::getCountryById);
        menu.put("23", this::createCountry);
        menu.put("24", this::updateUserRole);
        menu.put("25", this::deleteUserRole);

        /////////_____Fact_____////////
        menu.put("31", this::getAllFunFacts);
        menu.put("32", this::getFunFactById);
        menu.put("33", this::createFunFact);
        menu.put("34", this::updateFunFact);
        menu.put("35", this::deleteFunFact);

        /////////_____Product Company_____////////
        menu.put("41", this::getAllProductCompanies);
        menu.put("42", this::getProductCompanyById);
        menu.put("43", this::createProductCompany);
        menu.put("44", this::updateProductCompany);
        menu.put("45", this::deleteProductCompany);

        /////////_____Review_____////////
        menu.put("51", this::getAllReviews);
        menu.put("52", this::getReviewById);
        menu.put("53", this::createReview);
        menu.put("54", this::updateReview);
        menu.put("55", this::deleteReview);
    }

    public final void show() {


        String input;
        Menu showMenu = new Menu();
        showMenu.displayMenu();
        System.out.println("\n( ͡° ͜ʖ ͡°) Shoot your shot:\n");
        do {
            try {
                input = SCANNER.next();
                menu.get(input).print();
            } catch (Exception ignored) {
            }
        } while (SCANNER.hasNext());
    }


    ///////////////////////_____Film_____////////////////////
    private void getAllFilms() throws SQLException {
        System.out.println("\nGETting films...");
        System.out.println(filmController.findAll() + "\n");
    }


    private void getFilmById() throws SQLException {
        System.out.println("\nGETting film... Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(filmController.findOne(id) + "\n");
    }

    private Film getFilmInputs() throws SQLException {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();

        System.out.println("Enter runtime (in minutes please :) ) : ");
        int runtimeInMinutes = SCANNER.nextInt();

        System.out.println("Enter rating: ");
        int ratingOutOfTen = SCANNER.nextInt();

        System.out.println("\nEnter city: ");
        String originCity = SCANNER.next();

        System.out.println("Enter production company id: ");
        int productionCompanyId = SCANNER.nextInt();
        ProductionCompany productionCompany = companyController.findOne(productionCompanyId);
        System.out.println("Enter country Id: ");
        int countryId = Integer.parseInt(SCANNER.next());
        Country country = countryController.findOne(countryId);
        return new Film(name, runtimeInMinutes, ratingOutOfTen, originCity, productionCompany, country);
    }

    private void createFilm() throws SQLException {
        System.out.println("\nCREATing Film...");
        Film film = getFilmInputs();
        filmController.create(film);
        System.out.println("Hurrey! Film successfully created!\n");
    }

    private void updateFilm() throws SQLException {
        System.out.println("\nUPDATing Film... Enter ID: ");
        int id = SCANNER.nextInt();
        Film film = getFilmInputs();
        film.setId(id);

        filmController.update(film.getId(), film);
        System.out.println("Updated film with Id=" + id + "\n");
    }

    private void deleteFilm() throws SQLException {
        System.out.println("\nDELETing film... Enter ID: ");
        int id = SCANNER.nextInt();

        filmController.delete(id);
        System.out.println("Deleted film with ID=" + id + "\n");
    }
//////////////////////////////////////////////////////////////////////////////////


    //////////////////////_____Country_____///////////////////////////////

    private void getAllCountries() throws SQLException {
        System.out.println("\nGETting Country...");
        System.out.println(countryController.findAll() + "\n");
    }


    private void getCountryById() throws SQLException {
        System.out.println("\nGETting country... Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(countryController.findOne(id) + "\n");
    }

    private Country getCountryInputs() {
        System.out.println("Enter name: ");
        String name = String.valueOf(SCANNER.next());
        return new Country( name);
    }

    private void createCountry() throws SQLException {
        System.out.println("\nCREATing country...");
        Country country = getCountryInputs();
        countryController.create(country);
        System.out.println("Hurrey! Country successfully created!\n");
    }

    private void updateUserRole() throws SQLException {
        System.out.println("\nUPDATing country... Enter ID: ");
        int id = SCANNER.nextInt();
        Country userRole = getCountryInputs();
        userRole.setId(id);

        countryController.update(userRole.getId(), userRole);
        System.out.println("Updated country with Id=" + id + "\n");
    }

    private void deleteUserRole() throws SQLException {
        System.out.println("\nDELETing country... Enter ID: ");
        int id = SCANNER.nextInt();

        countryController.delete(id);
        System.out.println("Deleted country with ID=" + id + "\n");
    }
/////////////////////////////////////////////////////////////////////////////////
    //////////////////////_____FunFact_____////////////////////////////



    private void getAllFunFacts() throws SQLException {
        System.out.println("\nGETting actor...");
        System.out.println(factController.findAll() + "\n");
    }


    private void getFunFactById() throws SQLException {
        System.out.println("\nGETting Fun fact... Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(factController.findOne(id) + "\n");
    }

    private FunFact getFunFactInputs() throws SQLException {
        System.out.println("\nEnter source: ");
        String source = SCANNER.next();
        System.out.println("\nEnter fact: ");
        String factText = SCANNER.next();
        System.out.println("\nEnter fact id: ");
        int filmId = SCANNER.nextInt();
        Film film = filmController.findOne(filmId);

        return new FunFact(source, factText, film);

    }

    private void createFunFact() throws SQLException {
        System.out.println("\nCREATing fact...");
        FunFact actor = getFunFactInputs();
        factController.create(actor);
        System.out.println("Hurrey! Fun fact is successfully created!\n");
    }

    private void updateFunFact() throws SQLException {
        System.out.println("\nUPDATing fact... Enter ID: ");
        int id = SCANNER.nextInt();
        FunFact fact = getFunFactInputs();
        fact.setId(id);

        factController.update(fact.getId(), fact);
        System.out.println("Updated actor with Id=" + id + "\n");
    }

    private void deleteFunFact() throws SQLException {
        System.out.println("\nDELETing fact... Enter ID: ");
        int id = SCANNER.nextInt();

        factController.delete(id);
        System.out.println("Deleted fact with ID=" + id + "\n");
    }

    ///////////////////////_____Product company_____////////////////////
    private void getAllProductCompanies() throws SQLException {
        System.out.println("\nGETting company...");
        System.out.println(companyController.findAll() + "\n");
    }


    private void getProductCompanyById() throws SQLException {
        System.out.println("\nGETting company... Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(companyController.findOne(id) + "\n");
    }

    private ProductionCompany getProductCompanyInputs() {
        System.out.println("Enter name: ");
        String name = SCANNER.next();
        System.out.println("Enter website: ");
        String website = SCANNER.next();
        System.out.println("Enter owner: ");
        String owner = SCANNER.next();

        return new ProductionCompany(name, website, owner);
    }

    private void createProductCompany() throws SQLException {
        System.out.println("\nCREATing company...");
        ProductionCompany company = getProductCompanyInputs();
        companyController.create(company);
        System.out.println("Hurrey! company successfully created!\n");
    }

    private void updateProductCompany() throws SQLException {
        System.out.println("\nUPDATing company... Enter ID: ");
        int id = SCANNER.nextInt();
        ProductionCompany company = getProductCompanyInputs();
        company.setId(id);

        companyController.update(company.getId(), company);
        System.out.println("Updated company with Id=" + id + "\n");
    }

    private void deleteProductCompany() throws SQLException {
        System.out.println("\nDELETing company... Enter ID: ");
        int id = SCANNER.nextInt();

        companyController.delete(id);
        System.out.println("Deleted company with ID=" + id + "\n");
    }
//////////////////////////////////////////////////////////////////////////////////


    ///////////////////////_____Review_____////////////////////
    private void getAllReviews() throws SQLException {
        System.out.println("\nGETting company...");
        System.out.println(reviewController.findAll() + "\n");
    }


    private void getReviewById() throws SQLException {
        System.out.println("\nGETting company... Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(reviewController.findOne(id) + "\n");
    }

    private Review getReviewInputs() throws SQLException {
        System.out.println("Enter nickname: ");
        String nickname = SCANNER.next();
        System.out.println("Enter your review: ");
        String reviewText = SCANNER.next();
        System.out.println("Enter film id: ");
        int filmId = SCANNER.nextInt();
        Film film = filmController.findOne(filmId);
        return new Review(nickname, reviewText, film);
    }

    private void createReview() throws SQLException {
        System.out.println("\nCREATing review...");
        Review review = getReviewInputs();
        reviewController.create(review);
        System.out.println("Hurrey! review successfully created!\n");
    }

    private void updateReview() throws SQLException {
        System.out.println("\nUPDATing review... Enter ID: ");
        int id = SCANNER.nextInt();
        Review review = getReviewInputs();
        review.setId(id);

        reviewController.update(review.getId(), review);
        System.out.println("Updated review with Id=" + id + "\n");
    }

    private void deleteReview() throws SQLException {
        System.out.println("\nDELETing review... Enter ID: ");
        int id = SCANNER.nextInt();

        reviewController.delete(id);
        System.out.println("Deleted review with ID=" + id + "\n");
    }
//////////////////////////////////////////////////////////////////////////////////

}
