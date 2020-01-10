package blackout.dbconnector.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class User
{
    @Id
    public int id;

    public String password;
    public String username;
    public String email;
}
