package com.java.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

@Controller
public class UploadController {
	@Autowired
	AmazonS3 s3Client;

	@PostMapping("/upload.do")
	public void fileUpload(@RequestParam MultipartFile file) {
		String bucketName = "revature1903";
		String key = UUID.randomUUID() + "";
		//InputStream is = file.getInputStream();
		//File newFile = new File(file);
		//System.out.println(file.getName());
		s3Client.putObject(new PutObjectRequest(bucketName, key, convert(file))
				.withCannedAcl(CannedAccessControlList.PublicRead));

		S3Object object = s3Client.getObject(new GetObjectRequest(bucketName, key));

		System.out.println(object.getObjectContent().getHttpRequest().getURI().toString());
	}

	@GetMapping("/file.do")
	public String getFilePage() {
		return "file";
	}
	
	public File convert(MultipartFile file) 
	{    
	    File convFile = new File(file.getOriginalFilename());
	    try {
			convFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(convFile); 
		    fos.write(file.getBytes());
		    fos.close(); 
		    return convFile;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    return null;
	}
}
