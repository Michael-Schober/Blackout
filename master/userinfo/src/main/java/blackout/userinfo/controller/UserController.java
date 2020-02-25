package blackout.userinfo.controller;

import Blackout.shared.model.user.User;
import blackout.userinfo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class UserController
{
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable String id)
    {
        if(userRepo.existsById(id))
        {
            return userRepo.findById(id).get();
        }
        return null;
    }

    @GetMapping("/user/check/{id}")
    public boolean checkUser(@PathVariable String id)
    {
        if(userRepo.existsById(id))
        {
            return true;
        }
        return false;
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user)
    {
        if(user.getU_id() != null && userRepo.existsById(user.getU_id()))
        {
            return userRepo.findById(user.getU_id()).get();
        }
        return userRepo.save(user);
    }

    @GetMapping("/user")
    public User getcurrentUser()
    {
        return userRepo.findById(SecurityContextHolder.getContext().getAuthentication().getName()).get();
    }
}
