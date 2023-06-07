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


