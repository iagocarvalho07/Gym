package MeuTreino.Gym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class GymApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123456"));
	}

}
