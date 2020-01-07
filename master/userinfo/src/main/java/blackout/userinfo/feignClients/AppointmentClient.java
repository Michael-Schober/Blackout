package blackout.userinfo.feignClients;

import Blackout.shared.model.Appointment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "DB")
public interface AppointmentClient
{
    @GetMapping("/appointment")
    public List<Appointment> getAll();

    @PostMapping("/appointment")
    public Appointment createNew(@RequestBody Appointment appointment);

    @GetMapping("/appointment/{id}")
    public Appointment getById(@PathVariable int id);
}
