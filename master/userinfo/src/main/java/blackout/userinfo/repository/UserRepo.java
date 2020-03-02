package blackout.userinfo.repository;


import Blackout.shared.model.user.User;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepo extends ReactiveCrudRepository<User, String>
{
    @Query("insert into user (u_id) values (:u_id)")
    void insertNewUser(String u_id);

}
