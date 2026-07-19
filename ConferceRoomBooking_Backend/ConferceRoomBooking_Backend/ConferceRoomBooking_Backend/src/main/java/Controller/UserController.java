package Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.ConferenceRoom;
import com.Entity.User;
import com.service.AdminService;
import com.service.Userservice;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

	 @Autowired
	   Userservice userservice;

	    @PostMapping
	    public ResponseEntity<User> validateEmployee(@RequestBody User user) {
	    	System.out.println("hi b");
	    	 Optional<User> Validuser = userservice.Checkuser(user);
	         return Validuser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
			
	    }
	    

}
