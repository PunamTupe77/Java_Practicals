package com.punam;

interface A{
   void makeSound();
}

interface B{
	 void sleep();
}
class Cat implements A,B{
	@Override
	public void sleep() {
		System.out.println("Sleeping");
		
	}

	@Override
	public void makeSound() {
		System.out.println("Meow Meow");
	}
	
}

public class InterfaceExample {
  public static void main(String[] args) {
	 Cat myCat = new Cat();
	 myCat.makeSound();
	 myCat.sleep();
 }
}
