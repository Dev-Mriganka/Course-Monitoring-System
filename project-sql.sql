use project;

create table Admin
(
username varchar(255),
password varchar(255)
);

create table Faculty
(
facultyId int primary key auto_increment,
facultyname varchar(255),
facultyaddress varchar(255),
mobile varchar(10),
email varchar(255),
username varchar(255),
password varchar(255)
);

create table Course
(
courseId int primary key auto_increment,
courseName varchar(255),
fee int,
courseDescription varchar(255)
);

create table Batch
(
batchid int primary key auto_increment,
courseId int,
facultyId int,
numberofStudents int,
batchstartDate date,
duration varchar(255),
foreign key (courseId) references Course (courseid),
foreign key (facultyId) references faculty (facultyid)
);

create table courseplan
(
planid int primary key auto_increment,
batchId int,
daynumber int,
topic varchar(255),
status boolean,
foreign key (batchId) references Batch (batchid)
);




