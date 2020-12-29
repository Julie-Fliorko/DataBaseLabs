use students_db;

SET GLOBAL log_bin_trust_function_creators = 1;

-- №1: для students шукати MAX стовпця max_ranking.

drop function if exists get_max_max_ranking;

DELIMITER //
create function get_max_max_ranking()
returns varchar(30)
begin
return (
	select MAX(ranking)
    from students
);
end //
DELIMITER ;


-- №2: функція, яка стягує за ключем між city та oblast значення поля post_code.

drop function if exists get_post_code;

DELIMITER //
create function get_post_code(
city_id int
)
returns varchar(45)
begin
return (
	select s1.city 
	from oblast f
	left join city s1 on f.city_id = s1.id
    where f.id = city_id
);
end //
DELIMITER ;

-- вибірка даних
select get_max_max_ranking();
select *, get_post_code(id) from  city f;