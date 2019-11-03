package registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import registration.repository.UserRepository;
import registration.model.User;

@RestController
public class UserController
{
    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    public User register(@RequestBody User newUser)
    {
        newUser.setAccountExpired(false);
        newUser.setAccountLocked(false);
        newUser.setAuthorities("");
        newUser.setDisabled(false);
        newUser.setPassword(new BCryptPasswordEncoder().encode(newUser.getPassword()));
        return userRepository.save(newUser);
    }



    
}
