package MeuTreino.Gym.controllers.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import MeuTreino.Gym.dataVo.AcconutCredencialVO;
import MeuTreino.Gym.dataVo.TokenVo;
import MeuTreino.Gym.model.UserModel;
import MeuTreino.Gym.repositorys.UserRepository;
import MeuTreino.Gym.services.AuthService;
import MeuTreino.Gym.tokenJwt.JWTTokenProvider;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	@Autowired
	AuthService authService;
	
	@Autowired
	UserRepository userRepository;
	

	@PostMapping(value = "/login")
	public ResponseEntity singnin(@RequestBody AcconutCredencialVO data) {
		if (CheckIfParansIsNotNull(data)) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("invalid user");
		var token = authService.signin(data);
		if (token == null) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("invalid user");
		return token;

	}
	
	
	@PostMapping(value = "/create/user")
	public ResponseEntity createUser(@RequestBody AcconutCredencialVO data) {
		if (CheckIfParansIsNotNull(data)) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("invalid user");
		var token = authService.createUser(data);
		if (token == null) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("invalid user/create user");
		return token;
	
	}
// 
	private boolean CheckIfParansIsNotNull(AcconutCredencialVO data) {
		return data == null 
				|| data.getUsername() == null 
				|| data.getUsername().isBlank() 
				|| data.getPassword() == null
				|| data.getPassword().isBlank();
	}
	
 
}
