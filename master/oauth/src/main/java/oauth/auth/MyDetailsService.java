package oauth.auth;

import Blackout.shared.model.OauthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyDetailsService implements UserDetailsService
{
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException
    {
        OauthUser user = userRepository.findByUsername(s);
        if(user == null)
        {
            throw new UsernameNotFoundException("User Not Found");
        }
        else
        {
            return new MyPrincipal(user);
        }

    }


}
