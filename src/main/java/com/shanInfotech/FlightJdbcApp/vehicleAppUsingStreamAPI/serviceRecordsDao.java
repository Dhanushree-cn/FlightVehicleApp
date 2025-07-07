package com.shanInfotech.FlightJdbcApp.vehicleAppUsingStreamAPI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.shanInfotech.FlightJdbcApp.DBConnect;
import com.shanInfotech.FlightJdbcApp.VehicleServiceApp.IserviceRecords;
import com.shanInfotech.FlightJdbcApp.VehicleServiceApp.serviceRecords;

public class serviceRecordsDao  implements IserviceRecords{
	
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	Scanner sc=new Scanner(System.in);
	
	
	

	@Override
	public void addserviceRecords(serviceRecords r) throws Exception {
		con=DBConnect.Connect();
		con.setAutoCommit(false);
	
		String insertvalue="insert into service_records values(?,?,?,?,?)";
		ps=con.prepareStatement(insertvalue);
		System.out.println("insert service data");
		ps.setInt(1, r.getRecordid());
		ps.setInt(2, r.getVehicleid().getVehicleId());
		
		ps.setString(3, r.getServicedate());
		ps.setString(4, r.getDescription());
		ps.setDouble(5, r.getCost());
		ps.executeUpdate();
		con.commit();
		System.out.println("data inserted successfully");
		
		
		
		
		
		
	}

	@Override
	public void getserviceRecords() {
	
		
	}

}
