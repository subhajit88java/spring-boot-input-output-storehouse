package com.subhajit.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.subhajit.models.MiniModel;

@RestController
public class RequestParamVarietyController {

	/*
	 * Hit with : id = 1 name = Subhajit, 
	 * POST --> http://localhost:10000/spring-boot-input-output-storehouse/request-param-with-diff-name
	 * Both are mandatory
	 * If any one of them is not provided then exception will be thrown with 400(Bad Request) as ResponseCode
	 * Key names should be strictly id and name
	 * RequestParam variables differ, id Dummy for id and nameDummy for name
	 */		
	@PostMapping("/request-param-with-diff-name")
	public ResponseEntity<String> requestParamWithDiffNames(@RequestParam("id") String idDummy, @RequestParam("name") String nameDummy) {
		System.out.println("in requestParamWithDiffNames");
		return new ResponseEntity("requestParamWithDiffNames: " + idDummy + " - " + nameDummy,HttpStatus.OK);
	}
	
	/*
	 * Hit with : id = 1 name = Subhajit, 
	 * POST --> http://localhost:10000/spring-boot-input-output-storehouse/request-param-with-same-name
	 * Both are mandatory
	 * If any one of them is not provided then exception will be thrown with 400(Bad Request) as ResponseCode
	 * Key names should be strictly id and name
	 */	
	@PostMapping("/request-param-with-same-name")
	public ResponseEntity<String> requestParamWithSameNames(@RequestParam String id, @RequestParam String name) {
		System.out.println("in requestParamWithSameNames");
		return new ResponseEntity("requestParamWithSameNames: " + id + " - " + name,HttpStatus.OK);
	}
	
	/*
	 * Hit with : id = 1 name = Subhajit, 
	 * POST --> http://localhost:10000/spring-boot-input-output-storehouse/request-param-mandatory-value
	 * Only id is mandatory
	 * If id is not provided then exception will be thrown with 400(Bad Request) as ResponseCode
	 * Key names should be strictly id and name
	 * If name is not provided null is assigned to RequestParam variable name 
	 */	
	@PostMapping("/request-param-mandatory-value")
	public ResponseEntity<String> requestParamMandatoryValue(@RequestParam String id, @RequestParam(required=false) String name) {
		System.out.println("in requestParamMandatoryValue");
		return new ResponseEntity("requestParamMandatoryValue: " + id + " - " + name,HttpStatus.OK);
	}
	
	/*
	 * Hit with : id = 1 name = Subhajit, 
	 * POST --> http://localhost:10000/spring-boot-input-output-storehouse/request-param-default-value
	 * Only id is mandatory
	 * If id is not provided then exception will be thrown with 400(Bad Request) as ResponseCode
	 * Key names should be strictly id and name
	 * If name is not provided "Pallobi" is assigned as default value to RequestParam variable name 
	 */	
	@PostMapping("/request-param-default-value")
	public ResponseEntity<String> requestParamDefaultValue(@RequestParam String id, @RequestParam(required=false, defaultValue ="Pallobi") String name) {
		System.out.println("in requestParamDefaultValue");
		return new ResponseEntity("requestParamDefaultValue: " + id + " - " + name,HttpStatus.OK);
	}
	

	/*
	 * Hit with : id = 1 name = Subhajit, 
	 * POST --> http://localhost:10000/spring-boot-input-output-storehouse/request-param-with-all-attributes
	 * Only id is mandatory
	 * If id is not provided then exception will be thrown with 400(Bad Request) as ResponseCode
	 * Key names should be strictly id and name
	 * RequestParam variable differs, nameDummy for name
	 * If name is not provided "Pallobi" is assigned as default value to RequestParam variable name 
	 */	
	@PostMapping("/request-param-with-all-attributes")
	public ResponseEntity<String> requestParamWithAllAttributes(@RequestParam String id, @RequestParam(value="name", required=false, defaultValue ="Pallobi") String nameDummy) {
		System.out.println("in requestParamWithAllAttributes");
		return new ResponseEntity("requestParamWithAllAttributes: " + id + " - " + nameDummy,HttpStatus.OK);
	}
	
	/*
	 * Hit with : nameList = Subhajit, nameList = Pallobi, nameList = Asim, nameList = Suman, nameList = Ram
	 * POST --> http://localhost:10000/spring-boot-input-output-storehouse/request-param-multi-values-mandatory
	 * nameList is mandatory
	 * If nameList is not provided then exception will be thrown with 400(Bad Request) as ResponseCode
	 * Key name should be nameList
	 */	
	@PostMapping("/request-param-multi-values-mandatory")
	public ResponseEntity<String> requestParamMultiValuesMandatory(@RequestParam List<String> nameList) {
		System.out.println("in requestParamMultiValuesMandatory");
		return new ResponseEntity("requestParamMultiValuesMandatory: " + nameList,HttpStatus.OK);
	}
	
	/*
	 * Hit with : nameList = Subhajit, nameList = Pallobi, nameList = Asim, nameList = Suman, nameList = Ram
	 * POST --> http://localhost:10000/spring-boot-input-output-storehouse/request-param-multi-values-default
	 * nameList is optional
	 * If nameList is not provided then "Subhajit, Pallobi, Santosh" will be implicitely converted to List<String>, this depends on the "referenced by datatype", 
	 * if datatype is List<String> then "Subhajit, Pallobi, Santosh" wil be converted to List
	 * if datatype is String then "Subhajit, Pallobi, Santosh" will be regarded as single string
	 * Key name should be nameList
	 */	
	@PostMapping("/request-param-multi-values-default")
	public ResponseEntity<String> requestParamMultiValuesDefault(@RequestParam(required=false,  defaultValue ="Subhajit, Pallobi, Santosh") List<String> nameList) {
		System.out.println("in requestParamMultiValuesDefault");
		return new ResponseEntity("requestParamMultiValuesDefault: " + nameList,HttpStatus.OK);
	}
	
}

//This Controller details all the features of @RequestParam, its different attributes(value, required, defaultValue)
