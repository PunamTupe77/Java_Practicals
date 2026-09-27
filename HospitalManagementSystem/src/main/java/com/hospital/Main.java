package com.hospital;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Doctors doctors = new Doctors();
        Patients patients = new Patients();
        Appointment appointment = new Appointment();

        int choice = 0;

        do {
            System.out.println("============Hospital Management System==============");
            System.out.println("1. Add Doctor");
            System.out.println("2. View Doctor");
            System.out.println("3. Update Doctor");
            System.out.println("4. Delete Doctor");
            System.out.println("5. Add Patient");
            System.out.println("6. View Patient");
            System.out.println("7. Update Patient");
            System.out.println("8. Delete Patient");
            System.out.println("9. Book Appointment");
            System.out.println("10. View All Appointments");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        doctors.addDoctor();
                        break;

                    case 2:
                        doctors.viewDoctor();
                        break;

                    case 3:
                        doctors.updateDoctor();
                        break;
                        
                    case 4:
                        doctors.deleteDoctor();
                        break;

                    case 5:
                        patients.addPatient();
                        break;

                    case 6:
                        patients.viewPatient();
                        break;
                        
                    case 7:
                        patients.updatePatient();
                        break;
                        
                    case 8:
                        patients.deletePatient();
                        break;

                    case 9:
                        appointment.bookAppointment();
                        break;
                        
                    case 10:
                        appointment.viewAppointment();
                        break;

                    case 0:
                        System.out.println("Thank you for using Hospital Management System!");
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                sc.nextLine();
            }

        } while (choice != 0);

        sc.close();
    }
}