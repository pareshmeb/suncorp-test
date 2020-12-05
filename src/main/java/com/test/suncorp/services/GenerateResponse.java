package com.test.suncorp.services;

import java.util.ArrayList;

import com.test.suncorp.model.DispenceMoney;
import com.test.suncorp.model.Response;

public class GenerateResponse {
	
	public Response invalidateParameter() {
		Response response = new Response();
		response.setError("Invalid Paramete");
		response.setSuccess(false);
		return response;
	}
	
	public Response notAvailableCurrnecy() {
		Response response = new Response();
		response.setError("Currency Not Available");
		response.setSuccess(false);
		return response;
	}
	
	public Response notCorrectCombination() {
		Response response = new Response();
		response.setError("Not Correct Combination available, Please try again");
		response.setSuccess(false);
		return response;
	}
	
	public Response exceptionOccurred(String message) {
		Response response = new Response();
		response.setError(message);
		response.setSuccess(false);
		return response;
	}
	
	public Response success(ArrayList<DispenceMoney> dispneceMonies) {
		Response response = new Response();
		response.setDispenceMonies(dispneceMonies);
		response.setSuccess(true);
		return response;
	}

}
