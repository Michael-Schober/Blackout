package blackout.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Blackout.shared.model.*;

public interface AppointmentRepo extends JpaRepository<Appointment, Integer>
{

}
