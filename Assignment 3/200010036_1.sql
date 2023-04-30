-- 1
create user 'lab3'@'localhost' identified by 'iitdh';
create database lab3;
grant all privileges on lab3.* to 'lab3'@'localhost';

-- 2
use lab3;

create table part (
    part_no int,
    part_name varchar(25),
    color varchar(15),
    weight int,
    primary key (part_no)
);

create table supplier (
    supplier_no int,
    sup_name varchar(25),
    city varchar(25),
    bank varchar(25),
    primary key (supplier_no)
);

create table shipment (
    shipment_no int,
    part_no int,
    supplier_no int,
    date date,
    quantity int,
    price int,
    primary key (shipment_no),
    foreign key (part_no) references part(part_no),
    foreign key (supplier_no) references supplier(supplier_no)
);

-- 3
insert into part values (1, 'screw', 'silver', 12);
insert into supplier values (1, 'Singh Screw Co.', 'Delhi', 'SBI');
insert into shipment values (1, 1, 1, '2022-05-15', 100, 10);

-- 5
-- a
select distinct sup_name 
from supplier
natural join shipment
natural join part
where color = 'red';

-- b
select sup_name, sum(quantity * price) as total
from shipment
natural join supplier
group by sup_name;

-- c
select distinct sup_name 
from shipment
natural join supplier;
