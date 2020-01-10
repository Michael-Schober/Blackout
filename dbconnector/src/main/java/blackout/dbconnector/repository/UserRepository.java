package blackout.dbconnector.repository;

import blackout.dbconnector.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>
{

}
