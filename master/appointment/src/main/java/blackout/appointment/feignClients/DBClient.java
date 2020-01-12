package blackout.appointment.feignClients;

import Blackout.shared.model.Appointment;
import Blackout.shared.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("DB")
public interface DBClient
{
    @GetMapping("/appointment")
    public List<Appointment> getAll();

    @PostMapping("/appointment")
    public Appointment createNew(@RequestBody Appointment appointment);

    @GetMapping("/appointment/{id}")
    public Appointment getById(@PathVariable int id);


    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable String id);

    @PostMapping("/user")
    public User newUser(@RequestBody User user);
}
