package com.mysqldemoproject.open.DAOImpl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysqldemoproject.open.DAO.CountryDAO;
import com.mysqldemoproject.open.model.Country;
import com.mysqldemoproject.open.model.Employee;
@Repository
public class CountryDAOImpl implements CountryDAO{
	
	@Autowired
	SessionFactory sessionfactory;
	@Override
	@Transactional
	public int countryAdd(Country cnt)
	{
		org.hibernate.Session asess= sessionfactory.getCurrentSession();
		asess.save(cnt);
		Serializable ids = asess.getIdentifier(cnt);
	    return (Integer) ids;
	}
	@Transactional @Override
	public List <Country> getCountryList()
	{
		
		org.hibernate.Session sess= sessionfactory.getCurrentSession();
		List <Country> cntObj =   sess.createQuery("from Country").list();
		return cntObj;
	}
	@Transactional @Override
	public Country getCountryDetail(int id)
	{
		org.hibernate.Session session = sessionfactory.getCurrentSession();
		Country getcntry = (Country) session.get(Country.class, id);
		return getcntry;
	}
	
	}
