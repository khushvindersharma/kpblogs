package com.kpblogs.solid_design_principles.ocp;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		
		ViewType pdfType = new PDFViewer();
		
		ViewType pngType = new PNGViewer();
		
		FileViewer viewer = new FileViewer();
		
		viewer.openingFileViewer(pdfType);
		
		viewer.openingFileViewer(pngType);
	}
}
