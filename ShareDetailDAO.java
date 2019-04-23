package com.mysqldemoproject.open.DAO;

import com.mysqldemoproject.open.model.ShareDetail;
import java.util.List;
public interface ShareDetailDAO {

 public  int shareAdd(ShareDetail share);
 public List<ShareDetail> getShareMemberList();
 public ShareDetail getShareMembDetail(int id);
 public int shareEdit(ShareDetail share);
	public int shareDelete(int id);

}
