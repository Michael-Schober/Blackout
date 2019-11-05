package blackout.db.repository;

import blackout.db.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
    public User getByUsername(String username);
}
