package com.revature.service;

import com.revature.model.Cab;

public interface BookingSystem{
	
	void addCab(Cab newCab) throws Exception;
	Integer requestCab() throws Exception;
	Integer getNoOfAvailableCabs() throws Exception;
	

}