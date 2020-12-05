package com.test.suncorp.services;

import java.util.ArrayList;
import java.util.List;

import com.test.suncorp.CurrencyDao;
import com.test.suncorp.model.Currency;
import com.test.suncorp.model.DispenceMoney;

public class CurrencyDispenser {

	CurrencyDao currencyDoo;

	Integer currency;
	private List<Currency> currencies;

	public CurrencyDispenser() {
		super();
	}

	public CurrencyDispenser(Integer currency, CurrencyDao currencyDoo) {
		this();
		this.currency = currency;
		this.currencyDoo = currencyDoo;
	}

	private List<Currency> getCurrencies() {
		if (this.currencies == null) {
			return currencyDoo.findAllByOrderByValueAsc();
			// this.currencies = currencyDoo.findAllByOrderByValueDesc();
		}
		return currencyDoo.findAllByOrderByValueAsc();
		// return this.currencies;

	}

	public ArrayList<DispenceMoney> dispenceCurrency() {
		List<Currency> availableCurrencies = this.getCurrencies();
		ArrayList<DispenceMoney> dispneceMonies = new ArrayList<DispenceMoney>();
		DispenceMoney dispenceMoney = null;
		Integer dispencedValue = 0;
		Integer requestedValue = this.currency;
		Integer moneyValue;
		Currency availableCurrency;
		Integer noOfAvailable;
		for (int i = 0; i < availableCurrencies.size(); i++) {
			availableCurrency = availableCurrencies.get(i);
			moneyValue = availableCurrency.getValue();
			noOfAvailable = availableCurrency.getAvailable();
			dispenceMoney = new DispenceMoney(moneyValue, 0);
			while (requestedValue >= moneyValue && noOfAvailable > 0) {
				dispenceMoney.increaseNoOfNotes();
				noOfAvailable--;
				requestedValue -= moneyValue;
				dispencedValue += moneyValue;
			}
			if (dispenceMoney.getNoOfNotes() > 0) {
				dispneceMonies.add(dispenceMoney);
			}
		}
		return dispneceMonies;
	}

	public ArrayList<DispenceMoney> saveAndDispenceCurrency() throws Exception {
		ArrayList<DispenceMoney> dispneceMonies = this.dispenceCurrency();
		if (!dispneceMonies.isEmpty()) {
			this.saveCurrency(dispneceMonies);
		} else {
			throw new Exception("Something went wrong");
		}
		return dispneceMonies;
	}

	public void saveCurrency(ArrayList<DispenceMoney> dispneceMonies) {
		List<Currency> availableCurrencies = this.getCurrencies();
		Currency availableCurrency;
		Integer value;
		for (int i = 0; i < availableCurrencies.size(); i++) {
			availableCurrency = availableCurrencies.get(i);
			value = availableCurrency.getValue();
			for (DispenceMoney dispenceMoney : dispneceMonies) {
				if (value == dispenceMoney.getValue()) {
					availableCurrency.setAvailable(availableCurrency.getAvailable() - dispenceMoney.getNoOfNotes());
				}
			}
		}
		currencyDoo.saveAll(availableCurrencies);
	}

	public Boolean isSuitableCombinationAvailable() {
		List<Currency> availableCurrencies = this.getCurrencies();
		Integer requestedValue = this.currency;
		Integer moneyValue;
		Currency availableCurrency;
		for (int i = 0; i < availableCurrencies.size(); i++) {
			availableCurrency = availableCurrencies.get(i);
			moneyValue = availableCurrency.getValue();
			while ((requestedValue % moneyValue == 0) && requestedValue >= moneyValue) {
				requestedValue -= moneyValue;
			}
		}
		if (requestedValue > 0) {
			return false;
		} else {
			return true;
		}
	}

	public Boolean isMoneyAvailable() {
		List<Currency> availableCurrencies = this.getCurrencies();
		Integer requestedValue = this.currency;
		Integer moneyValue;
		Currency availableCurrency;
		Integer noOfAvailable = null;
		for (int i = 0; i < availableCurrencies.size(); i++) {
			availableCurrency = availableCurrencies.get(i);
			moneyValue = availableCurrency.getValue();
			noOfAvailable = availableCurrency.getAvailable();
			while (requestedValue >= moneyValue && noOfAvailable > 0) {
				requestedValue -= moneyValue;
				noOfAvailable--;
			}
		}
		if (noOfAvailable == null || noOfAvailable == 0) {
			return false;
		} else {
			return true;
		}
	}

	public Integer getRemaining() {
		List<Currency> availableCurrencies = this.getCurrencies();
		Integer requestedValue = this.currency;
		Integer moneyValue;
		Currency availableCurrency;
		Integer noOfAvailable = 0;
		for (int i = 0; i < availableCurrencies.size(); i++) {
			availableCurrency = availableCurrencies.get(i);
			moneyValue = availableCurrency.getValue();
			noOfAvailable = availableCurrency.getAvailable();
			while (requestedValue >= moneyValue && noOfAvailable > 0) {
				requestedValue -= moneyValue;
				noOfAvailable--;
			}
		}
		return requestedValue;
	}

	public Integer getCurrency() {
		return currency;
	}

	public void setCurrency(Integer currency) {
		this.currency = currency;
	}

}
