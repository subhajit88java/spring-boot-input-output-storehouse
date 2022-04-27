package com.subhajit.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subhajit.models.MiniModel;

@RestController
public class ResponseTestController {

	@PostMapping(value="test", produces="application/json")
	public ResponseEntity<MiniModel> testMethod(){
		System.out.println("Hit");
		MiniModel model = new MiniModel();
		model.setId(1);
		model.setName("Subhajit");
		return new ResponseEntity<MiniModel>(model, HttpStatus.valueOf(301));
	}
}
