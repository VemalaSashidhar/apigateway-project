package com.batsmans.batsmanservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batsmans.batsmanservice.dao.BatsmanDao;
import com.batsmans.batsmanservice.entities.Batsmen;

@Service
public class BatsmenService {
	
	@Autowired
	BatsmanDao dao;
	
	public List<Batsmen> getAll(){
		
		return dao.getAllBatamen();
	}
	
	public List<Batsmen> getAllByCountry(String country){
		
		return dao.getBatsmenOnCountry(country);
	}

}
