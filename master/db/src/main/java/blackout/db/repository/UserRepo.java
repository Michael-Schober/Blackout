package blackout.db.repository;

import Blackout.shared.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String>
{

}
