package com.subhajit.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConnectionTimeoutController {

	@GetMapping("/con-timeout")
	public ResponseEntity<String> testConTimeout(){
		System.out.println("In testConTimeout");
		try {
			Thread.sleep(50000);
		}catch(Exception e) {}
		return new ResponseEntity("Con time out not successful!!", HttpStatus.OK);
	}
}
