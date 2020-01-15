package blackout.appointment.repository;

import Blackout.shared.model.appoint.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentRepo extends JpaRepository<Appointment, Integer>
{
    @Query("SELECT att.ap_id, app.date, app.details, app.title FROM Appointment as app \n" +
            "inner join AttendeeList as att \n" +
            "on app.ap_id = att.ap_id \n" +
            "where att.at_id = ?1")
    public List<Appointment> getApp(String u_id);
}
