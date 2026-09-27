package com.hospital;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Appointment {

	Scanner sc = new Scanner(System.in);
	
	public void bookAppointment() {
		
		System.out.println("Enter patient Id: ");
		int patientId = sc.nextInt();
		
		System.out.println("Enter doctor ID: ");
		int doctorId = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
        String date = sc.nextLine();
        if(checkDoctorAvailability(doctorId, date)) {
        String sql = "INSERT INTO appointments(patient_id, doc_id, appointment_date)VALUES (?, ?, ?)";
        
        
        try(Connection conn = DBConnection.getConnection();
        		PreparedStatement ps = conn.prepareStatement(sql)){
        	
        	ps.setInt(1, patientId);
        	ps.setInt(2, doctorId);
        	ps.setDate(3, Date.valueOf(date));
        	
        	int row = ps.executeUpdate();
        	
        	if(row>0) {
        		System.out.println("Appointment booked successfully.");
        	}
        	
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }else {
			System.out.println("Doctor is not available on this date.");
		}
        
	}
	
	private boolean checkDoctorAvailability(int doctorId, String date) {

	    String sql = "SELECT COUNT(*) FROM appointments WHERE doc_id = ? AND appointment_date = ?";

	    try {
	        Connection conn = DBConnection.getConnection();
	        PreparedStatement ps = conn.prepareStatement(sql);

	        ps.setInt(1, doctorId);
	        ps.setDate(2, Date.valueOf(date));

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            int count = rs.getInt(1);

	            if (count == 0) {
	                return true;  // Doctor is available
	            } else {
	                return false; // Doctor is not available
	            }
	        }

	        conn.close();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return false;
	}

	public void viewAppointment() {
		String sql = "SELECT * FROM appointments";
		
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			System.out.println("Appointment List");
			while(rs.next()) {
				System.out.println("ID: "+rs.getInt("id")+ " | PatientID: "+rs.getInt("patient_id")+ " | DoctorID: "
			                        +rs.getInt("doc_id")+ " | AppointmentDate: "+rs.getDate("appointment_date"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
