
CREATE SCHEMA IF NOT EXISTS `students_db` DEFAULT CHARACTER SET utf8 ;
USE `students_db` ;

drop table if exists students;
drop table if exists city;
drop table if exists graduetion_school;
drop table if exists `group`;
drop table if exists oblast;


-- -----------------------------------------------------
-- Table `students_db`.`students`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `students_db`.`students` (
  `id` INT NOT NULL auto_increment PRIMARY KEY,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `ranking` int not null,
  `date_of_birth` DATE NOT NULL,
  `date_of_entry` DATE NOT NULL,
  `student_card_id_num` VARCHAR(12) NOT NULL,
  `email_address` VARCHAR(45) NOT NULL,
  `city_id` int not null,
  `school_id` int not null,
  `group_id` int not null);


-- -----------------------------------------------------
-- Table `students_db`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `students_db`.`city` (
  `id` INT NOT NULL auto_increment PRIMARY KEY,
  `city` VARCHAR(45) NOT NULL);

-- -----------------------------------------------------
-- Table `students_db`.`oblast`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `students_db`.`oblast` (
  `id` INT NOT NULL auto_increment PRIMARY KEY,
  `oblast_name` VARCHAR(45) NOT NULL,
  `post_code` INT NOT NULL,
  `city_id` int not null);


-- -----------------------------------------------------
-- Table `students_db`.`graduetion_school`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `students_db`.`graduetion_school` (
  `id` INT NOT NULL auto_increment PRIMARY KEY,
  `school_name` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(13) NOT NULL,
  `head_teachers_full_name` VARCHAR(45) NOT NULL,
  `city_id` int not null);


-- -----------------------------------------------------
-- Table `students_db`.`group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `students_db`.`group` (
  `id` INT NOT NULL auto_increment PRIMARY KEY,
  `group_name` VARCHAR(45) NOT NULL,
  `group_number` INT NOT NULL,
  `year_of_entry` YEAR NOT NULL);



-- -----------------------------------------------------
-- Table `students_db`.`dept`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `students_db`.`dept` (
  `id` INT NOT NULL auto_increment PRIMARY KEY,
  `subject_name` VARCHAR(45) NOT NULL  );


-- -----------------------------------------------------
-- Table `students_db`.`student_has_dept`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `students_db`.`student_has_dept` (
  `id` INT NOT NULL auto_increment PRIMARY KEY,
  `dept_id` int NOT NULL,
  `student_id` int not null);
  