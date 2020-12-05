package com.test.suncorp.model;

public class DispenceMoney {

	Integer value;
	Integer noOfNotes;

	public DispenceMoney() {
		super();
	}
	
	public DispenceMoney(Integer value, Integer noOfNotes) {
		this();
		this.value = value;
		this.noOfNotes = noOfNotes;
	}
	
	public void increaseNoOfNotes() {
		this.noOfNotes++;
	}
	
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public Integer getNoOfNotes() {
		return noOfNotes;
	}
	public void setNoOfNotes(Integer noOfNotes) {
		this.noOfNotes = noOfNotes;
	}
}
