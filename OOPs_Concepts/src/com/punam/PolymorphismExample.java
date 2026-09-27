package com.punam;

class Car{
	String name;
	int age;
	
	public void printInfo() {
		System.out.println(age);
	}
	
	public void printInfo(String name) {
		System.out.println(name);
	}
	
	public void printInfo(String name,int age) {
		System.out.println(name+ " "+age);
	}
}

public class PolymorphismExample {

	public static void main(String[] args) {

		Car c = new Car();
		c.name = "Thar";
		c.age = 5;
		
         c.printInfo();
         c.printInfo(c.name);
         c.printInfo(c.name, c.age);
         
	}

}
