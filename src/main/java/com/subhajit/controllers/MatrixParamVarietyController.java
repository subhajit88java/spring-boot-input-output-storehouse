 package com.subhajit.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatrixParamVarietyController {


	/*
	 * GET --> http://localhost:10000/spring-boot-input-output-storehouse/spring-matrixparam-one/examples;id=1;name=Subhajit
	 * Both id and name are mandatory
	 * If any one of them is not provided then exception will be thrown with 400(Bad Request) as ResponseCode
	 * Key names should be strictly id and name
	 */	
	@GetMapping("/spring-matrixparam-one/{examples}")
	public ResponseEntity<String> springMatrixparamOne(@MatrixVariable("id") Integer id, @MatrixVariable("name") String name) {
		System.out.println("springMatrixparamOne");
		return new ResponseEntity("springMatrixparam " + id +" - "+ name,HttpStatus.OK);
	}
	
	/*
	 * GET --> http://localhost:10000/spring-boot-input-output-storehouse/spring-matrixparam-two/examples;id=1;name=Subhajit;college=HITK;city=Durgapur
	 * No one is mandatory in case of Map
	 * Key names can be anything
	 */	
	@GetMapping("/spring-matrixparam-two/{examples}")
	public ResponseEntity<Map> springMatrixparamTwo(@MatrixVariable(pathVar = "examples") Map<String, String> examples) {
		System.out.println("springMatrixparamTwo : " + examples);
		return new ResponseEntity(examples,HttpStatus.OK);
	}
	
	/*
	 * GET --> http://localhost:10000/spring-boot-input-output-storehouse/spring-matrixparam-three/examples;id=1,2,3;name=Subhajit,Pallobi,Santosh;college=HITK,Women's College,BIT;city=Durgapur,Durgapur,Durgapur
	 * No one is mandatory in case of Map
	 * Key names can be anything
	 */	
	@GetMapping("/spring-matrixparam-three/{examples}")
	public ResponseEntity<Map<String, List<String>>> springMatrixparamThree(@MatrixVariable(pathVar = "examples") Map<String, List<String>> examples) {
		System.out.println("springMatrixparamThree : " + examples);
		return new ResponseEntity(examples,HttpStatus.OK);
	}
	
	/*
	 * GET --> http://localhost:10000/spring-boot-input-output-storehouse/spring-matrixparam-four/example1;id=1;name=Subhajit/example2;college=HITK;city=Durgapur
	 * No one is mandatory in case of Map
	 * Key names can be anything
	 * example1 placeholder will populate the values of Map example1
	 * example2 placeholder will populate the values of Map example2
	 */	
	@GetMapping("/spring-matrixparam-four/{example1}/{example2}")
	public ResponseEntity<List<Map<String, String> >> springMatrixparamFour(@MatrixVariable(pathVar = "example1") Map<String, String> example1, @MatrixVariable(pathVar = "example2") Map<String, String> example2) {
		System.out.println("springMatrixparamFour : " + example1+ " - "+example2);
		List<Map<String, String> > finalList = new ArrayList<>();
		finalList.add(example1);
		finalList.add(example2);
		return new ResponseEntity(finalList,HttpStatus.OK);
	}
	
}

//This Controller details all the features of Matrix-param, different input taking techniques of Matrix-param