package com.mysqldemoproject.open.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysqldemoproject.open.DAO.ShareDetailDAO;
import com.mysqldemoproject.open.model.ShareDetail;
import com.mysqldemoproject.open.service.ShareDetailService;
@Service
public class ShareDetailServiceImpl implements ShareDetailService {

	@Autowired
	ShareDetailDAO shareDetailDao;
	@Override
	public int shareAdd(ShareDetail share) {
		return shareDetailDao.shareAdd(share);
		
	}
	@Override
	public List<ShareDetail> shareMemberList() {
		// TODO Auto-generated method stub
		return shareDetailDao.getShareMemberList();
	}
	@Override
	public ShareDetail getShareMembDetail(int id) {
		// TODO Auto-generated method stub
		return shareDetailDao.getShareMembDetail(id);
	}
	
	@Override
	public int shareEdit(ShareDetail share)
	{
		return shareDetailDao.shareEdit(share);
	}
	@Override
	public int shareDelete(int id) {
		// TODO Auto-generated method stub
		return shareDetailDao.shareDelete(id);
	}


	
	
}
