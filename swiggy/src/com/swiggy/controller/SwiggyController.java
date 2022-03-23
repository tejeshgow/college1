package com.swiggy.controller;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.swiggy.entity.SwiggyUser;
import com.swiggy.service.SwiggyService;
import com.swiggy.service.SwiggyServiceInterface;
import com.swiggy.timeline.TimelineDetails;
import com.swiggy.utility.SortbyName;

public class SwiggyController implements SwiggyControllerInterface {
	Logger log=Logger.getLogger("SwiggyController");
	

	@Override
	public void createProfileController() {
		Scanner sc=new Scanner(System.in);
		log.info("enter name");
		String name=sc.next();
		log.info("enter password");
		String password=sc.next();
		log.info("enter email");
		String email=sc.next();
		log.info("enter address");
		String address=sc.next();
		SwiggyUser su=new SwiggyUser();
		su.setName(name);
		su.setPassword(password);
		su.setEmail(email);
		su.setAddress(address);
		SwiggyServiceInterface ss=new SwiggyService();
		int i=ss.createProfileService(su);
		if(i>0) {
			System.out.println("profile created");
		}else {
			System.out.println("could not create profile");
			}

	}

	@Override
	public void viewProfileController() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter email to view profile");
		String email=sc.next();
		SwiggyUser su=new SwiggyUser();
		su.setEmail(email);
		
		SwiggyServiceInterface ss=new SwiggyService();
		SwiggyUser s1=ss.viewProifileService(su);
		if(s1!=null) {
			System.out.println("Name is"+" "+s1.getName());
			System.out.println("password is"+" "+s1.getPassword());
			System.out.println("email is"+" "+s1.getEmail());
			System.out.println("address is"+" "+s1.getAddress());
			
		}else {
			System.out.println("profile not found");
			
		}
		
		
		
		
	}

	@Override
	public void deleteProfileController() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter email to delete profile");
		String email=sc.next();
		SwiggyUser su=new SwiggyUser();
		su.setEmail(email);
		
		SwiggyServiceInterface ss=new SwiggyService();
		int s1=ss.deleteProifileService(su);
		if(s1>0) {
			System.out.println("profile deleted");
		}else {
			System.out.println("could not delete profile");
			
		}
		
		
	}

	@Override
	public void viewAllProfileController() {
		SwiggyServiceInterface ss=new SwiggyService();
		ArrayList<SwiggyUser> ll=ss.viewAllProfileService();
		System.out.println(ll.size()+"record found in database");
		
		for(SwiggyUser r:ll) {
			System.out.println("************");
			System.out.println("Name is"+" "+r.getName());
			System.out.println("password is"+" "+r.getPassword());
			System.out.println("email is"+" "+r.getEmail());
			System.out.println("address is"+" "+r.getAddress());
			
		}
		System.out.println("******After Sorting******");
		Collections.sort(ll,new SortbyName());
		for(SwiggyUser r:ll) {
			System.out.println("************");
			System.out.println("Name is"+" "+r.getName());
			System.out.println("password is"+" "+r.getPassword());
			System.out.println("email is"+" "+r.getEmail());
			System.out.println("address is"+" "+r.getAddress());
			
		}
		
		
	}

	@Override
	public void editProfileController() {
		System.out.println("your old data");
		viewProfileController();
		Scanner sc=new Scanner(System.in);
		System.out.println("ener new name");
		String name=sc.next();
		System.out.println("ener new password");
		String password=sc.next();
		System.out.println("ener old email");
		String email=sc.next();
		System.out.println("ener new address");
		String address=sc.next();
		SwiggyUser su=new SwiggyUser();
		su.setName(name);
		su.setPassword(password);
		su.setEmail(email);
		su.setAddress(address);
		SwiggyServiceInterface ss=new SwiggyService();
		int i=ss.editProfileService(su);
		if(i>0) {
			System.out.println("your profile is edited"+" "+name);
			
		}else {
			System.out.println("your profile is not editeed");
			
		}
		
		
		
		
		
	}

	@Override
	public void searchProfileController() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter name to search profile");
		String name=sc.next();
		SwiggyUser su=new SwiggyUser();
		su.setName(name);
		SwiggyServiceInterface ss=new SwiggyService();
		List<SwiggyUser>ll=ss.searchProfileService(su);
		ll.forEach(s->{
				System.out.println(s.getName());
				System.out.println(s.getPassword());
				System.out.println(s.getEmail());
				System.out.println(s.getAddress());
		});
		
		
	}

	@Override
	public void createTimelineController() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Message ID: ");
		String messageid=sc.next();
		System.out.println("Enter Sender ID: ");
		String senderid=sc.next();
		System.out.println("Enter Reciever ID: ");
		String recieverid=sc.next();
		System.out.println("Enter Message: ");
		String message=sc.next();
		System.out.println("Enter Date2: ");
		String date2=sc.next();
		TimelineDetails tld=new TimelineDetails();
		tld.setMessageid(messageid);
		tld.setSenderid(senderid);
		tld.setRecieverid(recieverid);
		tld.setMessage(message);
		tld.setDate2(date2);
		SwiggyUser su=new SwiggyUser();
		SwiggyServiceInterface ss=new SwiggyService();
		int i=ss.createTimelineService(tld);
		if(i>0) {
			System.out.println("your timeline is updated");
		}else {
			System.out.println("Sorry unable to create timeline");
			
		}
		
		
		
	}

	@Override
	public SwiggyUser signINController() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter email");
		String email=sc.next();
		System.out.println("enter password");
		String password=sc.next();
		
		SwiggyUser su=new SwiggyUser();
		su.setEmail(email);
		su.setPassword(password);
		
		SwiggyServiceInterface ss=new SwiggyService();
		SwiggyUser i=ss.signINProifileService(su);
		if(i!=null) {
			System.out.println("*********");
			System.out.println("welcome to Swiggy"+" "+i.getName()+"  ");
			System.out.println("***********");
			}
		else {
				System.out.println("Unable to signin..... try again");
			}
		return i;
	}

	

	
		
		
		
	}


