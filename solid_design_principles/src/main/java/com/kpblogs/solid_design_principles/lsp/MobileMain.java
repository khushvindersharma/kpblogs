package com.kpblogs.solid_design_principles.lsp;

public class MobileMain extends WireLessPhone{

	public static void main(String[] args) {
		System.out.println("Check if range is available or not ? :"+ new MobileMain().isRangeAvailable());
	}
	
	@Override
	boolean isRangeAvailable() {
		// TODO Auto-generated method stub
		return super.isRangeAvailable();
	}

}
