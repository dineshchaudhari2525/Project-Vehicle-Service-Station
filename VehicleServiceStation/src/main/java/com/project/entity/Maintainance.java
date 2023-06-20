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
