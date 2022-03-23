package com.swiggy.dao;

import java.util.ArrayList;
import java.util.List;

import com.swiggy.entity.SwiggyUser;
import com.swiggy.timeline.TimelineDetails;

public interface SwiggyDAOInterface {

	int createProfileDAO(SwiggyUser su);

	SwiggyUser viewProfileDAO(SwiggyUser su);

	int deleteProfile(SwiggyUser su);

	ArrayList<SwiggyUser> viewAllProfileDAO();

	int editProfileDAO(SwiggyUser su);

	List<SwiggyUser> searchProfileDAO(SwiggyUser su);

	int createTimelineDAO(TimelineDetails tld);

	SwiggyUser signINDAO(SwiggyUser su);

	

	

	

}
