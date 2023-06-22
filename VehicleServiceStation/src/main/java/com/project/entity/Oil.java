package com.project.entity;

public class Oil extends Service {
	private double oil_cost;
	
	

	public Oil() {
		super("oil");
		
	}

	public Oil(double oil_cost) {
	this.oil_cost=oil_cost;
	}

	public Oil(int id, String type, double oil_cost, double total_cost, String remark) {
		super(id,type,total_cost,remark);
		this.oil_cost=oil_cost;
	}

	public double getOil_cost() {
		return oil_cost;
	}

	public void setOil_cost(double oil_cost) {
		this.oil_cost = oil_cost;
	}

	@Override
	public void acceptService() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calculateTotalCost() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return super.toString()+"Oil [oil_cost=" + oil_cost + "]";
	}
	

}
