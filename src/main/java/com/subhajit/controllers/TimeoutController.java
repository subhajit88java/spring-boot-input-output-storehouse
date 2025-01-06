package com.subhajit.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
public class TimeoutController {

    @GetMapping("/read-timeout")
    public ResponseEntity<String> readTimeout(){
        System.out.println("Landed in producer : read-timeout");
        try{
            Thread.sleep(20000);
        }catch(Exception e){}

        return new ResponseEntity<>("no read timeout happened!", HttpStatus.OK);
    }

    @GetMapping("/connection-reset")
    public ResponseEntity<?> connectionReset(){
        System.out.println("Landed in producer : connection-reset");
        try{
            Thread.sleep(20000);
        }catch(Exception e){}

        return new ResponseEntity<>("no connection reset happened!", HttpStatus.OK);
    }

    @GetMapping("/connection-timeout")
    public ResponseEntity<?> connectionTimeout(){
        System.out.println("Landed in producer : connection-timeout");
        return new ResponseEntity<>("no connection reset happened!", HttpStatus.OK);
    }

}
