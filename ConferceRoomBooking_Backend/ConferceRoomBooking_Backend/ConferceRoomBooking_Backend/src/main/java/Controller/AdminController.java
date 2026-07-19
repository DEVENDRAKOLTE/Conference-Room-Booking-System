package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.Entity.ConferenceRoom;
import com.service.AdminService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ConferenceRoom")
public class AdminController {

    @Autowired
    AdminService adminservice;

    @PostMapping
    public ResponseEntity<String> insertConferenceRoom(@RequestBody ConferenceRoom room) {
        boolean isAdded = adminservice.addConferRoom(room);
        if (isAdded) {
            return new ResponseEntity<>("Conference Room Added Successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Conference Room Not Added", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<ConferenceRoom>> getAllConferenceRooms() {
        List<ConferenceRoom> rooms = adminservice.getAllConferenceRooms();
        if (rooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateConferenceRoom(@PathVariable int id, @RequestBody ConferenceRoom room) {
        boolean isUpdated = adminservice.updateConferenceRoom(id, room);
        if (isUpdated) {
            return new ResponseEntity<>("Conference Room Updated Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Conference Room Not Updated", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity<String> deleteConferenceRoom(@PathVariable int roomId) {
        boolean isDeleted = adminservice.deleteConferenceRoom(roomId);
        if (isDeleted) {
            return new ResponseEntity<>("Conference Room Deleted Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Conference Room Not Found", HttpStatus.NOT_FOUND);
        }
    }
}
