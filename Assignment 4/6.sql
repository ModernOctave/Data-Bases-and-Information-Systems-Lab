select table_name, column_name, data_type
from information_schema.columns
where table_name = 'advisor';

select table_name, column_name, data_type
from information_schema.columns
where table_name = 'classroom';

select table_name, column_name, data_type
from information_schema.columns
where table_name = 'course';

select table_name, column_name, data_type
from information_schema.columns
where table_name = 'department';

select table_name, column_name, data_type
from information_schema.columns
where table_name = 'instructor';

select table_name, column_name, data_type
from information_schema.columns
where table_name = 'prereq';

select table_name, column_name, data_type
from information_schema.columns
where table_name = 'section';

select table_name, column_name, data_type
from information_schema.columns
where table_name = 'student';

select table_name, column_name, data_type
from information_schema.columns
where table_name = 'takes';

select table_name, column_name, data_type
from information_schema.columns
where table_name = 'teaches';

select table_name, column_name, data_type
from information_schema.columns
where table_name = 'time_slot';
