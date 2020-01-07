package blackout.db.controller;

import Blackout.shared.model.Appointment;
import blackout.db.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppointmentController
{
    @Autowired
    AppointmentRepo appointmentRepo;

    @GetMapping("/appointment")
    public List<Appointment> getAll()
    {
        return appointmentRepo.findAll();
    }

    @PostMapping("/appointment")
    public Appointment createNew(@RequestBody Appointment appointment)
    {
        return appointmentRepo.save(appointment);
    }
}
