package com.shanInfotech.FlightJdbcApp.vehicleAppUsingStreamAPI;

import java.sql.Connection;





import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.shanInfotech.FlightJdbcApp.DBConnect;
import com.shanInfotech.FlightJdbcApp.VehicleServiceApp.Ivehicles;

public class VehicalsDao implements Ivehicles {
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	Scanner sc=new Scanner(System.in);

	@Override
	public void addvehicles(vehicles v) throws Exception {
		con=DBConnect.Connect();
		con.setAutoCommit(false);
		String insert="insert into vehicles value(?,?,?,?)";
		ps=con.prepareStatement(insert);
		
		
		ps.setInt(1, v.getVehicleId());
		
		ps.setString(2, v.getOwnerName());
		ps.setString(3, v.getModel());
		ps.setString(4, v.getRegistrationNumber());
		ps.executeUpdate();
		con.commit();
		System.out.println(" vehicle data inserted successfully");
		
		
		
	}

	@Override
	public void getvehicles() {
		
		
	}

	@Override
	public void addvehicles(com.shanInfotech.FlightJdbcApp.VehicleServiceApp.vehicles v) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
