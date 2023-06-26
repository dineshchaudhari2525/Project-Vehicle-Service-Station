package com.project.entity;

public abstract class Service {

	private int id;
	protected String type;
	private double total_cost;
	private String remark;
	private int service_request_id;

	public Service() {

	}

	public Service(String type) {
		this.type = type;
	}
	
	public Service(int id, String type, double total_cost, String remark) {
		this.id = id;
		this.type = type;
		this.total_cost = total_cost;
		this.remark = remark;
		
	}

	public Service(int id, String type, double total_cost, String remark, int service_request_id) {
		this.id = id;
		this.type = type;
		this.total_cost = total_cost;
		this.remark = remark;
		this.service_request_id = service_request_id;
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

	public int getService_request_id() {
		return service_request_id;
	}

	public void setService_request_id(int service_request_id) {
		this.service_request_id = service_request_id;
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", type=" + type + ", total_cost=" + total_cost + ", remark=" + remark
				+ ", service_request_id=" + service_request_id + "]";
	}

	public abstract void acceptService();

	public abstract void calculateTotalCost();
}
