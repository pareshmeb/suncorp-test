package com.test.suncorp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.suncorp.model.Currency;
import com.test.suncorp.model.DispenceMoney;
import com.test.suncorp.model.Response;
import com.test.suncorp.services.CurrencyDispenser;
import com.test.suncorp.services.CurrencyValidator;
import com.test.suncorp.services.GenerateResponse;

@RestController
public class DispenseController {
	@Autowired
	CurrencyDao currencyDoo;
	
	@PutMapping("/dispence/{amount}")
	public Response dispenceMoney(@PathVariable Integer amount) {
		CurrencyValidator currencyValidator = new CurrencyValidator(amount);
		GenerateResponse generateResponse = new GenerateResponse();
		if (!currencyValidator.validateAmount()) {
			return generateResponse.invalidateParameter();
		}
		CurrencyDispenser currencyDispenser = new CurrencyDispenser(amount, currencyDoo);
		if (currencyDispenser.isMoneyAvailable())  {
			if (currencyDispenser.isSuitableCombinationAvailable()) {
				try {
					ArrayList<DispenceMoney> dispneceMonies = currencyDispenser.saveAndDispenceCurrency();
					return generateResponse.success(dispneceMonies);
					
				} catch(Exception e) {
					return generateResponse.exceptionOccurred(e.getMessage());
				}
				
			} else {
				return generateResponse.notCorrectCombination();
			}
			
		} else {
			return generateResponse.notAvailableCurrnecy();
		}
	}
	
	@GetMapping(value="/")
	public List<Currency> getAvailableNotes() {
		return currencyDoo.findAllByOrderByValueDesc();
	}

}
