package com.test.suncorp;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.test.suncorp.model.Currency;

public interface CurrencyDao extends CrudRepository<Currency, Long>{
	
	List<Currency> findAllByOrderByValueDesc();
	List<Currency> findAllByOrderByValueAsc();
	
	Currency findByValue(Integer value);

}
