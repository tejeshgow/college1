package com.swiggy.service;

import java.util.ArrayList;
import java.util.List;

import com.swiggy.dao.SwiggyDAO;
import com.swiggy.dao.SwiggyDAOInterface;
import com.swiggy.entity.SwiggyUser;
import com.swiggy.timeline.TimelineDetails;

public class SwiggyService implements SwiggyServiceInterface {

	@Override
	public int createProfileService(SwiggyUser su) {
		SwiggyDAOInterface sd=new SwiggyDAO();
		int i=sd.createProfileDAO(su);
		return i;
		
}

	@Override
	public SwiggyUser viewProifileService(SwiggyUser su) {
		SwiggyDAOInterface sd=new SwiggyDAO();
		SwiggyUser s=sd.viewProfileDAO(su);
		
		
		return s;
	}

	public int deleteProifileService(SwiggyUser su) {
		SwiggyDAOInterface sd=new SwiggyDAO();
		int i=sd.deleteProfile(su);
		
		return i;
		
	}

	@Override
	public ArrayList<SwiggyUser> viewAllProfileService() {
		SwiggyDAOInterface sd=new SwiggyDAO();
		ArrayList<SwiggyUser> s=sd.viewAllProfileDAO();
		return s;
	}

	@Override
	public int editProfileService(SwiggyUser su) {
		SwiggyDAOInterface sd=new SwiggyDAO();
		
		int i=sd.editProfileDAO(su);
		
		return i;
	}

	@Override
	public List<SwiggyUser> searchProfileService(SwiggyUser su) {
		SwiggyDAOInterface sd=new SwiggyDAO();
		
		
		return sd.searchProfileDAO(su);
		
	}

	@Override
	public int createTimelineService(TimelineDetails tld) {
		SwiggyDAOInterface sd=new SwiggyDAO();
		
		int i=sd.createTimelineDAO(tld);
		
		return i;
	}

	@Override
	public SwiggyUser signINProifileService(SwiggyUser su) {
		SwiggyDAOInterface sd=new SwiggyDAO();
		SwiggyUser i=sd.signINDAO(su);
		
		return i;
	}

		
}
