package blackout.db.controller;

import Blackout.shared.model.user.User;
import blackout.db.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController
{

    @Autowired
    private UserRepo userRepo;

    @PostMapping("")
    public User newUser(@RequestBody User user)
    {
        return userRepo.save(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id)
    {
        if(userRepo.existsById(id))
        {
            return userRepo.findById(id).get();
        }
        User u = new User();
        u.u_id = id;
        return userRepo.save(u);

    }


}
