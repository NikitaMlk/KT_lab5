/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Nikita
 * Created: 31 окт. 2024 г.
 */

-- створення таблиці
create table employee(id integer, first_name varchar(20), last_name varchar(20), 
designation varchar(20), phone varchar(20));
--додавання тестових даних
insert into employee values (1, 'Ivan', 'Petrenko', 'Manager', '11-22-33');
insert into employee values (2, 'Mykola', 'Kozhedub', 'Programmer', '33-44-55');
insert into employee values (3, 'Sergii', 'Zinchenko', 'System administrator', '12-
34-56');
insert into employee values (4, 'Oksana', 'Krutova', 'Manager', '56-78-90');
insert into employee values (5, 'Oleksii', 'Kuznetsov', 'Technician', '55-66-77');
-- обрати все з таблиці для перевірки
select * from employee;
