package blackout.userinfo.controller;

import Blackout.shared.model.Appointment;
import blackout.userinfo.feignClients.AppointmentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class AppointmentController
{
    @Autowired
    AppointmentClient appointmentClient;

    @GetMapping("/app")
    public List<Appointment> getAll()
    {
        return appointmentClient.getAll();
    }
}
