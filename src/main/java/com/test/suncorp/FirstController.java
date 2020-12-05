package com.test.suncorp;

import org.springframework.web.bind.annotation.RestController;


import com.test.suncorp.model.Currency;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class FirstController {
	@Autowired CurrencyDao currencyDoo;
	

	
	

	@RequestMapping("/hi/{name}")
	public List<Currency> index() {
		return currencyDoo.findAllByOrderByValueDesc();
	}

}