package blackout.userinfo.controller;

import Blackout.shared.model.user.User;
import blackout.userinfo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin("*")
public class UserController
{
    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/user", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<User> getUser()
    {
        return ReactiveSecurityContextHolder.getContext()
                    .map(SecurityContext::getAuthentication)
                    .map(Authentication::getName)
                    .flatMap(this::getCurrentUser);
    }

    private Mono<User> getCurrentUser(String id)
    {
        return userRepo.findById(id);
    }

    @PostMapping(value = "/user")
    public Mono<User> create(@RequestBody User user)
    {
        userRepo.insertNewUser(user.getU_id());
        return userRepo.findById(user.getU_id());
    }
}
