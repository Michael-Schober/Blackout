package blackout.appointment.controller;

import Blackout.shared.model.appoint.Appointment;
import Blackout.shared.model.appoint.Attendees;
import blackout.appointment.feignClients.UserClient;
import blackout.appointment.repository.AppointmentRepo;
import blackout.appointment.repository.AttendeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class AppointmentController
{
    @Autowired
    private UserClient userClient;
    @Autowired
    private AttendeeRepo attendeeRepo;
    @Autowired
    private AppointmentRepo appointmentRepo;

    @GetMapping("/appointment")
    public List<Appointment> getAll()
    {
        String u_id =SecurityContextHolder.getContext().getAuthentication().getName();

        return appointmentRepo.getApp(u_id);
    }

    @PutMapping("/appointment")
    public Appointment updateAppointment(@RequestBody Appointment appointment)
    {
        Appointment toUpdate = appointmentRepo.getOne(appointment.getAp_id());
        toUpdate.setTitle(appointment.getTitle());
        toUpdate.setDetails(appointment.getDetails());
        return appointmentRepo.save(toUpdate);
    }

    @PostMapping("/appointment")
    public Appointment newAppointment(@RequestBody Appointment appointment)
    {
        Jwt j = (Jwt)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String u_id = SecurityContextHolder.getContext().getAuthentication().getName();

        Appointment retApp = appointmentRepo.save(appointment);
        Attendees attendees = new Attendees(); attendees.setAt_id(u_id); attendees.setRole(1); attendees.setAp_id(retApp);
        attendeeRepo.save(attendees);
        return retApp;
    }
}
