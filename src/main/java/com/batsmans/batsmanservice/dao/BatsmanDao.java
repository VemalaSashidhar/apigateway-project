package com.batsmans.batsmanservice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.batsmans.batsmanservice.entities.Batsmen;
@Component
public class BatsmanDao {
	
	private Logger logger = LoggerFactory.getLogger(BatsmanDao.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Batsmen> getAllBatamen() {
		
		String query = "SELECT * FROM BATSMEN ORDER BY COUNTRY";
		
		List<Batsmen> list = jdbcTemplate.query(query, new RowMapper<Batsmen>() {
			
			public Batsmen mapRow(ResultSet rs, int rowNum)throws SQLException{
				
				Batsmen b = new Batsmen();
				
				b.setBatsmanId(rs.getInt("BATSMAN_ID"));
				b.setName(rs.getString("NAME"));
				b.setCountry(rs.getString("COUNTRY"));
				b.setRuns(rs.getInt("RUNS"));
				
				return b;
			}
		});
		
		return list;
		
	}
	
	public List<Batsmen> getBatsmenOnCountry(String country){
		
		String query = "SELECT * FROM BATSMEN WHERE COUNTRY=?";
		
		List<Batsmen> list = jdbcTemplate.query(query, new Object[] {country},new RowMapper<Batsmen>() {
			
			public Batsmen mapRow(ResultSet rs,int rowNum)throws SQLException{
				
				Batsmen bat = new Batsmen();
				
				bat.setBatsmanId(rs.getInt("batsman_id"));
				bat.setName(rs.getString("NAME"));
				bat.setCountry(rs.getString("COUNTRY"));
				bat.setRuns(rs.getInt("RUNS"));
				
				return bat;
			}
		});
		return list;
	}

}
