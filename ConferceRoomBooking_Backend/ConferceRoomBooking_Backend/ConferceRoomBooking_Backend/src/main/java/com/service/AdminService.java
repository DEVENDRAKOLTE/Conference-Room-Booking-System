package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.DatabaseConnetivity;
import com.Entity.ConferenceRoom;

@Service
public class AdminService {

	@Autowired
	DatabaseConnetivity admindata;
	
	
	public AdminService() {
		// TODO Auto-generated constructor stub
	}
	public boolean addConferRoom(ConferenceRoom room) {
		admindata.save(room);
		
		
		return true;
	}
	public List<ConferenceRoom> getAllConferenceRooms() {
	    
		return admindata.findAll();
	}
	public boolean updateConferenceRoom(int id, ConferenceRoom room) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean deleteConferenceRoom(int id) {
		admindata.deleteById(id);
		return true;
	}

}
