package com.swiggy.utility;

import java.util.Comparator;

import com.swiggy.entity.SwiggyUser;

public class SortbyName implements Comparator<SwiggyUser>{

	@Override
	public int compare(SwiggyUser u1, SwiggyUser u2) {
		
		return u1.getName().compareTo(u2.getName());
	}
	

}
