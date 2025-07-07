package com.shanInfotech.FlightJdbcApp.vehicleAppUsingStreamAPI;

import java.util.List;

public interface IService {
	public void addService() throws Exception;
	public List<serviceRecords>getService()throws Exception;
	void addserviceRecords(serviceRecords r) throws Exception;
	void getserviceRecords();

}
