use lab3;

-- a
select distinct sup_name 
from supplier
natural join shipment
natural join part
where color = 'red';

-- b
select sup_name, sum(quantity * price) as total
from supplier
natural join shipment
group by sup_name;

-- c
select distinct sup_name 
from shipment
natural join supplier;
