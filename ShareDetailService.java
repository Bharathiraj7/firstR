package com.mysqldemoproject.open.service;

import java.util.List;

import com.mysqldemoproject.open.model.ShareDetail;

public interface ShareDetailService {

	public  int shareAdd(ShareDetail share);
	public List<ShareDetail> shareMemberList();
	public ShareDetail getShareMembDetail(int id);
	public int shareEdit(ShareDetail share);
	public int shareDelete(int id);
	
}
