package blackout.game.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User
{

    private Long id;

    private String username;

    private String password;

    private String authorities;

    private boolean accountExpired;

    private boolean accountLocked;

    private boolean disabled;
}