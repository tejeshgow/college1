package com.swiggy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.swiggy.entity.SwiggyUser;
import com.swiggy.exception.UserDefinedException;
import com.swiggy.timeline.TimelineDetails;

public class SwiggyDAO implements SwiggyDAOInterface {
	int i;
	private Connection con;

	@Override
	public int createProfileDAO(SwiggyUser su) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Tejesh");
			if(su.getName().contentEquals("government")) {
				throw new UserDefinedException();
				
			}
			
			//step 3 is to create query
			//for static query we will use Statement Interface--static query will compile every time 
			//for dynamic query we will use PreparedStatement interface---- dynamic uery will use pre compiled query will not compile every time
			PreparedStatement ps=con.prepareStatement("insert into swiggyuser values(?,?,?,?)");
			ps.setString(1,su.getName());
			ps.setString(2,su.getPassword());
			ps.setString(3,su.getEmail());
			ps.setString(4,su.getAddress());
			i=ps.executeUpdate();	
			
			
		}
		catch(Exception e){
			e.printStackTrace();
			
			
		}
		return i;
	}

	@Override
	public SwiggyUser viewProfileDAO(SwiggyUser su) {
		SwiggyUser s2=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Tejesh");
			//step 3 is to create query
			//for static query we will use Statement Interface--static query will compile every time 
			//for dynamic query we will use PreparedStatement interface---- dynamic uery will use pre compiled query will not compile every time
			PreparedStatement ps=con.prepareStatement("select * from swiggyuser where email=?");
			
			ps.setString(1,su.getEmail());
			
			ResultSet res=ps.executeQuery();	
			if(res.next()) {
				String n=res.getString(1);
				String p=res.getString(2);
				String e=res.getString(3);
				String a=res.getString(4);
			    s2=new SwiggyUser();
				s2.setName(n);
				s2.setEmail(e);
				s2.setPassword(p);
				s2.setAddress(a);
				
			}
			
			
		}
		catch(Exception e){
			e.printStackTrace();
			
			
		}
		
		return s2;
	}

	@Override
	public int deleteProfile(SwiggyUser su) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Tejesh");
			//step 3 is to create query
			//for static query we will use Statement Interface--static query will compile every time 
			//for dynamic query we will use PreparedStatement interface---- dynamic uery will use pre compiled query will not compile every time
			PreparedStatement ps=con.prepareStatement("delete from swiggyuser where email=?");
			
			ps.setString(1,su.getEmail());
			
			i=ps.executeUpdate();	
			
			
		}
		catch(Exception e){
			e.printStackTrace();
			
			
		}
		return i;
	}

	@Override
	public ArrayList<SwiggyUser> viewAllProfileDAO() {
		SwiggyUser s2=null;
		ArrayList<SwiggyUser> ll=new ArrayList<SwiggyUser>();
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Tejesh");
			//step 3 is to create query
			//for static query we will use Statement Interface--static query will compile every time 
			//for dynamic query we will use PreparedStatement interface---- dynamic uery will use pre compiled query will not compile every time
			PreparedStatement ps=con.prepareStatement("select * from swiggyuser");
			
			
			
			ResultSet res=ps.executeQuery();
			while(res.next()) {
				String n=res.getString(1);
				String p=res.getString(2);
				String e=res.getString(3);
				String a=res.getString(4);
			    s2=new SwiggyUser();
				s2.setName(n);
				s2.setEmail(e);
				s2.setPassword(p);
				s2.setAddress(a);
				
				ll.add(s2);
				
				
			}
			
			
		}
		catch(Exception e){
			e.printStackTrace();
			
			
		}
		
		return ll;
		
		
	}

	@Override
	public int editProfileDAO(SwiggyUser su) {
		int i=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Tejesh");
			PreparedStatement ps=con.prepareStatement("update swiggyuser set name=?,password=?, address=? where email=?");
			ps.setString(1, su.getName());
			ps.setString(2, su.getPassword());
			ps.setString(4, su.getEmail());
			ps.setString(3, su.getAddress());
			i=ps.executeUpdate();
			
			}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return i;
	}

	@Override
	public List<SwiggyUser> searchProfileDAO(SwiggyUser su) {
		SwiggyUser s2=null;
		List<SwiggyUser> ll=new ArrayList<SwiggyUser>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Tejesh");
			PreparedStatement ps=con.prepareStatement("select * from swiggyuser where name=?");
			ps.setString(1, su.getName());
			
			ResultSet res=ps.executeQuery();
			while(res.next()) {
				String n=res.getString(1);
				String p=res.getString(2);
				String e=res.getString(3);
				String a=res.getString(4);
				
				s2=new SwiggyUser();
				s2.setName(n);
				s2.setPassword(p);
				s2.setEmail(e);
				s2.setAddress(a);
				ll.add(s2);
			}	
			}
		catch(Exception e) {
			e.printStackTrace();
			
		}return ll;
	}

	@Override
	public int createTimelineDAO(TimelineDetails tld) {
		int i=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Tejesh");
			PreparedStatement ps=con.prepareStatement("insert into TimelineDetails values(?,?,?,?,?)");
			ps.setString(1, tld.getMessageid());
			ps.setString(2, tld.getSenderid());
			ps.setString(3, tld.getRecieverid());
			ps.setString(4, tld.getMessage());
			ps.setString(5, tld.getDate2());
			
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return i;
	}

	@Override
	public SwiggyUser signINDAO(SwiggyUser su) {
		SwiggyUser t=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Tejesh");
			//step 3 is to create query
			//for static query we will use Statement Interface--static query will compile every time 
			//for dynamic query we will use PreparedStatement interface---- dynamic uery will use pre compiled query will not compile every time
			PreparedStatement ps=con.prepareStatement("select * from swiggyuser where email=? and password=?");
			
			//ps.setString(1,su.getName());
			ps.setString(2,su.getPassword());
			ps.setString(1,su.getEmail());
			//ps.setString(4,su.getAddress());
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				String n=res.getString(1);
				String p=res.getString(2);
				String e=res.getString(3);
				String a=res.getString(4);
				t=new SwiggyUser();
				t.setName(n);
				t.setPassword(p);
				t.setEmail(e);
				t.setAddress(a);
				
			}
			
			
		}
		catch(Exception e){
			e.printStackTrace();
			
			
		}
		return t;
	}

	

}
