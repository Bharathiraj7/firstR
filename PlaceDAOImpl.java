package com.mysqldemoproject.open.DAOImpl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysqldemoproject.open.DAO.PlaceDAO;
import com.mysqldemoproject.open.model.ExcelData;
import com.mysqldemoproject.open.model.Place;

@Repository
public class PlaceDAOImpl implements PlaceDAO {
	
	@Autowired
	SessionFactory sessionfactory;

	@Override
	@Transactional
	public int addPlace(Place place) {
	
		org.hibernate.Session asess= sessionfactory.getCurrentSession();
		asess.save(place);
		Serializable ids = asess.getIdentifier(place);
	    return (Integer) ids;
		
	}
	@Override
	@Transactional
	public List<Object[]> getPlaceDetail(int st_id)
	{
		org.hibernate.Session pl_ses= sessionfactory.getCurrentSession();
		/*String sql="SELECT g.*,h.state_name,i.country_name "
						+ "FROM place AS g "
						+ "LEFT JOIN states AS h ON  h.state_id=g.state_id "
						+ "LEFT JOIN country AS i ON  i.country_id=h.country_id "
						+ "WHERE g.state_id=:stId";
						List <Object[]> getlist= pl_ses.createSQLQuery(sql).setParameter("stId", st_id).list();
						*/
		
	/*	String sql="SELECT g.placeId,h.stateName,i.countryName "
						+ "FROM Place AS g "
						+ "LEFT JOIN State AS h ON  h.stateId=g.state.stateId "
						+ "LEFT JOIN Country AS i ON  i.countryId=h.country.countryId "
						+ "WHERE g.state.stateId=:stId";
		List <Object[]> getlist= pl_ses.createQuery(sql).setParameter("stId", st_id).list();*/
	
		String sql = "select p.placeId,p.placeName,s.stateName,c.countryName  from Place p,State s,"
						+ "Country c where p.state.stateId=:stId and "
						+ " p.state.stateId=s.stateId and c.countryId=s.country.countryId ";
		
//		List <Place> getlist= pl_ses.createQuery("from Place WHERE state.stateId=:stId").setParameter("stId", st_id).list();
		List <Object[]> getlist= pl_ses.createQuery(sql).setParameter("stId", st_id).list();
		return getlist;
	}
	@Override
	@Transactional
	public void saveExcel(
					ExcelData ex_data) {
		// TODO Auto-generated method stub
		org.hibernate.Session asess= sessionfactory.getCurrentSession();
		asess.save(ex_data);
	}


	
	

		
}
