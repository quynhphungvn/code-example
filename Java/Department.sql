create database training;

use training;

create table if not exists department (
	id int not null auto_increment,
    name nvarchar(50) not null unique,
    primary key (id)
);
insert into department (name) values ("IT"),("Bussiness"), ("Marketing"), ("Sales");
create table if not exists employee (
	id int not null auto_increment,
    name nvarchar(50) not null unique,
    department_id int not null,
    primary key (id),
    foreign key (department_id) references department(id)
);

insert into employee(name, department_id) values ("Nguyen Dinh Thi", 1),("Nguyen Thuy Lan", 1),("Dau Ngoc Diep", 1),("Phan Thanh Thao", 1),
("Truong Ngoc Trong", 2),("Ta Bich Loan", 2),("Nguyen Phu Tho", 2),("Hoang Xuan Nguyen", 2),
("Dang Huyen Trang", 3),("Le Minh Vo", 3),("Hoang Xuan Hong", 3),("Truong Trong Tri", 3),("La Phuong Han", 3),
("Vo Van Alel", 4),("Dang Dinh Hung", 4),("Le Xuan Nhat", 4);
create table if not exists erole (
	id int not null auto_increment,
    name nvarchar(50) not null unique,
    primary key (id)
);

insert into erole (name) values ("manager"), ("employee"), ("admin");
create table if not exists employee_erole (
	id int not null auto_increment,
    employee_id int not null,
    erole_id int not null,
    primary key (id),
    foreign key (employee_id) references employee(id),
    foreign key (erole_id) references erole(id)
);

insert into employee_erole (employee_id, erole_id) values (1,1),(5,1),(9,1),(14,1),
(1,2),(2,2),(3,2),(4,2),(5,2),(6,2),(7,2),(8,2),(9,2),(10,2),(11,2),(12,2),(13,2),(14,2),(15,2),(16,2),
(14,3),(3,3);

