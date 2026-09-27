package com.hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Patients {
	
	Scanner sc = new Scanner(System.in);
	
	public void addPatient() {
		System.out.println("Enter Patient name: ");
		String name = sc.nextLine();
		
		System.out.println("Enter Patient age: ");
		int age = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter gender: ");
		String gender = sc.nextLine();
		
		String sql = "INSERT INTO patients (name, age, gender) VALUES (?, ?, ?)";
		
		try(Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, gender);
			
			int row = ps.executeUpdate();
			if(row>0) {
				System.out.println("Patient added successfully.");
			}
			else {
				System.out.println("Failed to add patient.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void viewPatient() {
		String sql = "SELECT * FROM patients WHERE status ='Active'";
		
		try(Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()){
			
			System.out.println("Patient List");
			while(rs.next()) {
				System.out.println("ID: "+rs.getInt("patient_id")+ " | Name: "+rs.getString("name")+ " | Age: "+ rs.getInt("age")+ " | Gender: "+rs.getString("gender"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updatePatient() {
		System.out.println("Enter Patient Id to update: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter Patient's new name: ");
		String name = sc.nextLine();
		
		System.out.println("Enter new Age: ");
		int age = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter Patient's gender: ");
		String gender = sc.nextLine();
		
		String sql = "UPDATE patients SET name = ?, age = ?, gender = ? WHERE patient_id = ?";
		
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, gender);
			ps.setInt(4, id);
			
			int row = ps.executeUpdate();
			if(row>0) {
				System.out.println("Patient details updated successfully.");
			}else {
				System.out.println("Patient id not found.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletePatient() {
		
		System.out.println("Enter patient's Id to delete record: ");
		int id = sc.nextInt();
		
		String sql ="UPDATE patients SET status = 'Inactive' WHERE patient_id = ?";
		 
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,id);
			int row = ps.executeUpdate();
			if(row > 0) {
				System.out.println("Patient deleted successfully.");
			}else {
				System.out.println("Patient id not found.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
