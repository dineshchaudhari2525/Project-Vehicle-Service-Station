

CREATE DATABASE vehicles_db;

USE vehicles_db;

CREATE TABLE customer(
 id INT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(30),
 mobile VARCHAR(12),
 email VARCHAR(100),
 address VARCHAR(100)
);

insert into customer values(1,'David','9895607810','david@gmail.com','Pune');

insert into customer values(2,'Raj','9994717174','raj@gmail.com','Mumbai');

insert into customer values(3,'Sanket','7891007810','sanket@gmail.com','Satara');

insert into customer values(4,'Laxman','8845607890','laxman@gmail.com','Kolhapur');

insert into customer values(5,'Dhruva','9595857565','dhruva@gmail.com','Sambhaji Nagar');

insert into customer values(6,'Rani','78654507898','rani@gmail.com','Jalgoen');

insert into customer values(7,'James','9970139252','james@gmail.com','Nashik');

insert into customer values(8,'Lalita','9325280026','lalita@gmail.com','Chalisgoen');

insert into customer values(9,'Pooja','8759068778','pooja@gmail.com','Nagpur');

insert into customer values(10,'Nilesh','9876543210','nilesh@gmail.com','Kolhapur');





