package com.mysqldemoproject.open.DAOImpl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysqldemoproject.open.DAO.StateDAO;
import com.mysqldemoproject.open.model.Country;
import com.mysqldemoproject.open.model.State;
@Repository
public class StateDAOImpl implements StateDAO {
	@Autowired
	SessionFactory sessionfactory;
	@Override
	@Transactional
	public  int stateAdd(State st)
	{
		org.hibernate.Session asess= sessionfactory.getCurrentSession();
		asess.save(st);
		Serializable ids = asess.getIdentifier(st);
	    return (Integer) ids;
	}
	@Transactional @Override
	public List <State> getStateDetails()
	{
		
		org.hibernate.Session sess= sessionfactory.getCurrentSession();
		List <State> cntObj =   sess.createQuery("from State").list();
		return cntObj;
	}
	@SuppressWarnings("unchecked")
	@Transactional @Override
	 public List <State> getState_Country(int country_id)
	 {
		org.hibernate.Session sess= sessionfactory.getCurrentSession();
		List <State> stObj =   sess.createQuery("from State WHERE country.countryId=:cnty_id").setParameter("cnty_id", country_id).list();
		return stObj;
	 }
	@Transactional @Override
	public State  getStateId(int state_id)
	{
		org.hibernate.Session psess= sessionfactory.getCurrentSession();
		State stid=(State) psess.get(State.class, state_id);
		return stid;
	}
	
}
