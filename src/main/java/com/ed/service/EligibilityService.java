package com.ed.service;

import java.util.List;

import com.ed.dto.EligibilityDto;
import com.ed.entity.Eligibility;

public interface EligibilityService {
	
	public String checkEligibility(Integer appNumber);
	
	public List<EligibilityDto> getEligibilityDetails();
	
	public Eligibility getByAppNumber(Integer appNumber);

}
