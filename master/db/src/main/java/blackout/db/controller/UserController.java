package blackout.db.controller;

import blackout.db.model.User;
import blackout.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController
{
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getYourUser(@PathVariable(name = "id") Long id)
    {
        return userRepository.findById(id).get();
    }

    @PostMapping("/user")
    public User addNewUser(@RequestBody User user)
    {
        user.setAccountExpired(false);
        user.setAccountLocked(false);
        user.setDisabled(false);
        return userRepository.save(user);
    }
}
