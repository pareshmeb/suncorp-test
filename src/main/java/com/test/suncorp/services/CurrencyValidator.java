package com.test.suncorp.services;

public class CurrencyValidator {

	Integer amount;
	
	public CurrencyValidator() {
		super();
	}
	
	public CurrencyValidator(Integer amount) {
		this();
		this.amount = amount;
	}
	
	public boolean validateAmount() {
		if (this.amount == null || this.amount == 0) {
			return false;
		}
		return true;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
