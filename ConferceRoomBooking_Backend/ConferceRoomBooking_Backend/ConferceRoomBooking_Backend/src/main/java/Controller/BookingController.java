package Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Booking;
import com.service.BookingService;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/room")
public class BookingController {
	   @Autowired
	    private BookingService bookingService;

	    @GetMapping("/{roomId}/date/{date}")
	    public ResponseEntity<List<Booking>> getBookingsByRoomAndDate(@PathVariable int roomId,@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
	        
	        List<Booking> bookings = bookingService.getBookingsByRoomAndDate(roomId, date);
	        return ResponseEntity.ok(bookings);
	    }
	   
	    @PostMapping
	    public ResponseEntity<Booking> BookRoom(@RequestBody Booking room)
	    {
			return  bookingService.BookConferenceRoom(room);
	    	
	    }
	    

	    @DeleteMapping("/bookings/{id}")
	    public ResponseEntity<String> DeleteRoom(@PathVariable Long id)
	    {
	    	System.out.println("hi");
			 bookingService.deleteRoomById(id);
			  return ResponseEntity.ok("Room deleted Sucessfuly");
	    	
	    }
	    
	    
	    @GetMapping("/bookings/{userId}")
	    public ResponseEntity<List<Map<String, Object>>> getUserBookingDetails(@PathVariable Long userId) {
	        List<Object[]> rawData = bookingService.getUserBookingDetails(userId);
	        
	        // Convert Object[] to readable key-value map (optional, but better than raw Object[])
	        List<Map<String, Object>> response = new ArrayList<>();
	        for (Object[] row : rawData) {
	            Map<String, Object> map = new HashMap<>();
	            map.put("id", row[0]);
	            map.put("roomName", row[1]);
	            map.put("location", row[2]);
	            map.put("bookingDate", row[3]);
	            map.put("startTime", row[4]);
	            map.put("endTime", row[5]);
	            response.add(map);
	        }

	        return ResponseEntity.ok(response);
	    }
}
