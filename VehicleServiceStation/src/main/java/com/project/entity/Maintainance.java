package com.project.entity;

import java.util.ArrayList;
import java.util.List;

public class Maintainance extends Service {
	private double labourCharges;
	private double parts_cost;
	private List<ServiceParts>partsList;
	
	public Maintainance() {
		super("maintainance");
		this.labourCharges = 0;
		this.partsList=new ArrayList<ServiceParts>();
	}

	public Maintainance(double labourCharges, double parts_cost) {
		this.labourCharges=labourCharges;
		this.parts_cost=parts_cost;
	}

	public Maintainance(int id, String type, double labour_charges, double total_cost, String remark, double service_request_id) {
		super(id,type,total_cost,remark);
		this.labourCharges=labour_charges;
		
	
		
		
	}

	@Override
	public String toString() {
		return super.toString()+ "Maintainance [labourCharges=" + labourCharges + ", parts_cost=" + parts_cost + ", partsList="
				+ partsList + "]";
	}

	public double getLabourCharges() {
		return labourCharges;
	}

	public void setLabourCharges(double labourCharges) {
		this.labourCharges = labourCharges;
	}

	public double getParts_cost() {
		return parts_cost;
	}

	public void setParts_cost(double parts_cost) {
		this.parts_cost = parts_cost;
	}

	public List<ServiceParts> getPartsList() {
		return partsList;
	}

	public void setPartsList(List<ServiceParts> partsList) {
		this.partsList = partsList;
	}

	@Override
	public void acceptService() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calculateTotalCost() {
		// TODO Auto-generated method stub
		
	}
	

}
