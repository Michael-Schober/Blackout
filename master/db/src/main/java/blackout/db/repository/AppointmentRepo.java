package blackout.db.repository;

import Blackout.shared.model.appoint.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<Appointment, Integer>
{

}
