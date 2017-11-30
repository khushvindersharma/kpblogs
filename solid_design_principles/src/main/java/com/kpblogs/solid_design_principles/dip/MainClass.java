package com.kpblogs.solid_design_principles.dip;

public class MainClass {

	public static void main(String[] args) {
		Switchable switchableMotor = new Motor();
		
		Switchable switchableAC = new AC();
		
		PowerSwitch  powerSwitch = new PowerSwitch(switchableAC);
		
		powerSwitch.press();
		
		PowerSwitch  powerSwitchForMotor = new PowerSwitch(switchableMotor);
		
		powerSwitchForMotor.press();

	}

}
