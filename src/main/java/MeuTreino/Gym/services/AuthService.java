package MeuTreino.Gym.services;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import MeuTreino.Gym.dataVo.AcconutCredencialVO;
import MeuTreino.Gym.dataVo.TokenVo;
import MeuTreino.Gym.model.UserModel;
import MeuTreino.Gym.repositorys.UserRepository;
import MeuTreino.Gym.tokenJwt.JWTTokenProvider;



@Service
public class AuthService {

	@Autowired
	private JWTTokenProvider jwtTokenProvider;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;

	public ResponseEntity signin(AcconutCredencialVO data) {
		try {
			var username = data.getUsername();
			var password = data.getPassword();
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			var user = userRepository.findByUserName(username);
			var tokenResponse = new TokenVo();
			if (user != null) {
				tokenResponse = jwtTokenProvider.createAccessToken(username, user.getRoles());
			} else {
				throw new UsernameNotFoundException("Username" + username + " not found!");
			}
			return ResponseEntity.ok(tokenResponse);
		} catch (Exception e) {
			throw new BadCredentialsException("Invalid Username/ password supplied!");
		}
	}
	
	
	public ResponseEntity createUser(AcconutCredencialVO data) {
		try {
			var username = data.getUsername();
			var password = data.getPassword();
			UserModel usermodel = new UserModel();
			String bCryptPasswordEncoder = new BCryptPasswordEncoder().encode(password);
			UserModel user = (this.userRepository.findByUserName(username));
			if (user == null) {
				usermodel.setUserName(username);
				usermodel.setPassword(bCryptPasswordEncoder);
				userRepository.save(usermodel);
			}
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			var tokenResponse = new TokenVo();
			tokenResponse = jwtTokenProvider.createAccessToken(username, usermodel.getRoles());
			
			return ResponseEntity.ok(tokenResponse);
		} catch (Exception e) {
			throw new BadCredentialsException("erro ao criar usauario! " + e);
		}
		
	}
	
	
	
	
	
}