package com.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Dao.BookingRepository;
import com.Entity.Booking;
@Service
public class BookingService {
    
	@Autowired
    private BookingRepository bookingRepository;
	public List<Booking> getBookingsByRoomAndDate(int roomId, LocalDate date) {
		 

		       return bookingRepository.findByConferenceRoom_RoomNoAndBookingDate(roomId, date);
		    
	}
	public ResponseEntity<Booking> BookConferenceRoom(Booking room) {
		Booking savedBooking = bookingRepository.save(room);
	    return ResponseEntity.status(HttpStatus.CREATED).body(savedBooking);
	}

public List<Object[]> getUserBookingDetails(Long userId) {
    return bookingRepository.getUserBookingDetails(userId);
}
public void deleteRoomById(Long id) {
	bookingRepository.deleteById(id);
	
}

}
