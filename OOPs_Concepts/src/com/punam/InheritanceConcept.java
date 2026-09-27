package com.punam;


class Animal{
	public void sound() {
		System.out.println("every animal has different sounds");
	}
	
	public void eat() {
		System.out.println("This animal is eating food.");
	}
}

class Dog extends Animal{
	public void sound() {
		System.out.println("Barking.....");
	}
}
public class InheritanceConcept {

	public static void main(String[] args) {
		Dog d1 = new Dog();
		d1.sound();
		
		d1.eat();

	}

}
