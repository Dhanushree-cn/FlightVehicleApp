package com.shanInfotech.FlightJdbcApp.vehicleAppUsingStreamAPI;

public class serviceRecords {
	private int recordid;
	private vehicles vehicleid;
	private String servicedate;
	private String  description;
	private double cost;
	
	public serviceRecords() {
		
	}

	
	public serviceRecords(int recordid, vehicles vehicleid, String servicedate, String description, double cost) {
		super();
		this.recordid = recordid;
		this.vehicleid = vehicleid;
		this.servicedate = servicedate;
		this.description = description;
		this.cost = cost;
	}


	public int getRecordid() {
		return recordid;
	}


	public void setRecordid(int recordid) {
		this.recordid = recordid;
	}


	public vehicles getVehicleid() {
		return vehicleid;
	}


	public void setVehicleid(vehicles vehicleid) {
		this.vehicleid = vehicleid;
	}


	public String getServicedate() {
		return servicedate;
	}


	public void setServicedate(String servicedate) {
		this.servicedate = servicedate;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	@Override
	public String toString() {
		return "serviceRecords [recordid=" + recordid + ", vehicleid=" + vehicleid + ", servicedate=" + servicedate
				+ ", description=" + description + ", cost=" + cost + "]";
	}
	


}
