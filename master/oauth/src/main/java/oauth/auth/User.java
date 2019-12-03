package oauth.auth;
import shared.model.Users;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "oauth2", name = "users")
public class User extends Users {

}
