package registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import registration.model.User;

public interface UserRepository extends JpaRepository<User, Long>
{

}
