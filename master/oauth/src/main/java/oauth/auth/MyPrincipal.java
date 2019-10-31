package oauth.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class MyPrincipal implements UserDetails
{
    private User user;


    public MyPrincipal(User user)
    {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !user.isAccountExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.isAccountLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !user.isAccountExpired();
    }

    @Override
    public boolean isEnabled() {
        return !user.isDisabled();
    }
}
