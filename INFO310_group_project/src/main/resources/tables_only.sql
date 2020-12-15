/*
    Author: Leon Hoogenraad
*/

/* CREATE THESE TABLES IN ORDER. */
create table Staff(
    staffID bigint auto_increment(0),
    firstname varchar(20) not null,
    surname varchar(20) not null,
    dateOfBirth varchar(10) not null, 
    gender varchar(10) not null,
    username varchar(15) not null unique,
    password varchar(20) not null,
    email varchar(30) not null unique, 
    phoneNumber varchar(20) not null,
    description varchar(300) not null,
    address varchar(30) not null,
    category varchar(30) not null,
    searching boolean,
    constraint staff_PK primary key (staffID)
);

create table Student(
    studentID integer not null unique,
    firstname varchar(20) not null,
    surname varchar(20) not null,
    dateOfBirth varchar(10) not null, 
    gender varchar(10) not null, 
    username varchar(15) not null unique,
    password varchar(20) not null,
    email varchar(30) not null unique,
    phoneNumber varchar(20) not null,
    description varchar(300) not null,
    address varchar(30) not null, 
    category varchar(30) not null,
    searching boolean,
    constraint student_PK primary key (studentID)
);

create table ContactRequest(
    contactrequestid bigint auto_increment(0),
    studentID integer not null,
    staffID integer not null,
    staffFirstname varchar(20) not null,
    staffLastname varchar(20) not null,
    studentFirstname varchar(20) not null,
    studentLastname varchar(20) not null,
    message varchar(300) not null,
    staffemail varchar(30) not null,
    studentemail varchar(30) not null,
    staffphonenumber varchar(20) not null,
    studentphonenumber varchar(20) not null,
    studenttoprofessor boolean not null,
    constraint CR_PK primary key (contactrequestid),
    constraint CR_FK_Student foreign key (studentID) references Student,
    constraint CR_FK_Staff foreign key (staffID) references Staff
);