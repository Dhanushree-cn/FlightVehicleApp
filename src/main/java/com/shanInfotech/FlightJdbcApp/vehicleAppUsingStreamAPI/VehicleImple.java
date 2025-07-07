package com.shanInfotech.FlightJdbcApp.vehicleAppUsingStreamAPI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.shanInfotech.FlightJdbcApp.DBConnect;

public class VehicleImple  implements IVehicle{
	private Connection con=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	Scanner sc=new Scanner(System.in);

	@Override
	public void addVehicle() throws Exception {
		System.out.println("Enter vehicle id:");
		int vid=sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the owner name");
		String owner=sc.nextLine();
		
		System.out.println("Enter the vehicle model");
		String model=sc.nextLine();
		
		System.out.println("Enter the registration no");
		String regno=sc.nextLine();
		
		vehicles v1=new vehicles(vid,owner,model,regno);
		con=DBConnect.Connect();
		con.setAutoCommit(false);
		String insert="insert into vehicles value(?,?,?,?)";
		ps=con.prepareStatement(insert);
		
		
		ps.setInt(1, v1.getVehicleId());
		
		ps.setString(2, v1.getOwnerName());
		ps.setString(3, v1.getModel());
		ps.setString(4, v1.getRegistrationNumber());
		ps.executeUpdate();
		con.commit();
		System.out.println(" vehicle data inserted successfully");
		con.close();
		
		
		
	}

	@Override
	public List<vehicles> getVehicle() throws Exception {
		List<vehicles>list=new ArrayList<>();
		Connection con=DBConnect.Connect();
		PreparedStatement ps=con.prepareStatement("Select * from vehicles");
		rs=ps.executeQuery();
		while(rs.next()) {
			list.add(new vehicles(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4)
					));
					
		}
		return list;
	}

}
