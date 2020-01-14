package Blackout.shared.model.appoint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity @IdClass(AttendeesID.class)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttendeeList
{
    @Id
    public String at_id;

    @Id
    public int role;

    @Id
    @ManyToOne
    @JoinColumn(name = "ap_id")
    public Appointment ap_id;
}
