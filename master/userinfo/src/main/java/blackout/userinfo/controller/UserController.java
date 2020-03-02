package blackout.userinfo.controller;

import Blackout.shared.model.user.User;
import blackout.userinfo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin("*")
public class UserController
{
    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/user")
    public Flux<User> getcurrentUser(
            @RequestParam(value = "page", defaultValue = "0")long page,
            @RequestParam(value = "size", defaultValue = "1")long size)
    {
        return userRepo.findAll().skip(page*size).take(size);
    }

    @GetMapping(value = "/user/react")
    public Flux<User> getstream() {
        return userRepo.findAll();
    }

    @PostMapping(value = "/user")
    public Mono<User> create(@RequestBody User user)
    {
        userRepo.insertNewUser(user.getU_id());
        return userRepo.findById(user.getU_id());
    }
}
