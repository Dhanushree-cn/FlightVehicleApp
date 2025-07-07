package com.shanInfotech.FlightJdbcApp.vehicleAppUsingStreamAPI;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainClass {
	public static void main(String[]args)throws SQLException{
		IVehicle vdao=new VehicleImple();
		IService sdao=new ServiceImple();
		
		try {
//			vdao.addVehicle();
//			sdao.addService();
			
			List<vehicles>vehicles=vdao.getVehicle();
			System.out.println("\n all vehicle");
			vehicles.forEach(System.out::println);
			
			List<serviceRecords>services=sdao.getService();
			System.out.println("\n all service records");
			services.forEach(System.out::println);
			
			System.out.println("\n filtered service cost>1000");
			services.stream().filter(sr->sr.getCost()>1000).forEach(System.out::println);
			
			System.out.println("\n grouped by cost category:");
			Map<String,List<serviceRecords>> grouped=services.stream().collect(Collectors.groupingBy(sr->{
				if(sr.getCost()<1000)return "Low";
				else if(sr.getCost()<=2000)return "Medium";
				else return "High";
			}));
			
			grouped.forEach((category,list)->{
				System.out.println(category +" Cost:");
				list.forEach(System.out::println);
			});
			
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
