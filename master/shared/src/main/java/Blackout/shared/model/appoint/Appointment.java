package Blackout.shared.model.appoint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Appointment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ap_id;

    @Column
    private Date date;

    @Column
    private String title;

    @Column
    private String details;

    @OneToMany(mappedBy = "ap_id")
    private  List<AttendeeList> attendeeLists;
}
