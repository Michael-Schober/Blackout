package blackout.userinfo.controller;

import Blackout.shared.model.Appointment;
import blackout.userinfo.feignClients.AppointmentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AppointmentController
{
    @Autowired
    AppointmentClient appointmentClient;

    @GetMapping("/app")
    public List<Appointment> getAll()
    {
        return appointmentClient.getAll();
    }

    @GetMapping("/app/{id}")
    public Appointment getById(@PathVariable int id)
    {
        return appointmentClient.getById(id);
    }
}
