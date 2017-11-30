package com.kpblogs.solid_design_principles.lsp;

public class WireLessPhone extends Phone{
	
	//added new feature
	boolean isRangeAvailable() {
		return true;
	}
	
	
	@Override
	void ringing() {
		// TODO Auto-generated method stub
		super.ringing();
	}
	
	@Override
	void dialingNumber() {
		// TODO Auto-generated method stub
		super.dialingNumber();
	}

}
