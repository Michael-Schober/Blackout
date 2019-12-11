package blackout.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Blackout.shared.model.OauthUser;

public interface UserRepository extends JpaRepository<OauthUser, Long>
{
    public OauthUser getByUsername(String username);
}
