package blackout.db.controller;

import Blackout.shared.model.Appointment;
import blackout.db.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController
{
    @Autowired
    AppointmentRepo appointmentRepo;

    @GetMapping("")
    public List<Appointment> getAll()
    {
        return appointmentRepo.findAll();
    }

    @GetMapping("/{id}")
    public Appointment getById(@PathVariable int id) { return appointmentRepo.findById(id).get(); }

    @PostMapping("")
    public Appointment createNew(@RequestBody Appointment appointment)
    {
        return appointmentRepo.save(appointment);
    }
}
