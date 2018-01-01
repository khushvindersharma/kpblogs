package com.kpblogs.fileupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kpblogs.fileupload.service.FileUploadService;

@RestController
@RequestMapping("/api")
public class FileUploadController {

	@Autowired
	FileUploadService fileUploadService;
	
	@PostMapping("/fileUpload")
    public String fileUpload(@RequestParam("uploadfile") MultipartFile file) throws Exception {
    	try {
    		fileUploadService.store(file);
			return "File " + file.getName()+" uploaded successfully!!";
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
    }
    
}
