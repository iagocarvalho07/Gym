package MeuTreino.Gym.execpetions;


import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidJwtAutenticationException2 extends AuthenticationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidJwtAutenticationException2(String ex) {
		super(ex);
	}

}
