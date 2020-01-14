package blackout.appointment.controller;

import Blackout.shared.model.appoint.Appointment;
import Blackout.shared.model.appoint.AttendeeList;
import blackout.appointment.feignClients.UserClient;
import blackout.appointment.repository.AppointmentRepo;
import blackout.appointment.repository.AttendeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
import org.springframework.web.bind.annotation.*;

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

        return null;
    }

    @PostMapping("/appointment")
    public Appointment newAppointment(@RequestBody Appointment appointment)
    {


        OAuth2Authentication
        System.out.println(SecurityContextHolder.getContext().getAuthentication());
        String u_id = SecurityContextHolder.getContext().getAuthentication().getName();
        /*if(userClient.checkUser(u_id))
        {
            Appointment retApp = appointmentRepo.save(appointment);
            AttendeeList attendeeList = new AttendeeList(); attendeeList.setAt_id(u_id); attendeeList.setRole(1); attendeeList.setAp_id(retApp);
            attendeeRepo.save(attendeeList);
            retApp.getAttendeeLists().add(attendeeList);
            return appointmentRepo.save(retApp);
        }*/
        return null;
    }
}
