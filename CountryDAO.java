package com.mysqldemoproject.open.DAO;

import java.util.List;

import com.mysqldemoproject.open.model.Country;


public interface CountryDAO {

	public  int countryAdd(Country cnt);
	public List <Country> getCountryList();
	public Country getCountryDetail(int id);
}
