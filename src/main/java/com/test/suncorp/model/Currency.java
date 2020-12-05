package com.test.suncorp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Currency {
	public Currency() {
		super();
	}
	
	public Currency(Integer value, Integer available) {
		this();
		this.value = value;
		this.available = available;
	}
	
	@Id @GeneratedValue
	Long id;
	Integer value;
	Integer available;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
	public Integer getAvailable() {
		return available;
	}
	public void setAvailable(Integer available) {
		this.available = available;
	}

}
