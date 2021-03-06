package com.cf.openAccountDao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cf.entity.CustomerDetails;


public class Dao implements DaoInterface{

	Connection con=null;
	public Dao() throws Exception {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:e:/db2");
	}
	@Override
	/*public int checkNewCustomer(Integer custId) throws Exception {
		// TODO Auto-generated method stub
		int i=0;
		PreparedStatement ps=con.prepareStatement("select * from acc where cid=?");
		ps.setInt(1, custId);
		
		ResultSet res=ps.executeQuery();
		//System.out.println("updated "+i);
		if(res.next())
			i=1;
		return i;
		
	}
	*/
	
	//public List<Integer> displayCustomer() throws Exception {
	public List<Integer> displayCustomer() throws Exception {
		List<CustomerDetails> ll=new ArrayList<CustomerDetails>();
		
		
			PreparedStatement ps=con.prepareStatement("select cid from customers");
			ResultSet res=ps.executeQuery();
			List<Integer> a=new ArrayList<Integer>();
			while(res.next()) {
				//CustomerDetails a=new CustomerDetails();
				 a.add(res.getInt("cid"));
				 //ll.add(a);
			}
						return a;
	}
	
	
	public boolean checkPhone(CustomerDetails c) {
		boolean i=false;
		try {
			PreparedStatement ps=con.prepareStatement("select * from customers where pphone=?");
			ps.setString(1, c.getPphone());
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				i= true;
			}

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
		
	}
	

	
}

