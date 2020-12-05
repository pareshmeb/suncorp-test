package com.test.suncorp.model;

import java.util.ArrayList;

public class Response {
	
	ArrayList<DispenceMoney> dispneceMonies = new ArrayList<DispenceMoney>();
	String error;
	Boolean success;
	
	public Response() {
		super();
	}
	
	public ArrayList<DispenceMoney> getDispenceMonies() {
		return dispneceMonies;
	}
	public void setDispenceMonies(ArrayList<DispenceMoney> dispenceMoney) {
		this.dispneceMonies = dispenceMoney;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
}
