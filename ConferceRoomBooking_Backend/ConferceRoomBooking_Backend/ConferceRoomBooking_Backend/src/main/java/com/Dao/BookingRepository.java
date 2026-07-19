package com.Dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Entity.Booking;
@Repository
public interface BookingRepository extends JpaRepository<Booking,Long>{

	List<Booking> findByConferenceRoom_RoomNoAndBookingDate(int roomNo, LocalDate bookingDate);
	
	@Query("SELECT  b.id,cr.roomName, cr.location, b.bookingDate, b.startTime, b.endTime " +
		       "FROM Booking b " +
		       "JOIN b.conferenceRoom cr " +
		       "JOIN b.user u " +
		       "WHERE u.id = :userId")
		List<Object[]> getUserBookingDetails(@Param("userId") Long userId);
}
