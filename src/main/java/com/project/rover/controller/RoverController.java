package com.project.rover.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.rover.exception.RoverException;
import com.project.rover.objects.DirectionObject;
import com.project.rover.objects.Environment;
import com.project.rover.objects.RoverConfig;
import com.project.rover.service.RoverService;

@RestController
@RequestMapping(value = "api")
public class RoverController {
	
	@Autowired
	private RoverService roverService;
	
	@PostMapping(value = "/environment/configure")
	public ResponseEntity<Object> configureEnvironment(@RequestBody Environment environment) {
		roverService.configureEnvironment(environment);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PatchMapping(value = "/environment")
	public ResponseEntity updateEnvironment(@RequestBody Map<String, Object> property) {
		ResponseEntity responseEntity = null;
		try {
			responseEntity = new ResponseEntity<>(roverService.modifyEnvironment(property), HttpStatus.OK);
		} catch (RoverException e) {
			Map<String, String> body = new HashMap<>(); body.put("message", e.getErrorMsg());
			responseEntity = new ResponseEntity(body,HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	
	
	@PostMapping(value="/rover/configure")
	public ResponseEntity roverConfigure(@RequestBody RoverConfig roverConfig) {
		roverService.configureRover(roverConfig);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping(value="/rover/move")
	public ResponseEntity roverMove(@RequestBody DirectionObject object) {
		ResponseEntity responseEntity = null;
		try {
			responseEntity = new ResponseEntity(roverService.moveRover(object),HttpStatus.OK);
		} catch (RoverException e) {
			Map<String, String> body = new HashMap<>(); body.put("message", e.getErrorMsg());
			responseEntity = new ResponseEntity(body,HttpStatus.PRECONDITION_REQUIRED);
		}
		return responseEntity;
	}
	
	@GetMapping(value="/rover/status")
	public ResponseEntity roverStatus() {
		return new ResponseEntity(roverService.roverStatus(), HttpStatus.OK);
	}
}
