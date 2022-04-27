package com.subhajit.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subhajit.models.SuperModel;
import com.subhajit.utilities.CreateSuperModel;

@RestController
public class ResponseEntityAnalysisController {

	@GetMapping(value = "/test-reponseentity-single_object_body-and-status", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuperModel> singleObjectBodyAndStatus() {
		ResponseEntity<SuperModel> responseEntity = new ResponseEntity<>(CreateSuperModel.getSuperModel(), HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(value = "/test-reponseentity-list_object_body-and-status", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SuperModel>> listObjectBodyAndStatus() {
		ResponseEntity<List<SuperModel>> responseEntity = new ResponseEntity<>(CreateSuperModel.getSuperModelList(), HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(value = "/test-reponseentity-map_object_body-and-status", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String,SuperModel>> mapObjectBodyAndStatus() {
		ResponseEntity<Map<String,SuperModel>> responseEntity = new ResponseEntity<>(CreateSuperModel.getSuperModelMap(), HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(value = "/test-reponseentity-string_body-and-status")
	public ResponseEntity<String> stringBodyAndStatus() {
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Success!!!", HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(value="/test-reponseentity-single_object_body-and-status-xml", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<SuperModel> singleObjectBodyAndStatusAsXML() {
		ResponseEntity<SuperModel> responseEntity = new ResponseEntity<>(CreateSuperModel.getSuperModel(), HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(value="/test-reponseentity-list_object_body-and-status-xml", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<List<SuperModel>> listObjectBodyAndStatusAsXML() {
		ResponseEntity<List<SuperModel>> responseEntity = new ResponseEntity<>(CreateSuperModel.getSuperModelList(), HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(value="/test-reponseentity-map_object_body-and-status-xml", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Map<String,SuperModel>> mapObjectBodyAndStatusXML() {
		ResponseEntity<Map<String,SuperModel>> responseEntity = new ResponseEntity<>(CreateSuperModel.getSuperModelMap(), HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(value="/test-reponseentity-string_body-and-status-xml", produces = MediaType.ALL_VALUE)
	public ResponseEntity<String> stringBodyAndStatusXML() {
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Success!!!", HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/test-reponseentity-single_object_body-header-status")
	public ResponseEntity<SuperModel> singleObjectBodyHeaderAndStatus() {
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("customize-header-1", "Subhajit");
		headers.add("customize-header-2", "Pallobi");
		
		ResponseEntity<SuperModel> responseEntity = new ResponseEntity<>(CreateSuperModel.getSuperModel(), headers, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/test-single_object_body-only")
	public SuperModel singleObjectBodyOnly() {
		return CreateSuperModel.getSuperModel();
	}
	
	@GetMapping(value="/test-single_object_body-only-xml", produces = MediaType.APPLICATION_XML_VALUE)
	public SuperModel singleObjectBodyOnlyXML() {
		return CreateSuperModel.getSuperModel();
	}
	
	@GetMapping(value="/test-string_body-only-xml")
	public String stringObjectBodyOnlyXML() {
		return "Success!!!";
	}
	
	@GetMapping(value="/test-file-download-hardcode-filepath")
	public ResponseEntity<Resource> testFileDownloadHardcodeFilepath() throws MalformedURLException {
		
		 Path filePath = Paths.get("D:\\Image\\test.jpg").toAbsolutePath().normalize();
		 Resource resource = new UrlResource(filePath.toUri());
		 
		 MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		 headers.add(HttpHeaders.CONTENT_TYPE, "image/jpg");
		 headers.add(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + resource.getFilename() + "\"");
		 ResponseEntity<Resource> responseEntity = new ResponseEntity<>(resource,headers,HttpStatus.OK);
		 return responseEntity;
	}
	
	@GetMapping(value="/test-file-download-inputstream")
	public ResponseEntity<Resource> testFileDownloadInputstream() throws MalformedURLException, FileNotFoundException {
		
		InputStream is = new FileInputStream(new File("D:\\Image\\test.jpg"));
		InputStreamResource resource = new InputStreamResource(is);
		System.out.println(resource.getFilename());
		 
		 MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		 headers.add(HttpHeaders.CONTENT_TYPE, "image/jpg");
		 headers.add(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + "test1.jpg" + "\"");
		 ResponseEntity<Resource> responseEntity = new ResponseEntity<>(resource,headers,HttpStatus.OK);
		 return responseEntity;
	}
	
	@GetMapping(value="/test-file-download-bytearray")
	public ResponseEntity<byte[]> testFileDownloadByteArray() throws IOException {
		
		  BufferedImage bImage = ImageIO.read(new File("D:\\Image\\test.jpg"));
	      ByteArrayOutputStream bos = new ByteArrayOutputStream();
	      ImageIO.write(bImage, "jpg", bos );
	      byte [] data = bos.toByteArray();
		 
		 MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		 headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM.toString());
		 ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(data,headers,HttpStatus.OK);
		 return responseEntity;
	}
}

//This Controller details all the features of ResponseEntity, its approaches to render output
