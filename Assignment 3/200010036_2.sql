-- Parts
insert into part values (2, 'nut', 'black', 16);
insert into part values (3, 'bolt', 'red', 17);

-- Suppliers
insert into supplier values (2, 'Baburao & Sons', 'Mumbai', 'ICICI');
insert into supplier values (3, 'Rajesh Hardware', 'Chennai', 'HDFC');

-- Shipments
insert into shipment values (2, 1, 2, '2022-05-21', 200, 20);
insert into shipment values (3, 1, 1, '2021-06-13', 300, 30);
insert into shipment values (4, 1, 1, '2018-11-04', 400, 25);
insert into shipment values (5, 2, 1, '2003-02-26', 250, 15);
insert into shipment values (6, 2, 2, '2020-05-18', 650, 10);
insert into shipment values (7, 2, 2, '2019-12-05', 100, 20);
insert into shipment values (8, 2, 2, '2020-03-14', 200, 17);
insert into shipment values (9, 3, 1, '2012-12-30', 130, 20);
insert into shipment values (10, 3, 1, '2019-01-01', 150, 25);
insert into shipment values (11, 3, 1, '2014-11-26', 455, 12);
insert into shipment values (12, 3, 1, '2021-02-22', 120, 20);

-- Display Part table
select * from part;

-- Display Supplier table
select * from supplier;

-- Display Shipment table
select * from shipment;