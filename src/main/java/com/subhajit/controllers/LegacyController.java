package com.subhajit.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.subhajit.models.SuperModel;
import com.subhajit.utilities.CreateSuperModel;

@Controller
public class LegacyController {

	@GetMapping("/test-single_object_body-legacy")
	public SuperModel singleObjectBodyOnly() {
		return CreateSuperModel.getSuperModel();
	}
	
	@GetMapping("/test-single_object_body-responsebody")
	@ResponseBody
	public SuperModel singleObjectBodyResponsebody() {
		return CreateSuperModel.getSuperModel();
	}
	
	@GetMapping("/test-single_object_body-responsebody-and-status")
	@ResponseBody
	//@ResponseStatus(value=HttpStatus.OK, reason="Perfect")
	@ResponseStatus(value=HttpStatus.OK)
	public SuperModel singleObjectBodyResponsebodyAndStatus() {
		return CreateSuperModel.getSuperModel();
	}
	
	@GetMapping("/test-single_object_body-error_responsebody-and-status")
	@ResponseBody
	public SuperModel singleObjectErrorResponsebodyAndStatus() throws CustomizedException {
		
			throw new CustomizedException("Invalid data");
		
	}
	
	@GetMapping(value = "/test-single_object_body-responsebody-xml", produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public SuperModel singleObjectBodyResponsebodyXML() {
		return CreateSuperModel.getSuperModel();
	}
	
	@GetMapping("/test-string_body-responsebody")
	@ResponseBody
	public String stringObjectBodyResponsebody() {
		return "Success!!";
	}
}

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Wrong data")
class CustomizedException extends Exception{
	
	public CustomizedException(String message) {
		super(message);
	}
}

/*
 * Legacy @Controller. 
 * If we use legacy controller then we have to use @ResponseBody if we want to avoid spring view-resolver. 
 * Additionally we have to use @ResponseStatus for sending status to the caller. 
 * So this Class is a combination of @Controller + @ResponseBody + @ResponseStatus
 */