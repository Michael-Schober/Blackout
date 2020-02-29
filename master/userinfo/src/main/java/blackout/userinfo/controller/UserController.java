package blackout.userinfo.controller;

import Blackout.shared.model.user.User;
import blackout.userinfo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import org.springframework.http.MediaType;

@RestController
public class UserController
{
    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<User> getcurrentUser()
    {
        return userRepo.findAll();
    }
}
