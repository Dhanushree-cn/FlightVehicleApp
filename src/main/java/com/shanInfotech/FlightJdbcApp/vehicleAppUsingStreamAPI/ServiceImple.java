package com.shanInfotech.FlightJdbcApp.vehicleAppUsingStreamAPI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import com.shanInfotech.FlightJdbcApp.vehicleAppUsingStreamAPI.DBConnect;

public class ServiceImple implements IService {
	private Connection con=null;

	private PreparedStatement ps=null;
	private ResultSet rs=null;
	Scanner sc=new Scanner(System.in);
	VehicleImple vdao=new VehicleImple();


	@Override
	public void addService() throws Exception {
		
		List<vehicles> vehicles=vdao.getVehicle();
		System.out.println("Available vehicle");
		vehicles.forEach(System.out::println);
		
	System.out.println("enter vehicle id for service");
	int userVid=sc.nextInt();
	sc.nextLine();
	
	Optional<vehicles>matchedVehicle=vehicles.stream().filter(v->v.getVehicleId()==userVid).findFirst();
	if(matchedVehicle.isEmpty()) {
		System.out.println("vehicle id not found");
		return;
	}
	
	System.out.println("enterb service record id");
	int  rid=sc.nextInt();
	sc.nextLine();
	
	System.out.println("enter service date(yyyy-mm--dd):");
	String sDate=sc.nextLine();
	
	System.out.println("enter description:");
	String desc=sc.nextLine();
	
	System.out.println("enter cost");
	double cost=sc.nextDouble();
	
	serviceRecords sr=new serviceRecords(rid,matchedVehicle.get(),sDate,desc,cost);
	con=DBConnect.Connect();
	con.setAutoCommit(false);
	String insertvalue="insert into service_records values(?,?,?,?,?)";
	ps=con.prepareStatement(insertvalue);
	System.out.println("insert service data");
	ps.setInt(1, sr.getRecordid());
	ps.setInt(2, sr.getVehicleid().getVehicleId());	
	ps.setString(3, sr.getServicedate());
	ps.setString(4, sr.getDescription());
	ps.setDouble(5, sr.getCost());
	ps.executeUpdate();
	con.commit();
	System.out.println("data inserted successfully");
	
	con.close();
	
	
	
	
	
		
		
	}

	@Override
	public List<serviceRecords> getService() throws Exception {
		List<serviceRecords>list=new ArrayList<>();
		List<vehicles> vehicles=vdao.getVehicle();
		con=DBConnect.Connect();
		ps=con.prepareStatement("select * from service_records");
		rs=ps.executeQuery();
		while(rs.next()) {
			int vehicleIdFromService=rs.getInt(1);
			vehicles  matchedVehicle=vehicles.stream().filter(v->v.getVehicleId()==vehicleIdFromService).findFirst().orElse(null);
			serviceRecords r=new serviceRecords(
					rs.getInt(1),
					matchedVehicle,
					rs.getString(3),
					rs.getString(4),
					rs.getDouble(5)
					
					);
			list.add(r);
		}
		con.close();
		
		return list;
	}

	@Override
	public void addserviceRecords() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getserviceRecords() {
		// TODO Auto-generated method stub
		
	}

}
