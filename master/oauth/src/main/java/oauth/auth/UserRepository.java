package oauth.auth;

import org.springframework.stereotype.Repository;
import Blackout.shared.model.OauthUser;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<OauthUser, Long>
{
    OauthUser findByUsername(String username);
}
