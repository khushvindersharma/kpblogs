package com.kpblogs.fileupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FileUploadPageController {
	
	@GetMapping("/fileUploadPage")
	public String fileUploadPage() {
		
		return "fileUploadForm";
	
	}
}
