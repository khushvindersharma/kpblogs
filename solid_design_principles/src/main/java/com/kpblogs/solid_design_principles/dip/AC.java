package com.kpblogs.solid_design_principles.dip;

public class AC implements Switchable{

	public void turnOn() {
		System.out.println("AC On");
	}

	public void turnOff() {
		System.out.println("AC Off");
	}

}
