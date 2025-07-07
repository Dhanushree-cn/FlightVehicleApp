package com.shanInfotech.FlightJdbcApp.vehicleAppUsingStreamAPI;

public class vehicles {
	private int vehicleId;
	private String ownerName;
	private String model;
	private String registrationNumber;
	
	
	public vehicles() {
		
	}


	
	public vehicles(int vehicleId, String ownerName, String model, String registrationNumber) {
		super();
		this.vehicleId = vehicleId;
		this.ownerName = ownerName;
		this.model = model;
		this.registrationNumber = registrationNumber;
	}


	public int getVehicleId() {
		return vehicleId;
	}


	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}


	public String getOwnerName() {
		return ownerName;
	}


	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getRegistrationNumber() {
		return registrationNumber;
	}


	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}


	@Override
	public String toString() {
		return "vehicles [vehicleId=" + vehicleId + ", ownerName=" + ownerName + ", model=" + model
				+ ", registrationNumber=" + registrationNumber + "]";
	}


	
}
