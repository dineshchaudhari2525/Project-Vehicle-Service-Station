package com.project.entity;

import java.sql.Date;

public class Service {
	private int id;
	private String vehicle_number;
	private Date request_date;
	private Double bill_amount;
	public Service() {
		
	}
	public Service(int id, String vehicle_number) {
		super();
		this.id = id;
		this.vehicle_number = vehicle_number;
	
	}
	public Service(int id, String vehicle_number, Date request_date, Double bill_amount) {
		super();
		this.id = id;
		this.vehicle_number = vehicle_number;
		this.request_date = request_date;
		this.bill_amount = bill_amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVehicle_number() {
		return vehicle_number;
	}
	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
	}
	public Date getRequest_date() {
		return request_date;
	}
	public void setRequest_date(Date request_date) {
		this.request_date = request_date;
	}
	public Double getBill_amount() {
		return bill_amount;
	}
	public void setBill_amount(Double bill_amount) {
		this.bill_amount = bill_amount;
	}
	@Override
	public String toString() {
		return "Service [id=" + id + ", vehicle_number=" + vehicle_number + ", request_date=" + request_date
				+ ", bill_amount=" + bill_amount + "]";
	}
	

	
}
