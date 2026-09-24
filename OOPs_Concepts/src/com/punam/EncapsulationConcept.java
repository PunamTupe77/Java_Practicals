package com.punam;

class Account{
	private String name;
	private String email;
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
public class EncapsulationConcept {

	public static void main(String[] args) {
		
     Account a = new Account();
     a.setName("punam");
     a.setEmail("tupepunam177@gmail.com");
     System.out.println("Name is : "+a.getName());
     System.out.println("Email is : "+a.getEmail());
	}

}
