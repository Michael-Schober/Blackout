package registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import registration.feign_clients.UserClient;
import registration.model.User;

@RestController
public class UserController
{
    @Autowired
    private UserClient userClient;

    @GetMapping("/register/me")
    public User getUser()
    {
        return userClient.getUser(1L);
    }

    @PostMapping("register")
    public User saveNewUser(@RequestBody User user)
    {
        user.setPassword(bCryptPasswordEncoder().encode(user.getPassword()));
        return userClient.SaveUser(user);
    }



    private BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
