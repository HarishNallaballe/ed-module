package com.ed.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ed.entity.Eligibility;

public interface EDRepo extends JpaRepository<Eligibility, Integer>{
	
	public Eligibility findByAppNumber(Integer appNumber);

}
