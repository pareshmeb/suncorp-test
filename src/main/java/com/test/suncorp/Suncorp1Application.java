package com.test.suncorp;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.test.suncorp.model.Currency;

@SpringBootApplication
public class Suncorp1Application {

	public static void main(String[] args) {
		SpringApplication.run(Suncorp1Application.class, args);
	}
	
	@PostConstruct
	public void init() {
		Set<Currency>  Currencies = new HashSet<>();
		Currencies.add(new Currency(20, 50));
		Currencies.add(new Currency(50, 10));
		currencyDao.saveAll(Currencies);
		
	}
	
	@Autowired CurrencyDao currencyDao;

}
