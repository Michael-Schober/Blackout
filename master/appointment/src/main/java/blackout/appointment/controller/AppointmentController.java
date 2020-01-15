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

    @PostMapping("/appointment")
    public Appointment newAppointment(@RequestBody Appointment appointment)
    {
        Jwt j = (Jwt)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String u_id = SecurityContextHolder.getContext().getAuthentication().getName();
        if(userClient.checkUser(u_id, "Bearer " + j.getTokenValue()))
        {
            Appointment retApp = appointmentRepo.save(appointment);
            Attendees Attendees = new Attendees(); Attendees.setAt_id(u_id); Attendees.setRole(1); Attendees.setAp_id(retApp);
            attendeeRepo.save(Attendees);
            if(retApp.getAttendees() != null)
            {
                retApp.getAttendees().add(Attendees);
            }
            else
            {
                List<Attendees> newList= new ArrayList<Attendees>();
                newList.add(Attendees);
                retApp.setAttendees(newList);
            }
            return appointmentRepo.save(retApp);
        }
        return null;
    }
}
