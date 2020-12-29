use students_db;

-- №1 Параметризована втавка

drop procedure if exists insert_into_students;

DELIMITER //
create procedure insert_into_students(  
		name VARCHAR(45),
	surname VARCHAR(45),
		last_name VARCHAR(45),
	date_of_birth DATE,
		date_of_entry DATE,
	student_card_id VARCHAR(12),
		email_address VARCHAR(45),
	city_id int,
		school_id int,
  group_id int)
  begin
	insert into insert_into_studentd(name, surname, last_name, date_of_birth, student_card_id, email_address, city_id, school_id, group_id)
    values (name, surname, last_name, date_of_birth, student_card_id, email_address, city_id, school_id, group_id);
end //
DELIMITER ;

-- №2: вивести дані зі стикувальної таблиці М:М, замінивши числові значення реальними назвами

drop procedure if exists print_many_to_many;

DELIMITER //
create procedure print_many_to_many()
begin
	select CONCAT(f.surname, ', ', f.name, ', ', f.last_name) as full_name, fi.name as value_name
    from student_has_dept
    join dept files on files.id = dept_id
    join student file on file.id = student_id;
end //
DELIMITER ;


-- №3: динамічне створення 2х таблиць, ідентичних до students. випадковим чином пострічково
-- скопіювати стрічки таблиці students в одну з додаткових.


	drop procedure if exists create_random_tables;

DELIMITER //
create procedure create_random_tables()
begin
		declare done bool default false;
	declare new_id, new_city_id, new_school_id, new_group_id int;
    declare new_name, new_surname, new_last_name,  new_email_address varchar(45);
    declare new_date_of_birth, new_date_of_entry date;
    
    declare trees CURSOR
		for select * from students;
	declare continue handler
		for not found set done = true;
        
        drop table if exists new_tree_1;
	drop table if exists new_tree_2;
    
create table new_student_1 like students;
create table new_student_2 like students;
    
open trees;

students_loop:
			Loop
				fetch trees into new_id, new_city_id, new_school_id, new_group_id, new_name, new_surname, new_last_name,  new_email_address, new_date_of_birth, new_date_of_entry;
			if done then
				leave students_loop;
			end if;
            
            if rand() > 0.5 then
				insert into new_student_1 (new_id, new_city_id, new_school_id, new_group_id, new_name, new_surname, new_last_name,  new_email_address, new_date_of_birth, new_date_of_entry)
                values (new_id, new_city_id, new_school_id, new_group_id, new_name, new_surname, new_last_name,  new_email_address, new_date_of_birth, new_date_of_entry);
                
			else
				insert into new_student_2 (new_id, new_city_id, new_school_id, new_group_id, new_name, new_surname, new_last_name,  new_email_address, new_date_of_birth, new_date_of_entry)
                values (new_id, new_city_id, new_school_id, new_group_id, new_name, new_surname, new_last_name,  new_email_address, new_date_of_birth, new_date_of_entry);
end if;
		END LOOP;
    close trees;
end //
DELIMITER ;

