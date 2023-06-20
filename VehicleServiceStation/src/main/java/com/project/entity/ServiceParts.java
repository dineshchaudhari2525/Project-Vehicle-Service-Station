package com.project.entity;

public class ServiceParts {
	private int partid;
	private int quantity;
	public ServiceParts() {
	
	}
	public ServiceParts(int partid, int quantity) {
		super();
		this.partid = partid;
		this.quantity = quantity;
	}
	public int getPartid() {
		return partid;
	}
	public void setPartid(int partid) {
		this.partid = partid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
