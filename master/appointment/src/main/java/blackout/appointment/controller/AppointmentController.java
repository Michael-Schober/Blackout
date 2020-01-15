package blackout.appointment.controller;

import Blackout.shared.model.appoint.Appointment;
import Blackout.shared.model.appoint.AttendeeList;
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
            AttendeeList attendeeList = new AttendeeList(); attendeeList.setAt_id(u_id); attendeeList.setRole(1); attendeeList.setAp_id(retApp);
            attendeeRepo.save(attendeeList);
            if(retApp.getAttendeeLists() != null)
            {
                retApp.getAttendeeLists().add(attendeeList);
            }
            else
            {
                List<AttendeeList> newList= new ArrayList<AttendeeList>();
                newList.add(attendeeList);
                retApp.setAttendeeLists(newList);
            }
            return appointmentRepo.save(retApp);
        }
        return null;
    }
}
