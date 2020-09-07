package com.mthree.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Company {
	@Id
	private int companyId;
	private String companyName;
	private int tradeValue;
	public Company()
	{
		
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getTradeValue() {
		return tradeValue;
	}
	public void setTradeValue(int tradeValue) {
		this.tradeValue = tradeValue;
	}
	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", tradeValue=" + tradeValue + "]";
	}
	public Company(int companyId, String companyName, int tradeValue) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.tradeValue = tradeValue;
	}
	
	
	

}
