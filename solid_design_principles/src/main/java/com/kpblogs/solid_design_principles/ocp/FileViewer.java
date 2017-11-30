package com.kpblogs.solid_design_principles.ocp;

public class FileViewer {

	public void openingFileViewer(ViewType type){
		type.openFile();
	}
	
}

