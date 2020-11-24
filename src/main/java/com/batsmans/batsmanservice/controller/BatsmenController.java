package com.batsmans.batsmanservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.batsmans.batsmanservice.entities.Batsmen;
import com.batsmans.batsmanservice.service.BatsmenService;

@RestController
public class BatsmenController {

	@Autowired
	BatsmenService service;
	
	@GetMapping("/getAllBatsmen")
	public ResponseEntity<List<Batsmen>> getBatsmen(){
	
		List<Batsmen> list = service.getAll();
		if(list.size() == 0) {
			
			return new ResponseEntity<List<Batsmen>>(HttpStatus.NOT_FOUND);
		}
		list.stream().forEach(a ->System.out.println(a.getName()+" : "+a.getCountry()+" : "+a.getRuns()));
		
		return new ResponseEntity<List<Batsmen>>(list,HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllBatsmen/{country}")
	public ResponseEntity<List<Batsmen>> getBatsmenByCountry(@PathVariable("country")String country){
	
		List<Batsmen> list = service.getAllByCountry(country);
		if(list.size() == 0) {
			
			return new ResponseEntity<List<Batsmen>>(HttpStatus.NOT_FOUND);
		}
		list.stream().forEach(a ->System.out.println(a.getName()+" : "+a.getCountry()+" : "+a.getRuns()));
		
		return new ResponseEntity<List<Batsmen>>(list,HttpStatus.OK);
		
	}
}
