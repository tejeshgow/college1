package com.swiggy.view;
//test
import java.util.Scanner;

import com.swiggy.controller.SwiggyController;
import com.swiggy.controller.SwiggyControllerInterface;
import com.swiggy.entity.SwiggyUser;

public class SwiggyView {

	public static void main(String[] args) {
		String s="y";
		Scanner sc=new Scanner(System.in);
		while(s.contentEquals("y")) {
			System.out.println("*************");
			System.out.println("Welcome to Swiggy");
			System.out.println("*************");
			System.out.println("press 1 to signup");
			System.out.println("press 2 to signin");
			System.out.println("*************");
			System.out.println("enter your choice");
			int ch=sc.nextInt();
			SwiggyControllerInterface sf=new SwiggyController();
			SwiggyUser si;		
			
		switch(ch)
		{
		case 1:
			sf.createProfileController();
			
			break;
		case 2:
			si=sf.signINController();
			
			if(si!=null) {
				while(s.contentEquals("y")) {
					//System.out.println("*********main menu******");
					System.out.println("press 1 to delete profile");
					System.out.println("press 2 to view profile");
					System.out.println("press 3 to view all profile");
					System.out.println("press 4 to edit  profile");
					System.out.println("press 5 to search profile");
					System.out.println("press 6 to create timeline");
					System.out.println("select an operation");
					int c=sc.nextInt();
					switch(c) {
					case 1:
						sf.deleteProfileController();
						break;
					case 2:
						sf.viewProfileController();
						break;
					case 3:
						sf.viewAllProfileController();
						break;
					case 4:
						sf.editProfileController();
						break;
					case 5:
						sf.searchProfileController();
						break;						
					case 6:
						sf.createTimelineController();
						break;
						default:
							System.out.println("be careful what you wish for "+si.getName());
						}
					System.out.println("press y if you wanna see the operations again");
					s=sc.next();
				}
			}
			else {
				System.out.println("it is very sad that you are not on swiggy");
				
			}break;
			default:
				System.out.println("i guess");
		}
				
		}
		System.out.println("press y/n to continue");
		s=sc.next();
		
				
		}
		

	}


