package com.punam;

class Student{
	String name;
	int age;
	
	public void printInfo() {
		System.out.println(name);
		System.out.println(age);
    }
}

public class OOPS {

	public static void main(String[] args) {
		
       Student s1 = new Student();
       s1.name = "punam";
       s1.age = 24;
       s1.printInfo();
	}

}
