package com.mysqldemoproject.open.DAOImpl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysqldemoproject.open.DAO.ShareDetailDAO;
import com.mysqldemoproject.open.model.ShareDetail;
@Repository
public class ShareDetailDAOImpl implements ShareDetailDAO{
	
	@Autowired
	SessionFactory sessionfactory;

	@Override
	@Transactional
	public int shareAdd(ShareDetail share) {
		// TODO Auto-generated method stub
	
		org.hibernate.Session addobj=sessionfactory.getCurrentSession();
		addobj.save(share);
		 Serializable ids = addobj.getIdentifier(share);
	      return (Integer) ids;		
	}
	@Transactional @Override
	public List<ShareDetail> getShareMemberList() {
		 org.hibernate.Session session= sessionfactory.getCurrentSession();
		 List<ShareDetail> shareMemList = session.createQuery("from ShareDetail").list();
		return shareMemList;
	}
	@Transactional @Override
	public ShareDetail getShareMembDetail(int id) {
		org.hibernate.Session session = sessionfactory.getCurrentSession();
		ShareDetail addEmployee = (ShareDetail) session.get(ShareDetail.class, id);
		return addEmployee;
	}
@Override
	@Transactional
	public int shareEdit(ShareDetail share) {
		// TODO Auto-generated method stub
		org.hibernate.Session session = sessionfactory.getCurrentSession();
		session.update(share);
		Serializable ids = session.getIdentifier(share);
		return (Integer) ids;
	}
@Override
@Transactional
public int shareDelete(int id) {
	// TODO Auto-generated method stub
	org.hibernate.Session session = sessionfactory.getCurrentSession();
	ShareDetail share = (ShareDetail) session.get(ShareDetail.class, id);
	session.delete(share);
	Serializable ids = session.getIdentifier(share);
	return (Integer) ids;
}


}
