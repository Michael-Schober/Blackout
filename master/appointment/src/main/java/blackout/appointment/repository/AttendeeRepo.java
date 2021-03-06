package blackout.appointment.repository;

import Blackout.shared.model.appoint.Attendees;
import Blackout.shared.model.appoint.AttendeesID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AttendeeRepo extends JpaRepository<Attendees, AttendeesID>
{

}
