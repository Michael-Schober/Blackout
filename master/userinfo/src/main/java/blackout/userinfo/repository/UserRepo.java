package blackout.userinfo.repository;


import Blackout.shared.model.user.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepo extends ReactiveCrudRepository<User, String>
{

}
