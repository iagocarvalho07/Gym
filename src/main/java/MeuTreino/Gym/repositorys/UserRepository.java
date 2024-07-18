package MeuTreino.Gym.repositorys;



import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import MeuTreino.Gym.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
	UserModel findByUserName(String username);

}
