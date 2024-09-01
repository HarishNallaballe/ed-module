package com.ed.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ed.dto.EligibilityDto;
import com.ed.entity.Eligibility;
import com.ed.service.EligibilityService;

import jakarta.ws.rs.Path;

@RestController
public class EligibilityController {
	
	@Autowired
	private EligibilityService eliService;
	
	@PostMapping("/eligibility/{appNumber}")
	public ResponseEntity<String> checkEligibility(@PathVariable Integer appNumber){
		String eligibility = eliService.checkEligibility(appNumber);
		return new ResponseEntity<String>(eligibility,HttpStatus.OK);
	}
	
	@GetMapping("eligibility")
	public ResponseEntity<List<EligibilityDto>> getElibilityDetais(){
		List<EligibilityDto> eligibility = eliService.getEligibilityDetails();
		return new ResponseEntity<List<EligibilityDto>>(eligibility,HttpStatus.OK);
	}
	
	@GetMapping("/eligibility/appNumber/{appNumber}")
	public ResponseEntity<Eligibility> getEligibilityByAppNumber(@PathVariable Integer appNumber){
		Eligibility eligibility = eliService.getByAppNumber(appNumber);
		return new ResponseEntity<Eligibility>(eligibility,HttpStatus.OK);
	}
	
	

}
