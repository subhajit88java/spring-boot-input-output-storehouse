package com.subhajit.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.subhajit.models.ListWrapperClass;
import com.subhajit.models.SuperModel;
import com.subhajit.utilities.CreateSuperModel;

//This is all-input-taking technique(related to spring framework) controller

@RestController
public class AllInputsController {

	/*
	 * Hit with : id = 1 name = Subhajit, 
	 * POST --> http://localhost:10000/spring-boot-input-output-storehouse/spring-form-urlencoded
	 * Both are mandatory
	 * If any one of them is not provided then exception will be thrown with 400(Bad Request) as ResponseCode
	 * Key names should be strictly id and name
	 * @RequestParam is implicitly used (if not mentioned explicitly)
	 */	
	@PostMapping("/spring-form-urlencoded")
	public ResponseEntity<String> springFormUrlencoded(Integer id, String name) {
		System.out.println("in spring-form-urlencoded");
		return new ResponseEntity("spring-form-urlencoded : " + id + " - " + name,HttpStatus.OK);
	}
	
	/*
	 * GET --> http://localhost:10000/spring-boot-input-output-storehouse/spring-querystring?id=1&name=Subhajit
	 * Both are mandatory
	 * If any one of them is not provided then exception will be thrown with 400(Bad Request) as ResponseCode
	 * Key names should be strictly id and name
	 */	
	@GetMapping("/spring-querystring")
	public ResponseEntity<String> springQuerystring(@RequestParam("id") Integer id, @RequestParam("name") String name, HttpServletRequest request) {
		System.out.println("spring-querystring");
		return new ResponseEntity("spring-querystring :: " + id + " - " + name,HttpStatus.OK);
	}
	
	/*
	 * GET --> http://localhost:10000/spring-boot-input-output-storehouse/spring-pathparam/1/Subhajit
	 * Both are mandatory, no key names required, only values required
	 * If any one of them is not provided then exception will be thrown with 404(Not Found) as ResponseCode
	 */
	@GetMapping("/spring-pathparam/{id}/{name}")
	public ResponseEntity<String> springPathparam(@PathVariable("id") Integer id, @PathVariable("name") String name) {
		System.out.println("spring-pathparam");
		return new ResponseEntity("spring-pathparam : " + id + " - " + name,HttpStatus.OK);
	}
	
	/*
	 * GET --> http://localhost:10000/spring-boot-input-output-storehouse/spring-matrixparam/data;id=1;name=Subhajit
	 * Both id and name are mandatory
	 * If any one of them is not provided then exception will be thrown with 400(Bad Request) as ResponseCode
	 * Key names should be strictly id and name
	 */	
	@GetMapping("/spring-matrixparam/{data}")
	public ResponseEntity<String> springMatrixparam(@MatrixVariable("id") Integer id, @MatrixVariable("name") String name) {
		System.out.println("spring-matrixparam");
		return new ResponseEntity("spring-matrixparam : " + id + " - " + name, HttpStatus.OK);
	}
	
	/*
	 * POST --> http://localhost:10000/spring-boot-input-output-storehouse/spring-json
	 * Hit with JSON format of SuperModel object
	 * If JSON body is not provided then exception will be thrown with 415(unsupported Media Type) as ResponseCode
	 * If some fields are missing from JSON body and its a valid JSON, then the JSON will be absorbed but the missing fields will be assigned as null
	 */	
	@PostMapping(value = "/spring-json", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuperModel> springJSON(@RequestBody SuperModel superModel) {
		System.out.println("spring-JSON");
		return new ResponseEntity(superModel,HttpStatus.OK);
	}
	
	/*
	 * POST --> http://localhost:10000/spring-boot-input-output-storehouse/spring-XML
	 * Hit with JSON format of SuperModel object
	 * If XML body is not provided then exception will be thrown with 415(unsupported Media Type) as ResponseCode
	 * If some fields are missing from JSON body and its a valid XML, then the XML will be absorbed but the missing fields will be assigned as null
	 */	
	@PostMapping(value = "/spring-XML", consumes=MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<SuperModel> springXML(@RequestBody SuperModel superModel) {
		System.out.println("spring-XML");
		return new ResponseEntity(superModel,HttpStatus.OK);
	}
		
	/*
	 * POST --> http://localhost:10000/spring-boot-input-output-storehouse/list-of-supermodel
	 * Hit with JSON format of SuperModel object, if no consumer and producer are mentioned explicitly, JSON format wil be the default one
	 * If JSON body is not provided then exception will be thrown with 415(unsupported Media Type) as ResponseCode
	 * If some fields are missing from JSON body and its a valid JSON, then the JSON will be absorbed but the missing fields will be assigned as null
	 */	
	@PostMapping(value = "/list-of-supermodel", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SuperModel>> listOfSuperModels(@RequestBody List<SuperModel> superModelList) {
		System.out.println("list-of-supermodel");
		return new ResponseEntity(superModelList, HttpStatus.OK);
	}
	
	/*
	 * POST --> http://localhost:10000/spring-boot-input-output-storehouse/map-of-supermodel
	 * Hit with JSON format of SuperModel object, if no consumer and producer are mentioned explicitly, JSON format wil be the default one
	 * If JSON body is not provided then exception will be thrown with 415(unsupported Media Type) as ResponseCode
	 * If some fields are missing from JSON body and its a valid JSON, then the JSON will be absorbed but the missing fields will be assigned as null
	 */	
	@PostMapping(value = "/map-of-supermodel", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String,SuperModel>> mapOfColleges(@RequestBody Map<String,SuperModel> superModelMap) {
		System.out.println("map-of-supermodel");
		return new ResponseEntity(superModelMap,HttpStatus.OK);
	}
	
	
}
