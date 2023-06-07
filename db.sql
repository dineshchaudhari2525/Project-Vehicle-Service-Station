  create database vehicle_db;
   use vehicle_db;

create table customer(id INT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(30),mobile VARCHAR(12),email VARCHAR(50),address VARCHAR(100));
Query OK, 0 rows affected (0.01 sec)

mysql> insert into customer values(1,'David','9895607810','david@gmail.com','Pune');
Query OK, 1 row affected (0.01 sec)

mysql>
mysql> insert into customer values(2,'Raj','9994717174','raj@gmail.com','Mumbai');
Query OK, 1 row affected (0.00 sec)

mysql>
mysql> insert into customer values(3,'Sanket','7891007810','sanket@gmail.com','Satara');
Query OK, 1 row affected (0.00 sec)

mysql>
mysql> insert into customer values(4,'Laxman','8845607890','laxman@gmail.com','Kolhapur');
Query OK, 1 row affected (0.00 sec)

mysql>
mysql> insert into customer values(5,'Dhruva','9595857565','dhruva@gmail.com','Sambhaji Nagar');
Query OK, 1 row affected (0.00 sec)

mysql>
mysql> insert into customer values(6,'Rani','78654507898','rani@gmail.com','Jalgoen');
Query OK, 1 row affected (0.00 sec)

mysql>
mysql> insert into customer values(7,'James','9970139252','james@gmail.com','Nashik');
Query OK, 1 row affected (0.00 sec)

mysql>
mysql> insert into customer values(8,'Lalita','9325280026','lalita@gmail.com','Chalisgoen');
Query OK, 1 row affected (0.00 sec)

mysql>
mysql> insert into customer values(9,'Pooja','8759068778','pooja@gmail.com','Nagpur');
Query OK, 1 row affected (0.00 sec)

mysql>
mysql> insert into customer values(10,'Nilesh','9876543210','nilesh@gmail.com','Kolhapur');
Query OK, 1 row affected (0.00 sec)


 create table customer_vehicles(vehicle_number VARCHAR(10) PRIMARY KEY,customer_id INT,vehicle_id INT, foreign key(customer_id) REFERENCES customer(id) ON DELETE CASCADE ON UPDATE CASCADE,foreign key(vehicle_id) REFERENCES vehicle(id) ON DELETE CASCADE ON UPDATE CASCADE);
 insert into customer_vehicles values('MH12HK4481',8,9);
 insert into customer_vehicles values('MH09KV1234',10,4);
 insert into customer_vehicles values('MH09OP5678',10,6);
 insert into customer_vehicles values('MH15AB8814',7,1);
 insert into customer_vehicles values('MH20',5,8);
 insert into customer_vehicles values('MH11PD5161',3,2);
 insert into customer_vehicles values('MH01TY8814',2,7);
 insert into customer_vehicles values('MH01RM4141',2,10);
 insert into customer_vehicles values('MH19PH6543',6,2);
 insert into customer_vehicles values('MH31DS7890',9,8);
 insert into customer_vehicles values('MH12SJ4161',1,7);
 insert into customer_vehicles values('MH09OT0808',4,3);
 insert into customer_vehicles values('MH11AD7878',3,5);



