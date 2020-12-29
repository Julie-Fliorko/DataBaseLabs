use students_db;

-- №1: забезпечити цілісність даних


-- students
drop trigger if exists studentInts;

DELIMITER //
create trigger studentInts
		before insert 
	on students 
    for each row
begin 
		if(new.city_id not in(select id from city))then 
				signal sqlstate '45000'
			set message_text = 'FK error. no such city found';
        end if;
        if(new.school_id not in(select id from graduetion_school))then 
				signal sqlstate '45000'
			set message_text = 'FK error. no such school found found';
        end if;
        if(new.group_id not in(select id from `group`))then 
				signal sqlstate '45000'
			set message_text = 'FK error. no such group found found';
        end if;
end
// DELIMITER ;

drop trigger if exists studentUPD;
DELIMITER //
create trigger studentUpd
	before update
    on students
    for each row
begin
	    if (new.id != old.id and old in (select id from students)) then
		signal sqlstate '45000'
        set message_text = 'FK error. no such student found';
	end if;
end
// DELIMITER ;

drop trigger if exists studentDel;

DELIMITER //
create trigger studentDel
	before delete
    on students
    for each row
begin
	    if (old.id in (select student_id from student_has_dept)) then
		signal sqlstate '45000'
        set message_text = 'you cannot die without a dept';
	end if;
end
// DELIMITER ;


-- city


drop trigger if exists cityUPD;

drop trigger if exists cityUPD;
DELIMITER //
create trigger cityUpd
	before update
    on city
    for each row
begin
	    if(new.id != old.id and old in (select id from city))then 
				signal sqlstate '45000'
			set message_text = 'FK error. no such city found';
        end if;
end
// DELIMITER ;

drop trigger if exists cityDel;

DELIMITER //
create trigger cityDel
	before delete
    on city
    for each row
begin
	    if (old.id in (select city_id from students)) then
		signal sqlstate '45000'
        set message_text = 'you cannot die without a student';
		end if;
        if (old.id in (select city_id from oblast)) then
		signal sqlstate '45000'
        set message_text = 'you cannot die without a oblast';
		end if;
end
// DELIMITER ;

-- oblast

drop trigger if exists oblastUpd;

DELIMITER //
create trigger oblastUpd
	before update
    on oblast
    for each row
begin
    if (new.id != old.id and old in (select id from oblasr)) then
		signal sqlstate '45000'
        set message_text = 'no such value found';
	end if;
end
// DELIMITER ;



-- graduetion_school

drop trigger if exists graduetion_schoolInts;

DELIMITER //
create trigger graduetion_schoolInts
		before insert 
	on graduetion_school 
    for each row
begin 
		if(new.city_id not in(select id from city))then 
				signal sqlstate '45000'
			set message_text = 'FK error. no such city found';
        end if;
end
// DELIMITER ;
drop trigger if exists graduetion_schoolUPD;
DELIMITER //
create trigger graduetion_schoolUpd
	before update
    on students
    for each row
begin
	    if (new.id != old.id and old in (select id from graduetion_school)) then
		signal sqlstate '45000'
        set message_text = 'FK error. no such student found';
	end if;
end
// DELIMITER ;

drop trigger if exists graduetion_schoolDel;

DELIMITER //
create trigger graduetion_schoolDel
	before delete
    on graduetion_school
    for each row
begin
	    if (old.id in (select school_id from students)) then
		signal sqlstate '45000'
        set message_text = 'you cannot die without a students';
		end if;
end
// DELIMITER ;




-- group

drop trigger if exists groupInts;

DELIMITER //
create trigger groupInts
		before insert 
	on `group` 
    for each row
begin 
		if(new.id not in(select id from `group`))then 
				signal sqlstate '45000'
			set message_text = 'FK error. no such group found';
        end if;
end
// DELIMITER ;
drop trigger if exists graduetion_schoolUPD;
DELIMITER //
create trigger graduetion_schoolUpd
	before update
    on students
    for each row
begin
	    if (new.id != old.id and old in (select id from `group`)) then
		signal sqlstate '45000'
        set message_text = 'FK error. no such student found';
	end if;
end
// DELIMITER ;

drop trigger if exists groupDel;

DELIMITER //
create trigger groupDel
	before delete
    on `group`
    for each row
begin
	    if (old.id in (select group_id from students)) then
		signal sqlstate '45000'
        set message_text = 'you cannot die without a students';
		end if;
end
// DELIMITER ;


-- dept

drop trigger if exists deptUPD;
DELIMITER //
create trigger deptUpd
	before update
    on students
    for each row
begin
	    if (new.id != old.id and old in (select id from dept)) then
		signal sqlstate '45000'
        set message_text = 'FK error. no such student dept';
	end if;
end
// DELIMITER ;

drop trigger if exists studentDel;

DELIMITER //
create trigger studentDel
	before delete
    on students
    for each row
begin
	    if (old.id in (select dept_id from student_has_dept)) then
		signal sqlstate '45000'
        set message_text = 'you cannot die without a student';
	end if;
end
// DELIMITER ;



-- №2: для student_card_id забезпечити формат: Aхххххххх 

drop trigger if exists card_format;

DELIMITER //
create trigger card_format
    before insert
    on students
    for each row
begin
    if (new.student_card_id_num rlike '^((A)(([0-9]{4})))') then
		signal sqlstate '45000'
        set message_text = 'credit card does not match provided pattern!';
    end if;
end
//
DELIMITER ;

-- №3 Забезпечити максимальну кардинальність 6 стрічок для таблиці Групи.

drop trigger if exists groupcount;

DELIMITER //
create trigger groupcount
    before insert
    on `group`
    for each row
begin
		if( select count(*) from `group` ) = 6 then
		signal sqlstate '45000'
        set message_text = 'it is an extra group';
    end if;
end
//
DELIMITER ;