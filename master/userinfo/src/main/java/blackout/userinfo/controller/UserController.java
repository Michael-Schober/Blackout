package blackout.userinfo.controller;

import Blackout.shared.model.User;
import blackout.userinfo.feignClients.DBClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class UserController
{
    @Autowired
    private DBClient dbClient;

    @GetMapping("/user")
    public User getUser()
    {
        return dbClient.getUserById(SecurityContextHolder.getContextHolderStrategy().getContext().getAuthentication().getName());
    }

    @PostMapping("/user")
    public User newUser(@RequestBody User user)
    {
        return dbClient.newUser(user);
    }
}
