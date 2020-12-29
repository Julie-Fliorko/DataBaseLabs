
insert into city(city)
values('city1'),
('city2'),
('city3'),
('city4');



insert into `group`(group_name, group_number, year_of_entry)
values('group_name1', 1, 2020),
('group_name2', 2, 2020),
('group_name3', 3, 2020),
('group_name4', 4, 2020),
('group_name5', 5, 2020);

insert into graduetion_school(school_name, phone_number, head_teachers_full_name, city_id)
values('school_name1', '+380999999991', 'head_teachers_full_name1', 1),
('school_name2', '+380999999992', 'head_teachers_full_name2', 2),
('school_name3', '+380999999993', 'head_teachers_full_name3', 3),
('school_name4', '+380999999994', 'head_teachers_full_name4', 4),
('school_name5', '+380999999995', 'head_teachers_full_name5', 1);

insert into oblast(oblast_name, post_code, city_id)
values('oblast_name1', 1111, 1),
('oblast_name2', 2222, 2),
('oblast_name3', 3333, 3),
('oblast_name4', 4444, 4);

insert into students(name, surname, last_name, ranking, date_of_birth, date_of_entry, student_card_id_num, email_address, city_id, school_id, group_id)
values('name1', 'surname1', 'last name1',1 , "2017-06-15", "2017-06-15", 1, 'email1@gmail.com', 1, 1, 1),
('name2', 'surname2', 'last name2',2 , "2017-06-15", "2017-06-15", 1, 'email2@gmail.com', 2, 2, 2),
('name3', 'surname3', 'last name3', 3, "2017-06-15", "2017-06-15", 1, 'email3@gmail.com', 3, 3, 3),
('name4', 'surname4', 'last name4', 4, "2017-06-15", "2017-06-15", 'A11111111', 'email4@gmail.com', 1, 1, 1),
('name5', 'surname5', 'last name5', 5, "2017-06-15", "2017-06-15", 1, 'email5@gmail.com', 2, 2, 2);


insert into dept(subject_name)
values('subject_name1'),
('subject_name2'),
('subject_name3'),
('subject_name4'),
('subject_name5');

insert into student_has_dept(dept_id, student_id)
values(1,1),
(2,2),
(3,2),
(3,3),
(4,1);