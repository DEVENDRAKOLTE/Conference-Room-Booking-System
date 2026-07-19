package com.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="ConferenceRoom")
public class ConferenceRoom {
     @Id
     @Column(name="roomNo")
	int roomNo;
     
     @Column(name="roomName")
     String roomName;
     
     @Column(name="capaicty")
     int capaicty;
     
     @Column(name="location")
     String location;
     
     @JsonIgnore
     @OneToMany(mappedBy = "conferenceRoom", cascade = CascadeType.ALL, orphanRemoval = true)
     private List<Booking> bookings = new ArrayList<>();

     
     public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public ConferenceRoom() {
		// TODO Auto-generated constructor stub
	}
	public ConferenceRoom(int roomNo, String roomName, int capaicty, String location, List<Booking> bookings) {
		super();
		this.roomNo = roomNo;
		this.roomName = roomName;
		this.capaicty = capaicty;
		this.location = location;
		this.bookings = bookings;
	}
	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getCapaicty() {
		return capaicty;
	}

	public void setCapaicty(int capaicty) {
		this.capaicty = capaicty;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
     
	
	
}
