package com.ed.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ed.dto.EligibilityDto;
import com.ed.entity.Citizen;
import com.ed.entity.Eligibility;
import com.ed.entity.Kid;
import com.ed.feign.Citizenfeign;
import com.ed.feign.IncomeFeign;
import com.ed.feign.PlanFeign;
import com.ed.repo.EDRepo;

@Service
public class EligibilityServiceImpl implements EligibilityService{

	@Autowired
	private EDRepo edRepo;
	
	@Autowired
	private Citizenfeign citizenfeign;
	
	@Autowired
	private PlanFeign planFeign;
	
	@Autowired
	private IncomeFeign incomeFeign;
	
	@Override
	public String checkEligibility(Integer appNumber) {
		Eligibility eligibility = new Eligibility();
		Citizen citizen = citizenfeign.getCitizenByAppNumber(appNumber).getBody();
		Integer planId = citizen.getPlanId();
		String planName = planFeign.getPlanById(planId).getBody().getPlanName();
		Integer salaryIncome = incomeFeign.getIncomeByAppNumber(appNumber).getBody().getSalaryIncome();
		Integer propertyIncome = incomeFeign.getIncomeByAppNumber(appNumber).getBody().getPropertyIncome();
		long millis=System.currentTimeMillis();
		Date date=new Date(millis);
		
		eligibility.setPlanId(planId);
		eligibility.setBenfitAmt(300);
		eligibility.setAppNumber(appNumber);
		
		List<Kid> kids = incomeFeign.getKidByAppNumber(appNumber).getBody();
		if(planName.equalsIgnoreCase("SNAP") && salaryIncome <=300 ) {
			eligibility.setEligibilityStatus("Approved");
			eligibility.setDenialReason("NA");
			eligibility.setEligibilityStartDate(date);
			edRepo.save(eligibility);
			return "you are eligible to apply SNAP plan and the process is going on....";
		}else if(planName.equalsIgnoreCase("CCAP") && salaryIncome<=300 && kids.size()>0) {
			eligibility.setEligibilityStatus("Approved");
			eligibility.setDenialReason("NA");
			eligibility.setEligibilityStartDate(date);
			edRepo.save(eligibility);
			return "you are eligible to apply CCAP plan and the process is going on....";
		}else if(planName.equalsIgnoreCase("Medicaid") && salaryIncome<=300 && propertyIncome==0) {
			eligibility.setEligibilityStatus("Approved");
			eligibility.setDenialReason("NA");
			eligibility.setEligibilityStartDate(date);
			edRepo.save(eligibility);
			return "you are eligible to apply Medicaid plan and the process is going on....";
		}
		if(planName.equalsIgnoreCase("SNAP") || planName.equalsIgnoreCase("CCAP") && salaryIncome >=300) {
			return "Your salaryincome is greaterthan 300, You are not eligible to apply plan";
		}
		if(planName.equalsIgnoreCase("CCAP") && kids.size()<0) {
			return "you dont have kids so,you are not eligible to apply plan";
		}
		if(planName.equalsIgnoreCase("Medicaid")) {
			if(salaryIncome>300) {
				return "your salary Income is high,You are not eligible to apply medicaid plan";
			}
			if(propertyIncome>0) {
				return "your property Income is high,You are not eligible to apply medicaid plan";
			}
		}
		return "Your data is not suitable to apply the plans";
	}

	@Override
	public List<EligibilityDto> getEligibilityDetails() {
		ArrayList<EligibilityDto> arrayList = new ArrayList<>();
		EligibilityDto dto = new EligibilityDto();
		
		List<Eligibility> list = edRepo.findAll();
		for(Eligibility eligibility : list) {
			Integer planId = eligibility.getPlanId();
			String planName = planFeign.getPlanById(planId).getBody().getPlanName();
			BeanUtils.copyProperties(eligibility, dto);
			dto.setPlanName(planName);
			arrayList.add(dto);
		}
		return arrayList;
	}

	@Override
	public Eligibility getByAppNumber(Integer appNumber) {
		return edRepo.findByAppNumber(appNumber);
		
	}
	
	

}
