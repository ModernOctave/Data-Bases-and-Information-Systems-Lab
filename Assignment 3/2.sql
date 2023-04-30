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