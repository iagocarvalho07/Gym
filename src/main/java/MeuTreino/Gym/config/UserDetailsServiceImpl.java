package MeuTreino.Gym.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import MeuTreino.Gym.model.UserModel;
import MeuTreino.Gym.repositorys.UserRepository;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepository repository;

	public UserDetailsServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final UserModel usermodel = this.repository.findByUserName(username);
				if(usermodel == null) {
		            throw new UsernameNotFoundException("Unknown user "+ username);
		        }
		System.out.println(usermodel.getRoles().get(0));
		return User.withUsername(usermodel.getUsername())
				.password(usermodel.getPassword())
				.authorities(usermodel.getRoles().get(0))
//				.accountExpired(false)
//                .accountLocked(false)
//                .credentialsExpired(false)
//                .disabled(false)
                .build();
	}

}
