package com.ed.dto;

import java.sql.Date;

public class EligibilityDto {

	private Integer id;
	private Integer appNumber;
	private String planName;
	private String eligibilityStatus;
	private Date eligibilityStartDate;
	private Date eligibilityEndDate;
	private double benfitAmt;
	private String denialReason;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAppNumber() {
		return appNumber;
	}
	public void setAppNumber(Integer appNumber) {
		this.appNumber = appNumber;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getEligibilityStatus() {
		return eligibilityStatus;
	}
	public void setEligibilityStatus(String eligibilityStatus) {
		this.eligibilityStatus = eligibilityStatus;
	}
	public Date getEligibilityStartDate() {
		return eligibilityStartDate;
	}
	public void setEligibilityStartDate(Date eligibilityStartDate) {
		this.eligibilityStartDate = eligibilityStartDate;
	}
	public Date getEligibilityEndDate() {
		return eligibilityEndDate;
	}
	public void setEligibilityEndDate(Date eligibilityEndDate) {
		this.eligibilityEndDate = eligibilityEndDate;
	}
	public double getBenfitAmt() {
		return benfitAmt;
	}
	public void setBenfitAmt(double benfitAmt) {
		this.benfitAmt = benfitAmt;
	}
	public String getDenialReason() {
		return denialReason;
	}
	public void setDenialReason(String denialReason) {
		this.denialReason = denialReason;
	}
	
}
