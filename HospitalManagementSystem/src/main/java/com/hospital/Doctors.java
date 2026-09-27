package com.hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Doctors {
  
	Scanner sc = new Scanner(System.in);
	
	public void addDoctor() {
		System.out.println("Enter Doctor's name: ");
		String name = sc.nextLine();
		
		System.out.println("Enter Specialization: ");
		String specialization = sc.nextLine();
		
		String sql = "INSERT INTO doctors (name, specialization) VALUES (?, ?)";
		
		try{
			   Connection conn = DBConnection.getConnection();
			   PreparedStatement ps = conn.prepareStatement(sql); 
			   ps.setString(1, name);
			   ps.setString(2, specialization);
			   
			   int row = ps.executeUpdate();
			   if(row > 0) {
				   System.out.println("Doctor added successfully.");
			   }
			   else {
				   System.out.println("Failed to add doctor.");
			   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void viewDoctor() {
		String sql = "SELECT * FROM doctors WHERE status='Active'";
		
		try{
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println("Doctor's List");
			System.out.println("+-----------+----------------------+----------------------+");
			System.out.println("| Doctor ID | Doctor Name          | Specialization       |");
			System.out.println("+-----------+----------------------+----------------------+");
			while (rs.next()) {
	            System.out.printf("| %-9d | %-20s | %-20s |%n", rs.getInt("doc_id"),rs.getString("name"),
	            		rs.getString("specialization"));
	               
	        }
			System.out.println("+-----------+----------------------+----------------------+");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateDoctor() {

	    System.out.println("Enter Doctor ID to update: ");
	    int id = sc.nextInt();
	    sc.nextLine();

	    System.out.println("Enter new Doctor's name: ");
	    String name = sc.nextLine();

	    System.out.println("Enter new Specialization: ");
	    String specialization = sc.nextLine();

	    String sql = "UPDATE doctors SET name = ?, specialization = ? WHERE doc_id = ?";

	    try {
	        Connection conn = DBConnection.getConnection();
	        PreparedStatement ps = conn.prepareStatement(sql);

	        ps.setString(1, name);
	        ps.setString(2, specialization);
	        ps.setInt(3, id);

	        int row = ps.executeUpdate();

	        if (row > 0) {
	            System.out.println("Doctor updated successfully.");
	        } else {
	            System.out.println("Doctor ID not found.");
	        }

	        ps.close();
	        conn.close();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void deleteDoctor() {
		System.out.println("Enter Doctor's Id to delete");
		int id = sc.nextInt();
		
		String sql = "UPDATE doctors SET status ='Inactive' WHERE doc_id = ?";
		
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			int row = ps.executeUpdate();
			if(row>0) {
				System.out.println("Doctor deleted successfully");
			}else {
				System.out.println("Id not found.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
