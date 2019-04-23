package com.mysqldemoproject.open.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysqldemoproject.open.model.ShareDetail;
import com.mysqldemoproject.open.service.ShareDetailService;
@Controller
public class ShareController {
	
	@Autowired
	ShareDetailService shareDetailService;

	@ResponseBody
	@RequestMapping(value = "/addshareholder", method = RequestMethod.POST)
	public int addshareholder(@RequestParam String auser, @RequestParam String afname, 
			@RequestParam Integer aage, @RequestParam String aoccup, @RequestParam String acont )
			{
		ShareDetail share = new ShareDetail();
		share.setMemInfo_fname(auser);
		share.setMemInfo_fathname(afname);
		share.setMemInfo_age(aage);
		share.setMemInfo_occup(aoccup);
		share.setMemInfo_contno(acont);
		share.setMemInfo_status("Y");
		int retval=shareDetailService.shareAdd(share);
		System.out.println(retval);
		
		return retval;
	}
	
	@RequestMapping(value = "/viewshareholder")
	public ModelAndView shareview( Model model) {
				//	System.out.println("Ajax working");
				List<ShareDetail> shareMemList = shareDetailService.shareMemberList();
				model.addAttribute("shareMemberList",shareMemList);	
				//	System.out.println(shareMemList.size()+" list size");
				//System.out.println(shareMemList.get(0).getMemInfo_fname());
				return new ModelAndView("shareview");
	}
	@RequestMapping(value = "/changefieldshrholder", method = RequestMethod.POST)
	public ModelAndView getShareValue(@RequestParam Integer ashId,Model model)
			{
				ShareDetail shareDet = shareDetailService.getShareMembDetail(ashId);
				model.addAttribute("shareDet", shareDet);
				return new ModelAndView("shareedit");
				
	}
	@ResponseBody
	@RequestMapping(value = "/editshareholder", method = RequestMethod.POST)
	public int editshareholder(@RequestParam String auser, @RequestParam String afname, 
			@RequestParam Integer aage, @RequestParam String aoccup, @RequestParam String acont,@RequestParam Integer asId )
			{
		ShareDetail share = new ShareDetail();
		share.setMemInfo_fname(auser);
		share.setMemInfo_fathname(afname);
		share.setMemInfo_age(aage);
		share.setMemInfo_occup(aoccup);
		share.setMemInfo_contno(acont);
		share.setMemInfo_status("Y");
		share.setMemInfo_id(asId);
		int retval=shareDetailService.shareEdit(share);
		System.out.println(retval);
		return retval;
	}
	@ResponseBody
	@RequestMapping(value = "/deleteShareMem", method = RequestMethod.POST)
	public int deleteShareMem(@RequestParam Integer ashdelId,Model model)
			{
				
				int retval=shareDetailService.shareDelete(ashdelId);
				return retval;
				
	}

}
