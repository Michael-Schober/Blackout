package blackout.db.repository;

import Blackout.shared.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String>
{

}
