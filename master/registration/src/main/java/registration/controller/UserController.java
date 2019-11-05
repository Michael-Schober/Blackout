package registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
}
