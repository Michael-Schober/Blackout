package oauth.auth;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;
import shared.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
@EntityScan("shared.model.Users")
public interface UserRepository extends JpaRepository<Users, Long>
{
    Users findByUsername(String username);
}
