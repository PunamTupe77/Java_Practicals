package com.punam;

abstract class Vehical{
	public abstract void startEngine();
	
	public void turnOnLight() {
		System.out.println("Lights ON.");
	}
}

class WagonR extends Vehical{

	@Override
	public void startEngine() {
		System.out.println("Engine is started.....");
	}
	
	public void turnOffLight() {
		System.out.println("Lights OFF.");
	}
	
	
}
public class AbstractionDemo {

	public static void main(String[] args) {
		WagonR w = new WagonR();
		w.startEngine();
		w.turnOnLight();
		w.turnOffLight();
	}

}
