package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

import com.revature.db.dbConnect;
import com.revature.model.Cab;

public class BookingImpl implements Booking{
	
	private static final Logger logger = Logger.getLogger("BookingImpl.class");

	@Override
	public Set<Cab> copycabs() {			
		logger.info("adding cabs in local HashSet");
		
		Set<Cab> cabs=new LinkedHashSet<>();//creating a local hashSet to store all the cabs details from the database
		try {
			Connection con = dbConnect.getConnection();
			PreparedStatement pt = con.prepareStatement("select cabNo,freeOrBooked from cab");//getting data from cab table
			ResultSet rs = pt.executeQuery();
			while(rs.next()) {
				Integer cabNo = rs.getInt(1);//extracting the data one by one
				Integer fOB = rs.getInt(2);
				Cab a = new Cab(cabNo,fOB);//combining the data in a Cab type object
				cabs.add(a);//adding that Cab type object to out Hashset
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("All cab details are stored locally");
		return cabs;//returning our Hashset
	}

}