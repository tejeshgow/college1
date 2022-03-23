package com.swiggy.service;

import java.util.ArrayList;
import java.util.List;

import com.swiggy.entity.SwiggyUser;
import com.swiggy.timeline.TimelineDetails;

public interface SwiggyServiceInterface {

	int createProfileService(SwiggyUser su);

	SwiggyUser viewProifileService(SwiggyUser su);

	int deleteProifileService(SwiggyUser su);

	ArrayList<SwiggyUser> viewAllProfileService();

	int editProfileService(SwiggyUser su);

	List<SwiggyUser> searchProfileService(SwiggyUser su);

	int createTimelineService(TimelineDetails tld);

	SwiggyUser signINProifileService(SwiggyUser su);

	
	
	 

}
