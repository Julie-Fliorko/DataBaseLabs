drop SCHEMA IF EXISTS `julie_fliorko_db`;
CREATE SCHEMA IF NOT EXISTS `julie_fliorko_db` DEFAULT CHARACTER SET utf8 ;
USE `julie_fliorko_db`;


DROP TABLE IF EXISTS review;--
DROP TABLE IF EXISTS  fun_fact;--
DROP TABLE IF EXISTS actor;--
DROP TABLE IF EXISTS  film;--
DROP TABLE IF EXISTS  country;--
DROP TABLE IF EXISTS production_company;--
DROP TABLE IF EXISTS review;--



-- -----------------------------------------------------
-- Table julie_fliorko_db.country
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS country (
    name VARCHAR(45) NOT NULL,
    id INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`id`),
    UNIQUE INDEX id_UNIQUE (`id` ASC) VISIBLE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table julie_fliorko_db.production_company
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS production_company (
                                                  id INT NOT NULL AUTO_INCREMENT,
                                                  name VARCHAR(45) NOT NULL,
    website VARCHAR(200) NULL DEFAULT NULL,
    owner VARCHAR(100) NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX id_UNIQUE (`id` ASC) VISIBLE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table julie_fliorko_db.film
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS film (
                                    id INT NOT NULL AUTO_INCREMENT,
                                    name VARCHAR(45) NOT NULL,
    runtime_in_min INT NULL DEFAULT NULL,
    rating_out_of_ten INT NULL DEFAULT NULL,
    origin_city VARCHAR(45) NOT NULL,
    production_company_id INT NOT NULL,
    country_id INT NOT NULL,
    PRIMARY KEY (`id`, `production_company_id`),
    INDEX fk_film_production_company1_idx (`production_company_id` ASC) VISIBLE,
    INDEX fk_film_country1_idx (`country_id` ASC) VISIBLE,
    FOREIGN KEY (`country_id`)
    REFERENCES country (`id`),
    FOREIGN KEY (`production_company_id`)
    REFERENCES production_company (`id`))
    ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table julie_fliorko_db.review
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS review (
                                      id INT NOT NULL AUTO_INCREMENT ,--
                                      nick_name VARCHAR(45) NOT NULL,
    review_text VARCHAR(45) NOT NULL,
    film_id INT NOT NULL,
    PRIMARY KEY (`id`),
    INDEX fk_review_film1_idx (`film_id` ASC) VISIBLE,
    FOREIGN KEY (`film_id`)
    REFERENCES film (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table julie_fliorko_db.fun_fact
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS fun_fact (
                                        id INT NOT NULL AUTO_INCREMENT,
                                        sourse VARCHAR(90) NULL DEFAULT NULL,
    fact_text VARCHAR(45) NOT NULL,
    film_id INT NOT NULL,
    PRIMARY KEY (`id`, `film_id`),
    INDEX fk_fun_fact_film1_idx (`film_id` ASC) VISIBLE,
    FOREIGN KEY (`film_id`)
    REFERENCES film (`id`))
    ENGINE = InnoDB;


-- ----------------------------------------------------------------------
-- inserts
-- ----------------------------------------------------------------------
INSERT INTO julie_fliorko_db.production_company (`name`) VALUES
('CMC Pictures Holdings'),
('Sony'),
('China Lion Film Distribution'),
('Warner Bros'),
('Paramount'),
('Universal'),
('Beijing Enlight Pictures'),
('Warner Bros'),
('Disney'),
('Toho / Aniplex');

INSERT INTO julie_fliorko_db.country (name) VALUES
('China'),
('USA'),
('Japan');

INSERT INTO julie_fliorko_db.film (name, origin_city, production_company_id, country_id) VALUES
('The Eight Hundred', 'city1', '1', '1'),
('Bad Boys for Life', 'city2','2', '2'),
('My People, My Homeland', 'city3','3', '1'),
('Tenet', 'city4','4','2'),
('Sonic the Hedgehog', 'city5', '5', '2'),
('Dolittle', 'city6','6','2'),
('Jiang Ziya', 'city7','7','1'),
('Birds of Prey', 'city8','8','2'),
('Onward', 'city9','9', '2'),
('Demon Slayer: Infinity Train', 'city10','10', '3');

INSERT INTO julie_fliorko_db.review (nick_name, review_text, film_id) VALUES
('naickname1', 'review_text1', '1'),
('naickname2', 'review_text2', '2'),
('naickname3', 'review_text3', '3'),
('naickname4', 'review_text4', '4'),
('naickname5', 'review_text5', '5'),
('naickname6', 'review_text6', '6'),
('naickname7', 'review_text7', '7'),
('naickname8', 'review_text8', '8'),
('naickname9', 'review_text9', '9'),
('naickname10', 'review_text10', '10');


INSERT INTO julie_fliorko_db.fun_fact (sourse, fact_text, film_id) VALUES
('sourse1' ,'fact_text1'  ,1),
('sourse2' ,'fact_text2' ,2),
('sourse3' ,'fact_text3' ,3),
('sourse4' ,'fact_text4' ,4),
('sourse5' ,'fact_text5' ,5),
('sourse6' ,'fact_text6' ,6),
('sourse7' ,'fact_text7' ,7),
('sourse8' ,'fact_text8' ,8),
('sourse9' ,'fact_text9' ,9),
('sourse10' ,'fact_text10' ,10);

