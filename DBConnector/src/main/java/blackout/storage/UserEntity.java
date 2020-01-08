package blackout.storage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@NamedQueries({
        @NamedQuery(name="getUserByUsername",query = "select u from UserEntity u where u.username = :username"),
        @NamedQuery(name="getUserByEmail",query = "select  u from UserEntity u where u.email = :email"),
        @NamedQuery(name="getUserCount",query = "select count(u) from UserEntity u"),
        @NamedQuery(name = "getAllUsers",query = "select u from UserEntity u"),
        @NamedQuery(name = "searchForUser",query = "select  u from UserEntity u where " + "(lower(u.username) like :search or u.email like :earch) order by u.username"),
})


@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity
{
    @Id
    private String id;

    private String username;
    private String email;
    private String password;
    private String phone;
}
