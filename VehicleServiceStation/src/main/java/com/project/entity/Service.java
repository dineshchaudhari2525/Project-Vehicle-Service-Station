package com.project.entity;

public abstract class Service {
	
    private int id;
    private String type;
    private double total_cost;
    private String remark;
    
    
    
	public Service() {
		
	}
	

	public Service(int id, String type, double total_cost, String remark) {
		super();
		this.id = id;
		this.type = type;
		this.total_cost = total_cost;
		this.remark = remark;
	}


	public Service(String type) {
		this.type=type;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(double total_cost) {
		this.total_cost = total_cost;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", type=" + type + ", total_cost=" + total_cost + ", remark=" + remark + "]";
	}


	public abstract void acceptService() ;
	
	public abstract void calculateTotalCost();
}
