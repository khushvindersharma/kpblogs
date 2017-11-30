package com.kpblogs.solid_design_principles.isp;

interface Phone{
	void dialingNumber();
	void ringing();
	
}

interface WiredPhone extends Phone{
	boolean isWireOk();
	
}

interface WireLessPhone extends Phone{
	boolean isRangeAvailable();
}

/**
 * 
 *Now if we are working with Wireless device then implement WirelessPhone Interface else for Wired us
 *WiredPhone interface
 *
 */
class Mobile implements WireLessPhone{

	public void dialingNumber() {
		// TODO Auto-generated method stub
	}

	public void ringing() {
		// TODO Auto-generated method stub
	}

	public boolean isRangeAvailable() {
		// TODO Auto-generated method stub
		return false;
	}
}

public class MainMobile extends Mobile {

	public static void main(String[] args) {
		System.out.println("Checking mobile range : "+new MainMobile().isRangeAvailable());

	}

}
