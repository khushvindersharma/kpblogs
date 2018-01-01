package com.kpblogs.fileupload.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

	@Value("${fileupload-destination}")
	private String fileDestination;
	
	public void store(MultipartFile file){
		try {
			Path rootLocation = Paths.get(fileDestination);
            Files.copy(file.getInputStream(), rootLocation.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
        	throw new RuntimeException(e.getMessage());
        }
	}
 
	
}
