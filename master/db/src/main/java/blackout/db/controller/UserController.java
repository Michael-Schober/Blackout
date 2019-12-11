package blackout.db.controller;

import Blackout.shared.model.OauthUser;
import blackout.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController
{
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public OauthUser getYourUser(@PathVariable(name = "id") Long id)
    {
        return userRepository.findById(id).get();
    }

    @PostMapping("/user")
    public OauthUser addNewUser(@RequestBody OauthUser user)
    {
        user.setAccountExpired(false);
        user.setAccountLocked(false);
        user.setDisabled(false);
        return userRepository.save(user);
    }
}
