package blackout.db.controller;

import Blackout.shared.model.Role;
import blackout.db.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/role")
public class RoleController
{
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/{id}")
    public Set<Role> getRoles(@PathVariable String id)
    {
        return userRepo.findById(id).get().roles;
    }
}
