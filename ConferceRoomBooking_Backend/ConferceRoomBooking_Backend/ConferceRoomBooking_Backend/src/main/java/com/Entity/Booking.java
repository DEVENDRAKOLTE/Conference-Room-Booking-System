package com.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="Booking")
public class Booking {

	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	     Long id;

	   @ManyToOne(cascade = CascadeType.MERGE)
	    @JoinColumn(name = "conference_room_no")
	   @JsonIgnoreProperties({"roomName", "capaicty", "location", "bookings"})
	     ConferenceRoom conferenceRoom;

	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    @JsonIgnoreProperties({"name","password","bookings"})
	    User user;

	    @Column(name="bookingDate")
	    LocalDate bookingDate;
	    
	    @Column(name="startTime")
	    LocalTime startTime;
	    
	    @Column(name="endTime")
	    LocalTime endTime;
	    

public Booking() {
	// TODO Auto-generated constructor stub
}
		public Booking(ConferenceRoom conferenceRoom, User user, LocalDate bookingDate, LocalTime startTime,
				LocalTime endTime) {
			super();
			this.conferenceRoom = conferenceRoom;
			this.user = user;
			this.bookingDate = bookingDate;
			this.startTime = startTime;
			this.endTime = endTime;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public ConferenceRoom getConferenceRoom() {
			return conferenceRoom;
		}

		public void setConferenceRoom(ConferenceRoom conferenceRoom) {
			this.conferenceRoom = conferenceRoom;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public LocalDate getBookingDate() {
			return bookingDate;
		}

		public void setBookingDate(LocalDate bookingDate) {
			this.bookingDate = bookingDate;
		}

		public LocalTime getStartTime() {
			return startTime;
		}

		public void setStartTime(LocalTime startTime) {
			this.startTime = startTime;
		}

		public LocalTime getEndTime() {
			return endTime;
		}

		public void setEndTime(LocalTime endTime) {
			this.endTime = endTime;
		}
	    
		
}
