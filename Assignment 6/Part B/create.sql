create database library;
use library;

-- Create the tables
create table book (
	book_id int,
	title varchar(50),
	category varchar(50),
	author varchar(50),
	primary key (book_id)
);

create table student (
	student_id int,
	name varchar(50),
	dept_name varchar(50),
	year int,
	semester int,
	primary key (student_id)
);

create table issue (
	student_id int,
	book_id int,
	issue_date date,
	return_date date,
	primary key (student_id, book_id, issue_date),
	foreign key (student_id) references student(student_id),
	foreign key (book_id) references book(book_id)
);