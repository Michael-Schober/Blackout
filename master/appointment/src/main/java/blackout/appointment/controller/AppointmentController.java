package blackout.appointment.controller;

import Blackout.shared.model.Appointment;
import blackout.appointment.feignClients.DBClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class AppointmentController
{
    @Autowired
    private DBClient dbClient;

    @GetMapping("/appointment")
    public List<Appointment> getAll()
    {
        return dbClient.getAll();
    }

    @PostMapping("/appointment")
    public Appointment newAppointment(@RequestBody Appointment appointment)
    {
        return dbClient.createNew(appointment);
    }
}
